package ru.gitpub.rosatom.domain.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gitpub.rosatom.domain.entities.StatusType;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusType, Long> {
}
