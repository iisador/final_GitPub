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
import ru.gitpub.rosatom.domain.repos.GroupRepository;
import ru.gitpub.rosatom.rest.controllers.models.GroupModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Задача"})
public class GroupController {

    private final GroupRepository groupRepository;

    private final ConversionService conversionService;

    public GroupController(GroupRepository groupRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.groupRepository = groupRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список групп задач",
            tags = {"Задача"},
            description = "Список групп задач",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список групп задач",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GroupModel.class))))})
    @GetMapping(value = "/api/task/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GroupModel> list() {
        return groupRepository.findAll().stream()
                .map(e -> conversionService.convert(e, GroupModel.class))
                .collect(toList());
    }
}
