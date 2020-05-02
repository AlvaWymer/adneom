package com.adneom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @ClassName: SwaggerConfiguration
 * @Description: Swagger Configuration <br>
 * @Author: Yang Naihua
 * @Create: 2019/01/06
 **/
@Profile({"dev", "test", "staging"})
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    // 设置默认TOKEN，方便测试
    private static final String TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiZXhwIjoxNTg5ODg5NzQzfQ.cmW-xd-UI1iuAOUz5y4FqbB5J2IXNv8RCv6aSdAIB4tEAIYqCUQrMYpdKHS8vIe4j2D8alB6J0Xjz7z1Zwy8TQ";

    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization").description("Authorization key").defaultValue(TOKEN).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.adneom"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(
                        RequestMethod.GET,
                        newArrayList(
                                new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("string")).build(),
                                new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()
                        ));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("Yang Naihua", "https://www.linkedin.com/in/naihua-yang-481621110/", "yangnaihua@gmail.com"))
                .title("Adneom API")
                .version("1.0")
                .build();
    }
}
