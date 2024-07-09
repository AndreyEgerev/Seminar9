package homework.service;


import homework.api.Issue;
import homework.api.Reader;
import homework.repository.ReaderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private IssueProvider issueProvider;

    public Reader getReaderById(long id) {
        //return readerRepository.getReaderById(id);
        return readerRepository.findById(id).orElse(null);
    }

    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }
    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader updateReaderById(Long id, Reader reader) {
        Reader updateReader = getReaderById(id);
        updateReader.setName(reader.getName());
        return readerRepository.save(updateReader);
    }

    public List<Issue> getIssueByIdReader(Long id) {
        return issueProvider.getIssuesByIdReader(id);
    }
    public List<Reader> getAllReader() {
        return readerRepository.findAll();
    }
}
