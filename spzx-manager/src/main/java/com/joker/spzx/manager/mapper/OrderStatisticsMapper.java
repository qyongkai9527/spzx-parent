package com.joker.spzx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.spzx.model.dto.order.OrderStatisticsDto;
import com.joker.spzx.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单统计 Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Mapper
public interface OrderStatisticsMapper extends BaseMapper<OrderStatistics> {

    List<OrderStatistics> selectSaticsList(OrderStatisticsDto orderStatisticsDto);
}
