package kz.bitlab.trello1.utility;

import kz.bitlab.trello1.enums.TaskStatus;
import kz.bitlab.trello1.entity.Task;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@UtilityClass
public class TaskSpecification {
    public Specification<Task> getTaskSpecification(String title, TaskStatus status, Long userId){
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(title != null){
                predicates.add  ((Predicate) criteriaBuilder.like(root.get("title"),"%"+title+"%"));
            }
            if(status != null){
                predicates.add ((Predicate) criteriaBuilder.equal(root.get("status"), status));
            }
            if(userId != null){
                predicates.add((Predicate) criteriaBuilder.equal(root.get("user").get("id"), userId));
            }
            Predicate commonPredicate = (Predicate) criteriaBuilder.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
            return (jakarta.persistence.criteria.Predicate) commonPredicate;
        };
    }
}
