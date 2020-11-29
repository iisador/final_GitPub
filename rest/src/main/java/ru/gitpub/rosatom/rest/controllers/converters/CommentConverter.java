package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Comment;
import ru.gitpub.rosatom.domain.repos.AttachmentRepository;
import ru.gitpub.rosatom.rest.controllers.models.CommentModel;

import static java.util.stream.Collectors.toList;

@Component
public class CommentConverter implements Converter<Comment, CommentModel> {

    private final UserConverter userConverter;

    private final AttachmentConverter attachmentConverter;

    private final AttachmentRepository attachmentRepository;

    public CommentConverter(UserConverter userConverter,
            AttachmentConverter attachmentConverter,
            AttachmentRepository attachmentRepository) {
        this.userConverter = userConverter;
        this.attachmentConverter = attachmentConverter;
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public CommentModel convert(Comment comment) {
        return CommentModel.builder()
                .withId(comment.getId())
                .withAuthor(userConverter.convert(comment.getAuthor()))
                .withContent(comment.getContent())
                .withTstmpCreate(comment.getTstmpCreate())
                .withClosing(comment.getClosing())
                .withAttachments(attachmentRepository.findByCommentId(comment.getId()).stream()
                        .map(attachmentConverter::convert)
                        .collect(toList()))
                .build();
    }
}
