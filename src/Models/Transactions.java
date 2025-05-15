package Models;

import java.sql.Timestamp;
import java.util.Date;

public class Transactions {
    private int transactionId;
    private String borrowerName;
    private String bookTitle;
    private Timestamp transactionDate;
    private Timestamp dueDate;
    private String status;
    
    public Transactions(int transactionId, String borrowerName, String bookTitle, Timestamp transactionDate, Timestamp dueDate, String status){
        this.transactionId = transactionId;
        this.borrowerName = borrowerName;
        this.bookTitle = bookTitle;
        this.transactionDate = transactionDate;
        this.dueDate = dueDate;
        this.status = status;
    }
    
    public int getTransactionId(){
        return transactionId;
    }
    
    public String getBorrowerName(){
        return borrowerName;
    }
    
    public void setBorrowerName(String borrowerName){
        this.borrowerName = borrowerName;
    }
    
    public String getBookTitle(){
        return bookTitle;
    }
    
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
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
