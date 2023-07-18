package codesquad.todolist.travelers.process.service;

import codesquad.todolist.travelers.process.domain.repository.ProcessRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private final ProcessRepository processRepository;

    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

}
