package com.joker.spzx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joker.spzx.model.entity.oper.MallProductPicVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品图片表 Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2025-05-02 20:52:02
 */
@Mapper
public interface MallProductPicVideoMapper extends BaseMapper<MallProductPicVideo> {

    List<MallProductPicVideo> selectPicVideoListByOrderId(@Param("orderId") Long orderId);
}
