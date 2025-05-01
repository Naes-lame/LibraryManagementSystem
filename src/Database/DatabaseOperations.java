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
import javax.swing.JOptionPane;


public class DatabaseOperations extends SQLDatabaseManager {
    
    //user/admin ADD.
   @Override 
   public boolean addUser(Users users) {
        try (Connection con = getConnection()){
            String checkQuery = "SELECT COUNT(*) FROM user WHERE full_name = ? AND email = ? AND username = ?";//checking for duplication
            PreparedStatement check = con.prepareStatement(checkQuery);
            check.setString(1, users.getName());
            check.setString(2, users.getEmail());
            check.setString(3, users.getUsername());
            ResultSet rs = check.executeQuery();
            rs.next();
            
            if(rs.getInt(1)>0){
                JOptionPane.showMessageDialog(null, "User is already registered!","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
           String query = "INSERT INTO user  (full_name, email, username, password) VALUES ( ?, ?, ?, ?)";//adding new user
           PreparedStatement  ps = con.prepareStatement(query);
           
           ps.setString(1, users.getName());
           ps.setString(2, users.getEmail());
           ps.setString(3, users.getUsername());
           ps.setString(4, users.getPassword());
           
           int result = ps.executeUpdate();
           
           return result> 0;
        } catch  (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
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
           JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }
       return userList;
   }
   

   //books ADD
   @Override
    public boolean addBook(Books books) {
        try (Connection con = getConnection()) {
            String checkQuery = " SELECT COUNT(*) FROM bookrecords WHERE Title = ? AND Author = ? AND Genre = ? AND ISBN = ?";
            PreparedStatement check = con.prepareStatement(checkQuery);
            check.setString(1, books.getTitle());
            check.setString(2, books.getAuthor());
            check.setString(3, books.getGenre());
            check.setString(4, books.getIsbn());
            
            ResultSet rs = check.executeQuery();
            rs.next();
            
            if (rs.getInt(1)>0){
                JOptionPane.showMessageDialog(null, "Book already exists!","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
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
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
            return false; 
        }
    }

    //books UPDATE.
   @Override
    public boolean updateBook(Books books) {
        try (Connection con = getConnection()) {
            
            String query = "UPDATE bookrecords SET Title = ?, Author = ?, Genre = ?, ISBN = ?, Quantity = ? WHERE book_id = ?";
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
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
            return false; 
        }
    }
    
    //books SOFT DELETE
    @Override
    public boolean deleteBook(Books books) {
    try (Connection con = getConnection()) {
        String updateQuery = "UPDATE bookrecords SET deleted_at = NOW() WHERE book_id = ?";
        
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setInt(1, books.getBookId());
            int result = ps.executeUpdate();
            
            return result > 0; // True if the update was successful
        }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating record!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }



    //books FETCH.
    public List<Books> getBooks(){
        List<Books> bookList = new ArrayList<>();
        String query = "SELECT * FROM bookrecords WHERE deleted_at IS NULL";//unable the deleted records to display
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Books books = new Books(
                        rs.getInt("book_id"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Genre"),
                        rs.getString("ISBN"),
                        rs.getInt("Quantity")
                );
                bookList.add(books);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return bookList;
    }
    
    
    
    //borrower ADD.puyaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    @Override
    public boolean addBorrower (Borrowers borrowers){
        try (Connection con = getConnection()) {
            String checkQuery = "SELECT COUNT(*) FROM borrowerrecords WHERE Name = ? AND Address = ? AND Phone = ? AND Email = ? ";
            PreparedStatement check = con.prepareStatement(checkQuery);
            
            check.setString(1, borrowers.getName());
            check.setString(2, borrowers.getAddress());
            check.setLong(3, borrowers.getPhone());
            check.setString(4, borrowers.getEmail());
            
            ResultSet rs = check.executeQuery();
            rs.next();
            
            if(rs.getInt(1)> 0){
                JOptionPane.showMessageDialog(null, "Borrower already existed!","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            String query = "INSERT INTO borrowerrecords (Name, Address, Phone, Email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, borrowers.getName());
            ps.setString(2, borrowers.getAddress());
            ps.setLong(3, borrowers.getPhone());
            ps.setString(4, borrowers.getEmail());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
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
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
        }
        return false;
    }
    
    @Override 
    public boolean deleteBorrower(Borrowers borrowers){
        try(Connection con = getConnection()){
            String query = "UPDATE borrowerrecords SET deleted_at = NOW() WHERE borrower_id = ?";
            try(PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, borrowers.getBorrowerId());
                int result =  ps.executeUpdate();
                
                return result > 0;
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }
    
     //borrowers FETCH
    public List<Borrowers> getBorrower(){
       List<Borrowers> borrowerList = new ArrayList<>();
       String query = "SELECT * FROM borrowerrecords WHERE deleted_at IS NULL";
       
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
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
        }
        return borrowerList;
    }
   
    //transactions ADD/IISUE.
    @Override
    public boolean issueBook(Transactions transactions){
        try(Connection con = getConnection()){
            String checkQuery = "SELECT COUNT(*) FROM transactions WHERE borrower_id = ? AND book_id = ?";
            PreparedStatement check = con.prepareStatement(checkQuery);
            
            check.setInt(1, transactions.getBorrowerId());
            check.setInt(2, transactions.getBookId());
            
            ResultSet rs = check.executeQuery();
            rs.next();
            
            if(rs.getInt(1)> 0){
                JOptionPane.showMessageDialog(null, "This transaction already exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }
           String query = "INSERT INTO transactions (borrower_id, book_id, transaction_date, due_date, status) VALUES (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'Issued')";
           PreparedStatement ps = con.prepareStatement(query);

           ps.setInt(1, transactions.getBorrowerId()); 
           ps.setInt(2, transactions.getBookId());    

           int result = ps.executeUpdate();
           return result > 0;
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
        }
        return false;
    }
  
   //transactions UPDATE/RETURN.
   @Override
   public boolean returnBook(Transactions transactions) {
     try(Connection con = getConnection()){
            con.setAutoCommit(false);
            
           //Deleting from issuedbooks table in DB.
           String deleteQuery = "DELETE FROM issuedbooks WHERE transaction_id = ?";
           PreparedStatement ps = con.prepareStatement(deleteQuery);
           
           ps.setInt(1, transactions.getTransactionId());
           ps.executeUpdate();
           
           //inserting updated data to returnbooks BD table.
           String insertQuery = "INSERT INTO returned_books (transaction_id, borrower_id, book_id, date_returned, status) " +
                     "SELECT transaction_id, borrower_id, book_id, NOW(), 'Returned' FROM transactions WHERE transaction_id = ? " +
                     "AND NOT EXISTS (SELECT 1 FROM returned_books WHERE transaction_id = ?)";
            PreparedStatement ps2 = con.prepareStatement(insertQuery);
            ps2.setInt(1, transactions.getTransactionId());
            ps2.setInt(2, transactions.getTransactionId()); // Second parameter to avoid duplication.

            int result = ps2.executeUpdate();
            
            con.commit();//apply changes
            return result > 0;


           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
        }
        return false;
    }


    
    //trnsactions DELETE.
    @Override
    public boolean deleteTransaction(Transactions transactions){
        try(Connection con = getConnection()){
            String query = "UPDATE transactions SET deleted_at = NOW() WHERE transactions_id = ?";
            try(PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, transactions.getTransactionId());
                int result = ps.executeUpdate();
                
                return result > 0;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return issuedBooksList;
    }
    
    //return FETCH RETURNED BOOKS.
    public List<ReturnedBooks> getReturnedBooks(){
        List<ReturnedBooks> returnedBooksList = new ArrayList<>();
        String query = "SELECT * FROM returned_books";
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ReturnedBooks returnedBooks = new ReturnedBooks(
                        rs.getInt("transaction_id"),
                        rs.getInt("borrower_id"),
                        rs.getInt("book_id"),
                        rs.getTimestamp("date_returned"),
                        rs.getString("status")
                );
                
                returnedBooksList.add(returnedBooks);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return returnedBooksList;
    }
    
    public List<OverdueBooks> getOverdueBooks(){
        List<OverdueBooks> overdueBooksList = new ArrayList<>();
        String query = "SELECT * FROM overduebooks";
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                OverdueBooks overdueBooks = new OverdueBooks(
                        rs.getInt("transaction_id"),
                        rs.getInt("borrower_id"),
                        rs.getInt("book_id"),
                        rs.getTimestamp("issue_date"),
                        rs.getTimestamp("due_date"),
                        rs.getTimestamp("days_overdue"),
                        rs.getInt("fine_amount"),
                        rs.getString("status")
                );
                
                overdueBooksList.add(overdueBooks);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the Database occur!","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return overdueBooksList;
    }
    
    public int getRecordCount(String tableName) {
        int count = 0;
        String query = "SELECT COUNT(*) AS count FROM " + tableName;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
