package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.OrderStatisticsMapper;
import com.joker.spzx.manager.service.OrderStatisticsService;
import com.joker.spzx.model.entity.order.OrderStatistics;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单统计 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Service
public class OrderStatisticsServiceImpl extends ServiceImpl<OrderStatisticsMapper, OrderStatistics> implements OrderStatisticsService {

}
