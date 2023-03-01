package com.controller;

import com.entity.CommonResult;
import com.entity.Order;
import com.entity.OrderInfo;
import com.service.IOderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    private IOderService orderService;

    @RequestMapping("/selectOrder")
    public CommonResult<List<Order>> selectOrder(@RequestParam(value = "orderId", required = false) String orderId, @RequestParam(value = "beginTime", required = false)
            String beginTime, @RequestParam(value = "endTime", required = false) String endTime, @RequestParam(value = "buyUser", required = false) String buyUser, @RequestParam(value = "state", required = false) Integer state){
        List<Order> orderList = orderService.selectOrder(orderId,beginTime,endTime,buyUser,state);
        CommonResult<List<Order>> commonResult = new CommonResult<>("0000","查询成功",orderList);
        return commonResult;
    }

    @RequestMapping("/selectOrderByOrderId/{orderId}")
    public CommonResult<Order> selectOrderByOrderId(@PathVariable("orderId") String orderId){
        Order order = orderService.selectOrderByOrderId(orderId);
        CommonResult<Order> commonResult = new CommonResult<>("0000","查询成功",order);
        return commonResult;
    }

    @RequestMapping("/selectOrderInfo/{orderId}")
    public CommonResult<List<OrderInfo>> selectOrderInfo(@PathVariable("orderId")String orderId){
        List<OrderInfo> orderInfoList = orderService.selectOrderInfo(orderId);
        CommonResult<List<OrderInfo>> commonResult = new CommonResult<>("0000","查询成功",orderInfoList);
        return commonResult;

    }

    @RequestMapping("/selectAllSell")
    public CommonResult<List<Map<String,Object>>> selectAllSell(){
        List<Map<String,Object>> list = orderService.selectAllSell();
        CommonResult<List<Map<String,Object>>>  commonResult = new CommonResult<>("0000","查询成功",list);
        return commonResult;
    }

    @RequestMapping("/selectSellNumByCategory/{category}")
    public CommonResult<List<Map<String,Object>>> selectSellNumByCategory(@PathVariable("category")int category){
        List<Map<String,Object>> list = orderService.selectSellNumByCategory(category);
        CommonResult<List<Map<String,Object>>>  commonResult = new CommonResult<>("0000","查询成功",list);
        return commonResult;
    }

}
