/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 19:01
 * 限定类名: cn.hubbo.web.TestController
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hubbo.model.vo.ResultVO;

@ResponseBody
@Controller("test_controller")
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "", produces = "text/html")
    public String test() {
        return "<html> <h1>hello</h1>   </html>";
    }

    @ResponseBody
    @GetMapping("/date")
    public Date date() {
        return new Date();
    }

    @ResponseBody
    @GetMapping("/res")
    public ResultVO<?> result() {
        return ResultVO.success(new Date());
    }

}
