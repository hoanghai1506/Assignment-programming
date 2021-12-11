
import ibook.bookinformation.Book;
import ibook.controler.bookManager;
import java.io.IOException;
import java.util.Scanner;

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
        Showmenu();
        while (true) {
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Add book");
                    bookmanager.addBook(sc);
                    System.out.println("Successfull !");
                    bookmanager.write("./resouces/book.txt");
                    break;
                case "2":
                    menuedit();
                    while (true) {
                        choose = sc.nextLine();
                        switch (choose) {
                            case "1":
                                System.out.println("Enter ID book");
                                String bookid = sc.nextLine();
                                System.out.println("Edit Name");
                                bookmanager.editName(bookid);
                                System.out.println("Successfull !");
                                break;
                            case "2":
                                System.out.println("Enter ID book");
                                bookid = sc.nextLine();
                                System.out.println("Edit author");
                                bookmanager.editAuthor(bookid);
                                System.out.println("Successfull !");
                                break;
                            case "3":
                                System.out.println("Enter ID book");
                                bookid = sc.nextLine();
                                System.out.println("Edit language");
                                bookmanager.editLanguage(bookid);
                                System.out.println("Successfull !");
                                break;
                            case "4":
                                System.out.println("Enter ID book");
                                bookid = sc.nextLine();
                                System.out.println("Edit pirce");
                                bookmanager.editPrice(bookid);
                                System.out.println("Successfull !");
                                break;
                            case "5":
                                System.out.println("Enter ID book");
                                bookid = sc.nextLine();
                                System.out.println("Edit public Date");
                                bookmanager.editDate(bookid);
                                System.out.println("Successfull !");
                                break;
                            case "6":
                                System.out.println("Enter ID book");
                                bookid = sc.nextLine();
                                System.out.println("Edit ISBN");
                                bookmanager.editISBN(bookid);
                                System.out.println("Successfull !");
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
                case "3":
                    System.out.println("Delete book");
                    System.out.println("Enter id:");
                    String bookid = sc.nextLine();
                    sc.nextLine();
                    bookmanager.deleteStudent(bookid);
                    System.out.println("Successfull !");
                    bookmanager.write("./resouces/book.txt");
                    break;
                case "4":
                    menusort();
                    while (true) {
                        choose = sc.nextLine();
                        switch (choose) {
                            case "1":
                                System.out.println("Sort By Id");
                                bookmanager.sortById();
                                bookmanager.showAll();
                                System.out.println("------------------------------------------------------------");
                                break;
                            case "2":
                                System.out.println("Sort By Name");
                                bookmanager.sortByName();
                                bookmanager.showAll();
                                System.out.println("------------------------------------------------------------");
                                break;
                            case "3":
                                System.out.println("Sort By Price");
                                bookmanager.sortByPrice();
                                bookmanager.showAll();
                                System.out.println("------------------------------------------------------------");
                                break;
                            case "4":
                                System.out.println("Sort By Date");
                                bookmanager.sortByDate();
                                bookmanager.showAll();
                                System.out.println("------------------------------------------------------------");
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
                                Book newId = bookmanager.findById(bookid);
                                System.out.println(newId);
                                break;
                            case "2":
                                System.out.println("Enter name:");
                                String name = sc.nextLine();

                                Book newbook = bookmanager.findByName(name);
                                System.out.println(newbook);
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
                    continue;
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
        System.out.println("2.Find by ISBN");
        System.out.println("0.Exit");
        System.out.println("------------------------------------------------------------");
    }

    public static void menuedit() {
        System.out.println("----------------------------edit---------------------------");
        System.out.println("1.Edit Name");
        System.out.println("2.Edit author");
        System.out.println("3.Edit language");
        System.out.println("5.Edit price");
        System.out.println("6.Edit public date");
        System.out.println("7.Edit ISBN");
        System.out.println("------------------------------------------------------------");
    }
}
