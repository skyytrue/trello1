package kz.bitlab.trello1.mapper;

import kz.bitlab.trello1.entity.Task;
import kz.bitlab.trello1.dto.TaskCreateRecord;
import kz.bitlab.trello1.dto.TaskFullRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        uses = {MapperHelper.class})
public interface TaskMapper {
    @Mapping(target = "userId", source = "user.id")
    TaskFullRecord toFullRecord(Task task);

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapToUser")
    @Mapping(target = "status", constant = "NEW")
    Task toEntity(TaskCreateRecord request);

    default Page<TaskFullRecord> map(Page<Task> data) {
        return data.map(this::toFullRecord);
    }

    void updateMap(TaskFullRecord taskFullRecord, @MappingTarget Task task);



}
