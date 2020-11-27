package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Priority;
import ru.gitpub.rosatom.domain.entities.TaskType;
import ru.gitpub.rosatom.rest.controllers.models.PriorityModel;
import ru.gitpub.rosatom.rest.controllers.models.TaskTypeModel;

@Component
public class PriorityConverter implements Converter<Priority, PriorityModel> {

    @Override
    public PriorityModel convert(Priority priority) {
        return PriorityModel.builder()
                .withId(priority.getId())
                .withCode(priority.getCode())
                .build();
    }
}
