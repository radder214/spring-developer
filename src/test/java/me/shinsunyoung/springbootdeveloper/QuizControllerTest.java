package me.shinsunyoung.springbootdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // 문제1. GET 요청을 보내 응답 코드마다 예상하는 응답을 반환하는지 검증
    @DisplayName("quiz() : GET /quiz?code=1 이면 응답 코드는 201, 응답 본문은 Created! 를 반환한다.")
    @Test
    public void getQuiz1() throws Exception {
        // given(준비 코드)
        final String url = "/quiz";

        // when(실행 코드)
        final ResultActions resultActions = mockMvc.perform(
                get(url).param("code", "1") // param() -> url에 쿼리 파라미터 추가
        );

        // then(검증 코드)
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().string("Created!"));
    }

    @DisplayName("quiz() : GET /quiz?code=2 이면 응답 코드는 400, 응답 본문은 Bad Request! 를 반환한다.")
    @Test
    public void getQuiz2() throws Exception {
        // given(검증 코드)
        final String url = "/quiz";

        // when(실행 코드)
        ResultActions resultActions = mockMvc.perform(
                get(url).param("code", "2")
        );

        // then(검증 코드)
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!"));
    }

    // 문제2. POST 요청을 보내 응답 코드마다 예상하는 응답을 반환하는지 검증


}