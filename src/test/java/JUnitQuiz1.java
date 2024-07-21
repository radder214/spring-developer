import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz1 {
    @DisplayName("연습문제1")
    @Test
    public void quiz1() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        // 변수 3개 모두 null 이 아닌지 검증
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        // name1 과 name2 가 같은 값을 가지는지 검증
        assertThat(name1).isEqualTo(name2);

        // name3 이 name1, name2 과 다른 값을 가지는지 검증
        assertThat(name1).isNotEqualTo(name3);
    }
}