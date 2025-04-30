/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseOperations;
import Models.*;
import java.util.List;

public class BooksController {
    private static DatabaseOperations dbo = new DatabaseOperations();
    
    
    
    public static List<Books> getBooks(){
        return dbo.getBooks();
    }
    
    public static boolean addBook(Books books){
        return dbo.addBook(books);
    }
    
    public static boolean updateBook(Books books){
        return dbo.updateBook(books);
    }
    
    public static boolean deleteBook(Books books){
        return dbo.deleteBook(books);
    }
}
