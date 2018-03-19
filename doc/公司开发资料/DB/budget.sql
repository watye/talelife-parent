-- --------------------------------------------- 预算系统表  --------------------------------------------------------------------------------------
-- 系统业务上的分类表
drop table  IF EXISTS t_sys_category ;   
CREATE TABLE `t_sys_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父节点',
  `code` varchar(100) DEFAULT NULL,
  `sort_num` int(11) DEFAULT '0' COMMENT '排序',
  `name` varchar(255) NOT NULL COMMENT '类型名称',
  `node_path` varchar(255) DEFAULT NULL COMMENT '树路径',
  `remark` varchar(256) DEFAULT NULL,
  
  
  `createby` BIGINT(20) NULL COMMENT '创建日期',
  `createby_name` VARCHAR(50) NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  
  `updateby` BIGINT(20) NULL COMMENT '更新日期',
  `updateby_name` VARCHAR(50) NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期',
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_cate_code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统分类信息表';

insert into t_sys_category(pid,code,sn,name,node_path,app_code,create_date,update_date) values (-1,'dictionary',0,'数据字典','1,','1000',now(),now());
insert into t_sys_category(pid,code,sn,name,node_path,app_code,create_date,update_date) values (-1,'act_category',0,'流程分类','2,','1000',now(),now());

-- 系统字典表； 
DROP TABLE  IF EXISTS  t_sys_dictionary ;
CREATE TABLE `t_sys_dictionary` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `pid` BIGINT(20) DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL COMMENT '显示的中文名称',
  `value` VARCHAR(255) DEFAULT NULL COMMENT '值',
  `code` VARCHAR(255) NOT NULL COMMENT '编码',
  `category_code` VARCHAR(255) DEFAULT 'dictionary' COMMENT '分类代码',
  `sort_num` INT(11) DEFAULT '0' COMMENT '排序',
  `node_path` VARCHAR(1000) DEFAULT NULL,
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NULL COMMENT '创建日期',
  `createby_name` VARCHAR(50) NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  
  `updateby` BIGINT(20) NULL COMMENT '更新日期',
  `updateby_name` VARCHAR(50) NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期',
   
   `app_code` VARCHAR(50) DEFAULT NULL COMMENT '应用编码 1000=平台 2000=预算系统',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_dic_name_code` (`code`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='字典名称';

INSERT INTO t_sys_dictionary(id,pid,`name`,`value`,code,category_code,node_path,remark,createby,createby_name,create_date,updateby,updateby_name,update_date,app_code) VALUES (1,-1,'性别','sex','sex','dictionary','1,','性别',1,'admin',NOW(),1,'admin',NOW(),1000) ;
INSERT INTO t_sys_dictionary(id,pid,`name`,`value`,code,category_code,node_path,remark,createby,createby_name,create_date,updateby,updateby_name,update_date,app_code) VALUES (2,1,'男','man','man','dictionary','1,2,','男',1,'admin',NOW(),1,'admin',NOW(),1000) ;
INSERT INTO t_sys_dictionary(id,pid,`name`,`value`,code,category_code,node_path,remark,createby,createby_name,create_date,updateby,updateby_name,update_date,app_code) VALUES (3,1,'女','woman','woman','dictionary','1,3,','女',1,'admin',NOW(),1,'admin',NOW(),1000);

-- 插入56个民族
INSERT INTO t_sys_dictionary(id,pid,name,value,code,category_code,node_path,remark,createby,createby_name,create_date,updateby,updateby_name,update_date,app_code) VALUES (4,-1,'民族','nation','nation','dictionary','4,','民族',1,'admin',NOW(),1,'admin',NOW(),1000);
insert into t_sys_dictionary (pid,name,value,code) values(4,'汉族','Han','Han');
insert into t_sys_dictionary (pid,name,value,code) values(4,'阿昌族','Achang','Achang');
insert into t_sys_dictionary (pid,name,value,code) values(4,'白族','Bai','Bai');
insert into t_sys_dictionary (pid,name,value,code) values(4,'布朗族','Blang','Blang');
insert into t_sys_dictionary (pid,name,value,code) values(4,'保安族','Bonan','Bonan');
insert into t_sys_dictionary (pid,name,value,code) values(4,'布依族','Buyei','Buyei');
insert into t_sys_dictionary (pid,name,value,code) values(4,'傣族','Dai','Dai');
insert into t_sys_dictionary (pid,name,value,code) values(4,'达斡尔族','Daur','Daur');
insert into t_sys_dictionary (pid,name,value,code) values(4,'独龙族','Derung','Derung');
insert into t_sys_dictionary (pid,name,value,code) values(4,'侗族','Dong','Dong');
insert into t_sys_dictionary (pid,name,value,code) values(4,'东乡族','Dongxiang','Dongxiang');
insert into t_sys_dictionary (pid,name,value,code) values(4,'鄂温克族','Evenk','Evenk');
insert into t_sys_dictionary (pid,name,value,code) values(4,'高山族','Gaoshan','Gaoshan');
insert into t_sys_dictionary (pid,name,value,code) values(4,'仡佬族','Gelao','Gelao');
insert into t_sys_dictionary (pid,name,value,code) values(4,'哈尼族','HaNi','HaNi');
insert into t_sys_dictionary (pid,name,value,code) values(4,'回族','Hui','Hui');
insert into t_sys_dictionary (pid,name,value,code) values(4,'景颇族','Jingpo','Jingpo');
insert into t_sys_dictionary (pid,name,value,code) values(4,'基诺族','Jino','Jino');
insert into t_sys_dictionary (pid,name,value,code) values(4,'哈萨克族','Kazakh','Kazakh');
insert into t_sys_dictionary (pid,name,value,code) values(4,'京族','Kinh','Kinh');
insert into t_sys_dictionary (pid,name,value,code) values(4,'朝鲜族','Korean','Korean');
insert into t_sys_dictionary (pid,name,value,code) values(4,'柯尔克孜族','Kyrgyz','Kyrgyz');
insert into t_sys_dictionary (pid,name,value,code) values(4,'拉祜族','Lahu','Lahu');
insert into t_sys_dictionary (pid,name,value,code) values(4,'珞巴族','Lhoba','Lhoba');
insert into t_sys_dictionary (pid,name,value,code) values(4,'黎族','Li','Li');
insert into t_sys_dictionary (pid,name,value,code) values(4,'傈僳族','Lisu','Lisu');
insert into t_sys_dictionary (pid,name,value,code) values(4,'满族','Manchu','Manchu');
insert into t_sys_dictionary (pid,name,value,code) values(4,'毛难族','Maonan','Maonan');
insert into t_sys_dictionary (pid,name,value,code) values(4,'苗族','Miao','Miao');
insert into t_sys_dictionary (pid,name,value,code) values(4,'蒙古族','Mongolian','Mongolian');
insert into t_sys_dictionary (pid,name,value,code) values(4,'土族','Monguor','Monguor');
insert into t_sys_dictionary (pid,name,value,code) values(4,'门巴族','Monpa','Monpa');
insert into t_sys_dictionary (pid,name,value,code) values(4,'仫佬族','Mulao','Mulao');
insert into t_sys_dictionary (pid,name,value,code) values(4,'纳西族','Nakhi','Nakhi');
insert into t_sys_dictionary (pid,name,value,code) values(4,'赫哲族','Nanai','Nanai');
insert into t_sys_dictionary (pid,name,value,code) values(4,'怒族','Nu','Nu');
insert into t_sys_dictionary (pid,name,value,code) values(4,'鄂伦春族','Oroqen','Oroqen');
insert into t_sys_dictionary (pid,name,value,code) values(4,'其他','Other','Other');
insert into t_sys_dictionary (pid,name,value,code) values(4,'崩龙族','Palaung','Palaung');
insert into t_sys_dictionary (pid,name,value,code) values(4,'普米族','Pumi','Pumi');
insert into t_sys_dictionary (pid,name,value,code) values(4,'羌族','Qiang','Qiang');
insert into t_sys_dictionary (pid,name,value,code) values(4,'俄罗斯族','Russian','Russian');
insert into t_sys_dictionary (pid,name,value,code) values(4,'撒拉族','Salar','Salar');
insert into t_sys_dictionary (pid,name,value,code) values(4,'畲族','She','She');
insert into t_sys_dictionary (pid,name,value,code) values(4,'水族','Shui','Shui');
insert into t_sys_dictionary (pid,name,value,code) values(4,'塔吉克族','Tajik','Tajik');
insert into t_sys_dictionary (pid,name,value,code) values(4,'塔塔尔族','Tatar','Tatar');
insert into t_sys_dictionary (pid,name,value,code) values(4,'藏族','Tibetan','Tibetan');
insert into t_sys_dictionary (pid,name,value,code) values(4,'土家族','Tujia','Tujia');
insert into t_sys_dictionary (pid,name,value,code) values(4,'维吾尔族','Uyghur','Uyghur');
insert into t_sys_dictionary (pid,name,value,code) values(4,'乌孜别克族','Uzbek','Uzbek');
insert into t_sys_dictionary (pid,name,value,code) values(4,'佤族','Va','Va');
insert into t_sys_dictionary (pid,name,value,code) values(4,'锡伯族','Xibe','Xibe');
insert into t_sys_dictionary (pid,name,value,code) values(4,'瑶族','Yao','Yao');
insert into t_sys_dictionary (pid,name,value,code) values(4,'彝族','Yi','Yi');
insert into t_sys_dictionary (pid,name,value,code) values(4,'裕固族','Yughur','Yughur');
insert into t_sys_dictionary (pid,name,value,code) values(4,'壮族','Zhuang','Zhuang');

SET SQL_SAFE_UPDATES=0;
UPDATE t_sys_dictionary SET node_path=CONCAT(CONCAT('4,',id),',') WHERE node_path IS NULL;
UPDATE t_sys_dictionary SET remark=NAME,createby=1,createby_name='admin',create_date=NOW(),updateby=1,updateby_name='admin',update_date=NOW(),app_code=1000 WHERE app_code IS NULL ;


-- 添加数据集条件参数运算符字典
INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('-1', '数据集参数运算符', '1', 'paramCalculateType', 'dictionary', '0', '62,', '数据集参数运算符', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '等于', '1', 'equal', 'dictionary', '0', '62,63,', '等于', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '不等于', '2', 'not_equal', 'dictionary', '0', '62,64,', '不等于', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '小于', '3', 'lt', 'dictionary', '0', '62,65,', '小于', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '小于等于', '4', 'lt_equal', 'dictionary', '0', '62,66,', '小于等于', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '大于', '5', 'gt', 'dictionary', '0', '62,67,', '大于', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '大于等于', '6', 'gt_equal', 'dictionary', '0', '62,68,', '大于等于', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '包含', '7', 'contain', 'dictionary', '0', '62,69,', '包含', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');

INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ( '62', '不包含', '8', 'un_contain', 'dictionary', '0', '62,70,', '不包含', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


-- 添加数据集变量
INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('-1', '数据集参数变量', '1', 'variableType', 'dictionary', '0', '71,', '数据集参数变量', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('71', '预算年度', '1', 'budget_year', 'dictionary', '0', '71,72,', '预算年度', '1', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('71', '上一年度', '1', 'budget_last_year', 'dictionary', '0', '71,73,', '上一年度', '2', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('71', '预算单元', '1', 'budget_unit', 'dictionary', '0', '71,74,', '预算单元', '3', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('71', '操作员', '1', 'operator', 'dictionary', '0', '71,75,', '预算单元', '4', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


INSERT INTO `t_sys_dictionary` ( `pid`, `name`, `value`, `code`, `category_code`, `sort_num`, `node_path`, `remark`, `createby`, `createby_name`, `create_date`, `updateby`, `updateby_name`, `update_date`) 
VALUES ('71', '静态值', '1', 'static_value', 'dictionary', '0', '71,76,', '预算单元', '5', 'admin', '2017-02-27 19:49:30', '1', 'admin', '2017-02-27 19:49:30');


-- -----------------------------------------------------------预算系统业务表 -----------------------------------------------------------------


DROP TABLE  IF EXISTS  t_datasource ;
CREATE TABLE `t_datasource` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(40) NOT NULL COMMENT '数据源编码',
  `name` VARCHAR(255) NOT NULL COMMENT '数据源名称',
  `type` VARCHAR(255) NOT NULL COMMENT '数据源类型: 1=db 2=webservice 3=http(json)',
  
  `login_name` VARCHAR(255) NULL COMMENT '登陆名称',
  `login_password` VARCHAR(255) NULL COMMENT '登陆密码',
  `login_default_db` VARCHAR(255) NULL COMMENT '登陆的默认数据库名',
  
  `url` VARCHAR(500) DEFAULT NULL COMMENT '链接url',
  `status` INT(4) DEFAULT '1' COMMENT '连接状态：1=连接正常 0=连接异常',
  `enable` INT(4) DEFAULT '1' COMMENT '启用：1=可用 0=停用',
  
  `address` VARCHAR(255) DEFAULT NULL COMMENT '地址,可以是ip也可以是域名',
  `port` VARCHAR(20) DEFAULT NULL COMMENT '端口',
  `sort_num` INT(11) DEFAULT '0' COMMENT '排序',

  `driver_class_Name` VARCHAR(500) NOT NULL COMMENT '驱动名,如: com.mysql.jdbc.Driver',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期',
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_ds_code` (`code`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='预算编制:数据源连接管理表';



DROP TABLE  IF EXISTS  t_dataset ;
CREATE TABLE `t_dataset` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `datasource_code` VARCHAR(40) NOT NULL COMMENT '数据源编码',
  `datasource_name` VARCHAR(40) NULL COMMENT '数据源名称',
  `name` VARCHAR(255) NOT NULL COMMENT '数据集的名称',
  `status` INT(4) DEFAULT '1' COMMENT '连接状态：1=正常 0=异常',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'

) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据集定义';


DROP TABLE  IF EXISTS  t_template ;
CREATE TABLE `t_template` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(40) NOT NULL COMMENT '模板编码',
  `name` VARCHAR(255) NOT NULL COMMENT '模板名称',
  `status` INT(4) DEFAULT '1' COMMENT '启用：1=可用 0=停用',
  `sort_num` INT(11) DEFAULT '0' COMMENT '排序',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期',
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_tmpl_code` (`code`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='预算编制模板';

















DROP TABLE  IF EXISTS  t_period_managed ;
CREATE TABLE `t_period_managed` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL COMMENT '期间名称',
  `year` TINYINT NOT NULL COMMENT '年度', 
  `type` VARCHAR(4) NOT NULL COMMENT '周期类型 1=年 2=半年 3=季  4=月', 
  `start_time` DATETIME DEFAULT NULL COMMENT '开始时间',
  `end_time` DATETIME DEFAULT NULL COMMENT '结束时间',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',
  
  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='管理期间';


DROP TABLE  IF EXISTS  t_category_operated_goal ;
CREATE TABLE `t_category_operated_goal` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL COMMENT '期间名称',
  `year` TINYINT NOT NULL COMMENT '年度', 
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',
  
  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='经营目标分类';

  
  
DROP TABLE  IF EXISTS  t_unit_type ;
CREATE TABLE `t_unit_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL COMMENT '类型名称',
  `status` VARCHAR(4) NOT NULL COMMENT '状态: 1=启用 0=禁用', 
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',
  
  
  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='预算单元类型';

  
  
DROP TABLE  IF EXISTS  t_unit_budget ;
CREATE TABLE `t_unit_budget` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `unit_id` BIGINT(20) NOT NULL COMMENT '组织架构表的ID',
  `unit_name` BIGINT(20) NOT NULL COMMENT '单元名称',
  
  `type_deduction` VARCHAR(2) NOT NULL COMMENT '是否扣减单元: 1=是 0=否',
  `type_prop` VARCHAR(2) NOT NULL COMMENT '单元属性: 1=填报单元 2=汇总单元',
  `type` VARCHAR(2) NOT NULL COMMENT '预算单元类型: 1=直属经营  2=创新经营',
  
  `prepared_obj_type` VARCHAR(2) NOT NULL default '0' COMMENT '预算编制对象:0=岗位,1=用户 默认是岗位(多个以逗号分割)',
  `prepared_obj_ids` VARCHAR(1000) NOT NULL COMMENT '预算编制对象:岗位,默认是岗位(多个以逗号分割)',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='预算单元,本质是组织架构的一个扩展表';
  
  
  -- 预算控制规则设置表(伟耀添加到下面)
  
  
  
  
  
  
DROP TABLE  IF EXISTS  t_fund_type ;
CREATE TABLE `t_fund_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `pid` BIGINT(20) ,
  `code` varchar(20) comment '类型编码',
  `year` TINYINT NOT NULL COMMENT '年度', 
  `name` BIGINT(20) NOT NULL COMMENT '款项类型名称',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',
  `node_path` VARCHAR(1000) DEFAULT NULL COMMENT '节点路径',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期',
  UNIQUE KEY `uq_fund_type_code` (`code`) 
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='款项类型设置';
  
  
DROP TABLE  IF EXISTS  t_fund_type_item ;
CREATE TABLE `t_fund_type_item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `fund_type_id` BIGINT(20) comment '款项类型ID',
  `item_code` varchar(20) comment '科目编码',
  
  `year` TINYINT NOT NULL COMMENT '年度', 
  `name` BIGINT(20) NOT NULL COMMENT '项目名称',
  `status` VARCHAR(4) DEFAULT NULL COMMENT '状态 1=启用 0=停用',
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='款项类型设置';
  
  
  
DROP TABLE  IF EXISTS  t_budget_param_set ;
CREATE TABLE `t_budget_param_set` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(20) comment '名称',
  `digit` TINYINT comment '小数点位数',
  
  `act_set` varchar(20) comment '工作流启用设置 1=启用  0=不启用',
  `act_def_key` varchar(200) comment '流程模板(也就是流程定义)',
  
  `remark` VARCHAR(256) DEFAULT NULL COMMENT '备注',

  `createby` BIGINT(20) NOT NULL COMMENT '创建人',
  `createby_name` VARCHAR(50) NOT NULL COMMENT '创建人名称',
  `create_date` DATETIME DEFAULT NULL COMMENT '创建时间',
  `updateby` BIGINT(20) NOT NULL COMMENT '更新人',
  `updateby_name` VARCHAR(50) NOT NULL COMMENT '更新人名称',
  `update_date` DATETIME DEFAULT NULL COMMENT '更新日期'
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='预算参数设置';
  
  
  