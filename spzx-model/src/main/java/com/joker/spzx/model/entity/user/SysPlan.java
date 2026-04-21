package com.joker.spzx.model.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 推广计划表
 * </p>
 *
 * @author joker
 * @since 2025-05-21 17:06:21
 */
@Getter
@Setter
@TableName("sys_plan")
@Schema(name = "SysPlan", description = "推广计划表")
public class SysPlan extends Model<SysPlan> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "1：ztch2：ylmf")
    @TableField("type")
    private Integer type;

    @Schema(description = "计划名称")
    @TableField("plan_title")
    private String planTitle;

    @Schema(description = "出价方式")
    @TableField("plan_way")
    private Integer planWay;

    @Schema(description = "计划类型")
    @TableField("plan_type")
    private Integer planType;

    @Schema(description = "商品数量")
    @TableField("product_count")
    private Integer productCount;

    @Schema(description = "状态（0正常 1停用）")
    @TableField("status")
    private Integer status;

    @Schema(description = "创建者")
    @TableField("create_by")
    private Long createBy;

    @Schema(description = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    @TableField("update_by")
    private Long updateBy;

    @Schema(description = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @Schema(description = "备注")
    @TableField("remark")
    private String remark;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
