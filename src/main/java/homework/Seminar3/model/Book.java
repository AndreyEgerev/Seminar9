package homework.Seminar3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name = "book")
@Data
@RequiredArgsConstructor
public class Book {

  public static long sequence = 1L;
  @Id
  private Long id;
  @Column(name = "name")
  private String name;

  public Book(String name) {
    this(sequence++, name);
  }

  public Book(long id, String name) {
    this.id = id;
    this.name = name;
  }
}
