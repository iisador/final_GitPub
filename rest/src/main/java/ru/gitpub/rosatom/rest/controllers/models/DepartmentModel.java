package ru.gitpub.rosatom.rest.controllers.models;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ApiModel(value = "DepartmentModel", description = "Цех")
public class DepartmentModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("Строковое представление")
    private String code;

    @ApiModelProperty("Корпуса, привязанные к цеху")
    private List<HousingModel> housingList;
}
