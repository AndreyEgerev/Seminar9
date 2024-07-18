package homework.service;

import homework.api.Book;
import homework.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
//
//    public Book updateBookById(Long id, Book book) {
//        return bookRepository.updateBook(id, book);
//    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
}
