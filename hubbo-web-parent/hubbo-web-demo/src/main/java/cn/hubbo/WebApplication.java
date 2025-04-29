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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.hubbo.web.stater.annotation.EnableAuthentication;
import cn.hubbo.web.stater.annotation.EnableMyBatisPlus;
import cn.hubbo.web.stater.annotation.EnableXxlJob;

@EnableAuthentication
@EnableXxlJob
@EnableMyBatisPlus
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
