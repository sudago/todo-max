package codesquad.todolist.travelers.process.controller;

import static codesquad.todolist.travelers.global.SuccessCode.*;

import codesquad.todolist.travelers.global.ApiResponse;
import codesquad.todolist.travelers.process.domain.dto.ProcessRequestDto;
import codesquad.todolist.travelers.process.service.ProcessService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping("/process")
    public ResponseEntity<ApiResponse<?>> save(@Valid @RequestBody ProcessRequestDto processRequestDto) {
        processService.saveProcess(processRequestDto);
        return ResponseEntity.status(PROCESS_SUCCESS.getHttpStatus())
                .body(ApiResponse.success(PROCESS_SUCCESS.getCustomStatus(), PROCESS_SUCCESS.getMessage()));
    }
}
