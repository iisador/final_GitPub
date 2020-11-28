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
@ApiModel(value = "ReactionModel", description = "Реакция на задачу")
public class ReactionModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("Строковое представление")
    private String code;
}
