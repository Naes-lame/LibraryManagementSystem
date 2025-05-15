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
        try (Connection con = getConnection()) {
            String checkQuery = "SELECT COUNT(*) FROM user WHERE full_name = ? AND email = ? AND phone = ? AND address = ? AND username = ?";//checking for duplication
            PreparedStatement check = con.prepareStatement(checkQuery);
            check.setString(1, users.getFullName());
            check.setString(2, users.getEmail());
            check.setLong(3, users.getPhoneNum());
            check.setString(4, users.getAddress());
            check.setString(5, users.getUsername());
            ResultSet rs = check.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "User is already registered!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String query = "INSERT INTO user  (full_name, email, phone, address, username, password) VALUES ( ?, ?, ?, ?, ?, ?)";//adding new user
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, users.getFullName());
            ps.setString(2, users.getEmail());
            ps.setLong(3, users.getPhoneNum());
            ps.setString(4, users.getAddress());
            ps.setString(5, users.getUsername());
            ps.setString(6, users.getPassword());

            int result = ps.executeUpdate();

            return result > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }
    //user/admin RETRIEVE.

    public List<Users> getUser() {
        List<Users> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users user = new Users(
                        rs.getInt("user_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getLong("phone"),
                        rs.getString("address"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                userList.add(user);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return userList;
    }

    //books ADD
    @Override
    public boolean addBook(Books books) {
        try (Connection con = getConnection()) {
            String checkQuery = " SELECT COUNT(*) FROM bookrecords WHERE book_title = ? AND Author = ? AND Genre = ? AND ISBN = ?";
            PreparedStatement check = con.prepareStatement(checkQuery);
            check.setString(1, books.getTitle());
            check.setString(2, books.getAuthor());
            check.setString(3, books.getGenre());
            check.setString(4, books.getIsbn());

            ResultSet rs = check.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Book already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            String query = "INSERT INTO bookrecords (book_title, Author, Genre, ISBN, Quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, books.getTitle());
            ps.setString(2, books.getAuthor());
            ps.setString(3, books.getGenre());
            ps.setString(4, books.getIsbn());
            ps.setInt(5, books.getQuantity());

            int result = ps.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Books books) {
        try (Connection con = getConnection()) {
            String query = "UPDATE bookrecords SET book_title = ?, Author = ?, Genre = ?, ISBN = ?, Quantity = ? WHERE book_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, books.getTitle());
            ps.setString(2, books.getAuthor());
            ps.setString(3, books.getGenre());
            ps.setString(4, books.getIsbn());
            ps.setInt(5, books.getQuantity());
            ps.setInt(6, books.getBookId()); 

            System.out.println("Executing update query for book_id: " + books.getBookId()); // Debugging print

            int result = ps.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database!", "Error", JOptionPane.ERROR_MESSAGE);
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
    public List<Books> getBooks() {
        List<Books> bookList = new ArrayList<>();
        String query = "SELECT * FROM bookrecords WHERE deleted_at IS NULL";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("book_id");
                String title = rs.getString("book_title");
                String author = rs.getString("Author");
                String genre = rs.getString("Genre");
                String isbn = rs.getString("ISBN");
                int quantity = rs.getInt("Quantity");

                bookList.add(new Books(id, title, author, genre, isbn, quantity)); 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return bookList;
    }


    //borrower ADD.
    @Override
    public boolean addBorrower(Borrowers borrowers) {
        try (Connection con = getConnection()) {
            String checkQuery = "SELECT COUNT(*) FROM borrowerrecords WHERE borrower_name = ? AND Address = ? AND Phone = ? AND Email = ? ";
            PreparedStatement check = con.prepareStatement(checkQuery);

            check.setString(1, borrowers.getName());
            check.setString(2, borrowers.getAddress());
            check.setString(3, borrowers.getPhone());
            check.setString(4, borrowers.getEmail());

            ResultSet rs = check.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Borrower already existed!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String query = "INSERT INTO borrowerrecords (borrower_name, Address, Phone, Email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, borrowers.getName());
            ps.setString(2, borrowers.getAddress());
            ps.setString(3, borrowers.getPhone());
            ps.setString(4, borrowers.getEmail());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }

    //borowers UPDATE.
    @Override
    public boolean updateBorrower(Borrowers borrowers) {
        try (Connection con = getConnection()) {
            String query = "UPDATE borrowerrecords SET borrower_name = ?, Address = ?, Phone = ?, Email = ? WHERE borrower_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, borrowers.getName());
            ps.setString(2, borrowers.getAddress());
            ps.setString(3, borrowers.getPhone());
            ps.setString(4, borrowers.getEmail());
            ps.setInt(5, borrowers.getBorrowerId());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBorrower(Borrowers borrowers) {
        try (Connection con = getConnection()) {
            String query = "UPDATE borrowerrecords SET deleted_at = NOW() WHERE borrower_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, borrowers.getBorrowerId());
                int result = ps.executeUpdate();

                return result > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;
    }

    //borrowers FETCH
    public List<Borrowers> getBorrower() {
        List<Borrowers> borrowerList = new ArrayList<>();
        String query = "SELECT * FROM borrowerrecords WHERE deleted_at IS NULL";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Borrowers borrowers = new Borrowers(
                        rs.getInt("borrower_id"),
                        rs.getString("borrower_name"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getTimestamp("membership_date")
                );
                borrowerList.add(borrowers);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return borrowerList;
    }

    //transactions ADD/IISUE.
    @Override
    public boolean issueBook(Transactions transactions) {
        try (Connection con = getConnection()) {
            String checkQuery = "SELECT status FROM transactions WHERE borrower_name = ? AND book_title = ? ORDER BY transaction_date DESC LIMIT 1";
            PreparedStatement check = con.prepareStatement(checkQuery);

            check.setString(1, transactions.getBorrowerName());
            check.setString(2, transactions.getBookTitle());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                String status = rs.getString("status");
                if ("Issued".equalsIgnoreCase(status)) {
                    JOptionPane.showMessageDialog(null, "This book is already issued and has not been returned yet!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else if (!"Returned".equalsIgnoreCase(status)) {
                    JOptionPane.showMessageDialog(null, "This book must be returned first before re-issuing!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            String query = "INSERT INTO transactions (borrower_name, book_title, transaction_date, due_date, status) VALUES (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'Issued');";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, transactions.getBorrowerName());
            ps.setString(2, transactions.getBookTitle());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return false;                                      
    }

    
    @Override
    public boolean updateStatToReturn(int transactionId) {
        try (Connection con = getConnection()) {
            // Check if transaction is already marked as "Returned"
            String checkQuery = "SELECT status FROM transactions WHERE transaction_id = ?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setInt(1, transactionId);

            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && "Returned".equals(rs.getString("status"))) {
                return false; // Prevent unnecessary update
            }

            // Proceed with update
            String query = "UPDATE transactions SET status = ? WHERE transaction_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "Returned");
            ps.setInt(2, transactionId);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean transferToReturnTbl(int transactionId) {
        try (Connection con = getConnection()) {
            String query = "INSERT INTO returned_books (transaction_id, borrower_name, book_title, date_returned, status) "
                    + "SELECT transaction_id, borrower_name, book_title, NOW(), 'Returned' "
                    + "FROM transactions t WHERE transaction_id = ? AND NOT EXISTS "
                    + "(SELECT 1 FROM returned_books rb WHERE rb.transaction_id = t.transaction_id)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, transactionId);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {

        }
        return false;
    }
    @Override
    public boolean deleteFromIssuedTbl(int transactionId) {
        try (Connection con = getConnection()) {
            String query = "DELETE FROM issuedbooks WHERE transaction_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, transactionId);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean returnBook(Transactions transactions) {
        try (Connection con = getConnection()) {
            String query = "UPDATE transactions SET borrower_name = ?, book_title = ?, transaction_date = ?,status = ? WHERE transaction_id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, transactions.getBorrowerName());
            ps.setString(2, transactions.getBookTitle());
            ps.setTimestamp(3, transactions.getTransactionDate());
            ps.setString(4, "Returned");
            ps.setInt(5, transactions.getTransactionId());

            int result = ps.executeUpdate();
            updateStatToReturn(transactions.getTransactionId());
            transferToReturnTbl(transactions.getTransactionId());
            deleteFromIssuedTbl(transactions.getTransactionId());
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




    //transactions FETCH DATA.
    public List<Transactions> getTransaction() {
        List<Transactions> transactionList = new ArrayList<>();
        String query = "SELECT * FROM transactions";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transactions transaction = new Transactions(
                        rs.getInt("transaction_id"),
                        rs.getString("borrower_name"),
                        rs.getString("book_title"),
                        rs.getTimestamp("transaction_date"),
                        rs.getTimestamp("due_date"),
                        rs.getString("status")
                );
                transactionList.add(transaction);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return transactionList;
    }

    //issued books FETCH DATA.
    public List<IssuedBooks> getIssuedBooks() {
        List<IssuedBooks> issuedBooksList = new ArrayList<>();
        String query = "SELECT * FROM issuedbooks";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IssuedBooks issuedBooks = new IssuedBooks(
                        rs.getInt("transaction_id"),
                        rs.getString("borrower_name"),
                        rs.getString("book_title"),
                        rs.getTimestamp("issue_date"),
                        rs.getTimestamp("due_date"),
                        rs.getString("status")
                );
                issuedBooksList.add(issuedBooks);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return issuedBooksList;
    }

    //return FETCH RETURNED BOOKS.
    public List<ReturnedBooks> getReturnedBooks() {
        List<ReturnedBooks> returnedBooksList = new ArrayList<>();
        String query = "SELECT * FROM returned_books";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ReturnedBooks returnedBooks = new ReturnedBooks(
                        rs.getInt("transaction_id"),
                        rs.getString("borrower_name"),
                        rs.getString("book_title"),
                        rs.getTimestamp("date_returned"),
                        rs.getString("status")
                );

                returnedBooksList.add(returnedBooks);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in the Database occur!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return returnedBooksList;
    }

    public int getRecordCount(String tableName) {
        int count = 0;
        String query = "SELECT COUNT(*) AS count FROM " + tableName;

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Users getLoggedInUser(String username) {
        Users user = null;
        try (Connection con = getConnection()) {
            String query = "SELECT * FROM user WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new Users(
                    rs.getInt("user_id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getLong("phone"),
                    rs.getString("address"),
                    rs.getString("username"),
                    rs.getString("password")
                );

                SessionManager.setLoggedInUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving user data!", "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean updateUserInfo(Users users){
        try(Connection con = getConnection()){
            String updateQuery = "UPDATE user SET full_name = ?, email = ?, phone = ?, address = ?,username = ?, password = ? WHERE user_id = ? ";
            PreparedStatement ps = con.prepareStatement(updateQuery);
            
            ps.setString(1, users.getFullName());
            ps.setString(2, users.getEmail());
            ps.setLong(3, users.getPhoneNum());  // Phone should be a long/int
            ps.setString(4, users.getAddress());
            ps.setString(5, users.getUsername());
            ps.setString(6, users.getPassword());
            ps.setInt(7, users.getUserId());
            System.out.println("Executing query: " + ps);
            int result = ps.executeUpdate();
            
            return result > 0;
            
        } catch(SQLException e) {
            e.printStackTrace();  // Prints full error details in the terminal
            JOptionPane.showMessageDialog(null, "Failed to update admin info!\nError: " + e.getMessage(), 
            "Database Error", JOptionPane.ERROR_MESSAGE);
        }   return false;
    }
}
