package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.joker.spzx.manager.mapper.SysRoleMenuMapper;
import com.joker.spzx.manager.service.SysMenuService;
import com.joker.spzx.manager.service.SysRoleMenuService;
import com.joker.spzx.model.dto.system.AssginMenuDto;
import com.joker.spzx.model.entity.system.SysMenu;
import com.joker.spzx.model.entity.system.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {


    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public Map<String, Object> findSysRoleMenuByRoleId(Long roleId) {
        List<SysMenu> treeNodes = sysMenuService.getTreeNodes();
        LambdaQueryWrapper<SysRoleMenu> eq = lambdaQuery().getWrapper()
                .eq(SysRoleMenu::getRoleId, roleId)
                .eq(SysRoleMenu::getIsDeleted, 0)
                .eq(SysRoleMenu::getIsHalf, 0);
        List<Long> roleMenuIds = this.baseMapper.selectList(eq).stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());

        Map<String, Object> map = Maps.newHashMap();
        map.put("sysMenuList", treeNodes);
        map.put("roleMenuIds", roleMenuIds);
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAssign(AssginMenuDto assginMenuDto) {
        LambdaQueryWrapper<SysRoleMenu> eq = lambdaQuery().getWrapper()
                .eq(SysRoleMenu::getRoleId, assginMenuDto.getRoleId());
        this.remove(eq);

        List<SysRoleMenu> list = Lists.newArrayList();
        assginMenuDto.getMenuIdList().stream().forEach(menuMap -> {

            List<Integer> values = Lists.newArrayList(menuMap.values());
            SysRoleMenu sysRoleMenu = new SysRoleMenu() {{
                setRoleId(assginMenuDto.getRoleId());
                setMenuId(values.get(0).longValue());
                setIsHalf(values.get(1));
                setIsDeleted(0);
                setCreateTime(LocalDateTime.now());
            }};
            list.add(sysRoleMenu);

        });

        this.baseMapper.insert(list);
    }
}
