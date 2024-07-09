package homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import homework.api.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
