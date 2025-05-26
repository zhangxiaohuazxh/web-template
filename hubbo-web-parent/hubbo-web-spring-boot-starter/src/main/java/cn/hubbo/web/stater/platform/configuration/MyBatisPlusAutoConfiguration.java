/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.29.10.19
 * 更新时间: 2025/4/28 23:09
 * 限定类名: cn.hubbo.web.stater.platform.configuration.MyBatisPlusAutoConfiguration
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.web.stater.platform.configuration;

import cn.hubbo.commons.annotation.Comment;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.DataPermissionHandler;
import com.baomidou.mybatisplus.extension.plugins.handler.MultiDataPermissionHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Table;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@Slf4j
@Comment("MyBatisPlus自动配置类")
public class MyBatisPlusAutoConfiguration {

	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		var mybatisPlusInterceptor = new MybatisPlusInterceptor();
		mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
		mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		mybatisPlusInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
		mybatisPlusInterceptor.addInnerInterceptor(new DataPermissionInterceptor());
		return mybatisPlusInterceptor;
	}

	@Bean
	@ConditionalOnMissingBean
	public DataPermissionHandler dataPermissionHandler() {
		return new DefaultMultiDataPermissionHandlerImpl();
	}

	public static class DefaultMultiDataPermissionHandlerImpl implements MultiDataPermissionHandler {

		@Override
		public Expression getSqlSegment(Table table, Expression where, String mappedStatementId) {
			// todo 验证逻辑
			return null;
		}
	}

}
