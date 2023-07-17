package codesquad.todolist.travelers.task.domain.dto.request;

import codesquad.todolist.travelers.task.domain.entity.Task;

public class TaskUpdateRequestDto {
    private String title;
    private String contents;

    public TaskUpdateRequestDto() {
    }

    public TaskUpdateRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static Task toEntity(TaskUpdateRequestDto taskUpdateRequestDto) {
        return new Task(null, taskUpdateRequestDto.getTitle(), taskUpdateRequestDto.getContents(), null, null, null);
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
