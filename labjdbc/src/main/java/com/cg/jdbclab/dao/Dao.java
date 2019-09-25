package com.cg.jdbclab.dao;

import java.util.List;
import com.cg.jdbclab.Exception.UserException;
import com.cg.jdbclab.dto.Author;
import com.cg.jdbclab.dto.Book;

public interface Dao
{
    Book addBook(Book book) throws UserException;
    Author addAuthor(Author author) throws UserException;
    List<Book> listAllBooks();
    
    List<Book> authorBooks(final Book p0);
}
