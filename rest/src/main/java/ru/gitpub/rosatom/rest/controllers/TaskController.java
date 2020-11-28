package ru.gitpub.rosatom.rest.controllers;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gitpub.rosatom.domain.repos.TaskFilter;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.rest.controllers.models.TaskModel;
import ru.gitpub.rosatom.rest.controllers.resources.TaskResource;
import ru.gitpub.rosatom.services.TaskService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(tags = {"Задача"})
public class TaskController {

    private final TaskRepository taskRepository;

    private final TaskService taskService;

    private final ConversionService conversionService;

    public TaskController(TaskRepository taskRepository,
            TaskService taskService,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список задач",
            tags = {"Задача"},
            description = "Возвращает список задач",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список задач",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskModel.class))))})
    @GetMapping(value = "/api/tasks", produces = APPLICATION_JSON_VALUE)
    public Page<TaskModel> list(
            @RequestParam(required = false)
            @Parameter(description = "Фильтр по типу задачи", example = "0")
                    Long typeId,
            @RequestParam(required = false)
            @Parameter(description = "Фильтр по статусу задачи", example = "0")
                    Long statusId,
            @RequestParam(required = false)
            @Parameter(description = "Фильтр по исполнителю", example = "0")
                    Long assigneeId,
            @RequestParam(required = false)
            @Parameter(description = "Фильтр по автору задачи", example = "0")
                    Long authorId,
            Pageable pageable) {
        TaskFilter filter = TaskFilter.builder()
                .withType(typeId)
                .withStatusId(statusId)
                .withAssigneeId(assigneeId)
                .withAuthorId(authorId)
                .build();
        return taskRepository.findAll(filter, pageable)
                .map(e -> conversionService.convert(e, TaskModel.class));
    }

    @Operation(summary = "Создание задачи",
            tags = {"Задача"},
            description = "Создание задачи или подзадачи",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ид новое задачи, если все ок",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PostMapping(value = "/api/tasks", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> create(@RequestBody TaskResource task) {
        return ResponseEntity.ok(taskService.create(task));
    }

    @Operation(summary = "Создание подзадачи",
            tags = {"Задача"},
            description = "Создание задачи или подзадачи",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ид новое задачи, если все ок",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PostMapping(value = "/api/tasks/{taskId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createSubTask(@PathVariable Long taskId,
            @RequestBody TaskResource task) {
        task.setParent(taskId);
        return ResponseEntity.ok(taskService.create(task));
    }
}
