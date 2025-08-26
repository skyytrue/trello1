package kz.bitlab.trello1.service.impl;

import kz.bitlab.trello1.dto.ForgetPasswordDTO;
import kz.bitlab.trello1.entity.User;
import kz.bitlab.trello1.exception.PasswordNotMatchException;
import kz.bitlab.trello1.exception.UserNotExistException;
import kz.bitlab.trello1.repository.UserRepository;
import kz.bitlab.trello1.service.ForgetPasswordService;
import kz.bitlab.trello1.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForgetPasswordServiceImpl implements ForgetPasswordService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Void forget(ForgetPasswordDTO dto) {
        if(userRepository.findByUsername(dto.username()).isEmpty()) {
            throw new UserNotExistException("User not found");
        }

        if(!dto.password().equals(dto.rePassword())) {
            throw new PasswordNotMatchException("Password not match");
        }

        User user = userRepository.findByUsername(dto.username()).get();
        user.setPassword(passwordEncoder.encode(dto.password()));
        userRepository.save(user);

        return null;
    }
}
