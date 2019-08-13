/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 13/08/2019 17:17:57
*/

SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for task_management
-- ----------------------------
DROP TABLE IF EXISTS `task_management`;
CREATE TABLE `task_management`  (
  `task_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `mobile_imei` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机IMEI码',
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '别名（自定义标识）',
  `machine_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '机器码',
  `ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'IP地址',
  `device_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备状态：正常、掉线',
  `reg_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '注册码',
  `expire_date` datetime(0) NULL DEFAULT NULL COMMENT '注册码到期时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`task_id`) USING BTREE
  ) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_management
-- ----------------------------
INSERT INTO `task_management` VALUES (1, 'imei12345678', 'No1', '11111111111111', '172.0.0.1', 'good', 'xxx-yyy-regxx-1235', '2000-01-11 00:00:00', '2019-08-13 00:00:00');


/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 13/08/2019 17:18:07
*/

-- ----------------------------
-- Table structure for yidao
-- ----------------------------
DROP TABLE IF EXISTS `yidao`;
CREATE TABLE `yidao`  (
  `dao_id` bigint(20) NOT NULL COMMENT 'YiDao ID',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '游戏账号',
  `game_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '游戏区服',
  `vip_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'VIP等级',
  `ingot_num` bigint(20) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '元宝数量',
  `task_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '任务类型：练级、刷金',
  `task_phase` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '任务阶段',
  `passwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '游戏密码',
  `account_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号状态',
  `login_times_day` int(11) NULL DEFAULT NULL COMMENT '账号当日登录次数',
  `account_blocked` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号封禁状态',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `logout_time` datetime(0) NULL DEFAULT NULL COMMENT '最近退出时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dao_id`, `account`) USING BTREE
  ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yidao
-- ----------------------------
INSERT INTO `yidao` VALUES (1, 'accout1', '1000', '1', 00000000000000000100, 'a_type', 'c_phase', 'pwd1111', 'ok', 1, 'off', '2019-08-13 16:49:38', '2019-08-14 16:49:44', '2019-08-13 16:49:50');
