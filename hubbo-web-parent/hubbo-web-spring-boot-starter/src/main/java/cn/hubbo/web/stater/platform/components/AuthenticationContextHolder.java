/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/20 00:23
 * 限定类名: cn.hubbo.web.stater.platform.components.AuthenticationContextHolder
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater.platform.components;

import cn.hubbo.model.vo.AuthenticationParam;

public interface AuthenticationContextHolder {

    ThreadLocal<AuthenticationParam> CONTEXT = new ThreadLocal<>();

}
