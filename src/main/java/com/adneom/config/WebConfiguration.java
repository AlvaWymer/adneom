package com.adneom.config;

import com.adneom.specification.RSQLSpecification;
import com.adneom.specification.filter.FilterParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName: WebConfiguration
 * @Description: RSQLSpecification WebConfiguration<br>
 * @Author: Yang Naihua
 * @Create: 2018/09/30
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HandlerMethodArgumentResolver() {
            @Override
            public boolean supportsParameter(MethodParameter methodParameter) {
                return RSQLSpecification.class.equals(methodParameter.getParameterType());
            }

            @Override
            public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
                RSQLSpecification rsql = new RSQLSpecification<>(FilterParser.parse(nativeWebRequest.getParameterMap()));
                return rsql;
            }
        });
    }
}