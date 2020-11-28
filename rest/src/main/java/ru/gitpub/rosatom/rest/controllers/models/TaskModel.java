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
@ApiModel(value = "TaskModel", description = "Задача")
public class TaskModel implements Serializable {

    @ApiModelProperty("Ид")
    private Long id;

    @ApiModelProperty("Группа задачи")
    private GroupModel group;

    @ApiModelProperty("Тип задачи")
    private TaskTypeModel type;

    @ApiModelProperty("Исполнитель")
    private UserModel assignee;

    @ApiModelProperty("Реакция")
    private ReactionModel reaction;

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
    private StatusTypeModel status;

    @ApiModelProperty("Приоритет")
    private PriorityModel priority;

    @ApiModelProperty("Подзадачи")
    private List<TaskModel> subTaskList;

    @ApiModelProperty("Комментарии")
    private List<CommentModel> comments;

    @ApiModelProperty("Приложенные файлы")
    private List<AttachmentModel> attachments;
}
