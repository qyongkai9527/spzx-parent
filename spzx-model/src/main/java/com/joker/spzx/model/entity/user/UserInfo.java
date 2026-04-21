package com.joker.spzx.model.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.joker.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户实体类")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    @TableField("username")
    private String username;

    @Schema(description = "密码")
    @TableField("password")
    private String password;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "电话号码")
    @TableField("phone")
    private String phone;

    @Schema(description = "头像")
    @TableField("avatar")
    private String avatar;

    @Schema(description = "性别")
    @TableField("sex")
    private Boolean sex;

    @Schema(description = "备注")
    @TableField("memo")
    private String memo;

    @Schema(description = "微信open id")
    @TableField("open_id")
    private String openId;

    @Schema(description = "微信开放平台unionID")
    @TableField("union_id")
    private String unionId;

    @Schema(description = "最后一次登录ip")
    @TableField("last_login_ip")
    private String lastLoginIp;

    @Schema(description = "最后一次登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @Schema(description = "状态：1为正常，0为禁止")
    @TableField("status")
    private Integer status;

}