package pers.yurwisher.dota2.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.system.entity.StatusLog;
import pers.yurwisher.dota2.system.mapper.StatusLogMapper;
import pers.yurwisher.dota2.system.pojo.qo.StatusLogQo;
import pers.yurwisher.dota2.system.pojo.to.StatusLogTo;
import pers.yurwisher.dota2.system.service.IStatusLogService;
import pers.yurwisher.wisp.wrapper.PageR;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-11-11 22:29:20
 * @description 状态日志
 * @since V1.0.0
 */
@Service
public class StatusLogServiceImpl extends BaseServiceImpl<StatusLogMapper,StatusLog> implements IStatusLogService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Long entityId, Class clazz, String status, String remark) {
        StatusLog log = new StatusLog();
        log.setEntityId(entityId);
        log.setEntityClassName(clazz.getSimpleName());
        log.setStatus(status);
        log.setRemark(remark);
        log.setChangeDate(LocalDateTime.now());
        log.setOperatorId(JWTUser.current().getId());
        baseMapper.insert(log);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Long entityId, Class clazz, String status) {
        this.create(entityId,clazz,status,null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<StatusLogTo> list(StatusLogQo qo) {
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }
}
