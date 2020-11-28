package ru.gitpub.rosatom.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.gitpub.rosatom.rest.interceptors.MdcInterceptor;
import ru.gitpub.rosatom.rest.interceptors.TimerInterceptor;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * Конфиг веб приложения.
 */
@Configuration
@EnableWebMvc
@EnableOpenApi
@ComponentScan({"ru.gitpub.rosatom.rest.controllers",
        "ru.gitpub.rosatom.services"
})
public class RestWebConfig implements WebMvcConfigurer {

    /** Паттерн для даты. */
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /** Паттерн для даты-времени. */
    private static final String DATETIME_PATTERN = "dd.MM.yyyy' 'HH:mm";

    /** Форматтер для даты-времени. */
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /** Форматтер для даты. */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Добавляем интерсепторы.
     * Вызываем прямо метод бина, а не инжектим.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcInterceptor()).addPathPatterns("/rest/**").order(0);
        registry.addInterceptor(timerInterceptor()).addPathPatterns("/rest/**").order(1);
    }

    /** Тут отдаем статику для фронта. **/
    @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:ui/");
    }

    /**
     * Оверрайдим сериализацию\десериализацию http сообщений настройкой джексеновского маппера.
     *
     * @param converters конвертеры
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .modules(new JavaTimeModule(), new Jdk8Module())
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DATETIME_FORMATTER))
                .serializerByType(LocalDate.class, new LocalDateSerializer(DATE_FORMATTER))
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DATETIME_FORMATTER))
                .deserializerByType(LocalDate.class, new LocalDateDeserializer(DATE_FORMATTER));
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

    /**
     * Настраиваем десериализацию даты и времени в запросах.
     *
     * @param registry форматтеры
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class, new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String text, Locale locale) {
                return LocalDate.parse(text, DATE_FORMATTER);
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return DATE_FORMATTER.format(object);
            }
        });
        registry.addFormatterForFieldType(LocalDateTime.class, new Formatter<LocalDateTime>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) {
                return LocalDateTime.parse(text, DATETIME_FORMATTER);
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return DATETIME_FORMATTER.format(object);
            }
        });
    }

    /**
     * Подключение кастомных сообщений.
     *
     * @return messageSource
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages/validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Бин для преобразования типов.
     *
     * @param converters конвертер
     *
     * @return преобразование
     */
    @Bean
    public ConversionServiceFactoryBean conversionServices(Set<Converter<?, ?>> converters) {
        ConversionServiceFactoryBean f = new ConversionServiceFactoryBean();
        f.setConverters(converters);
        return f;
    }

    /**
     * Настройки cors.
     *
     * @param registry CorsRegistry
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/rest/**")
                .allowedOrigins("*");
    }

    /**
     * Объявляем бин тут, чтобы потом использовать в addInterceptors.
     */
    @Bean
    MdcInterceptor mdcInterceptor() {
        return new MdcInterceptor();
    }

    @Bean
    TimerInterceptor timerInterceptor() {
        return new TimerInterceptor();
    }
}
