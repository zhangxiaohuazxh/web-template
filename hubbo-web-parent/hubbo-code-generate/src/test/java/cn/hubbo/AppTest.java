package cn.hubbo;


import cn.hubbo.commons.utils.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AppTest {

	@Test
	public void testGetModulePath() {
		String moduleName = "hubbo-web-spring-boot-starter";
		String outputDir = FileUtils.getModuleParentPath() + File.separator + moduleName;
		System.out.println(outputDir);
	}

}
