package kz.bitlab.trello1.service;

import kz.bitlab.trello1.dto.UserRegisterDTO;

public interface UserRegisterService {
    Void registerUser(UserRegisterDTO dto);
}
