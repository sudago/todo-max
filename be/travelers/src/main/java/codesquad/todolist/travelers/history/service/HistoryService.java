package codesquad.todolist.travelers.history.service;

import codesquad.todolist.travelers.history.domain.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void deleteAllHistory() {
        historyRepository.deleteAll();
    }
}
