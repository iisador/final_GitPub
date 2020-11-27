package ru.gitpub.rosatom.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Класс конфигурации Swagger.
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Подключаем расурсы для swagger-ui.
     * {@inheritDoc}
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    /**
     * Метод для получения бина-настройки Swagger.
     *
     * @return бин-настройка Swagger
     */
    @Bean
    public Docket api() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Rosatom REST Api")
                .description("Апи")
                .version("0.0.1")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.gitpub.rosatom.rest.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
}
