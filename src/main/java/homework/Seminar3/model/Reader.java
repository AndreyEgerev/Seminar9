package homework.Seminar3.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Reader {

  public static long sequence = 1L;

  private Long id;
  private String name;

  public Reader(String name) {
    this(sequence++, name);
  }

  public Reader(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
