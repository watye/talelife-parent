/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : myproject

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-11-16 10:46:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` text COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'a', 'c4ca4238a0b923820dcc509a6f75849b');
