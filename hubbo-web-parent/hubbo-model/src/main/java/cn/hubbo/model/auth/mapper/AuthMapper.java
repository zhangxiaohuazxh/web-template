package cn.hubbo.model.auth.mapper;

import cn.hubbo.model.auth.vo.UserVO;
import cn.hubbo.model.pojo.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {

	AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);


	UserVO user2UserVO(User user);


	User userVO2User(UserVO userVO);

}
