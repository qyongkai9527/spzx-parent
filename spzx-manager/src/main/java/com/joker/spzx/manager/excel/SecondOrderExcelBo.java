package com.joker.spzx.manager.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class SecondOrderExcelBo {

    @ExcelProperty(value = "订单编号", index = 0)
    private String orderId;

    @ExcelProperty(value = "买家实付金额", index = 1)
    private String money;

    @ExcelProperty(value = "订单状态", index = 2)
    private String orderStatus;
}
