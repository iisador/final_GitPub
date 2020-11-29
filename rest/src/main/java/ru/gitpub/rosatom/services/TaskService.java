package ru.gitpub.rosatom.services;

import org.springframework.stereotype.Service;
import ru.gitpub.rosatom.domain.entities.Attachment;
import ru.gitpub.rosatom.domain.entities.Comment;
import ru.gitpub.rosatom.domain.entities.Reaction;
import ru.gitpub.rosatom.domain.entities.StatusType;
import ru.gitpub.rosatom.domain.entities.Task;
import ru.gitpub.rosatom.domain.entities.User;
import ru.gitpub.rosatom.domain.repos.AttachmentRepository;
import ru.gitpub.rosatom.domain.repos.CommentRepository;
import ru.gitpub.rosatom.domain.repos.PriorityRepository;
import ru.gitpub.rosatom.domain.repos.ReactionRepository;
import ru.gitpub.rosatom.domain.repos.StatusTypeRepository;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.domain.repos.TaskTypeRepository;
import ru.gitpub.rosatom.domain.repos.UserRepository;
import ru.gitpub.rosatom.rest.controllers.resources.CommentResource;
import ru.gitpub.rosatom.rest.controllers.resources.TaskResource;

@Service
public class TaskService {

    private static final Long DEF_STATUS = 0L;

    private static final Long DEF_PRIORITY = 2L;

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final StatusTypeRepository statusTypeRepository;

    private final PriorityRepository priorityRepository;

    private final CommentRepository commentRepository;

    private final TaskTypeRepository taskTypeRepository;

    private final ReactionRepository reactionRepository;

    private final AttachmentRepository attachmentRepository;

    public TaskService(TaskRepository taskRepository,
            UserRepository userRepository,
            StatusTypeRepository statusTypeRepository,
            PriorityRepository priorityRepository,
            CommentRepository commentRepository,
            TaskTypeRepository taskTypeRepository,
            ReactionRepository reactionRepository,
            AttachmentRepository attachmentRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.statusTypeRepository = statusTypeRepository;
        this.priorityRepository = priorityRepository;
        this.commentRepository = commentRepository;
        this.taskTypeRepository = taskTypeRepository;
        this.reactionRepository = reactionRepository;
        this.attachmentRepository = attachmentRepository;
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
        t.setType(taskTypeRepository.findById(res.getType())
                .orElseThrow(() -> new RuntimeException("Тип задачи с ид " + res.getType() + " не найден")));

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

    public Long comment(Long taskId, CommentResource commentResource) {
        taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Задача с ид " + taskId + " не найдена"));
        User author = userRepository.findById(commentResource.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Пользователь с ид " + commentResource.getAuthorId() + " не найден"));
        Comment c = new Comment();
        c.setAuthor(author);
        c.setContent(commentResource.getContent());
        c.setClosing(commentResource.getClosing());
        c.setTaskId(taskId);
        c = commentRepository.save(c);

        if (commentResource.getUrl() != null) {
            Comment finalC = c;
            commentResource.getUrl().stream()
                    .map(s -> new Attachment(author, finalC.getId(), s))
                    .forEach(attachmentRepository::save);
        }
        return c.getId();
    }

    public void reaction(Long taskId, Long reactionId) {
        Reaction r = reactionRepository.findById(reactionId)
                .orElseThrow(() -> new RuntimeException(("Реакция с ид " + reactionId + " не найдена")));

        taskRepository.findById(taskId)
                .map(task -> {
                    task.setReaction(r);
                    return taskRepository.save(task);
                });
    }

    public void status(Long taskId, Long statusId) {
        StatusType s = statusTypeRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException(("Статус с ид " + statusId + " не найден")));

        taskRepository.findById(taskId)
                .map(task -> {
                    task.setStatus(s);
                    return taskRepository.save(task);
                });
    }

    public void update(Long taskId, TaskResource res) {
        taskRepository.findById(taskId)
                .map(task -> {
                    if (res.getAssignee() != null) {
                        task.setAssignee(userRepository.findById(res.getAssignee())
                                .orElseThrow(() -> new RuntimeException("Пользователь с ид " + res.getAssignee() + " не найден")));
                    }
                    if (res.getHeader() != null) {
                        task.setHeader(res.getHeader());
                    }

                    if (res.getInfo() != null) {
                        task.setInfo(res.getInfo());
                    }

                    if (res.getDateTo() != null) {
                        task.setDateTo(res.getDateTo());
                    }

                    if (res.getDateFact() != null) {
                        task.setDateFact(res.getDateFact());
                    }

                    if (res.getType() != null) {
                        task.setType(taskTypeRepository.findById(res.getType())
                                .orElseThrow(() -> new RuntimeException("Тип задачи с ид " + res.getType() + " не найден")));
                    }

                    res.getPriority().ifPresent(id -> task.setPriority(priorityRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Приоритет с ид " + id + " не найден"))));
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Задача с ид " + taskId + " не найдена"));
    }
}
