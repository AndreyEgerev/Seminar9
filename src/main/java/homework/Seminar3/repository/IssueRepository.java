package homework.Seminar3.repository;

import org.springframework.stereotype.Repository;
import homework.Seminar3.model.Issue;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {

  private final List<Issue> issues;

  public IssueRepository() {
    this.issues = new ArrayList<>();
  }

  public void save(Issue issue) {
    // insert into ....
    issues.add(issue);
  }

  public Issue getIssueById(long id) {
    return issues.stream()
            .filter(it -> Objects.equals(it.getId(), id))
            .findFirst()
            .orElse(null);
  }

  public List<Issue> getIssuesByIdReader(Long id) {
    return issues.stream()
            .filter(issue -> issue.getReaderId().equals(id))
            .filter(issue -> issue.getReturnedTimestamp() == null)
            .toList();
  }

  public Issue returnedIssue(Long id) {
    return issues.stream()
            .filter(issue -> issue.getId().equals(id))
            .peek(issue -> issue.setReturnedTimestamp(LocalDateTime.now()))
            .findFirst()
            .orElse(null);
  }

  public List<Issue> getAllIssues() {
    return List.copyOf(issues);
  }

}
