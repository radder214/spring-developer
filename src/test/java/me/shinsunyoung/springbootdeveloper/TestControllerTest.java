package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest         // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc   // MockMVC 생성 및 자동 구성
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach // '매' 테스트 실행 '전' 실행하는 method
    public void mockMvcSetUp() {
        // mockMvc 설정
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("getAllMembers : 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given - 테스트 실행을 준비하는 단계
        // 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when - 테스트를 진행하는 단계
        // 멤버 리스트롤 조회하는 API 호출
        final ResultActions result = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        // then - 테스트 결과를 검증하는 단계
        // 응답 코드가 200(OK) && 반환받은 값 중 0번째 요소의 id와 name이 저장된 값과 같은지 확인
        result.andExpect( status().isOk() )                                             // 응답 코드가 OK(200)인지 확인
              .andExpect( jsonPath("$[0].id").value(savedMember.getId()) )     // 응답의 0번째 값이 DB에 저장된 값과 같은지 확인
              .andExpect( jsonPath("$[0].name").value(savedMember.getName()) );
    }

    @AfterEach  // '매' 테스트 실행 '후' 실행하는 method
    public void cleanUp() {
        // MEMBER Table 에 있는 데이터 모두 삭제
        memberRepository.deleteAll();
    }
}