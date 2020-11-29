package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Task;
import ru.gitpub.rosatom.domain.repos.AttachmentRepository;
import ru.gitpub.rosatom.domain.repos.CommentRepository;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.rest.controllers.models.TaskModel;

import static java.util.stream.Collectors.toList;

@Component
public class TaskConverter implements Converter<Task, TaskModel> {

    private final UserConverter userConverter;

    private final TaskRepository taskRepository;

    private final CommentRepository commentRepository;

    private final PriorityConverter priorityConverter;

    private final StatusTypeConverter statusTypeConverter;

    private final CommentConverter commentConverter;

    private final TaskTypeConverter taskTypeConverter;

    private final AttachmentConverter attachmentConverter;

    private final AttachmentRepository attachmentRepository;

    private final GroupConverter groupConverter;

    private final ReactionConverter reactionConverter;

    public TaskConverter(UserConverter userConverter,
            TaskRepository taskRepository,
            CommentRepository commentRepository,
            PriorityConverter priorityConverter,
            StatusTypeConverter statusTypeConverter,
            CommentConverter commentConverter,
            TaskTypeConverter taskTypeConverter,
            AttachmentConverter attachmentConverter,
            AttachmentRepository attachmentRepository,
            GroupConverter groupConverter,
            ReactionConverter reactionConverter) {
        this.userConverter = userConverter;
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.priorityConverter = priorityConverter;
        this.statusTypeConverter = statusTypeConverter;
        this.commentConverter = commentConverter;
        this.taskTypeConverter = taskTypeConverter;
        this.attachmentConverter = attachmentConverter;
        this.attachmentRepository = attachmentRepository;
        this.groupConverter = groupConverter;
        this.reactionConverter = reactionConverter;
    }

    @Override
    public TaskModel convert(Task task) {
        return TaskModel.builder()
                .withId(task.getId())
                .withType(taskTypeConverter.convert(task.getType()))
                .withAssignee(userConverter.convert(task.getAssignee()))
                .withDateTo(task.getDateTo())
                .withDateFact(task.getDateFact())
                .withTstmpCreate(task.getTstmpCreate())
                .withAuthor(userConverter.convert(task.getAuthor()))
                .withHeader(task.getHeader())
                .withInfo(task.getInfo())
                .withStatus(statusTypeConverter.convert(task.getStatus()))
                .withPriority(priorityConverter.convert(task.getPriority()))
                .withSubTaskList(taskRepository.findAllByParentId(task.getId()).stream()
                        .map(this::convert)
                        .collect(toList()))
                .withComments(commentRepository.findByTaskIdOrderByIdAsc(task.getId()).stream()
                        .map(commentConverter::convert)
                        .collect(toList()))
                .withAttachments(attachmentRepository.findByTaskId(task.getId()).stream()
                        .map(attachmentConverter::convert)
                        .collect(toList()))
                .withGroup(task.getGroup().map(groupConverter::convert).orElse(null))
                .withReaction(task.getReaction().map(reactionConverter::convert).orElse(null))
                .build();
    }
}
