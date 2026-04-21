package com.joker.spzx.model.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.joker.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("user_address")
@Schema(name = "UserAddress", description = "用户地址表")
public class UserAddress extends BaseEntity {

    @Schema(description = "用户ID")
    @TableField("user_id")
    private Integer userId;

    @TableField("name")
    private String name;

    @Schema(description = "电话")
    @TableField("phone")
    private String phone;

    @Schema(description = "标签名称")
    @TableField("tag_name")
    private String tagName;

    @TableField("province_code")
    private String provinceCode;

    @TableField("city_code")
    private String cityCode;

    @TableField("district_code")
    private String districtCode;

    @Schema(description = "详细地址")
    @TableField("address")
    private String address;

    @Schema(description = "完整地址")
    @TableField("full_address")
    private String fullAddress;

    @Schema(description = "是否默认地址（0：否 1：是）")
    @TableField("is_default")
    private Byte isDefault;


}