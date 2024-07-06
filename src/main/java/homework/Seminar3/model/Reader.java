package homework.Seminar3.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name = "reader")
@Data
@RequiredArgsConstructor
@Schema(name = "Readers")
public class Reader {

  public static long sequence = 1L;
  @Id
  @Schema(name = "ID")
  private Long id;
  @Column
  @Schema(name = "Имя читателя")
  private String name;

  public Reader(String name) {
    this(sequence++, name);
  }

  public Reader(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
