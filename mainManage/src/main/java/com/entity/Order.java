package com.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Order implements Serializable {

    private String orderId;
    private String username;
    private String time;
    private String name;
    private String phone;
    private String address;
    private Integer state;
    private Integer totalNumber;
    private double totalMoney;
    private String isDel;
    private String operator;
    private Date operateTime;
    private List<OrderInfo> orderInfos;

}
