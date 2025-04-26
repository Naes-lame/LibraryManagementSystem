/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


public class DatabaseOperations extends SQLDatabaseManager {
    
   @Override 
   public boolean addUser(Users users) {
       try (Connection con = getConnection()){
           String query = "INSERT INTO user  (full_name, email, username, password) VALUES ( ?, ?, ?, ?)";
           PreparedStatement  ps = con.prepareStatement(query);
           
           ps.setString(1, users.getName());
           ps.setString(2, users.getEmail());
           ps.setString(3, users.getUsername());
           ps.setString(4, users.getPassword());
           
           int result = ps.executeUpdate();
           
           return result> 0;
       } catch  (SQLException e) {
               e.printStackTrace();
               return false;
               }
   }
   
   public List<Users> getUser(){
       List<Users> userList = new ArrayList<>();
       String query = "SELECT * FROM user";
       
       try (Connection con = getConnection()){
           PreparedStatement ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
                Users user = new Users(
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                userList.add(user);
            }
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return userList;
   }
   


   @Override
    public boolean addBook(Books books) {
        try (Connection con = getConnection()) {
            String query = "INSERT INTO bookrecords (Title, Author, Genre, ISBN, Quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, books.getTitle()); 
            ps.setString(2, books.getAuthor());
            ps.setString(3, books.getGenre());
            ps.setString(4, books.getIsbn());  
            ps.setInt(5, books.getQuantity()); 

            int result = ps.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false; 
        }
    }

    
   @Override
    public boolean updateBook(Books books) {
        try (Connection con = getConnection()) {
            String query = "UPDATE bookrecords SET Title = ?, Author = ?, Genre = ?, ISBN = ?, Quantity = ? WHERE BookID = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, books.getTitle());
            ps.setString(2, books.getAuthor()); 
            ps.setString(3, books.getGenre());  
            ps.setString(4, books.getIsbn());    
            ps.setInt(5, books.getQuantity());  
            ps.setInt(6, books.getBookId());    

            int result = ps.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false; 
        }
    }

    
    public List<Books> getBooks(){
        List<Books> bookList = new ArrayList<>();
        String query = "SELECT * FROM bookrecords";
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Books books = new Books(
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Genre"),
                        rs.getString("ISBN"),
                        rs.getInt("Quantity")
                );
                bookList.add(books);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }
    
       @Override
   public boolean addBorrower (Borrowers borrowers){
        try (Connection con = getConnection()) {
           String query = "INSERT INTO borrowerrecords (Name, Address, Phone, Email) VALUES (?, ?, ?, ?)";
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setString(1, borrowers.getName());
           ps.setString(2, borrowers.getAddress());
           ps.setLong(3, borrowers.getPhone());
           ps.setString(4, borrowers.getEmail());
           
           int result = ps.executeUpdate();
           return result > 0;
           
         } catch (SQLException e){
             e.printStackTrace();
        }
       return false;
    }
   
   public List<Borrowers> getBorrower(){
       List<Borrowers> borrowerList = new ArrayList<>();
       String query = "SELECT * FROM borrowerrecords";
       
       try{
           Connection con = getConnection();
           PreparedStatement ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
               Borrowers borrowers = new Borrowers(
               rs.getInt("borrower_id"),
               rs.getString("Name"),
               rs.getString("Address"),
               rs.getLong("Phone"),
               rs.getString("Email"),
               rs.getTimestamp("membership_date")
               
               );
               borrowerList.add(borrowers);
           }
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return borrowerList;
   }
   
   @Override
   public boolean updateBorrower(Borrowers borrowers){
       try(Connection con = getConnection()){
           String query = "UPDATE borrowerrecords SET Name = ?, Address = ?, Phone = ?, Email = ? WHERE borrower_id = ?";
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setString(1, borrowers.getName());
           ps.setString(2, borrowers.getAddress());
           ps.setLong(3, borrowers.getPhone());
           ps.setString(4, borrowers.getEmail());
           ps.setInt(5, borrowers.getBorrowerId());
           
           int result = ps.executeUpdate();
           
           return result > 0;
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return false;
   }
   
   @Override
   public boolean issue(Transactions transactions){
       try(Connection con = getConnection()){
           String query = "INSERT INTO transactions (borrower_id, book_id, transaction_date, status) VALUES (?, ?, ?, ?)";
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setInt(1, transactions.getBorrowerId());
           ps.setInt(2, transactions.getBookId());
           ps.setTimestamp(3, transactions.getTransactionDate());
           ps.setString(4, transactions.getStatus());
           
           int result = ps.executeUpdate();
           return result>0;
       }catch(SQLException e){
           e.printStackTrace();
       }
       return false;
    }
   
   @Override
   public boolean updateStatToReturn(int transactionId){
       try(Connection con = getConnection()){
           String query = "UPDATE transactions SET status = ? WHERE transaction_id = ?";
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setString(1, "Returned");
           ps.setInt(2, transactionId);
           
           int result = ps.executeUpdate();
           return result>0;
           
       }catch(SQLException e){
           e.printStackTrace();     
       }
       return false;
   }
   
   @Override
   public boolean transferToReturnTbl(int transactionId){
       try(Connection con = getConnection()){
            String query = "INSERT INTO returned_books (transaction_id, book_id, borrower_id, issue_date, return_date, due_date) "
                     + "SELECT transaction_id, book_id, borrower_id, transaction_date, NOW(), due_date "
                     + "FROM transactions WHERE transaction_id = ? AND NOT EXISTS "
                     + "(SELECT 1 FROM returned_books WHERE transaction_id = ?)";
            PreparedStatement ps = con.prepareStatement(query);
        
            ps.setInt(1, transactionId);
            ps.setInt(2, transactionId);
            
            int result = ps.executeUpdate();
            return result>0;
        
       }catch(SQLException e){
           e.printStackTrace();
       }
       return false;
   }
   
   
   @Override
   public boolean returnBook(Transactions transactions){
       try(Connection con = getConnection()){
           String query = "UPDATE transactions SET borrower_id = ?, book_id = ?, transaction_date = ?,status = ? WHERE transaction_id = ?";
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setInt(1, transactions.getBorrowerId());
           ps.setInt(2, transactions.getBookId());
           ps.setTimestamp(3, transactions.getTransactionDate());
           ps.setString(4, "Returned");
           ps.setInt(5, transactions.getTransactionId());
           
           int result = ps.executeUpdate();
           updateStatToReturn(transactions.getTransactionId());
           transferToReturnTbl(transactions.getTransactionId());
           return true;
           
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return false;
   }
   
    public List<Transactions> getTransaction(){
       List<Transactions> transactionList = new ArrayList<>();
       String query = "SELECT * FROM transactions";
       
       try{
           Connection con = getConnection();
           PreparedStatement ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
                Transactions transaction = new Transactions(
                    rs.getInt("transaction_id"),
                    rs.getInt("borrower_id"),
                    rs.getInt("book_id"),
                    rs.getTimestamp("transaction_date"),
                    rs.getTimestamp("due_date"),
                    rs.getString("status")
                );
               transactionList.add(transaction);
           }
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return transactionList;
   }
    
    @Override
    public String getStatus(int borrowerId){
        String status = "Unknown";
        try(Connection con = getConnection()){
            String query = "SELECT status FROM transactions WHERE borrower_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, borrowerId);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                status = rs.getString("status");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
