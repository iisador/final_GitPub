package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Position;
import ru.gitpub.rosatom.domain.entities.TaskType;
import ru.gitpub.rosatom.rest.controllers.models.PositionModel;
import ru.gitpub.rosatom.rest.controllers.models.TaskTypeModel;

@Component
public class PositionConverter implements Converter<Position, PositionModel> {

    @Override
    public PositionModel convert(Position position) {
        return PositionModel.builder()
                .withId(position.getId())
                .withCode(position.getCode())
                .build();
    }
}
