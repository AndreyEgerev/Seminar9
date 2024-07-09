package homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import homework.api.Book;

//@Data
//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
