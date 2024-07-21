import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    // =========== 성공 CASE ===========
    @DisplayName("1 + 2는 3이다.") // 테스트 이름
    @Test                         // 테스트 method
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;
        /*
         * assertEquals -> JUnit 에서 제공하는 검증 method
         * assertEquals(기대하는 값, 실제로 검증할 값)
         */
        Assertions.assertEquals(sum, a + b); // 값이 같은지 확인
    }

    // =========== 실패 CASE ===========
    @DisplayName("1 + 3은 4이다.")
    @Test
    public void junitFailedTest() {
        int a = 1;
        int b = 3;
        int sum = 3;

        Assertions.assertEquals(sum, a + b);
    }

}