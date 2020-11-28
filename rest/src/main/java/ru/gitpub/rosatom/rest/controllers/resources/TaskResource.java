package ru.gitpub.rosatom.rest.controllers.resources;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResource implements Serializable {

    @ApiModelProperty(value = "Ид типа задачи", required = true)
    private Long type;

    @ApiModelProperty(value = "Ид исполнителя", required = true)
    private Long assignee;

    @ApiModelProperty(value = "Необходимая дата\\время выполнения", example = "27.11.2020 12:00", required = true)
    private LocalDateTime dateTo;

    @ApiModelProperty(value = "Фактическая дата\\время выполнения", example = "28.11.2020 12:00", required = true)
    private LocalDateTime dateFact;

    @ApiModelProperty("Ид автора задачи")
    private Long author;

    @ApiModelProperty(value = "Заголовок", required = true)
    private String header;

    @ApiModelProperty("Содержание задачи")
    private String info;

    @ApiModelProperty(value = "Ид приоритета", required = true)
    private Long priority;

    @ApiModelProperty(value = "Ид родительской задачи")
    private Long parent;

    public Optional<Long> getPriority() {
        return Optional.ofNullable(priority);
    }

    public Optional<Long> getParent() {
        return Optional.ofNullable(parent);
    }
}
