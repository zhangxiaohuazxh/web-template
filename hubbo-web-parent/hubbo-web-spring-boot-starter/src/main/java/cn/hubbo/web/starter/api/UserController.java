package cn.hubbo.web.starter.api;

import cn.hubbo.model.vo.ResultVO;
import cn.hubbo.web.starter.service.impl.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户基础信息表 前端控制器
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	@NonNull
	private UserServiceImpl userService;


	@GetMapping
	public ResultVO<?> queryCurrentUserInfo() {
		return ResultVO.success();
	}


}
