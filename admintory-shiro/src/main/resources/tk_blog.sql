/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : tk_blog

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-11-19 20:45:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) DEFAULT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `content` text,
  `first_picture` varchar(200) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `appreciation` int(11) DEFAULT NULL,
  `share_statement` int(11) DEFAULT NULL,
  `commentabled` int(11) DEFAULT NULL,
  `published` int(11) DEFAULT NULL,
  `recommend` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '看我的', '3', '4', '0', '6', '7', '8', '9', '0', '11', '12', '12', '123', '31', '2019-11-06 17:22:14', '2019-11-22 17:22:17', '1');
INSERT INTO `article` VALUES ('2', '3', '4', '5', '0', '1', '123', null, '123', '123', null, null, null, null, null, '2019-11-17 19:13:13', '2019-12-28 19:13:19', null);
INSERT INTO `article` VALUES ('3', '没事的', '5', '6', '0', '23', '12', '313', '12', '312', null, null, null, null, null, '2019-11-21 19:13:16', '2019-11-26 19:13:25', null);
INSERT INTO `article` VALUES (null, 'a阿达', '6', '7', '0', '23', '42', '32', '13', '12', null, null, '12', null, null, '2019-12-19 19:48:14', '2019-11-21 19:48:17', null);
INSERT INTO `article` VALUES (null, 'ad', 'ad', 'qwe', '0', '11', '321', '12', '3', '123', null, null, null, null, null, '2019-11-29 20:16:32', '2019-11-30 20:16:34', null);
INSERT INTO `article` VALUES (null, 'adaewq', 'qwe', 'qwe', '0', null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) DEFAULT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `content` text,
  `first_picture` varchar(200) DEFAULT NULL,
  `flag` varchar(100) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `appreciation` int(11) DEFAULT NULL,
  `share_statement` int(11) DEFAULT NULL,
  `commentabled` int(11) DEFAULT NULL,
  `published` int(11) DEFAULT NULL,
  `recommend` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `tagid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '11', '12', '12', '123', '31', '2019-11-06 17:22:14', '2019-11-22 17:22:17', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '2', '34', '4', '2019-11-08 17:39:03', '2019-11-29 17:39:07', '1');
INSERT INTO `category` VALUES ('2', null, '1111', '1', null, null, '0');
INSERT INTO `category` VALUES ('3', null, '222', '3', '2019-11-09 16:14:11', '2019-11-09 16:14:11', '0');
INSERT INTO `category` VALUES ('4', null, '3333', '3', '2019-11-09 16:52:07', '2019-11-09 16:52:07', '0');
INSERT INTO `category` VALUES ('5', null, '3333', '3', '2019-11-09 16:53:31', '2019-11-09 16:53:31', '0');
INSERT INTO `category` VALUES ('6', null, '3333', '3', '2019-11-09 16:54:13', '2019-11-09 16:54:13', '0');
INSERT INTO `category` VALUES ('7', null, '3333', '3', '2019-11-09 16:55:25', '2019-11-09 16:55:25', '0');
INSERT INTO `category` VALUES ('8', null, '3333', '3', '2019-11-09 16:58:48', '2019-11-09 16:58:48', '0');
INSERT INTO `category` VALUES ('9', null, '3333', '3', '2019-11-09 17:00:15', '2019-11-09 17:00:15', '0');

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` int(11) DEFAULT NULL,
  `log_key` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `content` varchar(1023) DEFAULT NULL,
  `ip_address` varchar(127) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('1', '2', '0', '4', '5', '2019-11-20 17:05:44', '2019-11-21 17:05:50', '1');
INSERT INTO `logs` VALUES ('2', '3', '5', '啊阿斯顿', '1', '2019-11-28 10:33:06', '2019-11-22 10:33:09', '1');
INSERT INTO `logs` VALUES ('3', null, '0', 'aaqqq', 'azzx', '2019-11-14 10:49:13', '2019-11-14 10:49:13', '0');
INSERT INTO `logs` VALUES ('3', null, '0', 'aaqqq', 'azzx', '2019-11-14 10:50:03', '2019-11-14 10:50:03', '0');
INSERT INTO `logs` VALUES ('0', '777', '0', '没有问题的', null, '2019-11-14 14:43:42', '2019-11-14 14:43:42', '0');
INSERT INTO `logs` VALUES ('0', '777', '0', null, null, '2019-11-14 14:44:31', '2019-11-14 14:44:31', '0');
INSERT INTO `logs` VALUES ('0', '777', '0', '没有问题的', null, '2019-11-14 14:57:54', '2019-11-14 14:57:54', '0');
INSERT INTO `logs` VALUES ('0', '777', '0', '没有问题的', null, '2019-11-14 14:58:22', '2019-11-14 14:58:22', '0');
INSERT INTO `logs` VALUES ('0', '777', '0', '没有问题的1', null, '2019-11-14 14:58:30', '2019-11-14 14:58:30', '0');
INSERT INTO `logs` VALUES ('0', '777', '0', '没有问题的1', null, '2019-11-14 15:00:01', '2019-11-14 15:00:01', '0');
INSERT INTO `logs` VALUES ('0', '11', '0', 'aaaa', null, '2019-11-14 15:00:51', '2019-11-14 15:00:51', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:04:15', '2019-11-14 15:04:15', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:05:03', '2019-11-14 15:05:03', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:19:35', '2019-11-14 15:19:35', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:26:35', '2019-11-14 15:26:35', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:27:47', '2019-11-14 15:27:47', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:29:12', '2019-11-14 15:29:12', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:29:19', '2019-11-14 15:29:19', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:30:30', '2019-11-14 15:30:30', '0');
INSERT INTO `logs` VALUES ('0', '1123', '0', 'aaaabbbcc', null, '2019-11-14 15:31:46', '2019-11-14 15:31:46', '0');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(100) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `redirect` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `hidden` int(11) DEFAULT '0',
  `affix` int(11) DEFAULT '0',
  `always_show` int(11) DEFAULT '0',
  `no_cache` int(11) DEFAULT '1',
  `bread_crumb` int(11) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/', 'Layout', 'Dashboard', 'dashboard', '', null, null, '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('2', '/dashboard', 'dashboard/admin/index', 'Dashboard', null, '控制台', 'dashboard', '1', '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('3', '/article', 'Layout', 'Article', 'list', '博客管理', 'article', null, '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('5', 'list', 'article/index', 'aa', null, '博客列表', 'list', '3', '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('6', '/article/select', 'article/select/index', 'Table', '', '添加博客', 'add', '3', '0', '0', '1', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('7', 'category', 'category/index', 'Tree', null, '分类管理', 'alter', '3', '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('14', 'delete', 'article/delete', 'Tree1', null, '删除博客', 'delete', '3', '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('44', 'selectArticle', 'article/select/selectArticle', 'AS', null, '查询文章', null, '6', '0', '1', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('45', 'selectComment', 'article/select/selectComment', 'pk', null, '查询评论', null, '6', '0', '1', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('46', '/test', 'Layout', 'Test', null, '测试', 'tree', null, '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('47', 'test1', 'article/select/selectComment', 'test1', null, '测试1', null, '46', '0', '0', '0', '1', '1', null, null, null);
INSERT INTO `menu` VALUES ('48', 'test2', 'article/select/selectComment', 'test2', null, '测试2', null, '46', '0', '0', '0', '1', '1', null, null, null);
