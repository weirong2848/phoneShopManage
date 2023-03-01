package com.controller;

import com.entity.Commodity;
import com.entity.CommodityInfo;
import com.entity.CommonResult;
import com.service.ICommodityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/commodityManage")
public class CommodityManageController {

    @Resource
    private ICommodityService commodityService;

    @RequestMapping("/selectCommodity")
    public ModelAndView selectCommodity(){//进入商品管理页面并返回商品数据
        ModelAndView mv = new ModelAndView();
        CommonResult<List<Commodity>> commodityResult = new CommonResult<>("0000","查询成功",null);
        commodityResult = commodityService.selectCommodity();
//        List<Commodity> commodityList = commodityResult.getData();
//        for (int i=0;i<commodityList.size();i++){
//            CommonResult<List<CommodityInfo>> commodityInfoResult = commodityService.selectCommodityInfo(commodityList.get(i).getCommodityId());
//            commodityList.get(i).setCommodityInfoList(commodityInfoResult.getData());
//        }
        mv.addObject("commodityResult",commodityResult);
        mv.setViewName("commodityManage");
        return mv;
    }

    @RequestMapping("/selectCommodityInfo/{commodityId}")
    public CommonResult<List<CommodityInfo>> selectCommodityInfo(@PathVariable("commodityId")String orderId){
        CommonResult<List<CommodityInfo>> commodityInfoResult = new CommonResult<>("0000","查询成功",null);
        commodityInfoResult = commodityService.selectCommodityInfo(orderId);
        return commodityInfoResult;
    }

}

