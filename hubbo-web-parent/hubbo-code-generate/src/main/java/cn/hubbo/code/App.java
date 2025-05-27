package cn.hubbo.code;

import cn.hubbo.code.mybatis.MybatisPlusCodeGenerator;
import cn.hubbo.commons.utils.FileUtils;
import com.mysql.cj.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

@Slf4j
public class App {


	public static void main(String[] args) {
		log.info("code generate start successfully.........................");
		String moduleName = "hubbo-web-spring-boot-starter";
		String outputDir = FileUtils.getModuleParentPath() + File.separator + moduleName + "/src/main/java";
		String parentPackageName = "cn.hubbo.web.starter";
		String xmlLocation = outputDir.substring(0, outputDir.length() - 4).concat("resources/mapper");
		MybatisPlusCodeGenerator.DBProperties dbProperties = MybatisPlusCodeGenerator.DBProperties.builder()
				.url("*****************")
				.username("*****************")
				.passwd("*****************")
				.driverClassName(Driver.class.getName())
				.build();
		MybatisPlusCodeGenerator.CodeGenerateConfigProperties generateConfigProperties = MybatisPlusCodeGenerator.CodeGenerateConfigProperties.builder()
				.author("张晓华")
				.outputDir(outputDir)
				.parentPackageName(parentPackageName)
				// 不同时生效
				//.packageName(packageName)
				//.moduleName(moduleName)
				.xmlLocation(xmlLocation)
				.tableNames(List.of())
				.ignoreTableNames(List.of())
				.ignoreTableNames(List.of())
				.trimTablePrefix(List.of("t_"))
				.build();
		MybatisPlusCodeGenerator.code_generate(dbProperties, generateConfigProperties);
		log.info("code generate   end successfully.........................");
	}
}
