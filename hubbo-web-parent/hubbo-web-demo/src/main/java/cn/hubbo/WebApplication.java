/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.29.10.19
 * 更新时间: 2025/4/28 23:08
 * 限定类名: cn.hubbo.WebApplication
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo;

import cn.hubbo.configuration.Holder;
import cn.hubbo.web.starter.annotation.EnableAuthentication;
import cn.hubbo.web.starter.annotation.EnableMyBatisPlus;
import cn.hubbo.web.starter.annotation.EnableXxlJob;
import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@EnableAuthentication
@EnableXxlJob
@EnableMyBatisPlus
@SpringBootApplication
public class WebApplication implements CommandLineRunner, ApplicationContextAware {

	private Thread wait_thread;

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}


	@Override
	public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
		Holder.setApplicationContext(applicationContext);
		if (wait_thread != null && wait_thread.isAlive()) {
			synchronized (this) {
				wait_thread.notify();
			}
		}
	}

	@Override
	public void run(String... args) throws Exception {
		if (Holder.getApplicationContext() == null) {
			synchronized (this) {
				wait_thread = Thread.currentThread();
				wait_thread.wait();
			}
		}
		Holder.callbackFuns().forEach(callbackFun -> callbackFun.callback(args));
	}
}
