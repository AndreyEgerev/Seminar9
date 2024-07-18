package homework.controllers;

import homework.api.Book;
import homework.repository.BookRepository;
import homework.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class BooksControllerTest extends JUnitSpringBootBase{

    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    WebTestClient webTestClient;

    @Test
    void getBookById() {
        log.info("test1");
        Book book = new Book(1L,"Test");
        log.info(book.toString());

        Book newBook = bookRepository.save(book);//bookService.addBook(book);
        log.info(newBook.toString());
        Book responseBook = webTestClient.get()
                .uri("/books/{}", newBook.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();
        log.info(responseBook.toString());
        Assertions.assertEquals(newBook.getId(),responseBook.getId());
    }

    @Test
    void getBooks() {
    }

    @Test
    void createBook() {
    }

    @Test
    void deleteBook() {
        Book book = new Book(1L,"Test");
        bookRepository.save(book);
        log.info(book.toString());
        webTestClient.delete()
                .uri("/book/{}", book.getId())
                .exchange()
                .expectStatus().isNoContent();
        assertNull(bookService.getBookById(book.getId()));
    }
}