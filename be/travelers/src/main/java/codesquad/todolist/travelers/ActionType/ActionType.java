package codesquad.todolist.travelers.ActionType;

public enum ActionType {
    MOVE_TASK(1L),
    UPDATE_TASK(2L),
    CREATE_TASK(3L),
    DELETE_TASK(4L);

    private final Long actionId;

    ActionType(Long actionId) {
        this.actionId = actionId;
    }

    public Long getActionId() {
        return actionId;
    }
}
