package pers.yurwisher.dota2.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import pers.yurwisher.dota2.common.base.ICacheService;
import pers.yurwisher.dota2.common.base.IUploadService;
import pers.yurwisher.dota2.common.base.IUserInfoService;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.common.constant.cache.SystemCacheConstant;
import pers.yurwisher.dota2.common.constant.cache.ThirdCacheConstant;
import pers.yurwisher.dota2.common.enums.tip.ThirdCustomTipEnum;
import pers.yurwisher.dota2.common.exception.ThirdException;
import pers.yurwisher.dota2.common.wrapper.CustomUserInfoDetail;
import pers.yurwisher.dota2.common.wrapper.TokenPlus;
import pers.yurwisher.dota2.third.MessageSender;
import pers.yurwisher.earthshaker.service.IQiniuService;
import pers.yurwisher.token.ITokenService;
import pers.yurwisher.token.TokenHelper;
import pers.yurwisher.token.impl.TokenServiceImpl;
import pers.yurwisher.wisp.utils.StringUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author yq
 * @date 2019/07/15 14:11
 * @description 第三方的配置
 * @since V1.0.0
 */
@Configuration
public class ThirdConfig {

    @Bean
    public ITokenService<TokenPlus> tokenService(TokenHelper tokenHelper){
        return new TokenServiceImpl<>(tokenHelper);
    }

    @Bean
    public ICacheService cacheService(RedisTemplate<String, Object> redisTemplate){
        return new ICacheService() {
            @Override
            public void put(String key, Object value) {
                redisTemplate.opsForValue().set(key,value);
            }

            @Override
            public void put(String key, Object value, long times, TimeUnit unit) {
                redisTemplate.opsForValue().set(key, value, times, unit);
            }

            @Override
            public void put(String hash, String key, Object value) {
                redisTemplate.opsForHash().put(hash,key,value);
            }

            @Override
            public Object get(String key) {
                return redisTemplate.opsForValue().get(key);
            }

            @Override
            public Object get(String hash, String key) {
                return redisTemplate.opsForHash().get(hash,key);
            }

            @Override
            public void delete(String key) {
                redisTemplate.delete(key);
            }

            @Override
            public void delete(String hash, String key) {
                redisTemplate.opsForHash().delete(hash,key);
            }

            @Override
            public Set<String> keys(String pattern) {
                return redisTemplate.keys(pattern);
            }

            @Override
            public Long increment(String key, long value) {
                return redisTemplate.opsForValue().increment(key,value);
            }

            @Override
            public Boolean expire(String key, long timeout, TimeUnit unit) {
                return redisTemplate.expire(key, timeout, unit);
            }

            @Override
            public void flushDb() {
                redisTemplate.getConnectionFactory().getConnection().flushDb();
            }
        };
    }

    /**
     * 自定义文件上传
     */
    @Bean
    public IUploadService uploadService(IQiniuService qiniuService){
        return stream -> {
            String returnBody = qiniuService.upload(stream);
            if(StringUtils.isNotEmpty(returnBody)){
                return JSON.parseObject(returnBody).getString("fileUrl");
            }else{
                throw new ThirdException(ThirdCustomTipEnum.UPLOAD_FILE_FAIL);
            }
        };
    }

    /**
     * 自定义短信发送
     */
    @Bean
    public MessageSender messageSender(){
        return  (String content, String... phones) ->{

        };
    }

    /**
     * 自定义用户信息
     */
    @Bean
    public IUserInfoService userInfoService(){
        return userId -> {
            CustomUserInfoDetail detail = new CustomUserInfoDetail();
            detail.setAvatar("");
            detail.setNickName("");
            return detail;
        };
    }


    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory,Map<String,Integer> cacheExpireConfigMap) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                // 默认策略，未配置的 key 会使用这个, 默认过期时间 8 小时
                this.getRedisCacheConfigurationWithTtl(8 * 60 * 60),
                // 指定 key 策略
                this.getRedisCacheConfigurationMap(cacheExpireConfigMap)
        );
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // set key serializer
        StringRedisSerializer serializer = new StringRedisSerializer();
        // 设置key序列化类，否则key前面会多了一些乱码
        template.setKeySerializer(serializer);
        template.setHashKeySerializer(serializer);

        // fastjson serializer
        GenericFastJsonRedisSerializer fastSerializer = new GenericFastJsonRedisSerializer();
        template.setValueSerializer(fastSerializer);
        template.setHashValueSerializer(fastSerializer);
        // 如果 KeySerializer 或者 ValueSerializer 没有配置，则对应的 KeySerializer、ValueSerializer 才使用这个 Serializer
        template.setDefaultSerializer(fastSerializer);

        // factory
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public KeyGenerator defaultKeyGenerator(){
        return  (target,method,params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName())
                    .append(method.getName());
            if (params != null && params.length > 0){
                for (Object obj : params) {
                    if(obj != null){
                        sb.append(obj.toString());
                    }
                }
            }
            return sb.toString();
        };
    }


    @Bean
    public Map<String,Integer> cacheExpireConfigMap(){
        Map<String,Integer> cacheExpireConfigMap = new HashMap<>(10);
        //永不过期
        cacheExpireConfigMap.put(RBACCacheConstant.NEVER_EXPIRE_CACHE, -1);
        //用户菜单树 一周
        cacheExpireConfigMap.put(RBACCacheConstant.USER_MENU_TREE, 7 * 24 * 60 * 60);
        //RBAC下拉框 永久
        cacheExpireConfigMap.put(RBACCacheConstant.SELECT, -1);
        //部门职位 一天
        cacheExpireConfigMap.put(RBACCacheConstant.DEPARTMENT_JOB, 24 * 60 * 60);
        //用户自定义信息 一周
        cacheExpireConfigMap.put(RBACCacheConstant.CUSTOM_USER_INFO,7 * 24 * 60 * 60);
        //用户角色 一周
        cacheExpireConfigMap.put(RBACCacheConstant.USER_ROLE_CODE, 7 * 24 * 60 * 60);
        //图片验证码 5分钟过期
        cacheExpireConfigMap.put(RBACCacheConstant.VERIFY_CODE, 5 * 60);
        //找回密码短信验证码验证码 5分钟
        cacheExpireConfigMap.put(RBACCacheConstant.RETRIEVE_PASSWORD_PHONE_CODE, 5 * 60);
        //找回密码操作有效期 16分钟
        cacheExpireConfigMap.put(RBACCacheConstant.RETRIEVE_PASSWORD_PERIOD_OF_VALIDITY, 16 * 60);
        //注册短信验证码  5分钟
        cacheExpireConfigMap.put(RBACCacheConstant.REGISTER_PHONE_CODE, 5 * 60);

        //字典下拉框 15天
        cacheExpireConfigMap.put(SystemCacheConstant.DICT_SELECT, 15 * 24 * 60 * 60);
        //消息模版类型编码-模版映射 15天
        cacheExpireConfigMap.put(SystemCacheConstant.MESSAGE_TEMPLATE_TYPE_CODE_MESSAGE_TEMPLATE,15 * 24 * 60 * 60);
        //系统配置编码值映射 10天
        cacheExpireConfigMap.put(SystemCacheConstant.SYSTEM_CONFIG_CODE_VALUE,10 * 24 * 60 * 60);
        //门户信息配置 永久
        cacheExpireConfigMap.put(SystemCacheConstant.ENTERPRISE_PORTAL_INFO,-1);

        //手机短信推送限制 10分钟
        cacheExpireConfigMap.put(ThirdCacheConstant.PHONE_SEND_MESSAGE_LIMIT,10 * 60);
        return cacheExpireConfigMap;
    }

    private Map<String,RedisCacheConfiguration> getRedisCacheConfigurationMap(Map<String,Integer> cacheExpireConfigMap){
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>(cacheExpireConfigMap.size());
        cacheExpireConfigMap.forEach((s,time) ->
            redisCacheConfigurationMap.put(s,this.getRedisCacheConfigurationWithTtl(time))
        );
        return redisCacheConfigurationMap;
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        GenericFastJsonRedisSerializer fastSerializer = new GenericFastJsonRedisSerializer();
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(fastSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));
        return redisCacheConfiguration;
    }
}
