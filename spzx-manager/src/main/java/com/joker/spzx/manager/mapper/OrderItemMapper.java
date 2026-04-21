package com.joker.spzx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.spzx.model.entity.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单项信息 Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
