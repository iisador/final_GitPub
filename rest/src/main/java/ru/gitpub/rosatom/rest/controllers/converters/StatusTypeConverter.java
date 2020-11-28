package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.StatusType;
import ru.gitpub.rosatom.rest.controllers.models.StatusTypeModel;

@Component
public class StatusTypeConverter implements Converter<StatusType, StatusTypeModel> {

    @Override
    public StatusTypeModel convert(StatusType statusType) {
        return StatusTypeModel.builder()
                .withId(statusType.getId())
                .withCode(statusType.getCode())
                .build();
    }
}
