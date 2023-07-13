package codesquad.todolist.travelers.task.domain.dto.response;

import codesquad.todolist.travelers.task.domain.entity.Task;
import java.time.LocalDateTime;

public class TaskResponseDto {
    private final Long taskId;
    private final String title;
    private final String contents;
    private final String platform;
    private final LocalDateTime createdTime;
    private final Long processId;

    public TaskResponseDto(final Task task) {
        this.taskId = task.getTaskId();
        this.title = task.getTitle();
        this.contents = task.getContents();
        this.platform = task.getPlatform();
        this.createdTime = task.getCreatedTime();
        this.processId = task.getProcessId();
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getPlatform() {
        return platform;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Long getProcessId() {
        return processId;
    }
}
