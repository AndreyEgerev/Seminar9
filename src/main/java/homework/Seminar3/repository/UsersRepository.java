package homework.Seminar3.repository;

import homework.Seminar3.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByName(String name);
}
