/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;

public class OverdueBooks {
    private int overdueBooksId;
    private int transactionId;
    private int borrowerId;
    private int bookId;
    private Timestamp issueDate;
    private Timestamp dueDate;
    private Timestamp daysOverdue;
    private int fineAmount;
    private String status;
    
    public OverdueBooks(int transactionId, int borrowerId, int bookId,Timestamp issueDate, 
            Timestamp dueDate, Timestamp daysOverdue, int fineAmount, String status){
    }
    
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
    
    public Timestamp getDaysOverdue(){
        return daysOverdue;
    }
    
    public int getFineAmount(){
        return fineAmount;
    }
    
    public String getStatus(){
        return status;
    }
}
