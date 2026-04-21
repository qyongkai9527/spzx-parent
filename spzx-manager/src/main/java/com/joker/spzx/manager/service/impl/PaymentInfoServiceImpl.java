package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.PaymentInfoMapper;
import com.joker.spzx.manager.service.PaymentInfoService;
import com.joker.spzx.model.entity.pay.PaymentInfo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 付款信息表 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

}
