package com.vcampus.dao;
import com.vcampus.entity.*;

import java.util.List;
import java.util.Map;

/**
 * 一系列图书馆书籍相关操作的接口
 *
 * @author Franklin Yang
 * @date 2021/7/22
 */
public interface IBookMapper {

    public String searchAuthorByTitle(String _name);

    public List<String> searchByTitle(String _name);

    public int searchHowManyByISBN(String ISBN);

    public int searchChargableByISBN(String ISBN);

    public Boolean changeChargableByISBN(String ISBN);

    public String searchTitleByISBN(String ISBN);

    public Boolean changeNumberByTitle(String _name);

    public Boolean returnBookByISBN(String ISBN);

    public List<Book> searchBeBorrowed(String borrower);

    public Book searchBookDetail(String ISBN);

    public List<Book> fuzzySearchByTitle(String _name);

    public List<Book> fuzzySearchByAuthor(String _author);
    public List<Book> fuzzySearchByTabs(String _tabs);

    public List<Book> fuzzySearchByTitleAndAuthor(Book book);
    public List<Book> fuzzySearchByTitleAndTabs(Book book);
    public List<Book> searchSimilarBook(Book book);

    public Boolean addBook(Book book);

    public Boolean deleteBook(Book book);

    public String searchPicture(String ISBN);

    public List<Book> searchHotBook();

    public int changeBorrowerByISBN(Map<String, String> map);

    public int changeTabsByISBN(Map<String, String> map);

    public int changeNumByISBN(Map<String, String> map);

    public int changePlaceByISBN(Map<String, String> map);

    public String getBorrowerByISBN(String ISBN);

    public List<Book> getBorrowedBook(String cardNumber);

    public List<Book> getBorrowedBookListFromtitle(String _name);

    public int checkBorrowTime(String ISBN);
    public int checkRenewOrNot(String ISBN);
    public Boolean renewBook(String ISBN);
}
