package codesquad.todolist.travelers.history.service;

import codesquad.todolist.travelers.history.domain.dto.response.ActionHistoryResponseDto;
import codesquad.todolist.travelers.history.domain.entity.History;
import codesquad.todolist.travelers.history.domain.repository.HistoryRepository;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<ActionHistoryResponseDto> getAllHistory() {
        return historyRepository.findAll().stream()
                .map(ActionHistoryResponseDto::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public void saveHistory(){
    }
}
