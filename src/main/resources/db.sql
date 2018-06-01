DROP DATABASE IF EXISTS blog;
/*åˆ›å»ºæ•°æ®åº“ï¼Œå¹¶è®¾ç½®ç¼–ç */
CREATE DATABASE blog DEFAULT CHARACTER SET utf8;

USE blog;

CREATE TABLE `t_blogger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'åšä¸»id',
  `username` VARCHAR(50) NOT NULL COMMENT 'åšä¸»å§“å',
  `password` VARCHAR(100) NOT NULL COMMENT 'åšä¸»å¯†ç ',
  `profile` TEXT COMMENT 'åšä¸»ä¿¡æ¯',
  `nickname` VARCHAR(50) DEFAULT NULL COMMENT 'åšä¸»æ˜µç§°',
  `sign` VARCHAR(100) DEFAULT NULL COMMENT 'åšä¸»ç­¾å',
  `imagename` VARCHAR(100) DEFAULT NULL COMMENT 'åšä¸»å¤´åƒè·¯å¾„',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `t_link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'å‹æƒ…é“¾æ¥è¡¨id',
  `linkname` VARCHAR(100) DEFAULT NULL COMMENT 'å‹æƒ…é“¾æ¥å',
  `linkurl` VARCHAR(200) DEFAULT NULL COMMENT 'å‹æƒ…é“¾æ¥url',
  `orderNum` INT(11) DEFAULT NULL COMMENT 'é“¾æ¥æ’åº',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blogtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'åšå®¢id',
  `typeName` VARCHAR(30) DEFAULT NULL COMMENT 'åšå®¢ç±»åˆ«',
  `orderNum` INT(11) DEFAULT NULL COMMENT 'åšå®¢æ’åº',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'åšå®¢ç±»å‹',
  `title` VARCHAR(200) NOT NULL COMMENT 'åšå®¢é¢˜ç›®',
  `summary` VARCHAR(400) DEFAULT NULL COMMENT 'åšå®¢æ‘˜è¦',
  `releaseDate` DATETIME DEFAULT NULL COMMENT 'å‘å¸ƒæ—¥æœŸ',
  `clickHit` INT(11) DEFAULT NULL COMMENT 'è¯„è®ºæ¬¡æ•°',
  `replyHit` INT(11) DEFAULT NULL COMMENT 'å›å¤æ¬¡æ•°',
  `content` TEXT COMMENT 'åšå®¢å†…å®¹',
  `keyWord` VARCHAR(200) DEFAULT NULL COMMENT 'å…³é”®å­—',
  `type_id` INT(11) DEFAULT NULL COMMENT 'å¤–é”®å…³è”åšå®¢ç±»åˆ«',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'è¯„è®ºè¡¨id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT 'è¯„è®ºè€…çš„ip',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT 'è¯„è®ºå†…å®¹',
  `commentDate` DATETIME DEFAULT NULL COMMENT 'è¯„è®ºæ—¥æœŸ',
  `state` INT(11) DEFAULT NULL COMMENT 'å®¡æ ¸çŠ¶æ€',
  `blog_id` INT(11) DEFAULT NULL COMMENT 'å¤–é”®å…³è”å…·ä½“åšå®¢',
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('1', 'Java', '1');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('16', 'MyBatis', '2');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('17', 'SpringMVC', '3');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('18', 'Spring', '34');
INSERT INTO `blog`.`t_blogtype` (`id`, `typeName`, `orderNum`) VALUES ('19', 'JVM', '6');

<<<<<<< HEAD
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('37', '²âÊÔ3', '²âÊÔ²âÊÔ²âÊÔ11', '2018-02-19 15:03:18', '0', '0', '<p>²âÊÔ²âÊÔ²âÊÔ11</p>', '²âÊÔ', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('38', '²âÊÔ4', '²âÊÔ²âÊÔ²âÊÔ', '2018-02-19 15:03:30', '0', '0', '<p>²âÊÔ²âÊÔ²âÊÔ</p>', '¶î', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('39', '²âÊÔ²âÊÔ²âÊÔ²âÊÔ', '2222', '2018-02-19 15:03:42', '0', '0', '<p>2222</p>', '1', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('40', '²âÊÔ455', '²âÊÔ°¡', '2018-02-19 15:03:59', '0', '0', '<p>²âÊÔ°¡<br/></p>', '²âÊÔ', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('41', 'Ë®Ë®', 'µãµãµÎµÎ', '2018-02-19 15:04:55', '4', '1', '<p>µãµãµÎµÎ</p>', '12', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('42', '²âÊÔmybatis', 'Mybatis²âÊÔ', '2018-02-19 15:21:33', '0', '0', '<p>Mybatis²âÊÔ<img src=\"http://localhost:8080/SSM_blog/static/userImages1/20180219/1519024886626044549.jpg\" title=\"1519024886626044549.jpg\" alt=\"java.jpg\"/></p>', 'mybatis Java', '16');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('43', '²âÊÔSpringMVC', 'SpringMVC²âÊÔ£¡', '2018-02-19 15:22:13', '0', '0', '<p>SpringMVC²âÊÔ£¡</p>', 'springmvc mybatis', '17');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('44', '²âÊÔSpring', '²âÊÔSpring', '2018-02-19 15:22:45', '0', '0', '<p>²âÊÔSpring</p>', 'spring', '18');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('45', '²âÊÔJVM', '²âÊÔJVM', '2018-02-19 15:23:31', '2', '0', '<p>²âÊÔJVM</p>', 'JVM', '19');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('46', '²âÊÔ2', '²âÊÔ²âÊÔ2', '2018-02-19 15:31:10', '1', '0', '<p>²âÊÔ²âÊÔ2<br/></p>', 'Java MyBatis', '17');

INSERT INTO `blog`.`t_blogger` (`id`, `username`, `password`, `profile`, `nickname`, `sign`, `imagename`) VALUES ('1', 'admin', '123', '<p>Ã»ÓĞ¼ò½é£¡</p>', 'ÁõÓî¶«', 'Ã»ÓĞÇ©Ãû', '20180219025821.jpg');


INSERT INTO `blog`.`t_comment` (`id`, `userIp`, `content`, `commentDate`, `state`, `blog_id`) VALUES ('3', '0:0:0:0:0:0:0:1', 'ÆÀÂÛ²âÊÔ£¡', '2018-02-19 14:59:51', '1', '37');
=======
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('37', 'æµ‹è¯•3', 'æµ‹è¯•æµ‹è¯•æµ‹è¯•11', '2018-02-19 15:03:18', '0', '0', '<p>æµ‹è¯•æµ‹è¯•æµ‹è¯•11</p>', 'æµ‹è¯•', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('38', 'æµ‹è¯•4', 'æµ‹è¯•æµ‹è¯•æµ‹è¯•', '2018-02-19 15:03:30', '0', '0', '<p>æµ‹è¯•æµ‹è¯•æµ‹è¯•</p>', 'é¢', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('39', 'æµ‹è¯•æµ‹è¯•æµ‹è¯•æµ‹è¯•', '2222', '2018-02-19 15:03:42', '0', '0', '<p>2222</p>', '1', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('40', 'æµ‹è¯•455', 'æµ‹è¯•å•Š', '2018-02-19 15:03:59', '0', '0', '<p>æµ‹è¯•å•Š<br/></p>', 'æµ‹è¯•', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('41', 'æ°´æ°´', 'ç‚¹ç‚¹æ»´æ»´', '2018-02-19 15:04:55', '4', '1', '<p>ç‚¹ç‚¹æ»´æ»´</p>', '12', '1');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('42', 'æµ‹è¯•mybatis', 'Mybatisæµ‹è¯•', '2018-02-19 15:21:33', '0', '0', '<p>Mybatisæµ‹è¯•<img src=\"http://localhost:8080/SSM_blog/static/userImages1/20180219/1519024886626044549.jpg\" title=\"1519024886626044549.jpg\" alt=\"java.jpg\"/></p>', 'mybatis Java', '16');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('43', 'æµ‹è¯•SpringMVC', 'SpringMVCæµ‹è¯•ï¼', '2018-02-19 15:22:13', '0', '0', '<p>SpringMVCæµ‹è¯•ï¼</p>', 'springmvc mybatis', '17');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('44', 'æµ‹è¯•Spring', 'æµ‹è¯•Spring', '2018-02-19 15:22:45', '0', '0', '<p>æµ‹è¯•Spring</p>', 'spring', '18');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('45', 'æµ‹è¯•JVM', 'æµ‹è¯•JVM', '2018-02-19 15:23:31', '2', '0', '<p>æµ‹è¯•JVM</p>', 'JVM', '19');
INSERT INTO `blog`.`t_blog` (`id`, `title`, `summary`, `releaseDate`, `clickHit`, `replyHit`, `content`, `keyWord`, `type_id`) VALUES ('46', 'æµ‹è¯•2', 'æµ‹è¯•æµ‹è¯•2', '2018-02-19 15:31:10', '1', '0', '<p>æµ‹è¯•æµ‹è¯•2<br/></p>', 'Java MyBatis', '17');

INSERT INTO `blog`.`t_blogger` (`id`, `username`, `password`, `profile`, `nickname`, `sign`, `imagename`) VALUES ('1', 'admin', '123', '<p>æ²¡æœ‰ç®€ä»‹ï¼</p>', 'åˆ˜å®‡ä¸œ', 'æ²¡æœ‰ç­¾å', '20180219025821.jpg');


INSERT INTO `blog`.`t_comment` (`id`, `userIp`, `content`, `commentDate`, `state`, `blog_id`) VALUES ('3', '0:0:0:0:0:0:0:1', 'è¯„è®ºæµ‹è¯•ï¼', '2018-02-19 14:59:51', '1', '37');
>>>>>>> 949d641c88e62af347630a4034e72fa48b7123f1
INSERT INTO `blog`.`t_comment` (`id`, `userIp`, `content`, `commentDate`, `state`, `blog_id`) VALUES ('4', '0:0:0:0:0:0:0:1', '1111', '2018-02-19 15:16:28', '1', '41');

INSERT INTO `blog`.`t_link` (`id`, `linkname`, `linkurl`, `orderNum`) VALUES ('8', 'SpringMvc', NULL, NULL);

