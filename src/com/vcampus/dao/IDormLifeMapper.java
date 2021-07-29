package com.vcampus.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vcampus.entity.DormLife;

/**
 * 参见IStudentMapper
 *
 * @author Y
 * @date 2021/7/25
 */

public interface IDormLifeMapper {

    public Integer getHygieneMark(Map map);

    public float getWaterRate(Map map);

    public float getElectricityRate(Map map);

    public Boolean setDormHygieneMark(Map map);

    public Boolean setDormWaterRate(Map map);

    public Boolean setDormElectricityRate(Map map);

}
