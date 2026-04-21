package com.joker.spzx.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "请求参数实体类")
public class AssginRoleDto {

    @NotNull(message = "用户id不能为空")
    @Schema(description = "用户id")
    private Long userId;

    @NotNull(message = "角色id的List集合不能为空")
    @Size(min = 1, message = "角色id的List集合不能为空")
    @Schema(description = "角色id的List集合")
    private List<Long> roleIdList;

}
