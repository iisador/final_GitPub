package ru.gitpub.rosatom.rest.controllers.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ApiModel(value = "CommentModel", description = "Комментарий")
public class CommentModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("Автор")
    private UserModel author;

    @ApiModelProperty("Содержание")
    private String content;

    @ApiModelProperty("Время создания")
    private LocalDateTime tstmpCreate;

    @ApiModelProperty("Метка закрывающего комментария")
    private Boolean closing;

    @ApiModelProperty("Аттачи")
    private List<AttachmentModel> attachments;
}
