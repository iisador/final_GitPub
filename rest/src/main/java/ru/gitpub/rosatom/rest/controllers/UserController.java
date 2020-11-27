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
import ru.gitpub.rosatom.domain.repos.UserRepository;
import ru.gitpub.rosatom.rest.controllers.models.PriorityModel;
import ru.gitpub.rosatom.rest.controllers.models.UserModel;

import static java.util.stream.Collectors.toList;

@RestController
@Api(tags = {"Пользователь"})
public class UserController {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserController(UserRepository userRepository,
            @Qualifier("conversionServices") ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Operation(summary = "Список юзеров",
            tags = {"Пользователь"},
            description = "Возвращает список юзеров",
            responses = {
                    @ApiResponse(responseCode = "200", description = "список юзеров",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserModel.class))))})
    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> list() {
        return userRepository.findAll().stream()
                .map(e -> conversionService.convert(e, UserModel.class))
                .collect(toList());
    }
}
