package codesquad.todolist.travelers.global;

import java.net.BindException;
import java.util.List;
import java.util.stream.Collectors;
import jdk.jshell.Snippet.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleCustomException(CustomException e){
        StatusCode statusCode = e.getStatusCode();

        return ResponseEntity.status(statusCode.getHttpStatus())
                .body(ApiResponse.fail(statusCode.getCustomStatus(),statusCode.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        StatusCode statusCode = ErrorCode.VALIDATION_FAILED;

        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();

        StringBuilder errorMessage = new StringBuilder();
        for (ObjectError error : objectErrors) {
            errorMessage.append("Message: ").append(error.getDefaultMessage()).append("\n");
        }

        return ResponseEntity.status(statusCode.getHttpStatus())
                .body(ApiResponse.fail(statusCode.getCustomStatus(),errorMessage.toString()));
    }
    
}
