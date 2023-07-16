package codesquad.todolist.travelers.task.domain.dto.request;

import codesquad.todolist.travelers.task.domain.entity.Task;
import java.time.LocalDateTime;

public class TaskRequestDto {
    private String title;
    private String contents;
    private String platform;
    private Long processId;

    public TaskRequestDto() {
    }

    public TaskRequestDto(final String title, final String contents, final String platform, final Long processId) {
        this.title = title;
        this.contents = contents;
        this.platform = platform;
        this.processId = processId;
    }

    public static Task toEntity(TaskRequestDto taskRequestDto) {
        return new Task(null, taskRequestDto.getTitle(), taskRequestDto.getContents(), taskRequestDto.getPlatform(), LocalDateTime.now(), taskRequestDto.getProcessId());
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Long getProcessId() {
        return processId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContents(final String contents) {
        this.contents = contents;
    }

    public void setProcessId(final Long processId) {
        this.processId = processId;
    }
}
