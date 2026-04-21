package com.joker.spzx.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.spzx.manager.mapper.ProductDetailsMapper;
import com.joker.spzx.manager.service.ProductDetailsService;
import com.joker.spzx.model.entity.product.ProductDetails;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品sku属性表 服务实现类
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Service
public class ProductDetailsServiceImpl extends ServiceImpl<ProductDetailsMapper, ProductDetails> implements ProductDetailsService {

}
