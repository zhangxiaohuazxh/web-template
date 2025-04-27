/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/27 22:53
 * 限定类名: cn.hubbo.web.stater.unit.CodeGenerateTemplateTest
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater.unit;

import java.io.File;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import cn.hubbo.commons.utils.FileUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@SuppressWarnings("all")
public class CodeGenerateTemplateTest {

    public static void code_generate(DBProperties dbProperties, CodeGenerateConfigProperties properties) {
        // @formatter:off
        FastAutoGenerator.create(dbProperties.url, dbProperties.username, dbProperties.passwd)
                .globalConfig(builder -> {
                                        builder.author(properties.author)
                                        .enableSpringdoc()
                                        .outputDir(properties.outputDir)
                                        .dateType(DateType.TIME_PACK);
        }).dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
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
        .templateEngine(new FreemarkerTemplateEngine())
        .execute();
        // @formatter:on
    }

    @SneakyThrows
    @Test
    public void test_get_current_dir() {
        var properties = new CodeGenerateConfigProperties();
        System.out.println(properties);
    }

    @AllArgsConstructor
    @Data
    static class DBProperties {
        public String url;

        public String username;

        public String passwd;

        public String driverClassName;
    }

    @Data
    static class CodeGenerateConfigProperties {
        public String author;
        public String outputDir = FileUtils.getModuleParentPath();
        public String parentPackageName;
        public String packageName;
        public String moduleName;
        public String xmlLocation = outputDir.concat(String.format("%ssrc\\main\\resources", File.separator));
        public List<String> tableNames;
        public List<String> ignoreTableNames;
        public List<String> tableNamePrefix;
    }

}
