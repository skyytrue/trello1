package kz.bitlab.trello1.controller;

import jdk.jfr.Registered;
import kz.bitlab.trello1.dto.UserRegisterDTO;
import kz.bitlab.trello1.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/register") //общий url осымен кетед барлык postmaping getmapping
@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final UserRegisterService registerService;


    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO dto) {
        registerService.registerUser(dto);
        return ResponseEntity.ok().build();
    }
}
