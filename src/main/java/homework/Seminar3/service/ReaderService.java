package homework.Seminar3.service;

import homework.Seminar3.model.Issue;
import homework.Seminar3.model.Reader;
import homework.Seminar3.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private IssuerService issuerService;

    public Reader getReaderById(long id) {
        return readerRepository.getReaderById(id);
    }

    public void deleteReaderById(Long id) {
        readerRepository.deleteReaderById(id);
    }
    public Reader addReader(Reader reader) {
        return readerRepository.addReader(reader);
    }

    public Reader updateReaderById(Long id, Reader reader) {
        return readerRepository.updateReader(id, reader);
    }

    public List<Issue> getIssueByIdReader(Long id) {
        return issuerService.getIssuesByIdReader(id);
    }
}
