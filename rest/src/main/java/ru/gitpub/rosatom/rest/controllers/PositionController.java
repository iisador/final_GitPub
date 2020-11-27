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
import ru.gitpub.rosatom.domain.entities.Position;
import ru.gitpub.rosatom.domain.repos.PositionRepository;
import ru.gitpub.rosatom.rest.controllers.models.PositionModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Пользователь"})
public class PositionController {

    private final PositionRepository positionRepository;

    private final ConversionService conversionService;

    public PositionController(PositionRepository positionRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.positionRepository = positionRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список должностей",
            tags = {"Пользователь"},
            description = "Возвращает список должностей",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список типов задачи",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PositionModel.class))))})
    @GetMapping(value = "/api/positions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PositionModel> list() {
        return positionRepository.findAll().stream()
                .map(e -> conversionService.convert(e, PositionModel.class))
                .collect(toList());
    }

    @Operation(summary = "Создание новой должности",
            tags = {"Пользователь"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PostMapping(value = "/api/positions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestParam String name) {
        positionRepository.save(new Position(name));
        return ResponseEntity.ok("OK");
    }

    @Operation(summary = "Обновление должности",
            tags = {"Пользователь"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PatchMapping(value = "/api/positions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestParam String name) {
        positionRepository.findById(id)
                .map(e -> e.updateCode(name))
                .map(positionRepository::save)
                .orElseThrow(() -> new RuntimeException("Должности c id " + id + " не найден"));

        return ResponseEntity.ok("OK");
    }
}
