package ru.gitpub.rosatom.rest.controllers.converters;

import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Department;
import ru.gitpub.rosatom.rest.controllers.models.DepartmentModel;

import static java.util.stream.Collectors.toList;

@Component
public class DepartmentConverter implements Converter<Department, DepartmentModel> {

    private final HousingConverter housingConverter;

    public DepartmentConverter(HousingConverter housingConverter) {
        this.housingConverter = housingConverter;
    }

    @Override
    public DepartmentModel convert(Department department) {
        return DepartmentModel.builder()
                .withId(department.getId())
                .withCode(department.getCode())
                .withHousingList(department.getHousing().stream()
                        .map(housingConverter::convert)
                        .collect(toList()))
                .build();
    }
}
