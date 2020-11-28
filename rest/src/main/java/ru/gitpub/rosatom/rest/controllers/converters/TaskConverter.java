package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Task;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.rest.controllers.models.TaskModel;

import static java.util.stream.Collectors.toList;

@Component
public class TaskConverter implements Converter<Task, TaskModel> {

    private final UserConverter userConverter;

    private final TaskRepository taskRepository;

    private final PriorityConverter priorityConverter;
    private final StatusTypeConverter statusTypeConverter;

    public TaskConverter(UserConverter userConverter, TaskRepository taskRepository, PriorityConverter priorityConverter, StatusTypeConverter statusTypeConverter) {
        this.userConverter = userConverter;
        this.taskRepository = taskRepository;
        this.priorityConverter = priorityConverter;
        this.statusTypeConverter = statusTypeConverter;
    }

    @Override
    public TaskModel convert(Task task) {
        return TaskModel.builder()
                .withId(task.getId())
                .withType(task.getType())
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
                .build();
    }
}
