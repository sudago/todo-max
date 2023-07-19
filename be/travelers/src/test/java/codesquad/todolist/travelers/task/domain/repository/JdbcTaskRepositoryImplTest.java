package codesquad.todolist.travelers.task.domain.repository;

import codesquad.todolist.travelers.annotation.RepositoryTest;
import codesquad.todolist.travelers.task.domain.entity.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@RepositoryTest
class JdbcTaskRepositoryImplTest {

    @Autowired
    private JdbcTaskRepositoryImpl repository;

    @Test
    @DisplayName("save() 를 통해 task를 DB에 저장할수 있다.")
    void saveSuccessTest() {
        //given
        Task expected = dummyTask();
        //when
        Long taskId = repository.save(expected).get();
        //then
        Task actual = repository.findByIgnoringDeleted(taskId);

        Assertions.assertThat(actual)
                .usingRecursiveComparison() // 값 하나씩 돌면서 비교해주는 메서드
                // DB에서 생성해주는 건 무시
                .ignoringFields("taskId")
                .ignoringFields("createdTime")
                .isEqualTo(expected);
    }

    private Task dummyTask() {
        return new Task(null, "제목입니다", "내용입니다", "web", null, 1L);
    }

    // 지안
    // 1. 등록
    // 2. 삭제

    // 설리
    // 1. 수정
    // 2. 이동
}