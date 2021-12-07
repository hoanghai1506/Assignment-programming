
import ibook.bookDataservice.service;
import ibook.bookinformation.Book;
import ibook.controler.bookManager;
import java.io.IOException;
//import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author hoanghai
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String choose = null;
        String choose1 = null;
        boolean exit = false;
        bookManager bookmanager = new bookManager("./resouces/book.txt");
        service services = new service();
        List<Book> books = services.read("./resouces/book.txt");
        Showmenu();
        while (true) {
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Add book");
                    bookmanager.addBook(sc);
                    services.write("./resouces/book.txt", books);
                    break;
                case "2":
                    System.out.println("Edit book");
                    System.out.println("Enter id");
                    String bookid = sc.nextLine();
                    sc.nextLine();
                    bookmanager.edit(bookid);
                    break;
                case "3":
                    System.out.println("Delete book");
                    System.out.println("Enter id:");
                    bookid = sc.nextLine();
                    sc.nextLine();
                    bookmanager.deleteStudent(bookid);
                    services.write("./resouces/book.txt", books);
                    break;
                case "4":
                    menusort();
                    while (true) {
                        choose = sc.nextLine();
                        switch (choose) {
                            case "1":
                                bookmanager.sortById();
                                System.out.println( bookmanager.toString());
                                break;
                            case "2":
                                bookmanager.sortByName();
                                break;
                            case "3":
                                bookmanager.sortByPrice();
                                break;
                            case "4":
                                bookmanager.sortByDate();
                                break;
                            case "0":
                                System.out.println("Exited");
                                exit = true;
                                break;
                            default:
                                System.out.println("Please choose again!");
                                break;
                        }
                        if (exit) {
                            break;
                        }
                    }
                    Showmenu();
                    continue;

                case "5":
                    menufind();
                    while (true) {
                        choose1 = sc.nextLine();
                        switch (choose1) {
                            case "1":
                                System.out.println("Enter Id:");
                                bookid = sc.nextLine();
                                bookmanager.findById(books, bookid);
                                break;
                            case "2":
                                System.out.println("Enter name:");
                                String name = sc.nextLine();
                                bookmanager.findByName(books, name);
                                break;
                            case "0":
                                System.out.println("Exited");
                                exit = true;
                                break;
                            default:
                                System.out.println("Please choose again!");
                                break;
                        }
                        if (exit) {
                            break;
                        }
                    }
                    Showmenu();
                    continue;
                case "6":
                    bookmanager.showAll();
                    break;
                case "0":
                    System.out.println("Exited");
                    exit = true;
                    break;
                default:
                    System.out.println("Please choose again!");
                    break;
            }
            if (exit) {
                break;
            }
            Showmenu();
        }
    }

    public static void Showmenu() {
        System.out.println("----------------------------Menu-------------------------");
        System.out.println("1.Add book");
        System.out.println("2.Edit book");
        System.out.println("3.Delete book");
        System.out.println("4.Sort");
        System.out.println("5.find");
        System.out.println("6.show all book");
        System.out.println("0.exit");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Please choose");
    }

    public static void menusort() {
        System.out.println("--------------------------sort------------------------------");
        System.out.println("1.sort by Id");
        System.out.println("2.sort by name");
        System.out.println("3.sort by price");
        System.out.println("4.sort by public date");
        System.out.println("0.exit");
        System.out.println("------------------------------------------------------------");
    }

    public static void menufind() {
        System.out.println("----------------------------find---------------------------");
        System.out.println("1.Find by Id");
        System.out.println("2.Find by name");
        System.out.println("0.Exit");
        System.out.println("------------------------------------------------------------");
    }
}
