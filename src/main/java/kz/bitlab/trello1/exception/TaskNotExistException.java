package kz.bitlab.trello1.exception;

public class TaskNotExistException extends RuntimeException {
    public TaskNotExistException(String message) {
        super(message);
    }
}
