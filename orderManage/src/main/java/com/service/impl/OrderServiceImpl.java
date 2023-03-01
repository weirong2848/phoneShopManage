package com.service.impl;

import com.entity.Order;
import com.entity.OrderInfo;
import com.mapper.IOrderMapper;
import com.service.IOderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements IOderService {
    @Resource
    private IOrderMapper orderMapper;

    @Override
    public List<Order> selectOrder(String orderId,String beginTime,String endTime,String buyUser,Integer state) {
        return orderMapper.selectOrder(orderId,beginTime,endTime,buyUser,state);
    }

    @Override
    public Order selectOrderByOrderId(String orderId) {
        return orderMapper.selectOrderByOrderId(orderId);
    }

    @Override
    public List<OrderInfo> selectOrderInfo(String orderId) {
        return orderMapper.selectOrderInfo(orderId);
    }

    @Override
    public List<Map<String, Object>> selectAllSell() {
        return orderMapper.selectAllSell();
    }

    @Override
    public List<Map<String, Object>> selectSellByCategory(int category) {
        return orderMapper.selectSellByCategory(category);
    }

    @Override
    public List<Map<String, Object>> selectSellNumByCategory(int category) {
        return orderMapper.selectSellNumByCategory(category);
    }
}
