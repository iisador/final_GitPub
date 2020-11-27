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
@ApiModel(value = "UserModel", description = "Пользователь")
public class UserModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("ФИО")
    private String name;

    @ApiModelProperty("Должность")
    private PositionModel position;

    @ApiModelProperty("Группа пользователей\\конкретный пользователь")
    private Long type;
}
