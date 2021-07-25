package com.vcampus.server.library;

import com.vcampus.dao.IBookMapper;
import com.vcampus.entity.Book;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddoneBook {
    public static List<Book> getBorrowedBookList(String cardNumber) {
        List<Book> result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            result = bookMapper.getBorrowedBook(cardNumber);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
