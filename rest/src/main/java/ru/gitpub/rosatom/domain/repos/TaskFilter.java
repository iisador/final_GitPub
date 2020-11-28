package ru.gitpub.rosatom.domain.repos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import lombok.Builder;
import org.springframework.data.jpa.domain.Specification;
import ru.gitpub.rosatom.domain.entities.Task;

@Builder(setterPrefix = "with")
public class TaskFilter implements Specification<Task> {

    private Long type;

    private Long assigneeId;

    private LocalDateTime dateTo;

    private LocalDateTime dateFact;

    private LocalDateTime tstmpCreate;

    private Long authorId;

    private String header;

    private String info;

    private Long statusId;

    private Long priorityId;

    @Override
    public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.isNull(root.get("parentId")));

        if (type != null) {
            predicates.add(criteriaBuilder.equal(root.get("type"), type));
        }

        if (assigneeId != null) {
            predicates.add(criteriaBuilder.equal(root.get("assignee").get("id"), assigneeId));
        }

        if (authorId != null) {
            predicates.add(criteriaBuilder.equal(root.get("author").get("id"), authorId));
        }

        if (statusId != null) {
            predicates.add(criteriaBuilder.equal(root.get("status").get("id"), statusId));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
