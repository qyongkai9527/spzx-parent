package com.joker.spzx.model.vo.mall;


import lombok.Data;

import java.util.List;

@Data
public class OderAllocationVo {

    private Long orderId;
    private List<Long> resourceIds;

    private String comment;
}
