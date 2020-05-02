//package com.adneom.config;
//
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName: MailHealthIndicator
// * @Description: MailHealthIndicator 是为了解决启动报错，冲突来自于spring-boot-starter-mail 和spring-boot-actuator
// * @Author: Yang Naihua
// * @Create: 2018-11-20 16:55
// **/
//@Component
//public class MailHealthIndicator implements HealthIndicator {
//    @Override
//    public Health health() {
//        int errorCode = check();
//        if (errorCode != 0) {
//            return Health.down().withDetail("Error Code", errorCode).build();
//        }
//        return Health.up().build();
//    }
//
//    int check() {
//        //可以实现自定义的检测逻辑
//        return 0;
//    }
//}