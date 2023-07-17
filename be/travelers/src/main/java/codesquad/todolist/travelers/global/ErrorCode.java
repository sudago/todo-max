package codesquad.todolist.travelers.global;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements StatusCode{
    // TODO: 에러에 맞게 수정하기
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "","Resource not exists"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "","Internal server error"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
    private final String customStatus;

    ErrorCode(HttpStatus httpStatus, String customStatus, String message) {
        this.httpStatus = httpStatus;
        this.customStatus = customStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getCustomStatus() {
        return this.customStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
