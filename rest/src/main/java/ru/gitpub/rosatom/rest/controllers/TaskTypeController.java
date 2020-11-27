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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gitpub.rosatom.domain.entities.TaskType;
import ru.gitpub.rosatom.domain.repos.TaskTypeRepository;
import ru.gitpub.rosatom.rest.controllers.models.TaskTypeModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Задача"})
public class TaskTypeController {

    private final TaskTypeRepository taskTypeRepository;

    private final ConversionService conversionService;

    public TaskTypeController(TaskTypeRepository taskTypeRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.taskTypeRepository = taskTypeRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список типов задачи",
            tags = {"Задача"},
            description = "Возвращает список типов задачи",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список типов задачи",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskTypeModel.class))))})
    @GetMapping(value = "/api/task/types", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskTypeModel> list() {
        return taskTypeRepository.findAll().stream()
                .map(e -> conversionService.convert(e, TaskTypeModel.class))
                .collect(toList());
    }

    @Operation(summary = "Создание нового типа задачи",
            tags = {"Задача"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PostMapping(value = "/api/task/types", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestParam String name) {
        taskTypeRepository.save(new TaskType(name));
        return ResponseEntity.ok("OK");
    }

    @Operation(summary = "Обновление типа задачи",
            tags = {"Задача"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PatchMapping(value = "/api/task/types/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestParam String name) {
        taskTypeRepository.findById(id)
                .map(e -> e.updateCode(name))
                .map(taskTypeRepository::save)
                .orElseThrow(() -> new RuntimeException("Тип задачи c id " + id + " не найден"));

        return ResponseEntity.ok("OK");
    }
}
