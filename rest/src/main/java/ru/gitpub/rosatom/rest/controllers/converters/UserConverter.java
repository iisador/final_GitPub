package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.User;
import ru.gitpub.rosatom.rest.controllers.models.UserModel;

@Component
public class UserConverter implements Converter<User, UserModel> {

    private final PositionConverter positionConverter;

    public UserConverter(PositionConverter positionConverter) {
        this.positionConverter = positionConverter;
    }

    @Override
    public UserModel convert(User user) {
        return UserModel.builder()
                .withId(user.getId())
                .withName(user.getName())
                .withPosition(user.getPosition().map(positionConverter::convert).orElse(null))
                .withType(user.getType())
                .build();
    }
}
