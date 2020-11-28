package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Group;
import ru.gitpub.rosatom.domain.entities.Reaction;
import ru.gitpub.rosatom.rest.controllers.models.GroupModel;
import ru.gitpub.rosatom.rest.controllers.models.ReactionModel;

@Component
public class ReactionConverter implements Converter<Reaction, ReactionModel> {

    @Override
    public ReactionModel convert(Reaction reaction) {
        return ReactionModel.builder()
                .withId(reaction.getId())
                .withCode(reaction.getCode())
                .build();
    }
}
