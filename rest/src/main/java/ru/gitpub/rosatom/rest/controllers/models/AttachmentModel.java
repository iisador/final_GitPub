package ru.gitpub.rosatom.rest.controllers.models;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ApiModel(value = "AttachmentModel", description = "Приложение")
public class AttachmentModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("Название")
    private String name;

    @ApiModelProperty("Автор аттача")
    private UserModel author;
}
