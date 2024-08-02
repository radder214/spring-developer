package me.shinsunyoung.springbootdeveloper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller // Controller 라는 것을 명시적으로 표시
public class ThymeleafExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) { // view(HTML)로 데이터를 넘겨주는 Model 객체
        Person person = new Person(1L, "매맞는남자", 28, Arrays.asList("회피", "공격"));

        model.addAttribute("person", person); // person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; // example.html 이라는 view 조회
    }
}

// record -> 필드, 생성자, getter, equals(), hashCode(), toString() 등의 method 를 자동으로 생성
// parameter 에 정의한 필드는 private final 로 정의
record Person(Long id, String name, int age, List<String> hobbies) {

}