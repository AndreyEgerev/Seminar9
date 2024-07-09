package homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import homework.api.Issue;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IssuesRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByReaderIdAndReturnedTimestamp(Long readerId, LocalDateTime returnedTime);

}
