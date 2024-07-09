package homework.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  @Schema(name = "Имя читателя")
  private String name;
  @Column
  @Schema(name = "Фамилия читателя")
  private String lastname;

  public Reader(String name) {
    this(sequence++, name);
  }

  public Reader(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
