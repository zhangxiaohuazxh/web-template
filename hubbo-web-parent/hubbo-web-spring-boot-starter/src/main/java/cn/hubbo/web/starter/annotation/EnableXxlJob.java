/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/27 22:53
 * 限定类名: cn.hubbo.web.stater.annotation.EnableXxlJob
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import cn.hubbo.web.starter.platform.configuration.XxlJobAutoConfiguration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({XxlJobAutoConfiguration.class})
public @interface EnableXxlJob {}
