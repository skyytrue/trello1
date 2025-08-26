package kz.bitlab.trello1.dto;

public record ForgetPasswordDTO(
        String username,
        String password,
        String rePassword
) {
}
