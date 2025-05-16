package Controller;

import Database.DatabaseOperations;
import Models.Users;
import java.util.List;

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
}
