package homework.Seminar3.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name = "book")
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Book")
public class Book {

  public static long sequence = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Schema(name = "ID")
  private Long id;
  @Column(name = "name")
  @Schema(name = "Название")
  private String name;

  public Book(String name) {
    this(sequence++, name);
  }

  public Book(long id, String name) {
    this.id = id;
    this.name = name;
  }
}
