package me.shinsunyoung.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }

    @GetMapping("/test2")
    public String test() {
        return "Hello World";
    }


}
