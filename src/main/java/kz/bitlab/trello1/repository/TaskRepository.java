package kz.bitlab.trello1.repository;

import kz.bitlab.trello1.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findAll(Specification<Task> sprecification, Pageable pageable);

}
