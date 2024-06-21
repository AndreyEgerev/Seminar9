package homework.Seminar3.service;

import homework.Seminar3.model.Book;
import homework.Seminar3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteBook(id);
    }
    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public Book updateBookById(Long id, Book book) {
        return bookRepository.updateBook(id, book);
    }
}
