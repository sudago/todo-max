package codesquad.todolist.travelers.history.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import codesquad.todolist.travelers.annotation.ControllerTest;
import codesquad.todolist.travelers.history.service.HistoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@ControllerTest(HistoryController.class)
class HistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoryService historyService;

    @Test
    @DisplayName("사용자의 모든 활동 기록을 삭제할수 있다.")
    void deleteSuccessTest() throws Exception {
        //given
        doNothing().when(historyService).deleteAllHistory();

        //when
        ResultActions resultActions = mockMvc.perform(delete("/history"));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("200"))
                .andExpect(jsonPath("$.message").value("활동 기록 삭제 성공"));
    }
    
}