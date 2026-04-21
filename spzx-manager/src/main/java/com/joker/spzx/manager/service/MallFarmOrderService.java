package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.dto.mall.FarmOrderPageDto;
import com.joker.spzx.model.entity.oper.MallFarmOrder;
import com.joker.spzx.model.vo.mall.OderAllocationVo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 补单表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-05-06 17:21:06
 */
public interface MallFarmOrderService extends IService<MallFarmOrder> {

    IPage<MallFarmOrder> findByPage(FarmOrderPageDto farmOrderPageDto);

    void saveData(MallFarmOrder farmOrderPageDto);

    void updateData(MallFarmOrder farmOrderPageDto);

    void allocateResources(OderAllocationVo oderAllocationVo);

    void gennerShowBuy(List<Long> orderIdList, HttpServletResponse response);

    void importOrderData(MultipartFile file, Map<String, Object> bodyMap);
}
