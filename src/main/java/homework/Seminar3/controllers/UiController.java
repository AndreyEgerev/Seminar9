package homework.Seminar3.controllers;

import homework.Seminar3.model.Book;
import homework.Seminar3.model.Issue;
import homework.Seminar3.model.Reader;
import homework.Seminar3.service.BookService;
import homework.Seminar3.service.IssuerService;
import homework.Seminar3.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/ui")
public class UiController {
    @Autowired
    BookService bookService;
    @Autowired
    ReaderService readerService;
    @Autowired
    IssuerService issuerService;


    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/readers")
    public String getAllReader(Model model) {
        List<Reader> readers = readerService.getAllReader();
        model.addAttribute("readers", readers);
        return "readers";
    }

    @GetMapping("/issues")
    public String getAllIssue(Model model) {
        model.addAttribute("issues", issuerService.getAllIssue());
        return "issues";
    }

    @GetMapping("/readers/{id}")
    public String getIssueById(Model model, @PathVariable Long id) {
        Reader reader = readerService.getReaderById(id);
        if (reader == null) {
            throw new NoSuchElementException("читатель не найден");
        }
        List<Issue> issues = issuerService.getIssuesByIdReader(id);
        model.addAttribute("id", reader.getId());
        model.addAttribute("name", reader.getName());
        model.addAttribute("issues", issues);
        return "readerId";
    }



}
