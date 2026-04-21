package com.joker.spzx.manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Lists;
import com.joker.spzx.manager.service.MallFarmOrderService;
import com.joker.spzx.model.dto.mall.FarmOrderPageDto;
import com.joker.spzx.model.entity.oper.MallFarmOrder;
import com.joker.spzx.model.vo.common.Result;
import com.joker.spzx.model.vo.mall.OderAllocationVo;
import com.joker.spzx.utils.AuthContextUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 补单表 前端控制器
 * </p>
 *
 * @author joker
 * @since 2025-05-06 17:21:06
 */
@RestController
@RequestMapping("/admin/mall/farmOrder")
public class MallFarmOrderController {

    @Autowired
    private MallFarmOrderService mallFarmOrderService;

    @GetMapping("/findByPage")
    public Result<MallFarmOrder> findByPage(FarmOrderPageDto farmOrderPageDto) {

        IPage<MallFarmOrder> page = mallFarmOrderService.findByPage(farmOrderPageDto);
        return Result.build(page);
    }

    @PostMapping("/save")
    public Result<MallFarmOrder> saveData(@RequestBody MallFarmOrder farmOrderPageDto) {
        mallFarmOrderService.saveData(farmOrderPageDto);
        return Result.build(null);
    }

    @PutMapping("/update")
    public Result<MallFarmOrder> updateData(@RequestBody MallFarmOrder farmOrderPageDto) {
        mallFarmOrderService.updateData(farmOrderPageDto);
        return Result.build(null);
    }

    @PostMapping("/allocate")
    public Result<MallFarmOrder> allocateData(@RequestBody OderAllocationVo oderAllocationVo) {
        mallFarmOrderService.allocateResources(oderAllocationVo);
        return Result.build(null);
    }

    @PostMapping("/gennerShouBuy")
    public void gennerShouBuy(@RequestBody List<Long> orderIdList, HttpServletResponse response) {
        mallFarmOrderService.gennerShowBuy(orderIdList, response);
    }

    @PostMapping(value = "/importOrder", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Result<String> importOrderData(@RequestPart("file") MultipartFile file, @RequestParam Map<String, Object> bodyMap) {
        mallFarmOrderService.importOrderData(file, bodyMap);
        return Result.build(null);
    }

    @PostMapping("/importTemp")
    @Operation(summary = "临时录入，导入功能未完善")
    public Result<String> tempRecords() {
        List<String> orderList = Lists.newArrayList(
                "2558869538910279860",
                "2558858846770044951",
                "2558689356214958252",
                "2558677620351430155",
                "2558433867169364496",
                "2558415255269749457",
                "2558414751592615894",
                "2558406327348714695",
                "2558397039699065754",
                "2558385699141608776",
                "2558365503948194698",
                "2558355999842042687",
                "2558347467991181696",
                "2558343903625653468",
                "2558342499441063663",
                "4331613240126311215",
                "4331580950826389126",
                "4331569827559693042",
                "4331540594040997817",
                "4331347633264192221",
                "4331305117282049832",
                "4331297881782126106",
                "4331279413564242349",
                "4331272321862238846",
                "2559359857490196491",
                "2559357013389564371",
                "2558915762441461597",
                "2558901434121041261",
                "2558888546549155072",
                "2558882102517623357",
                "4331699640954925839",
                "4331683188259221612",
                "4331649459615686225",
                "4331637147772937033",
                "4331630772260226913",
                "4331630664282186820",
                "2558619588908918575",
                "2558608032475044553",
                "2558602308085321175",
                "2558399055503809180",
                "2558391027116707784",
                "2558384223385905469",
                "2558366907168407756",
                "2558360751895387860",
                "2558349159701667866",
                "4331290681520913616",
                "2559329221516388596",
                "2559293113102894152",
                "2559291133722093075");
        orderList.stream().forEach(orderId -> {
            MallFarmOrder mallFarmOrder = new MallFarmOrder();
            mallFarmOrder.setTbOrderCode(orderId);
            mallFarmOrder.setOrderType(1);
            mallFarmOrder.setSeedMoney(0.01);
            mallFarmOrder.setHireMoney(3.0);
            mallFarmOrder.setSeedIsPay(1);
            mallFarmOrder.setHireIsPay(1);
            mallFarmOrder.setShootPersonId(3L);
            mallFarmOrder.setProductId(43L);
            mallFarmOrder.setStatus(3);
            mallFarmOrder.setCreateTime(LocalDateTime.now());
            mallFarmOrder.setCreateBy(AuthContextUtil.getUser().getId());
            mallFarmOrder.setRemark("2025-05-15上传本系统，数据可能略有偏差");
            mallFarmOrder.insert();
        });

        return Result.build(null);
    }

}
