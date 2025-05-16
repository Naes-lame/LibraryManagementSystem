/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;

public class IssuedBooks {
    private int issueId;
    private String borrowerName;
    private String bookTitle;
    private Timestamp issueDate;
    private Timestamp dueDate;
    private String status;
    
    public IssuedBooks( String borrowerName, String bookTitle, Timestamp issueDate, Timestamp dueDate, String status){
        this.issueId = issueId;
        this.borrowerName = borrowerName;
        this.bookTitle = bookTitle;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    } 
    
    public int getIssueId(){
        return issueId;
    }
    
    
    public String getBorrowerName(){
        return borrowerName;
    }
    
    public String getBookTitle(){
        return bookTitle;
    }
    
    public Timestamp getIssueDate(){
        return issueDate;
    }
    
    public Timestamp getDueDate(){
        return dueDate;
    }
    
    public String getStatus(){
        return status;
    }
    
}
