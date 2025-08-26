package kz.bitlab.trello1.dto;

public record UserRegisterDTO(
        String username,
        String fullName,
        String password,
        Integer age,
        String rePassword
) {
}
