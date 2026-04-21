package com.joker.spzx.model.vo.mall;


import com.joker.spzx.model.entity.oper.MallRefundRecordDetail;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Schema
public class RefundReportVo extends MallRefundRecordDetail {

    private String name;
    private String code;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer state;
    private String orderDataCode;
}
