package com.vcampus.dao;

import com.vcampus.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * @author Huang Qiyue
 * @date 2021-07-26
 */
public interface IGoodsMapper {

    public List<Goods> listAllGoods();

    public List<Goods> listGoodsByCategory(String category);

    public List<Goods> searchGoods(String Goods);

    public Boolean insertNewGoods(Goods goods);

    public Boolean insertNewGoodsWithoutId(Goods goods);

    public Boolean deleteGoods(Goods goods);

    public List<Goods> manageListGoods(Goods goods);

    public List<Goods> searchBuyer(String buyer);

    public Boolean addBuyer(Goods Goods);

    public int getGoodsStorageByName(String name);

    public int getGoodsStorageById(int id);

    public int buySomething(Map<String, Integer> map);  //<cardNumber, id>

}
