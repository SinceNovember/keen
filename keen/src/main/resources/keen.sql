/*
 Navicat Premium Data Transfer

 Source Server         : 124.221.237.161(云服务)
 Source Server Type    : MySQL
 Source Server Version : 50738 (5.7.38)
 Source Host           : 124.221.237.161:3306
 Source Schema         : keen

 Target Server Type    : MySQL
 Target Server Version : 50738 (5.7.38)
 File Encoding         : 65001

 Date: 22/03/2023 13:56:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_code_item
-- ----------------------------
DROP TABLE IF EXISTS `t_code_item`;
CREATE TABLE `t_code_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '代码项ID',
  `item_text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码项内容',
  `item_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码项值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `code_id` bigint(20) NULL DEFAULT NULL COMMENT '代码ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码项表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_code_item
-- ----------------------------
INSERT INTO `t_code_item` VALUES (1, '男', 'MALE', NULL, 2, NULL, 1);
INSERT INTO `t_code_item` VALUES (5, '女', 'FEMALE', 'ddd ', 1, '2021-12-06 17:00:28', 1);
INSERT INTO `t_code_item` VALUES (20, '启用', 'VALID', NULL, 2, '2021-12-07 14:13:44', 13);
INSERT INTO `t_code_item` VALUES (21, '禁用', 'LOCK', NULL, 0, '2021-12-07 14:13:50', 13);
INSERT INTO `t_code_item` VALUES (24, 'cx', 'sx', '211', 1, '2023-02-06 13:27:10', 14);
INSERT INTO `t_code_item` VALUES (25, '未知', 'UNKNOWN', NULL, 0, '2023-02-06 13:45:26', 1);
INSERT INTO `t_code_item` VALUES (30, NULL, NULL, 'dd', 1, '2023-03-02 17:17:56', NULL);
INSERT INTO `t_code_item` VALUES (31, NULL, NULL, 'tet', 0, '2023-03-02 17:19:28', NULL);
INSERT INTO `t_code_item` VALUES (32, NULL, NULL, 'sda', 0, '2023-03-02 17:19:47', NULL);

-- ----------------------------
-- Table structure for t_code_main
-- ----------------------------
DROP TABLE IF EXISTS `t_code_main`;
CREATE TABLE `t_code_main`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '代码ID',
  `code_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码描述',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_code_main
-- ----------------------------
INSERT INTO `t_code_main` VALUES (1, '性别', '用户性别代码', 0, '2023-02-06 14:22:35');
INSERT INTO `t_code_main` VALUES (13, '状态', '', 0, '2021-12-07 14:13:32');

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID',
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建者ID',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标志',
  `dept_short_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门简称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_dept_parent_id`(`parent_id`) USING BTREE,
  INDEX `t_dept_dept_name`(`dept_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (57, NULL, '管理部', 123, 11, '2023-01-10 16:21:40', NULL, 0, '管理', '没有');
INSERT INTO `t_dept` VALUES (58, 57, '管理1部', 234, 1, NULL, '2023-01-11 13:59:21', 0, '1部', 'hhhhgggg');
INSERT INTO `t_dept` VALUES (59, 58, '她她她', 123, NULL, '2023-01-11 14:19:32', '2023-01-11 14:19:32', 1, 'qqq', '4qwwa');
INSERT INTO `t_dept` VALUES (60, 0, 'ddd', 123, 0, '2023-01-11 15:41:29', '2023-01-11 15:41:29', 0, '1', '23');
INSERT INTO `t_dept` VALUES (61, 0, 'ddd', 123, NULL, '2023-01-11 15:43:02', '2023-01-11 15:43:02', 0, '11', 'qwe');
INSERT INTO `t_dept` VALUES (62, 0, 'wqe', 123, NULL, '2023-01-11 15:43:23', '2023-01-11 15:43:23', 0, 'asd', 'xcz');
INSERT INTO `t_dept` VALUES (63, 0, 'asd', 123, NULL, '2023-01-11 15:45:03', '2023-01-11 15:44:58', 0, 'ads', 'zxc');
INSERT INTO `t_dept` VALUES (64, NULL, 'jjjjjj', 123, 88, '2023-01-11 15:45:30', '2023-03-02 18:30:57', 0, 'uu', 'u');
INSERT INTO `t_dept` VALUES (65, 57, '管理2部', 123, NULL, '2023-01-13 15:56:24', '2023-01-13 15:56:24', 0, NULL, NULL);
INSERT INTO `t_dept` VALUES (66, NULL, 'ddd', 123, 2, '2023-03-02 11:35:17', '2023-03-02 13:07:37', 1, 'ddddd', 'qq');
INSERT INTO `t_dept` VALUES (67, NULL, 'xxx', 123, 0, '2023-03-02 15:29:45', '2023-03-02 15:29:45', 1, 'aaa', 'cccc');
INSERT INTO `t_dept` VALUES (68, 64, 'cc', 123, 1, '2023-03-03 23:49:26', '2023-03-03 23:49:26', 1, 'cc', 'c');

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `system` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_login_log_login_time`(`login_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 870 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES (814, 'test', '2023-02-06 17:51:30', 'test1', '12', 'ds', 'qwe', NULL);
INSERT INTO `t_login_log` VALUES (815, '王大苗', '2023-03-04 22:18:04', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', NULL);
INSERT INTO `t_login_log` VALUES (816, '王大苗', '2023-03-05 14:09:12', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (817, '王大苗', '2023-03-05 17:26:36', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (818, '王大苗', '2023-03-05 17:28:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (819, '王大苗', '2023-03-05 17:30:33', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (820, '王大苗', '2023-03-05 17:33:00', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (821, '王大苗', '2023-03-05 17:36:45', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (823, '王大苗', '2023-03-05 18:15:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (824, '王大苗', '2023-03-05 18:15:25', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (825, '王大苗', '2023-03-05 18:16:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (826, '王大苗', '2023-03-06 09:43:08', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (827, '王大苗', '2023-03-06 09:53:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (828, '王大苗', '2023-03-06 10:00:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (829, '王大苗', '2023-03-06 10:59:00', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (830, '王大苗', '2023-03-06 11:01:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (831, '王大苗', '2023-03-06 20:19:05', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (832, '王大苗', '2023-03-10 15:17:52', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (833, '王大苗11xx', '2023-03-13 11:28:17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (834, '王大苗11xx', '2023-03-13 11:28:08', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (835, '王大苗11xx', '2023-03-13 11:29:25', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (836, '王大苗11xx', '2023-03-13 11:29:36', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (837, '王大苗11xx', '2023-03-13 11:30:30', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (838, '王大苗11xx', '2023-03-13 17:07:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (839, '王大苗11xx', '2023-03-13 17:53:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (840, '王大苗11xx', '2023-03-13 17:53:42', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (841, '王大苗11xx', '2023-03-15 15:39:17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (842, '王大苗11xx', '2023-03-15 17:54:11', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (843, '王大苗11xx', '2023-03-15 18:19:51', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (844, '王大苗11xx', '2023-03-15 18:26:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (845, '王大苗11xx', '2023-03-16 09:57:10', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (846, '3', '2023-03-18 14:17:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (847, '3', '2023-03-18 14:17:42', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (848, '王大苗11xx', '2023-03-19 20:32:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (849, '王大苗11xx', '2023-03-19 21:52:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (850, '3', '2023-03-20 14:07:04', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (851, '3', '2023-03-20 14:10:43', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (852, '3', '2023-03-20 14:10:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (853, '3', '2023-03-20 14:10:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (854, '3', '2023-03-20 14:12:23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (855, '王大苗11xx', '2023-03-20 14:12:56', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (856, '王大苗11xx', '2023-03-20 14:30:48', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (857, 'test2', '2023-03-20 14:30:52', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (858, '王大苗11xx', '2023-03-20 14:43:57', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (859, 'test2', '2023-03-20 14:44:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (860, '王大苗11xx', '2023-03-20 15:34:45', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (861, 'test2', '2023-03-20 15:35:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (862, '王大苗11xx', '2023-03-20 23:59:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (863, 'test2', '2023-03-21 00:01:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (864, '王晓鹏', '2023-03-22 13:16:00', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (865, 'te', '2023-03-22 13:18:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 155);
INSERT INTO `t_login_log` VALUES (866, '3', '2023-03-22 13:48:05', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 156);
INSERT INTO `t_login_log` VALUES (867, '王大苗11xx', '2023-03-22 13:53:38', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (868, '3', '2023-03-22 13:53:58', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 156);
INSERT INTO `t_login_log` VALUES (869, 'ccc', '2023-03-22 13:54:54', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 134);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件地址',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `expand` int(1) NULL DEFAULT 0 COMMENT '是否默认展开',
  `redirect` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重定向地址',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单标题',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `hidden` int(1) NULL DEFAULT 0 COMMENT '是否隐藏',
  `bread_crumb` int(1) NULL DEFAULT 1 COMMENT '面包屑',
  `always_show` int(1) NULL DEFAULT NULL COMMENT '是否公开',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `type` int(11) NULL DEFAULT NULL COMMENT '（1、目录，2、菜单，3、按钮）',
  `request_method` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `t_menu_tk`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 176 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '/test', 'Layout', 'home', 0, '', 'Home', 'bi bi-grid', NULL, 0, 1, 0, NULL, '2023-03-06 10:42:10', 0, 9, 1, 'GET');
INSERT INTO `t_menu` VALUES (2, '/dashboard', 'dashboard/index3', 'Dashboard', 0, '', 'Dashboard', 'bi bi-grid', 1, 0, 1, 1, NULL, '2023-02-28 10:28:41', 0, 1, 2, 'GET');
INSERT INTO `t_menu` VALUES (3, '/system', 'Layout', 'System', 0, '/user', '系统管理', 'bi bi-grid', NULL, 0, 1, 1, NULL, '2023-03-06 21:01:25', 0, 8, 1, 'GET');
INSERT INTO `t_menu` VALUES (5, '/user', 'system/user/index', 'user', 0, NULL, '用户管理', 'bi bi-person-lines-fill', 3, 0, 1, 1, NULL, '2023-03-02 20:35:16', 0, 7, 2, 'GET');
INSERT INTO `t_menu` VALUES (6, '/menu', 'system/menu/index', 'menu', 0, NULL, '菜单管理', 'bi bi-list', 3, 0, 1, 1, NULL, '2023-03-02 20:41:06', 0, 4, 2, 'GET');
INSERT INTO `t_menu` VALUES (7, '/dept', 'dashboard/index', 'dept', 0, '', '部门管理', 'bx-sitemap', 1, 1, 1, 1, NULL, '2023-02-02 19:58:02', 1, 8, 2, 'GET');
INSERT INTO `t_menu` VALUES (11, '/layout', 'layout/index', 'Layout', 0, '', '布局设置', 'bi bi-columns-gap', 3, 0, 1, 1, NULL, '2023-03-02 20:55:51', 0, 2, 2, 'GET');
INSERT INTO `t_menu` VALUES (75, '/operation', 'system/user/index', '', 0, '', '操作日志', '', 5, 1, 1, 1, '2021-11-23 15:42:18', '2023-03-01 21:22:09', 0, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (76, '/login', 'monitor/login-log/index', 'LoginLog', 0, '', '登陆日志', '', 11, 0, 1, 1, '2021-11-23 15:46:26', '2021-11-23 15:46:40', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (77, '/active', 'monitor/active/index', 'Active', 0, '', '在线用户', '', 11, 0, 1, 1, '2021-11-24 13:30:50', '2021-11-24 13:31:17', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (83, '/metadata', 'Layout', 'nnb', 0, '', '元数据管理', 'bi bi-bar-chart-line', NULL, 0, 1, 1, '2021-12-03 15:53:16', '2023-03-02 20:56:32', 0, 7, 1, 'GET');
INSERT INTO `t_menu` VALUES (84, '/systemConfig', 'metadata/systemConfig/index', 'systemConfig', 0, '', '系统参数', 'bi bi-gear', 83, 0, 1, 1, '2021-12-03 15:55:42', '2023-03-02 20:48:12', 0, 9, 2, 'GET');
INSERT INTO `t_menu` VALUES (85, '/codeMain', 'metadata/codeMain/index', 'ccc', 0, '', '代码管理', 'bi bi-book', 83, 0, 1, 1, '2021-12-03 15:56:26', '2023-03-02 20:48:34', 0, 8, 2, 'GET');
INSERT INTO `t_menu` VALUES (88, '/other', 'Layout', '', 0, '', '其他管理', 'bx-list-plus', NULL, 0, 1, 0, '2021-12-10 16:44:02', '2023-02-27 16:23:20', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (89, '/theme', 'other/theme/index', '', 0, '', '主题管理', 'bxs-layer', 88, 0, 1, 1, '2021-12-10 16:45:26', '2021-12-17 11:07:09', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (91, '/base', 'Layout', 'nnnmm', 0, '', '基础组件', 'mdi mdi-access-point-network', NULL, 0, 1, 1, '2021-12-17 13:07:08', '2022-12-16 10:41:44', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (92, '/menu', 'menu/index', 'menu', 0, '', '个人简介', '', 2, 0, 1, 1, '2021-12-17 13:07:56', '2021-12-20 10:32:40', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (105, '/tet', 'menu/index', 'tet', 0, '', 'tet', 'mdi mdi-bullhorn-variant', 2, 1, 1, 1, '2022-12-07 10:36:37', '2022-12-07 10:36:37', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (106, '/tst', 'menu/index', 'ttt', 0, '', 'tst', 'mdi mdi-bullhorn-variant', 2, 0, 1, 1, '2022-12-07 10:37:54', '2022-12-07 10:37:54', 1, 3, 1, 'GET');
INSERT INTO `t_menu` VALUES (107, '/txt', 'menu/index', 'ee', 0, '', 'txt', 'mdi mdi-abjad-hebrew', 2, 0, 1, 1, '2022-12-07 13:06:43', '2022-12-07 13:06:43', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (108, 'tess', 'tee', 'ttt', 0, 'sss', 'test1', 'mdi mdi-access-point-network-off', 2, 1, 1, 1, '2022-12-08 11:07:09', '2022-12-08 11:07:09', 1, 111, 1, 'GET');
INSERT INTO `t_menu` VALUES (109, '/person', 'menu/index', 'person', 0, '', '个人', 'mdi mdi-account-alert', 2, 0, 1, 1, '2022-12-08 19:58:51', '2022-12-08 19:58:51', 1, 1, 1, 'GET');
INSERT INTO `t_menu` VALUES (113, '/test', 'Layout', 'mytest', 0, 'test', 'mytest', 'mdi mdi-access-point-minus', NULL, 1, 1, 1, '2022-12-08 21:02:51', '2022-12-16 10:40:26', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (116, 'v', 'Layout', 'vv', 0, 'v', 'vvvv', '', NULL, 0, 1, 1, '2022-12-09 22:31:30', '2022-12-09 22:31:30', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (117, '/vg', 'Layout', 'vvg', 0, 'vg', 'vvvvggg', '', NULL, 1, 1, 1, '2022-12-09 22:31:44', '2022-12-16 10:40:06', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (118, 'vcx', 'Layout', 'cvx', 0, 'xv', 'vcx', 'mdi mdi-abjad-arabic', NULL, 0, 1, 1, '2022-12-09 23:21:33', '2022-12-09 23:21:33', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (119, '/x', 'Layout', 's', 0, 'c', 'xx', 'mdi mdi-abugida-thai', NULL, 1, 1, 1, '2022-12-09 23:35:17', '2022-12-16 11:00:30', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (125, '/sss', 'sss', 'xxxx', 0, 'xxx', 'tesss', 'mdi mdi-abjad-arabic', 88, 1, 1, 1, '2022-12-10 18:49:04', '2022-12-16 10:34:12', 1, 11, 2, 'GET');
INSERT INTO `t_menu` VALUES (126, 'qq', 'qqqq', 'q', 0, '22', 'qqqq', '', 88, 0, 1, 1, '2022-12-10 18:54:53', '2022-12-10 18:54:53', 1, 111, 2, 'GET');
INSERT INTO `t_menu` VALUES (127, 'qq', 'qqqq', 'q', 0, '22', 'qqqq', '', 88, 0, 1, 1, '2022-12-10 19:25:15', '2022-12-10 19:25:15', 1, 111, 2, 'GET');
INSERT INTO `t_menu` VALUES (131, 'ads', 'Layout', 'sad', 0, '', 'sasadsdcccxxx', 'mdi mdi-account-alert', 119, 0, 1, 1, '2022-12-10 23:09:12', '2022-12-11 16:35:54', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (134, '/tyuio', 'Layout', 'yy', 0, '', 'yyyyy', 'mdi mdi-access-point-network', 5, 1, 1, 1, '2022-12-13 22:09:22', '2022-12-14 13:33:15', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (135, '/tyuio', 'menu/index', 'yy', 0, '', 'yyyyynn', 'mdi mdi-access-point-network', 8, 0, 1, 1, '2022-12-13 22:09:43', '2022-12-13 22:09:43', 0, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (136, '/fghj', 'Layout', 'j', 0, '', 'nnn', 'mdi mdi-access-point-minus', NULL, 1, 1, 1, '2022-12-13 22:12:51', '2022-12-14 13:32:14', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (137, 'fghj', 'Layout', 'j', 0, '', 'nnnjjjj', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-13 22:13:16', '2022-12-13 22:13:16', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (138, 'fghj', 'Layout', 'j', 0, '', 'nnnjjjjkkk', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-13 22:13:39', '2022-12-13 22:13:39', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (139, 'fghj', 'Layout', 'j', 0, '', 'nnnjjjjkkkllll', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-13 22:13:58', '2022-12-13 22:13:58', 1, 3, 1, 'GET');
INSERT INTO `t_menu` VALUES (140, '/as', 'Layout', 'cx', 0, '', 'asd', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-14 13:08:50', '2022-12-16 10:40:48', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (141, '/ascc', 'Layout', 'cx', 0, '', 'asdccc', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-14 13:09:20', '2022-12-14 13:09:20', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (142, '/asccx', 'Layout', 'cx', 0, '/test', 'asdcccxx', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-14 13:09:46', '2022-12-16 10:33:05', 1, 6, 1, 'GET');
INSERT INTO `t_menu` VALUES (143, '/cc', 'Layout', 'cc', 0, 'cc', 'cc', 'mdi mdi-access-point-minus', NULL, 0, 1, 0, '2022-12-16 11:16:46', '2022-12-16 15:49:06', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (144, '/xx', 'Layout', 'xx', 0, 'xx', 'xxx', 'mdi mdi-access-point-network', NULL, 0, 1, 1, '2022-12-16 11:17:07', '2022-12-16 11:17:07', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (146, '/test', 'Layout', 'test', 0, '', 'test', 'mdi mdi-account-alert-outline', NULL, 0, 1, 1, '2023-01-04 15:00:43', '2023-01-04 15:00:43', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (147, '/role', 'system/role/index', 'role', 0, '', '角色管理', 'bi bi-person-vcard', 3, 0, 1, 1, '2023-01-06 14:25:29', '2023-03-02 20:36:22', 0, 5, 2, 'GET');
INSERT INTO `t_menu` VALUES (148, '/333', 'Layout', '222', 0, NULL, '111444', 'mdi mdi-access-point-network', NULL, 1, 1, 1, '2023-01-06 17:28:13', '2023-01-06 17:28:35', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (149, '/dept', 'system/dept/index', 'dept', 0, NULL, '部门管理', 'bi bi-diagram-3', 3, 0, 1, 1, '2023-01-10 14:52:13', '2023-03-02 20:34:51', 0, 6, 2, 'GET');
INSERT INTO `t_menu` VALUES (150, '/dddxx', NULL, NULL, 0, NULL, 'ddd', NULL, 1, 0, 1, 1, '2023-02-02 20:57:39', '2023-02-02 20:57:39', 1, 5, 3, 'POST');
INSERT INTO `t_menu` VALUES (151, '/test', 'Layout', 'ccc', 0, NULL, 'cccc', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2023-02-02 20:59:58', '2023-02-02 20:59:58', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (152, '/api/system/user', NULL, NULL, 0, NULL, '添加用户', NULL, 5, 1, 1, 1, '2023-02-03 09:37:48', '2023-03-01 21:22:09', 0, 9, 3, 'POST');
INSERT INTO `t_menu` VALUES (153, '/api/system/user/page', NULL, NULL, 0, NULL, '用户列表', NULL, 5, 0, 1, 1, '2023-02-03 14:30:19', '2023-03-06 21:13:47', 0, 10, 3, 'GET');
INSERT INTO `t_menu` VALUES (156, '/metadata', 'Layout', 'metadata', 0, NULL, '元数据管理', 'mdi mdi-air-filter', NULL, 0, 1, 1, '2023-02-04 13:49:10', '2023-02-04 13:49:10', 1, 8, 1, 'GET');
INSERT INTO `t_menu` VALUES (157, '/monitor', 'Layout', 'monitor', 0, NULL, '系统监控', 'bi bi-box', NULL, 0, 1, 1, '2023-02-06 17:44:24', '2023-03-03 13:43:13', 0, 6, 1, 'GET');
INSERT INTO `t_menu` VALUES (158, '/loginLog', 'monitor/loginLog/index', 'loginLog', 0, NULL, '登录日志', 'bi bi-fingerprint', 157, 0, 1, 1, '2023-02-06 17:45:16', '2023-03-03 13:36:16', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (159, '/operateLog', 'monitor/operateLog/index', 'operateLog', 0, NULL, '操作日志', 'bi bi-brightness-alt-high', 157, 0, 1, 1, '2023-02-06 17:45:48', '2023-03-03 13:39:08', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (160, '/asd', 'Layout', 'wqe', 0, '/xzc', 'fff', 'qqq', 2, 0, 0, 0, '2023-02-28 14:20:33', '2023-02-28 14:20:33', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (161, '/r', 'Layout', 'r', 0, '/rr', 'rrr', 'rr', 2, 0, 0, 0, '2023-02-28 14:24:18', '2023-02-28 14:24:18', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (162, '/r', 'Layout', 'r', 0, '/rr', 'rrr', 'rr', 2, 0, 0, 0, '2023-02-28 14:24:37', '2023-02-28 14:24:37', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (163, '/rr', 'Layout', 'r', 0, '/r', 'rrr', 'r', 2, 0, 0, 0, '2023-02-28 14:24:53', '2023-02-28 14:24:53', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (164, '/wqe', 'Layout', 'da', 0, '/312', 'jyt', 'gfs', NULL, 0, 0, 0, '2023-02-28 14:27:32', '2023-02-28 14:27:32', 1, 3, 1, 'GET');
INSERT INTO `t_menu` VALUES (165, '/xcz', 'Layout', 'xcz', 0, '/1', 'zxc', 'xcz', NULL, 0, 0, 0, '2023-02-28 14:29:42', '2023-02-28 14:29:42', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (166, '/xcz', 'Layout', 'xcz', 0, '/1', 'zxc1', 'xcz', NULL, 0, 0, 0, '2023-02-28 14:30:48', '2023-02-28 14:30:48', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (167, '/f1', 'Layout', 'ff1', 0, '/f1', 'fff1333', 'ff1', NULL, 0, 0, 0, '2023-02-28 14:33:27', '2023-03-01 15:09:13', 1, 4, 1, 'GET');
INSERT INTO `t_menu` VALUES (168, '/sda', 'Layout', 'wqe', 0, '', 'wqew', 'asd', NULL, 0, 0, 0, '2023-02-28 14:36:51', '2023-02-28 14:36:51', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (169, '/zxcq', 'xzc1', 'wq1', 1, '/sda1', 'xxca', 'asd1', 168, 1, 1, 1, '2023-02-28 14:39:53', '2023-02-28 15:03:36', 1, 3, 3, 'PUT');
INSERT INTO `t_menu` VALUES (170, '/sad', 'xzc', 'wq', 1, '/sda', 'fffggaa', 'asd', 167, 1, 1, 1, '2023-02-28 14:40:55', '2023-02-28 14:40:55', 1, 2, 2, 'GET');
INSERT INTO `t_menu` VALUES (171, '/sad11', 'xzc', 'wq', 1, '/sda', 'fffggaa11', 'asd', 167, 1, 1, 1, '2023-02-28 14:41:42', '2023-02-28 14:41:42', 1, 4, 3, 'PUT');
INSERT INTO `t_menu` VALUES (172, '/te', 'Layout', 'te', 0, '/sds', 'tes', 'bi bi-app', NULL, 0, 0, 0, '2023-03-01 18:19:20', '2023-03-01 18:19:28', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (173, '/11', 'Layout', '11', 0, '/11', '11', 'bi bi-alarm', NULL, 0, 1, 1, '2023-03-02 18:32:22', '2023-03-02 18:32:22', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (174, '/account', 'Layout', 'account', 0, NULL, '我的账号', 'bi bi-universal-access', NULL, 0, 1, 1, '2023-03-08 14:21:05', '2023-03-08 14:21:19', 0, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (175, '/overview', 'account/index', 'overview', 0, NULL, '个人信息', 'bi bi-award-fill', 174, 0, 1, 1, '2023-03-08 14:22:58', '2023-03-09 11:04:30', 0, 0, 2, 'GET');

-- ----------------------------
-- Table structure for t_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_permission`;
CREATE TABLE `t_menu_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '按钮ID',
  `permission_id` bigint(20) NULL DEFAULT NULL COMMENT '权限ID',
  `permission_type` bigint(20) NULL DEFAULT NULL COMMENT '权限类别（1、角色，2、部门，3、用户）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 575 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu_permission
-- ----------------------------
INSERT INTO `t_menu_permission` VALUES (438, 142, 40, 1);
INSERT INTO `t_menu_permission` VALUES (439, 142, 42, 1);
INSERT INTO `t_menu_permission` VALUES (440, 142, 43, 1);
INSERT INTO `t_menu_permission` VALUES (441, 142, 44, 1);
INSERT INTO `t_menu_permission` VALUES (442, 142, 58, 2);
INSERT INTO `t_menu_permission` VALUES (443, 142, 64, 2);
INSERT INTO `t_menu_permission` VALUES (444, 142, 113, 3);
INSERT INTO `t_menu_permission` VALUES (445, 142, 114, 3);
INSERT INTO `t_menu_permission` VALUES (477, 3, 40, 1);
INSERT INTO `t_menu_permission` VALUES (478, 3, 42, 1);
INSERT INTO `t_menu_permission` VALUES (479, 3, 57, 2);
INSERT INTO `t_menu_permission` VALUES (480, 3, 58, 2);
INSERT INTO `t_menu_permission` VALUES (481, 3, 65, 2);
INSERT INTO `t_menu_permission` VALUES (482, 3, 64, 2);
INSERT INTO `t_menu_permission` VALUES (483, 3, 113, 3);
INSERT INTO `t_menu_permission` VALUES (484, 3, 114, 3);
INSERT INTO `t_menu_permission` VALUES (485, 3, 115, 3);
INSERT INTO `t_menu_permission` VALUES (486, 3, 116, 3);
INSERT INTO `t_menu_permission` VALUES (487, 3, 117, 3);
INSERT INTO `t_menu_permission` VALUES (488, 3, 118, 3);
INSERT INTO `t_menu_permission` VALUES (489, 3, 119, 3);
INSERT INTO `t_menu_permission` VALUES (490, 3, 120, 3);
INSERT INTO `t_menu_permission` VALUES (493, 85, 123, 3);
INSERT INTO `t_menu_permission` VALUES (495, 88, 43, 1);
INSERT INTO `t_menu_permission` VALUES (499, 152, 113, 3);
INSERT INTO `t_menu_permission` VALUES (524, 167, 40, 1);
INSERT INTO `t_menu_permission` VALUES (525, 167, 42, 1);
INSERT INTO `t_menu_permission` VALUES (526, 167, 43, 1);
INSERT INTO `t_menu_permission` VALUES (527, 167, 57, 2);
INSERT INTO `t_menu_permission` VALUES (528, 167, 58, 2);
INSERT INTO `t_menu_permission` VALUES (529, 167, 64, 2);
INSERT INTO `t_menu_permission` VALUES (530, 167, 113, 3);
INSERT INTO `t_menu_permission` VALUES (531, 167, 114, 3);
INSERT INTO `t_menu_permission` VALUES (532, 167, 126, 3);
INSERT INTO `t_menu_permission` VALUES (533, 167, 128, 3);
INSERT INTO `t_menu_permission` VALUES (566, 153, 153, 3);
INSERT INTO `t_menu_permission` VALUES (567, 1, 43, 1);
INSERT INTO `t_menu_permission` VALUES (568, 1, 44, 1);
INSERT INTO `t_menu_permission` VALUES (569, 1, 42, 1);
INSERT INTO `t_menu_permission` VALUES (570, 1, 54, 1);
INSERT INTO `t_menu_permission` VALUES (571, 1, 58, 2);
INSERT INTO `t_menu_permission` VALUES (572, 1, 65, 2);
INSERT INTO `t_menu_permission` VALUES (573, 1, 64, 2);
INSERT INTO `t_menu_permission` VALUES (574, 1, 113, 3);

-- ----------------------------
-- Table structure for t_message_history
-- ----------------------------
DROP TABLE IF EXISTS `t_message_history`;
CREATE TABLE `t_message_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息',
  `from_id` int(11) NULL DEFAULT NULL COMMENT '发送方ID',
  `to_id` int(11) NULL DEFAULT NULL COMMENT '接受方ID',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '内容',
  `type` int(1) NULL DEFAULT NULL COMMENT '发送类别',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `is_read` int(1) NULL DEFAULT NULL COMMENT '1已读，0未读',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 122 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_message_history
-- ----------------------------
INSERT INTO `t_message_history` VALUES (1, 114, 154, 'ASD', 1, '2023-03-19 18:18:18', 1);
INSERT INTO `t_message_history` VALUES (2, 114, 154, 'ASDC', 1, '2023-03-19 18:19:18', 1);
INSERT INTO `t_message_history` VALUES (3, 154, 114, 'CCCC', 1, '2023-03-19 18:20:18', 1);
INSERT INTO `t_message_history` VALUES (4, 154, 153, 'CCCC1', 1, '2023-03-19 18:21:18', 1);
INSERT INTO `t_message_history` VALUES (5, 114, 153, 'aaaaa', 1, '2023-03-19 18:26:18', 1);
INSERT INTO `t_message_history` VALUES (9, 114, 154, '烦烦烦', 1, '2023-03-20 15:43:21', 1);
INSERT INTO `t_message_history` VALUES (10, 114, 154, '你在烦什么呢', 1, '2023-03-20 15:49:15', 1);
INSERT INTO `t_message_history` VALUES (11, 154, 114, '你管我烦什么', 1, '2023-03-20 15:49:24', 1);
INSERT INTO `t_message_history` VALUES (12, 154, 114, 'HHH ', 1, '2023-03-20 15:52:28', 1);
INSERT INTO `t_message_history` VALUES (13, 114, 154, 'NI HAO ', 1, '2023-03-20 15:52:36', 1);
INSERT INTO `t_message_history` VALUES (14, 114, 154, '??', 1, '2023-03-20 15:58:42', 1);
INSERT INTO `t_message_history` VALUES (15, 154, 114, '咋了', 1, '2023-03-20 15:58:46', 1);
INSERT INTO `t_message_history` VALUES (16, 114, 154, '我没说啥啊', 1, '2023-03-20 15:58:51', 1);
INSERT INTO `t_message_history` VALUES (17, 114, 154, '那你在说什么？', 1, '2023-03-20 15:58:57', 1);
INSERT INTO `t_message_history` VALUES (18, 154, 114, '好吧你你自己说', 1, '2023-03-20 15:59:11', 1);
INSERT INTO `t_message_history` VALUES (19, 114, 157, 'aaaaa11', 1, '2023-03-19 18:25:18', 1);
INSERT INTO `t_message_history` VALUES (20, 114, 157, 'hhhh', 1, '2023-03-20 16:55:09', 0);
INSERT INTO `t_message_history` VALUES (21, 114, 153, 'ddd', 1, '2023-03-20 16:57:56', 1);
INSERT INTO `t_message_history` VALUES (22, 114, 154, 'h', 1, '2023-03-20 17:06:06', 1);
INSERT INTO `t_message_history` VALUES (23, 114, 157, 'hh', 1, '2023-03-20 17:06:33', 0);
INSERT INTO `t_message_history` VALUES (24, 114, 157, 'jhh', 1, '2023-03-20 17:06:41', 0);
INSERT INTO `t_message_history` VALUES (25, 114, 153, 'jjj', 1, '2023-03-20 17:09:30', 1);
INSERT INTO `t_message_history` VALUES (26, 114, 154, 'hh', 1, '2023-03-20 17:43:24', 1);
INSERT INTO `t_message_history` VALUES (27, 114, 154, 'who', 1, '2023-03-20 17:45:37', 1);
INSERT INTO `t_message_history` VALUES (28, 114, 154, 'ni m ', 1, '2023-03-20 17:45:40', 1);
INSERT INTO `t_message_history` VALUES (29, 114, 154, 'w zhenbuzhidao', 1, '2023-03-20 17:45:44', 1);
INSERT INTO `t_message_history` VALUES (30, 154, 114, 'what', 1, '2023-03-20 17:48:06', 1);
INSERT INTO `t_message_history` VALUES (31, 154, 114, 'ss ', 1, '2023-03-20 17:48:09', 1);
INSERT INTO `t_message_history` VALUES (32, 154, 114, 'ni zhenliu', 1, '2023-03-20 17:48:12', 1);
INSERT INTO `t_message_history` VALUES (33, 114, 157, 'hihi', 1, '2023-03-20 18:08:43', 0);
INSERT INTO `t_message_history` VALUES (34, 114, 157, 'hihi', 1, '2023-03-20 18:08:51', 0);
INSERT INTO `t_message_history` VALUES (35, 114, 157, 'hih', 1, '2023-03-20 18:09:15', 0);
INSERT INTO `t_message_history` VALUES (36, 154, 114, 'hh', 1, '2023-03-20 18:09:29', 1);
INSERT INTO `t_message_history` VALUES (37, 154, 114, 'hihi', 1, '2023-03-20 18:09:32', 1);
INSERT INTO `t_message_history` VALUES (38, 154, 114, 'wohu', 1, '2023-03-20 18:09:37', 1);
INSERT INTO `t_message_history` VALUES (39, 154, 114, 's', 1, '2023-03-20 18:09:40', 1);
INSERT INTO `t_message_history` VALUES (40, 114, 157, 'nini', 1, '2023-03-20 18:09:55', 0);
INSERT INTO `t_message_history` VALUES (41, 154, 114, 'nini', 1, '2023-03-20 18:10:19', 1);
INSERT INTO `t_message_history` VALUES (42, 114, 154, 'dd', 1, '2023-03-20 18:10:24', 1);
INSERT INTO `t_message_history` VALUES (43, 114, 154, 'qweq', 1, '2023-03-20 18:10:26', 1);
INSERT INTO `t_message_history` VALUES (44, 114, 154, 'bushi ni hidaom ', 1, '2023-03-20 18:10:42', 1);
INSERT INTO `t_message_history` VALUES (45, 114, 154, 'nizhidaom ?', 1, '2023-03-20 18:12:02', 1);
INSERT INTO `t_message_history` VALUES (46, 154, 114, 'w zhidaioshenm ?', 1, '2023-03-20 18:12:10', 1);
INSERT INTO `t_message_history` VALUES (47, 154, 114, '你不知道吗？', 1, '2023-03-20 18:12:17', 1);
INSERT INTO `t_message_history` VALUES (48, 114, 154, '我不知道啊', 1, '2023-03-20 18:12:31', 1);
INSERT INTO `t_message_history` VALUES (49, 114, 154, '', 1, '2023-03-20 22:32:50', 1);
INSERT INTO `t_message_history` VALUES (50, 114, 154, '', 1, '2023-03-20 22:32:52', 1);
INSERT INTO `t_message_history` VALUES (51, 114, 154, '芜湖', 1, '2023-03-20 22:34:08', 1);
INSERT INTO `t_message_history` VALUES (52, 154, 114, '起飞', 1, '2023-03-20 22:34:33', 1);
INSERT INTO `t_message_history` VALUES (53, 114, 154, '真的吗', 1, '2023-03-20 22:34:42', 1);
INSERT INTO `t_message_history` VALUES (54, 154, 153, '你不知道的吗', 1, '2023-03-20 22:34:50', 1);
INSERT INTO `t_message_history` VALUES (55, 114, 154, '真的啊', 1, '2023-03-20 22:34:54', 1);
INSERT INTO `t_message_history` VALUES (56, 154, 114, '是的呢', 1, '2023-03-20 22:34:59', 1);
INSERT INTO `t_message_history` VALUES (57, 154, 114, 'a haha', 1, '2023-03-20 22:57:14', 1);
INSERT INTO `t_message_history` VALUES (58, 154, 114, 'jjj', 1, '2023-03-20 23:01:03', 1);
INSERT INTO `t_message_history` VALUES (59, 114, 154, 'd', 1, '2023-03-20 23:01:07', 1);
INSERT INTO `t_message_history` VALUES (60, 114, 154, 'w zhn', 1, '2023-03-20 23:02:55', 1);
INSERT INTO `t_message_history` VALUES (61, 154, 114, 'zhengaoxiao', 1, '2023-03-20 23:03:02', 1);
INSERT INTO `t_message_history` VALUES (62, 154, 114, 'nihao a ', 1, '2023-03-20 23:11:40', 1);
INSERT INTO `t_message_history` VALUES (63, 154, 114, 'shenm ', 1, '2023-03-20 23:11:46', 1);
INSERT INTO `t_message_history` VALUES (64, 114, 154, 's de ', 1, '2023-03-20 23:11:49', 1);
INSERT INTO `t_message_history` VALUES (65, 154, 153, 's de ', 1, '2023-03-20 23:12:00', 1);
INSERT INTO `t_message_history` VALUES (66, 154, 114, 'd', 1, '2023-03-20 23:12:03', 1);
INSERT INTO `t_message_history` VALUES (67, 114, 154, 'zezeze', 1, '2023-03-20 23:12:07', 1);
INSERT INTO `t_message_history` VALUES (68, 154, 114, 'nizaishuoshenma ', 1, '2023-03-20 23:25:03', 1);
INSERT INTO `t_message_history` VALUES (69, 114, 154, 'kkkk', 1, '2023-03-21 00:00:55', 1);
INSERT INTO `t_message_history` VALUES (70, 154, 114, 'fff', 1, '2023-03-21 00:01:42', 1);
INSERT INTO `t_message_history` VALUES (71, 114, 154, 'ni zai shuo shenm ?', 1, '2023-03-21 00:01:47', 1);
INSERT INTO `t_message_history` VALUES (72, 114, 154, 'fff', 1, '2023-03-21 00:02:56', 1);
INSERT INTO `t_message_history` VALUES (73, 154, 114, 'dddd', 1, '2023-03-21 00:03:00', 1);
INSERT INTO `t_message_history` VALUES (74, 114, 154, 'gigii', 1, '2023-03-21 00:13:45', 1);
INSERT INTO `t_message_history` VALUES (75, 154, 114, '你才是giegie', 1, '2023-03-21 00:13:52', 1);
INSERT INTO `t_message_history` VALUES (76, 114, 154, '我就是怎么了啊', 1, '2023-03-21 00:14:06', 1);
INSERT INTO `t_message_history` VALUES (77, 154, 114, '烦烦烦', 1, '2023-03-21 00:16:43', 1);
INSERT INTO `t_message_history` VALUES (78, 114, 154, '你在犯什么呢', 1, '2023-03-21 00:16:49', 1);
INSERT INTO `t_message_history` VALUES (79, 154, 114, '我也不知道 就是有点', 1, '2023-03-21 00:16:57', 1);
INSERT INTO `t_message_history` VALUES (80, 154, 114, 'hi', 1, '2023-03-21 09:36:10', 1);
INSERT INTO `t_message_history` VALUES (81, 114, 154, 'hi', 1, '2023-03-21 09:36:14', 1);
INSERT INTO `t_message_history` VALUES (82, 154, 114, 'what are you name', 1, '2023-03-21 09:36:18', 1);
INSERT INTO `t_message_history` VALUES (83, 114, 154, 'my name is good', 1, '2023-03-21 09:36:26', 1);
INSERT INTO `t_message_history` VALUES (84, 154, 114, 'ddd', 1, '2023-03-21 09:41:05', 1);
INSERT INTO `t_message_history` VALUES (85, 114, 154, 'hi loo', 1, '2023-03-21 13:43:54', 1);
INSERT INTO `t_message_history` VALUES (86, 114, 154, ' s de a  w ', 1, '2023-03-21 13:44:06', 1);
INSERT INTO `t_message_history` VALUES (87, 154, 114, ' ni hai zai ne ', 1, '2023-03-21 13:44:00', 1);
INSERT INTO `t_message_history` VALUES (88, 154, 114, 'w yebuzhda ]', 1, '2023-03-21 13:44:18', 1);
INSERT INTO `t_message_history` VALUES (89, 114, 154, ' 哎 ', 1, '2023-03-21 14:13:45', 1);
INSERT INTO `t_message_history` VALUES (90, 154, 114, '？怎么了', 1, '2023-03-21 14:13:57', 1);
INSERT INTO `t_message_history` VALUES (91, 114, 154, '啥 我不知道的啊', 1, '2023-03-21 15:08:06', 1);
INSERT INTO `t_message_history` VALUES (92, 154, 114, '你真不知道吗？', 1, '2023-03-21 15:08:18', 1);
INSERT INTO `t_message_history` VALUES (93, 154, 114, 'ddd', 1, '2023-03-21 15:48:54', 1);
INSERT INTO `t_message_history` VALUES (94, 114, 154, '有个问题问一下', 1, '2023-03-21 16:51:12', 1);
INSERT INTO `t_message_history` VALUES (95, 154, 114, '什么问题？', 1, '2023-03-21 16:51:19', 1);
INSERT INTO `t_message_history` VALUES (96, 154, 114, 'hello', 1, '2023-03-21 16:57:59', 1);
INSERT INTO `t_message_history` VALUES (97, 114, 154, 'w zhidao l m', 1, '2023-03-21 16:58:07', 1);
INSERT INTO `t_message_history` VALUES (98, 154, 114, 'zhodao ', 1, '2023-03-21 16:58:11', 1);
INSERT INTO `t_message_history` VALUES (99, 114, 154, 'ni buzhidao ?', 1, '2023-03-21 16:58:18', 1);
INSERT INTO `t_message_history` VALUES (100, 154, 114, 'zhidao e', 1, '2023-03-21 16:58:29', 1);
INSERT INTO `t_message_history` VALUES (101, 114, 154, 'zhidao de l', 1, '2023-03-21 16:58:43', 1);
INSERT INTO `t_message_history` VALUES (102, 154, 114, 'zhidaoge pi', 1, '2023-03-21 16:58:49', 1);
INSERT INTO `t_message_history` VALUES (103, 114, 126, '你好啊', 1, '2023-03-22 09:41:27', 0);
INSERT INTO `t_message_history` VALUES (104, 114, 128, 'hi', 1, '2023-03-22 09:48:00', 0);
INSERT INTO `t_message_history` VALUES (105, 114, 126, '的', 1, '2023-03-22 09:52:06', 0);
INSERT INTO `t_message_history` VALUES (106, 114, 128, 'd', 1, '2023-03-22 11:10:12', 0);
INSERT INTO `t_message_history` VALUES (107, 114, 131, 'asd', 1, '2023-03-22 11:12:53', 0);
INSERT INTO `t_message_history` VALUES (108, 114, 131, '大师', 1, '2023-03-22 11:13:47', 0);
INSERT INTO `t_message_history` VALUES (109, 114, 157, '你好啊', 1, '2023-03-22 11:31:00', 0);
INSERT INTO `t_message_history` VALUES (110, 114, 149, 'hi', 1, '2023-03-22 11:31:12', 0);
INSERT INTO `t_message_history` VALUES (111, 114, 131, 'hello', 1, '2023-03-22 11:31:34', 0);
INSERT INTO `t_message_history` VALUES (112, 114, 149, 'ni zhidaom ', 1, '2023-03-22 11:31:39', 0);
INSERT INTO `t_message_history` VALUES (113, 114, 134, 'where are you ', 1, '2023-03-22 13:14:46', 0);
INSERT INTO `t_message_history` VALUES (114, 114, 153, 'what', 1, '2023-03-22 13:16:33', 0);
INSERT INTO `t_message_history` VALUES (115, 153, 114, 'what sha ', 1, '2023-03-22 13:16:41', 0);
INSERT INTO `t_message_history` VALUES (116, 114, 155, 'hi ', 1, '2023-03-22 13:29:39', 1);
INSERT INTO `t_message_history` VALUES (117, 155, 114, 'hi 你在干啥？', 1, '2023-03-22 13:38:46', 0);
INSERT INTO `t_message_history` VALUES (119, 114, 156, 'ni hao ', 1, '2023-03-22 13:53:28', 0);
INSERT INTO `t_message_history` VALUES (120, 134, 114, 'i am rom chine', 1, '2023-03-22 13:55:06', 1);
INSERT INTO `t_message_history` VALUES (121, 134, 114, 's ', 1, '2023-03-22 13:55:51', 0);

-- ----------------------------
-- Table structure for t_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operate_log`;
CREATE TABLE `t_operate_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `operation` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作内容',
  `time` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时',
  `method` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作方法',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '方法参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者IP',
  `operate_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_log_create_time`(`operate_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2231 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_operate_log
-- ----------------------------
INSERT INTO `t_operate_log` VALUES (2202, '王大苗', '添加或修改用户', 495, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=126, username=ggg, password=null, nickname=eeqwe, sex=MALE, email=4213@qq.com, mobile=1232, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-6/1678107138498682.jpg, description=ggg, deptId=57, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-03-06 20:52:20', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2204, '王大苗', '添加或修改用户', 193, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=67899, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-09 09:39:07', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2203, '王大苗', '添加或修改用户', 265, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=67899, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-09 09:39:06', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2201, '王大苗', '添加或修改用户', 184, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=null, username=1231, password=2342, nickname=3, sex=MALE, email=2, mobile=1, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=ad, deptId=57, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-03-06 10:05:22', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2205, '王大苗', '添加或修改用户', 220, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-09 09:54:57', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2206, '王大苗', '添加或修改用户', 302, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东1345, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 14:35:50', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2207, '王大苗', '添加或修改用户', 204, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东134577, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 14:42:12', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2208, '王大苗', '添加或修改用户', 241, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 14:42:27', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2209, '王大苗', '添加或修改用户', 270, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788CC, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 14:53:56', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2210, '王大苗', '添加或修改用户', 224, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788CCDD, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 14:56:17', '内网IP|0|0|内网IP|内网IP', NULL);
INSERT INTO `t_operate_log` VALUES (2211, '王大苗', '添加或修改用户', 275, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788CCDDxx, sex=MALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:00:58', '内网IP|0|0|内网IP|内网IP', 120);
INSERT INTO `t_operate_log` VALUES (2212, '王大苗', '添加或修改用户', 263, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788CCDDxx, sex=FEMALE, email=83428190@qq.com, mobile=13218133416, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit., deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:05:13', '内网IP|0|0|内网IP|内网IP', 120);
INSERT INTO `t_operate_log` VALUES (2213, '王大苗', '添加或修改用户', 252, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788CCDDxx1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-4/1677917794677212.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:05:23', '内网IP|0|0|内网IP|内网IP', 120);
INSERT INTO `t_operate_log` VALUES (2214, '王大苗', '添加或修改用户', 264, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东13457788CCDDxx1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678431936714739.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:05:39', '内网IP|0|0|内网IP|内网IP', 120);
INSERT INTO `t_operate_log` VALUES (2215, '王大苗', '添加或修改用户', 239, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678431936714739.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:06:15', '内网IP|0|0|内网IP|内网IP', 120);
INSERT INTO `t_operate_log` VALUES (2216, '王大苗', '添加或修改用户', 329, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东dddddddddddddddd, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678431936714739.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:18:12', '内网IP|0|0|内网IP|内网IP', 120);
INSERT INTO `t_operate_log` VALUES (2217, '王大苗', '添加或修改用户', 204, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东dddddddddddddddd, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678431936714739.jpg, description=you like a shit, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:20:21', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2218, '王大苗', '添加或修改用户', 198, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东dddddddddddddddd, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678431936714739.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:20:26', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2219, '王大苗', '添加或修改用户', 267, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东dddddddddddddddd, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-10 15:24:39', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2220, '王大苗11', '添加或修改用户', 185, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=123, password=null, nickname=王大苗11, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=6, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-10 15:49:00', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2221, '王大苗11', '添加或修改用户', 151, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=123, password=null, nickname=王大苗11, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-10 15:57:12', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2222, '王大苗11xx', '添加或修改用户', 151, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=123, password=null, nickname=王大苗11xx, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-10 17:44:15', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2223, '王大苗11xx', '添加或修改用户', 246, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=null, username=ttt, password=tt, nickname=123, sex=MALE, email=231@qq, mobile=132141, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=sda, deptId=58, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-03-13 17:47:46', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2224, '王大苗11xx', '添加或修改用户', 307, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东ddd, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-15 15:39:27', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2225, '王大苗11xx', '添加或修改用户', 207, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东ddd1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-15 15:39:35', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2226, '王大苗11xx', '添加或修改用户', 190, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东ddd1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-15 15:39:53', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2227, '王大苗11xx', '添加或修改用户', 240, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东ddd1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-15 16:37:42', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2228, '王大苗11xx', '添加或修改用户', 243, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东ddd1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-15 16:37:51', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2229, '王大苗11xx', '添加或修改用户', 238, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东ddd1, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-03-15 16:38:24', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2230, 'test2', '添加或修改用户', 319, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=154, username=1, password=null, nickname=test2, sex=MALE, email=321, mobile=12, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=3, deptId=57, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-03-20 14:15:09', '内网IP|0|0|内网IP|内网IP', 154);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色标签',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '角色状态',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (40, 'zxcxxx', 'sad', 0, 1, 'tedt', NULL, '2023-03-02 18:31:29', 1);
INSERT INTO `t_role` VALUES (41, 'test2', '4444', 3, 0, 'dddddd', NULL, '2023-01-09 16:49:29', 1);
INSERT INTO `t_role` VALUES (42, '领导角色', '试试', 0, 1, NULL, '2023-01-09 16:13:53', '2023-03-02 11:03:42', 0);
INSERT INTO `t_role` VALUES (43, '信息', 'zz', 0, 0, NULL, '2023-01-09 16:14:58', '2023-03-02 11:03:35', 0);
INSERT INTO `t_role` VALUES (44, 'dsa', 'qwe', NULL, 0, 'zxcxxz', '2023-01-09 16:15:05', '2023-02-06 14:29:44', 1);
INSERT INTO `t_role` VALUES (45, 'ccc', 'ccc', 77, 0, 'cccc', '2023-01-09 16:16:47', '2023-01-09 16:16:47', 1);
INSERT INTO `t_role` VALUES (46, 'x', 's', 0, 1, 'cc', '2023-02-06 13:42:27', '2023-02-06 13:42:27', 1);
INSERT INTO `t_role` VALUES (47, 'das', 'xxx', 0, 1, 'sad', '2023-03-02 10:06:03', '2023-03-02 10:06:03', 1);
INSERT INTO `t_role` VALUES (48, 'zxc', 'sda', 6, 1, 'qew', '2023-03-02 10:21:52', '2023-03-02 10:21:52', 1);
INSERT INTO `t_role` VALUES (49, 'zxc', 'sda', 6, 1, 'qew', '2023-03-02 10:22:41', '2023-03-02 10:22:41', 1);
INSERT INTO `t_role` VALUES (50, 'sda', 'zxcc', 2, 1, 'a', '2023-03-02 10:23:02', '2023-03-02 10:23:02', 1);
INSERT INTO `t_role` VALUES (51, 'zxc1', 'asd1', 3, 0, 'asd1', '2023-03-02 10:24:35', '2023-03-02 10:25:24', 1);
INSERT INTO `t_role` VALUES (52, 'cc', 'cc', 0, 1, 'ccc', '2023-03-02 11:12:54', '2023-03-02 11:12:54', 1);
INSERT INTO `t_role` VALUES (53, 'd2', 'd1', 1, 1, 'w', '2023-03-02 18:33:18', '2023-03-02 18:33:22', 1);
INSERT INTO `t_role` VALUES (54, 'xx', 'x', 0, 1, 'xxxc', '2023-03-02 18:34:58', '2023-03-02 18:35:03', 0);
INSERT INTO `t_role` VALUES (55, '1', '1', 0, 1, '22', '2023-03-03 22:59:44', '2023-03-03 22:59:44', 1);
INSERT INTO `t_role` VALUES (56, 'xxx', 'xx', 2, 0, 'xxx', '2023-03-03 23:03:30', '2023-03-03 23:03:30', 0);

-- ----------------------------
-- Table structure for t_system_config
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置名称',
  `config_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_system_config
-- ----------------------------
INSERT INTO `t_system_config` VALUES (1, 'sessionExpireTime', '3600', '系统不操作过期时间1', 9, NULL);
INSERT INTO `t_system_config` VALUES (2, 'resetPassword', '11111', '初始和重置密码', 0, '2021-12-17 09:16:25');
INSERT INTO `t_system_config` VALUES (9, '3', '2', '1', 0, '2023-03-04 00:21:04');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示名称',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 0锁定 1有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近访问时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标志',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_user_username`(`username`) USING BTREE,
  INDEX `t_user_mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (113, '12345', '234', 0, '83428190@qq.com1', '132181334161', '谢裕东ddd1', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg', 'Design is like a fart. If you have to force it, it’s probably shit.1', 57, 0, '2022-12-16 17:35:58', '2023-03-15 16:38:24', '2022-12-16 17:36:41', 0, 1);
INSERT INTO `t_user` VALUES (114, 'test345566', '123', 0, '2', '3', '王大苗11xx', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg', 'life is biess, work is free', 57, 1, '2022-12-16 17:35:58', '2023-03-10 17:44:15', '2022-12-16 17:36:41', 0, 1);
INSERT INTO `t_user` VALUES (115, 'asd', 'xz', 1, '12', '132456', 'weqsss', 'https://coderthemes.com/hyper_2/saas/assets/images/users/avatar-2.jpg', 'sad', 58, 1, '2022-12-25 20:43:13', '2023-02-02 13:06:58', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (116, 'hh', 'aa', 1, '234', '132', '刘宇东', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2022-12-28/1672233040634619.jpg', '1213', 57, 1, '2022-12-28 21:14:11', '2022-12-28 21:14:11', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (117, 'dd', 'ww', 1, '123', '132', 'qw', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1', 57, 1, '2023-01-04 14:50:17', '2023-01-04 14:50:17', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (118, 'dd', 'ww', 2, '123', '132', 'qw', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1', 57, 1, '2023-01-04 14:51:30', '2023-01-04 14:51:30', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (119, 'mmnn', 'ggg', 0, '123', '132', '11', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-4/1672815349361169.jpg', 'rrrr', 57, 1, '2023-01-04 14:56:21', '2023-01-04 14:56:21', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (120, 'dda', '12', 1, '123', '123', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '', 57, 1, '2023-01-04 15:11:25', '2023-01-04 15:11:25', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (121, 'xx', 'cc', 0, '456', '234567', 'aa', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-4/1672817212675451.jpg', '23', 57, 0, '2023-01-04 15:19:59', '2023-02-06 14:20:24', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (122, 'dd', 'ww', 1, '22', '11', 'xzc', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-6/1672997469947183.jpg', '111', 57, 1, '2023-01-06 17:31:02', '2023-01-06 17:31:12', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (123, 'd', 's', 0, '2', '1', 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1111', 64, 1, '2023-01-06 17:31:24', '2023-02-03 16:28:46', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (124, 'hgfd', 'hgf', 0, '1234', '123', 'hgf', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-11/1673422311749878.jpg', 'jjjjj', 57, 1, '2023-01-11 15:30:13', '2023-01-11 15:31:54', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (125, 'hjhh', 'yyy', 0, '55@qq.com', '13218133416', '234', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, 57, 1, '2023-02-01 13:29:16', '2023-02-01 13:29:16', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (126, 'ggg', 'fff', 0, '4213@qq.com', '1232', 'eeqwe', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-6/1678107138498682.jpg', 'ggg', 57, 1, '2023-02-01 17:54:05', '2023-03-06 20:52:20', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (128, 'ddd', 'dd', 0, '12', '123', 'www', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '132213', 57, 1, '2023-02-02 09:56:52', '2023-02-02 09:56:52', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (129, 'qqqq', 'sss', 0, '123', '132', 'ddd', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dd', 65, 1, '2023-02-02 18:11:01', '2023-02-02 18:11:13', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (130, 'VVV', 'VVV', 0, '234', '123', 'VVV', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'GGG', 57, 1, '2023-02-03 14:12:50', '2023-02-03 14:12:50', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (131, 'bb', 'cc', 0, '234', '123', 'sd', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sda', 57, 1, '2023-02-03 14:13:14', '2023-02-03 14:13:14', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (132, 'zxc', 'sad', 0, '321', '123', 'we', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dsa', 57, 1, '2023-02-03 14:20:43', '2023-02-26 20:38:03', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (133, 'hg', 'hg', 0, '32', '123', '123', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dsa', 57, 1, '2023-02-03 14:25:43', '2023-03-02 14:53:30', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (134, 'cdcc', 'ccc', 0, '321', '123', 'ccc', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'ddd', 57, 1, '2023-02-06 14:26:56', '2023-03-02 14:53:36', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (135, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, 0, '2023-02-25 17:16:01', '2023-02-25 17:16:01', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (136, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, 0, '2023-02-25 17:16:39', '2023-02-25 17:16:39', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (137, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, 0, '2023-02-25 17:17:00', '2023-02-25 17:17:00', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (138, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, 0, '2023-02-25 17:17:49', '2023-02-25 17:17:49', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (139, '123', '123', 0, '5', '4', '3', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '78', 65, 0, '2023-02-25 17:24:32', '2023-02-25 17:24:32', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (140, 'c', 's', 0, '2', '1', 'x', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-2-25/1677317092256982.jpg', '4444', 64, 1, '2023-02-25 17:25:01', '2023-02-25 17:25:01', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (141, 'd', 's', 1, '2', '1', 'w', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-2-25/1677317157024567.jpg', 'sda', NULL, 1, '2023-02-25 17:26:06', '2023-02-25 17:26:06', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (142, 'x', 's', NULL, NULL, NULL, 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, NULL, 1, '2023-02-25 17:29:15', '2023-02-25 17:29:15', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (143, 'x', 's', NULL, NULL, NULL, 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, NULL, 1, '2023-02-25 17:30:15', '2023-02-25 17:30:15', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (144, 'ff', 'dd', NULL, '2', '1', 'ss', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, NULL, 1, '2023-02-25 17:35:32', '2023-02-25 17:35:32', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (145, 'ccc', 'asd', 0, '214', '13', 'qwe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'zadsaas', 65, 0, '2023-02-26 11:11:43', '2023-02-26 11:11:43', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (146, 'd1', '1', 1, '2341', '1231', 'ad1', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'scxz1', 65, 0, '2023-02-26 11:12:46', '2023-02-26 22:00:54', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (147, 'xzxz', 'asd', 1, '214', '123', 'qwe', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-2-26/1677381201644950.jpg', 'zxdasad', NULL, 0, '2023-02-26 11:13:30', '2023-02-26 11:13:30', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (148, 'sda', 'xc', 0, '32', '12', 'sa', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asd', NULL, 1, '2023-02-27 09:58:34', '2023-02-27 09:59:12', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (149, '123444', '234', 1, '213', '111', 'xxx', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, 0, '2023-02-27 10:00:40', '2023-02-27 10:38:47', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (150, '123777', '7777', 0, '123', '123', '777', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '213', 64, 1, '2023-02-27 10:16:36', '2023-02-27 10:18:53', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (151, 'xzxzc', 'xzcz', 0, '321', '123', 'zxcxz', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sasdad', 58, 1, '2023-02-27 10:34:01', '2023-02-27 10:34:08', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (152, 'zxc', 'xcz', 1, '321', '123', 'ads', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sad', 57, 0, '2023-02-28 14:22:16', '2023-02-28 14:22:16', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (153, 'dd', 'ddd', 0, '31', '123', '王晓鹏', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-3/1677812182998354.jpg', 'adssd', 64, 1, '2023-03-01 16:45:40', '2023-03-03 10:56:25', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (154, '1', '2', 0, '321', '12', 'test2', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '3', 57, 1, '2023-03-03 23:48:33', '2023-03-20 14:15:09', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (155, '123te', '234te', 0, 'te', 'te', 'te', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-6/1678068071993248.jpg', 'ette', 57, 1, '2023-03-06 10:01:19', '2023-03-06 10:01:19', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (156, '1231', '2342', 0, '2', '1', '3', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'ad', 57, 1, '2023-03-06 10:05:21', '2023-03-06 10:05:21', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (157, 'ttt', 'tt', 0, '231@qq', '132141', '123', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sda', 58, 1, '2023-03-13 17:47:46', '2023-03-13 17:47:46', NULL, 0, NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 396 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (247, 128, 40);
INSERT INTO `t_user_role` VALUES (248, 128, 42);
INSERT INTO `t_user_role` VALUES (249, 128, 43);
INSERT INTO `t_user_role` VALUES (250, 129, 40);
INSERT INTO `t_user_role` VALUES (251, 129, 42);
INSERT INTO `t_user_role` VALUES (252, 129, 40);
INSERT INTO `t_user_role` VALUES (253, 129, 42);
INSERT INTO `t_user_role` VALUES (255, 130, 40);
INSERT INTO `t_user_role` VALUES (256, 131, 40);
INSERT INTO `t_user_role` VALUES (261, 123, 40);
INSERT INTO `t_user_role` VALUES (262, 123, 42);
INSERT INTO `t_user_role` VALUES (263, 123, 43);
INSERT INTO `t_user_role` VALUES (266, 121, 42);
INSERT INTO `t_user_role` VALUES (267, 121, 40);
INSERT INTO `t_user_role` VALUES (268, 121, 43);
INSERT INTO `t_user_role` VALUES (275, 135, 40);
INSERT INTO `t_user_role` VALUES (276, 135, 42);
INSERT INTO `t_user_role` VALUES (277, 136, 40);
INSERT INTO `t_user_role` VALUES (278, 136, 42);
INSERT INTO `t_user_role` VALUES (279, 137, 40);
INSERT INTO `t_user_role` VALUES (280, 137, 42);
INSERT INTO `t_user_role` VALUES (281, 138, 40);
INSERT INTO `t_user_role` VALUES (282, 138, 42);
INSERT INTO `t_user_role` VALUES (283, 139, 40);
INSERT INTO `t_user_role` VALUES (284, 139, 42);
INSERT INTO `t_user_role` VALUES (285, 140, 40);
INSERT INTO `t_user_role` VALUES (286, 141, 40);
INSERT INTO `t_user_role` VALUES (287, 145, 40);
INSERT INTO `t_user_role` VALUES (288, 145, 42);
INSERT INTO `t_user_role` VALUES (290, 147, 40);
INSERT INTO `t_user_role` VALUES (294, 132, 40);
INSERT INTO `t_user_role` VALUES (295, 132, 42);
INSERT INTO `t_user_role` VALUES (312, 146, 43);
INSERT INTO `t_user_role` VALUES (315, 148, 40);
INSERT INTO `t_user_role` VALUES (319, 150, 40);
INSERT INTO `t_user_role` VALUES (321, 151, 40);
INSERT INTO `t_user_role` VALUES (324, 149, 40);
INSERT INTO `t_user_role` VALUES (327, 152, 42);
INSERT INTO `t_user_role` VALUES (329, 133, 40);
INSERT INTO `t_user_role` VALUES (330, 134, 40);
INSERT INTO `t_user_role` VALUES (331, 134, 42);
INSERT INTO `t_user_role` VALUES (341, 153, 42);
INSERT INTO `t_user_role` VALUES (342, 153, 54);
INSERT INTO `t_user_role` VALUES (346, 155, 42);
INSERT INTO `t_user_role` VALUES (347, 156, 42);
INSERT INTO `t_user_role` VALUES (382, 157, 42);
INSERT INTO `t_user_role` VALUES (393, 113, 42);
INSERT INTO `t_user_role` VALUES (394, 113, 54);
INSERT INTO `t_user_role` VALUES (395, 154, 42);

SET FOREIGN_KEY_CHECKS = 1;
