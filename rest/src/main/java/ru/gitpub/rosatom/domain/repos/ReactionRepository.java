package ru.gitpub.rosatom.domain.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gitpub.rosatom.domain.entities.Reaction;
import ru.gitpub.rosatom.domain.entities.TaskType;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}
