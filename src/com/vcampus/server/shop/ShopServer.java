package com.vcampus.server.shop;

import com.vcampus.dao.IGoodsMapper;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.Goods;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购买者（师生）角色的商店后端。
 *
 * @author Huang Qiyue
 * @date 2021-07-26
 */
public class ShopServer {
    public static List<Goods> searchGoods(String Goods) {
        List<Goods> result = null;

        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IGoodsMapper GoodsMapper = sqlSession.getMapper(IGoodsMapper.class);
            result = GoodsMapper.searchGoods(Goods);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            // sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static List<Goods> listGoodsByType(String category) {
        List<Goods> result = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IGoodsMapper GoodsMapper = sqlSession.getMapper(IGoodsMapper.class);
            result = GoodsMapper.listGoodsByCategory(category);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            // sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static List<Goods> manageListGoods(Goods Goods) {
        List<Goods> result = new ArrayList<>();

        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IGoodsMapper GoodsMapper = sqlSession.getMapper(IGoodsMapper.class);
            result = GoodsMapper.manageListGoods(Goods);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            //sqlSession.rollback();
            e.printStackTrace();
        }
        return result;

    }

    /**
     * 用于学生的结账。
     * 
     * @param cardNumber 一卡通号
     * @param se 按一定格式生成的商品-数量字符串。
     * @return 结账是否成功
     */
    public static Integer studentCheckout(String cardNumber, String se) {
        if (se.length() < 3) {
            return -1; // invalid request
        }
        Integer result = 0;
        // tokenize and parse
        BigDecimal totalMoney = new BigDecimal(0);
        Map<String, Integer> remainChecker = new HashMap<>();
        String[] L1 = se.split("\\$");
        for (String ele : L1) {
            String[] L2 = ele.split("@");
            remainChecker.put(L2[0], Integer.parseInt(L2[1]));
            totalMoney = totalMoney.add (new BigDecimal(L2[1]).multiply(new BigDecimal(L2[2])) );
        }
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            // balance check
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            BigDecimal currentBalance = studentMapper.getBalance(cardNumber);
            if (currentBalance.compareTo(totalMoney) == -1) {   // currentBalance < totalMoney
                return 1; // balance not sufficient
            }
            // storage check
            IGoodsMapper goodsMapper = sqlSession.getMapper(IGoodsMapper.class);
            for (String key : remainChecker.keySet()) {
                Integer currentRemain = Integer.parseInt(goodsMapper.getGoodsStorage(key));
                if (currentRemain < remainChecker.get(key)) {
                    return 2; // storage not sufficient
                }
            }
            // buy, update `goods`
            for (String key : remainChecker.keySet()) {
                Map<String, String> map = new HashMap<>();
                map.put("howmany", String.valueOf(remainChecker.get(key)));
                map.put("name", key);
                goodsMapper.buySomething(map);
            }
            // buy, update student balance
            Map<String, String> map = new HashMap<>();
            map.put("money", String.valueOf(totalMoney.multiply(new BigDecimal(-1))));
            map.put("cardNumber", cardNumber);
            studentMapper.chargeCard(map);
            sqlSession.commit();
            sqlSession.close();
            return 0;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

}
