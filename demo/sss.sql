/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : sss

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-04-13 20:16:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for seatinfo
-- ----------------------------
DROP TABLE IF EXISTS `seatinfo`;
CREATE TABLE `seatinfo` (
  `sid` varchar(255) NOT NULL,
  `seat` text,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_files
-- ----------------------------
DROP TABLE IF EXISTS `tb_files`;
CREATE TABLE `tb_files` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `uploadtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fsize` int(11) DEFAULT NULL,
  `md5` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `dcount` int(11) DEFAULT '0',
  `saleintegral` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  PRIMARY KEY (`fid`),
  KEY `fk_tb_files_tb_user_1` (`uid`),
  CONSTRAINT `fk_tb_files_tb_user_1` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_record`;
CREATE TABLE `tb_record` (
  `rid` varchar(255) NOT NULL,
  `downloadtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  PRIMARY KEY (`rid`),
  KEY `fk_tb_record_tb_user_1` (`uid`),
  KEY `fk_tb_record_tb_files_1` (`fid`),
  CONSTRAINT `fk_tb_record_tb_files_1` FOREIGN KEY (`fid`) REFERENCES `tb_files` (`fid`),
  CONSTRAINT `fk_tb_record_tb_user_1` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `integral` int(11) DEFAULT '20',
  `regtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `lastlogin` datetime DEFAULT NULL,
  `isDel` int(11) DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
