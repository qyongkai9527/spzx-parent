package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.MallAddOrderMapper;
import com.joker.spzx.manager.service.MallAddOrderService;
import com.joker.spzx.model.dto.mall.MallAddOrderPageDto;
import com.joker.spzx.model.dto.mall.MallAddOrderPageVo;
import com.joker.spzx.model.entity.oper.MallAddOrder;
import com.joker.spzx.utils.AuthContextUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 补单表 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-06-10 14:05:10
 */
@Service
public class MallAddOrderServiceImpl extends ServiceImpl<MallAddOrderMapper, MallAddOrder> implements MallAddOrderService {

    @Override
    public IPage<MallAddOrderPageVo> findByPage(MallAddOrderPageDto mallAddOrderPageDto) {
        IPage<MallAddOrderPageVo> page = mallAddOrderPageDto.getPage();
        this.baseMapper.selectAddOrderPage(page, mallAddOrderPageDto);
        return page;
    }

    @Override
    public void insertData(MallAddOrder mallAddOrder) {
        mallAddOrder.setCreateBy(AuthContextUtil.getUser().getId());
        mallAddOrder.setCreateTime(LocalDateTime.now());
        mallAddOrder.insert();
    }

    @Override
    public void updateData(MallAddOrder mallAddOrder) {
        System.out.println(mallAddOrder);
        mallAddOrder.setUpdateBy(AuthContextUtil.getUser().getId());
        mallAddOrder.setUpdateTime(LocalDateTime.now());
        mallAddOrder.updateById();
    }
}
