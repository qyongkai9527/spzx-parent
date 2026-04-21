package com.joker.spzx.model.dto.mall;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MallAddOrderPageVo {

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "刷手Id")
    private Long brushPersonId;

    @Schema(description = "刷手名称")
    private String brushPersonName;

    @Schema(description = "产品Id")
    private String productId;

    @Schema(description = "主图图片地址")
    private String productPicUrl;

    @Schema(description = "产品名称")
    private String productName;

    @Schema(description = "淘宝订单号")
    private String tbOrderId;

    @Schema(description = "下单时间")
    private LocalDateTime orderTime;

    @Schema(description = "订单状态")
    private Integer orderState;

    @Schema(description = "本金")
    private Double seedMoney;

    @Schema(description = "佣金")
    private Double hireMoney;

    @Schema(description = "运费")
    private Double wayBillMoney;

    @Schema(description = "物流单号")
    private String wayBillCode;

    @Schema(description = "物流公司")
    private String wayBillName;
}
