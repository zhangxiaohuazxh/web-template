/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 22:59
 * 限定类名: cn.hubbo.web.stater.HubboAutoConfiguration
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater;

import static cn.hubbo.commons.constants.StringConstants.DEFAULT_DATE_FORMAT_PATTERN;

import java.text.SimpleDateFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import cn.hubbo.commons.annotation.Comment;
import cn.hubbo.web.stater.platform.configuration.properties.ThreadPoolProperties;

@Comment("自动配置类")
@ComponentScan
@EnableAsync
@EnableConfigurationProperties
public class HubboAutoConfiguration {

    /**
     *
     * @return ObjectMapper 主要设置MappingJackson2HttpMessageConverter默认的日期格式化
     */
    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        return objectMapper;
    }

    @Primary
    @Bean("threadPool")
    @ConditionalOnBean({ThreadPoolProperties.class})
    public ThreadPoolExecutor threadPool(ThreadPoolProperties properties) {
        var counter = new AtomicInteger(1);
        return new ThreadPoolExecutor(properties.getCoreSize(), properties.getMaxSize(), properties.getTimeout(),
            properties.getTimeUnit(), new ArrayBlockingQueue<>(properties.getQueueCapacity()), runnable -> {
                var thread = new Thread(runnable);
                thread.setName(String.format("%s%d", properties.getThreadNamePrefix(), counter.getAndIncrement()));
                return thread;
            }, new ThreadPoolExecutor.AbortPolicy());
    }

}
