package com.entity;

import lombok.Data;

import java.util.Date;

@Data
/**
 * 商品详情
 */
public class CommodityInfo {
    private String id;
    private String commodityId;//商品id
    private String color;//颜色
    private String memoryCapacity;//内存容量
    private Double price;//价格
    private Integer reserve;//库存
    private Integer isDelete;//是否删除
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
}
