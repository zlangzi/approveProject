/*
Navicat MySQL Data Transfer

Source Server         : zl
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : approveproject

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-09-26 22:24:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `application_table`
-- ----------------------------
DROP TABLE IF EXISTS `application_table`;
CREATE TABLE `application_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(80) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `leader_id` int(11) DEFAULT NULL,
  `approver` char(20) DEFAULT NULL,
  `stage` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_application_category` (`category_id`),
  KEY `FK_application_user` (`leader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_table
-- ----------------------------

-- ----------------------------
-- Table structure for `approve_attachment_table`
-- ----------------------------
DROP TABLE IF EXISTS `approve_attachment_table`;
CREATE TABLE `approve_attachment_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_id` int(11) DEFAULT NULL,
  `type` char(20) DEFAULT NULL,
  `path` char(255) DEFAULT NULL,
  `uploadtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_application_attachment` (`application_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve_attachment_table
-- ----------------------------

-- ----------------------------
-- Table structure for `category_table`
-- ----------------------------
DROP TABLE IF EXISTS `category_table`;
CREATE TABLE `category_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_category_parent` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_table
-- ----------------------------
INSERT INTO `category_table` VALUES ('1', '科技攻关项目', 'fasd', '3');
INSERT INTO `category_table` VALUES ('2', '应用基础研究项目', 'asdfa', '3');
INSERT INTO `category_table` VALUES ('3', '根', '根', null);
INSERT INTO `category_table` VALUES ('4', '标准类项目', 'fsafas', '3');
INSERT INTO `category_table` VALUES ('5', '推广应用项目', 'asdfasd', '3');
INSERT INTO `category_table` VALUES ('9', '科技攻关子类2', 'adfasd', '1');
INSERT INTO `category_table` VALUES ('10', '科技攻关子类1', '科技攻关子类1', '1');
INSERT INTO `category_table` VALUES ('11', '标准类项目1', '标准类项目1', '4');
INSERT INTO `category_table` VALUES ('12', '标准类项目1子项目', 'asdfa', '11');

-- ----------------------------
-- Table structure for `detail_table`
-- ----------------------------
DROP TABLE IF EXISTS `detail_table`;
CREATE TABLE `detail_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_id` int(11) DEFAULT NULL,
  `approvetime` bigint(20) DEFAULT NULL,
  `status` char(20) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `approver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_application_details` (`application_id`),
  KEY `FK_approver_details` (`approver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail_table
-- ----------------------------

-- ----------------------------
-- Table structure for `information_table`
-- ----------------------------
DROP TABLE IF EXISTS `information_table`;
CREATE TABLE `information_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `content` text,
  `publishtime` mediumtext,
  `type_id` int(11) DEFAULT NULL,
  `status` char(3) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `orderby` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_info_publisher` (`publisher_id`),
  KEY `FK_info_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information_table
-- ----------------------------

-- ----------------------------
-- Table structure for `info_type_table`
-- ----------------------------
DROP TABLE IF EXISTS `info_type_table`;
CREATE TABLE `info_type_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_type_table
-- ----------------------------
INSERT INTO `info_type_table` VALUES ('1', '通知公告');
INSERT INTO `info_type_table` VALUES ('2', '科技动态');
INSERT INTO `info_type_table` VALUES ('3', '办事指南');
INSERT INTO `info_type_table` VALUES ('4', '处室概况');

-- ----------------------------
-- Table structure for `menu_table`
-- ----------------------------
DROP TABLE IF EXISTS `menu_table`;
CREATE TABLE `menu_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `url` char(100) DEFAULT '#',
  `role_id` int(11) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `isvisible` tinyint(1) unsigned DEFAULT '1' COMMENT '1',
  PRIMARY KEY (`id`),
  KEY `FK_menu_parent` (`parent_id`),
  KEY `FK_role_menu` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_table
-- ----------------------------

-- ----------------------------
-- Table structure for `role_table`
-- ----------------------------
DROP TABLE IF EXISTS `role_table`;
CREATE TABLE `role_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_table
-- ----------------------------
INSERT INTO `role_table` VALUES ('1', '管理员');
INSERT INTO `role_table` VALUES ('2', '项目负责人');
INSERT INTO `role_table` VALUES ('3', '审核专家');

-- ----------------------------
-- Table structure for `user_attachment_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_attachment_table`;
CREATE TABLE `user_attachment_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) DEFAULT NULL,
  `path` char(255) DEFAULT NULL,
  `uploadtime` bigint(20) DEFAULT NULL,
  `type` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_attachment` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_attachment_table
-- ----------------------------

-- ----------------------------
-- Table structure for `user_expand_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_expand_table`;
CREATE TABLE `user_expand_table` (
  `id` int(11) NOT NULL,
  `education` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `university` varchar(40) DEFAULT NULL,
  `industry` varchar(40) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `passed` char(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_expand_table
-- ----------------------------

-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT NULL,
  `gender` char(3) DEFAULT NULL,
  `idcard` char(18) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `username` char(20) DEFAULT NULL,
  `password` char(18) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', 'admin', '1', '510122199505167311', '18487110755', '1148402529@qq.com', 'administrator', '111111', '1');
