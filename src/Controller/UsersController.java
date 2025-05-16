package Controller;

import Database.DatabaseOperations;
import Database.SQLDatabaseManager;
import Models.Users;
import java.util.List;
import java.sql.*;

public class UsersController {
    private static DatabaseOperations dbo = new DatabaseOperations();
    
    public static boolean addUser(Users users) {
        return dbo.addUser(users);
    }
   
    public static List<Users> getUser() {
        return dbo.getUser();
    }
     
    // Updated method: accepts an int userId rather than a String.
    public static Users getLoggedInUser(int userId) {
        return dbo.getLoggedInUser(userId);
    }
    
    public static boolean updateUserInfo(Users users) {
        return dbo.updateUserInfo(users);
    }
    public static Users getUserByUsername(String username) {
    Users user = null;
    try (Connection conn = SQLDatabaseManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE username = ?")) {
        
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            user = new Users(
                rs.getInt("user_id"),         // Store userId for session
                rs.getString("full_name"),
                rs.getString("email"),
                rs.getLong("phone"),
                rs.getString("address"),
                rs.getString("username"),
                rs.getString("password")     // Hashed password for security
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}

}
