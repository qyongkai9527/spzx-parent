package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.SysUserScheduleTaskMapper;
import com.joker.spzx.manager.service.SysUserScheduleTaskService;
import com.joker.spzx.model.entity.user.SysUserSchedule;
import com.joker.spzx.model.entity.user.SysUserScheduleTask;
import com.joker.spzx.utils.AuthContextUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 日程任务表 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-05-20 11:34:20
 */
@Service
public class SysUserScheduleTaskServiceImpl extends ServiceImpl<SysUserScheduleTaskMapper, SysUserScheduleTask> implements SysUserScheduleTaskService {

    @Override
    public List<SysUserScheduleTask> pageList(Long schedule) {
        LambdaQueryWrapper<SysUserScheduleTask> queryWrapper = lambdaQuery().getWrapper()
                .eq(SysUserScheduleTask::getScheduleId, schedule)
                .eq(SysUserScheduleTask::getStatus, 0)
                .orderByAsc(SysUserScheduleTask::getSort);

        return list(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveData(SysUserScheduleTask sysUserScheduleTask) {
        sysUserScheduleTask.setCreateBy(AuthContextUtil.getUser().getId());
        sysUserScheduleTask.setCreateTime(LocalDateTime.now());
        sysUserScheduleTask.setStatus(0);
        this.baseMapper.insert(sysUserScheduleTask);
        this.updateCompleteValue(sysUserScheduleTask.getScheduleId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateData(SysUserScheduleTask sysUserScheduleTask) {
        this.updateById(sysUserScheduleTask);
        Long scheduleId = sysUserScheduleTask.getScheduleId();
        this.updateCompleteValue(scheduleId);
    }

    private void updateCompleteValue(Long scheduleId) {
        LambdaQueryWrapper<SysUserScheduleTask> eq = lambdaQuery().getWrapper().eq(SysUserScheduleTask::getScheduleId, scheduleId)
                .eq(SysUserScheduleTask::getStatus, 0);
        List<SysUserScheduleTask> list = list(eq);
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            int completeCount = list.stream().filter(item -> item.getIsComplete() == 1).collect(Collectors.toList()).size();
            SysUserSchedule sysUserSchedule = new SysUserSchedule();
            sysUserSchedule.setId(scheduleId);
            sysUserSchedule.setTaskCount(size);
            sysUserSchedule.setCompleteCount(completeCount);
            sysUserSchedule.updateById();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeData(Long id) {
        SysUserScheduleTask sysUserScheduleTask = new SysUserScheduleTask();
        sysUserScheduleTask.setId(id);
        sysUserScheduleTask.setStatus(1);
        this.baseMapper.updateById(sysUserScheduleTask);
        SysUserScheduleTask byId = this.getById(id);
        if (Objects.nonNull(byId))
            this.updateCompleteValue(byId.getScheduleId());
    }
}
