package cn.hubbo.web.starter.mapper;

import cn.hubbo.model.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限信息表 Mapper 接口
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}

