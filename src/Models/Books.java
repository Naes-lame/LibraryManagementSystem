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
    
    public static boolean isbnValidation(String isbn) {
    // Validate length
    if (isbn == null || isbn.length() != 13) {
        return false;
    }

    int sum = 0;
    // Loop through each digit
    for (int i = 0; i < 13; i++) {
        char ch = isbn.charAt(i);
        if (!Character.isDigit(ch)) return false; // Ensure all characters are digits
        
        int digit = Character.getNumericValue(ch); // Convert char to integer

        // Apply weight rule: odd positions (index 0, 2, 4...) *1, even positions (index 1, 3, 5...) *3
        sum += (i % 2 == 0) ? digit : digit * 3;
    }

    // ISBN-13 is valid if sum is divisible by 10
    return (sum % 10 == 0);
}

}
