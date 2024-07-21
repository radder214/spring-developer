
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

// 1. 각각의 테스트를 실행하기 전에 “Hello!” 출력
// 2. 모든 테스트가 끝나면 “Bye!” 출력
public class JUnitQuiz3 {
    @DisplayName("@BeforeEach") // 해당 annotation 이 붙어도 콘솔창에 출력 안 됨
    @BeforeEach
    public void beforeEach() {
        System.out.println("Hello!");
    }

    @DisplayName("@Test 1") // 얘는 콘솔창에 출력됨
    @Test
    public void junitQuiz3() {
        System.out.println("This is first test");
    }

    @DisplayName("@Test 2") // 얘는 콘솔창에 출력됨
    @Test
    public void junitQuiz4() {
        System.out.println("This is second test");
    }

//    @DisplayName("@AfterEach") // 해당 annotation 이 붙어도 콘솔창에 출력 안 됨
//    @AfterEach
//    public void afterEach() {
//        System.out.println("Bye!");
//    }

    @DisplayName("@AfterAll") // 해당 annotation 이 붙어도 콘솔창에 출력 안 됨
    @AfterAll
    static void afterAll() {
        System.out.println("Bye!");
    }
}