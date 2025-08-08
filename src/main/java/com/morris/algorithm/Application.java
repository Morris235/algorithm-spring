package com.morris.algorithm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing              // 생성일/수정일 자동 관리
@EnableAsync                    // 비동기 처리 (시각화 데이터 처리용)
@EnableCaching                  // Redis 캐싱
//@MapperScan("com.morris.algorithm.repository.query")  // MyBatis 매퍼 스캔
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
