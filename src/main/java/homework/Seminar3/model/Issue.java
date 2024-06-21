package homework.Seminar3.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
// @Entity
public class Issue {

  public static long sequence = 1L;

  private final Long id;
  private final Long bookId;
  private final Long readerId;

  /**
   * Дата выдачи
   */
  private final LocalDateTime timestamp;
  private LocalDateTime returnedTimestamp;

  public Issue(long bookId, long readerId) {
    this.id = sequence++;
    this.bookId = bookId;
    this.readerId = readerId;
    this.timestamp = LocalDateTime.now();
  }

}
