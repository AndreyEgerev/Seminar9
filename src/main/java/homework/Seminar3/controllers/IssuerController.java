package homework.Seminar3.controllers;

import homework.Seminar3.model.Issue;
import homework.Seminar3.service.IssuerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssuerController {

  @Autowired
  private IssuerService service;


  @PostMapping
  public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
    log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
    final Issue issue;
    try {
      issue = service.issue(request);
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatusCode.valueOf(409));
    }
    return ResponseEntity.status(HttpStatus.OK).body(issue);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Issue> getInfoIssueById(@PathVariable Long id) {
    final Issue issue;
    issue = service.getInfoById(id);
    return issue != null
            ? ResponseEntity.ok(issue)
            : ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Issue> returnedIssue(@PathVariable Long id) {
    Issue reurnedIssue = service.returnedIssue(id);
    return reurnedIssue != null
            ? ResponseEntity.ok(reurnedIssue)
            : ResponseEntity.badRequest().build();
  }

}
