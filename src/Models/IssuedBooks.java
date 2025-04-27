/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;

public class IssuedBooks {
    //private int issueId;
    private int transactionId;
    private int borrowerId;
    private int bookId;
    private Timestamp issueDate;
    private Timestamp dueDate;
    private String status;
    
    public IssuedBooks( int transactionId, int borrowerId, int bookId, Timestamp issueDate, Timestamp dueDate, String status){
       // this.issueId = issueId;
        this.transactionId = transactionId;
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    } 
    
//    public int getIssueId(){
//        return issueId;
//    }
    
    public int getTransactionId(){
        return transactionId;
    }
    
    public int getBorrowerId(){
        return borrowerId;
    }
    
    public int getBookId(){
        return bookId;
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
