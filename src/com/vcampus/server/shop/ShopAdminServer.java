package com.vcampus.server.shop;

import com.vcampus.dao.IGoodsMapper;
import com.vcampus.entity.Goods;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

/**
 * 商店管理员角色的服务器后端。
 * 
 * @author Huang Qiyue
 * @date 2021-07-26
 */
public class ShopAdminServer {
    public static Boolean insertNewGoods(Goods goods) {
        Boolean result = null;

        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IGoodsMapper goodsMapper = sqlSession.getMapper(IGoodsMapper.class);
            result = goodsMapper.insertNewGoods(goods);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;

    }

    public static Boolean deleteGoods(Goods goods) {
        Boolean result = null;

        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IGoodsMapper goodsMapper = sqlSession.getMapper(IGoodsMapper.class);
            result = goodsMapper.deleteGoods(goods);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

}
