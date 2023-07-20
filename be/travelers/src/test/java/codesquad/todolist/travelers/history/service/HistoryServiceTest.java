package codesquad.todolist.travelers.history.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import codesquad.todolist.travelers.annotation.ServiceTest;
import codesquad.todolist.travelers.history.domain.repository.HistoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ServiceTest
class HistoryServiceTest {

    @InjectMocks
    HistoryService historyService;

    @Mock
    HistoryRepository historyRepository;

    @Test
    @DisplayName("deleteAllHistory 메서드를 통해 deleteAll 메서드를 호출할수 있다.")
    void deleteAllHistorySuccessTest() {
        //given
        doNothing().when(historyRepository).deleteAll();

        //when
        historyService.deleteAllHistory();

        //then
        verify(historyRepository).deleteAll();
    }
}