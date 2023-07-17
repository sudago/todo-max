package codesquad.todolist.travelers.history.service;

import codesquad.todolist.travelers.ActionType.ActionType;
import codesquad.todolist.travelers.aspect.dto.TaskServiceHistoryDto;
import codesquad.todolist.travelers.history.domain.dto.response.ActionHistoryResponseDto;
import codesquad.todolist.travelers.history.domain.entity.History;
import codesquad.todolist.travelers.history.domain.repository.HistoryRepository;
import codesquad.todolist.travelers.task.domain.entity.Task;
import codesquad.todolist.travelers.task.domain.repository.TaskRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final TaskRepository taskRepository;

    public HistoryService(HistoryRepository historyRepository, TaskRepository taskRepository) {
        this.historyRepository = historyRepository;
        this.taskRepository = taskRepository;
    }

    public void deleteAllHistory() {
        historyRepository.deleteAll();
    }

    public List<ActionHistoryResponseDto> getAllHistory() {
        return historyRepository.findAll().stream()
                .map(ActionHistoryResponseDto::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public void saveHistory(TaskServiceHistoryDto taskServiceHistoryDto, ActionType actionType) {
        Long taskId = taskServiceHistoryDto.getTaskId();

        TaskServiceHistoryDto updatedTaskServiceHistoryDto = null;

        String fromName;
        String toName;
        //카드 등록할때 taskId가 null 이라 분기처리해야함
        Task task = null;
        if (taskId != null) {
            task = taskRepository.findBy(taskId);
        }

        switch (actionType) {
            case CREATE_TASK:
                fromName = taskRepository.findProcessNameBy(taskServiceHistoryDto.getFromId());
                updatedTaskServiceHistoryDto = TaskServiceHistoryDto.of(taskServiceHistoryDto, actionType, fromName);
                break;
            case DELETE_TASK:
                fromName = taskRepository.findProcessNameBy(task.getProcessId());
                updatedTaskServiceHistoryDto = TaskServiceHistoryDto.of(task, actionType, fromName);
                break;
            case MOVE_TASK:
                fromName = taskRepository.findProcessNameBy(task.getProcessId());
                toName = taskRepository.findProcessNameBy(taskServiceHistoryDto.getToId());
                updatedTaskServiceHistoryDto = TaskServiceHistoryDto.of(task, actionType, fromName, toName);
                break;
            case UPDATE_TASK:
                updatedTaskServiceHistoryDto = TaskServiceHistoryDto.of(task, actionType);
                break;
        }

        History history = updatedTaskServiceHistoryDto.toEntity();
        historyRepository.save(history);
    }
}
