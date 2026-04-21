package com.joker.spzx.manager.helper;

import com.joker.spzx.model.entity.system.SysMenu;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class MenuHelper {

    /**
     * 使用递归方法建菜单
     *
     * @param sysMenuList
     * @return
     */
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> trees = Lists.newArrayList();
        sysMenuList.stream().forEach(sysMenu -> {
            if (sysMenu.getParentId().longValue() == 0) {
                trees.add(findChildren(sysMenu, sysMenuList));
            }
        });
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        sysMenu.setChildren(Lists.newArrayList());
        treeNodes.stream().forEach(treeNode -> {
            if (sysMenu.getId().longValue() == treeNode.getParentId().longValue()) {
                if (sysMenu.getChildren() == null) {
                    sysMenu.setChildren(Lists.newArrayList());
                }
                sysMenu.getChildren().add(findChildren(treeNode, treeNodes));
            }
        });
        return sysMenu;
    }
}
