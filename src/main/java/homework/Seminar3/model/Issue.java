package homework.Seminar3.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Выдача книг")
public class Issue {

  public static long sequence = 1L;
  @Id
  @Schema(name = "ID")
  private Long id;
  @Column
  @Schema(name = "ID книги")
  private Long bookId;
  @Column
  @Schema(name = "ID читателя")
  private Long readerId;
  @Column
  @Schema(name = "Дата выдачи")
  private LocalDateTime timestamp;
  @Column
  @Schema(name = "Дата возврата")
  private LocalDateTime returnedTimestamp;

  public Issue(long bookId, long readerId) {
    this.id = sequence++;
    this.bookId = bookId;
    this.readerId = readerId;
    this.timestamp = LocalDateTime.now();
  }

}
