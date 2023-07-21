package codesquad.todolist.travelers.history.controller;

import codesquad.todolist.travelers.global.ApiResponse;
import codesquad.todolist.travelers.history.domain.dto.response.ActionHistoryResponseDto;
import codesquad.todolist.travelers.history.service.HistoryService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @DeleteMapping("/history")
    public ResponseEntity<ApiResponse> delete() {
        historyService.deleteAllHistory();

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", "활동 기록 삭제 성공"));
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<?>> get() {
        List<ActionHistoryResponseDto> actionHistories = historyService.getAllHistory();

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("200", actionHistories));
    }
}
