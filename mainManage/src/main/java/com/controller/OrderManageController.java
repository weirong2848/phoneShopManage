package com.controller;

import com.entity.CommonResult;
import com.entity.Order;
import com.entity.OrderInfo;
import com.service.IOrderservice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/orderManage")
public class OrderManageController {

    @Resource
    private IOrderservice orderService;

    @RequestMapping("/selectOrder")
    public ModelAndView selectOrder(String orderId,String beginTime,String endTime,String buyUser,Integer state){
        ModelAndView mv = new ModelAndView();
        CommonResult<List<Order>> orderResult = new CommonResult<>("0000","成功");
        orderResult = orderService.selectOrder(orderId,beginTime,endTime,buyUser,state);
        List<Order> orderList = orderResult.getData();
        for(int i=0;i<orderList.size();i++){
            Order order = orderList.get(i);
            CommonResult<List<OrderInfo>> orderInfoResult = orderService.selectOrderInfo(order.getOrderId());
            order.setOrderInfos(orderInfoResult.getData());
        }
        mv.addObject("orderResult",orderResult);
        mv.setViewName("orderManage");
        return mv;
    }

    @RequestMapping("/selectOrderByOrderId")
    public ModelAndView selectOrderByOrderId(String orderId){
        ModelAndView mv = new ModelAndView();
        CommonResult<Order> orderResult = new CommonResult<>("0000","成功");
        orderResult = orderService.selectOrderByOrderId(orderId);
        if(null != orderResult.getData()){
            Order order = orderResult.getData();
            CommonResult<List<OrderInfo>> orderInfoResult = orderService.selectOrderInfo(order.getOrderId());
            order.setOrderInfos(orderInfoResult.getData());
            mv.addObject("orderResult",orderResult);
            mv.setViewName("orderMessage");
        }else{
            orderResult = new CommonResult<>("500","查询失败",null);
            mv.addObject("errorResult",orderResult);
            mv.setViewName("admin-error");
        }
        return mv;
    }

}
