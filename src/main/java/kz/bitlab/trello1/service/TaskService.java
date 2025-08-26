package kz.bitlab.trello1.service;

import kz.bitlab.trello1.dto.TaskAssignRecord;
import kz.bitlab.trello1.dto.TaskCreateRecord;
import kz.bitlab.trello1.dto.TaskFullRecord;
import kz.bitlab.trello1.entity.Task;
import kz.bitlab.trello1.enums.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
;

public interface TaskService {
    Page<TaskFullRecord> getTasks(String title, TaskStatus status, Pageable pageable);

    TaskFullRecord getTask(Long id);

    TaskFullRecord createTask(TaskCreateRecord request);

    TaskFullRecord updateTask(TaskFullRecord request);

    Void removeTask(Long id);

    Void assignTaskToUser(TaskAssignRecord request);

}
