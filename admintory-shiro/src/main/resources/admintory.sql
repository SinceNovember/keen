-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: admintory
-- ------------------------------------------------------
-- Server version	5.7.24-log

--
-- Table structure for table `t_code_item`
--
CREATE DATABASE `admintory`;

DROP TABLE IF EXISTS `t_code_item`;
CREATE TABLE `t_code_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '代码项ID',
  `item_text` varchar(100) DEFAULT NULL COMMENT '代码项内容',
  `item_value` varchar(100) DEFAULT NULL COMMENT '代码项值',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `code_id` bigint(20) DEFAULT NULL COMMENT '代码ID',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='代码项表';


--
-- Dumping data for table `t_code_item`
--

LOCK TABLES `t_code_item` WRITE;
INSERT INTO `t_code_item` VALUES (1,'男','MALE',2,NULL,1),(5,'女','FEMALE',0,'2021-12-06 17:00:28',1),(20,'启用','VALID',0,'2021-12-07 14:13:44',13),(21,'禁用','LOCK',0,'2021-12-07 14:13:50',13);
UNLOCK TABLES;

--
-- Table structure for table `t_code_main`
--

DROP TABLE IF EXISTS `t_code_main`;
CREATE TABLE `t_code_main` (
  `code_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '代码ID',
  `code_name` varchar(100) DEFAULT NULL COMMENT '代码名称',
  `description` varchar(100) DEFAULT NULL COMMENT '代码描述',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='代码表';


--
-- Dumping data for table `t_code_main`
--

LOCK TABLES `t_code_main` WRITE;
INSERT INTO `t_code_main` VALUES (1,'性别','用户性别',0,NULL),(13,'状态','',0,'2021-12-07 14:13:32');
UNLOCK TABLES;

--
-- Table structure for table `t_dept`
--

DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '上级部门ID',
  `dept_name` varchar(100) NOT NULL COMMENT '部门名称',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建者ID',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标志',
  `dept_short_name` varchar(100) DEFAULT NULL COMMENT '部门简称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`dept_id`) USING BTREE,
  KEY `t_dept_parent_id` (`parent_id`),
  KEY `t_dept_dept_name` (`dept_name`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';


--
-- Dumping data for table `t_dept`
--

LOCK TABLES `t_dept` WRITE;
INSERT INTO `t_dept` VALUES (1,0,'开发部',93,1,'2019-06-14 20:56:41',NULL,0,NULL,NULL),(2,1,'开发一部',93,1,'2019-06-14 20:58:46',NULL,0,NULL,NULL),(3,2,'开发二部',93,2,'2019-06-14 20:58:56',NULL,0,NULL,NULL),(4,0,'采购部',93,2,'2019-06-14 20:59:56',NULL,0,NULL,NULL),(5,0,'财务部',93,3,'2019-06-14 21:00:08',NULL,0,NULL,NULL),(6,0,'销售部',93,4,'2019-06-14 21:00:15',NULL,0,NULL,NULL),(7,0,'工程部',93,5,'2019-06-14 21:00:42',NULL,0,NULL,NULL),(8,0,'行政部',93,6,'2019-06-14 21:00:49',NULL,0,NULL,NULL),(9,20,'人力资源部',93,8,'2019-06-14 21:01:14','2021-12-19 19:21:20',0,NULL,NULL),(20,0,'个人部门',93,99,'2021-10-21 14:23:28','2021-11-12 20:21:41',0,'',''),(21,1,'大数据研发部',93,99,'2021-10-21 14:23:48','2021-12-20 20:44:09',0,'bigdata',''),(53,0,'系统管理部',93,0,'2021-11-18 15:30:12','2021-11-18 15:30:12',0,'',''),(56,0,'测试部门',93,0,'2021-12-21 13:18:34','2021-12-21 13:18:34',0,'','');
UNLOCK TABLES;

--
-- Table structure for table `t_log`
--

DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `nickname` varchar(50) DEFAULT NULL COMMENT '操作用户',
  `operation` text COMMENT '操作内容',
  `time` decimal(11,0) DEFAULT NULL COMMENT '耗时',
  `method` text COMMENT '操作方法',
  `params` text COMMENT '方法参数',
  `ip` varchar(64) DEFAULT NULL COMMENT '操作者IP',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `location` varchar(50) DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `t_log_create_time` (`create_time`)
) ENGINE=MyISAM AUTO_INCREMENT=2194 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志表';


--
-- Dumping data for table `t_log`
--

LOCK TABLES `t_log` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `t_login_log`

DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` varchar(50) NOT NULL COMMENT '用户名',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `location` varchar(50) DEFAULT NULL COMMENT '登录地点',
  `ip` varchar(50) DEFAULT NULL COMMENT 'IP地址',
  `system` varchar(50) DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(50) DEFAULT NULL COMMENT '浏览器',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `t_login_log_login_time` (`login_time`)
) ENGINE=MyISAM AUTO_INCREMENT=811 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='登录日志表';

--
-- Dumping data for table `t_login_log`
-

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `path` varchar(100) DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) DEFAULT NULL COMMENT '组件地址',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `is_expand` int(11) DEFAULT '0' COMMENT '是否默认展开',
  `redirect` varchar(100) DEFAULT NULL COMMENT '重定向地址',
  `title` varchar(100) DEFAULT NULL COMMENT '菜单标题',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `hidden` int(11) DEFAULT '0' COMMENT '是否隐藏',
  `affix` int(11) DEFAULT '0' COMMENT '是否固定',
  `always_show` int(11) DEFAULT '0' COMMENT '是否展示',
  `no_cache` int(11) DEFAULT '1' COMMENT '是否缓存',
  `bread_crumb` int(11) DEFAULT '1' COMMENT '面包屑',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `type` int(11) DEFAULT NULL COMMENT '（1、目录，2、菜单，3、按钮）',
  `request_method` varchar(15) DEFAULT NULL COMMENT '请求方法',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='菜单表';


--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;

INSERT INTO `t_menu` VALUES (1,'/','Layout','Dashboard',0,'dashboard','首页',NULL,NULL,0,0,1,1,1,NULL,'2021-12-13 10:10:19',0,9,1,'GET'),(2,'/dashboard','dashboard/index','Dashboard',0,NULL,'控制台','bxs-dashboard',1,0,1,1,1,1,NULL,'2021-12-13 11:13:23',0,9,2,'GET'),(3,'/system','Layout','System',1,'/system/user','系统管理','bx-cog',NULL,0,0,0,1,1,NULL,'2021-11-23 15:40:53',0,9,1,'GET'),(4,'/user','system/user/index','user',0,NULL,'用户管理','bx-user',3,0,1,1,1,1,NULL,'2021-12-17 10:08:15',0,9,2,'GET'),(5,'/role','system/role/index','role',0,NULL,'角色管理','bxs-user-detail',3,0,0,1,1,1,NULL,'2021-11-18 22:47:25',0,9,2,'GET'),(6,'/menu','system/menu/index','',1,NULL,'菜单管理','bx-menu',3,0,0,1,1,1,NULL,'2021-12-17 10:08:04',0,6,2,'GET'),(7,'/dept','system/dept/index','dept',0,NULL,'部门管理','bx-sitemap',3,0,0,1,1,1,NULL,'2021-12-17 09:46:41',0,8,2,'GET'),(11,'/monitor','Layout','Monitor',0,'/monitor/operation','系统监控','bx-webcam',NULL,0,0,1,1,1,NULL,'2021-11-24 09:58:45',0,9,1,'GET'),(67,'/api/system/role','','',0,'','删除按钮','',5,0,0,1,1,1,'2021-11-22 23:02:42','2021-11-23 00:04:39',0,NULL,3,'DELETE'),(68,'/api/system/role','','',0,'','添加按钮','',5,0,0,1,1,1,'2021-11-22 23:57:07','2021-11-23 00:04:40',0,NULL,3,'POST'),(69,'/api/system/role','','',0,'','修改按钮','',5,0,0,1,1,1,'2021-11-23 00:03:22','2021-11-23 10:30:50',0,NULL,3,'PUT'),(71,'/api/system/role/list','','',0,'','列表按钮','',5,0,0,1,1,1,'2021-11-23 08:58:11','2021-11-23 10:31:42',0,NULL,3,'GET'),(75,'/operation','monitor/operation-log/index','',0,'','操作日志','',11,0,0,1,1,1,'2021-11-23 15:42:18','2021-11-23 15:42:41',0,NULL,2,'GET'),(76,'/login','monitor/login-log/index','LoginLog',0,'','登陆日志','',11,0,0,1,1,1,'2021-11-23 15:46:26','2021-11-23 15:46:40',0,NULL,2,'GET'),(77,'/active','monitor/active/index','Active',0,'','在线用户','',11,0,0,1,1,1,'2021-11-24 13:30:50','2021-11-24 13:31:17',0,NULL,2,'GET'),(83,'/metadata','Layout','',0,'','元数据管理','bxs-data',NULL,0,0,1,1,1,'2021-12-03 15:53:16','2021-12-17 11:03:11',0,0,1,'GET'),(84,'/system','metadata/system/index','',0,'','系统参数','',83,0,0,1,1,1,'2021-12-03 15:55:42','2021-12-03 15:56:28',0,NULL,2,'GET'),(85,'/code','metadata/code/main/index','',0,'','代码管理','',83,0,0,1,1,1,'2021-12-03 15:56:26','2021-12-06 15:36:27',0,NULL,2,'GET'),(88,'/other','Layout','',0,'','其他管理','bx-list-plus',NULL,0,0,1,1,1,'2021-12-10 16:44:02','2021-12-17 11:05:49',0,0,1,'GET'),(89,'/theme','other/theme/index','',0,'','主题管理','bxs-layer',88,0,0,1,1,1,'2021-12-10 16:45:26','2021-12-17 11:07:09',0,0,2,'GET'),(91,'/base','Layout','',0,'','基础组件','',NULL,1,0,1,1,1,'2021-12-17 13:07:08','2021-12-20 10:32:40',0,0,1,'GET'),(92,'/profile','profile/index','',0,'','个人简介','',91,0,0,1,1,1,'2021-12-17 13:07:56','2021-12-20 10:32:40',0,0,2,'GET');
UNLOCK TABLES;

--
-- Table structure for table `t_menu_permission`
--

DROP TABLE IF EXISTS `t_menu_permission`;
CREATE TABLE `t_menu_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '按钮ID',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `permission_type` bigint(20) DEFAULT NULL COMMENT '权限类别（1、角色，2、部门，3、用户）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';


--
-- Dumping data for table `t_menu_permission`
--

LOCK TABLES `t_menu_permission` WRITE;
INSERT INTO `t_menu_permission` VALUES (208,2,11,2),(209,2,31,2),(224,3,9,1),(225,3,10,1),(227,4,41,3),(228,5,41,3),(229,6,41,3),(395,4,17,1),(396,5,17,1),(397,6,17,1),(401,1,6,1),(402,1,8,1),(403,1,17,1),(404,2,17,1),(405,58,17,1),(409,1,20,2),(410,1,9,2),(411,3,9,2),(412,3,53,2);
UNLOCK TABLES;

--
-- Table structure for table `t_msg`
--

DROP TABLE IF EXISTS `t_msg`;
CREATE TABLE `t_msg` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '消息',
  `from_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发送方ID',
  `to_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '接受方ID',
  `content` text COLLATE utf8_bin COMMENT '内容',
  `type` int(1) DEFAULT NULL COMMENT '发送类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_read` int(1) DEFAULT NULL COMMENT '1已读，0未读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='消息表';

--
-- Dumping data for table `t_msg`
--

LOCK TABLES `t_msg` WRITE;
INSERT INTO `t_msg` VALUES ('0807c5af-c033-4e68-93a9-60e34b868b9a','93','110','系统即将维护，请维护好在登陆。',1,'2021-12-20 17:17:15',1),('180ae0ba-8a2a-4655-85e7-05f07c53e63d','110','41','任务已完成，已成发送到邮箱。',1,'2021-12-20 21:01:18',1),('3165130c-3c25-4ae9-9a2d-283b78c9da11','41','110','用于检查',1,'2021-12-20 17:16:17',1),('3d44a833-964e-457a-8f9d-a44904ac7e98','41','93','晚上有空吗，一起吃饭',1,'2021-12-20 21:00:05',1),('4f7d629e-bc70-4dca-a56f-4087ad19710b','41','110','完成后发送到我的邮箱里',1,'2021-12-20 19:33:12',1),('6a69e82b-9f7e-4339-bb33-5467f7a709b2','41','110',' 昨天的功能完成里面 ',1,'2021-12-20 17:15:58',1),('739e0d2f-7b73-47f1-aefa-70ffe0d3ee4f','93','110','请及时修改密码。',1,'2021-12-20 17:15:39',1),('92b974b0-ce67-43c0-be32-81b018739c02','93','110','你的账号存在安全问题，注意账号安全性。',1,'2021-12-20 17:11:10',1),('bb14b290-ca04-4d6e-9c71-fad2cf9062b6','41','110','完成后请及时提交给我',1,'2021-12-20 17:16:10',1),('da0e2b11-dd00-4b2c-ae43-f435d2ea45f4','93','110','昨天登陆存在异常。',1,'2021-12-20 17:17:02',1),('da2699ef-feb9-4bf1-8062-b47efca4691e','93','110','系统即将维护，请维护好在登陆。',1,'2021-12-20 23:58:24',0);
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_tag` varchar(100) DEFAULT NULL COMMENT '角色标签',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序号',
  `status` tinyint(4) DEFAULT NULL COMMENT '角色状态',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
INSERT INTO `t_role` VALUES (17,'系统管理员','admin',0,1,'','2021-11-18 08:58:46','2021-11-18 08:58:46',0),(18,'普通角色','normal',0,1,'','2021-11-18 15:33:02','2021-11-18 15:33:02',0),(24,'应用角色','',0,1,'','2021-11-18 23:07:04','2021-12-19 20:33:42',0);
UNLOCK TABLES;

--
-- Table structure for table `t_system_config`
--

DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `config_name` varchar(100) DEFAULT NULL COMMENT '配置名称',
  `config_value` varchar(100) DEFAULT NULL COMMENT '配置值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表';

--
-- Dumping data for table `t_system_config`
--

LOCK TABLES `t_system_config` WRITE;
INSERT INTO `t_system_config` VALUES (1,'sessionExpireTime','3600','系统不操作过期时间',9,NULL),(2,'resetPassword','11111','初始和重置密码',0,'2021-12-17 09:16:25');
UNLOCK TABLES;

--
-- Table structure for table `t_theme`
--

DROP TABLE IF EXISTS `t_theme`;
CREATE TABLE `t_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主题ID',
  `theme_text` varchar(100) DEFAULT NULL COMMENT '主题文本',
  `theme_name` varchar(100) DEFAULT NULL COMMENT '主题名称',
  `pic_url` varchar(100) DEFAULT NULL COMMENT '图片地址',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='主题表';

--
-- Dumping data for table `t_theme`
--

LOCK TABLES `t_theme` WRITE;
INSERT INTO `t_theme` VALUES (1,'默认','default','http://r401m0osl.hn-bkt.clouddn.com/code/duck/2021-12-12-c51b1bb480ed46ff97d36c5ba7550bc4.png',3,NULL),(12,'黑色','dark','http://r401m0osl.hn-bkt.clouddn.com/code/duck/2021-12-12-2777b8e8c7584052b98d7dc92404716f.jpg',2,'2021-12-12 21:57:26');
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `status` varchar(20) NOT NULL COMMENT '状态 0锁定 1有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近访问时间',
  `ssex` char(1) DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `is_tab` char(1) DEFAULT NULL COMMENT '是否开启tab，0关闭 1开启',
  `theme` varchar(10) DEFAULT NULL COMMENT '主题',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '删除标志',
  `nickname` varchar(100) DEFAULT NULL COMMENT '展示名称',
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `t_user_username` (`username`),
  KEY `t_user_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
INSERT INTO `t_user` VALUES (1,'MrBird','cb62ad1497597283961545d608f80241',1,'mrbird@qq.com','17788888888','1','2019-06-14 20:39:22','2019-12-04 16:47:11','2019-12-04 16:48:10','0','1','black','http://r14m2fq0b.hn-bkt.clouddn.com/code/duck/2021-10-19-b395be67c3b349c8abab3e730ae326ed.png','我是帅比作者。',NULL,'ttt'),(2,'Scott','1d685729d113cfd03872f154939bee1c',1,'scott@gmail.com','17722222222','1','2019-06-14 20:55:53','2019-06-14 21:05:43','2019-08-18 17:36:18','0','1','black','http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png','我是scott。',NULL,'vvvv'),(3,'Reina','1461afff857c02afbfb768aa3771503d',1,'Reina@hotmail.com','17711111111','0','2019-06-14 21:07:38','2019-06-14 21:09:06','2019-06-14 21:08:26','1','1','black','http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png','由于公款私用，已被封禁。',NULL,'ass'),(4,'Micaela','9f2daa2c7bed6870fcbb5b9a51d6300e',10,'Micaela@163.com','17733333333','1','2019-06-14 21:10:13','2019-06-14 21:11:26','2019-06-14 21:10:37','0','0','white','http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png','我叫米克拉',NULL,'ass'),(5,'Jana','176679b77b3c3e352bd3b30ddc81083e',8,'Jana@126.com','17744444444','1','2019-06-14 21:12:16','2019-06-14 21:12:52','2019-06-14 21:12:32','1','1','white','http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png','大家好，我叫简娜',NULL,'ass'),(6,'Georgie','dffc683378cdaa015a0ee9554c532225',3,'Georgie@qq.com','17766666666','0','2019-06-14 21:15:09','2019-06-14 21:16:25','2019-06-14 21:16:11','2','0','black','http://r14m2fq0b.hn-bkt.clouddn.com/code/duck/2021-10-19-b395be67c3b349c8abab3e730ae326ed.png','生产执行rm -rf *，账号封禁T T',NULL,'ass'),(7,'Margot','31379841b9f4bfde22b8b40471e9a6ce',9,'Margot@qq.com','13444444444','1','2019-06-14 21:17:53','2019-06-14 21:18:59','2019-06-14 21:18:07','1','1','white','http://r14m2fq0b.hn-bkt.clouddn.com/code/duck/2021-10-19-b395be67c3b349c8abab3e730ae326ed.png','大家好我叫玛戈',NULL,'ass'),(41,'lyd','111111',53,'1234@qq.com','13218133416','1','2021-10-18 20:36:49','2021-12-20 10:27:42',NULL,'1','0',NULL,'http://r401m0osl.hn-bkt.clouddn.com/code/duck/2021-12-20-404f7cc1936d4c4cab81ae85a94bde24.jpg','hhhhhhhhhhh',0,'部门经理'),(93,'admin','111111',53,'83428190@qq.com','17625176725','1','2019-06-14 20:55:53','2021-12-20 10:23:25',NULL,'0','1',NULL,'http://r401m0osl.hn-bkt.clouddn.com/code/duck/2021-12-20-c25baf8151744b25a9e9826153e6017b.jpg',NULL,0,'系统管理员 '),(110,'test','11111',21,'83428190@qq.com','13218133416','1','2021-12-20 10:38:00','2021-12-20 10:38:00',NULL,'0',NULL,NULL,'http://r401m0osl.hn-bkt.clouddn.com/code/duck/2021-12-20-1fd204f176c748f8bcbe69897126f713.jpg','一个积极工作的人',0,'普通职员');
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
INSERT INTO `t_user_role` VALUES (241,93,17),(244,41,17),(245,41,24),(246,110,18);
UNLOCK TABLES;

--
-- Table structure for table `t_user_token`
--

DROP TABLE IF EXISTS `t_user_token`;
CREATE TABLE `t_user_token` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户Token';

--
-- Dumping data for table `t_user_token`
--

LOCK TABLES `t_user_token` WRITE;
INSERT INTO `t_user_token` VALUES (24,'b4d1c404793fbb7e570f58a4607f257e','2021-11-17 11:17:21','2021-11-16 23:17:21'),(41,'d30978a3c7c600dfb51027cf3868634d','2021-11-27 00:01:31','2021-11-26 12:01:31'),(88,'7102220b0094874a63d4f7fb2b2e669c','2021-11-18 04:37:38','2021-11-17 16:37:38'),(91,'a8f2d20f59eb6ed8e840b91ac0d55c38','2021-11-27 00:01:59','2021-11-26 12:01:59'),(93,'5a37c90b9c433119f8fa9d9d6b96de51','2021-11-19 03:36:17','2021-11-18 15:36:17');
UNLOCK TABLES;

--
-- Dumping routines for database 'admintory'
--

-- Dump completed on 2021-12-21 14:40:52
