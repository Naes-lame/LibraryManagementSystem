/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Database.DatabaseOperations;
import Models.Transactions;
import java.util.List;

public class TransactionsController {
    private static final DatabaseOperations dbo = new DatabaseOperations();
    
    public static boolean issue(Transactions transactions){
        return dbo.issue(transactions);
    }
    
    public static boolean returnBooks(Transactions transactions){
        return dbo.returnBook(transactions);
    }
    
    public static List<Transactions> getTransaction(){
        return dbo.getTransaction();
    }
    
    public static String getStatus(int borrowerId){
        return dbo.getStatus(borrowerId);
    }
}
