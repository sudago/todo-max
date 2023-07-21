package codesquad.todolist.travelers.task.domain.entity;

import java.time.LocalDateTime;

public class Task {
    private Long taskId;
    private String title;
    private String contents;
    private String platform;
    private LocalDateTime createdTime;
    private Long processId;

    public Task(final Long taskId, final String title, final String contents, final String platform,
                final LocalDateTime createdTime,
                final Long processId) {
        this.taskId = taskId;
        this.title = title;
        this.contents = contents;
        this.platform = platform;
        this.createdTime = createdTime;
        this.processId = processId;
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
