package ru.gitpub.rosatom;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Базовый класс spring boot приложения.
 */
@SpringBootApplication
public class RestApplication extends SpringBootServletInitializer {

    /**
     * Метод main для запуска Spring Boot приложения.
     *
     * @param args параметры запуска приложения
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(RestApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
