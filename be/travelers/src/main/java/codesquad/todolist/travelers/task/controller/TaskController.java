package codesquad.todolist.travelers.task.controller;

import codesquad.todolist.travelers.global.ApiResponse;
import codesquad.todolist.travelers.task.domain.dto.request.TaskUpdateRequestDto;
import codesquad.todolist.travelers.task.domain.dto.response.ProcessResponseDto;
import codesquad.todolist.travelers.task.domain.dto.request.TaskRequestDto;
import codesquad.todolist.travelers.task.domain.entity.Task;
import codesquad.todolist.travelers.task.service.TaskService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<?>> get() {
        List<ProcessResponseDto> processes = taskService.getProcesses();

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", processes));
    }

    @PostMapping("/task")
    public ResponseEntity<ApiResponse<?>> add(@RequestBody final TaskRequestDto taskRequestDto) {
        Long taskId = taskService.createTask(taskRequestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", taskId));
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", "카드 삭제 성공!"));
    }

    @PatchMapping("/task/{taskId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long taskId,
                                                 @RequestBody final TaskUpdateRequestDto taskUpdateRequestDto) {
        taskService.updateTask(taskId, taskUpdateRequestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", taskUpdateRequestDto));
    }
}
