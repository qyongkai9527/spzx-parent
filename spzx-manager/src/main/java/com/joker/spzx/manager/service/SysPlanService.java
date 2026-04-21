package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.entity.oper.MallProduct;
import com.joker.spzx.model.entity.user.SysPlan;

import java.util.List;

/**
 * <p>
 * 推广计划表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-05-21 17:06:21
 */
public interface SysPlanService extends IService<SysPlan> {

    List<SysPlan> getList(Integer type);

    void saveData(SysPlan type);

    List<MallProduct> getLinkedProductList(Long planId);
}
