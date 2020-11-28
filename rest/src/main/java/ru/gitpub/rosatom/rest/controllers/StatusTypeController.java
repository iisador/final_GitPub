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
import ru.gitpub.rosatom.domain.entities.StatusType;
import ru.gitpub.rosatom.domain.repos.StatusTypeRepository;
import ru.gitpub.rosatom.rest.controllers.models.StatusTypeModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Задача"})
public class StatusTypeController {

    private final StatusTypeRepository statusTypeRepository;

    private final ConversionService conversionService;

    public StatusTypeController(StatusTypeRepository statusTypeRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.statusTypeRepository = statusTypeRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список статусов задачи",
            tags = {"Задача"},
            description = "Возвращает список статусов задачи",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список статусов задачи",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StatusTypeModel.class))))})
    @GetMapping(value = "/api/task/statuses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StatusTypeModel> list() {
        return statusTypeRepository.findAll().stream()
                .map(e -> conversionService.convert(e, StatusTypeModel.class))
                .collect(toList());
    }

    @Operation(summary = "Создание нового статуса задачи",
            tags = {"Задача"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PostMapping(value = "/api/task/statuses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestParam String name) {
        statusTypeRepository.save(new StatusType(name));
        return ResponseEntity.ok("OK");
    }

    @Operation(summary = "Обновление статуса задачи",
            tags = {"Задача"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PatchMapping(value = "/api/task/statuses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestParam String name) {
        statusTypeRepository.findById(id)
                .map(e -> e.updateCode(name))
                .map(statusTypeRepository::save)
                .orElseThrow(() -> new RuntimeException("Статус c id " + id + " не найден"));

        return ResponseEntity.ok("OK");
    }
}
