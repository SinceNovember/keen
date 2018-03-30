DROP DATABASE IF EXISTS blog;
/*创建数据库，并设置编码*/
CREATE DATABASE blog DEFAULT CHARACTER SET utf8;

USE blog;

CREATE TABLE `t_blogger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博主id',
  `username` VARCHAR(50) NOT NULL COMMENT '博主姓名',
  `password` VARCHAR(100) NOT NULL COMMENT '博主密码',
  `profile` TEXT COMMENT '博主信息',
  `nickname` VARCHAR(50) DEFAULT NULL COMMENT '博主昵称',
  `sign` VARCHAR(100) DEFAULT NULL COMMENT '博主签名',
  `imagename` VARCHAR(100) DEFAULT NULL COMMENT '博主头像路径',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `t_link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '友情链接表id',
  `linkname` VARCHAR(100) DEFAULT NULL COMMENT '友情链接名',
  `linkurl` VARCHAR(200) DEFAULT NULL COMMENT '友情链接url',
  `orderNum` INT(11) DEFAULT NULL COMMENT '链接排序',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blogtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `typeName` VARCHAR(30) DEFAULT NULL COMMENT '博客类别',
  `orderNum` INT(11) DEFAULT NULL COMMENT '博客排序',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客类型',
  `title` VARCHAR(200) NOT NULL COMMENT '博客题目',
  `summary` VARCHAR(400) DEFAULT NULL COMMENT '博客摘要',
  `releaseDate` DATETIME DEFAULT NULL COMMENT '发布日期',
  `clickHit` INT(11) DEFAULT NULL COMMENT '评论次数',
  `replyHit` INT(11) DEFAULT NULL COMMENT '回复次数',
  `content` TEXT COMMENT '博客内容',
  `keyWord` VARCHAR(200) DEFAULT NULL COMMENT '关键字',
  `type_id` INT(11) DEFAULT NULL COMMENT '外键关联博客类别',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评论表id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '评论者的ip',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT '评论内容',
  `commentDate` DATETIME DEFAULT NULL COMMENT '评论日期',
  `state` INT(11) DEFAULT NULL COMMENT '审核状态',
  `blog_id` INT(11) DEFAULT NULL COMMENT '外键关联具体博客',
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('1', 'Java', '1');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('16', 'MyBatis', '2');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('17', 'SpringMVC', '3');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('18', 'Spring', '34');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('19', 'JVM', '6');

INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('37', '测试3', '测试测试测试11', '2018-02-19 15:03:18', '0', '0', '<p>测试测试测试11</p>', '测试', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('38', '测试4', '测试测试测试', '2018-02-19 15:03:30', '0', '0', '<p>测试测试测试</p>', '额', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('39', '测试测试测试测试', '2222', '2018-02-19 15:03:42', '0', '0', '<p>2222</p>', '1', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('40', '测试455', '测试啊', '2018-02-19 15:03:59', '0', '0', '<p>测试啊<br/></p>', '测试', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('41', '水水', '点点滴滴', '2018-02-19 15:04:55', '4', '1', '<p>点点滴滴</p>', '12', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('42', '测试mybatis', 'Mybatis测试', '2018-02-19 15:21:33', '0', '0', '<p>Mybatis测试<img src=\"http://localhost:8080/SSM_blog/static/userImages1/20180219/1519024886626044549.jpg\" title=\"1519024886626044549.jpg\" alt=\"java.jpg\"/></p>', 'mybatis Java', '16');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('43', '测试SpringMVC', 'SpringMVC测试！', '2018-02-19 15:22:13', '0', '0', '<p>SpringMVC测试！</p>', 'springmvc mybatis', '17');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('44', '测试Spring', '测试Spring', '2018-02-19 15:22:45', '0', '0', '<p>测试Spring</p>', 'spring', '18');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('45', '测试JVM', '测试JVM', '2018-02-19 15:23:31', '2', '0', '<p>测试JVM</p>', 'JVM', '19');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('46', '测试2', '测试测试2', '2018-02-19 15:31:10', '1', '0', '<p>测试测试2<br/></p>', 'Java MyBatis', '17');

INSERT INTO `blog`.`t_blogger` (`id`, `username`, `password`, `profile`, `nickname`, `sign`, `imagename`) VALUES ('1', 'admin', '123', '<p>没有简介！</p>', '刘宇东', '没有签名', '20180219025821.jpg');


INSERT INTO `blog`.`t_comment` (`id`, `userIp`, `content`, `commentDate`, `state`, `blog_id`) VALUES ('3', '0:0:0:0:0:0:0:1', '评论测试！', '2018-02-19 14:59:51', '1', '37');
INSERT INTO `blog`.`t_comment` (`id`, `userIp`, `content`, `commentDate`, `state`, `blog_id`) VALUES ('4', '0:0:0:0:0:0:0:1', '1111', '2018-02-19 15:16:28', '1', '41');

INSERT INTO `blog`.`t_link` (`id`, `linkname`, `linkurl`, `orderNum`) VALUES ('8', 'SpringMvc', NULL, NULL);

