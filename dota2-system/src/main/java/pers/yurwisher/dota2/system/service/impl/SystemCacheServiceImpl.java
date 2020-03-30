package pers.yurwisher.dota2.system.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import pers.yurwisher.dota2.common.base.ICacheService;
import pers.yurwisher.dota2.system.pojo.qo.SystemCacheQo;
import pers.yurwisher.dota2.system.pojo.to.SystemCacheTo;
import pers.yurwisher.dota2.system.service.ISystemCacheService;
import pers.yurwisher.wisp.constants.SymbolConstants;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.utils.PageWisp;
import pers.yurwisher.wisp.utils.StringUtils;
import pers.yurwisher.wisp.wrapper.PageR;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author yq
 * @date 2019/08/14 15:52
 * @description 系统缓存配置
 * @since V1.0.0
 */
@Service
public class SystemCacheServiceImpl implements ISystemCacheService {

    private ICacheService cacheService;

    public SystemCacheServiceImpl(ICacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public PageR<SystemCacheTo> list(SystemCacheQo qo) {
        String key = qo.getKey();
        if (StringUtils.isNotEmpty(key)) {
            key = SymbolConstants.ASTERISK + key + SymbolConstants.ASTERISK;
        } else {
            key = SymbolConstants.ASTERISK;
        }
        Set<String> keySet = cacheService.keys(key);
        if(CollectionUtils.isEmpty(keySet)){
            return new PageR<>();
        }
        List<String> keys = new ArrayList<>(cacheService.keys(key));
        int total = CollectionUtils.size(keySet);
        PageWisp<SystemCacheTo> wisp = new PageWisp<>();
        return wisp.get((long)total,qo.getSize(),qo.getPage(),(from, end) ->{
            List<SystemCacheTo> list = new ArrayList<>();
            for (int i = from.intValue(), endIndex = end.intValue(); i < endIndex; i++) {
                String currentKey = keys.get(i);
                list.add(new SystemCacheTo(currentKey, JSON.toJSONString(cacheService.get(currentKey))));
            }
            return list;
        });
    }

    @Override
    public void delete(String key) {
        cacheService.delete(key);
    }

    @Override
    public void flushDb() {
        cacheService.flushDb();
    }


}
