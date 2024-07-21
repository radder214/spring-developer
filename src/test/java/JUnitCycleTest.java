import org.junit.jupiter.api.*;

/**
 * 콘솔창에는 아래와 같이 찍힌다.
 *
 * @BeforeAll
 * @BeforeEach
 * test1
 * @AfterEach
 * @BeforeEach
 * test2
 * @AfterEach
 * @BeforeEach
 * test3
 * @AfterEach
 * @AfterAll
 *
 * */

public class JUnitCycleTest {
    // 전체 테스트를 시작하기 전에 1회 실행하므로 method 를 static 으로 선언
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    // 테스트 케이스를 시작하기 전마다 실행
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    // 테스트 케이스를 종료하기 전마다 실행
    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 method 를 static 으로 선언
    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }
}