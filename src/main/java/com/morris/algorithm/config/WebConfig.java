package com.morris.algorithm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    // CORS 설정 제거하고 다른 MVC 설정만 관리
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addFormatters(FormatterRegistry registry) {
                // 커스텀 포매터 등록
//                registry.addFormatter(new LocalDateTimeFormatter());
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 인터셉터 등록 (로깅, 인증 등)
//                registry.addInterceptor(new LoggingInterceptor());
            }
        };
    }
}
