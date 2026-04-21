package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.entity.user.SysUserScheduleTask;

import java.util.List;

/**
 * <p>
 * 日程任务表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-05-20 11:34:20
 */
public interface SysUserScheduleTaskService extends IService<SysUserScheduleTask> {

    List<SysUserScheduleTask> pageList(Long schedule);

    void saveData(SysUserScheduleTask sysUserScheduleTask);

    void updateData(SysUserScheduleTask sysUserScheduleTask);

    void removeData(Long id);
}
