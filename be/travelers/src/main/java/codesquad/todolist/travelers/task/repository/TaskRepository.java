package codesquad.todolist.travelers.task.repository;

import codesquad.todolist.travelers.task.domain.entity.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Long> save(final Task task);

    void deleteBy(final Long taskId);

    void updateBy(final Long taskId, final Task task);

    void updateTaskBy(final Long processId, final Long taskId, final double position);

    List<Task> findAllBy(final Long processId);

    Task findByIgnoringDeleted(final Long taskId);

    Long findPositionById(final Long taskId);

    void deleteByProcessId(final Long processId);

}
