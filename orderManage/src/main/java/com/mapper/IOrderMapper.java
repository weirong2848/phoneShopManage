package com.mapper;

import com.entity.Order;
import com.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IOrderMapper {

    public List<Order> selectOrder(@Param("orderId") String orderId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("buyUser") String buyUser, @Param("state") Integer state);

    public Order selectOrderByOrderId(String orderId);

    public List<OrderInfo> selectOrderInfo(String orderId);

    public List<Map<String,Object>> selectAllSell();

    public List<Map<String,Object>> selectSellByCategory(int category);

    public List<Map<String,Object>> selectSellNumByCategory(int category);
}
