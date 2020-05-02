package com.adneom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "dev");
        SpringApplication.run(Application.class, args);
    }

    // TODO 优化到 WebSecurityConfig，这样的话，不需要在每个模块都要注入这个Bean
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
