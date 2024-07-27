package me.shinsunyoung.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1 :
                // 응답 코드 : 201, 응답 본문 : Created!
                return ResponseEntity.created(null).body("Created!");
            case 2 :
                // 응답 코드 : 400, 응답 본문 : Bad Request!
                return ResponseEntity.badRequest().body("Bad Request!");
            default:
                // 응답 코드 : 200, 응답 본문 : OK!
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        switch (code.value()) {
            case 1:
                // 응답 코드 : 403, 응답 본문 : Forbidden!
                return ResponseEntity.status(403).body("Forbidden!");
            default:
                // 응답 코드 : 200, 응답 본문 : OK!
                return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value) {};