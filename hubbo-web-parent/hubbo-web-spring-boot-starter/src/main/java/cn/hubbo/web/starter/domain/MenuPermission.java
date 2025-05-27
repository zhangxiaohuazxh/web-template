package cn.hubbo.web.starter.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 菜单权限关联表
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("t_menu_permission")
public class MenuPermission implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关系编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer permissionId;

    private Integer menuId;

    /**
     * 是否启用
     */
    private Boolean enabled;

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

    public static final String ID = "id";

    public static final String PERMISSION_ID = "permission_id";

    public static final String MENU_ID = "menu_id";

    public static final String ENABLED = "enabled";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";
}
