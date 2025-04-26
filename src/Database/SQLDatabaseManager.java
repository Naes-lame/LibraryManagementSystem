/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLDatabaseManager {
    private static final String url = "jdbc:mysql://localhost:3306/lms_database?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public abstract boolean addUser(Users users);

    public abstract boolean addBook(Books books);
    
    public abstract boolean updateBook(Books books);
    
    public abstract boolean addBorrower(Borrowers borrowers);
    
    public abstract boolean updateBorrower (Borrowers borrowers);
    
    public abstract boolean issue (Transactions transactions);
    
    public abstract boolean updateStatToReturn(int transactionId);
    
    public abstract boolean transferToReturnTbl(int transactionId);
    
    public abstract boolean returnBook(Transactions transactions);
    
    public abstract String getStatus(int borrowerId);
}
