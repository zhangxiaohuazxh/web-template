/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/27 22:53
 * 限定类名: cn.hubbo.web.stater.platform.configuration.AuthenticationAutoConfiguration
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater.platform.configuration;

import cn.hubbo.model.vo.AuthenticationParam;
import cn.hubbo.web.stater.platform.components.AuthenticationContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class AuthenticationAutoConfiguration extends OncePerRequestFilter implements HandlerInterceptor {

	private final List<Predicate> predicates;

	@SuppressWarnings("all")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// todo 解析用户携带的token信息
		// todo 将解析后的信息放入线程上下文中
		var authenticationParam = new AuthenticationParam();
		AuthenticationContextHolder.CONTEXT.set(authenticationParam);
		try {
			filterChain.doFilter(request, response);

		} catch (Throwable throwable) {
			log.error("请求出错", throwable);
			throw new RuntimeException(throwable);
		} finally {
			AuthenticationContextHolder.CONTEXT.remove();
		}
	}

	@SuppressWarnings("all")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return this.predicates.stream().allMatch(e -> e.test(request, response, handler));
	}

	@FunctionalInterface
	interface Predicate {
		/**
		 * 用户权限鉴权
		 *
		 * @param request  请求
		 * @param response 响应
		 * @param handler  处理器信息
		 * @return 是否通过校验
		 */
		boolean test(HttpServletRequest request, HttpServletResponse response, Object handler);
	}

}
