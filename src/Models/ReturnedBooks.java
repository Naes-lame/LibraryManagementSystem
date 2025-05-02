/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;

public class ReturnedBooks {
    //private int returnedBooksId;
    private int transactionId;
    private int borrowerId;
    private int bookId;
    private Timestamp dateReturned;
    private String status;
    
    public ReturnedBooks(int transactionId, int borrowerId, int bookId, Timestamp dateReturned, String status){
        this.transactionId = transactionId;
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.dateReturned = dateReturned;
        this.status = status;
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
    
    public Timestamp getDateReturned(){
        return dateReturned;
    }
    
    public String getStatus(){
        return status;
    }
}
