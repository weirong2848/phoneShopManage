package com.service;

import com.entity.Order;
import com.entity.OrderInfo;

import java.util.List;
import java.util.Map;

public interface IOderService {

    public List<Order> selectOrder(String orderId,String beginTime,String endTime,String buyUser,Integer state);

    public Order selectOrderByOrderId(String orderId);

    public List<OrderInfo> selectOrderInfo(String orderId);

    public List<Map<String,Object>> selectAllSell();

    public List<Map<String,Object>> selectSellByCategory(int category);

    public List<Map<String,Object>> selectSellNumByCategory(int category);
}
