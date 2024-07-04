package homework.Seminar3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import homework.Seminar3.model.Issue;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IssuesRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByReaderIdAndReturnedTimestamp(Long readerId, LocalDateTime returnedTime);
//
//  private final List<Issue> issues;
//
//  public IssueRepository() {
//    this.issues = new ArrayList<>();
//  }
//
//  public void save(Issue issue) {
//    // insert into ....
//    issues.add(issue);
//  }
//
//  public Issue getIssueById(long id) {
//    return issues.stream()
//            .filter(it -> Objects.equals(it.getId(), id))
//            .findFirst()
//            .orElse(null);
//  }
//
//  public List<Issue> getIssuesByIdReader(Long id) {
//    return issues.stream()
//            .filter(issue -> issue.getReaderId().equals(id))
//            .filter(issue -> issue.getReturnedTimestamp() == null)
//            .toList();
//  }
//
//  public Issue returnedIssue(Long id) {
//    return issues.stream()
//            .filter(issue -> issue.getId().equals(id))
//            .peek(issue -> issue.setReturnedTimestamp(LocalDateTime.now()))
//            .findFirst()
//            .orElse(null);
//  }
//
//  public List<Issue> getAllIssues() {
//    return List.copyOf(issues);
//  }

}
