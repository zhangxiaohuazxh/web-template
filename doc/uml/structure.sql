create
database hub default character set utf8mb4;
use
hub;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
    user_id            bigint                              not null comment '用户编号，分布式id',
    user_name          varchar(255)                        NOT NULL comment '用户名',
    phone              char(11)                            NOT NULL UNIQUE comment '手机号',
    passwd             varchar(255) comment '用户密码，不要存储明文',
    profile_url        varchar(255) comment '头像url地址',
    enabled            bit       DEFAULT true comment '是否启用',
    deleted            bit       DEFAULT false             NOT NULL comment '逻辑删除字段',
    create_by          bigint                              NOT NULL comment '创建人，用户自行注册的话值就是自己的id',
    create_time        datetime  DEFAULT current_timestamp NOT NULL comment '创建时间',
    update_by          bigint comment '更新人',
    update_time        datetime comment '更新时间',
    recent_online_time timestamp DEFAULT current_timestamp comment '最近一次的上线时间',
    description        varchar(255) comment '对用户的备注信息',
    CONSTRAINT t_user_pk PRIMARY KEY (user_id)
) comment ='用户基础信息表' ENGINE = InnoDB;

DROP TABLE IF EXISTS t_role;
CREATE TABLE t_role
(
    role_id     bigint                 not null AUTO_INCREMENT comment '分布式id',
    role_name   varchar(255)           NOT NULL comment '角色名称',
    enabled     bit      DEFAULT true  NOT NULL comment '是否启用',
    deleted     bit      DEFAULT false NOT NULL comment '逻辑删除字段',
    create_by   bigint                 NOT NULL comment '创建人',
    create_time datetime DEFAULT current_timestamp,
    update_by   bigint comment '更新人',
    update_time datetime DEFAULT current_timestamp comment '更新时间',
    CONSTRAINT t_role_pk PRIMARY KEY (role_id)
) comment ='角色基础信息表' ENGINE = InnoDB;

DROP TABLE IF EXISTS t_user_role;
CREATE TABLE t_user_role
(
    id          bigint                 NOT NULL AUTO_INCREMENT,
    user_id     bigint                 NOT NULL comment '用户编号，t_user主键',
    role_id     bigint                 NOT NULL comment '角色编号，t_role主键',
    enabled     bit      DEFAULT true  NOT NULL comment '是否启用',
    deleted     bit      DEFAULT false NOT NULL comment '逻辑删除',
    create_by   bigint                 NOT NULL comment '创建人',
    create_time datetime DEFAULT current_timestamp comment '创建时间',
    update_by   bigint comment '更新人',
    update_time datetime DEFAULT current_timestamp comment '更新时间',
    description varchar(255) comment '备注描述信息',
    CONSTRAINT t_user_role_pk PRIMARY KEY (id)
) comment ='用户角色关联信息表' ENGINE = InnoDB;

DROP TABLE IF EXISTS t_permission;
CREATE TABLE t_permission
(
    permission_id   int                    NOT NULL comment '权限id',
    permission_code varchar(255)           NOT NULL comment '权限字符串，三段式，module.menu.action,module模块，如system，auth，menu可以是一级菜单也可以是二级三级菜单，action即要执行的动作，包括CURD',
    permission_name varchar(255)           NOT NULL comment '权限名称',
    enabled         bit      DEFAULT true  NOT NULL comment '是否启用',
    deleted         bit      DEFAULT false NOT NULL comment '逻辑删除字段',
    create_by       bigint                 NOT NULL comment '创建人',
    create_time     datetime DEFAULT current_timestamp comment '创建时间',
    update_by       bigint comment '更新人',
    update_time     datetime DEFAULT current_timestamp comment '更新时间',
    CONSTRAINT t_permission_pk PRIMARY KEY (permission_id),
    UNIQUE INDEX (permission_code)
) comment ='权限信息表' ENGINE = InnoDB;

DROP TABLE IF EXISTS t_role_permission;
CREATE TABLE t_role_permission
(
    id            int      NOT NULL AUTO_INCREMENT comment '主键编号',
    role_id       bigint   NOT NULL comment '角色id',
    permission_id int      NOT NULL comment '权限编号',
    enabled       bit      DEFAULT true comment '是否启用',
    create_by     bigint   NOT NULL comment '创建人',
    create_time   datetime NOT NULL comment '创建时间',
    update_by     bigint comment '更新人',
    update_time   datetime DEFAULT current_timestamp comment '更新时间',
    CONSTRAINT t_role_permission_pk PRIMARY KEY (id)
) comment ='角色权限关联信息表' ENGINE = InnoDB;

DROP TABLE IF EXISTS t_menu;
CREATE TABLE t_menu
(
    menu_id       int          NOT NULL comment '菜单编号',
    menu_name     varchar(255) NOT NULL comment '菜单名',
    path          varchar(255) NOT NULL comment 'URI资源路径',
    component     varchar(255) NOT NULL comment '渲染组件的路径',
    level         char(1)      NOT NULL comment '菜单层级',
    title         varchar(255) comment '标题',
    icon          varchar(255) comment '菜单icon',
    auth          bit          DEFAULT true comment '是否需要认证',
    keep_alive    bit          DEFAULT true comment '是否缓存组件',
    `order`       int comment '序号，查询结果根据此字段排序',
    menu_type     char(1)      DEFAULT 'M' check ( menu_type in ('C', 'M', 'L')) comment ' 菜单类型，如目录C，菜单M，超链接L ',
    link          varchar(255) DEFAULT false comment '链接的地址，当menu_type为L时，此字段值有意义',
    upper_menu_id int comment '父级菜单编号',
    enabled       bit          DEFAULT true comment '是否启用',
    deleted       bit          DEFAULT false comment '逻辑删除字段',
    create_by     bigint       NOT NULL comment '创建人',
    create_time   datetime     DEFAULT current_timestamp comment '创建时间',
    update_by     bigint comment '更新人',
    update_time   datetime     DEFAULT current_timestamp comment '更新时间',
    CONSTRAINT t_menu_pk PRIMARY KEY (menu_id)
) comment ='菜单配置信息表，对应前端的路由信息' ENGINE = InnoDB;


DROP TABLE IF EXISTS t_menu_permission;
CREATE TABLE t_menu_permission
(
    id            int                                NOT NULL AUTO_INCREMENT comment '关系编号',
    permission_id int                                NOT NULL,
    menu_id       int                                NOT NULL,
    enabled       bit      DEFAULT true comment '是否启用',
    create_by     bigint                             NOT NULL comment '创建人',
    create_time   datetime DEFAULT current_timestamp NOT NULL comment '创建时间',
    update_by     bigint comment '更新人',
    update_time   datetime DEFAULT current_timestamp comment '更新时间',
    CONSTRAINT t_menu_permission_pk PRIMARY KEY (id)
) comment ='菜单权限关联表' ENGINE = InnoDB;


DROP TABLE IF EXISTS t_button_permission;
CREATE TABLE t_button_permission
(
    id                     int                                NOT NULL comment '按钮权限编号',
    button_permission_code varchar(255)                       NOT NULL comment '按钮权限字符',
    button_name            varchar(255)                       NOT NULL comment '按钮名称',
    enabled                bit      DEFAULT true comment '是否启用',
    deleted                bit      DEFAULT false comment '逻辑删除字段',
    create_by              bigint                             NOT NULL comment '创建人',
    create_time            datetime DEFAULT current_timestamp NOT NULL comment '创建时间',
    update_by              bigint comment '更新人',
    update_time            datetime DEFAULT current_timestamp comment '更新时间',
    permission_id          int                                NOT NULL,
    CONSTRAINT t_button_permission_pk PRIMARY KEY (id),
    UNIQUE INDEX (button_permission_code)
) comment ='按钮权限关联信息表' ENGINE = InnoDB;
