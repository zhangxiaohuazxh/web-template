package cn.hubbo.model.pojo;

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
 * 用户角色关联信息表
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("t_user_role")
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编号，t_user主键
     */
    private Long userId;

    /**
     * 角色编号，t_role主键
     */
    private Long roleId;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 逻辑删除
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

    /**
     * 备注描述信息
     */
    private String description;

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";

    public static final String ENABLED = "enabled";

    public static final String DELETED = "deleted";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";

    public static final String DESCRIPTION = "description";
}
