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
    
    //user/admin ADD.
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
   //user/admin RETRIEVE.
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
   

   //books ADD
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

    //books UPDATE.
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

    //books FETCH.
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
    
    //borrower ADD.
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
   
    //borrowers FETCH
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
   
    //borowers UPDATE.
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
   
    //transactions ADD/IISUE.
    @Override
    public boolean issue(Transactions transactions){
        try(Connection con = getConnection()){
           String query = "INSERT INTO transactions (borrower_id, book_id, transaction_date, due_date, status) VALUES (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'Issued')";
           PreparedStatement ps = con.prepareStatement(query);

           ps.setInt(1, transactions.getBorrowerId()); 
           ps.setInt(2, transactions.getBookId());    

           int result = ps.executeUpdate();
           return result > 0;
        } catch(SQLException e){
           e.printStackTrace();
        }
        return false;
 }
  
   //transactions UPDATE/RETURN.
   @Override
   public boolean returnBook(Transactions transactions){
       try(Connection con = getConnection()){
           //updating status from the transactions DB table.
           String updateQuery = "UPDATE transactions SET status = 'Returned' WHERE transaction_id = ?";
           PreparedStatement ps = con.prepareStatement(updateQuery);
           
           ps.setInt(1, transactions.getTransactionId());
           ps.executeUpdate();
           
           //inserting updated data to returnbooks BD table.
           String insertQuery = "INSERT INTO returned_books (transaction_id, borrower_id, book_id, date_returned, status) " +
                             "SELECT transaction_id, borrower_id, book_id, NOW(), 'Returned' FROM transactions WHERE transaction_id = ?";
           PreparedStatement ps2 = con.prepareStatement(insertQuery);
           ps2.setInt(1, transactions.getTransactionId());
           int result = ps2.executeUpdate();
           return result > 0;
           
           
       }catch(SQLException e){
           e.printStackTrace();
       }
       return false;
   }
   
   //transactions FETCH DATA.
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
    
    //issued books FETCH DATA.
    public List<IssuedBooks> getIssuedBooks(){
        List<IssuedBooks> issuedBooksList = new ArrayList<>();
        String query = "SELECT * FROM issuedbooks";
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                IssuedBooks issuedBooks = new IssuedBooks(
                        rs.getInt("transaction_id"),
                        rs.getInt("borrower_id"),
                        rs.getInt("book_id"),
                        rs.getTimestamp("issue_date"),
                        rs.getTimestamp("due_date"),
                        rs.getString("status")
                );
                issuedBooksList.add(issuedBooks);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return issuedBooksList;
    }
}
