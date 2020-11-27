package ru.gitpub.rosatom.rest.controllers.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ApiModel(value = "TaskModel", description = "Задача")
public class TaskModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("Тип задачи")
    private Long type;

    @ApiModelProperty("Исполнитель")
    private UserModel assignee;

    @ApiModelProperty("Необходимая дата\\время выполнения")
    private LocalDateTime dateTo;

    @ApiModelProperty("Фактическая дата\\время выполнения")
    private LocalDateTime dateFact;

    @ApiModelProperty("Время создания задачи")
    private LocalDateTime tstmpCreate;

    @ApiModelProperty("Автор задачи")
    private UserModel author;

    @ApiModelProperty("Заголовок")
    private String header;

    @ApiModelProperty("Содержание задачи")
    private String info;

    @ApiModelProperty("Статус задачи")
    private Long status;

    @ApiModelProperty("Приоритет")
    private PriorityModel priority;

    @ApiModelProperty("Родительская задача")
    private TaskModel parent;
}
