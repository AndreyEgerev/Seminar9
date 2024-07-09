package homework.service;


import homework.controllers.IssueRequest;
import homework.api.Issue;

import homework.repository.IssuesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IssuerService {

  private final IssuesRepository issueRepository;
  private final ServiceProvider serviceProvider;

  @Value("${application.max-allowed-books:1}")
  private int maxAllowedBooks;


  public Issue issue(IssueRequest request) {
    log.info(request.toString());
    if (serviceProvider.getByIdBook(request.getBookId()).isEmpty()) {
      log.error("Не найдена книга с идентификатором \"{}\"", request.getBookId());
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (serviceProvider.getByIdReader(request.getReaderId()).isEmpty()) {
      log.error("Не найден читатель с идентификатором \"{}\"", request.getReaderId());
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
    if (issueRepository.findByReaderIdAndReturnedTimestamp(request.getReaderId(), null).size() >= maxAllowedBooks) {
      log.error("Отказано в выдаче читателю ID - \"{}\" из-за превышения лимита", request.getReaderId());
      throw new RuntimeException("Отказано в выдаче читателю ID - " + request.getReaderId() + " из-за превышения лимита");
    }
    log.info("Запрос разрешен {}", request);
    Issue issue = new Issue(request.getBookId(), request.getReaderId());
    log.info(issue.toString());
    Issue saveIssue = issueRepository.saveAndFlush(issue);
    log.info(saveIssue.toString());
    return saveIssue;
  }

  public Issue getInfoById(Long id) {
    return issueRepository.getById(id);
  }

  public List<Issue> getIssuesByIdReader(Long id) {
    return issueRepository.findByReaderIdAndReturnedTimestamp(id, null);
  }

  public Issue returnedIssue(Long id) {
    Optional<Issue> returnedIssue = issueRepository.findById(id);
    returnedIssue.get().setReturnedTimestamp(LocalDateTime.now());
    return issueRepository.save(returnedIssue.get());
  }
  public List<Issue> getAllIssue() {
    return issueRepository.findAll();
  }

}
