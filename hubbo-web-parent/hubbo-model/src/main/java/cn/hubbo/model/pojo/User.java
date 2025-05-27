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
 * 用户基础信息表
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Getter
@Setter
@ToString
@TableName("t_user")
@Accessors(chain = true)
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号，分布式id
     */
    @TableId("user_id")
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

    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String PHONE = "phone";

    public static final String PASSWD = "passwd";

    public static final String PROFILE_URL = "profile_url";

    public static final String ENABLED = "enabled";

    public static final String DELETED = "deleted";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";

    public static final String RECENT_ONLINE_TIME = "recent_online_time";

    public static final String DESCRIPTION = "description";
}
