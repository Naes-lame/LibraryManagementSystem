/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//all goods
package Models;

public class Users {

    private static int userId;
    private String fullName;
    private String email;
    private long phoneNum;
    private String address;
    private String username;
    private String password;
    
    public Users(int userId, String fullName, String email, long phoneNum, String address, String username, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public Users() {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.username = username;
        this.password = password;
    }


    public static int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
