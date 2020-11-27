package ru.gitpub.rosatom.rest.controllers;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.rest.controllers.models.TaskModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Задача"})
public class TaskController {

    private final TaskRepository taskRepository;

    private final ConversionService conversionService;

    public TaskController(TaskRepository taskRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.taskRepository = taskRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список задач",
            tags = {"Задача"},
            description = "Возвращает список задач",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список задач",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskModel.class))))})
    @GetMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskModel> list() {
        return taskRepository.findAll().stream()
                .map(e -> conversionService.convert(e, TaskModel.class))
                .collect(toList());
    }
}
