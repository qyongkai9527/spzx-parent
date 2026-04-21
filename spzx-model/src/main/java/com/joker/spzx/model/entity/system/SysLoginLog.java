package com.joker.spzx.model.entity.system;

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
 * 系统用户登录记录
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Getter
@Setter
@TableName("sys_login_log")
@Schema(name = "SysLoginLog", description = "系统用户登录记录")
public class SysLoginLog extends Model<SysLoginLog> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "访问ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "用户账号")
    @TableField("username")
    private String username;

    @Schema(description = "登录IP地址")
    @TableField("ipaddr")
    private String ipaddr;

    @Schema(description = "登录状态（0成功 1失败）")
    @TableField("status")
    private Boolean status;

    @Schema(description = "提示信息")
    @TableField("msg")
    private String msg;

    @Schema(description = "访问时间")
    @TableField("access_time")
    private LocalDateTime accessTime;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @Schema(description = "删除标记（0:不可用 1:可用）")
    @TableField("is_deleted")
    private Byte isDeleted;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
