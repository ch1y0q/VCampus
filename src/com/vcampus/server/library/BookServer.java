package com.vcampus.server.library;

import com.vcampus.dao.IBookMapper;
import com.vcampus.entity.Book;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServer {
    public static String searchAuthorByTitle(String _name) {
        String result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            result = bookMapper.searchAuthorByTitle(_name);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }
    public static Book searchBookDetail(String ISBN) {
        Book book =new Book();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            book=bookMapper.searchBookDetail(ISBN);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return book;
    }

    public static int borrowBook(String borrower, String ISBN) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            String TITLE = bookMapper.searchTitleByISBN(ISBN);
            if (TITLE != null)
            {
                int chargable = bookMapper.searchChargableByISBN(ISBN);
                if (chargable >0 ) {
                    bookMapper.changeChargableByISBN(ISBN);
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("borrower", borrower);
                    map.put("ISBN", ISBN);
                    bookMapper.changeBorrowerByISBN(map);
                    result = 1;
                }
            }
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean resetTabsByISBN(Map map){
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            bookMapper.changeTabsByISBN(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Boolean resetNumByISBN(Map map){
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            bookMapper.changeNumByISBN(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Boolean resetPlaceByISBN(Map map){
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            bookMapper.changePlaceByISBN(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<Book> searchBeBorrowed(String borrower) {
        List<Book> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            list = bookMapper.searchBeBorrowed(borrower);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }


    public static List<Book> fuzzySearchByTitleAndAuthor(String _name, String _author) {
        List<Book> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            if (_author == null) {
                list = bookMapper.fuzzySearchByTitle(_name);
                sqlSession.commit();
                sqlSession.close();
                return list;
            } else if (_name == null) {
                list = bookMapper.fuzzySearchByAuthor(_author);
                sqlSession.commit();
                sqlSession.close();
                return list;
            } else {
                Book book = new Book();
                book.setName(_name);
                book.setAuthor(_author);
                list = bookMapper.fuzzySearchByTitleAndAuthor(book);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public static List<Book> fuzzySearchByTitleAndTabs(String _name, String _tabs) {
        List<Book> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            if (_tabs == null) {
                list = bookMapper.fuzzySearchByTitle(_name);
                sqlSession.commit();
                sqlSession.close();
                return list;
            } else if (_name == null) {
                list = bookMapper.fuzzySearchByTabs(_tabs);
                sqlSession.commit();
                sqlSession.close();
                return list;
            } else {
                Book book = new Book();
                book.setName(_name);
                book.setTabs(_tabs);
                list = bookMapper.fuzzySearchByTitleAndTabs(book);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public static int returnBook(String borrower, String ISBN) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();

            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            String TITLE = bookMapper.searchTitleByISBN(ISBN);

            if (TITLE != null) {
                int chargable = bookMapper.searchChargableByISBN(ISBN);
                if (chargable == 1)
                    result = 1;
                else {
                    String nowborrower = bookMapper.getBorrowerByISBN(ISBN);
                    if (nowborrower == null || !nowborrower.equals(borrower)) {
                        result = 1;
                    } else {
                        bookMapper.returnBookByISBN(ISBN);
                        result = 2;
                    }
                }
            }
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }

        return result;

    }

    public static Boolean addBook(String ISBN, String _name, String _author, String _authorCountry,String _publishingHouse,String _tabs,String _number,String _place, String _introduction) {
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            int number = bookMapper.searchHowManyByISBN(ISBN);
            if (number == 1) {
                sqlSession.close();
                return false;
            } else {
                Book book2 = new Book();
                book2.setISBN(ISBN);
                book2.setName(_name);
                book2.setAuthor(_author);
                book2.setTabs(_tabs);
                book2.setIntroduction(_introduction);
                book2.setAuthorCountry(_authorCountry);
                book2.setPublishingHouse(_publishingHouse);
                book2.setNumber(Integer.parseInt(_number));
                book2.setPlace(_place);
                bookMapper.addBook(book2);

                sqlSession.commit();
                sqlSession.close();
                return true;
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public static int searchHowManyByISBN(String ISBN) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            Book book = new Book();
            book.setISBN(ISBN);
            result = bookMapper.searchHowManyByISBN(ISBN);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static List<Book> searchSimilarBook(String _name, String _tabs) {
        List<Book> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            Book book = new Book();
            book.setName(_name);
            book.setTabs(_tabs);
            list = bookMapper.searchSimilarBook(book);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String searchPicture(String ISBN) {
        String result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            result = bookMapper.searchPicture(ISBN);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static List<Book> searchHotBook() {
        List<Book> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            list = bookMapper.searchHotBook();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;

    }

    public static Boolean deleteBook(String ISBN) {
        Boolean result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            Book book = new Book();
            book.setISBN(ISBN);
            result = bookMapper.deleteBook(book);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static int renewBook(String ISBN) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            result = bookMapper.checkBorrowTime(ISBN);
            if (result >= 30)
                result = 0;
            else {
                bookMapper.renewBook(ISBN);
                result = 1;
            }
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
