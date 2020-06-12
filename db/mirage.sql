/*
 Navicat Premium Data Transfer

 Source Server         : MySQL for 本机
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : mirage

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 04/01/2020 02:44:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grs_ex_fcbasic
-- ----------------------------
DROP TABLE IF EXISTS `grs_ex_fcbasic`;
CREATE TABLE `grs_ex_fcbasic`  (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '表单编码基础表id',
  `date_re` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '日期参考值',
  `code_re` int(11) DEFAULT NULL COMMENT '序号参考值',
  `prefix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '前缀值',
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'fc：form Code' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grs_ex_fcbasic
-- ----------------------------
INSERT INTO `grs_ex_fcbasic` VALUES (1, '20190712', 3, 'DTXF-');

-- ----------------------------
-- Table structure for grs_ex_opbasic
-- ----------------------------
DROP TABLE IF EXISTS `grs_ex_opbasic`;
CREATE TABLE `grs_ex_opbasic`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '基础表主键',
  `form_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '表单来源',
  `nature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性质分类',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grs_ex_opbasic
-- ----------------------------
INSERT INTO `grs_ex_opbasic` VALUES (1, '地铁热线', '咨询');
INSERT INTO `grs_ex_opbasic` VALUES (2, '市政务热线', '投诉');
INSERT INTO `grs_ex_opbasic` VALUES (3, '市信访局转办', '建议');
INSERT INTO `grs_ex_opbasic` VALUES (4, '到访集团', '表扬');
INSERT INTO `grs_ex_opbasic` VALUES (5, '到访市信访局', '举报');
INSERT INTO `grs_ex_opbasic` VALUES (6, '市政务短信', '车站报备');
INSERT INTO `grs_ex_opbasic` VALUES (7, '市政务信箱', '无效');
INSERT INTO `grs_ex_opbasic` VALUES (8, '其他部门转办', '招领');
INSERT INTO `grs_ex_opbasic` VALUES (9, '集团（官网）接信', '挂失');
INSERT INTO `grs_ex_opbasic` VALUES (10, '集团接电接信', '求助');
INSERT INTO `grs_ex_opbasic` VALUES (11, '测试', '测试');

-- ----------------------------
-- Table structure for grs_ex_pp
-- ----------------------------
DROP TABLE IF EXISTS `grs_ex_pp`;
CREATE TABLE `grs_ex_pp`  (
  `pid` int(20) NOT NULL AUTO_INCREMENT COMMENT '表单编码',
  `form_src` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '表单来源',
  `nature` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性质分类',
  `content` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容分类',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '事发区域',
  `event` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '大事记',
  `time` int(11) DEFAULT 0 COMMENT '重复次数',
  `branch` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '线路',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细内容',
  `mode` int(11) DEFAULT NULL COMMENT '回复方式',
  `answer` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答复信息',
  `form_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '表单编码',
  `uid` int(11) DEFAULT NULL COMMENT '外键，指向来电信息表id',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grs_ex_pp
-- ----------------------------
INSERT INTO `grs_ex_pp` VALUES (34, '市政务信箱', '无效', '不知道', '大事', '市南', '大事', 0, '[10, 11]', '输入详细内容...', 1, '输入答复信息...', 'DTXF-201903110099', 54);
INSERT INTO `grs_ex_pp` VALUES (35, '到访市信访局', '投诉', '不知道', '大事', '', '大事', 0, '[10, 11]', '输入详细内容...', 1, '输入答复信息...', 'DTXF-201903110100', 55);
INSERT INTO `grs_ex_pp` VALUES (36, '地铁热线', '咨询', '不知道', '大事', '', '大事', 0, '[9,10]', '输入详细内容...', 1, '输入答复信息...', 'DTXF-201903110101', 56);
INSERT INTO `grs_ex_pp` VALUES (40, '市政务热线', '求助', '不知道', '爱情故事', '仙二', '悲剧', 10, '[10, 12, 15]', '想变成一只狐狸，永远跟着小虎', 1, '一切皆有因果', 'DTXF-201903120020', 60);
INSERT INTO `grs_ex_pp` VALUES (41, '市政务信箱', '车站报备', '剧情', '爱情故事', '仙三剑冢', '悲剧', 5, '[1, 2, 3, 4, 5, 6, 7]', '如果说我还有所眷恋，我也就只剩下眷恋', 1, '活着的人要坚强地活，死了的人才不会白死', 'DTXF-201903120021', 61);
INSERT INTO `grs_ex_pp` VALUES (44, '地铁热线', '咨询', '剧情', '爱情故事', '司云崖', '喜剧', 5, '[6, 8, 11, 12]', '我爱你', 1, '有情人终成眷属', 'DTXF-201903130001', 64);
INSERT INTO `grs_ex_pp` VALUES (49, '集团（官网）接信', '测试', '剧情', '仙侠情缘', '北京软星', '仙剑往事', 500, '[1, 5, 10, 17, 18]', '感谢大家一路的支持', 1, '祝仙剑越来越好', 'DTXF-201903130025', 69);

-- ----------------------------
-- Table structure for grs_ex_user
-- ----------------------------
DROP TABLE IF EXISTS `grs_ex_user`;
CREATE TABLE `grs_ex_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来电号码',
  `phone_home` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '归属地',
  `phone_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来电时间',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `phone2` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `is_secrecy` int(11) DEFAULT 2 COMMENT '是否保密',
  `home` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭住址',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grs_ex_user
-- ----------------------------
INSERT INTO `grs_ex_user` VALUES (54, '13156595313', '仙五前传世界', '2019-03-12 10:22:53', '小兰', '13156595313', 2, '输入家庭住址...');
INSERT INTO `grs_ex_user` VALUES (55, '13269875637', '仙四世界', '2019-03-11 10:32:53', '长卿', '13269875637', 2, '输入家庭住址...');
INSERT INTO `grs_ex_user` VALUES (56, '13269875637', '仙二世界', '2019-03-12 10:32:53', '小虎', '13269875637', 2, '输入家庭住址...');
INSERT INTO `grs_ex_user` VALUES (60, '18796534867', '仙二世界', '2019-03-12 23:48:00', '苏媚', '18796534867', 1, '小虎后山');
INSERT INTO `grs_ex_user` VALUES (61, '13791539658', '仙三剑冢', '2019-03-12 23:53:20', '唐雪见', '13791539658', 2, '唐门');
INSERT INTO `grs_ex_user` VALUES (64, '16593468512', '仙五前传', '2019-03-13 00:07:49', '瑕', '16593468512', 2, '司云崖');
INSERT INTO `grs_ex_user` VALUES (69, '99999999999', '仙剑世界', '2019-03-13 17:43:14', '仙剑奇侠传', '99999999999', 2, '输入家庭住址...');

-- ----------------------------
-- Procedure structure for pin
-- ----------------------------
DROP PROCEDURE IF EXISTS `pin`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pin`( IN p_in INT )
BEGIN
SELECT
	p_in;

SET p_in = 2;
SELECT
	p_in;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pinout
-- ----------------------------
DROP PROCEDURE IF EXISTS `pinout`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pinout`(INOUT p_inout int)
BEGIN
	#Routine body goes here...
select p_inout;
set p_inout=2;
select p_inout;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pout
-- ----------------------------
DROP PROCEDURE IF EXISTS `pout`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pout`(OUT p_out int)
BEGIN
	#Routine body goes here...
select p_out;
set p_out=2;
select p_out;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
