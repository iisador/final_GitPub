package ru.gitpub.rosatom.rest.interceptors;

import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Для вывода времени обработки запроса.
 */
public class TimerInterceptor implements AsyncHandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TimerInterceptor.class);

    /**
     * Время начала выполнения запроса.
     */
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTime.set(System.currentTimeMillis());
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
        long timeSpent = System.currentTimeMillis() - startTime.get();
        long min = TimeUnit.MILLISECONDS.toMinutes(timeSpent);
        long sec = TimeUnit.MILLISECONDS.toSeconds(timeSpent) - TimeUnit.MINUTES.toSeconds(min);
        long millis = timeSpent - (TimeUnit.MINUTES.toMillis(min) + TimeUnit.SECONDS.toMillis(sec));
        startTime.remove();
        String humanReadable = String.format("%02d:%02d:%04d ms", min, sec, millis);
        log.info("Request \"{}\" time: {}", request.getRequestURI(), humanReadable);
    }
}
