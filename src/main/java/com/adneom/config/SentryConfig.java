package com.adneom.config;//package com.fatboar.config;
//
//import io.sentry.Sentry;
//import io.sentry.spring.SentryExceptionResolver;
//import io.sentry.spring.SentryServletContextInitializer;
//import org.springframework.boot.web.servlet.ServletContextInitializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//
//import javax.annotation.PostConstruct;
//
///**
// * @ClassName: SentryConfig
// * @Description: Sender Exception <br>
// * @Author: Yang Naihua
// * @Create: 2018/09/2
// **/
//@Configuration
//public class SentryConfig {
//    private static final String url = "https://db243159518349f68b03952d7907345a:2482a534063f4247aa186dc415e6d23f@sentry.io/1287876";
//
//    @Bean
//    public HandlerExceptionResolver sentryExceptionResolver() {
//        return new SentryExceptionResolver();
//    }
//
//    @Bean
//    public ServletContextInitializer sentryServletContextInitializer() {
//        return new SentryServletContextInitializer();
//    }
//
//    @PostConstruct
//    public void init() {
//        Sentry.init(url);
//    }
//}
