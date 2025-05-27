package cn.hubbo.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * 权限信息表
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("t_permission")
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId("permission_id")
    private Integer permissionId;

    /**
     * 权限字符串，三段式，module.menu.action,module模块，如system，auth，menu可以是一级菜单也可以是二级三级菜单，action即要执行的动作，包括CURD
     */
    private String permissionCode;

    /**
     * 权限名称
     */
    private String permissionName;

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

    public static final String PERMISSION_ID = "permission_id";

    public static final String PERMISSION_CODE = "permission_code";

    public static final String PERMISSION_NAME = "permission_name";

    public static final String ENABLED = "enabled";

    public static final String DELETED = "deleted";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";
}
