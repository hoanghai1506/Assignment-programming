/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibook.controler;

import ibook.bookDataservice.service;
import ibook.bookinformation.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoanghai
 */
public class bookManager {

    private List<Book> list;
    private final String pathFileToInput;
    private service Service;

    public bookManager(String pathFileToInput) {
        this.pathFileToInput = pathFileToInput;
        this.Service = new service();
        try {
            this.list = Service.read(pathFileToInput);
         //  this.list=Service.write(pathFileToInput);
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

    public Book findByName(List<Book> list, String name) {
        for (Book s : list) {
            if (s.getNamebook().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public Book findById(List<Book> list, String id) {
        for (Book s : list) {
            if (s.getId().equals(id)) {
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
        Book findById = findById(list, id);
        list.remove(findById);
    }

    public void edit(String id) {
        Book students = findById(list, id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NameBook:");
        String newname = sc.nextLine();
        students.setNamebook(newname);
        System.out.println("Enter Athor");
        String newClass = sc.nextLine();
        students.setAuthor(newClass);
        System.out.println("Enter  language:");
        String newAdd = sc.nextLine();
        students.setLanguage(newAdd);
        System.out.println("Enter price");
        double newC = sc.nextDouble();
        students.setPrice(newC);
        System.out.println("Enter publicDate");
        String newNetworking = sc.nextLine();
        students.setPublicDate(newNetworking);
    }

    public void addBook(Scanner sc) {
        list.add(new Book().input(sc));
    }
    public void write(String path,List<Book> books) throws IOException{
            List<String> list=new ArrayList<>();
            for( int i=0;i<books.size();i++){
                Book bookout=books.get(i);
                list.add(bookout.toString1());
            }
            Path pathFileToWrite= Paths.get(path);
            Files.write(pathFileToWrite,list);
        
        }
}
