package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.dto.system.AssginRoleDto;
import com.joker.spzx.model.dto.system.LoginDto;
import com.joker.spzx.model.dto.system.SysUserDto;
import com.joker.spzx.model.entity.system.SysUser;
import com.joker.spzx.model.vo.system.LoginVo;
import com.joker.spzx.model.vo.system.ValidateCodeVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
public interface SysUserService extends IService<SysUser> {

    LoginVo login(LoginDto loginDto);

    ValidateCodeVo genVarifyCode();

    SysUser getUserInfo(String token);

    void logout(String token);

    IPage<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteSysUser(Long id);

    void assignRole(AssginRoleDto assginRoleDto);
}
