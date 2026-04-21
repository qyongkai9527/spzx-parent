package com.joker.spzx.manager.controller;

import com.joker.spzx.manager.service.SysMenuService;
import com.joker.spzx.model.entity.system.SysMenu;
import com.joker.spzx.model.vo.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@RestController
@Tag(description = "菜单相关接口", name = "菜单相关接口")
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/findNodes")
    @Operation(summary = "树形菜单列表")
    public Result<List<SysMenu>> getNodes() {
        List<SysMenu> list = sysMenuService.getTreeNodes();
        return Result.build(list);
    }

    @PostMapping("/save")
    @Operation(summary = "新增菜单")
    public Result<String> saveMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.saveData(sysMenu);
        return Result.build(null);
    }


    @PutMapping("/update")
    @Operation(summary = "编辑菜单")
    public Result<String> updateData(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateData(sysMenu);
        return Result.build(null);
    }


    @DeleteMapping("/removeById/{id}")
    @Operation(summary = "编辑菜单")
    public Result<String> deleteData(@PathVariable Long id) {
        sysMenuService.deleteData(id);
        return Result.build(null);
    }
}
