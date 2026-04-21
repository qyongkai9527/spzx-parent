package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.dto.system.UserScheduleDtp;
import com.joker.spzx.model.entity.user.SysUserSchedule;

/**
 * <p>
 * 每天日程安排表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-05-20 11:34:20
 */
public interface SysUserScheduleService extends IService<SysUserSchedule> {

    void saveData(SysUserSchedule sysUserSchedule);

    IPage<SysUserSchedule> pageList(UserScheduleDtp userScheduleDtp);
}
