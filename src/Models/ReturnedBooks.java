
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;

public class ReturnedBooks {
    //private int returnedBooksId;
    private String borrowerName;
    private String bookTitle; 
    private Timestamp dateReturned;
    private String status;
    
    public ReturnedBooks(String borrowerName,  String bookTitle, Timestamp dateReturned, String status){
       
        this.borrowerName = borrowerName;
        this.bookTitle = bookTitle;
        this.dateReturned = dateReturned;
        this.status = status;
    }
    
    
    
    public String getBorrowerName(){
        return borrowerName;
    }
    
    public String getBookTitle(){
        return bookTitle;
    }
    
    public Timestamp getDateReturned(){
        return dateReturned;
    }
    
    public String getStatus(){
        return status;
    }
}
