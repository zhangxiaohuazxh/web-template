package cn.hubbo.web.starter.service.impl;

import cn.hubbo.model.pojo.Menu;
import cn.hubbo.web.starter.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单配置信息表，对应前端的路由信息 服务实现类
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> {


	public List<Menu> queryAllMenus() {
		return getBaseMapper().selectList(null);
	}


}
