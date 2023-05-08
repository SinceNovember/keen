/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : keen

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 08/05/2023 15:41:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_code_item
-- ----------------------------
DROP TABLE IF EXISTS `t_code_item`;
CREATE TABLE `t_code_item`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '代码项ID',
                                `item_text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码项内容',
                                `item_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码项值',
                                `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
                                `order_num` int NULL DEFAULT NULL COMMENT '排序号',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `code_id` bigint NULL DEFAULT NULL COMMENT '代码ID',
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
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '代码ID',
                                `code_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码名称',
                                `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码描述',
                                `order_num` int NULL DEFAULT NULL COMMENT '排序号',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码表' ROW_FORMAT = DYNAMIC;

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
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门ID',
                           `parent_id` bigint NULL DEFAULT NULL COMMENT '上级部门ID',
                           `dept_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '部门名称',
                           `create_user_id` bigint NOT NULL COMMENT '创建者ID',
                           `order_num` bigint NULL DEFAULT NULL COMMENT '排序',
                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                           `deleted` tinyint NULL DEFAULT 0 COMMENT '删除标志',
                           `dept_short_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门简称',
                           `description` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `t_dept_parent_id`(`parent_id` ASC) USING BTREE,
                           INDEX `t_dept_dept_name`(`dept_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (57, NULL, '开发部', 123, 11, '2023-01-10 16:21:40', '2023-05-06 22:50:26', 0, 'kfb', '开发部');
INSERT INTO `t_dept` VALUES (58, 57, '大数据部', 234, 1, NULL, '2023-05-06 22:50:54', 0, 'dsj', '大数据开发');
INSERT INTO `t_dept` VALUES (59, 58, '她她她', 123, NULL, '2023-01-11 14:19:32', '2023-01-11 14:19:32', 1, 'qqq', '4qwwa');
INSERT INTO `t_dept` VALUES (60, 0, 'ddd', 123, 0, '2023-01-11 15:41:29', '2023-01-11 15:41:29', 0, '1', '23');
INSERT INTO `t_dept` VALUES (61, 0, 'ddd', 123, NULL, '2023-01-11 15:43:02', '2023-01-11 15:43:02', 0, '11', 'qwe');
INSERT INTO `t_dept` VALUES (62, 0, 'wqe', 123, NULL, '2023-01-11 15:43:23', '2023-01-11 15:43:23', 0, 'asd', 'xcz');
INSERT INTO `t_dept` VALUES (63, 0, 'asd', 123, NULL, '2023-01-11 15:45:03', '2023-01-11 15:44:58', 0, 'ads', 'zxc');
INSERT INTO `t_dept` VALUES (64, NULL, '采购部', 123, 12, '2023-01-11 15:45:30', '2023-05-06 22:48:41', 0, 'cgb', '采购物品');
INSERT INTO `t_dept` VALUES (65, 57, '系统开发部', 123, 0, '2023-01-13 15:56:24', '2023-05-06 22:52:11', 0, 'xtkfb', NULL);
INSERT INTO `t_dept` VALUES (66, NULL, 'ddd', 123, 2, '2023-03-02 11:35:17', '2023-03-02 13:07:37', 1, 'ddddd', 'qq');
INSERT INTO `t_dept` VALUES (67, NULL, 'xxx', 123, 0, '2023-03-02 15:29:45', '2023-03-02 15:29:45', 1, 'aaa', 'cccc');
INSERT INTO `t_dept` VALUES (68, 64, 'cc', 123, 1, '2023-03-03 23:49:26', '2023-03-03 23:49:26', 1, 'cc', 'c');
INSERT INTO `t_dept` VALUES (69, 65, '前端开发', 114, 0, '2023-03-23 16:47:44', '2023-05-06 22:52:16', 0, 'qdkf', NULL);
INSERT INTO `t_dept` VALUES (70, NULL, '市场部', 113, 10, '2023-05-06 22:53:01', '2023-05-06 22:53:01', 0, 'scb', NULL);
INSERT INTO `t_dept` VALUES (71, NULL, '招聘部', 113, 8, '2023-05-06 22:53:15', '2023-05-06 22:53:15', 0, 'zpb', NULL);
INSERT INTO `t_dept` VALUES (72, NULL, '营销部', 113, 6, '2023-05-06 22:54:12', '2023-05-06 22:54:12', 0, 'yxb', NULL);

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                                `nickname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
                                `login_time` datetime NOT NULL COMMENT '登录时间',
                                `location` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录地点',
                                `ip` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
                                `system` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '操作系统',
                                `browser` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '浏览器',
                                `user_id` int NULL DEFAULT NULL COMMENT '用户id',
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `t_login_log_login_time`(`login_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1101 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '登录日志表' ROW_FORMAT = DYNAMIC;

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
INSERT INTO `t_login_log` VALUES (870, '王大苗11xx', '2023-03-22 22:20:45', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (871, '王大苗11xx', '2023-03-22 22:26:53', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (872, '王大苗11xx', '2023-03-22 22:32:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (873, '王大苗11xx', '2023-03-23 15:34:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (874, 'test2', '2023-03-24 11:19:30', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (875, 'ccc', '2023-03-24 11:23:49', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 134);
INSERT INTO `t_login_log` VALUES (876, '王大苗11xx', '2023-03-25 09:54:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (877, '王大苗11xx', '2023-03-25 10:27:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (878, '王大苗11xx', '2023-03-25 11:12:38', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (879, 'test2', '2023-03-25 15:36:15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (880, '王晓鹏', '2023-03-25 15:57:40', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (881, '123', '2023-03-25 15:59:11', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (882, 'xxx', '2023-03-25 16:01:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 149);
INSERT INTO `t_login_log` VALUES (883, 'test2', '2023-03-25 16:19:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (884, 'test2', '2023-03-25 16:21:40', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (885, 'test2', '2023-03-25 16:22:28', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (886, 'test2', '2023-03-25 16:26:37', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (887, 'test2', '2023-03-25 16:27:09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (888, 'test2', '2023-03-25 16:27:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (889, 'test2', '2023-03-25 16:30:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (890, 'test2', '2023-03-25 16:47:09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (891, 'test2', '2023-03-25 16:47:30', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (892, 'test2', '2023-03-25 16:50:19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (893, 'test2', '2023-03-25 16:51:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (894, 'test2', '2023-03-25 16:51:35', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (895, 'test2', '2023-03-25 16:52:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (896, 'test2', '2023-03-25 16:54:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (897, 'test2', '2023-03-25 16:55:19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (898, 'test2', '2023-03-25 16:55:47', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (899, 'test2', '2023-03-25 16:56:15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (900, 'test2', '2023-03-25 16:58:09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (901, 'test2', '2023-03-25 16:59:05', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (902, 'test2', '2023-03-25 16:59:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (903, 'test2', '2023-03-25 17:00:58', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (904, 'test2', '2023-03-25 17:01:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (905, 'test2', '2023-03-25 17:04:55', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (906, 'test2', '2023-03-25 17:05:16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (907, 'test2', '2023-03-25 17:06:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (908, 'test2', '2023-03-25 17:06:28', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (909, 'test2', '2023-03-25 17:08:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (910, 'test2', '2023-03-25 17:08:54', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (911, 'test2', '2023-03-25 17:09:51', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (912, 'test2', '2023-03-25 17:10:16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (913, 'test2', '2023-03-25 17:11:49', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (914, 'test2', '2023-03-25 17:13:01', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (915, 'test2', '2023-03-25 17:15:50', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (916, 'test2', '2023-03-25 17:19:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (917, 'test2', '2023-03-25 17:21:51', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (918, 'test2', '2023-03-25 17:23:58', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (919, 'test2', '2023-03-25 17:25:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (920, 'test2', '2023-03-25 17:25:39', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (921, 'test2', '2023-03-25 17:26:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (922, 'test2', '2023-03-25 17:29:42', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (923, 'test2', '2023-03-25 17:30:40', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (924, 'test2', '2023-03-25 17:36:01', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (925, 'test2', '2023-03-25 17:37:38', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (926, 'test2', '2023-03-25 17:38:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (927, 'test2', '2023-03-25 17:39:18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (928, 'test2', '2023-03-25 17:39:37', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (929, 'test2', '2023-03-25 17:41:53', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (930, 'test2', '2023-03-25 17:42:09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (931, 'test2', '2023-03-25 17:44:56', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (932, 'test2', '2023-03-25 17:47:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (933, 'test2', '2023-03-25 17:50:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (934, 'test2', '2023-03-25 17:59:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (935, 'test2', '2023-03-25 18:00:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (936, 'test2', '2023-03-25 18:06:16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (937, 'test2', '2023-03-25 18:06:44', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (938, '王大苗11xx', '2023-03-25 18:08:09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (939, 'test2', '2023-03-25 18:08:33', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (940, 'test2', '2023-03-25 18:08:57', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (941, 'www', '2023-03-25 18:09:58', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (942, 'test2', '2023-03-25 18:10:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (943, 'www', '2023-03-26 17:34:26', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (944, 'www', '2023-03-26 17:34:55', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (945, 'www', '2023-03-26 17:37:47', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (946, 'www', '2023-03-26 17:40:29', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (947, 'www', '2023-03-26 17:40:56', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (948, 'www', '2023-03-26 17:42:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (949, 'www', '2023-03-26 18:01:46', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (950, 'www', '2023-03-26 18:02:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (951, 'test2', '2023-03-26 18:08:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (952, 'www', '2023-03-26 18:16:13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (953, 'test2', '2023-03-26 18:18:46', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (954, 'www', '2023-03-26 19:48:00', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (955, '王大苗11xx', '2023-03-26 19:48:15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (956, 'www', '2023-03-27 09:30:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (957, 'www', '2023-03-27 09:31:31', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (958, 'www', '2023-03-27 09:33:19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (959, 'test2', '2023-03-27 09:34:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (960, 'www', '2023-03-27 09:34:58', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (961, 'test2', '2023-03-27 09:35:07', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (962, 'www', '2023-03-27 14:45:13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (963, '王大苗11xx', '2023-03-27 14:45:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (964, 'www', '2023-03-27 14:47:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (965, 'www', '2023-03-27 14:49:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (966, 'www', '2023-03-27 14:50:26', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (967, 'www', '2023-03-27 14:51:57', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (968, 'www', '2023-03-27 14:53:30', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (969, 'www', '2023-03-27 14:55:49', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (970, 'www', '2023-03-27 14:56:11', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (971, 'www', '2023-03-27 15:14:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (972, '王大苗11xx', '2023-03-27 16:49:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (973, '王大苗11xx', '2023-03-27 16:54:00', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (974, '王大苗11xx', '2023-03-27 17:01:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (975, '王大苗11xx', '2023-03-27 17:04:19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (976, 'www', '2023-03-27 17:05:12', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (977, '王大苗11xx', '2023-03-29 15:55:25', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (978, '王大苗11xx', '2023-03-29 23:06:19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (979, '王大苗11xx', '2023-03-30 09:48:40', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (980, 'www', '2023-03-30 09:48:55', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (981, 'test2', '2023-03-30 10:19:28', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (982, 'www', '2023-03-30 10:20:52', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 128);
INSERT INTO `t_login_log` VALUES (983, 'test2', '2023-03-30 10:52:51', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (984, '王大苗11xxxxzz', '2023-03-31 17:21:51', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (985, 'test2', '2023-03-31 17:49:48', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (986, '王大苗11xxxxzz', '2023-03-31 21:25:10', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (987, 'test2', '2023-03-31 21:27:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (988, '王大苗11xxxxzz', '2023-03-31 22:34:13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (989, '王大苗11xxxxzz', '2023-03-31 22:34:13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (990, '王大苗11xxxxzz', '2023-04-01 13:25:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (991, '王大苗11xxxxzz', '2023-04-01 13:49:39', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (992, '王大苗11xxxxzz', '2023-04-01 15:34:42', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (993, '王大苗11xxxxzz', '2023-04-01 15:41:07', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (994, '王大苗11xxxxzz', '2023-04-01 15:41:07', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (995, '王大苗11xxxxzz', '2023-04-01 15:59:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (996, 'test2', '2023-04-01 16:18:28', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (997, '王大苗11xxxxzz', '2023-04-01 17:11:04', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (998, 'test2', '2023-04-01 17:11:09', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (999, '王大苗11xxxxzz', '2023-04-01 17:12:05', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1000, '王大苗11xxxxzz', '2023-04-01 19:24:23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1001, '王大苗11xxxxzz', '2023-04-01 19:24:23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1002, 'test2', '2023-04-01 20:42:29', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (1003, '王大苗11xxxxzz', '2023-04-03 15:49:44', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1004, '王大苗11xxxxzz', '2023-04-03 15:54:56', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1005, '王大苗11xxxxzz', '2023-04-03 15:58:07', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1006, 'test2', '2023-04-03 17:24:38', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (1007, '王大苗11xxxxzz', '2023-04-03 17:51:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1008, 'test2', '2023-04-03 17:52:18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (1009, '王大苗11xxxxzz', '2023-04-03 17:58:47', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1010, 'test2', '2023-04-03 17:59:48', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (1011, '王大苗11xxxxzz', '2023-04-03 18:07:26', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1012, 'test2', '2023-04-03 18:07:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (1013, '王大苗11xxxxzz', '2023-04-05 15:43:37', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1014, '王大苗11xxxxzz', '2023-04-07 22:45:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1015, '王大苗11xxxxzz', '2023-04-13 10:42:31', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1016, '王大苗11xxxxzz', '2023-04-19 09:59:43', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1017, '王大苗11xxxxzz', '2023-04-19 10:00:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1018, '王大苗11xxxxzz', '2023-04-19 10:00:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1019, '王大苗11xxxxzz', '2023-04-19 10:49:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1020, '王大苗11xxxxzz', '2023-04-19 16:50:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1021, '王大苗11xxxxzz', '2023-04-19 18:05:48', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1022, '王大苗11xxxxzz', '2023-04-19 18:07:13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1023, '王大苗11xxxxzz', '2023-04-22 12:24:49', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1024, 'sd', '2023-04-22 20:52:16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 131);
INSERT INTO `t_login_log` VALUES (1025, '123', '2023-04-22 20:57:14', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 133);
INSERT INTO `t_login_log` VALUES (1026, '王大苗11xxxxzz', '2023-04-23 16:38:07', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1027, '王大苗11xxxxzz', '2023-04-23 16:44:43', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1028, '王晓鹏', '2023-04-23 16:55:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (1029, '王大苗11xxxxzz', '2023-04-23 17:23:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1030, '王晓鹏', '2023-04-23 17:25:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (1031, '王大苗11xxxxzz', '2023-04-23 17:41:35', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1032, '王晓鹏', '2023-04-23 17:50:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (1033, '王大苗11xxxxzz', '2023-04-23 17:50:46', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1034, '王大苗11xxxxzz', '2023-04-24 09:56:18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1035, '王大苗11xxxxzz', '2023-04-24 13:28:46', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1036, '王大苗11xxxxzz', '2023-04-24 15:20:52', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1037, '王大苗11xxxxzz', '2023-04-24 16:07:46', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1038, '王大苗11xxxxzz', '2023-04-24 16:35:01', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1039, '王大苗11xxxxzz', '2023-04-24 16:46:19', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1040, '王晓鹏', '2023-04-25 10:29:47', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (1041, '王晓鹏', '2023-04-25 10:29:54', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (1042, '王大苗测试', '2023-04-25 15:46:48', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1043, '王大苗测试', '2023-04-25 17:48:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1044, '王大苗测试', '2023-04-25 17:48:57', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1045, '王大苗测试', '2023-04-25 17:51:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1046, '王大苗测试', '2023-04-26 17:18:59', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1047, '王大苗测试', '2023-04-26 17:20:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1048, '王晓鹏', '2023-04-26 20:49:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 153);
INSERT INTO `t_login_log` VALUES (1049, '王大苗测试1', '2023-04-28 14:04:39', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1050, '王大苗测试1', '2023-04-28 14:05:16', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1051, '王大苗测试1', '2023-04-28 14:06:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1052, '123', '2023-04-28 14:07:20', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1053, '王大苗测试1', '2023-04-28 14:06:42', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 114);
INSERT INTO `t_login_log` VALUES (1054, '123', '2023-04-28 16:00:45', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1055, '123', '2023-04-28 16:16:23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1056, '123', '2023-04-28 22:30:17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1057, '123', '2023-04-30 15:26:00', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1058, '123', '2023-04-30 15:45:44', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1059, '123', '2023-04-30 16:35:51', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1060, '123', '2023-05-05 13:07:01', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1061, '谢裕东d', '2023-05-05 14:43:32', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1062, '谢裕东d', '2023-05-05 14:45:18', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1063, '谢裕东d', '2023-05-05 14:48:10', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1064, '谢裕东d', '2023-05-05 14:52:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1065, '谢裕东d', '2023-05-05 15:11:31', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1066, '123', '2023-05-05 15:15:48', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1067, '123', '2023-05-05 15:23:56', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1068, '123', '2023-05-05 15:25:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 157);
INSERT INTO `t_login_log` VALUES (1069, 'test2', '2023-05-05 15:33:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 154);
INSERT INTO `t_login_log` VALUES (1070, '谢裕东d', '2023-05-05 16:03:02', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1071, '谢裕东d', '2023-05-05 16:05:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1072, '谢裕东d', '2023-05-05 16:05:45', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1073, '谢裕东d', '2023-05-05 16:17:15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1074, '谢裕东d', '2023-05-05 16:18:01', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1075, '谢裕东d', '2023-05-05 16:18:04', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1076, '谢裕东d', '2023-05-05 16:18:13', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1077, '谢裕东d', '2023-05-05 16:18:17', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1078, '谢裕东d', '2023-05-05 16:18:23', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1079, '谢裕东d', '2023-05-05 16:28:01', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1080, '谢裕东d', '2023-05-05 20:45:41', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1081, '谢裕东d', '2023-05-05 20:46:06', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1082, '谢裕东d', '2023-05-05 20:47:46', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1083, '谢裕东d', '2023-05-05 20:48:34', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1084, '谢裕东d', '2023-05-05 22:25:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1085, '谢裕东d', '2023-05-05 22:25:26', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1086, '谢裕东d', '2023-05-06 14:31:58', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1087, '谢裕东d', '2023-05-06 17:07:08', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1088, '谢裕东d', '2023-05-06 17:09:33', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1089, '谢裕东d', '2023-05-06 17:11:24', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1090, '谢裕东d', '2023-05-06 18:07:11', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1091, '谢裕东d', '2023-05-06 18:09:10', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1092, 'xxx', '2023-05-06 18:49:22', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 149);
INSERT INTO `t_login_log` VALUES (1093, '谢裕东d', '2023-05-06 21:41:27', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1094, 'xxx', '2023-05-06 21:42:11', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 149);
INSERT INTO `t_login_log` VALUES (1095, '谢裕东d', '2023-05-06 21:48:53', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1096, '谢裕东d', '2023-05-06 22:27:49', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1097, '谢裕东', '2023-05-06 23:04:21', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 113);
INSERT INTO `t_login_log` VALUES (1098, '谢晓明', '2023-05-06 23:04:49', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 120);
INSERT INTO `t_login_log` VALUES (1099, '王小虎', '2023-05-06 23:05:15', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 126);
INSERT INTO `t_login_log` VALUES (1100, '王小虎', '2023-05-06 23:15:03', '内网IP|0|0|内网IP|内网IP', '127.0.0.1', 'Windows 10', 'Chrome 11', 126);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
                           `path` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '路由地址',
                           `component` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组件地址',
                           `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
                           `expand` int NULL DEFAULT 0 COMMENT '是否默认展开',
                           `redirect` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '重定向地址',
                           `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单标题',
                           `icon` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
                           `pid` int NULL DEFAULT NULL COMMENT '父ID',
                           `hidden` int NULL DEFAULT 0 COMMENT '是否隐藏',
                           `bread_crumb` int NULL DEFAULT 1 COMMENT '面包屑',
                           `always_show` int NULL DEFAULT NULL COMMENT '是否公开',
                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                           `deleted` tinyint NULL DEFAULT 0 COMMENT '是否删除',
                           `order_num` int NULL DEFAULT NULL COMMENT '排序号',
                           `type` int NULL DEFAULT NULL COMMENT '（1、目录，2、菜单，3、按钮）',
                           `request_method` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请求方法',
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `t_menu_tk`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 189 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '/dashboard', 'dashboard/index', 'dashboard', 0, '', '控制台', 'bi bi-house', NULL, 0, 1, 1, NULL, '2023-04-24 13:51:54', 0, 9, 2, 'GET');
INSERT INTO `t_menu` VALUES (2, '/dashboard', 'dashboard/index', 'Dashboard', 0, '', 'Dashboard', 'bi bi-grid', 1, 0, 1, 1, NULL, '2023-04-04 20:19:57', 1, 1, 2, 'GET');
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
INSERT INTO `t_menu` VALUES (174, '/account', 'Layout', 'account', 0, NULL, '我的账号', 'bi bi-universal-access', NULL, 0, 1, 1, '2023-03-08 14:21:05', '2023-04-25 11:08:02', 0, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (175, '/overview', 'account/index', 'overview', 0, NULL, '个人信息', 'bi bi-award-fill', 174, 0, 1, 1, '2023-03-08 14:22:58', '2023-03-09 11:04:30', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (176, '/message', 'Layout', NULL, 0, NULL, '消息管理', 'bi bi-messenger', NULL, 0, 1, 1, '2023-03-31 18:10:32', '2023-03-31 18:10:32', 0, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (177, '/chat', 'message/chat/index', 'chat', 0, NULL, '聊天管理', 'bi bi-chat-dots', 176, 0, 1, 1, '2023-03-31 18:11:53', '2023-03-31 18:11:53', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (178, '/notification', 'message/notification/index', 'notification', 0, NULL, '通知管理', 'bi bi-bell', 176, 0, 1, 1, '2023-04-01 13:16:18', '2023-04-01 13:16:53', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (179, '/qq', 'dashboard/index', 'qqq', 0, NULL, 'qqqqq', 'bi bi-alarm-fill', NULL, 0, 1, 1, '2023-04-04 20:24:04', '2023-04-04 20:24:22', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (180, '/kkk', 'dashboard/index', 'kk', 0, NULL, 'kkkk', 'bi bi-align-start', NULL, 0, 1, 1, '2023-04-04 20:57:53', '2023-04-04 20:58:59', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (181, '/tes', 'Layout', 'tes', 0, NULL, 'test', 'bi bi-alarm-fill', NULL, 0, 1, 1, '2023-04-04 21:00:31', '2023-04-04 21:00:31', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (182, '/123', 'dashboard/index', '23', 0, '', '11', 'bi bi-arrow-90deg-right', 181, 0, 1, 1, '2023-04-04 21:00:53', '2023-04-04 21:02:23', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (183, '/test', 'dashboard/index', 'test', 0, NULL, 'test', 'bi bi-123', 1, 0, 1, 1, '2023-04-05 09:26:05', '2023-04-05 09:26:05', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (184, '/test', 'dashboard/index', 'test', 0, NULL, 'test1', 'bi bi-align-start', 1, 1, 1, 1, '2023-04-05 09:42:05', '2023-05-06 23:03:44', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (185, '/test1', 'message/ship/index', 'ship', 0, NULL, 'test1', NULL, 178, 0, 0, 1, '2023-04-26 20:58:43', '2023-05-05 21:52:55', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (186, '/test', 'Layout', NULL, 0, NULL, 'testt', 'bi bi-alarm-fill', NULL, 0, 1, 1, '2023-04-27 14:14:17', '2023-04-27 14:14:17', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (187, '/test', 'message/notification/index', 'test2', 0, NULL, 'test2', 'bi bi-alarm-fill', 185, 0, 1, 1, '2023-04-27 14:32:29', '2023-04-27 14:32:29', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (188, '/test2', 'system/user/index', 'test', 0, NULL, 'TEST', 'bi bi-alt', 178, 1, 1, 1, '2023-05-06 19:28:38', '2023-05-06 23:08:41', 0, 0, 2, 'GET');

-- ----------------------------
-- Table structure for t_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_permission`;
CREATE TABLE `t_menu_permission`  (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                      `menu_id` bigint NULL DEFAULT NULL COMMENT '按钮ID',
                                      `permission_id` bigint NULL DEFAULT NULL COMMENT '权限ID',
                                      `permission_type` bigint NULL DEFAULT NULL COMMENT '权限类别（1、角色，2、部门，3、用户）',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 576 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

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
INSERT INTO `t_menu_permission` VALUES (575, 180, 113, 3);

-- ----------------------------
-- Table structure for t_message_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_message_chat`;
CREATE TABLE `t_message_chat`  (
                                   `id` int NOT NULL AUTO_INCREMENT COMMENT '消息',
                                   `from_id` int NULL DEFAULT NULL COMMENT '发送方ID',
                                   `to_id` int NULL DEFAULT NULL COMMENT '接受方ID',
                                   `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL COMMENT '内容',
                                   `content_type` int NULL DEFAULT NULL COMMENT '1文本，2图片',
                                   `type` int NULL DEFAULT NULL COMMENT '发送类别',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `is_read` int NULL DEFAULT NULL COMMENT '1已读，0未读',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 447 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_message_chat
-- ----------------------------

-- ----------------------------
-- Table structure for t_message_chat_user_hidden
-- ----------------------------
DROP TABLE IF EXISTS `t_message_chat_user_hidden`;
CREATE TABLE `t_message_chat_user_hidden`  (
                                               `id` int NOT NULL AUTO_INCREMENT,
                                               `from_id` int NULL DEFAULT NULL,
                                               `to_id` int NULL DEFAULT NULL,
                                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_message_chat_user_hidden
-- ----------------------------
INSERT INTO `t_message_chat_user_hidden` VALUES (1, 114, 134);
INSERT INTO `t_message_chat_user_hidden` VALUES (3, 114, 156);
INSERT INTO `t_message_chat_user_hidden` VALUES (4, 114, 155);
INSERT INTO `t_message_chat_user_hidden` VALUES (10, 114, 120);
INSERT INTO `t_message_chat_user_hidden` VALUES (13, 114, 146);
INSERT INTO `t_message_chat_user_hidden` VALUES (15, 128, 146);
INSERT INTO `t_message_chat_user_hidden` VALUES (21, 114, 128);
INSERT INTO `t_message_chat_user_hidden` VALUES (22, 126, 114);
INSERT INTO `t_message_chat_user_hidden` VALUES (23, 126, 114);
INSERT INTO `t_message_chat_user_hidden` VALUES (24, 126, 114);
INSERT INTO `t_message_chat_user_hidden` VALUES (25, 126, 149);

-- ----------------------------
-- Table structure for t_message_notification
-- ----------------------------
DROP TABLE IF EXISTS `t_message_notification`;
CREATE TABLE `t_message_notification`  (
                                           `id` int NOT NULL AUTO_INCREMENT,
                                           `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                           `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                           `type` int NULL DEFAULT NULL,
                                           `create_user_id` int NULL DEFAULT NULL,
                                           `last_notification_time` datetime NULL DEFAULT NULL,
                                           `create_time` datetime NULL DEFAULT NULL,
                                           `update_time` datetime NULL DEFAULT NULL,
                                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_message_notification
-- ----------------------------
INSERT INTO `t_message_notification` VALUES (1, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 114, '2023-05-06 23:41:10', '2023-04-01 13:49:51', '2023-04-01 17:14:35');
INSERT INTO `t_message_notification` VALUES (12, '管理员通知', '这是一条管理员通知这是一条管理员通知这是一条管理员通知这是一条管理员通知', 2, 126, '2023-05-06 23:47:22', '2023-04-27 13:51:25', '2023-05-06 23:10:17');

-- ----------------------------
-- Table structure for t_message_notification_user
-- ----------------------------
DROP TABLE IF EXISTS `t_message_notification_user`;
CREATE TABLE `t_message_notification_user`  (
                                                `id` int NOT NULL AUTO_INCREMENT,
                                                `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                                `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                                `type` int NULL DEFAULT NULL,
                                                `user_id` int NULL DEFAULT NULL,
                                                `create_time` datetime NULL DEFAULT NULL,
                                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_message_notification_user
-- ----------------------------
INSERT INTO `t_message_notification_user` VALUES (1, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, NULL, '2023-04-01 20:44:33');
INSERT INTO `t_message_notification_user` VALUES (2, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 154, '2023-04-01 20:45:58');
INSERT INTO `t_message_notification_user` VALUES (3, 'test', 'test22', 0, 154, '2023-04-01 22:20:04');
INSERT INTO `t_message_notification_user` VALUES (4, 'test', 'test22', 0, 154, '2023-04-01 22:20:16');
INSERT INTO `t_message_notification_user` VALUES (5, 'test', 'test22', 0, 154, '2023-04-02 21:04:53');
INSERT INTO `t_message_notification_user` VALUES (6, 'test', 'test22', 0, 154, '2023-04-03 17:26:09');
INSERT INTO `t_message_notification_user` VALUES (7, 'xxx', 'xcc', 0, 154, '2023-04-03 17:27:24');
INSERT INTO `t_message_notification_user` VALUES (8, 'xxx', 'xcc', 0, 154, '2023-04-03 17:27:42');
INSERT INTO `t_message_notification_user` VALUES (9, 'xxx', 'xcc', 0, 154, '2023-04-03 17:32:04');
INSERT INTO `t_message_notification_user` VALUES (10, 'xxx', 'xcc', 0, 154, '2023-04-03 17:33:37');
INSERT INTO `t_message_notification_user` VALUES (11, 'test', 'test22', 0, 154, '2023-04-03 17:49:59');
INSERT INTO `t_message_notification_user` VALUES (12, 'xxx', 'xcc', 4, 154, '2023-04-03 18:03:40');
INSERT INTO `t_message_notification_user` VALUES (13, 'xxx', 'xcc', 3, 154, '2023-04-03 18:04:35');
INSERT INTO `t_message_notification_user` VALUES (14, 'xxx', 'xcc', 2, 154, '2023-04-03 18:06:29');
INSERT INTO `t_message_notification_user` VALUES (16, 'xxx', 'xcc', 1, 154, '2023-04-04 10:52:24');
INSERT INTO `t_message_notification_user` VALUES (17, 'xxx', 'xcc', 1, 154, '2023-04-04 10:53:11');
INSERT INTO `t_message_notification_user` VALUES (21, 'xxx', 'xcc', 3, 154, '2023-04-04 11:19:18');
INSERT INTO `t_message_notification_user` VALUES (23, 'xxx', 'xcc', 4, 154, '2023-04-04 15:36:17');
INSERT INTO `t_message_notification_user` VALUES (24, 'xxx', 'xcc', 4, 154, '2023-04-04 15:37:13');
INSERT INTO `t_message_notification_user` VALUES (25, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 154, '2023-04-04 15:39:08');
INSERT INTO `t_message_notification_user` VALUES (26, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 154, '2023-04-04 15:39:23');
INSERT INTO `t_message_notification_user` VALUES (27, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 154, '2023-04-04 15:40:15');
INSERT INTO `t_message_notification_user` VALUES (29, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 154, '2023-04-04 15:46:35');
INSERT INTO `t_message_notification_user` VALUES (30, 'xxx', 'xcc', 4, 153, '2023-04-23 17:26:00');
INSERT INTO `t_message_notification_user` VALUES (31, NULL, NULL, NULL, 114, '2023-04-27 13:51:32');
INSERT INTO `t_message_notification_user` VALUES (32, NULL, NULL, NULL, 126, '2023-05-06 23:10:22');
INSERT INTO `t_message_notification_user` VALUES (33, NULL, NULL, NULL, 126, '2023-05-06 23:10:29');
INSERT INTO `t_message_notification_user` VALUES (34, NULL, NULL, NULL, 126, '2023-05-06 23:10:53');
INSERT INTO `t_message_notification_user` VALUES (35, NULL, NULL, NULL, 126, '2023-05-06 23:11:04');
INSERT INTO `t_message_notification_user` VALUES (36, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 120, '2023-05-06 23:14:02');
INSERT INTO `t_message_notification_user` VALUES (37, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 126, '2023-05-06 23:14:18');
INSERT INTO `t_message_notification_user` VALUES (38, '管理员通知', '这是一条管理员通知这是一条管理员通知这是一条管理员通知这是一条管理员通知', 2, 126, '2023-05-06 23:15:09');
INSERT INTO `t_message_notification_user` VALUES (39, '系统公告', '这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告这是一条公告', 0, 126, '2023-05-06 23:41:10');
INSERT INTO `t_message_notification_user` VALUES (40, '管理员通知', '这是一条管理员通知这是一条管理员通知这是一条管理员通知这是一条管理员通知', 2, 126, '2023-05-06 23:47:09');
INSERT INTO `t_message_notification_user` VALUES (41, '管理员通知', '这是一条管理员通知这是一条管理员通知这是一条管理员通知这是一条管理员通知', 2, 126, '2023-05-06 23:47:22');

-- ----------------------------
-- Table structure for t_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operate_log`;
CREATE TABLE `t_operate_log`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志ID',
                                  `nickname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '操作用户',
                                  `operation` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '操作内容',
                                  `time` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时',
                                  `method` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '操作方法',
                                  `params` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '方法参数',
                                  `ip` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '操作者IP',
                                  `operate_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
                                  `location` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '操作地点',
                                  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX `t_log_create_time`(`operate_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2287 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '操作日志表' ROW_FORMAT = DYNAMIC;

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
INSERT INTO `t_operate_log` VALUES (2231, '王大苗11xx', '添加或修改用户', 358, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=128, username=ddd, password=null, nickname=www, sex=MALE, email=12, mobile=123, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=132213, deptId=69, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-03-23 16:54:17', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2232, '王大苗11xxxxzz', '添加或修改用户', 95, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:50:19', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2233, '王大苗11xxxxzz', '添加或修改用户', 12, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:50:29', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2234, '王大苗11xxxxzz', '添加或修改用户', 28, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:50:34', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2235, '王大苗11xxxxzz', '添加或修改用户', 12, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:50:58', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2236, '王大苗11xxxxzz', '添加或修改用户', 25, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:51:03', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2237, '王大苗11xxxxzz', '添加或修改用户', 11, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:51:11', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2238, '王大苗11xxxxzz', '添加或修改用户', 14, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:51:20', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2239, '王大苗11xxxxzz', '添加或修改用户', 25, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:51:25', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2240, '王大苗11xxxxzz', '添加或修改用户', 14, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:51:42', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2241, '王大苗11xxxxzz', '添加或修改用户', 22, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, roleIds=null, status=VALID, orderNum=1)', '127.0.0.1', '2023-03-30 19:51:47', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2242, '王大苗11xxxxzz', '修改简介背景', 4608, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=114, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-31/1680254518779150.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-03-31 17:22:04', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2243, '王大苗11xxxxzz', '修改简介背景', 3693, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=114, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-31/1680254622908580.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-03-31 17:23:47', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2244, '王大苗11xxxxzz', '修改简介背景', 10, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=114, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-31/1680254664624229.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-03-31 17:24:25', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2245, '王大苗11xxxxzz', '修改简介背景', 21, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-31/1680254935557115.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-03-31 17:28:56', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2246, '王大苗11xxxxzz', '修改简介背景', 8, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-31/1680255133176494.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-03-31 17:32:13', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2247, '王大苗11xxxxzz', '修改简介背景', 8, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-31/1680255178169660.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-03-31 17:32:58', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2248, '王大苗11xxxxzz', '添加或修改用户', 202, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东d, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678433077909633.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, profileImage=null, roleIds=[42, 54], status=LOCK, orderNum=1)', '127.0.0.1', '2023-04-02 17:33:35', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2249, '王大苗11xxxxzz', '修改简介背景', 18, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-2/1680436288673424.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-04-02 19:51:30', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2250, '王大苗11xxxxzz', '修改简介背景', 99, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-04-14 16:35:26', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2251, '王大苗11xxxxzz', '添加或修改用户', 441, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗11xxxxzz, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=[42], status=VALID, orderNum=1)', '127.0.0.1', '2023-04-25 10:23:00', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2252, '王大苗测试', '添加或修改用户', 331, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test345566, password=null, nickname=王大苗测试, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=[42], status=VALID, orderNum=1)', '127.0.0.1', '2023-04-25 10:31:06', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2255, '谢裕东d', '添加或修改用户', 196, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test3455661, password=null, nickname=王大苗测试1, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368444358668.jpg, description=life is biess, work is free, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=[42], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 18:20:46', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2254, '王大苗测试1', '添加或修改用户', 355, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test3455661, password=null, nickname=王大苗测试1, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-10/1678434537816733.jpg, description=life is biess, work is free, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=[42], status=VALID, orderNum=1)', '127.0.0.1', '2023-04-27 11:14:26', '内网IP|0|0|内网IP|内网IP', 114);
INSERT INTO `t_operate_log` VALUES (2256, '谢裕东d', '添加或修改用户', 16, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东d, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368479066963.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, profileImage=null, roleIds=[42, 54], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 18:21:20', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2257, '谢裕东d', '修改简介背景', 44, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368506837744.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-05-06 18:21:47', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2258, '谢裕东d', '修改简介背景', 6, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368703633391.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-05-06 18:25:04', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2259, '谢裕东d', '修改简介背景', 5, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368778523720.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-05-06 18:26:19', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2260, '谢裕东', '添加或修改用户', 127, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东, sex=MALE, email=83428190@qq.com1, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368479066963.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368778523720.jpg, roleIds=[42, 54], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 22:28:40', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2261, '谢裕东', '添加或修改用户', 21, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test, password=null, nickname=王大苗测试1, sex=MALE, email=2, mobile=3, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368444358668.jpg, description=life is biess, work is free, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=[42], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 22:28:49', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2262, '谢裕东', '添加或修改用户', 19, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东, sex=MALE, email=83428190@qq.com, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368479066963.jpg, description=Design is like a fart. If you have to force it, it’s probably shit.1, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368778523720.jpg, roleIds=[42, 54], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 22:28:56', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2263, '谢裕东', '添加或修改用户', 17, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=113, username=12345, password=null, nickname=谢裕东, sex=MALE, email=83428190@qq.com, mobile=132181334161, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368479066963.jpg, description=Design is like a fart. If you have to force it, it’s probably shit, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368778523720.jpg, roleIds=[42, 54], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 22:29:06', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2264, '谢裕东', '添加或修改用户', 21, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=114, username=test, password=null, nickname=王大苗, sex=MALE, email=12345@qq.com, mobile=13218133411, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368444358668.jpg, description=life is biess, work is free, deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg, roleIds=[42], status=VALID, orderNum=1)', '127.0.0.1', '2023-05-06 22:29:51', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2265, '谢裕东', '添加或修改用户', 48, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=120, username=dda, password=null, nickname=谢晓明, sex=FEMALE, email=xiaoli@163.com, mobile=13912345678, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:33:21', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2266, '谢裕东', '添加或修改用户', 2, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=120, username=test2, password=null, nickname=谢晓明, sex=FEMALE, email=xiaoli@163.com, mobile=13912345678, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:33:29', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2267, '谢裕东', '添加或修改用户', 14, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=126, username=test3, password=null, nickname=王小虎, sex=MALE, email=xiaoming@qq.com, mobile=13123456789, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-6/1678107138498682.jpg, description=ggg, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:34:01', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2268, '谢裕东', '添加或修改用户', 9, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=128, username=test4, password=null, nickname=赵小刚, sex=MALE, email=xiaohua@hotmail.com, mobile=13634567890, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=132213, deptId=69, profileImage=null, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:35:00', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2269, '谢裕东', '添加或修改用户', 8, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=131, username=bb, password=null, nickname=谢小明, sex=MALE, email=xiaoyu@yahoo.com, mobile=15009876543, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=sda, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:37:17', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2270, '谢裕东', '添加或修改用户', 28, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=132, username=test5, password=null, nickname=王大治, sex=MALE, email=xiaoyu@126.com, mobile=15901234567, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=dsa, deptId=57, profileImage=null, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:37:44', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2271, '谢裕东', '添加或修改用户', 20, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=133, username=test7, password=null, nickname=赵刚, sex=MALE, email=xiaomeng@sina.com, mobile=18321098765, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=dsa, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:38:17', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2272, '谢裕东', '添加或修改用户', 14, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=134, username=test8, password=null, nickname=徐斌, sex=MALE, email=xiaolu@aliyun.com, mobile=13210987654, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=ddd, deptId=57, profileImage=null, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:40:08', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2273, '谢裕东', '添加或修改用户', 0, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=131, username=test6, password=null, nickname=谢小明, sex=MALE, email=xiaoyu@yahoo.com, mobile=15009876543, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=sda, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:40:14', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2274, '谢裕东', '添加或修改用户', 19, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=146, username=test9, password=null, nickname=赵大海, sex=FEMALE, email=xiaohu@foxmail.com, mobile=18765432109, avatar=https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg, description=scxz1, deptId=65, profileImage=null, roleIds=null, status=LOCK, orderNum=null)', '127.0.0.1', '2023-05-06 22:40:30', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2275, '谢裕东', '添加或修改用户', 9, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=120, username=test2, password=null, nickname=谢晓明, sex=FEMALE, email=xiaoli@163.com, mobile=13912345678, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384236734121.jpg, description=, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:44:00', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2276, '谢裕东', '添加或修改用户', 9, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=126, username=test3, password=null, nickname=王小虎, sex=MALE, email=xiaoming@qq.com, mobile=13123456789, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384257136964.jpg, description=ggg, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:44:18', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2277, '谢裕东', '添加或修改用户', 21, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=128, username=test4, password=null, nickname=赵小刚, sex=MALE, email=xiaohua@hotmail.com, mobile=13634567890, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384291173015.jpg, description=132213, deptId=69, profileImage=null, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:44:53', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2278, '谢裕东', '添加或修改用户', 20, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=131, username=test6, password=null, nickname=谢小明, sex=MALE, email=xiaoyu@yahoo.com, mobile=15009876543, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384302737954.jpg, description=sda, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:45:04', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2279, '谢裕东', '添加或修改用户', 10, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=132, username=test5, password=null, nickname=王大治, sex=MALE, email=xiaoyu@126.com, mobile=15901234567, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384352467480.jpg, description=dsa, deptId=57, profileImage=null, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:45:54', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2280, '谢裕东', '添加或修改用户', 10, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=133, username=test7, password=null, nickname=赵刚, sex=MALE, email=xiaomeng@sina.com, mobile=18321098765, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384365225297.jpg, description=dsa, deptId=57, profileImage=null, roleIds=null, status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:46:06', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2281, '谢裕东', '添加或修改用户', 11, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=134, username=test8, password=null, nickname=徐斌, sex=MALE, email=xiaolu@aliyun.com, mobile=13210987654, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384381997818.jpg, description=ddd, deptId=57, profileImage=null, roleIds=[42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 22:46:23', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2282, '谢裕东', '添加或修改用户', 9, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=146, username=test9, password=null, nickname=赵大海, sex=FEMALE, email=xiaohu@foxmail.com, mobile=18765432109, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384397189147.jpg, description=scxz1, deptId=65, profileImage=null, roleIds=null, status=LOCK, orderNum=null)', '127.0.0.1', '2023-05-06 22:46:38', '内网IP|0|0|内网IP|内网IP', 113);
INSERT INTO `t_operate_log` VALUES (2283, '王小虎', '添加或修改用户', 25, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=126, username=test3, password=null, nickname=王小虎, sex=MALE, email=xiaoming@qq.com, mobile=13123456789, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384257136964.jpg, description=ggg, deptId=57, profileImage=null, roleIds=[57, 42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 23:33:17', '内网IP|0|0|内网IP|内网IP', 126);
INSERT INTO `t_operate_log` VALUES (2284, '王小虎', '修改简介背景', 10, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683387224355224.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-05-06 23:33:45', '内网IP|0|0|内网IP|内网IP', 126);
INSERT INTO `t_operate_log` VALUES (2285, '王小虎', '修改简介背景', 7, 'com.simple.keen.system.controller.UserController.updateProfileImage()', ' userQuery: UserQuery(id=null, username=null, password=null, nickname=null, sex=null, email=null, mobile=null, avatar=null, description=null, deptId=null, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683387246758848.jpg, roleIds=null, status=null, orderNum=null)', '127.0.0.1', '2023-05-06 23:34:07', '内网IP|0|0|内网IP|内网IP', 126);
INSERT INTO `t_operate_log` VALUES (2286, '王小虎', '添加或修改用户', 6, 'com.simple.keen.system.controller.UserController.addOrUpdateUser()', ' userQuery: UserQuery(id=126, username=test3, password=null, nickname=王小虎, sex=MALE, email=xiaoming@qq.com, mobile=13123456789, avatar=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384257136964.jpg, description=Nothing is to be got without pain but poverty., deptId=57, profileImage=https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683387246758848.jpg, roleIds=[57, 42], status=VALID, orderNum=null)', '127.0.0.1', '2023-05-06 23:35:20', '内网IP|0|0|内网IP|内网IP', 126);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                           `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
                           `role_tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色标签',
                           `order_num` bigint NULL DEFAULT NULL COMMENT '排序号',
                           `status` tinyint NULL DEFAULT NULL COMMENT '角色状态',
                           `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                           `deleted` tinyint NULL DEFAULT 0 COMMENT '删除标志',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (40, 'zxcxxx', 'sad', 0, 1, 'tedt', NULL, '2023-03-02 18:31:29', 1);
INSERT INTO `t_role` VALUES (41, 'test2', '4444', 3, 0, 'dddddd', NULL, '2023-01-09 16:49:29', 1);
INSERT INTO `t_role` VALUES (42, '测试角色', 'test', 0, 1, NULL, '2023-01-09 16:13:53', '2023-05-06 22:56:17', 0);
INSERT INTO `t_role` VALUES (43, '信息', 'zz', 0, 0, NULL, '2023-01-09 16:14:58', '2023-03-02 11:03:35', 1);
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
INSERT INTO `t_role` VALUES (54, '经理角色', 'manage', 0, 1, '经理角色', '2023-03-02 18:34:58', '2023-05-06 22:56:08', 0);
INSERT INTO `t_role` VALUES (55, '1', '1', 0, 1, '22', '2023-03-03 22:59:44', '2023-03-03 22:59:44', 1);
INSERT INTO `t_role` VALUES (56, '领导角色', 'leader', 2, 0, '领导角色', '2023-03-03 23:03:30', '2023-05-06 22:55:10', 0);
INSERT INTO `t_role` VALUES (57, '管理员', 'admin', 1, 1, '管理员', '2023-04-26 20:24:18', '2023-05-06 22:55:25', 0);

-- ----------------------------
-- Table structure for t_system_config
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config`  (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                    `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置名称',
                                    `config_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置值',
                                    `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
                                    `order_num` bigint NULL DEFAULT NULL COMMENT '排序号',
                                    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表' ROW_FORMAT = DYNAMIC;

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
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                           `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
                           `password` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
                           `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
                           `email` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                           `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
                           `nickname` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '展示名称',
                           `avatar` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
                           `description` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
                           `dept_id` int NULL DEFAULT NULL COMMENT '部门ID',
                           `profile_image` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简介背景',
                           `status` tinyint NULL DEFAULT NULL COMMENT '状态 0锁定 1有效',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                           `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近访问时间',
                           `deleted` tinyint NULL DEFAULT 0 COMMENT '删除标志',
                           `order_num` int NULL DEFAULT NULL COMMENT '排序',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `t_user_username`(`username` ASC) USING BTREE,
                           INDEX `t_user_mobile`(`mobile` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (113, '12345', '234', 0, '83428190@qq.com', '132181334161', '谢裕东', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368479066963.jpg', 'Design is like a fart. If you have to force it, it’s probably shit', 57, 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368778523720.jpg', 1, '2022-12-16 17:35:58', '2023-05-06 22:29:06', '2022-12-16 17:36:41', 0, 1);
INSERT INTO `t_user` VALUES (114, 'test', '123', 0, '12345@qq.com', '13218133411', '王大苗', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683368444358668.jpg', 'life is biess, work is free', 57, 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-4-14/1681461323828860.jpg', 1, '2022-12-16 17:35:58', '2023-05-06 22:29:51', '2022-12-16 17:36:41', 0, 1);
INSERT INTO `t_user` VALUES (115, 'asd', 'xz', 1, '12', '132456', 'weqsss', 'https://coderthemes.com/hyper_2/saas/assets/images/users/avatar-2.jpg', 'sad', 58, NULL, 1, '2022-12-25 20:43:13', '2023-02-02 13:06:58', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (116, 'hh', 'aa', 1, '234', '132', '刘宇东', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2022-12-28/1672233040634619.jpg', '1213', 57, NULL, 1, '2022-12-28 21:14:11', '2022-12-28 21:14:11', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (117, 'dd', 'ww', 1, '123', '132', 'qw', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1', 57, NULL, 1, '2023-01-04 14:50:17', '2023-01-04 14:50:17', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (118, 'dd', 'ww', 2, '123', '132', 'qw', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1', 57, NULL, 1, '2023-01-04 14:51:30', '2023-01-04 14:51:30', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (119, 'mmnn', 'ggg', 0, '123', '132', '11', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-4/1672815349361169.jpg', 'rrrr', 57, NULL, 1, '2023-01-04 14:56:21', '2023-01-04 14:56:21', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (120, 'test2', '12', 1, 'xiaoli@163.com', '13912345678', '谢晓明', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384236734121.jpg', '', 57, NULL, 1, '2023-01-04 15:11:25', '2023-05-06 22:44:00', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (121, 'xx', 'cc', 0, '456', '234567', 'aa', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-4/1672817212675451.jpg', '23', 57, NULL, 0, '2023-01-04 15:19:59', '2023-02-06 14:20:24', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (122, 'dd', 'ww', 1, '22', '11', 'xzc', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-6/1672997469947183.jpg', '111', 57, NULL, 1, '2023-01-06 17:31:02', '2023-01-06 17:31:12', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (123, 'd', 's', 0, '2', '1', 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1111', 64, NULL, 1, '2023-01-06 17:31:24', '2023-02-03 16:28:46', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (124, 'hgfd', 'hgf', 0, '1234', '123', 'hgf', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-11/1673422311749878.jpg', 'jjjjj', 57, NULL, 1, '2023-01-11 15:30:13', '2023-01-11 15:31:54', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (125, 'hjhh', 'yyy', 0, '55@qq.com', '13218133416', '234', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, 57, NULL, 1, '2023-02-01 13:29:16', '2023-02-01 13:29:16', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (126, 'test3', 'fff', 0, 'xiaoming@qq.com', '13123456789', '王小虎', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384257136964.jpg', 'Nothing is to be got without pain but poverty.', 57, 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683387246758848.jpg', 1, '2023-02-01 17:54:05', '2023-05-06 23:35:20', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (128, 'test4', 'dd', 0, 'xiaohua@hotmail.com', '13634567890', '赵小刚', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384291173015.jpg', '132213', 69, NULL, 1, '2023-02-02 09:56:52', '2023-05-06 22:44:53', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (129, 'qqqq', 'sss', 0, '123', '132', 'ddd', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dd', 65, NULL, 1, '2023-02-02 18:11:01', '2023-02-02 18:11:13', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (130, 'VVV', 'VVV', 0, '234', '123', 'VVV', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'GGG', 57, NULL, 1, '2023-02-03 14:12:50', '2023-02-03 14:12:50', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (131, 'test6', 'cc', 0, 'xiaoyu@yahoo.com', '15009876543', '谢小明', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384302737954.jpg', 'sda', 57, NULL, 1, '2023-02-03 14:13:14', '2023-05-06 22:45:04', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (132, 'test5', 'sad', 0, 'xiaoyu@126.com', '15901234567', '王大治', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384352467480.jpg', 'dsa', 57, NULL, 1, '2023-02-03 14:20:43', '2023-05-06 22:45:54', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (133, 'test7', 'hg', 0, 'xiaomeng@sina.com', '18321098765', '赵刚', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384365225297.jpg', 'dsa', 57, NULL, 1, '2023-02-03 14:25:43', '2023-05-06 22:46:06', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (134, 'test8', 'ccc', 0, 'xiaolu@aliyun.com', '13210987654', '徐斌', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384381997818.jpg', 'ddd', 57, NULL, 1, '2023-02-06 14:26:56', '2023-05-06 22:46:23', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (135, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, NULL, 0, '2023-02-25 17:16:01', '2023-02-25 17:16:01', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (136, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, NULL, 0, '2023-02-25 17:16:39', '2023-02-25 17:16:39', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (137, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, NULL, 0, '2023-02-25 17:17:00', '2023-02-25 17:17:00', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (138, 'sda', 'xzc', 0, NULL, '12', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, NULL, 0, '2023-02-25 17:17:49', '2023-02-25 17:17:49', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (139, '123', '123', 0, '5', '4', '3', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '78', 65, NULL, 0, '2023-02-25 17:24:32', '2023-02-25 17:24:32', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (140, 'c', 's', 0, '2', '1', 'x', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-2-25/1677317092256982.jpg', '4444', 64, NULL, 1, '2023-02-25 17:25:01', '2023-02-25 17:25:01', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (141, 'd', 's', 1, '2', '1', 'w', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-2-25/1677317157024567.jpg', 'sda', NULL, NULL, 1, '2023-02-25 17:26:06', '2023-02-25 17:26:06', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (142, 'x', 's', NULL, NULL, NULL, 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, NULL, NULL, 1, '2023-02-25 17:29:15', '2023-02-25 17:29:15', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (143, 'x', 's', NULL, NULL, NULL, 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, NULL, NULL, 1, '2023-02-25 17:30:15', '2023-02-25 17:30:15', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (144, 'ff', 'dd', NULL, '2', '1', 'ss', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, NULL, NULL, 1, '2023-02-25 17:35:32', '2023-02-25 17:35:32', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (145, 'ccc', 'asd', 0, '214', '13', 'qwe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'zadsaas', 65, NULL, 0, '2023-02-26 11:11:43', '2023-02-26 11:11:43', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (146, 'test9', '1', 1, 'xiaohu@foxmail.com', '18765432109', '赵大海', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-5-6/1683384397189147.jpg', 'scxz1', 65, NULL, 0, '2023-02-26 11:12:46', '2023-05-06 22:46:38', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (147, 'xzxz', 'asd', 1, '214', '123', 'qwe', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-2-26/1677381201644950.jpg', 'zxdasad', NULL, NULL, 0, '2023-02-26 11:13:30', '2023-02-26 11:13:30', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (148, 'sda', 'xc', 0, '32', '12', 'sa', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asd', NULL, NULL, 1, '2023-02-27 09:58:34', '2023-02-27 09:59:12', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (149, '123444', '234', 1, '213', '111', 'xxx', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'asdasd', 58, NULL, 1, '2023-02-27 10:00:40', '2023-02-27 10:38:47', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (150, '123777', '7777', 0, '123', '123', '777', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '213', 64, NULL, 1, '2023-02-27 10:16:36', '2023-02-27 10:18:53', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (151, 'xzxzc', 'xzcz', 0, '321', '123', 'zxcxz', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sasdad', 58, NULL, 1, '2023-02-27 10:34:01', '2023-02-27 10:34:08', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (152, 'zxc', 'xcz', 1, '321', '123', 'ads', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sad', 57, NULL, 0, '2023-02-28 14:22:16', '2023-02-28 14:22:16', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (153, 'dd', 'ddd', 0, '31', '123', '王晓鹏', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-3/1677812182998354.jpg', 'adssd', 64, NULL, 1, '2023-03-01 16:45:40', '2023-03-03 10:56:25', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (154, '1', '2', 0, '321', '12', 'test2', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '3', 57, NULL, 1, '2023-03-03 23:48:33', '2023-03-20 14:15:09', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (155, '123te', '234te', 0, 'te', 'te', 'te', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-3-6/1678068071993248.jpg', 'ette', 57, NULL, 1, '2023-03-06 10:01:19', '2023-03-06 10:01:19', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (156, '1231', '2342', 0, '2', '1', '3', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'ad', 57, NULL, 1, '2023-03-06 10:05:21', '2023-03-06 10:05:21', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (157, 'ttt', 'tt', 0, '231@qq', '132141', '123', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sda', 58, NULL, 1, '2023-03-13 17:47:46', '2023-03-13 17:47:46', NULL, 0, NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
                                `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 424 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (250, 129, 40);
INSERT INTO `t_user_role` VALUES (251, 129, 42);
INSERT INTO `t_user_role` VALUES (252, 129, 40);
INSERT INTO `t_user_role` VALUES (253, 129, 42);
INSERT INTO `t_user_role` VALUES (255, 130, 40);
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
INSERT INTO `t_user_role` VALUES (315, 148, 40);
INSERT INTO `t_user_role` VALUES (319, 150, 40);
INSERT INTO `t_user_role` VALUES (321, 151, 40);
INSERT INTO `t_user_role` VALUES (324, 149, 40);
INSERT INTO `t_user_role` VALUES (327, 152, 42);
INSERT INTO `t_user_role` VALUES (341, 153, 42);
INSERT INTO `t_user_role` VALUES (342, 153, 54);
INSERT INTO `t_user_role` VALUES (346, 155, 42);
INSERT INTO `t_user_role` VALUES (347, 156, 42);
INSERT INTO `t_user_role` VALUES (382, 157, 42);
INSERT INTO `t_user_role` VALUES (395, 154, 42);
INSERT INTO `t_user_role` VALUES (411, 113, 42);
INSERT INTO `t_user_role` VALUES (412, 113, 54);
INSERT INTO `t_user_role` VALUES (413, 114, 42);
INSERT INTO `t_user_role` VALUES (417, 128, 42);
INSERT INTO `t_user_role` VALUES (418, 132, 42);
INSERT INTO `t_user_role` VALUES (419, 134, 42);
INSERT INTO `t_user_role` VALUES (422, 126, 57);
INSERT INTO `t_user_role` VALUES (423, 126, 42);

SET FOREIGN_KEY_CHECKS = 1;
