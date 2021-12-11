
package ibook.controler;

import ibook.bookDataservice.service;
import ibook.bookinformation.Book;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bookManager {


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
    // edit book
    public void editName(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NameBook:");
        String newname = sc.nextLine();
        books.setNamebook(newname);
    }
    public void editAuthor(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name author:");
        String newauthor = sc.nextLine();
        books.setAuthor(newauthor);
    }
    public void editLanguage(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter language:");
        String newlanguage = sc.nextLine();
        books.setLanguage(newlanguage);
    }
    public void editPrice(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new price:");
        Double newprice = sc.nextDouble();
        books.setPrice(newprice);
    }
     public void editDate(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date:");
        String newdate = sc.nextLine();
        books.setPublicDate(newdate);
    }
      public void editISBN(String id) {
        Book books = findById(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ISBN:");
        String newnisbn = sc.nextLine();
        books.setIsbn(newnisbn);
    }

    public void addBook(Scanner sc) {
        list.add(new Book().input(sc));
    }
    public void write(String path) throws IOException {
        Service.write(path, list);
    }
}
