package com.controller;


import com.entity.Commodity;
import com.entity.CommodityInfo;
import com.entity.CommonResult;
import com.service.ICommodityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Resource(name = "commodityService")
    private ICommodityService commodityService;

    @RequestMapping("selectCommodity")
    public CommonResult<List<Commodity>> selectCommodity(){
        List<Commodity> commodityList = commodityService.selectCommodity();
        return new CommonResult<List<Commodity>>("0000","查询成功",commodityList);
    }

    @RequestMapping("selectCommodityInfo/{commodityId}")
    public CommonResult<List<CommodityInfo>> selectCommodityInfo(@PathVariable("commodityId")String commodityId){
        List<CommodityInfo> commodityInfoList = commodityService.selectCommodityInfo(commodityId,null,null,null);
        return new CommonResult<List<CommodityInfo>>("0000","查询成功",commodityInfoList);
    }
}
