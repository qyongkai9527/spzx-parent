package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.entity.system.SysMenu;
import com.joker.spzx.model.vo.system.SysMenuVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getTreeNodes();

    void saveData(SysMenu sysMenu);

    void updateData(SysMenu sysMenu);

    void deleteData(Long id);

    List<SysMenuVo> findUserMenuList();

}
