package cn.hubbo.model;


import cn.hubbo.model.auth.mapper.AuthMapper;
import cn.hubbo.model.auth.vo.UserVO;
import cn.hubbo.model.pojo.User;
import org.junit.jupiter.api.Test;

public class MapperTest {


	@Test
	void testUser2UserVO() {
		User user = new User();
		user.setUserId(10086L);
		user.setPhone("13148282713");
		UserVO userVO = AuthMapper.INSTANCE.user2UserVO(user);
		System.out.println(userVO);
	}


	@Test
	void testUserVO2User() {
		UserVO userVO = new UserVO();
		userVO.setEnabled(true);
		userVO.setUserName("测试用户");
		User user = AuthMapper.INSTANCE.userVO2User(userVO);
		System.out.println(user);
	}

}
