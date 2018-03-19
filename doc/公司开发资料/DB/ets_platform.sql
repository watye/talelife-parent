drop database if exists ets_platform;

create database ets_platform;

use ets_platform;

/*==============================================================*/
/* table: t_estate_project_info                                 */
/*==============================================================*/
create table t_estate_project_info
(
   project_id           bigint not null auto_increment comment '小区id',
   manage_project_id    bigint not null comment '管理项目id',
   project_name         varchar(50) not null default '' comment '小区名称(项目名称)',
   project_addr         varchar(100) not null default '' comment '小区地址',
   project_addr_detail  varchar(200) not null default '' comment '详细地址',
   province_id          varchar(32) not null default '' comment '省id',
   city_id              varchar(32) not null default '' comment '城市id',
   county_id            varchar(32) not null default '' comment '区域id',
   street_id            varchar(32) not null default '' comment '街道id',
   community_id         varchar(32) not null default '' comment '社区id',
   building_area        decimal(21,6) comment '建筑面积',
   complete_date        datetime comment '竣工日期',
   delivery_date        datetime comment '接管(交房)日期',
   status               tinyint not null default 1 comment '状态(1启用2停用)',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (project_id)
);

alter table t_estate_project_info comment '房档_小区信息表';

/*==============================================================*/
/* index: ix1_t_estate_project_info                             */
/*==============================================================*/
create index ix1_t_estate_project_info on t_estate_project_info
(
   manage_project_id
);

/*==============================================================*/
/* table: t_org_company_info                                    */
/*==============================================================*/
create table t_org_company_info
(
   company_id           bigint not null comment '公司id',
   company_name         varchar(50) not null default '' comment '公司名称',
   remark               varchar(200) not null default '' comment '备注',
   org_unit_level       tinyint not null comment '组织单元级别（1集团2区域公司3公司4管理项目5部门6工作组）',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (company_id)
);

alter table t_org_company_info comment '组织_区域公司、分公司';

/*==============================================================*/
/* table: t_org_department                                      */
/*==============================================================*/
create table t_org_department
(
   pk                   bigint not null auto_increment comment 'pk',
   org_unit_id          bigint not null comment '组织单元id',
   department_id        bigint not null comment '部门id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   primary key (pk)
);

alter table t_org_department comment '组织_组织部门关系';

/*==============================================================*/
/* index: uk_t_org_department                                   */
/*==============================================================*/
create unique index uk_t_org_department on t_org_department
(
   org_unit_id,
   department_id
);

/*==============================================================*/
/* table: t_org_department_info                                 */
/*==============================================================*/
create table t_org_department_info
(
   department_id        bigint not null auto_increment comment '部门id',
   department_name      varchar(50) not null default '' comment '部门名称',
   department_fullname  varchar(100) not null default '' comment '部门全称',
   org_unit_level       tinyint not null comment '部门级别（1集团2区域公司3公司4管理项目5部门6工作组）',
   org_unit_id          bigint not null comment '组织单元id/父部门id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (department_id)
);

alter table t_org_department_info comment '组织_部门信息表，部门级别=4，部门级别id=父节点';

/*==============================================================*/
/* index: ix1_t_org_department_info                             */
/*==============================================================*/
create index ix1_t_org_department_info on t_org_department_info
(
   org_unit_id
);

/*==============================================================*/
/* table: t_org_duties_info                                     */
/*==============================================================*/
create table t_org_duties_info
(
   duties_id            bigint not null auto_increment comment '岗位id',
   duties_name          varchar(50) not null default '' comment '岗位名称',
   remark               varchar(200) not null default '' comment '岗位职责',
   direct_duties_id     bigint not null comment '直属上级',
   direct_duties_name   varchar(32) not null default '' comment '直属上级名称',
   org_unit_level       tinyint not null comment '岗位级别（1集团2区域公司3公司4管理项目5部门6工作组）',
   org_unit_id          bigint not null comment '组织单元id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (duties_id)
);

alter table t_org_duties_info comment '组织_岗位信息表';

/*==============================================================*/
/* index: ix1_t_org_duties_info                                 */
/*==============================================================*/
create index ix1_t_org_duties_info on t_org_duties_info
(
   org_unit_id
);

/*==============================================================*/
/* table: t_org_group_info                                      */
/*==============================================================*/
create table t_org_group_info
(
   group_id             bigint not null comment '集团id',
   group_name           varchar(50) not null default '' comment '集团名称',
   remark               varchar(200) not null default '' comment '备注',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (group_id)
);

alter table t_org_group_info comment '组织_集团';

/*==============================================================*/
/* table: t_org_manage_project_info                             */
/*==============================================================*/
create table t_org_manage_project_info
(
   manage_project_id    bigint not null comment '管理项目id',
   manage_project_name  varchar(50) not null default '' comment '管理项目名称',
   remark               varchar(200) not null default '' comment '备注',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (manage_project_id)
);

alter table t_org_manage_project_info comment '组织_管理项目';

/*==============================================================*/
/* table: t_org_unit_info                                       */
/*==============================================================*/
create table t_org_unit_info
(
   org_unit_id          bigint not null auto_increment comment '组织单元id',
   org_unit_name        varchar(50) not null default '' comment '组织名称',
   org_unit_fullname    varchar(200) not null default '' comment '组织单元全称',
   org_unit_level       tinyint not null comment '组织单元级别（1集团2区域公司3公司4管理项目5部门6工作组）',
   parent_org_unit_id   bigint not null default 0 comment '父节点',
   order_no             int not null default 0 comment '排序',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (org_unit_id)
);

alter table t_org_unit_info comment '组织_组织，组织的根节点：新增第一个节点的时候，需要创建虚拟节点为根节点
组织单元id=集团id，组织单元级';

/*==============================================================*/
/* index: ix1_t_org_unit_info                                   */
/*==============================================================*/
create index ix1_t_org_unit_info on t_org_unit_info
(
   parent_org_unit_id
);

/*==============================================================*/
/* table: t_power_data_res_info                                 */
/*==============================================================*/
create table t_power_data_res_info
(
   data_id              bigint not null auto_increment comment '资源id',
   data_name            varchar(32) not null default '' comment '数据资源名称',
   data_desc            varchar(100) not null default '' comment '资源描述',
   table_name           varchar(32) not null default '' comment '表名',
   column_name          varchar(32) not null default '' comment '字段',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (data_id)
);

alter table t_power_data_res_info comment '权限_数据资源';

/*==============================================================*/
/* table: t_power_duties_role                                   */
/*==============================================================*/
create table t_power_duties_role
(
   pk                   bigint not null auto_increment comment 'pk',
   role_id              bigint not null comment '角色id',
   duties_id            bigint not null comment '岗位id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   primary key (pk)
);

alter table t_power_duties_role comment '权限_部门角色关系';

/*==============================================================*/
/* index: uk_t_power_duties_role                                */
/*==============================================================*/
create unique index uk_t_power_duties_role on t_power_duties_role
(
   duties_id,
   role_id
);

/*==============================================================*/
/* table: t_power_menu_func                                     */
/*==============================================================*/
create table t_power_menu_func
(
   menu_func_id         bigint not null auto_increment comment '菜单功能id',
   func_id              bigint not null comment '功能id',
   menu_id              bigint not null comment '菜单id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   primary key (menu_func_id)
);

alter table t_power_menu_func comment '权限_菜单功能关系';

/*==============================================================*/
/* index: uk_t_power_menu_func                                  */
/*==============================================================*/
create unique index uk_t_power_menu_func on t_power_menu_func
(
   menu_id,
   func_id
);

/*==============================================================*/
/* table: t_power_range_res_info                                */
/*==============================================================*/
create table t_power_range_res_info
(
   range_id             bigint not null auto_increment comment '资源id',
   range_name           varchar(32) not null default '' comment '数据资源名称',
   range_desc           varchar(100) not null default '' comment '资源描述',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (range_id)
);

alter table t_power_range_res_info comment '权限_数据范围';

/*==============================================================*/
/* table: t_power_res_func_info                                 */
/*==============================================================*/
create table t_power_res_func_info
(
   func_id              bigint not null auto_increment comment '功能id',
   func_name            varchar(32) not null default '' comment '功能名称',
   func_desc            varchar(100) not null default '' comment '功能描述',
   func_code            varchar(32) not null default '' comment '功能code',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (func_id)
);

alter table t_power_res_func_info comment '权限_按钮';

/*==============================================================*/
/* table: t_power_res_menu_info                                 */
/*==============================================================*/
create table t_power_res_menu_info
(
   menu_id              bigint not null auto_increment comment '菜单id',
   menu_name            varchar(32) not null default '' comment '菜单名称',
   menu_code            varchar(32) not null default '' comment '菜单code',
   menu_order           int not null default 0 comment '菜单顺序',
   menu_url             varchar(200) not null default '' comment '菜单url',
   menu_icon            varchar(50) not null default '' comment '菜单图标',
   menu_desc            varchar(100) not null default '' comment '菜单描述',
   pri_menu_id          bigint not null comment '父级菜单id（根结节点-1）',
   menu_type            tinyint comment '菜单类型(1pc2app3pad)',
   menu_level           tinyint not null comment '菜单层级（根节点为1）',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (menu_id)
);

alter table t_power_res_menu_info comment '权限_菜单';

/*==============================================================*/
/* table: t_power_role_data_res                                 */
/*==============================================================*/
create table t_power_role_data_res
(
   pk                   bigint not null auto_increment comment 'pk',
   role_id              bigint not null comment '角色id',
   data_id              bigint not null comment '资源id',
   data_value           bigint not null comment '资源分类值',
   data_desc            varchar(100) not null default '' comment '资料描述',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (pk)
);

alter table t_power_role_data_res comment '权限_角色数据资源关系';

/*==============================================================*/
/* index: uk_t_power_role_data_res                              */
/*==============================================================*/
create unique index uk_t_power_role_data_res on t_power_role_data_res
(
   role_id,
   data_id
);

/*==============================================================*/
/* table: t_power_role_info                                     */
/*==============================================================*/
create table t_power_role_info
(
   role_id              bigint not null auto_increment comment '角色id',
   role_type_id         bigint not null comment '角色分类id',
   role_type            tinyint not null comment '角色类型(1独立2员工3岗位)',
   role_name            varchar(32) not null default '' comment '角色名称',
   role_desc            varchar(100) not null default '' comment '角色描述',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (role_id)
);

alter table t_power_role_info comment '权限_角色
1、角色类型(1独立2员工3岗位)
2、删除岗位，需要删除岗位相对应的角色，还有角色';

/*==============================================================*/
/* index: ix1_t_power_role_info                                 */
/*==============================================================*/
create index ix1_t_power_role_info on t_power_role_info
(
   role_type_id
);

/*==============================================================*/
/* table: t_power_role_menu_func_operation                      */
/*==============================================================*/
create table t_power_role_menu_func_operation
(
   pk                   bigint not null auto_increment comment 'pk',
   role_id              bigint not null comment '角色id',
   menu_func_id         bigint not null comment 'menu_func_id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   primary key (pk)
);

alter table t_power_role_menu_func_operation comment '权限_角色菜单功能关系';

/*==============================================================*/
/* index: uk_t_power_role_menu_func_operation                   */
/*==============================================================*/
create unique index uk_t_power_role_menu_func_operation on t_power_role_menu_func_operation
(
   role_id,
   menu_func_id
);

/*==============================================================*/
/* table: t_power_role_menu_operation                           */
/*==============================================================*/
create table t_power_role_menu_operation
(
   pk                   bigint not null auto_increment comment 'pk',
   menu_id              bigint not null comment '菜单id',
   role_id              bigint not null comment '角色id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   primary key (pk)
);

alter table t_power_role_menu_operation comment '权限_角色菜单关系';

/*==============================================================*/
/* index: uk_t_power_role_menu_operation                        */
/*==============================================================*/
create unique index uk_t_power_role_menu_operation on t_power_role_menu_operation
(
   role_id,
   menu_id
);

/*==============================================================*/
/* table: t_power_role_range_res                                */
/*==============================================================*/
create table t_power_role_range_res
(
   pk                   bigint not null auto_increment comment 'pk',
   role_id              bigint not null comment '角色id',
   range_id             bigint not null comment '资源id',
   range_value          bigint not null comment '资源分类值',
   range_desc           varchar(100) not null default '' comment '资料描述',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (pk)
);

alter table t_power_role_range_res comment '权限_角色数据范围关系';

/*==============================================================*/
/* index: uk_t_power_role_range_res                             */
/*==============================================================*/
create unique index uk_t_power_role_range_res on t_power_role_range_res
(
   role_id,
   range_id
);

/*==============================================================*/
/* table: t_power_role_type                                     */
/*==============================================================*/
create table t_power_role_type
(
   role_type_id         bigint not null auto_increment comment '角色分类id',
   role_type_name       varchar(50) not null default '' comment '角色分类名称',
   parent_role_type_id  bigint not null default 0 comment '父角色分类id',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (role_type_id)
);

alter table t_power_role_type comment '权限_角色分类';

/*==============================================================*/
/* index: ix1_t_power_role_type                                 */
/*==============================================================*/
create index ix1_t_power_role_type on t_power_role_type
(
   parent_role_type_id
);

/*==============================================================*/
/* table: t_user_department                                     */
/*==============================================================*/
create table t_user_department
(
   pk                   bigint not null auto_increment comment 'pk',
   duties_id            bigint not null comment '岗位id',
   user_id              bigint not null comment '用户id',
   user_name            varchar(32) not null default '' comment '用户名称',
   duties_type          tinyint not null default 1 comment '岗位类型(1主职2兼职)',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   primary key (pk)
);

alter table t_user_department comment '用户_用户隶属岗位表';

/*==============================================================*/
/* index: uk_t_user_department                                  */
/*==============================================================*/
create unique index uk_t_user_department on t_user_department
(
   duties_id,
   user_id
);

/*==============================================================*/
/* table: t_user_info                                           */
/*==============================================================*/
create table t_user_info
(
   user_id              bigint not null auto_increment comment '用户id',
   user_name            varchar(32) not null default '' comment '用户名称（客户名称）',
   user_sex             tinyint comment '性别(1男2女)',
   nation               varchar(10) not null default '' comment '民族',
   birthday             datetime comment '出生日期',
   work_no              varchar(32) not null default '' comment '用户名（默认手机号）',
   login_no             varchar(32) not null default '' comment '账号',
   password             char(32) not null default '' comment '密码',
   pwd_salt             char(8) not null default '' comment '加密盐值：8位随机数',
   mobile_phone         varchar(11) not null default '' comment '手机号(注册手机号)',
   user_phone           varchar(12) not null default '' comment '座机',
   user_email           varchar(50) not null default '' comment '邮箱',
   createby             bigint not null comment '创建者id',
   createby_name        varchar(32) not null default '' comment '创建者名称',
   create_date          datetime not null comment '创建时间',
   updateby             bigint comment '修改者id',
   updateby_name        varchar(32) not null default '' comment '修改者名称',
   update_date          datetime comment '修改时间',
   primary key (user_id)
);

alter table t_user_info comment '用户_员工信息表，住户跟多个组织交换名片，在用户表就存在多个userid；员工名片是独立的userid';

/*==============================================================*/
/* index: uk1_t_user_info                                       */
/*==============================================================*/
create unique index uk1_t_user_info on t_user_info
(
   work_no
);

/*==============================================================*/
/* index: uk2_t_user_info                                       */
/*==============================================================*/
create unique index uk2_t_user_info on t_user_info
(
   login_no
);
