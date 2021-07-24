package com.vcampus.dao;
import com.vcampus.entity.*;

import java.util.List;
import java.util.Map;

/**
 * @author Franklin Yang
 * @date 2021/7/22
 */
public interface IBookMapper {

    public String searchAuthorByTitle(String title);

    public List<String> searchByTitle(String title);

    public int searchHowManyByISBN(String ISBN);

    public int searchChargableByISBN(String ISBN);

    public Boolean changeChargableByISBN(String ISBN);

    public String searchTitleByISBN(String ISBN);

    public Boolean changeNumberByTitle(String title);

    public Boolean returnBookByISBN(String ISBN);

    public List<Book> searchBeBorrowed(String borrower);

    public List<Book> fuzzySearchByTitle(String title);

    public List<Book> fuzzySearchByAuthor(String author);

    public List<Book> fuzzySearchByTitleAndAuthor(Book book);

    public List<Book> searchSimilarBook(Book book);

    public Boolean addBook(Book book);

    public Boolean deleteBook(Book book);

    public String searchPicture(String ISBN);

    public List<Book> searchHotBook();

    public int changeBorrowerByISBN(Map<String, String> map);

    public String getBorrowerByISBN(String ISBN);

    public List<Book> getBorrowedBook(String cardNumber);

    public int checkBorrowTime(String ISBN);
    public int checkRenewOrNot(String ISBN);
    public Boolean renewBook(String ISBN);
}
