/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseOperations;
import Models.Borrowers;
import java.util.List;

public class BorrowersController {
    private static DatabaseOperations dbo = new DatabaseOperations();
    
    public static boolean addBorrower (Borrowers borrowers){
        return dbo.addBorrower(borrowers);
    }
    
    public static List<Borrowers> getBorrower(){
        return dbo.getBorrower();
    }
    
    public static boolean updateBorrower(Borrowers borrowers){
        return dbo.updateBorrower(borrowers);
    }
    
    public static boolean deleteBorrowers(Borrowers borrowers){
        return dbo.deleteBorrower(borrowers);
    }
}
