package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.dto.product.UserCostDto;
import com.joker.spzx.model.dto.product.UserCostPageDto;
import com.joker.spzx.model.entity.user.UserCost;
import com.joker.spzx.model.vo.product.UserCostDetailVo;
import com.joker.spzx.model.vo.product.UserCostPageVo;

/**
 * <p>
 * 商品规格 服务类
 * </p>
 *
 * @author joker
 * @since 2025-08-25 16:12:25
 */
public interface UserCostService extends IService<UserCost> {

    IPage<UserCostPageVo> findByPage(UserCostPageDto userCostQueryDto);

    UserCostDetailVo getDetail(Long id);

    void saveData(UserCostDto userCostDto);

    void updateData(UserCostDto userCostDto);

    void removeData(Long id);
}
