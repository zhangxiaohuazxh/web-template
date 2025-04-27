/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/13 19:28
 * 限定类名: cn.hubbo.commons.ex.BusinessException
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.commons.ex;

import lombok.Getter;
import lombok.Setter;

/**
 * 所有不能在编译器处理掉的错误全部归类为runtime error
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private final Short statusCode;

    public BusinessException(Short statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public BusinessException(Short statusCode, Throwable throwable) {
        super(throwable);
        this.statusCode = statusCode;
    }

    public BusinessException(Short statusCode, String msg, Throwable throwable) {
        super(msg, throwable);
        this.statusCode = statusCode;
    }

}
