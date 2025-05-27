/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/15 22:45
 * 限定类名: cn.hubbo.commons.annotation.Comment
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Comment("用来做注释,比注释美观,只保留在源码中,避免运行时的内存浪费")
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.METHOD,
    ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
public @interface Comment {

    String value() default "";

}
