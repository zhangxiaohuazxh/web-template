/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/13 19:28
 * 限定类名: cn.hubbo.commons.ex.BusinessStatusCode
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.commons.ex;

/**
 * TODO 做一个工具类,每次根据表中的配置自动映射到当前文件中,前端也需要这么一个配置
 */
public interface BusinessStatusCode {

    Short DEFAULT_SUCCESS_CODE = 0;

    String SUCCESS_MSG = "ok";

    Short DEFAULT_ERROR_CODE = 10000;

    String DEFAULT_ERROR_MSG = "error";

    Short UNKNOWN_ERROR_CODE = 10001;

    String UNKNOWN_ERROR_MSG = "未知异常";

}
