package com.joker.spzx.manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joker.spzx.manager.service.ProductService;
import com.joker.spzx.model.dto.product.ProductDto;
import com.joker.spzx.model.entity.product.Product;
import com.joker.spzx.model.vo.common.Result;
import com.joker.spzx.model.vo.common.ResultCodeEnum;
import com.joker.spzx.model.vo.product.ProductPageVo;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-04-15 17:07:15
 */
@RestController
@RequestMapping(value = "/admin/product/sourceProduct")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/pageList")
    public Result<IPage<ProductPageVo>> findByPage(ProductDto productDto) {
        IPage<ProductPageVo> pageInfo = productService.findByPage(productDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/saveData")
    public Result save(@RequestBody Product product) {
        productService.saveData(product);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/updateData")
    public Result updateById(@RequestBody Product product) {
        productService.updateDataById(product);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@Parameter(name = "id", description = "商品id", required = true) @PathVariable Long id) {
        productService.deleteData(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


    @GetMapping("/getDetail")
    public Result<ProductPageVo> updateStatus(@RequestParam Long id) {
        ProductPageVo byId = productService.getDataById(id);
        return Result.build(byId, ResultCodeEnum.SUCCESS);
    }
}
