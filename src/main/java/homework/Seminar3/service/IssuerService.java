package homework.Seminar3.service;

import homework.Seminar3.controllers.IssueRequest;
import homework.Seminar3.model.Issue;

import homework.Seminar3.repository.BookRepository;
import homework.Seminar3.repository.IssueRepository;
import homework.Seminar3.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

  // спринг это все заинжектит
  private final BookRepository bookRepository;
  private final ReaderRepository readerRepository;
  private final IssueRepository issueRepository;

  @Value("${application.max-allowed-books:1}")
  private int maxAllowedBooks;


  public Issue issue(IssueRequest request) {
    if (bookRepository.getBookById(request.getBookId()) == null) {
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (readerRepository.getReaderById(request.getReaderId()) == null) {
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
    if (issueRepository.getIssuesByIdReader(request.getReaderId()).size() >= maxAllowedBooks) {
      throw new RuntimeException("Отказано в выдаче читателю ID - " + request.getReaderId() + " из-за превышения лимита");
    }
    Issue issue = new Issue(request.getBookId(), request.getReaderId());
    issueRepository.save(issue);
    return issue;
  }

  public Issue getInfoById(Long id) {
    return issueRepository.getIssueById(id);
  }

  public List<Issue> getIssuesByIdReader(Long id) {
    return issueRepository.getIssuesByIdReader(id);
  }

  public Issue returnedIssue(Long id) {
    return issueRepository.returnedIssue(id);
  }

}
