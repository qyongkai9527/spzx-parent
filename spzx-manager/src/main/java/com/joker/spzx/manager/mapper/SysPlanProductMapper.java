package com.joker.spzx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.spzx.model.entity.user.SysPlanProduct;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 计划和商品关联表 Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2025-05-21 17:06:21
 */
@Mapper
public interface SysPlanProductMapper extends BaseMapper<SysPlanProduct> {

}
