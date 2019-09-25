package com.cg.jdbclab.ui;


import com.cg.jdbclab.Exception.UserException;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.cg.jdbclab.dto.Author;
import com.cg.jdbclab.dto.Book;
import java.util.Scanner;
import com.cg.jdbclab.dao.DaoImpl;
import com.cg.jdbclab.dao.Dao;

public class Application
{
    private static Dao dao;
    
    static {
        dao = new DaoImpl();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1 to add book");
            System.out.println("2 to add author");
            System.out.println("3 to update author");
            System.out.println("4 to delete author");
            System.out.println("5 to list all books");
            System.out.println("6 to list all books of a specific author"); 
            System.out.println("7 to exit");
            choice = scanner.nextInt();
            switch(choice) {
            case 1:	
            	System.out.println("Enter the book name");
            	String book_name = scanner.next();
            	System.out.println("Enter the book price");
            	double book_cost = scanner.nextDouble();
            	System.out.println("Enter the author id");
            	int aid = scanner.nextInt();
            	Book book = new Book();
            	book.setBookName(book_name);
            	book.setBookPrice(BigDecimal.valueOf(book_cost));
            	book.setAuthorId(BigInteger.valueOf(aid));
            	//System.out.println(book.getBookName());
            	try {
					dao.addBook(book);
				} catch (UserException e) {
					System.out.println(e.getMessage());
				}
            	break;
            case 2: 
            	System.out.println("Enter the author first name");
            	String fname = scanner.next();
            	System.out.println("Enter the author middle name");
            	String mname = scanner.next();
            	System.out.println("Enter the author last name");
            	String lname = scanner.next();
            	System.out.println("Enter the author phone number");
            	long number = scanner.nextLong();
            	Author author = new Author();
            	author.setFirstName(fname);
            	author.setMiddleName(mname);
            	author.setLastName(lname);
            	author.setPhoneNo(number);
            	
            	try {
					dao.addAuthor(author);
				} catch (UserException e) {
					System.out.println(e.getMessage());
				}
            	break;
            case 3:	break;
            case 4: break;
            case 5:	break;
            case 6: 
            	System.out.println("Enter author Id whose books are to be found");
            	int id = scanner.nextInt();
            	Book book1 = new Book();
            	book1.setAuthorId(BigInteger.valueOf(id));
            	dao.authorBooks(book1);
            	break;
            case 7: System.exit(0);
            default:	
            	System.out.println("Enter choice between 1 and 7 only!");
            	break;
            }
        } while (choice != 7);
//        Book book = new Book();
//        book.setBookName("c#");
//        book.setBookPrice(new BigDecimal(500));
//        book.setAuthorId(BigInteger.valueOf(2L));
//        try {
//            book = Application.dao.addBook(book);
//            if (book != null) {
//                System.out.println("Book added successfully :" + book);
//            }
//            else {
//                System.out.println("Book not added :" + book);
//            }
//        }
//        catch (UserException e) {
//            System.out.println(e.getMessage());
//        }
//        final List<Book> bookList = Application.dao.listAllBooks();
//        if (bookList != null) {
//            bookList.forEach(System.out::println);
//        }
//        else {
//            System.out.println("No Record Found!!");
//        }
//        final List<Book> list = Application.dao.authorBooks(book);
//        for (final Book book2 : list) {
//            System.out.println("The books found are " + book.getBookName());
//        }
    }
}
