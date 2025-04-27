/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Database.DatabaseOperations;
import Models.IssuedBooks;
import java.util.List;

public class IssuedBooksController {
    private static final DatabaseOperations dbo = new DatabaseOperations();
    
    public static List<IssuedBooks> getIssuedBooks(){
        return dbo.getIssuedBooks();
    }
}
