package com.joker.spzx.manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.joker.spzx.manager.service.MallOrderResourceService;
import com.joker.spzx.manager.service.MallProductPicVideoService;
import com.joker.spzx.model.entity.oper.MallOrderResource;
import com.joker.spzx.model.entity.oper.MallProductPicVideo;
import com.joker.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单与图片视频关联关系表 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-05-11 13:02:11
 */
@RestController
@RequestMapping("/admin/mall/orderResource")
public class MallOrderResourceController {

    @Autowired
    private MallOrderResourceService mallOrderResourceService;

    @Autowired
    private MallProductPicVideoService mallProductPicVideoService;

    @GetMapping("/getSelectedResource")
    public Result<List<Long>> getSelectedResourceList(@RequestParam Long orderId) {
        List<Long> resourceIdList = mallOrderResourceService.getSelectResources(orderId);
        return Result.build(resourceIdList);
    }

    @GetMapping("/handInsert")
    @Transactional(rollbackFor = Exception.class)
    public Result<String> handInsert() {

        List<MallOrderResource> collect58 = Lists.newArrayList(82L, 83L, 84L, 85L, 86L).stream().map(resourceId -> {
            MallOrderResource mallOrderResource = new MallOrderResource();
            mallOrderResource.setOrderId(58L);
            mallOrderResource.setFileId(resourceId);
            return mallOrderResource;
        }).collect(Collectors.toList());
        mallOrderResourceService.saveBatch(collect58);

        List<MallOrderResource> collect59 = Lists.newArrayList(87L, 88L, 89L).stream().map(resourceId -> {
            MallOrderResource mallOrderResource = new MallOrderResource();
            mallOrderResource.setOrderId(59L);
            mallOrderResource.setFileId(resourceId);
            return mallOrderResource;
        }).collect(Collectors.toList());
        mallOrderResourceService.saveBatch(collect59);

        List<MallOrderResource> collect60 = Lists.newArrayList(90L, 91L, 92L).stream().map(resourceId -> {
            MallOrderResource mallOrderResource = new MallOrderResource();
            mallOrderResource.setOrderId(60L);
            mallOrderResource.setFileId(resourceId);
            return mallOrderResource;
        }).collect(Collectors.toList());
        mallOrderResourceService.saveBatch(collect60);

        List<MallOrderResource> collect61 = Lists.newArrayList(93L, 94L, 95L).stream().map(resourceId -> {
            MallOrderResource mallOrderResource = new MallOrderResource();
            mallOrderResource.setOrderId(61L);
            mallOrderResource.setFileId(resourceId);
            return mallOrderResource;
        }).collect(Collectors.toList());
        mallOrderResourceService.saveBatch(collect61);

        List<MallOrderResource> collect62 = Lists.newArrayList(96L, 97L, 98L).stream().map(resourceId -> {
            MallOrderResource mallOrderResource = new MallOrderResource();
            mallOrderResource.setOrderId(62L);
            mallOrderResource.setFileId(resourceId);
            return mallOrderResource;
        }).collect(Collectors.toList());
        mallOrderResourceService.saveBatch(collect62);

        List<MallOrderResource> collect63 = Lists.newArrayList(99L, 100L, 101L, 102L, 103L).stream().map(resourceId -> {
            MallOrderResource mallOrderResource = new MallOrderResource();
            mallOrderResource.setOrderId(63L);
            mallOrderResource.setFileId(resourceId);
            return mallOrderResource;
        }).collect(Collectors.toList());
        mallOrderResourceService.saveBatch(collect63);


        return Result.build(null);
    }

    @GetMapping("/updateDataTest")
    @Transactional(rollbackFor = Exception.class)
    public Result<String> handInsert2() {
        LambdaQueryWrapper<MallOrderResource> gt = new LambdaQueryWrapper<MallOrderResource>()
                .gt(MallOrderResource::getId, 69L);
        List<MallOrderResource> list = this.mallOrderResourceService.list(gt);
        list.stream().forEach(mallOrderResource -> {
            Long fileId = mallOrderResource.getFileId();
            String fileUrl = "http://127.0.0.1:9000/spzx-manager/20250515/" + fileId + ".jpg";
            LambdaQueryWrapper<MallProductPicVideo> queryWrapper = new LambdaQueryWrapper<MallProductPicVideo>()
                    .eq(MallProductPicVideo::getFileUrl, fileUrl)
                    .last(" limit 1");
            MallProductPicVideo obj = mallProductPicVideoService.getOne(queryWrapper);
            if (Objects.nonNull(obj)) {
                mallOrderResource.setFileId(obj.getId());
                mallOrderResource.updateById();
            } else {
                System.out.println("文件地址查询失败：" + mallOrderResource);
            }
        });

        return Result.build(null);

    }
}
