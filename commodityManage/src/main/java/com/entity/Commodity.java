package com.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Commodity implements Serializable {

    private String id;
    private String commodityId;//商品编号
    private String brand;//品牌
    private String model;//型号
    private String picture;//图片
    private String commoditydetails;//详情
    private Integer category;//品类
    private String kind;//分类
    private Integer isDelete;//是否删除
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;

    private List<CommodityInfo> commodityInfoList;//颜色规格价格信息


}
