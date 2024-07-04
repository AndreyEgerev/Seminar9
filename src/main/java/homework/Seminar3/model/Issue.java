package homework.Seminar3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
@Entity
@Table(name = "issue")
@RequiredArgsConstructor
public class Issue {

  public static long sequence = 1L;
  @Id
  private Long id;
  @Column
  private Long bookId;
  @Column
  private Long readerId;
  @Column
  private LocalDateTime timestamp;
  @Column
  private LocalDateTime returnedTimestamp;

  public Issue(long bookId, long readerId) {
    this.id = sequence++;
    this.bookId = bookId;
    this.readerId = readerId;
    this.timestamp = LocalDateTime.now();
  }

}
