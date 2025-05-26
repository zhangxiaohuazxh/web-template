package cn.hubbo.code.mybatis;

import cn.hubbo.commons.utils.FileUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.io.File;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

public class MybatisPlusCodeGenerator {

	public static void code_generate(DBProperties dbProperties, CodeGenerateConfigProperties properties) {
		// @formatter:off
		FastAutoGenerator.create(dbProperties.url, dbProperties.username, dbProperties.passwd)
				.globalConfig(builder -> builder.author(properties.author)
						.enableSpringdoc()
						.outputDir(properties.outputDir)
						.dateType(DateType.TIME_PACK)).dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
					int typeCode = metaInfo.getJdbcType().TYPE_CODE;
					if (typeCode == Types.BIT) {
						return DbColumnType.BOOLEAN;
					} else if (typeCode == Types.SMALLINT || typeCode == Types.TINYINT) {
						// 考虑无符号整型数
						return DbColumnType.SHORT;
					} else if (typeCode == Types.BLOB) {
						return DbColumnType.STRING;
					}
					return typeRegistry.getColumnType(metaInfo);
				})).packageConfig(builder -> builder.parent(properties.parentPackageName)
						.moduleName(properties.moduleName)
						.pathInfo(Collections.singletonMap(OutputFile.xml, properties.xmlLocation))
				).strategyConfig(
						builder -> builder.addInclude(properties.tableNames == null ? List.of() : properties.tableNames)
								.addExclude(properties.ignoreTableNames == null ? List.of() : properties.ignoreTableNames)
								.addTablePrefix(properties.tableNamePrefix == null ? List.of() : properties.tableNamePrefix)
								.enableSkipView())
				.strategyConfig(strategyConfig-> {
					strategyConfig
							.addTablePrefix(properties.getTrimTablePrefix() == null ? null:properties.getTrimTablePrefix())
							.addFieldPrefix(properties.getTrimFieldPrefix() == null? Collections.emptyList(): properties.getTrimFieldPrefix())
							.enableSkipView()
							.entityBuilder()
							.naming(NamingStrategy.underline_to_camel)
							.columnNaming(NamingStrategy.underline_to_camel)
							.enableLombok()
							.enableColumnConstant()
							.enableSerialAnnotation()
							.enableChainModel()
							.mapperBuilder()
							.enableBaseColumnList()
							.enableBaseResultMap()
							.mapperAnnotation(Mapper.class)
							.serviceBuilder()
							.disableService()
							.controllerBuilder()
							.enableRestStyle()
							.build();
				})
				.templateEngine(new FreemarkerTemplateEngine())
				.execute();
		// @formatter:on
	}


	@Builder
	@Data
	public static class DBProperties {
		/* 连接地址 */
		private String url;
		/* 用户名 */
		private String username;
		/* 密码 */
		private String passwd;
		/* 驱动 */
		private String driverClassName;
	}

	@Builder
	@Data
	public static class CodeGenerateConfigProperties {
		/* 作者信息 */
		private String author;
		/* 输出目录 */
		private String outputDir = FileUtils.getModuleParentPath();
		/* 父包名 */
		private String parentPackageName;
		/* 包名 */
		private String packageName;
		/* 模块名 */
		private String moduleName;
		/* MyBatis xml文件路径 */
		private String xmlLocation = outputDir.concat(String.format("%ssrc\\main\\resources", File.separator));
		/* 需要进行逆向生成的表名 */
		private List<String> tableNames;
		/* 逆向生成忽略的表名 */
		private List<String> ignoreTableNames;
		/* 需要逆向生成的表名前缀 */
		private List<String> tableNamePrefix;
		// 需要去除掉的表前缀
		private List<String> trimTablePrefix;
		/* 需要去除的属性名前缀 */
		private List<String> trimFieldPrefix;
	}


}
