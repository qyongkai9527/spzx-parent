package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.entity.system.ProductUnit;

import java.util.List;

/**
 * <p>
 * 商品单位 服务类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
public interface ProductUnitService extends IService<ProductUnit> {

    List<ProductUnit> findAll();
}
