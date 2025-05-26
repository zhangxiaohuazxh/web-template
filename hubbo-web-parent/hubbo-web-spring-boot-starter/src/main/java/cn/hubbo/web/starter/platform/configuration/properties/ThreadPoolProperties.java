/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 23:00
 * 限定类名: cn.hubbo.web.stater.platform.configuration.properties.ThreadPoolProperties
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.starter.platform.configuration.properties;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import cn.hubbo.commons.annotation.Comment;
import cn.hubbo.commons.constants.StringConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {

    @Comment("核心线程数")
    private int coreSize = 3;

    @Comment("最大线程数")
    private int maxSize = 100;

    @Comment("超时时间")
    private long timeout = 60;

    @Comment("时间单位")
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    @Comment("线程名前缀")
    private String threadNamePrefix = StringConstants.DEFAULT_THREAD_NAME_PREFIX;

    @Comment("工作队列容量")
    private int queueCapacity = 100;

}
