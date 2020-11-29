package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Group;
import ru.gitpub.rosatom.domain.entities.Priority;
import ru.gitpub.rosatom.rest.controllers.models.GroupModel;
import ru.gitpub.rosatom.rest.controllers.models.PriorityModel;

@Component
public class GroupConverter implements Converter<Group, GroupModel> {

    @Override
    public GroupModel convert(Group group) {
        return GroupModel.builder()
                .withId(group.getId())
                .withCode(group.getCode())
                .build();
    }
}
