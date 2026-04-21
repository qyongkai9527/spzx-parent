package com.joker.spzx.model.dto.mall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 订单评价数据模型
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvaluation {
    private String orderId;
    private String comment;
    private List<String> fileUrls;


    // 构造函数、getters/setters省略
}