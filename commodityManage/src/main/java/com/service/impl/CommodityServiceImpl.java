package com.service.impl;

import com.entity.Commodity;
import com.entity.CommodityInfo;
import com.mapper.ICommodityMapper;
import com.service.ICommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commodityService")
public class CommodityServiceImpl implements ICommodityService {

    @Resource
    private ICommodityMapper commodityMapper;

    @Override
    public List<Commodity> selectCommodity() {
        return commodityMapper.selectCommodity();
    }

    @Override
    public List<CommodityInfo> selectCommodityInfo(String commodityId,String color,String memoryCapacity,Integer isDelete) {
        return commodityMapper.selectCommodityInfo(commodityId,color,memoryCapacity,isDelete);
    }

    @Override
    public void updateCoommodity() {
        commodityMapper.updateCoommodity();
    }

    @Override
    public void updateCommodityInfo() {
        commodityMapper.updateCommodityInfo();
    }

    @Override
    public void noDeleteCoommodity() {
        commodityMapper.noDeleteCoommodity();
    }

    @Override
    public void noDeleteCommodityInfo() {
        commodityMapper.updateCommodityInfo();
    }

    @Override
    public void deleteCoommodity() {
        commodityMapper.deleteCoommodity();
    }

    @Override
    public void deleteCommodityInfo() {
        commodityMapper.deleteCommodityInfo();
    }

    @Override
    public void insertCoommodity(Commodity commodity) {
        commodityMapper.insertCoommodity(commodity);
    }

    @Override
    public void insertCommodityInfo(CommodityInfo commodityInfo) {
        commodityMapper.insertCommodityInfo(commodityInfo);
    }
}
