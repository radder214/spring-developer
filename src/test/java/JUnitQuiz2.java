import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz2 {
    @DisplayName("연습문제1")
    @Test
    public void quiz2() {
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;

        // 1. number1, number2, number3 가 각각 양수, 0, 음수 인지 검증
        assertThat(number1).isPositive();
        assertThat(number2).isZero();
        assertThat(number3).isNegative();

        // 2. number1 이 number2 보다 큰 값인지 검증
        assertThat(number1).isGreaterThan(number2);

        // 3. number3 가 number2 보다 작은 값인지 검증
        assertThat(number3).isLessThan(number2);
    }
}