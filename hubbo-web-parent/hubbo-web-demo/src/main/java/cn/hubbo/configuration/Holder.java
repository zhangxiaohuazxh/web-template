package cn.hubbo.configuration;

import cn.hubbo.components.CallbackFun;
import cn.hubbo.model.pojo.User;
import cn.hubbo.web.starter.mapper.UserMapper;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public interface Holder {

	AtomicReference<ApplicationContext> APPLICATION_CONTEXT_REF = new AtomicReference<>();

	static List<CallbackFun> callbackFuns() {
		return List.of(args -> {
			System.out.println("args  " + Arrays.toString(args));
			UserMapper userMapper = getApplicationContext().getBean(UserMapper.class);
			User user = userMapper.selectById(1);
			System.out.println(user);
		});
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		APPLICATION_CONTEXT_REF.set(applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return APPLICATION_CONTEXT_REF.get();
	}

}
