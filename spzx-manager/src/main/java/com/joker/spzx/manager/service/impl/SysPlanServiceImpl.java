package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.MallProductMapper;
import com.joker.spzx.manager.mapper.SysPlanMapper;
import com.joker.spzx.manager.mapper.SysPlanProductMapper;
import com.joker.spzx.manager.service.SysPlanService;
import com.joker.spzx.model.entity.oper.MallProduct;
import com.joker.spzx.model.entity.user.SysPlan;
import com.joker.spzx.model.entity.user.SysPlanProduct;
import com.joker.spzx.utils.AuthContextUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 推广计划表 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-05-21 17:06:21
 */
@Service
public class SysPlanServiceImpl extends ServiceImpl<SysPlanMapper, SysPlan> implements SysPlanService {

    @Autowired
    private SysPlanProductMapper sysPlanProductMapper;
    @Autowired
    private MallProductMapper mallProductMapper;

    @Override
    public List<SysPlan> getList(Integer type) {
        LambdaQueryWrapper<SysPlan> eq = lambdaQuery().getWrapper().eq(SysPlan::getType, type)
                .eq(SysPlan::getStatus, 0);
        return list(eq);
    }

    @Override
    public void saveData(SysPlan sysPlan) {
        sysPlan.setCreateBy(AuthContextUtil.getUser().getId());
        sysPlan.setCreateTime(LocalDateTime.now());
        sysPlan.setStatus(0);
        sysPlan.setProductCount(0);
        this.baseMapper.insert(sysPlan);
    }

    @Override
    public List<MallProduct> getLinkedProductList(Long planId) {
        LambdaQueryWrapper<SysPlanProduct> queryWrapper = new LambdaQueryWrapper<SysPlanProduct>()
                .eq(SysPlanProduct::getPlanId, planId)
                .eq(SysPlanProduct::getStatus, 0);
        List<SysPlanProduct> sysPlanProducts = sysPlanProductMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(sysPlanProducts)) {
            return Lists.newArrayList();
        }
        List<Long> collect = sysPlanProducts.stream().map(SysPlanProduct::getProductId).collect(Collectors.toList());
        LambdaQueryWrapper<MallProduct> productLambdaQueryWrapper = new LambdaQueryWrapper<MallProduct>()
                .in(MallProduct::getId, collect);

        return mallProductMapper.selectList(productLambdaQueryWrapper);
    }
}
