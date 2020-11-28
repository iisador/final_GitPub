package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Comment;
import ru.gitpub.rosatom.rest.controllers.models.CommentModel;

@Component
public class CommentConverter implements Converter<Comment, CommentModel> {

    private final UserConverter userConverter;

    public CommentConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public CommentModel convert(Comment comment) {
        return CommentModel.builder()
                .withId(comment.getId())
                .withAuthor(userConverter.convert(comment.getAuthor()))
                .withContent(comment.getContent())
                .withTstmpCreate(comment.getTstmpCreate())
                .build();
    }
}
