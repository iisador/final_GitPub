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
import ru.gitpub.rosatom.domain.repos.ReactionRepository;
import ru.gitpub.rosatom.rest.controllers.models.ReactionModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Задача"})
public class ReactionController {

    private final ReactionRepository reactionRepository;

    private final ConversionService conversionService;

    public ReactionController(ReactionRepository reactionRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.reactionRepository = reactionRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список реакций на задачу",
            tags = {"Задача"},
            description = "Список реакций на задачу",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список реакций на задачу",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ReactionModel.class))))})
    @GetMapping(value = "/api/task/reactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReactionModel> list() {
        return reactionRepository.findAll().stream()
                .map(e -> conversionService.convert(e, ReactionModel.class))
                .collect(toList());
    }
}
