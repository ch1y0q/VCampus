package com.vcampus.server;

import com.vcampus.dao.IStudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class AppLife {
    public static float chargeCard(HashMap map){
        float result = 0;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            studentMapper.chargeCard(map);

            result = studentMapper.getBalance((String)map.get("cardNumber"));
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
