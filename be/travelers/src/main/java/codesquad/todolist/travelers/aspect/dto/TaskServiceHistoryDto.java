package codesquad.todolist.travelers.aspect.dto;

import codesquad.todolist.travelers.ActionType.ActionType;
import codesquad.todolist.travelers.history.domain.entity.History;
import codesquad.todolist.travelers.task.domain.entity.Task;

public class TaskServiceHistoryDto {
    private ActionType actionType;
    private String title;
    private String from;
    private String to;
    private Long taskId;
    private Long fromId;
    private Long toId;

    private TaskServiceHistoryDto(Builder builder) {
        this.actionType = builder.actionType;
        this.title = builder.title;
        this.from = builder.from;
        this.to = builder.to;
        this.taskId = builder.taskId;
        this.fromId = builder.fromId;
        this.toId = builder.toId;
    }

    public History toEntity() {
        return new History.Builder()
                .title(title)
                .from(from)
                .to(to)
                .actionId(actionType.getActionId())
                .userId(1L)
                .build();
    }

    public static TaskServiceHistoryDto of(TaskServiceHistoryDto originalDto, ActionType actionType,
                                           String fromName) {
        return TaskServiceHistoryDto.builder()
                .title(originalDto.getTitle())
                .from(fromName)
                .actionType(actionType)
                .build();
    }

    public static TaskServiceHistoryDto of(Task task, ActionType actionType, String fromName, String toName) {
        return TaskServiceHistoryDto.builder()
                .title(task.getTitle())
                .from(fromName)
                .to(toName)
                .actionType(actionType)
                .build();
    }

    public static TaskServiceHistoryDto of(Task task, ActionType actionType, String fromName) {
        return TaskServiceHistoryDto.builder()
                .title(task.getTitle())
                .from(fromName)
                .actionType(actionType)
                .build();
    }

    public static TaskServiceHistoryDto of(Task task, ActionType actionType) {
        return TaskServiceHistoryDto.builder()
                .title(task.getTitle())
                .actionType(actionType)
                .build();
    }

    public ActionType getActionType() {
        return actionType;
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

    public Long getTaskId() {
        return taskId;
    }

    public Long getFromId() {
        return fromId;
    }

    public Long getToId() {
        return toId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ActionType actionType;
        private String title;
        private Long taskId;
        private String from;
        private String to;
        private Long fromId;
        private Long toId;

        public Builder actionType(ActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder taskId(Long taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder fromId(Long fromId) {
            this.fromId = fromId;
            return this;
        }

        public Builder toId(Long toId) {
            this.toId = toId;
            return this;
        }

        public TaskServiceHistoryDto build() {
            return new TaskServiceHistoryDto(this);
        }
    }
}
