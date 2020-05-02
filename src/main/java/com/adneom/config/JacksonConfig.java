package com.adneom.config;

import com.adneom.utils.CommonUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName: JacksonConfig 序列化 和反序列化时间处理
 * @Description: JacksonConfig
 * @Author: Yang Naihua
 * @Create: 2018-12-20 14:14:16
 **/
@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                .deserializerByType(String.class, createStringDeserializer())
                .modulesToInstall(createLocalDateModule())
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }

    private JsonDeserializer createStringDeserializer() {
        return new JsonDeserializer() {
            @Override
            public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                return CommonUtils.nullIfEmpty(jsonParser.getValueAsString().trim());
            }
        };
    }

    private SimpleModule createLocalDateModule() {
        return new SimpleModule()
                .addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                        String value = jsonParser.getValueAsString();
                        if (CommonUtils.isEmpty(value)) {
                            return null;
                        }
                        if (StringUtils.contains(value, "+")) {
                            return ZonedDateTime.parse(value).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
                        }
                        return LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
                    }
                })
                .addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                    @Override
                    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                        jsonGenerator.writeString(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
                    }
                });
    }
}
