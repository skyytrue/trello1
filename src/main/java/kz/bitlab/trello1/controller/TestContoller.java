package kz.bitlab.trello1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    @GetMapping("/test")
    public ResponseEntity<?> test() { //responseEntity дает статус сол ушин пишем
        return ResponseEntity.ok().build();
    }
}
