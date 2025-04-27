/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 18:57
 * 限定类名: cn.hubbo.web.stater.platform.components.advice.CustomResponseBodyAdvice
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater.platform.components.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import cn.hubbo.model.vo.ResultVO;

/**
 * 只拦截被@RestController和@ResponseBody注解标注的controller类中的函数
 */
@SuppressWarnings("all")
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class CustomResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Class<?> type = returnType.getMethod().getReturnType();
        return type != ResultVO.class;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
        Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (!selectedConverterType.equals(MediaType.APPLICATION_JSON)) {
            return body;
        }
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return ResultVO.success(body);
    }

}
