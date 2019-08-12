/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 12/08/2019 22:08:05
*/

SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for task_management
-- ----------------------------
DROP TABLE IF EXISTS `task_management`;
CREATE TABLE `task_management`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `mobile_imei` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机IMEI码',
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '别名（自定义标识）',
  `machine_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '机器码',
  `ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'IP地址',
  `device_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备状态：正常、掉线',
  `reg_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '注册码',
  `expire_date` bigint(20) NULL DEFAULT NULL COMMENT '注册码到期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 12/08/2019 22:08:14
*/

-- ----------------------------
-- Table structure for yidao
-- ----------------------------
DROP TABLE IF EXISTS `yidao`;
CREATE TABLE `yidao`  (
  `id` bigint(20) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '游戏账号',
  `game_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '游戏区服',
  `vip_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'VIP等级',
  `ingot_num` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT '元宝数量',
  `task_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '任务类型：练级、刷金',
  `task_phase` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '任务阶段',
  `passwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '游戏密码',
  `account_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号状态',
  `login_times_day` int(11) NULL DEFAULT NULL COMMENT '账号当日登录次数',
  `account_blocked` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号封禁状态',
  `login_time` bigint(20) NULL DEFAULT NULL COMMENT '登录时间',
  `logout_time` bigint(20) NULL DEFAULT NULL COMMENT '最近退出时间',
  PRIMARY KEY (`id`, `account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;
