package codesquad.todolist.travelers.history.domain.dto.response;

import codesquad.todolist.travelers.history.domain.vo.ActionHistory;
import java.time.LocalDateTime;

public class ActionHistoryResponseDto {
    private final String title;
    private final String from;
    private final String to;
    private final String action;
    private final LocalDateTime createdTime;
    private final String userName;
    private final String imageUrl;

    public ActionHistoryResponseDto(String title, String from, String to, String action, LocalDateTime createdTime,
                                    String userName,
                                    String imageUrl) {

        this.title = title;
        this.from = from;
        this.to = to;
        this.action = action;
        this.createdTime = createdTime;
        this.userName = userName;
        this.imageUrl = imageUrl;
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

    public String getAction() {
        return action;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public String getUserName() {
        return userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static ActionHistoryResponseDto from(ActionHistory actionHistory) {
        return new ActionHistoryResponseDto(actionHistory.getTitle(), actionHistory.getFrom(), actionHistory.getTo(),
                actionHistory.getAction(), actionHistory.getCreatedTime(), actionHistory.getUserName(),
                actionHistory.getImageUrl());
    }
}
