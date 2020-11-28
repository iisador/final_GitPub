package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Attachment;
import ru.gitpub.rosatom.rest.controllers.models.AttachmentModel;

@Component
public class AttachmentConverter implements Converter<Attachment, AttachmentModel> {

    private final UserConverter userConverter;

    public AttachmentConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public AttachmentModel convert(Attachment attachment) {
        return AttachmentModel.builder()
                .withId(attachment.getId())
                .withName(attachment.getName())
                .withAuthor(userConverter.convert(attachment.getAuthor()))
                .build();
    }
}
