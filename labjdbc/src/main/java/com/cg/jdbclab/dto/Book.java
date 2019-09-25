package com.cg.jdbclab.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Book
{
    private BigInteger bookId;
    private String bookName;
    private BigDecimal bookPrice;
    private BigInteger authorId;
    
    public Book() {
    }
    
    public Book(BigInteger bookId, String bookName, BigDecimal bookPrice, BigInteger authorId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.authorId = authorId;
    }
    
    @Override
    public String toString() {
        return "Book [bookId=" + this.bookId + ", bookName=" + this.bookName + ", bookPrice=" + this.bookPrice + ", authorId=" + this.authorId + "]";
    }
    
    public BigInteger getBookId() {
        return this.bookId;
    }
    
    public void setBookId(BigInteger bookId) {
        this.bookId = bookId;
    }
    
    public String getBookName() {
        return this.bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public BigDecimal getBookPrice() {
        return this.bookPrice;
    }
    
    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    public BigInteger getAuthorId() {
        return this.authorId;
    }
    
    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }
    
    @Override
    public int hashCode() {
        return this.bookId.intValue();
    }
    
    @Override
    public boolean equals(final Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
