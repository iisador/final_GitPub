package ru.gitpub.rosatom.domain.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gitpub.rosatom.domain.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    @Query("select t from Task t where t.parentId is null")
    List<Task> findAll();

    List<Task> findAllByParentId(Long parentId);
}
