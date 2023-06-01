package com.shop.dataloader;

import com.shop.db.BookRepository;
import com.shop.db.UserRepository;
import com.shop.model.Book;
import com.shop.model.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Loader {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @SneakyThrows
    @EventListener(classes = {ApplicationReadyEvent.class})
    public void run(){
      log.info("Start loading data...");
        loadUsers();
        loadBooks();

        log.info("Finish loading data...");
    }

    private void loadUsers(){
        List<User> users = new ArrayList<>();
        User admin = new User(
                "admin",
                "qwe",
                "admin"
        );
        users.add(admin);

        //
        User user1 = new User(
                "user1",
                "user1",
                "user1"
        );

        users.add(user1);

        User user2 = new User(
                "user2",
                "user2",
                "user2"
        );
        users.add(user2);

        userRepository.saveAll(users);
    }

    private void loadBooks() throws IOException {
        List<Book> books = new ArrayList<>();

        //Insert 1st book
        Path path1 = Paths.get("D:/photo/book/photo.jpg");
        byte[] bookPhotoBytes1 = Files.readAllBytes(path1);

        Book book1 = new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "9.99",
                bookPhotoBytes1
        );

        books.add(book1);

        //Insert 2d book
        Path path2 = Paths.get("D:/photo/book/photo1.jpg");
        byte[] bookPhotoBytes2 = Files.readAllBytes(path2);

        Book book2 = new Book(
                "To Kill a Mockingbird",
                "Harper Lee",
                "12.50",
                bookPhotoBytes2
        );
        books.add(book2);
        //Insert 3d book
        Path path3 = Paths.get("D:/photo/book/photo2.jpg");
        byte[] bookPhotoBytes3 = Files.readAllBytes(path3);

        Book book3 = new Book(
                "1984",
                "George Orwell",
                "8.99",
                bookPhotoBytes3
        );
        books.add(book3);

        //
        Path path4 = Paths.get("D:/photo/book/photo3.jpg");
        byte[] bookPhotoBytes4 = Files.readAllBytes(path4);

        Book book4 = new Book(
                "Pride and Prejudice",
                "Jane Austen",
                "15.99",
                bookPhotoBytes4
        );
        books.add(book4);

        //

        Path path5 = Paths.get("D:/photo/book/photo4.jpg");
        byte[] bookPhotoBytes5 = Files.readAllBytes(path5);

        Book book5 = new Book(
                "The Catcher in the Rye",
                "J.D. Salinger",
                "10.99",
                bookPhotoBytes5
        );
        books.add(book5);

        //

        Path path6 = Paths.get("D:/photo/book/photo5.jpg");
        byte[] bookPhotoBytes6 = Files.readAllBytes(path6);

        Book book6 = new Book(
                "Moby-Dick",
                "Herman Melville",
                "11.99",
                bookPhotoBytes6
        );
        books.add(book6);
        //
        Path path7 = Paths.get("D:/photo/book/photo6.jpg");
        byte[] bookPhotoBytes7 = Files.readAllBytes(path7);

        Book book7 = new Book(
                "The Lord of the Rings",
                "J.R.R. Tolkien",
                "19.99",
                bookPhotoBytes7
        );
        books.add(book7);

        bookRepository.saveAll(books);
    }
//  ('The Lord of the Rings', 'J.R.R. Tolkien', 19.99, NULL),
//  ('Harry Potter and the Sorcerers Stone', 'J.K. Rowling', 14.99, NULL),
//  ('The Chronicles of Narnia', 'C.S. Lewis', 13.99, NULL),
//  ('The Hitchhiker Guide to the Galaxy', 'Douglas Adams', 9.99, NULL);
}
