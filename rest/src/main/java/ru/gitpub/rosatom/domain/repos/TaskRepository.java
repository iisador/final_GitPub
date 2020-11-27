package ru.gitpub.rosatom.domain.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gitpub.rosatom.domain.entities.Task;
import ru.gitpub.rosatom.domain.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
