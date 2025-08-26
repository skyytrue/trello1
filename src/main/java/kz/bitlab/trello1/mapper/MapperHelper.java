package kz.bitlab.trello1.mapper;

import kz.bitlab.trello1.entity.User;
import kz.bitlab.trello1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperHelper {
    private final UserRepository userRepository;

    @Named("mapToUser")
    public User findByIdUser(Long id){
        if(id==null){
            return null;
        }
        return userRepository.findById(id).orElse(null);
    }
}
