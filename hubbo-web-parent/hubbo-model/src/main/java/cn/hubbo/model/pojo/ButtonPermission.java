package cn.hubbo.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 按钮权限关联信息表
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("t_button_permission")
public class ButtonPermission implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 按钮权限编号
	 */
	private Integer id;

	/**
	 * 按钮权限字符
	 */
	private String buttonPermissionCode;

	/**
	 * 按钮名称
	 */
	private String buttonName;

	/**
	 * 是否启用
	 */
	private Boolean enabled;

	/**
	 * 逻辑删除字段
	 */
	private Boolean deleted;

	/**
	 * 创建人
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

	private Integer permissionId;

	public static final String ID = "id";

	public static final String BUTTON_PERMISSION_CODE = "button_permission_code";

	public static final String BUTTON_NAME = "button_name";

	public static final String ENABLED = "enabled";

	public static final String DELETED = "deleted";

	public static final String CREATE_BY = "create_by";

	public static final String CREATE_TIME = "create_time";

	public static final String UPDATE_BY = "update_by";

	public static final String UPDATE_TIME = "update_time";

	public static final String PERMISSION_ID = "permission_id";
}
