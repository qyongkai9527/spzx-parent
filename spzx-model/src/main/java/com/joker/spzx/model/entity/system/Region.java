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
 * 地区信息表
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Getter
@Setter
@TableName("region")
@Schema(name = "Region", description = "地区信息表")
public class Region extends Model<Region> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "地区id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "地区编码")
    @TableField("code")
    private String code;

    @Schema(description = "上级地区code")
    @TableField("parent_code")
    private Long parentCode;

    @Schema(description = "地区名称")
    @TableField("name")
    private String name;

    @Schema(description = "地区级别：1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县")
    @TableField("level")
    private Integer level;

    @Schema(description = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @Schema(description = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    private Byte isDeleted;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
