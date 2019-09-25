package com.cg.jdbclab.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.math.BigInteger;

import com.cg.jdbclab.dto.Author;
import com.cg.jdbclab.dto.Book;
import java.util.Properties;
import com.cg.jdbclab.Exception.UserException;
import com.cg.jdbclab.util.DBUtil;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class DaoImpl implements Dao
{
    private static Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private static Logger myLogger;
    
    static {
        final Properties props = System.getProperties();
        final String userDir = String.valueOf(props.getProperty("user.dir")) + "/src/main/resources/";
        System.out.println("Current working directory is " + userDir);
        PropertyConfigurator.configure(String.valueOf(userDir) + "log4j.properties");
        DaoImpl.myLogger = Logger.getLogger("DBUtil.class");
        try {
            DaoImpl.connection = DBUtil.getConnection();
            DaoImpl.myLogger.info((Object)"Connection Obtained!!");
        }
        catch (UserException e) {
            DaoImpl.myLogger.error((Object)("Connection Not Obtained at EmployeeDao : " + e));
        }
    }
    
    public Book addBook(Book book) throws UserException {
    	String sql = "Insert into book(book_name,book_price,author_Id) values (?,?,?)";
        try {
        	ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getBookName());
            ps.setBigDecimal(2, book.getBookPrice());
            ps.setLong(3, book.getAuthorId().longValue());
            int noOfRec = this.ps.executeUpdate();
            BigInteger generatedId = BigInteger.valueOf(0L);
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = BigInteger.valueOf(rs.getLong(1));
                System.out.println("Auto generated Id " + generatedId);
            }
            book.setBookId(generatedId);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new UserException("The entered author does not exist");
        }
        catch (SQLException e) {
            DaoImpl.myLogger.error((Object)("Error at addBook Dao method : " + e));
            System.out.println("Error at addBook Dao method : " + e);
        }
        finally {
            if (this.ps != null) {
                try {
                    this.ps.close();
                }
                catch (SQLException e2) {
                    System.out.println("Error at addBook Dao method : " + e2);
                }
            }
        }
        if (this.ps != null) {
            try {
                this.ps.close();
            }
            catch (SQLException e2) {
                System.out.println("Error at addBook Dao method : " + e2);
            }
        }
        return book;
    }
    
    public List<Book> listAllBooks() {
        final String sql = "select * from book";
        final List<Book> list = new ArrayList<Book>();
        try {
            this.ps = connection.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            while (this.rs.next()) {
                final Book book = new Book();
                book.setBookId(BigInteger.valueOf(this.rs.getLong("book_Id")));
                book.setBookName(this.rs.getString("book_name"));
                book.setBookPrice(BigDecimal.valueOf(this.rs.getLong("book_price")));
                book.setAuthorId(BigInteger.valueOf(this.rs.getLong("author_Id")));
                list.add(book);
            }
        }
        catch (SQLException e) {
            System.out.println("Error at listAllBooks Dao method : " + e);
            if (this.ps != null) {
                try {
                    this.ps.close();
                }
                catch (SQLException e2) {
                    System.out.println("Error at listAllBooks Dao method : " + e2);
                }
                return list;
            }
            return list;
        }
        finally {
            if (this.ps != null) {
                try {
                    this.ps.close();
                }
                catch (SQLException e2) {
                    System.out.println("Error at listAllBooks Dao method : " + e2);
                }
            }
        }
        if (this.ps != null) {
            try {
                this.ps.close();
            }
            catch (SQLException e2) {
                System.out.println("Error at listAllBooks Dao method : " + e2);
            }
        }
        return list;
    }
    
    public List<Book> authorBooks(Book book) {
        List<Book> authorList = new ArrayList<Book>();
        String sql = "select book_name from book where author_Id = ?";
        try {
            ps = connection.prepareStatement(sql);
			ps.setLong(1, book.getAuthorId().longValue());
            rs = ps.executeQuery();
            while (rs.next()) {
                final Book authorBook = new Book();
                authorBook.setBookId(BigInteger.valueOf(this.rs.getLong("book_id")));
                authorBook.setBookName(this.rs.getString("book_name"));
                authorList.add(book);
            }
        }
        catch (SQLException e) {
            System.out.println("Error at authorBooks Dao method : " + e);
            if (ps != null) {
                try {
                    ps.close();
                }
                catch (SQLException e2) {
                    System.out.println("Error at authorBooks Dao method : " + e2);
                }
                return authorList;
            }
            return authorList;
        }
        finally {
            if (ps != null) {
                try {
                    ps.close();
                }
                catch (SQLException e2) {
                    System.out.println("Error at authorBooks Dao method : " + e2);
                }
            }
        }
        if (ps != null) {
            try {
                ps.close();
            }
            catch (SQLException e2) {
                System.out.println("Error at authorBooks Dao method : " + e2);
            }
        }
        return authorList;
    }

	@Override
	public Author addAuthor(Author author) throws UserException {
		String sql = "Insert into author(author_fname, author_mname, author_lname, author_phoneno) values (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        	ps.setString(1, author.getFirstName());
            ps.setString(2, author.getMiddleName());
            ps.setString(3, author.getLastName());
            ps.setLong(4, author.getPhoneNo().longValue());
            int noOfRec = ps.executeUpdate();
            BigInteger generatedId = BigInteger.valueOf(0L);
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = BigInteger.valueOf(rs.getLong(1));
                System.out.println("Auto generated Id " + generatedId);
            }
            author.setAuthorId(generatedId);
        }
        catch (SQLException e) {
            DaoImpl.myLogger.error((Object)("Error at addAuthor Dao method : " + e));
            System.out.println("Error at addAuthor Dao method : " + e);
        }
        finally {
            if (ps != null) {
                try {
                    ps.close();
                }
                catch (SQLException e2) {
                    System.out.println("Error at addAuthor Dao method : " + e2);
                }
            }
        }
        if (ps != null) {
            try {
                ps.close();
            }
            catch (SQLException e2) {
                System.out.println("Error at addAuthor Dao method : " + e2);
            }
        }
        return author;
    }
}
