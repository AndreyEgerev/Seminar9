package homework.Seminar3.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {

  public static long sequence = 1L;

  private Long id;
  private String name;

  public Book(String name) {
    this(sequence++, name);
  }

  public Book(long id, String name) {
    this.id = id;
    this.name = name;
  }
}
