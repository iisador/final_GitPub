package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Housing;
import ru.gitpub.rosatom.domain.entities.TaskType;
import ru.gitpub.rosatom.rest.controllers.models.HousingModel;
import ru.gitpub.rosatom.rest.controllers.models.TaskTypeModel;

@Component
public class TaskTypeConverter implements Converter<TaskType, TaskTypeModel> {

    @Override
    public TaskTypeModel convert(TaskType taskType) {
        return TaskTypeModel.builder()
                .withId(taskType.getId())
                .withCode(taskType.getCode())
                .build();
    }
}
