package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Task;
import ru.gitpub.rosatom.rest.controllers.models.TaskModel;

@Component
public class TaskConverter implements Converter<Task, TaskModel> {

    private final UserConverter userConverter;

    private final PriorityConverter priorityConverter;

    public TaskConverter(UserConverter userConverter, PriorityConverter priorityConverter) {
        this.userConverter = userConverter;
        this.priorityConverter = priorityConverter;
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
                .withStatus(task.getStatus())
                .withPriority(priorityConverter.convert(task.getPriority()))
                // TODO: найти дочерние задачи
                .build();
    }
}
