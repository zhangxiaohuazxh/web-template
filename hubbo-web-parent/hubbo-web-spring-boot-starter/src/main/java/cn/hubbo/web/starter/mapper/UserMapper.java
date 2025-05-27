package cn.hubbo.web.starter.mapper;

import cn.hubbo.web.starter.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户基础信息表 Mapper 接口
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

