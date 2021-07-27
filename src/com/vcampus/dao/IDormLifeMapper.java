package com.vcampus.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vcampus.entity.DormLife;

public interface IDormLifeMapper {

    public Integer getHygieneMark(Map map);

    public float getWaterRate(Map map);

    public float getElectricityRate(Map map);

    public Boolean setDormHygieneMark(Map map);

}
