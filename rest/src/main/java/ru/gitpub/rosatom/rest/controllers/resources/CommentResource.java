package ru.gitpub.rosatom.rest.controllers.resources;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResource implements Serializable {

    @ApiModelProperty(value = "Ид автора комментария", required = true)
    private Long authorId;

    @ApiModelProperty(value = "Сам коммент", required = true)
    private String content;
}
