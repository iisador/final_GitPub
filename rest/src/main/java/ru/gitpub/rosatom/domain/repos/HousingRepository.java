package ru.gitpub.rosatom.domain.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gitpub.rosatom.domain.entities.Department;
import ru.gitpub.rosatom.domain.entities.Housing;

@Repository
public interface HousingRepository extends JpaRepository<Housing, Long> {
}
