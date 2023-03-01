package com.mapper;

import com.entity.Commodity;
import com.entity.CommodityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICommodityMapper {

    public List<Commodity> selectCommodity();

    public List<CommodityInfo> selectCommodityInfo(@Param("commodityId") String commodityId,@Param("color") String color,
                                                   @Param("memoryCapacity")String memoryCapacity,@Param("isDelete") Integer isDelete);

    public void updateCoommodity();

    public void updateCommodityInfo();

    public void noDeleteCoommodity();

    public void noDeleteCommodityInfo();

    public void deleteCoommodity();

    public void deleteCommodityInfo();

    public void insertCoommodity(Commodity commodity);

    public void insertCommodityInfo(CommodityInfo commodityInfo);

}
