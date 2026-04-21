package com.joker.spzx.model.dto.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserCostDto {

    private Long id;

    @Schema(description = "账单类型1:收入2:支出")
    private Integer billType;

    @Schema(description = "创建时间")
    private BigDecimal amount;

    @Schema(description = "支付方式")
    private Integer payType;

    @Schema(description = "用途Id")
    private Integer payUsageId;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "支付时间")
    private LocalDateTime payTime;
}
