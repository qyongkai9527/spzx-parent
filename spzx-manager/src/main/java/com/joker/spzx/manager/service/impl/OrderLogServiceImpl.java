package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.OrderLogMapper;
import com.joker.spzx.manager.service.OrderLogService;
import com.joker.spzx.model.entity.order.OrderLog;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单操作日志记录 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Service
public class OrderLogServiceImpl extends ServiceImpl<OrderLogMapper, OrderLog> implements OrderLogService {

}
