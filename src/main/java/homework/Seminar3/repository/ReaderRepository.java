package homework.Seminar3.repository;

import homework.Seminar3.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import homework.Seminar3.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

  private final List<Reader> readers;

  public ReaderRepository() {
    this.readers = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    readers.addAll(List.of(
      new homework.Seminar3.model.Reader("Игорь"),
      new homework.Seminar3.model.Reader("Андрей"),
      new homework.Seminar3.model.Reader("Влад")
    ));
  }

  public Reader getReaderById(long id) {
    return readers.stream().filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .orElse(null);
  }

  public void deleteReaderById(Long id) {
    readers.removeIf(book -> book.getId().equals(id));
  }

  public Reader addReader(Reader reader) {
    if (readers.stream().anyMatch(existReader -> existReader.getName().equals(reader.getName())
                                              || existReader.getId().equals(reader.getId()))) {
      return null;
    } else {
      Reader newReader = new Reader(reader.getName());
      readers.add(newReader);
      return newReader;
    }
  }

  public Reader updateReader(Long id, Reader updateReader) {
    return readers.stream()
            .filter(reader -> reader.getId().equals(id))
            .peek(reader -> {reader.setName(updateReader.getName());})
            .findFirst()
            .orElse(null);
  }

  public List<Reader> getAllReader () {
    return List.copyOf(readers);
  }

}
