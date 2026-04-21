package com.joker.spzx.manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joker.spzx.manager.service.MallAddOrderService;
import com.joker.spzx.model.dto.mall.MallAddOrderPageDto;
import com.joker.spzx.model.dto.mall.MallAddOrderPageVo;
import com.joker.spzx.model.entity.oper.MallAddOrder;
import com.joker.spzx.model.vo.common.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 补单表 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-06-10 14:05:10
 */
@RestController
@Tag(name = "补单表接口", description = "补单表接口")
@RequestMapping("/admin/mall/addOrder")
public class MallAddOrderController {

    @Autowired
    private MallAddOrderService addOrderService;


    @GetMapping("/findByPage")
    public Result<IPage<MallAddOrderPageVo>> findByPage(MallAddOrderPageDto mallAddOrderPageDto) {
        IPage<MallAddOrderPageVo> byPage = addOrderService.findByPage(mallAddOrderPageDto);
        return Result.build(byPage);
    }

    @PostMapping("/insert")
    public Result<String> insert(@RequestBody MallAddOrder mallAddOrder) {
        addOrderService.insertData(mallAddOrder);
        return Result.build(null);
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody MallAddOrder mallAddOrder) {
        addOrderService.updateData(mallAddOrder);
        return Result.build(null);
    }
}
