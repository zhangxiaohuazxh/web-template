package cn.hubbo.code;

import cn.hubbo.code.mybatis.MybatisPlusCodeGenerator;
import com.mysql.cj.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class App {


	public static void main(String[] args) {
		log.info("code generate start successfully.........................");
		MybatisPlusCodeGenerator.DBProperties dbProperties = MybatisPlusCodeGenerator.DBProperties.builder()
				.url("xxx")
				.username("root")
				.passwd("xxx")
				.driverClassName(Driver.class.getName())
				.build();
		MybatisPlusCodeGenerator.CodeGenerateConfigProperties generateConfigProperties = MybatisPlusCodeGenerator.CodeGenerateConfigProperties.builder()
				.author("张晓华")
				.outputDir("C:\\data\\store\\tmp\\store\\output")
				.parentPackageName("cn.hubbo")
				//.packageName("")
				.moduleName("auth")
				.xmlLocation("C:\\data\\store\\tmp\\store\\output\\xml")
				.tableNames(List.of())
				.ignoreTableNames(List.of())
				.ignoreTableNames(List.of())
				.trimTablePrefix(List.of("t_"))
				.build();
		MybatisPlusCodeGenerator.code_generate(dbProperties, generateConfigProperties);
		log.info("code generate   end successfully.........................");
	}
}
