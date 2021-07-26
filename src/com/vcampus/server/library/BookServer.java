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
    public static Book searchBookDetail(String serialVersionUID) {
        Book book =new Book();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            book=bookMapper.searchBookDetail(serialVersionUID);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return book;
    }

    public static int borrowBook(String borrower, String serialVersionUID) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            String TITLE = bookMapper.searchTitleByISBN(serialVersionUID);
            if (TITLE != null)
            {
                int chargable = bookMapper.searchChargableByISBN(serialVersionUID);
                System.out.println(chargable);
                if (chargable >0 ) {
                    bookMapper.changeChargableByISBN(serialVersionUID);
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("borrower", borrower);
                    map.put("serialVersionUID", serialVersionUID);
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

    public static int returnBook(String borrower, String serialVersionUID) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();

            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            String TITLE = bookMapper.searchTitleByISBN(serialVersionUID);

            if (TITLE != null) {
                int chargable = bookMapper.searchChargableByISBN(serialVersionUID);
                if (chargable == 1)
                    result = 1;
                else {
                    String nowborrower = bookMapper.getBorrowerByISBN(serialVersionUID);
                    if (nowborrower == null || !nowborrower.equals(borrower)) {
                        result = 1;
                    } else {
                        bookMapper.returnBookByISBN(serialVersionUID);
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

    public static Boolean addBook(String serialVersionUID, String title, String author, String category, String details,
                                  String pictureURL) {
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            int number = bookMapper.searchHowManyByISBN(serialVersionUID);
            if (number == 1) {
                sqlSession.close();
                return false;
            } else {
                Book book2 = new Book();
                book2.setSerialVersionUID(serialVersionUID);
                book2.setName(title);
                book2.setAuthor(author);
                book2.setTabs(category);
                book2.setIntroduction(details);
                book2.setPictureURL(pictureURL);
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

    public static int searchHowManyByISBN(String serialVersionUID) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            Book book = new Book();
            book.setSerialVersionUID(serialVersionUID);
            result = bookMapper.searchHowManyByISBN(serialVersionUID);
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

    public static String searchPicture(String serialVersionUID) {
        String result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            result = bookMapper.searchPicture(serialVersionUID);
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

    public static Boolean deleteBook(String serialVersionUID) {
        Boolean result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            Book book = new Book();
            book.setSerialVersionUID(serialVersionUID);
            result = bookMapper.deleteBook(book);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static int renewBook(String serialVersionUID) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
            result = bookMapper.checkBorrowTime(serialVersionUID);
            if (result >= 30)
                result = 0;
            else {
                bookMapper.renewBook(serialVersionUID);
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
