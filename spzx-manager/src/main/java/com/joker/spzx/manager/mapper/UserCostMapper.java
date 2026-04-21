package com.joker.spzx.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joker.spzx.model.dto.product.UserCostPageDto;
import com.joker.spzx.model.entity.user.UserCost;
import com.joker.spzx.model.vo.product.UserCostPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品规格 Mapper 接口
 * </p>
 *
 * @author joker
 * @since 2025-08-25 16:12:25
 */
@Mapper
public interface UserCostMapper extends BaseMapper<UserCost> {

    IPage<UserCostPageVo> selectPageList(@Param("page") IPage<UserCostPageVo> page, @Param("dto") UserCostPageDto userCostQueryDto);


}
