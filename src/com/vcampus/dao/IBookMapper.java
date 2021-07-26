package com.vcampus.dao;
import com.vcampus.entity.*;

import java.util.List;
import java.util.Map;

/**
 * @author Franklin Yang
 * @date 2021/7/22
 */
public interface IBookMapper {

    public String searchAuthorByTitle(String _name);

    public List<String> searchByTitle(String _name);

    public int searchHowManyByISBN(String serialVersionUID);

    public int searchChargableByISBN(String serialVersionUID);

    public Boolean changeChargableByISBN(String serialVersionUID);

    public String searchTitleByISBN(String serialVersionUID);

    public Boolean changeNumberByTitle(String _name);

    public Boolean returnBookByISBN(String serialVersionUID);

    public List<Book> searchBeBorrowed(String borrower);

    public Book searchBookDetail(String serialVersionUID);

    public List<Book> fuzzySearchByTitle(String _name);

    public List<Book> fuzzySearchByAuthor(String _author);
    public List<Book> fuzzySearchByTabs(String _tabs);

    public List<Book> fuzzySearchByTitleAndAuthor(Book book);
    public List<Book> fuzzySearchByTitleAndTabs(Book book);
    public List<Book> searchSimilarBook(Book book);

    public Boolean addBook(Book book);

    public Boolean deleteBook(Book book);

    public String searchPicture(String serialVersionUID);

    public List<Book> searchHotBook();

    public int changeBorrowerByISBN(Map<String, String> map);

    public String getBorrowerByISBN(String serialVersionUID);

    public List<Book> getBorrowedBook(String cardNumber);

    public int checkBorrowTime(String serialVersionUID);
    public int checkRenewOrNot(String serialVersionUID);
    public Boolean renewBook(String serialVersionUID);
}
