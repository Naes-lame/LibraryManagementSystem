/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseOperations;
import Models.*;
import java.util.List;
public class UsersController {
    private  static DatabaseOperations dbo = new DatabaseOperations();
    
    public static boolean addUser(Users users){
        return dbo.addUser(users);
    }
   
     public static List<Users> getUser(){
       return dbo.getUser();
   }
     
   public static Users getLoggedInUser(String username) {
        return dbo.getLoggedInUser(username);
    }
    public static boolean updateUserInfo(Users users){
        return dbo.updateUserInfo(users);
    }  
    
}
