package ru.gitpub.rosatom.services;

import org.springframework.stereotype.Service;
import ru.gitpub.rosatom.domain.entities.Task;
import ru.gitpub.rosatom.domain.repos.PriorityRepository;
import ru.gitpub.rosatom.domain.repos.StatusTypeRepository;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.domain.repos.UserRepository;
import ru.gitpub.rosatom.rest.controllers.resources.TaskResource;

@Service
public class TaskService {

    private static final Long DEF_STATUS = 0L;

    private static final Long DEF_PRIORITY = 2L;

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final StatusTypeRepository statusTypeRepository;

    private final PriorityRepository priorityRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, StatusTypeRepository statusTypeRepository, PriorityRepository priorityRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.statusTypeRepository = statusTypeRepository;
        this.priorityRepository = priorityRepository;
    }

    public Long create(TaskResource r) {
        Task task = generateTask(r);
        return taskRepository.save(task).getId();
    }

    private Task generateTask(TaskResource res) {
        if (!res.getPriority().isPresent()) {
            res.setPriority(DEF_PRIORITY);
        }

        Task t = new Task();
        t.setStatus(statusTypeRepository.findById(DEF_STATUS).orElse(null));
        t.setType(res.getType());

        t.setAssignee(userRepository.findById(res.getAssignee())
                .orElseThrow(() -> new RuntimeException("Пользователь с ид " + res.getAssignee() + " не найден")));
        t.setDateTo(res.getDateTo());
        t.setDateFact(res.getDateFact());
        t.setAuthor(userRepository.findById(res.getAuthor())
                .orElseThrow(() -> new RuntimeException("Пользователь с ид " + res.getAuthor() + " не найден")));
        t.setHeader(res.getHeader());
        t.setInfo(res.getInfo());
        res.getPriority()
                .map(id -> priorityRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Приоритет с ид " + id + " не найден")))
                .ifPresent(t::setPriority);
        res.getParent()
                .map(id -> taskRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Задача с ид " + id + " не найдена")))
                .ifPresent(parent -> t.setParentId(parent.getId()));
        return t;
    }
}
