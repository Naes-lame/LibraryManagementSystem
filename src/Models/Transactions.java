package Models;

import java.sql.Timestamp;
import java.util.Date;

public class Transactions {
    private int transactionId;
    private int borrowerId;
    private int bookId;
    private Timestamp transactionDate;
   private Timestamp dueDate;
    private String status;
    
    public Transactions(int transactionId, int borrowerId, int bookId, Timestamp transactionDate, Timestamp dueDate, String status){
        this.transactionId = transactionId;
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.transactionDate = transactionDate;
        this.dueDate = dueDate;
        this.status = status;
    }
    
    public int getTransactionId(){
        return transactionId;
    }
    
    public int getBorrowerId(){
        return this.borrowerId;
    }
    
    public void setBorrowerId(int borrowerId){
        this.borrowerId = borrowerId;
    }
    
    public int getBookId(){
        return this.bookId;
    }
    
    public void setBookId(int bookId){
         this.bookId = bookId;
    }
    
    public Timestamp getTransactionDate(){
        return transactionDate;
    }
    
    public Timestamp getDueDate(){
        return dueDate;
   }
   
    public String getStatus(){
        return status;
    }
}
