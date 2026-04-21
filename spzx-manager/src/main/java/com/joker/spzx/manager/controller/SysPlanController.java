package com.joker.spzx.manager.controller;

import com.joker.spzx.manager.service.SysPlanService;
import com.joker.spzx.model.entity.oper.MallProduct;
import com.joker.spzx.model.entity.user.SysPlan;
import com.joker.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 推广计划表 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-05-21 17:06:21
 */
@RestController
@RequestMapping("/admin/sys/plan")
public class SysPlanController {

    @Autowired
    private SysPlanService sysPlanService;

    @GetMapping("/list")
    public Result<List<SysPlan>> list(@RequestParam Integer type) {
        List<SysPlan> sysPlanServiceList = sysPlanService.getList(type);
        return Result.build(sysPlanServiceList);
    }

    @PostMapping("/save")
    public Result<List<SysPlan>> list(@RequestBody SysPlan type) {
        sysPlanService.saveData(type);
        return Result.build(null);
    }

    @GetMapping("/linkProducts")
    public Result<List<MallProduct>> list(@RequestParam Long planId) {
        List<MallProduct> mallProducts = sysPlanService.getLinkedProductList(planId);
        return Result.build(mallProducts);
    }

}
