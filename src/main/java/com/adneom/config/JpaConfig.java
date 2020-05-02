package com.adneom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: JpaConfig
 * @Description: JpaConfig
 * @Author: Yang Naihua
 * @Create: 2018-06-21 13:55
 **/

@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.adneom")
@Configuration
@Primary
public class JpaConfig {
}
