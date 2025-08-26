package kz.bitlab.trello1.service.impl;

import kz.bitlab.trello1.dto.UserRegisterDTO;
import kz.bitlab.trello1.entity.Role;
import kz.bitlab.trello1.entity.User;
import kz.bitlab.trello1.exception.PasswordNotMatchException;
import kz.bitlab.trello1.exception.UserExistException;
import kz.bitlab.trello1.mapper.UserMapper;
import kz.bitlab.trello1.repository.RoleRepository;
import kz.bitlab.trello1.repository.UserRepository;
import kz.bitlab.trello1.service.UserRegisterService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Void registerUser(UserRegisterDTO dto) {
        userRepository.findByUsername(dto.username()).ifPresent(user -> {
            throw new UserExistException("Username already exists" + user.getUsername());
        });

        if(!dto.password().equals(dto.rePassword())) {
            throw new PasswordNotMatchException("Passwords do not match");
        }
        User user=userMapper.toUser(dto);

        Role role=roleRepository.findRoleUser();
        user.setRoles(Collections.singleton(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return null;

    }
}
