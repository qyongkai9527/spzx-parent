package com.joker.spzx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.spzx.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    List<Map<Long, Long>> findCountByParentId(@Param("collect") List<Long> collect);
}
