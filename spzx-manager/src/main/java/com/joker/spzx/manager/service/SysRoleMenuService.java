package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.dto.system.AssginMenuDto;
import com.joker.spzx.model.entity.system.SysRoleMenu;

import java.util.Map;

/**
 * <p>
 * 角色菜单 服务类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    void doAssign(AssginMenuDto assginMenuDto);
}
