package cn.hubbo.web.starter.mapper;

import cn.hubbo.model.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单配置信息表，对应前端的路由信息 Mapper 接口
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}

