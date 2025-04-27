/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 18:57
 * 限定类名: cn.hubbo.web.stater.platform.components.advice.GlobalExceptionAdvice
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater.platform.components.advice;

import static cn.hubbo.commons.ex.BusinessStatusCode.UNKNOWN_ERROR_CODE;
import static cn.hubbo.commons.ex.BusinessStatusCode.UNKNOWN_ERROR_MSG;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.hubbo.commons.ex.BusinessException;
import cn.hubbo.model.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ResultVO<?> defaultExceptionHandler(Throwable throwable) {
        log.error("未被明确处理的异常", throwable);
        return ResultVO.error(UNKNOWN_ERROR_CODE, UNKNOWN_ERROR_MSG, null);
    }

    @ExceptionHandler(value = {BusinessException.class})
    public ResultVO<?> businessExceptionHandler(BusinessException businessException) {
        log.error("业务异常", businessException);
        // todo 处理不同的状态信息
        return ResultVO.error();
    }

}
