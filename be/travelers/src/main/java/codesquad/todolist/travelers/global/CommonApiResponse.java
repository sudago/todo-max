package codesquad.todolist.travelers.global;

import io.swagger.annotations.ApiModelProperty;

public class CommonApiResponse<T> {

    @ApiModelProperty(example = "P01")
    private String status;
    @ApiModelProperty(example = "컬럼 요청 성공!")
    private T message;

    public CommonApiResponse(String status, T message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public T getMessage() {
        return message;
    }

    public static <T> CommonApiResponse<T> success(String status, T message) {
        return new CommonApiResponse<>(status, message);
    }
    public static <T> CommonApiResponse<T> fail(String status, T message) {
        return new CommonApiResponse<>(status, message);
    }
}
