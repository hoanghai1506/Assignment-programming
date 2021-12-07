/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibook.bookinformation;

import java.util.Scanner;

/**
 *
 * @author hoanghai
 */
public class Book {

    private String id;
    private String namebook;
    private String author;
    private String language;
    private Double price;
    private String publicDate;

    public Book() {
    }

    public Book(String id, String namebook, String author, String language, Double price, String publicDate) {
        this.id = id;
        this.namebook = namebook;
        this.author = author;
        this.language = language;
        this.price = price;
        this.publicDate = publicDate;
    }
    public Book input(Scanner sc){
        System.out.println("Enter Book id:");
        String id=sc.nextLine();
        
        System.out.println("Enter Name Book:");
        String name =sc.nextLine();
        System.out.println("Enter author");
        String author =sc.nextLine();
        System.out.println("Enter Language: ");
        String langhuge = sc.nextLine();
        System.out.println("Enter price: ");
        double price=sc.nextDouble();sc.nextLine();
        System.out.println("Enter publicdate");
        String date = sc.nextLine();
        return new Book(id,name,author,langhuge,price,date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", namebook=" + namebook + ", author=" + author + ", language=" + language + ", price=" + price + ", publicDate=" + publicDate + '}';
    }
    public String toString1() {
        return ( id + "," + namebook + "," + author + "," + language + "," + price + "," + publicDate ) ;
    }

}
