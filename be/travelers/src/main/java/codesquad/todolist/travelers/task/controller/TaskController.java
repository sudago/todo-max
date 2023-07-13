package codesquad.todolist.travelers.task.controller;

import codesquad.todolist.travelers.global.ApiResponse;
import codesquad.todolist.travelers.task.domain.dto.ProcessResponseDto;
import codesquad.todolist.travelers.task.domain.dto.ResponseDto;
import codesquad.todolist.travelers.task.domain.dto.TaskRequestDto;
import codesquad.todolist.travelers.task.service.TaskService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // TODO: StatusCode 생성
    @GetMapping("/")
    public ResponseEntity<List<ProcessResponseDto>> get() {
        List<ProcessResponseDto> processes = taskService.getProcesses();

        return ResponseEntity.ok().body(processes);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(ApiResponse.success(StatusCode.ORDER_SUCCESS.getCustomStatus(), processes));
    }

    // TODO: StatusCode 생성
    @PostMapping("/task")
    public ResponseEntity<Long> add(@RequestBody final TaskRequestDto taskRequestDto) {
        Long taskId = taskService.createTask(taskRequestDto);

        return ResponseEntity.ok().body(taskId);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(ApiResponse.success(StatusCode.ORDER_SUCCESS.getCustomStatus(), taskId));
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", "카드 삭제 성공!"));
    }
}
