/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class Books {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private int quantity;
    
    public Books (int bookId, String title, String author, String genre, String isbn, int quantity){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.quantity = quantity;
    }
    public int getBookId(){
        return bookId;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getIsbn(){
        return isbn;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(){
        this.quantity = quantity;
    }
    
    public static boolean isbnValidation(String isbn){
        //validate isbn legnth.
        if(isbn == null || isbn.length()!= 13){
        return false;
    }
        int sum = 0;//get numbers inputed
        for(int i = 0; i < 13; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));//convert char to int
            sum += (i % 2 == 0)? digit : digit*3;//apply weight rule (even * 1 , odd * 3)
        }
        return sum % 10 == 0;//validate if isbn is divisible by 10.
    }
}
