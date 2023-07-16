package codesquad.todolist.travelers.task.service;

import codesquad.todolist.travelers.task.domain.dto.request.TaskProcessIdRequestDto;
import codesquad.todolist.travelers.task.domain.dto.request.TaskUpdateRequestDto;
import codesquad.todolist.travelers.task.domain.dto.response.ProcessResponseDto;
import codesquad.todolist.travelers.task.domain.dto.request.TaskRequestDto;
import codesquad.todolist.travelers.task.domain.dto.response.TaskPostResponseDto;
import codesquad.todolist.travelers.task.domain.dto.response.TaskResponseDto;
import codesquad.todolist.travelers.task.domain.entity.Process;
import codesquad.todolist.travelers.task.domain.entity.Task;
import codesquad.todolist.travelers.task.domain.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskPostResponseDto createTask(final TaskRequestDto taskRequestDto) {
        Task task = TaskRequestDto.toEntity(taskRequestDto);
        Long taskId = taskRepository.save(task);

        return new TaskPostResponseDto(task, taskId);
    }

    public void deleteTask(final Long taskId) {
        taskRepository.deleteBy(taskId);
    }

    public void updateTask(final Long taskId, final TaskUpdateRequestDto taskUpdateRequestDto) {
        taskRepository.updateBy(taskId, TaskUpdateRequestDto.toEntity(taskUpdateRequestDto));
    }

    public void updateTaskByProcess(final TaskProcessIdRequestDto taskProcessIdRequestDto, final Long taskId) {
        taskRepository.updateTaskBy(taskProcessIdRequestDto.getProcessId(), taskId);
    }

    public List<ProcessResponseDto> getProcesses() {
        List<Process> processes = taskRepository.findProcesses();

        List<ProcessResponseDto> processResponseDtoList = new ArrayList<>();
        for (Process process : processes) {
            ProcessResponseDto from = ProcessResponseDto.from(process, getTasksBy(process.getProcessId()));
            processResponseDtoList.add(from);
        }

        return processResponseDtoList;
    }

    private List<TaskResponseDto> getTasksBy(final Long processId) {
        return taskRepository.findAllBy(processId)
                .stream()
                .map(TaskResponseDto::fromEntity)
                .collect(Collectors.toUnmodifiableList());
    }
}
