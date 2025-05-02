/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseOperations;
import Models.Users;

public class AccountController {
    private static final DatabaseOperations dbo = new DatabaseOperations();
    
    public static Users getLoggedInUser(String username) {
        return dbo.getLoggedInUser(username);
    }
}
