package kz.bitlab.trello1.mapper;
import kz.bitlab.trello1.dto.UserRegisterDTO;
import kz.bitlab.trello1.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRegisterDTO dto);

}
