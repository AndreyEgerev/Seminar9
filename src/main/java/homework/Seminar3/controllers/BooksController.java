package homework.Seminar3.controllers;

import homework.Seminar3.model.Book;
import homework.Seminar3.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookService.getBookById(id);
        log.info(book != null ? book.toString() : "none");
    return book != null
            ? ResponseEntity.ok(book)
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        log.info(newBook != null ? newBook.toString() : "none");
        return newBook != null
                ? new ResponseEntity<>(newBook, HttpStatus.CREATED)//ResponseEntity.ok(newBook)
                : ResponseEntity.badRequest().build();
        //new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
