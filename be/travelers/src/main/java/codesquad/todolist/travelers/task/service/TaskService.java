package codesquad.todolist.travelers.task.service;

import codesquad.todolist.travelers.ActionType.ActionType;
import codesquad.todolist.travelers.annotation.ActionId;
import codesquad.todolist.travelers.aspect.dto.TaskServiceHistoryDto;
import codesquad.todolist.travelers.global.CustomException;
import codesquad.todolist.travelers.global.ErrorCode;
import codesquad.todolist.travelers.process.domain.repository.ProcessRepository;
import codesquad.todolist.travelers.task.domain.dto.request.TaskProcessIdRequestDto;
import codesquad.todolist.travelers.task.domain.dto.request.TaskRequestDto;
import codesquad.todolist.travelers.task.domain.dto.request.TaskUpdateRequestDto;
import codesquad.todolist.travelers.task.domain.dto.response.TasksByProcessResponseDto;
import codesquad.todolist.travelers.task.domain.dto.response.TaskPostResponseDto;
import codesquad.todolist.travelers.task.domain.dto.response.TaskResponseDto;
import codesquad.todolist.travelers.task.domain.entity.Task;
import codesquad.todolist.travelers.task.domain.repository.TaskRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProcessRepository processRepository;

    public TaskService(final TaskRepository taskRepository, ProcessRepository processRepository) {
        this.taskRepository = taskRepository;
        this.processRepository = processRepository;
    }

    @ActionId(ActionType.CREATE_TASK)
    public TaskPostResponseDto createTask(TaskServiceHistoryDto taskServiceHistoryDto,
                                          final TaskRequestDto taskRequestDto) {
        Task task = TaskRequestDto.toEntity(taskRequestDto);
        Long taskId = taskRepository.save(task).orElseThrow(() -> new CustomException(ErrorCode.FAIL_TASK_CREATE));

        return new TaskPostResponseDto(task, taskId);
    }

    @ActionId(ActionType.DELETE_TASK)
    public void deleteTask(TaskServiceHistoryDto taskServiceHistoryDto, final Long taskId) {
        taskRepository.deleteBy(taskId);
    }

    public void updateTask(final Long taskId, final TaskUpdateRequestDto task) {
        taskRepository.updateBy(taskId, task.toEntity());
    }

    @ActionId(ActionType.MOVE_TASK)
    public void updateTaskByProcess(TaskServiceHistoryDto taskServiceHistoryDto,
                                    final TaskProcessIdRequestDto taskProcessIdRequestDto,
                                    final Long taskId) {
        taskRepository.updateTaskBy(taskProcessIdRequestDto.getProcessId(), taskId);
    }

    public List<TasksByProcessResponseDto> getAllTodoList() {
        return processRepository.findProcesses()
                .stream()
                .map(process -> TasksByProcessResponseDto.fromEntity(process, getTasksBy(process.getProcessId())))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<TaskResponseDto> getTasksBy(final Long processId) {
        return taskRepository.findAllBy(processId)
                .stream()
                .map(TaskResponseDto::fromEntity)
                .collect(Collectors.toUnmodifiableList());
    }
}
