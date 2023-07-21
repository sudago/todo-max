package codesquad.todolist.travelers.history.domain.repository;

import codesquad.todolist.travelers.annotation.RepositoryTest;
import codesquad.todolist.travelers.history.domain.ActionHistory;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@RepositoryTest
class JdbcHistoryRepositoryImplTest {

    @Autowired
    private JdbcHistoryRepositoryImpl repository;

    @Test
    @DisplayName("deleteAllHistory() 를 통해 모든 활동기록을 지울수 있다.")
    void deleteAllHistoryTest() {
        //when
        repository.deleteAll();
        
        //then
        List<ActionHistory> actual = repository.findAll();
        Assertions.assertThat(actual.size()).isEqualTo(0);
    }

}