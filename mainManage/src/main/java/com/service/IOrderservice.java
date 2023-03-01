package com.service;

import com.entity.CommonResult;
import com.entity.Order;
import com.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "orderManage")
public interface IOrderservice {

    @GetMapping("/order/selectOrder")
    public CommonResult<List<Order>> selectOrder(@RequestParam(value = "orderId", required = false) String orderId, @RequestParam(value = "beginTime", required = false)
            String beginTime, @RequestParam(value = "endTime", required = false) String endTime, @RequestParam(value = "buyUser", required = false) String buyUser, @RequestParam(value = "state", required = false) Integer state);

    @GetMapping(value = "/order/selectOrderByOrderId/{orderId}")
    public CommonResult<Order> selectOrderByOrderId(@PathVariable("orderId")String orderId);

    @GetMapping(value = "/order/selectOrderInfo/{orderId}")
    public CommonResult<List<OrderInfo>> selectOrderInfo(@PathVariable("orderId")String orderId);

    @GetMapping(value = "/order/selectAllSell")
    public CommonResult<List<Map<String,Object>>> selectAllSell();

    @GetMapping(value = "/order/selectSellNumByCategory/{category}")
    public CommonResult<List<Map<String,Object>>> selectSellNumByCategory(@PathVariable("category")int category);
}
