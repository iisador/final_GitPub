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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gitpub.rosatom.domain.entities.Department;
import ru.gitpub.rosatom.domain.repos.DepartmentRepository;
import ru.gitpub.rosatom.rest.controllers.models.DepartmentModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Цеха"})
public class DepartmentsController {

    private final DepartmentRepository departmentRepository;

    private final ConversionService conversionService;

    public DepartmentsController(DepartmentRepository departmentRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.departmentRepository = departmentRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список цехов",
            tags = {"Цеха"},
            description = "Возвращает список цехов",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список цехов",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = DepartmentModel.class))))})
    @GetMapping(value = "/api/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentModel> list() {
        return departmentRepository.findAll().stream()
                .map(e -> conversionService.convert(e, DepartmentModel.class))
                .collect(toList());
    }

    @Operation(summary = "Создание цеха",
            tags = {"Цеха"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PostMapping(value = "/api/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestParam String name) {
        departmentRepository.save(new Department(name));

        return ResponseEntity.ok("OK");
    }

    @Operation(summary = "Обновление цеха",
            tags = {"Цеха"},
            description = "Ok\\ошибка",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ок или ошибку",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class))))})
    @PatchMapping(value = "/api/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable Long id, @RequestParam String name) {
        departmentRepository.findById(id)
                .map(e -> e.updateCode(name))
                .map(departmentRepository::save)
                .orElseThrow(() -> new RuntimeException("Цех c id " + id + " не найден"));

        return ResponseEntity.ok("OK");
    }
}
