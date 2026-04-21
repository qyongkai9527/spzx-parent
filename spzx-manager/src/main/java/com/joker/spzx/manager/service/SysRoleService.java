package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.dto.system.SysRoleDto;
import com.joker.spzx.model.entity.system.SysRole;

import java.util.Map;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
public interface SysRoleService extends IService<SysRole> {

    IPage<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize);

    void saveSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);

    void deleteSysRole(Long id);

    Map<String, Object> getList(Long sysRoleDto);

}
