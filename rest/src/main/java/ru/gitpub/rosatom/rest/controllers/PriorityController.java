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
import ru.gitpub.rosatom.domain.repos.PriorityRepository;
import ru.gitpub.rosatom.domain.repos.TaskRepository;
import ru.gitpub.rosatom.rest.controllers.models.PriorityModel;
import ru.gitpub.rosatom.rest.controllers.models.TaskModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Задача"})
public class PriorityController {

    private final PriorityRepository priorityRepository;
    private final ConversionService conversionService;

    public PriorityController(PriorityRepository priorityRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.priorityRepository = priorityRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список приоритетов для задачи",
            tags = {"Задача"},
            description = "Возвращает список приоритетов для задачи",
            responses = {
                    @ApiResponse(responseCode = "200", description = "список приоритетов для задачи",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PriorityModel.class))))})
    @GetMapping(value = "/api/task/priorities", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriorityModel> list() {
        return priorityRepository.findAll().stream()
                .map(e -> conversionService.convert(e, PriorityModel.class))
                .collect(toList());
    }
}
