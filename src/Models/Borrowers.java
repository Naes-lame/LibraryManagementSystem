/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Timestamp;

public class Borrowers {
    private int borrowerId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Timestamp membershipDate;
    
    public Borrowers(int borrowerId, String name, String address, String phone, String email, Timestamp membershipDate){
        this.borrowerId = borrowerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.membershipDate = membershipDate;
    }
    
    public int getBorrowerId (){
        return borrowerId;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAddress (){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public Timestamp getMembershipDate(){
        return membershipDate;
    }
}
