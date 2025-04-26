/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseOperations;
import Models.*;
import java.util.List;
public class UsersController {
    private  static DatabaseOperations dbm = new DatabaseOperations();
    
   public static boolean addUser(Users users){
        return dbm.addUser(users);
    }
   
   public static List<Users> getUser(){
       return dbm.getUser();
   }
    
}
