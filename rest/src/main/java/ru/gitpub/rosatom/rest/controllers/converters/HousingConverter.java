package ru.gitpub.rosatom.rest.controllers.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gitpub.rosatom.domain.entities.Housing;
import ru.gitpub.rosatom.rest.controllers.models.HousingModel;

@Component
public class HousingConverter implements Converter<Housing, HousingModel> {

    @Override
    public HousingModel convert(Housing housing) {
        return HousingModel.builder()
                .withId(housing.getId())
                .withCode(housing.getCode())
                .build();
    }
}
