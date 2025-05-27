package cn.hubbo.web.starter.api;

import cn.hubbo.model.vo.ResultVO;
import cn.hubbo.web.starter.service.impl.MenuServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单配置信息表，对应前端的路由信息 前端控制器
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

	@NonNull
	MenuServiceImpl menuService;

	@GetMapping
	public ResultVO<?> queryAllMenus() {
		return ResultVO.success(menuService.queryAllMenus());
	}


}
