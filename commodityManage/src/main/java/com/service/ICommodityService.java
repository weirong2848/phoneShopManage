package com.service;

import com.entity.Commodity;
import com.entity.CommodityInfo;

import java.util.List;

public interface ICommodityService {

    public List<Commodity> selectCommodity();

    public List<CommodityInfo> selectCommodityInfo(String commodityId,String color,String memoryCapacity,Integer isDelete);

    public void updateCoommodity();

    public void updateCommodityInfo();

    public void noDeleteCoommodity();

    public void noDeleteCommodityInfo();

    public void deleteCoommodity();

    public void deleteCommodityInfo();

    public void insertCoommodity(Commodity commodity);

    public void insertCommodityInfo(CommodityInfo commodityInfo);
}
