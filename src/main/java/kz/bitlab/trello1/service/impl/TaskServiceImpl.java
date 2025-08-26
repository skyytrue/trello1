package kz.bitlab.trello1.service.impl;

import kz.bitlab.trello1.dto.TaskAssignRecord;
import kz.bitlab.trello1.dto.TaskCreateRecord;
import kz.bitlab.trello1.dto.TaskFullRecord;
import kz.bitlab.trello1.entity.User;
import kz.bitlab.trello1.entity.Task;
import kz.bitlab.trello1.enums.TaskStatus;
import kz.bitlab.trello1.exception.TaskNotExistException;
import kz.bitlab.trello1.exception.UserNotExistException;
import kz.bitlab.trello1.mapper.TaskMapper;
import kz.bitlab.trello1.repository.TaskRepository;
import kz.bitlab.trello1.repository.UserRepository;
import kz.bitlab.trello1.service.TaskService;
import kz.bitlab.trello1.utility.TaskSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Page<TaskFullRecord> getTasks(String title, TaskStatus status, Pageable pageable) {
        Page<Task> tasks=taskRepository.findAll(TaskSpecification.getTaskSpecification(title, status, null), pageable);
        return taskMapper.map(tasks);
    }


    private final TaskMapper taskMapper;

    @Override
    public TaskFullRecord getTask(Long id) {
        Task task= taskRepository.findById(id).orElseThrow(()->new TaskNotExistException(String.format("Task with id %s not found", id)));
        return taskMapper.toFullRecord(task);
    }

    @Override
    public TaskFullRecord createTask(TaskCreateRecord request) {
        Task task=taskMapper.toEntity(request);
        task=taskRepository.save(task);
        return taskMapper.toFullRecord(task);
    }

    @Override
    public TaskFullRecord updateTask(TaskFullRecord request) {
        Task task=taskRepository.findById(request.id()).orElseThrow(()->new TaskNotExistException(String.format("Task with id %s not found", request.id())));
        taskMapper.updateMap(request,task);
        task=taskRepository.save(task);
        return taskMapper.toFullRecord(task);
    }

    @Override
    public Void removeTask(Long id) {
        taskRepository.deleteById(id);
        return null;
    }

    @Override
    public Void assignTaskToUser(TaskAssignRecord request) {
        Task task=taskRepository.findById(request.taskId()).orElseThrow(()->new TaskNotExistException(String.format("Task with id %s not found", request.taskId())));
        User user=userRepository.findById(request.userId()).orElseThrow(()->new UserNotExistException(String.format("User with id %s not found", request.userId())));
        task.setUser(user);
        taskRepository.save(task);

        return null;
    }
}

