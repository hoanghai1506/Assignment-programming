/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibook.bookDataservice;

import ibook.bookinformation.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoanghai
 */
public class service {

    public List<Book> read(String path) throws IOException {

        List<Book> books = new ArrayList<>();

        // read file
        Path pathFileToRead = Paths.get(path);
        List<String> allLines = Files.readAllLines(pathFileToRead);
        for (int i = 0; i < allLines.size(); i++) {
            String line = allLines.get(i);
            String[] data = line.split(",");
            Book book = new Book(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), Double.parseDouble(data[4]), data[5].trim(), data[6].trim());
            books.add(book);
        }
        return books;
    }

    public void write(String path, List<Book> books) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book bookout = books.get(i);
            list.add(bookout.toString1());
        }
        Path pathFileToWrite = Paths.get(path);
        Files.write(pathFileToWrite, list);

    }
}
