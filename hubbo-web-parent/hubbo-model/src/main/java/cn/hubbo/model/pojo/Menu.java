package cn.hubbo.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 菜单配置信息表，对应前端的路由信息
 * </p>
 *
 * @author 张晓华
 * @since 2025-05-27
 */
@Getter
@Setter
@ToString
@TableName("t_menu")
@Accessors(chain = true)
public class Menu implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 菜单编号
     */
    @TableId("menu_id")
    private Integer menuId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * URI资源路径
     */
    private String path;

    /**
     * 渲染组件的路径
     */
    private String component;

    /**
     * 菜单层级
     */
    private String level;

    /**
     * 标题
     */
    private String title;

    /**
     * 菜单icon
     */
    private String icon;

    /**
     * 是否需要认证
     */
    private Boolean auth;

    /**
     * 是否缓存组件
     */
    private Boolean keepAlive;

    /**
     * 序号，查询结果根据此字段排序
     */
    @TableField("`order`")
    private Integer order;

    /**
     *  菜单类型，如目录C，菜单M，超链接L
     */
    private String menuType;

    /**
     * 链接的地址，当menu_type为L时，此字段值有意义
     */
    private String link;

    /**
     * 父级菜单编号
     */
    private Integer upperMenuId;

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

    public static final String MENU_ID = "menu_id";

    public static final String MENU_NAME = "menu_name";

    public static final String PATH = "path";

    public static final String COMPONENT = "component";

    public static final String LEVEL = "level";

    public static final String TITLE = "title";

    public static final String ICON = "icon";

    public static final String AUTH = "auth";

    public static final String KEEP_ALIVE = "keep_alive";

    public static final String ORDER = "`order`";

    public static final String MENU_TYPE = "menu_type";

    public static final String LINK = "link";

    public static final String UPPER_MENU_ID = "upper_menu_id";

    public static final String ENABLED = "enabled";

    public static final String DELETED = "deleted";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_TIME = "update_time";
}
