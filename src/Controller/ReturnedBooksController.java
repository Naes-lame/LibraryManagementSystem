/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Database.DatabaseOperations;
import Models.ReturnedBooks;
import java.util.List;

public class ReturnedBooksController {
    private static final DatabaseOperations dbo = new DatabaseOperations();
    
    public static List<ReturnedBooks> getReturnedBooks(){
        return dbo.getReturnedBooks();
    }
}
