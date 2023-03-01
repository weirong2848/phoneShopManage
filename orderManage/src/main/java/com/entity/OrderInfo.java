package com.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfo implements Serializable {

    private String orderId;
    private String goodsID;
    private String model;
    private String color;
    private String memoryCapacity;
    private Integer number;
    private double price;
    private String picture;

}
