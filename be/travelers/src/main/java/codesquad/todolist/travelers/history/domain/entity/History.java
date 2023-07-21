package codesquad.todolist.travelers.history.domain.entity;

import java.time.LocalDateTime;

public class History {
    private final Long historyId;
    private final String title;
    private final String from;
    private final String to;
    private final Long actionId;
    private final LocalDateTime createdTime;
    private final Long userId;

    public History(Long historyId, String title, String from, String to, Long actionId, LocalDateTime createdTime,
                   Long userId) {
        this.historyId = historyId;
        this.title = title;
        this.from = from;
        this.to = to;
        this.actionId = actionId;
        this.createdTime = createdTime;
        this.userId = userId;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public String getTitle() {
        return title;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Long getActionId() {
        return actionId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Long getUserId() {
        return userId;
    }
}
