package cn.hubbo.model.auth.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号，分布式id
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 用户密码，不要存储明文
	 */
	private String passwd;

	/**
	 * 头像url地址
	 */
	private String profileUrl;

	/**
	 * 是否启用
	 */
	private Boolean enabled;

	/**
	 * 逻辑删除字段
	 */
	private Boolean deleted;

	/**
	 * 创建人，用户自行注册的话值就是自己的id
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新人
	 */
	private Long updateBy;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 最近一次的上线时间
	 */
	private LocalDateTime recentOnlineTime;

	/**
	 * 对用户的备注信息
	 */
	private String description;

}