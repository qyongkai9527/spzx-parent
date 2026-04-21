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
 * 每天日程安排表
 * </p>
 *
 * @author joker
 * @since 2025-05-20 11:34:20
 */
@Getter
@Setter
@TableName("sys_user_schedule")
@Schema(name = "SysUserSchedule", description = "每天日程安排表")
public class SysUserSchedule extends Model<SysUserSchedule> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "用户id")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "日期")
    @TableField("date_str")
    private String dateStr;

    @Schema(description = "子任务个数")
    @TableField("task_count")
    private Integer taskCount;

    @Schema(description = "完成个数")
    @TableField("complete_count")
    private Integer completeCount;

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
