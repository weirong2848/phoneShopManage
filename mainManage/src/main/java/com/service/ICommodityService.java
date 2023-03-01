package com.service;

import com.entity.Commodity;
import com.entity.CommodityInfo;
import com.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "commodityManage")
public interface ICommodityService {

    @GetMapping(value = "/commodity/selectCommodity")
    public CommonResult<List<Commodity>> selectCommodity();

    @GetMapping(value = "/commodity/selectCommodityInfo/{commodityId}")
    public CommonResult<List<CommodityInfo>> selectCommodityInfo(@PathVariable("commodityId")String commodityId);
}
