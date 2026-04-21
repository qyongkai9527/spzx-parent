package com.joker.spzx.manager.controller;

import com.joker.spzx.manager.service.SysRoleMenuService;
import com.joker.spzx.model.dto.system.AssginMenuDto;
import com.joker.spzx.model.vo.common.Result;
import com.joker.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 角色菜单 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@RestController
@Tag(description = "角色菜单接口", name = "角色菜单接口")
@RequestMapping("/admin/system/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Operation(summary = "根据角色id查询树形菜单")
    @GetMapping(value = "/findSysRoleMenuByRoleId/{roleId}")
    public Result<Map<String, Object>> findSysRoleMenuByRoleId(@PathVariable Long roleId) {
        Map<String, Object> map = sysRoleMenuService.findSysRoleMenuByRoleId(roleId);
        return Result.build(map);
    }

    @Operation(summary = "角色分配菜单")
    @PostMapping(value = "/doAssign")
    public Result<String> doAssign(@RequestBody AssginMenuDto assginMenuDto) {
        sysRoleMenuService.doAssign(assginMenuDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

}
