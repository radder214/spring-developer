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

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizController2Test {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // 문제1. GET 요청을 보내 응답 코드마다 예상하는 응답을 반환하는지 검증
    @DisplayName("GET Test - code 1")
    @Test
    public void getTestCode1() throws Exception {
        // given
        final String url = "/quiz";

        // when
        ResultActions resultActions = mockMvc.perform(get(url).param("code", "1"));

        // then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().string("Created!"));
    }

    @DisplayName("GET Test - code 2")
    @Test
    public void getTestCode2() throws Exception {
        // given
        final String url = "/quiz";

        // when
        ResultActions resultActions = mockMvc.perform(get(url).param("code", "2"));

        // then
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!"));
    }

    // 문제2. POST 요청을 보내 응답 코드마다 예상하는 응답을 반환하는지 검증
    @DisplayName("POST Test - code 1")
    @Test
    public void postTestCode1() throws Exception {
        // given
        final String url = "/quiz";

        // when
        ResultActions resultActions = mockMvc
                .perform(
                        post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(new Codes(1)))
                        /**
                         * objectMapper.writeValueAsString --> Java 객체를 JSON 형태의 문자열로 변환
                         * objectMapper.writeValueAsString --> {'value' : 13}
                         *
                         * new Codes(1)
                         * ㄴCodes 라는 class 를 따로 만들지는 않고 record 를 사용했다.
                         * ㄴrecord Codes(int value) {};
                         */
                );
        // then
        resultActions
                .andExpect(status().isForbidden())
                .andExpect(content().string("Forbidden!"));
    }

    @DisplayName("quiz() : POST /quiz?code=13 이면 응답 코드는 200, 응답 본문은 OK! 를 반환한다.")
    @Test
    public void postTestCode13() throws Exception {
        // given
        final String url = "/quiz";

        // when
        ResultActions resultActions = mockMvc
                .perform(
                        post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(new Codes(13)))
                );

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("OK!"));
    }
}