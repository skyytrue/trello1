package kz.bitlab.trello1.controller;

import kz.bitlab.trello1.dto.ForgetPasswordDTO;
import kz.bitlab.trello1.service.ForgetPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("forget-password")
@Controller //Для статусов
@RequiredArgsConstructor
public class ForgetPasswordController {
    private final ForgetPasswordService forgetPasswordService;

    @PostMapping
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordDTO dto) {
        try{
            forgetPasswordService.forget(dto);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
