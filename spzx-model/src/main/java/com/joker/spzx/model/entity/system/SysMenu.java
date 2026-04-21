package com.joker.spzx.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.joker.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@TableName("sys_menu")
@Schema(name = "SysMenu", description = "菜单表")
@Data
public class SysMenu extends BaseEntity {

    @Schema(description = "所属上级")
    @TableField("parent_id")
    private Long parentId;

    @Schema(description = "菜单标题")
    @TableField("title")
    private String title;

    @Schema(description = "组件名称")
    @TableField("component")
    private String component;

    @Schema(description = "排序")
    @TableField("sort_value")
    private Integer sortValue;

    @Schema(description = "状态(0:禁止,1:正常)")
    @TableField("status")
    private Integer status;

    // 下级列表
    @Schema(description = "子节点")
    @TableField(exist = false)
    private List<SysMenu> children;

}