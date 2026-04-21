package com.joker.spzx.model.dto.mall;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "订单详情查询参数")
public class RefundReportGenerateDto {

    private Long id;

}
