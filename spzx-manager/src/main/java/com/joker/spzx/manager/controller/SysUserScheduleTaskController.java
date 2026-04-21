package com.joker.spzx.manager.controller;

import com.joker.spzx.manager.service.SysUserScheduleTaskService;
import com.joker.spzx.model.entity.user.SysUserScheduleTask;
import com.joker.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 日程任务表 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-05-20 11:34:20
 */
@RestController
@RequestMapping("/admin/sys/userScheduleTask")
public class SysUserScheduleTaskController {

    @Autowired
    private SysUserScheduleTaskService sysUserScheduleTaskService;

    @GetMapping("/list")
    public Result<List<SysUserScheduleTask>> pageList(Long scheduleId) {
        List<SysUserScheduleTask> page = sysUserScheduleTaskService.pageList(scheduleId);
        return Result.build(page);
    }

    @PostMapping("/save")
    public Result<String> save(@RequestBody SysUserScheduleTask sysUserScheduleTask) {
        sysUserScheduleTaskService.saveData(sysUserScheduleTask);
        return Result.build(null);
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody SysUserScheduleTask sysUserScheduleTask) {
        sysUserScheduleTaskService.updateData(sysUserScheduleTask);
        return Result.build(null);
    }

    @DeleteMapping("/delete")
    public Result<String> update(@RequestParam Long id) {
        sysUserScheduleTaskService.removeData(id);
        return Result.build(null);
    }

}
