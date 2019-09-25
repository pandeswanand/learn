package com.cg.jdbclab.dto;

import java.math.BigInteger;

public class Author
{
    private BigInteger authorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long phoneNo;
    
    public Author() {
    }
    
    public BigInteger getAuthorId() {
        return this.authorId;
    }
    
    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Long getPhoneNo() {
        return this.phoneNo;
    }
    
    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    public Author(BigInteger authorId, String firstName, String middleName, String lastName, Long phoneNo) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }
    
    @Override
    public String toString() {
        return "Author [authorId=" + this.authorId + ", firstName=" + this.firstName + ", middleName=" + this.middleName + ", lastName=" + this.lastName + ", phoneNo=" + this.phoneNo + "]";
    }
    
    @Override
    public int hashCode() {
        return this.authorId.intValue();
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
