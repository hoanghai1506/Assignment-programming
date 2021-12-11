/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibook.controler;

import ibook.bookDataservice.service;
import ibook.bookinformation.Book;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoanghai
 */
public class bookManager {

    public static void add(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Book> list;
    private final String pathFileToInput;
    private service Service;

    public bookManager(String pathFileToInput) {
        this.pathFileToInput = pathFileToInput;
        this.Service = new service();
        try {
            this.list = Service.read(pathFileToInput);

        } catch (IOException e) {

        }
    }

    // sort
    public void sortByName() {
        Collections.sort(list, (s1, s2) -> s1.getNamebook().compareTo(s2.getNamebook()));
    }

    public void sortById() {
        Collections.sort(list, (s2, s1) -> s1.getId().compareTo(s2.getId()));

    }

    public void sortByathor() {
        Collections.sort(list, (s1, s2) -> s1.getAuthor().compareTo(s2.getAuthor()));
    }

    public void sortByPrice() {
        Collections.sort(list, (s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice()));
    }

    public void sortByDate() {
        Collections.sort(list, (s1, s2) -> s1.getPublicDate().compareTo(s2.getPublicDate()));
    }

    public Book findByName(String name) {
        for (Book s : list) {
            if (s.getNamebook().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public Book findById(String id) {
        for (Book s : list) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Book findByIsbn(String Isbn) {
        for (Book s : list) {
            if (s.getIsbn().equals(Isbn)) {
                return s;
            }
        }
        return null;
    }

    public void showAll() {
        for (Book s : list) {
            System.out.println(s.toString());
        }
    }

    //delete
    public void deleteStudent(String id) {
        Book findById = findById(id);
        list.remove(findById);
    }

    public void edit(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NameBook:");
        String newname = sc.nextLine();
        books.setNamebook(newname);
        System.out.println("Enter Athor");
        String newauthor = sc.nextLine();
        books.setAuthor(newauthor);
        System.out.println("Enter  language:");
        String newlanguage = sc.nextLine();
        books.setLanguage(newlanguage);
        System.out.println("Enter price");
        double newprice = sc.nextDouble();
        books.setPrice(newprice);
        System.out.println("Enter publicDate");
        String newpublicdate = sc.nextLine();
        books.setPublicDate(newpublicdate);
        System.out.println("Enter ISBN");
        String newIsbn=sc.nextLine();
        books.setIsbn(newIsbn);
    }

    public void addBook(Scanner sc) {
        list.add(new Book().input(sc));
    }

    public void write(String path) throws IOException {
        Service.write(path, list);
    }
}
