package Database;
import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLDatabaseManager {
    private static final String url = "jdbc:mysql://localhost:3306/lms_database?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public abstract boolean addUser(Users users);

    public abstract boolean addBook(Books books);
    
    public abstract boolean updateBook(Books books);
    
    public abstract boolean deleteBook(Books books);
    
    public abstract boolean addBorrower(Borrowers borrowers);
    
    public abstract boolean updateBorrower (Borrowers borrowers);
    
    public abstract boolean deleteBorrower(Borrowers borrowers);
    
    public abstract boolean issueBook (Transactions transactions);
    
    public abstract boolean updateStatToReturn(int transactionId);
    
    public abstract boolean transferToReturnTbl(int transactionId);
    
    public abstract boolean deleteFromIssuedTbl(int transactionId);

    public abstract boolean returnBook(Transactions transactions);
    
   
}
