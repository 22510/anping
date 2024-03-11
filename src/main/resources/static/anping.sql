/*
 Navicat Premium Data Transfer

 Source Server         : qinghe
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : anping

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 10/03/2024 21:19:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for caidanshoucang
-- ----------------------------
DROP TABLE IF EXISTS `caidanshoucang`;
CREATE TABLE `caidanshoucang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增',
  `CaiDanJSON` json NULL COMMENT '收藏菜单名',
  `YongHuMing` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caidanshoucang
-- ----------------------------

-- ----------------------------
-- Table structure for chaxiao
-- ----------------------------
DROP TABLE IF EXISTS `chaxiao`;
CREATE TABLE `chaxiao`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '插销' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chaxiao
-- ----------------------------

-- ----------------------------
-- Table structure for daibanshixiang
-- ----------------------------
DROP TABLE IF EXISTS `daibanshixiang`;
CREATE TABLE `daibanshixiang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `ShiXiangMing` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '待办事项名',
  `ZhongYaoChengDu` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '重要程度',
  `YongHuMing` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `NeiRong` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '待办内容',
  `InsertTime` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建/插入时间',
  `EndTime` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '截至时间',
  `Statu` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '待办事项状态, 已完成/未完成/已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of daibanshixiang
-- ----------------------------
INSERT INTO `daibanshixiang` VALUES (3, '123', '非常紧急', 'QeHing3', '123123', 'Sun Mar 10 10:49:14 CST 2024', 'Wed Mar 20 10:49:14 CST 2024', '已删除');
INSERT INTO `daibanshixiang` VALUES (4, '测试时间', '非常紧急', 'QeHing3', '撒打发 阿斯蒂芬士大夫十分士大夫士大夫', '2024-03-10', '2024-03-13', '已完成');
INSERT INTO `daibanshixiang` VALUES (5, '121', '比较紧急', 'QeHing3', '123123', '2024-03-10', '2024-03-13', '已完成');
INSERT INTO `daibanshixiang` VALUES (6, '123', '非常紧急', 'QeHing3', '123', '2024-03-10', '2024-03-13', '已删除');
INSERT INTO `daibanshixiang` VALUES (7, '合同待审核', '比较紧急', 'yewuzhuguan', '待审核, 合同编号013, 负责业务员:QeHing3', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (8, '合同待审核', '比较紧急', 'yewuzhuguan', '待审核, 合同编号015, 负责业务员:QeHing3', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (9, '合同待审核', '比较紧急', 'yewuzhuguan', '待审核, 合同编号016, 负责业务员:QeHing3', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (10, '合同待审核', '比较紧急', 'QeHing3', '待审核, 合同编号211, 负责业务员:yewuzhuguan', '2024-03-10', '2024-03-13', '已完成');
INSERT INTO `daibanshixiang` VALUES (11, '合同待审核', '比较紧急', 'QeHing3', '待审核, 合同编号090, 负责业务员:yewuzhuguan', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (12, '合同待审核', '比较紧急', 'QeHing3', '待审核, 合同编号090, 负责业务员:yewuzhuguan', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (13, '合同待审核', '比较紧急', 'QeHing3', '待审核, 合同编号091, 负责业务员:yewuzhuguan', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (14, '合同待审核', '比较紧急', 'yewuzhuguan', '待审核, 合同编号658, 负责业务员:QeHing3', '2024-03-10', '2024-03-13', '未完成');
INSERT INTO `daibanshixiang` VALUES (15, '合同待审核', '比较紧急', 'yewuzhuguan', '待审核, 合同编号123, 负责业务员:QeHing3', '2024-03-10', '2024-03-13', '未完成');

-- ----------------------------
-- Table structure for daishoutuihuo
-- ----------------------------
DROP TABLE IF EXISTS `daishoutuihuo`;
CREATE TABLE `daishoutuihuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `YeWuYuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '待收退货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of daishoutuihuo
-- ----------------------------
INSERT INTO `daishoutuihuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '70', '王楠', 'cmxadmin', '2023-12-14 17:34:05', NULL);

-- ----------------------------
-- Table structure for fahuoxinxichaxun
-- ----------------------------
DROP TABLE IF EXISTS `fahuoxinxichaxun`;
CREATE TABLE `fahuoxinxichaxun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `WeiFaJianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '未发件数',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '发货信息查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fahuoxinxichaxun
-- ----------------------------
INSERT INTO `fahuoxinxichaxun` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '20', '李会民', '1511111111', '王楠', '2023-12-14', 'cmxadmin', '2023-12-14 17:53:15', NULL);

-- ----------------------------
-- Table structure for fangguan
-- ----------------------------
DROP TABLE IF EXISTS `fangguan`;
CREATE TABLE `fangguan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '方管' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fangguan
-- ----------------------------
INSERT INTO `fangguan` VALUES (1, '1212', '12121', '2222', '', '', '', '', '', 'cmxadmin', '2023-12-12 20:49:36', NULL);

-- ----------------------------
-- Table structure for fangzhukou
-- ----------------------------
DROP TABLE IF EXISTS `fangzhukou`;
CREATE TABLE `fangzhukou`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '方柱扣' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fangzhukou
-- ----------------------------

-- ----------------------------
-- Table structure for faqizulinfahuo
-- ----------------------------
DROP TABLE IF EXISTS `faqizulinfahuo`;
CREATE TABLE `faqizulinfahuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `WeiFaJianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '未发件数',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '发起租赁发货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faqizulinfahuo
-- ----------------------------
INSERT INTO `faqizulinfahuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '20', '李会民', '151149055', '王楠', '2023-12-14', 'cmxadmin', '2023-12-14 17:20:42', NULL);
INSERT INTO `faqizulinfahuo` VALUES (2, '002', '中国青少年空天科普研学基地', '陕西欧亚', '钢柱箍', '90', '10', '马姗姗', '19391639827', '王楠', '2023-12-13', 'cmxadmin', '2023-12-14 17:22:43', NULL);

-- ----------------------------
-- Table structure for faqizulintuihuo
-- ----------------------------
DROP TABLE IF EXISTS `faqizulintuihuo`;
CREATE TABLE `faqizulintuihuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `WeiShouTuiHuoJianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '未收退货件数',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '发起租赁退货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faqizulintuihuo
-- ----------------------------
INSERT INTO `faqizulintuihuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '60', '20', '李蓉蓉', '15123412345', '王楠', '2023-12-30', 'cmxadmin', '2023-12-14 17:27:22', NULL);

-- ----------------------------
-- Table structure for fukuanjiedian
-- ----------------------------
DROP TABLE IF EXISTS `fukuanjiedian`;
CREATE TABLE `fukuanjiedian`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `FuKuanShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '付款时间',
  `FuKuanLeiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '付款类型',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '付款节点' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fukuanjiedian
-- ----------------------------
INSERT INTO `fukuanjiedian` VALUES (1, '001', '2023-12-26T16:00:00.000Z', '预付款', NULL, 'cmxadmin', '2023-12-26 10:46:49', NULL);
INSERT INTO `fukuanjiedian` VALUES (4, '002', '2023-12-27T16:00:00.000Z', '预付款', NULL, 'cmxadmin', '2023-12-26 10:49:13', NULL);

-- ----------------------------
-- Table structure for gangbeileng
-- ----------------------------
DROP TABLE IF EXISTS `gangbeileng`;
CREATE TABLE `gangbeileng`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '钢背楞' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gangbeileng
-- ----------------------------

-- ----------------------------
-- Table structure for gongjulan
-- ----------------------------
DROP TABLE IF EXISTS `gongjulan`;
CREATE TABLE `gongjulan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `anjianmingcheng` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `MingCheng` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `FuID` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '父ID',
  `ShiFouDaKaiChuangKou` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否打开窗口',
  `TuBiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `QianJingYanSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '前景颜色',
  `BeiJingYanSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '背影颜色',
  `ShiFouXuanZeYiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否选择一行',
  `ZhiXingCaoZuo` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '执行操作',
  `ZuJianLeiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组件类型',
  `BeiZhu` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `ShuoMing` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '说明',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '工具栏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gongjulan
-- ----------------------------
INSERT INTO `gongjulan` VALUES (1, '查询', '查询', '1', '是', 'home', 'red', 'blue', NULL, '/api/busi', 'nzform', '查询', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (2, '添加', '添加', '1', '是', 'home', '#ff00aa', 'red', NULL, '/cmxcore/add', 'nzform', '添加一条记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (3, '新增案例', '新增案例', '1', '是', 'home', '#ff00aa', 'red', NULL, '/cmxcore/add', NULL, '添加一条记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (4, '新增措施前案例', '新增措施前案例', '1', '是', 'home', '#ff00aa', 'red', NULL, '/cmxcore/add', NULL, '添加一条记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (5, '新增措施后案例', '新增措施后案例', '1', '是', 'home', '#ff00aa', 'red', NULL, '/cmxcore/add', NULL, '添加一条记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (6, '删除', '删除', '1', '否', 'delete', 'green', 'blue', '是', '/cmxcore/delete/{id}', NULL, '确认要删除吗?', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (7, '修改', '修改', '1', '是', 'wallet', 'blue', 'yellow', '是', '/cmxcore/update/{id}', 'nzform', '更新一行记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (8, '导出Excel', '导出Excel', '1', '否', 'profile', 'green', 'green', NULL, '/api/busi/exportexcel', NULL, '导出Excel', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (9, '导入Excel', '导入Excel', '1', '文件上传', 'project', '#ff00aa', 'blue', NULL, '/api/busi/importexcel', NULL, '导入Excel', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (10, '追加Excel', '导入Excel', '1', '文件上传', 'schedule', 'red', 'red', NULL, '/api/busi/addexcel', NULL, '导入Excel', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (11, '报送数据', '报送数据', '1', '否', 'baosong.png', NULL, NULL, NULL, '/cmxcore/uploadData', NULL, '报送数据', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (12, '生成邮件', '生成邮件', '1', '否', 'add.png', NULL, NULL, NULL, '/cmxcore/getfujian', NULL, '将以下内容生成附件', '  ', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (13, '邮件预览', '邮件预览', '1', '是', 'preview.png', NULL, NULL, NULL, '/cmxcore/emailPreview/{id}', NULL, '预览邮件内容', '11', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (14, '批量更新', '批量更新', '1', '是', 'update.png', NULL, NULL, NULL, '/cmxcore/updatePl', NULL, '更新多行记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (15, '发邮件', '发邮件', '1', '是', 'page_white_freehand.png', NULL, NULL, NULL, '/cmxcore/sendEmail', NULL, '邮件发送', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (16, '导出TXT', '导出TXT', '1', '否', 'page_white_freehand.png', NULL, NULL, NULL, '/btn/exporttxt', NULL, '导出TXT', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (17, '措施推荐', '措施推荐', '1', '是', 'wallet', 'blue', 'yellow', NULL, '/cmxcore/update/{id}', NULL, '效果评价一行记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (18, '措施评价', '措施评价', '1', '是', 'wallet', 'blue', 'yellow', NULL, '/cmxcore/update/{id}', NULL, '效果评价一行记录', '', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (19, '再次购买', '再次购买', '1', '是', 'update.png', NULL, NULL, '是', '/cmxcore/buyagain/{id}', NULL, '确定要再次购买吗？', ' ', NULL, NULL, NULL);
INSERT INTO `gongjulan` VALUES (20, '全部', '全部', '0', '', '', NULL, NULL, NULL, '', NULL, '', '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for gouziluomuxiaopian
-- ----------------------------
DROP TABLE IF EXISTS `gouziluomuxiaopian`;
CREATE TABLE `gouziluomuxiaopian`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '钩子螺母销片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gouziluomuxiaopian
-- ----------------------------

-- ----------------------------
-- Table structure for hetongyingshoukuanhuizong
-- ----------------------------
DROP TABLE IF EXISTS `hetongyingshoukuanhuizong`;
CREATE TABLE `hetongyingshoukuanhuizong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `HeTongJieSuanZongJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同结算总计',
  `HeTongQingSuanZongJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同清算总计',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '合同应收款汇总' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hetongyingshoukuanhuizong
-- ----------------------------
INSERT INTO `hetongyingshoukuanhuizong` VALUES (1, '001', '1578', '', 'cmxadmin', '2023-12-13 11:32:45', '2023-12-14 17:44:05');

-- ----------------------------
-- Table structure for jiaohengliangwaitao
-- ----------------------------
DROP TABLE IF EXISTS `jiaohengliangwaitao`;
CREATE TABLE `jiaohengliangwaitao`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角横梁外套' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jiaohengliangwaitao
-- ----------------------------

-- ----------------------------
-- Table structure for jueseguanli
-- ----------------------------
DROP TABLE IF EXISTS `jueseguanli`;
CREATE TABLE `jueseguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `JueSe` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `ZhongYaoXing` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '重要性',
  `BeiZhu` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jueseguanli
-- ----------------------------
INSERT INTO `jueseguanli` VALUES (1, '系统管理员', '1', '', NULL, NULL, NULL);
INSERT INTO `jueseguanli` VALUES (8, '业务员', '', '', 'cmxadmin', '2023-12-12 22:36:41', NULL);
INSERT INTO `jueseguanli` VALUES (9, '业务经理', '', '', 'cmxadmin', '2023-12-12 22:36:53', NULL);
INSERT INTO `jueseguanli` VALUES (10, '财务人员', '', '', 'cmxadmin', '2023-12-12 22:37:03', NULL);
INSERT INTO `jueseguanli` VALUES (11, '财务经理', '', '', 'cmxadmin', '2023-12-12 22:37:12', NULL);
INSERT INTO `jueseguanli` VALUES (12, '结算', '', '', 'cmxadmin', '2023-12-12 22:37:22', NULL);
INSERT INTO `jueseguanli` VALUES (13, '结算经理', '', '', 'cmxadmin', '2023-12-12 22:37:31', NULL);
INSERT INTO `jueseguanli` VALUES (14, '收发部门', '', '', 'cmxadmin', '2023-12-12 22:37:57', NULL);
INSERT INTO `jueseguanli` VALUES (15, '收发管理', '', '', 'cmxadmin', '2023-12-12 22:38:11', NULL);
INSERT INTO `jueseguanli` VALUES (16, '公司高管', '', '', 'cmxadmin', '2023-12-12 22:38:25', NULL);

-- ----------------------------
-- Table structure for kehuguanli
-- ----------------------------
DROP TABLE IF EXISTS `kehuguanli`;
CREATE TABLE `kehuguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `KeHuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `KeHuJianCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户简称',
  `ShuiHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '税号',
  `DanWeiDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '单位地址',
  `DianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话',
  `KaiHuXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '开户行',
  `YinHangZhangHu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '银行账户',
  `LianXiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `LianXiDianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `CaiWuRenYuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '财务人员',
  `CaiWuGuDingDianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '财务固定电话',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '客户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kehuguanli
-- ----------------------------

-- ----------------------------
-- Table structure for kufangbeihuo
-- ----------------------------
DROP TABLE IF EXISTS `kufangbeihuo`;
CREATE TABLE `kufangbeihuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `WuLiaoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料数量',
  `ZhiXingRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '执行人',
  `ShiYongShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '使用时间',
  `BeiHuoShuoMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货说明',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房备货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangbeihuo
-- ----------------------------

-- ----------------------------
-- Table structure for kufangbeihuochaxun
-- ----------------------------
DROP TABLE IF EXISTS `kufangbeihuochaxun`;
CREATE TABLE `kufangbeihuochaxun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `WuLiaoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料数量',
  `BeiHuoZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货状态',
  `ZhiXingRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '执行人',
  `ShiYongShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '使用时间',
  `BeiHuoShuoMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货说明',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房备货查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangbeihuochaxun
-- ----------------------------
INSERT INTO `kufangbeihuochaxun` VALUES (1, '001', 'Z0.45-0.21-0.8', 'Z杠', '加固件', '根', '100', '正在备货', '李蓉蓉', '2023-12-13', '正常备货', 'cmxadmin', '2023-12-13 11:20:32', NULL);

-- ----------------------------
-- Table structure for kufangbeihuolishishujuchaxun
-- ----------------------------
DROP TABLE IF EXISTS `kufangbeihuolishishujuchaxun`;
CREATE TABLE `kufangbeihuolishishujuchaxun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `BeiHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货人',
  `BeiHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货时间',
  `BeiHuoZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房备货历史数据查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangbeihuolishishujuchaxun
-- ----------------------------
INSERT INTO `kufangbeihuolishishujuchaxun` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '李会民', '李蓉蓉', '2023-12-14', '待发出', 'cmxadmin', '2023-12-14 17:56:42', NULL);

-- ----------------------------
-- Table structure for kufangdaibeihuo
-- ----------------------------
DROP TABLE IF EXISTS `kufangdaibeihuo`;
CREATE TABLE `kufangdaibeihuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `BeiHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货人',
  `BeiHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货时间',
  `BeiHuoZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房待备货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangdaibeihuo
-- ----------------------------
INSERT INTO `kufangdaibeihuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '李会民', '李蓉蓉', '2023-12-14', '正在备货', 'cmxadmin', '2023-12-14 17:30:53', NULL);

-- ----------------------------
-- Table structure for kufangfahuo
-- ----------------------------
DROP TABLE IF EXISTS `kufangfahuo`;
CREATE TABLE `kufangfahuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `FaHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发货人',
  `FaHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发货时间',
  `JiaShiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房发货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangfahuo
-- ----------------------------
INSERT INTO `kufangfahuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '15114905', '李蓉蓉', '2023-12-15', '张三', '陕A66908', '承租单位', '是', '200', '在途', 'cmxadmin', '2023-12-14 17:33:29', NULL);

-- ----------------------------
-- Table structure for kufangfahuochaxun
-- ----------------------------
DROP TABLE IF EXISTS `kufangfahuochaxun`;
CREATE TABLE `kufangfahuochaxun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `FaHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发货人',
  `FaHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发货时间',
  `JiaShiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房发货查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangfahuochaxun
-- ----------------------------
INSERT INTO `kufangfahuochaxun` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '李会民', '李蓉蓉', '2023-12-15', '张三', '陕A66908', '承租单位', '是', '200', '在途', 'cmxadmin', '2023-12-14 17:57:59', NULL);

-- ----------------------------
-- Table structure for kufangfahuofangshiguanli
-- ----------------------------
DROP TABLE IF EXISTS `kufangfahuofangshiguanli`;
CREATE TABLE `kufangfahuofangshiguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `FaHuoDingDanHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发货订单号',
  `ZongDanHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总单号',
  `FenDanHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '分单号',
  `PeiSongFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配送方式',
  `PeiSongCheLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配送车辆',
  `PeiSongSiJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配送司机',
  `SiJiDianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '司机电话',
  `JianKongRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '监控人',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房发货方式管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangfahuofangshiguanli
-- ----------------------------
INSERT INTO `kufangfahuofangshiguanli` VALUES (1, '0001', '0001', '0001', '货啦啦', '陕A8889', '李四', '15064357890', '王五', 'cmxadmin', '2023-12-13 11:23:02', NULL);

-- ----------------------------
-- Table structure for kufangshoudaotuihuo
-- ----------------------------
DROP TABLE IF EXISTS `kufangshoudaotuihuo`;
CREATE TABLE `kufangshoudaotuihuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `DiuShiMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '丢失明细',
  `SunHuaiMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '损坏明细',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `ShouHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货时间',
  `JiaShiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房收到退货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangshoudaotuihuo
-- ----------------------------
INSERT INTO `kufangshoudaotuihuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '60', '1', '2', '李蓉蓉', '12378947289', '2023-12-30', '张三', '陕A68975', '承担方', '否', '', '已入库', 'cmxadmin', '2023-12-14 17:38:24', NULL);

-- ----------------------------
-- Table structure for kufangtuihuoxinxichaxun
-- ----------------------------
DROP TABLE IF EXISTS `kufangtuihuoxinxichaxun`;
CREATE TABLE `kufangtuihuoxinxichaxun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `YunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '垫付价格',
  `CheLiangXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `JiaShiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '驾驶人',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系',
  `ShouHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货时间',
  `SunHuaiMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '损坏明细',
  `DiuShiMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '丢失明细',
  `HuoWuZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '库房退货信息查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kufangtuihuoxinxichaxun
-- ----------------------------
INSERT INTO `kufangtuihuoxinxichaxun` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '60', '承租方', '否', '', '陕A12121', '张三', '李蓉蓉', '12121212121', '2023-12-30', '2', '1', '已入库', 'cmxadmin', '2023-12-14 18:00:16', NULL);

-- ----------------------------
-- Table structure for liangqiaju
-- ----------------------------
DROP TABLE IF EXISTS `liangqiaju`;
CREATE TABLE `liangqiaju`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '梁卡具' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liangqiaju
-- ----------------------------

-- ----------------------------
-- Table structure for liuchengdingyi
-- ----------------------------
DROP TABLE IF EXISTS `liuchengdingyi`;
CREATE TABLE `liuchengdingyi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `YeWuMingCheng` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务名称',
  `LiuChengMing` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '流程名',
  `ShunXu` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顺序',
  `JueSe` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色',
  `FanWei` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '范围',
  `BieMing` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '别名',
  `TuiHuiWeiZhi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '退回位置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liuchengdingyi
-- ----------------------------
INSERT INTO `liuchengdingyi` VALUES (1, '租赁合同', '租赁合同审批', '0', '8', '自己', '待审批', '0');
INSERT INTO `liuchengdingyi` VALUES (2, '租赁合同', '租赁合同审批', '1', '9', '部门', '业务经理审批', '0');
INSERT INTO `liuchengdingyi` VALUES (3, '租赁合同', '租赁合同审批', '2', '15', '全局', '副经理审批', '0');
INSERT INTO `liuchengdingyi` VALUES (4, '租赁合同', '租赁合同审批', '3', '16', '全局', '总经理审批', '2');

-- ----------------------------
-- Table structure for liuchengjilu
-- ----------------------------
DROP TABLE IF EXISTS `liuchengjilu`;
CREATE TABLE `liuchengjilu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `YongHuMing` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `LiuChengMingCheng` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '流程名称',
  `ShunXu` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行所到节点',
  `YeWuBiaoShi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '业务标识(索引到具体业务信息)',
  `time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `ChuLiJieGuo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '流程在该节点的处理结果(继续/回退)',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理结果备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liuchengjilu
-- ----------------------------
INSERT INTO `liuchengjilu` VALUES (1, 'QeHing3', '租赁合同审批', '0', '008', '24-3-9', '待审核', NULL);
INSERT INTO `liuchengjilu` VALUES (2, 'QeHing3', '租赁合同审批', '1', '008', '24-3-10', '拒绝', NULL);
INSERT INTO `liuchengjilu` VALUES (3, 'QeHing3', '租赁合同审批', '0', '008', '24-3-11', '待审核', NULL);
INSERT INTO `liuchengjilu` VALUES (4, 'QeHing3', '租赁合同审批', '0', '009', '2024-03-10T13:40:50.562', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (10, 'QeHing3', '租赁合同审批', '1', '009', '2024-03-10T15:22:07.899', '通过', '');
INSERT INTO `liuchengjilu` VALUES (11, 'QeHing3', '租赁合同审批', '0', '009', '2024-03-10T15:38:03.850', '不通过', 'test');
INSERT INTO `liuchengjilu` VALUES (12, 'QeHing3', '租赁合同审批', '0', '013', '2024-03-10T15:46:18.992', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (13, 'QeHing3', '租赁合同审批', '0', '013', '2024-03-10T15:58:55.331', '通过', '');
INSERT INTO `liuchengjilu` VALUES (14, 'QeHing3', '租赁合同审批', '0', '013', '2024-03-10T15:59:08.012', '通过', '');
INSERT INTO `liuchengjilu` VALUES (15, 'QeHing3', '租赁合同审批', '0', '015', '2024-03-10T16:34:45.880', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (16, 'QeHing3', '租赁合同审批', '0', '016', '2024-03-10T16:38:48.669', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (17, 'yewuzhuguan', '租赁合同审批', '0', '211', '2024-03-10T18:43:32.177', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (18, 'QeHing3', '租赁合同审批', '1', '008', '2024-03-10T18:44:57.676', '通过', '');
INSERT INTO `liuchengjilu` VALUES (19, 'QeHing3', '租赁合同审批', '1', '016', '2024-03-10T18:45:13.549', '通过', '');
INSERT INTO `liuchengjilu` VALUES (20, 'QeHing3', '租赁合同审批', '1', '016', '2024-03-10T18:45:20.028', '通过', '');
INSERT INTO `liuchengjilu` VALUES (21, 'QeHing3', '租赁合同审批', '1', '015', '2024-03-10T18:45:28.696', '通过', '');
INSERT INTO `liuchengjilu` VALUES (22, 'yewuzhuguan', '租赁合同审批', '0', '090', '2024-03-10T18:51:56.829', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (23, 'yewuzhuguan', '租赁合同审批', '0', '090', '2024-03-10T18:52:09.688', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (24, 'yewuzhuguan', '租赁合同审批', '0', '091', '2024-03-10T18:52:40.123', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (25, 'QeHing3', '租赁合同审批', '0', '658', '2024-03-10T19:11:47.179', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (26, 'QeHing3', '租赁合同审批', '0', '123', '2024-03-10T19:16:23.164', '待审核', 'null');
INSERT INTO `liuchengjilu` VALUES (27, 'QeHing3', '租赁合同审批', '1', '123', '2024-03-10T19:17:00.182', '通过', '');

-- ----------------------------
-- Table structure for mokuaifenpei
-- ----------------------------
DROP TABLE IF EXISTS `mokuaifenpei`;
CREATE TABLE `mokuaifenpei`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `JueSe` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `GongNengLieBiao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '功能列表',
  `MoKuaiMing` varchar(12000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '模块名',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '模块分配' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mokuaifenpei
-- ----------------------------
INSERT INTO `mokuaifenpei` VALUES (1, '1', '添加,删除,修改', '用户管理', '', NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (2, '1', '添加,删除,修改', '模块分配', '', NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (3, '1', '添加,修改,删除,导出Excel', '角色管理', '', NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (4, '8', '添加,修改,删除,导出Excel', '发起租赁发货,租赁合同', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (5, '8', '添加,修改,删除', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (6, '8', '添加,修改,删除', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (7, '10', '添加,修改,删除', '租赁合同,租赁结算,租赁清算,销售合同,销售订单交付', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (8, '12', '添加,修改,删除', '租赁合同,库房发货,库房收到退货,租赁结算,租赁清算,', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (9, '14', '添加,修改,删除', '库房备货,库房发货,库房发货查询,退货员清点货物,库房收到退货', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (10, '15', '添加,修改,删除,导出Excel', '库房备货,库房发货,库房发货查询,库房备货查询,库房发货方式管理,,退货员清点货物,库房收到退货,退货信息查询,物流公司管理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (11, '8', '添加,修改,删除', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (12, '8', '添加,修改,删除', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (13, '9', '添加,修改,删除,导出Excel', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,租赁合同审批', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (14, '10', '添加,修改,删除', '租赁合同,租赁结算,租赁清算,销售合同,销售订单交付', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (15, '11', '添加,修改,删除,导出Excel', '租赁合同,租赁结算,租赁清算,合同应收款汇总,销售合同,销售订单交付,销售业绩汇总,,合同应收款一览,销售应收款一览,', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (16, '12', '添加,修改,删除', '租赁合同,库房发货,库房收到退货,租赁结算,租赁清算', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (17, '13', '添加,修改,删除,导出Excel', '租赁合同,库房发货,库房收到退货,租赁结算,租赁清算,合同应收款汇总', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (18, '14', '添加,修改,删除', '库房备货,库房发货,库房发货查询,退货员清点货物,库房收到退货', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (19, '15', '添加,修改,删除,导出Excel', '库房备货,库房发货,库房发货查询,库房备货查询,库房发货方式管理,,退货员清点货物,库房收到退货,退货信息查询,物流公司管理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (20, '16', '添加,修改,删除,导出Excel', '人员管理,,物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,,客户管理,物流公司管理,,租赁合同,租赁合同审批,发起租赁发货,发货信息查询,库房备货,库房备货查询,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,租赁结算,租赁清算,合同应收款汇总,合同应收款一览,销售应收款一览', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (21, '8', '添加,修改,删除', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,发货信息查询,库房备货查询,库房发货查询,租赁合同物料,租赁结算,租赁清算,退货员清点货物,库房收到退货,退货信息查询', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (22, '9', '添加,修改,删除', '物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,发货信息查询,库房备货查询,库房发货查询,租赁合同物料,租赁结算,租赁清算,退货员清点货物,库房收到退货,退货信息查询,租赁合同审批', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (23, '11', '添加,修改,删除,导出Excel', '租赁合同,租赁结算,租赁清算,合同应收款汇总,销售合同,销售订单交付,销售业绩汇总,合同应收款一览,销售应收款一览', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (24, '12', '添加,修改,删除', '租赁合同,库房发货,库房收到退货,租赁结算,租赁清算', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (25, '13', '添加,修改,删除,导出Excel', '租赁合同,库房发货,库房收到退货,租赁结算,租赁清算,合同应收款汇总', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (26, '14', '添加,修改,删除', '库房备货,库房发货,库房待备货,库房备货查询,库房待备货,库房备货查询,库房发货查询,退货员清点货物,库房收到退货', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (27, '15', '添加,修改,删除,导出Excel', '库房备货,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,库房发货,库房发货查询,库房备货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,物流公司管理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (28, '16', '添加,修改,删除,导出Excel', '人员管理,物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,客户管理,物流公司管理,钢背楞,梁卡具,锁具,角横梁外套,客户管理,物流公司管理,租赁合同,租赁合同审批,发起租赁发货,发货信息查询,库房备货,库房备货查询,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,租赁结算,租赁清算,合同应收款汇总,合同应收款一览,销售应收款一览,租赁合同,租赁合同物料,租赁合同审批,发起租赁发货,发货信息查询,库房待备货,库房备货查询,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,租赁结算,租赁清算,合同应收款汇总,销售合同,销售合同审批,销售发起发货,销售发货信息查询,销售库房备货,销售库房发货,销售库房发货方式管理,销售库房收到退货,销售库房退货查询,销售订单交付,销售业绩汇总', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (29, '10', '添加,修改,删除', '租赁合同,租赁合同物料,租赁结算,租赁清算,合同应收款一览,销售应收款一览', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (30, '8', '添加,修改,删除', '物料汇总,物料库存一览图,租赁合同,租赁合同物料,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房备货历史数据查询,库房发货查询,库房退货信息查询,销售合同,销售合同物料,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房备货历史查询,销售库房发货查询,销售库房退货查询,转租合同,转租合同物料,转租业务员发起收货信息查询,转租业务员发起退回信息查询,转租物料入库历史查询,转租退回物料历史查询\n', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (31, '9', '添加,修改,删除', '物料汇总,物料库存一览图,租赁合同,租赁合同物料,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房备货历史数据查询,库房发货查询,库房退货信息查询,销售合同,销售合同物料,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房备货历史查询,销售库房发货查询,销售库房退货查询,转租合同,转租合同物料,转租业务员发起收货信息查询,转租业务员发起退回信息查询,转租物料入库历史查询,转租退回物料历史查询,租赁合同审批,销售合同审批,转租合同审批\n', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (32, '10', '添加,修改,删除', '租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款\n', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (33, '11', '添加,修改,删除', '租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款,合同应收款一览,销售应收款一览,转租应付款一览', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (34, '12', '添加,修改,删除', '租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (35, '13', '添加,修改,删除', '租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款,合同应收款汇总,销售业绩汇总,转租盈利一览', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (36, '14', '添加,修改,删除', '\n库房待备货,已备货未发货,库房备货历史数据查询,库房发货,库房发货查询,待收退货,退货员清点货物,库房收到退货,库房退货信息查询,销售库房待备货,销售库房已备货未发货,销售库房备货历史查询,销售库房发货,销售库房发货查询,销售库房待收退货,销售库房收到退货,销售库房退货查询,转租物料已发货待入库,转租入库,转租物料入库历史查询,转租退回物料待备货,转租退回物料,转租退回物料历史查询', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (37, '15', '添加,修改,删除', '\n库房待备货,已备货未发货,库房备货历史数据查询,库房发货,库房发货查询,待收退货,退货员清点货物,库房收到退货,库房退货信息查询,销售库房待备货,销售库房已备货未发货,销售库房备货历史查询,销售库房发货,销售库房发货查询,销售库房待收退货,销售库房收到退货,销售库房退货查询,转租物料已发货待入库,转租入库,转租物料入库历史查询,转租退回物料待备货,转租退回物料,转租退回物料历史查询,物流公司管理,库房发货方式管理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (38, '16', '添加,修改,删除', '人员管理,物料汇总,物料库存一览图,客户管理,物流公司管理,库房发货方式管理,租赁合同,租赁合同物料,租赁合同审批,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房待备货,已备货未发货,库房备货历史数据查询,库房发货,库房发货查询,待收退货,退货员清点货物,库房收到退货,库房退货信息查询,租赁结算,租赁清算,合同应收款汇总,销售合同,销售合同物料,销售合同审批,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房待备货,销售库房已备货未发货,销售库房备货历史查询,\n销售库房发货,销售库房发货查询,销售库房待收退货,销售库房收到退货,销售库房退货查询,销售订单交付,销售业绩汇总,转租合同,转租合同物料,转租合同审批,转租业务员发起收货,转租业务员发起收货信息查询,转租业务员发起退回,转租业务员发起退回信息查询,转租物料已发货待入库,转租入库,转租物料入库历史查询,转租退回物料待备货,转租退回物料,转租退回物料历史查询,转租付款,转租盈利一览,合同应收款一览,销售应收款一览,转租应付款一览', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (39, '8', '添加,修改,删除', '业务员', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (40, '9', '添加,修改,删除', '业务员', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (41, '10', '添加,修改,删除', '财务人员', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (42, '11', '添加,修改,删除', '财务经理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (43, '11', '添加,修改,删除', '财务经理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (44, '12', '添加,修改,删除', '结算', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (45, '13', '添加,修改,删除', '结算经理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (46, '12', '添加,修改,删除', '结算人员', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (47, '14', '添加,修改,删除', '收发人员', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (48, '15', '添加,修改,删除', '首发管理', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (49, '16', '添加,修改,删除', '公司高管', NULL, NULL, NULL, NULL);
INSERT INTO `mokuaifenpei` VALUES (50, '8', '添加,修改,删除', '付款节点', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for renyuanguanli
-- ----------------------------
DROP TABLE IF EXISTS `renyuanguanli`;
CREATE TABLE `renyuanguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `XingMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `NianLing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `XingBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `JiaTingZhuZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `YouXiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `DianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话',
  `ShouJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机',
  `ZhiWu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '职务',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '人员管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of renyuanguanli
-- ----------------------------
INSERT INTO `renyuanguanli` VALUES (7, '王楠', '22', '女', 'xxxxxxxx', '', '18064357889', '', '业务员', '', 'cmxadmin', '2023-12-12 19:41:31', '2023-12-13 12:36:20');
INSERT INTO `renyuanguanli` VALUES (8, '薛超', '', '', '', '', '', '', '结算', '', 'cmxadmin', '2023-12-13 12:38:23', NULL);
INSERT INTO `renyuanguanli` VALUES (9, '张帅', '', '', '', '', '', '', '结算经理', '', 'cmxadmin', '2023-12-13 12:38:38', NULL);
INSERT INTO `renyuanguanli` VALUES (10, '李蓉蓉', '', '', '', '', '', '', '收发员', '', 'cmxadmin', '2023-12-13 12:39:10', '2023-12-13 12:39:43');

-- ----------------------------
-- Table structure for shenheliucheng
-- ----------------------------
DROP TABLE IF EXISTS `shenheliucheng`;
CREATE TABLE `shenheliucheng`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `ShenHeMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审核名称',
  `YeWuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '业务名称',
  `GuanJianZiDuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '关键字段',
  `ShenHeZiDuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审核字段',
  `JueSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `ShuJuFanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '数据范围',
  `TongGuoYu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '通过语',
  `JuJueYu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '拒绝语',
  `ShenHeZhaXunMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审核查询名称',
  `XiuGaiYeWuZiDuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改业务字段',
  `ShenHeXuHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审核序号',
  `ShenHeShunXu` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审核顺序',
  `ZiDuanPaiChu` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '字段排除',
  `ZiDuanZhiDing` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '字段指定',
  `ZiDuanZengJia` varchar(88) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '字段增加',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '审核流程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shenheliucheng
-- ----------------------------

-- ----------------------------
-- Table structure for suoju
-- ----------------------------
DROP TABLE IF EXISTS `suoju`;
CREATE TABLE `suoju`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '锁具' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suoju
-- ----------------------------

-- ----------------------------
-- Table structure for tianjiabiaodanceshi
-- ----------------------------
DROP TABLE IF EXISTS `tianjiabiaodanceshi`;
CREATE TABLE `tianjiabiaodanceshi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `XingMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `XingBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `ChuShengRiQi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `XueXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '血型',
  `ShiFouBenDi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否本地',
  `GongYuLou` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '公寓楼',
  `JiaTingChengYuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '家庭成员',
  `NianLing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `ZhengJianZhao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '证件照',
  `RiQiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日期时间',
  `BiYeShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '毕业时间',
  `DengLuMiMaZhongZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录密码重置',
  `ShiFouJianDangLiKa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否建党立卡',
  `RuXueShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '入学时间',
  `XiHuanYanSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '喜欢颜色',
  `GeRenPingJia` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '个人评价',
  `GeRenPingFen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '个人评分',
  `ShiFouQueRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否确认',
  `ZiDongWanCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '自动完成',
  `ChuanSuoKuang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '穿梭框',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '添加表单测试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tianjiabiaodanceshi
-- ----------------------------
INSERT INTO `tianjiabiaodanceshi` VALUES (2, '测试姓名', '女', '10:30', 'null', '是', 'null', '哥哥', '8', 'null', 'null', '2023-12-20T07:36:02.000Z', 'null', 'false', 'null', '#B24545', 'null', 'null', '100', 'null', 'null', 'cmxadmin', '2023-12-20 15:38:16', '2023-12-20 17:09:15');
INSERT INTO `tianjiabiaodanceshi` VALUES (10, '添加表单测试', '女', 'null', NULL, '否', NULL, NULL, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'cmxadmin', '2023-12-21 10:38:39', NULL);
INSERT INTO `tianjiabiaodanceshi` VALUES (19, '10:55', '男', 'SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)', NULL, '是', NULL, NULL, '4', NULL, NULL, '2023-12-21T02:55:06.000Z', NULL, 'true', NULL, '#DA3232', NULL, NULL, NULL, NULL, NULL, 'cmxadmin', '2023-12-21 10:55:42', NULL);
INSERT INTO `tianjiabiaodanceshi` VALUES (44, '添加表单测试', '女', 'SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)', NULL, NULL, NULL, NULL, '18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', NULL, NULL, NULL, 'cmxadmin', '2023-12-21 14:47:45', NULL);
INSERT INTO `tianjiabiaodanceshi` VALUES (45, '添加表单测试', '女', 'SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)', NULL, NULL, NULL, NULL, '18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', NULL, NULL, NULL, 'cmxadmin', '2023-12-22 16:30:09', NULL);
INSERT INTO `tianjiabiaodanceshi` VALUES (46, '添加表单测1', '女', 'SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)', NULL, NULL, NULL, NULL, '18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '3', NULL, NULL, NULL, 'cmxadmin', '2023-12-22 16:30:18', NULL);

-- ----------------------------
-- Table structure for tuihuoxinxichaxun
-- ----------------------------
DROP TABLE IF EXISTS `tuihuoxinxichaxun`;
CREATE TABLE `tuihuoxinxichaxun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `WeiShouTuiHuoJianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '未收退货件数',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '退货信息查询' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tuihuoxinxichaxun
-- ----------------------------
INSERT INTO `tuihuoxinxichaxun` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '60', '20', '李蓉蓉', '12121212121', '王楠', '2023-12-30', 'cmxadmin', '2023-12-14 17:55:23', NULL);

-- ----------------------------
-- Table structure for tuihuoyuanqingdianhuowu
-- ----------------------------
DROP TABLE IF EXISTS `tuihuoyuanqingdianhuowu`;
CREATE TABLE `tuihuoyuanqingdianhuowu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `DiuShiMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '丢失明细',
  `SunHuaiMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '损坏明细',
  `ShouHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `ShouHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货时间',
  `JiaShiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '退货员清点货物' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tuihuoyuanqingdianhuowu
-- ----------------------------
INSERT INTO `tuihuoyuanqingdianhuowu` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '60', '1', '2', '李蓉蓉', '145678996', '2023-12-30', '张三', '陕A55678', '承租方', '否', '', '现场清点', 'cmxadmin', '2023-12-14 17:36:25', NULL);

-- ----------------------------
-- Table structure for wuliaohuizong
-- ----------------------------
DROP TABLE IF EXISTS `wuliaohuizong`;
CREATE TABLE `wuliaohuizong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoMianJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料面积',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `WuLiaoDanJia` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料单价',
  `XianYouKuCun` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '现有库存',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '物料汇总' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wuliaohuizong
-- ----------------------------
INSERT INTO `wuliaohuizong` VALUES (1, 'ZLU杠', '根', '1.11', '6.67', '一对一', '80', '1000', 'cmxadmin', '2023-12-14 15:33:49', NULL);
INSERT INTO `wuliaohuizong` VALUES (2, '方管', '根', '4', '4.8', '一根对一根', '80', '1000', 'cmxadmin', '2023-12-14 15:34:48', NULL);
INSERT INTO `wuliaohuizong` VALUES (3, '插销', '个', '0', '0.4', '一对一', '70', '1000', 'cmxadmin', '2023-12-14 15:35:30', NULL);
INSERT INTO `wuliaohuizong` VALUES (4, '方柱扣', '根', '0', '14', '一根对一根 四根为一套', '60', '1000', 'cmxadmin', '2023-12-14 15:36:31', NULL);

-- ----------------------------
-- Table structure for wuliaojiageguanli
-- ----------------------------
DROP TABLE IF EXISTS `wuliaojiageguanli`;
CREATE TABLE `wuliaojiageguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `ShangPinBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品编号',
  `ShangPinShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品数量',
  `HuoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货数量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '物料价格管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wuliaojiageguanli
-- ----------------------------

-- ----------------------------
-- Table structure for wuliaoshuliang
-- ----------------------------
DROP TABLE IF EXISTS `wuliaoshuliang`;
CREATE TABLE `wuliaoshuliang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `ShangPinBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品编号',
  `ShangPinShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品数量',
  `ShangPinKuCun` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品库存',
  `ShangPinQueHuo` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '商品缺货',
  `GouMaiShangXian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '购买上限',
  `GouMaiXiaXian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '购买下限',
  `JinHuoShangXian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '进货上限',
  `JinHuoXiaXian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '进货下限',
  `ZongJinHuoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总进货数量',
  `BenCiJinHuoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '本次进货数量',
  `BenCiJinHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '本次进货时间',
  `LiShiJinHuoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '历史进货数量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '物料数量' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wuliaoshuliang
-- ----------------------------

-- ----------------------------
-- Table structure for wuliaoxinxiguanli
-- ----------------------------
DROP TABLE IF EXISTS `wuliaoxinxiguanli`;
CREATE TABLE `wuliaoxinxiguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '物料信息管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wuliaoxinxiguanli
-- ----------------------------

-- ----------------------------
-- Table structure for wuliugongsiguanli
-- ----------------------------
DROP TABLE IF EXISTS `wuliugongsiguanli`;
CREATE TABLE `wuliugongsiguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiuGongSiMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物流公司名称',
  `DiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地址',
  `LianXiRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `LianXiDianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `CheLiangXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆信息',
  `SiJiXingMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '司机姓名',
  `SiJiDianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '司机电话',
  `CheLiangGuiGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆规格',
  `ZuiDaZaiZhong` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '最大载重',
  `CheLiangBaoXian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '车辆保险',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '物流公司管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wuliugongsiguanli
-- ----------------------------

-- ----------------------------
-- Table structure for xiaoshouhetong
-- ----------------------------
DROP TABLE IF EXISTS `xiaoshouhetong`;
CREATE TABLE `xiaoshouhetong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `KeHuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `ChanPinMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `DunShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '吨数',
  `DanJia` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '单价',
  `DingJin` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '定金',
  `HeTongZongE` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同总额',
  `KeYongYuE` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '可用余额',
  `YingShouJinE` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '应收金额',
  `ShiFouKaiPiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否开票',
  `HeTongZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同状态',
  `QianDingRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '签订人',
  `ZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '状态',
  `DingJinZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '定金状态',
  `HeTongMuBan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同模板',
  `HeTongJinDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同进度',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '销售合同' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xiaoshouhetong
-- ----------------------------

-- ----------------------------
-- Table structure for xiaoxituisonglog
-- ----------------------------
DROP TABLE IF EXISTS `xiaoxituisonglog`;
CREATE TABLE `xiaoxituisonglog`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '消息通信记录ID',
  `XiaoXiNeiRong` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息内容',
  `FaSongFangId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息发送者的用户ID',
  `JieShouFangId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息接收者的用户ID',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '已发送' COMMENT '消息状态: sent, read, 已发送, 已读',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息类型: info, remind, warn, 通知, 提醒, 警告',
  `UserName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名, 执行此操作的用户信息 ( 不确定是否需要 )',
  `InsertTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息发送时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息更新时间 ( 可以用来记录接收方读取该消息的时间 )',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1766785319757905922 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xiaoxituisonglog
-- ----------------------------
INSERT INTO `xiaoxituisonglog` VALUES (1766776897603862530, '有租赁合同需要审批, 合同编号:211, 负责业务员:yewuzhuguan', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:43:32.165', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766777256246214658, '合同编号:008审批结果为:通过.', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:44:57.682', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766777322814013442, '合同编号:016审批结果为:通过.', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:45:13.553', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766777349955354625, '合同编号:016审批结果为:通过.', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:45:20.031', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766777386336747521, '合同编号:015审批结果为:通过.', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:45:28.700', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766779014230016002, '有租赁合同需要审批, 合同编号:090, 负责业务员:yewuzhuguan', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:51:56.827', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766779068181348353, '有租赁合同需要审批, 合同编号:090, 负责业务员:yewuzhuguan', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:52:09.686', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766779195809824770, '有租赁合同需要审批, 合同编号:091, 负责业务员:yewuzhuguan', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T18:52:40.121', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766784006932365313, '有租赁合同需要审批, 合同编号:658, 负责业务员:QeHing3', 'QeHing3', 'yewuzhuguan', '已发送', 'info', NULL, '2024-03-10T19:11:47.178', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766785164535103490, '有租赁合同需要审批, 合同编号:123, 负责业务员:QeHing3', 'QeHing3', 'yewuzhuguan', '已发送', 'info', NULL, '2024-03-10T19:16:23.163', NULL);
INSERT INTO `xiaoxituisonglog` VALUES (1766785319757905921, '合同编号:123审批结果为:通过.', 'yewuzhuguan', 'QeHing3', '已发送', 'info', NULL, '2024-03-10T19:17:00.185', NULL);

-- ----------------------------
-- Table structure for yibeihuoweifahuo
-- ----------------------------
DROP TABLE IF EXISTS `yibeihuoweifahuo`;
CREATE TABLE `yibeihuoweifahuo`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '收货人联系方式',
  `BeiHuoRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货人',
  `BeiHuoShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货时间',
  `BeiHuoZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备货状态',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '已备货未发货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yibeihuoweifahuo
-- ----------------------------
INSERT INTO `yibeihuoweifahuo` VALUES (1, '001', '居然之家咸阳购物广场', '咸阳市秦都区文林西路', '方柱扣', '80', '151149055', '李蓉蓉', '2013-12-14', '已备货', 'cmxadmin', '2023-12-14 17:31:57', NULL);

-- ----------------------------
-- Table structure for yonghuguanli
-- ----------------------------
DROP TABLE IF EXISTS `yonghuguanli`;
CREATE TABLE `yonghuguanli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `YongHuMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `JueSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `YongHuXingZhi` varchar(600) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户性质',
  `LianXiDianHua` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `ShouJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机',
  `XingMing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `YouXiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `DanWei` varchar(220) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '单位',
  `DiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地址',
  `YongHuZhuangTai` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户状态',
  `MiMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `ZhangHaoYouXiaoQi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '账号有效期',
  `ZhuCeShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '注册时间',
  `Leader` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '上级名字',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghuguanli
-- ----------------------------
INSERT INTO `yonghuguanli` VALUES (1, 'admin', '1', '所内', '123', '12399', '超级管理员', '123@qq.com', '', '北京市东城区东单三条五号', '审核通过', 'c30807e6587ade285ba7ade9f881b3d7', '2026-12-12', '2023-12-12', NULL, NULL, NULL, NULL);
INSERT INTO `yonghuguanli` VALUES (2, 'wangnan', '8', NULL, '1111', NULL, '王楠', '1212', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', 'cb4f3a43c8a976cd002ce822ad5c9d13', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 22:49:40', NULL);
INSERT INTO `yonghuguanli` VALUES (3, 'dushuai', '9', NULL, '1111', NULL, '杜帅', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', '92f21f1af6552e1e5e994b73b0199db3', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 22:53:43', NULL);
INSERT INTO `yonghuguanli` VALUES (4, 'liuwenchuang', '10', NULL, '1111', NULL, '刘文创', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', '3f214452232b765fe3c9c938685bd645', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 22:55:48', NULL);
INSERT INTO `yonghuguanli` VALUES (5, 'fanzong', '11', NULL, '1111', NULL, '樊总', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', '62e69a0028e7776f9fc4d22c56286b68', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 23:00:38', NULL);
INSERT INTO `yonghuguanli` VALUES (6, 'xuechao', '12', NULL, '1111', NULL, '薛超', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', 'd7c14553857b418397d0d504713bbe98', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 23:02:34', NULL);
INSERT INTO `yonghuguanli` VALUES (7, 'zhangshuai', '13', NULL, '1111', NULL, '张帅', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', 'e6950a217d774f491d3e786998223419', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 23:03:30', NULL);
INSERT INTO `yonghuguanli` VALUES (8, 'lirongrong', '14', NULL, '1111', NULL, '李蓉蓉', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', '826e172ed2f3104b54bb3e89dddc3bfc', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 23:04:28', NULL);
INSERT INTO `yonghuguanli` VALUES (9, 'wanghuan', '15', NULL, '1111', NULL, '王欢', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', '1e45f47fdea6017665fa87cb273bb9f6', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 23:05:55', NULL);
INSERT INTO `yonghuguanli` VALUES (10, 'yuanzong', '16', NULL, '1111', '123456789', '袁总', '', NULL, '陕西省渭南市临渭区双王街道菜鸟驿站', '审核通过', 'a20ce4bea5fbae01d4cb73afcca88602', '2026-12-12', '2023-12-12', NULL, 'cmxadmin', '2023-12-12 23:06:44', NULL);
INSERT INTO `yonghuguanli` VALUES (14, 'QeHing3', '8', NULL, NULL, '18275823007', NULL, NULL, NULL, NULL, 'yes', 'sxfkpTVIL5MZclRCN1U3@80c0d7cb0ba29deb431cc8ab8d9e8dff', NULL, 'Thu Mar 07 15:44:40 CST 2024', 'yewuzhuguan', NULL, 'Thu Mar 07 15:44:40 CST 2024', NULL);
INSERT INTO `yonghuguanli` VALUES (16, 'yewuzhuguan', '9', NULL, NULL, '15029795663', NULL, NULL, NULL, NULL, 'yes', 'Anb9Oc66CXnKJZTQlKeL@890ccb7ee4f7f32f81b4518694170aed', NULL, 'Sat Mar 09 14:40:59 CST 2024', 'QeHing3', NULL, 'Sat Mar 09 14:40:59 CST 2024', NULL);
INSERT INTO `yonghuguanli` VALUES (17, 'LiuWenChuang', '8', NULL, NULL, '17691281242', NULL, NULL, NULL, NULL, 'yes', '72cG5KZxLF5F7QQ1pYUb@ad426096abfb99ac222bf12fb9fc44f3', NULL, 'Sat Mar 09 22:11:26 CST 2024', 'yewuzhuguan', NULL, 'Sat Mar 09 22:11:26 CST 2024', NULL);

-- ----------------------------
-- Table structure for ziliao4zulinhetong
-- ----------------------------
DROP TABLE IF EXISTS `ziliao4zulinhetong`;
CREATE TABLE `ziliao4zulinhetong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '租赁合同的编号',
  `ZiLiaoMingCheng` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资料文件的名字',
  `ZiLiaoPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资料保存的路径',
  `UserName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '插入时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '租赁合同的资料表\r\n保存一份合同相关的图片和文档等.\r\n关联租赁合同表.' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ziliao4zulinhetong
-- ----------------------------
INSERT INTO `ziliao4zulinhetong` VALUES (34, '007', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/007/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (35, '007', '0307广东九为中粮粮谷渭南新建90万吨年小麦加工项目土建施工一标段.pdf', '/007/0307广东九为中粮粮谷渭南新建90万吨年小麦加工项目土建施工一标段.pdf', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (36, '007', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/007/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (37, '010', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/010/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (38, '010', '0307广东九为中粮粮谷渭南新建90万吨年小麦加工项目土建施工一标段.pdf', '/010/0307广东九为中粮粮谷渭南新建90万吨年小麦加工项目土建施工一标段.pdf', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (39, '010', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/010/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (40, '012', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/012/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (41, '012', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/012/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (42, '009', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/009/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (43, '009', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/009/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (44, '013', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/013/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (45, '013', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/013/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (46, '015', 'hetong2_3.png', '/015/hetong2_3.png', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (47, '015', '合同.jpg', '/015/合同.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (48, '015', 'hetong2_1.png', '/015/hetong2_1.png', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (49, '015', 'hetong2_2.png', '/015/hetong2_2.png', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (50, '015', '0229泾开学校.pdf', '/015/0229泾开学校.pdf', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (51, '016', 'file-1710059928159', '/016/file-1710059928159', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (52, '211', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/211/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (53, '211', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/211/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (54, '090', 'file-1710067916971', '/090/file-1710067916971', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (55, '090', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/090/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (56, '090', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/090/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (57, '091', 'bb783a98d4c7bebc508c4948d4e9550.jpg', '/091/bb783a98d4c7bebc508c4948d4e9550.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (58, '091', 'bcbc4c35b2368bee9bc965e293ae3e9.jpg', '/091/bcbc4c35b2368bee9bc965e293ae3e9.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (59, '658', '1710069104603_IMG20240309020852.jpg', '/658/1710069104603_IMG20240309020852.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (60, '658', '1710069104907_IMG20240309020901.jpg', '/658/1710069104907_IMG20240309020901.jpg', NULL, NULL, NULL);
INSERT INTO `ziliao4zulinhetong` VALUES (61, '123', '1710069381683_mmexport1709904131883.jpg', '/123/1710069381683_mmexport1709904131883.jpg', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for zlugang
-- ----------------------------
DROP TABLE IF EXISTS `zlugang`;
CREATE TABLE `zlugang`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'ZLU杠' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zlugang
-- ----------------------------
INSERT INTO `zlugang` VALUES (1, 'Z0.45-0.21-0.8', 'Z杠', '加固件', '否', '根', '', '1.46', '6.57', 'cmxadmin', '2023-12-13 12:42:14', NULL);

-- ----------------------------
-- Table structure for zulinhetong
-- ----------------------------
DROP TABLE IF EXISTS `zulinhetong`;
CREATE TABLE `zulinhetong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `ChuZuDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '出租单位',
  `ChengZuDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '承租单位',
  `ChengZuFangSheHuiXinXiDaiMa` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '承租方社会信息代码',
  `ChengZuFangKaiHuXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '承租方开户行',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `JieShouRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接收人',
  `JieShouRenLianXiFangShi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接收人联系方式',
  `HeTongLeiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同类型',
  `QiShiRiQi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '起始日期',
  `JieZhiRiQi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '截至日期',
  `WuLiaoYunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料运费',
  `HeTongTuPian` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '合同资料: 数量',
  `HeTongFuJiaXinXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同附加信息',
  `BeiZhuYuanYin` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注原因',
  `YeWuYuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `HeTongZhiXingJinDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '待审核' COMMENT '合同执行进度: 待审核, 审批中, 待备货, 待发货, 发货中, 租赁中, 退货中, 已完成. 已作废.',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租赁合同' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zulinhetong
-- ----------------------------
INSERT INTO `zulinhetong` VALUES (31, '008', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', NULL, NULL, '', 'QeHing3', '审核中', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (32, '007', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/007/bb783a98d4c7bebc508c4948d4e9550.jpg, /007/0307广东九为中粮粮谷渭南新建90万吨年小麦加工项目土建施工一标段.pdf, /007/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', NULL, '', 'QeHing3', '待备货', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (34, '012', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '1424324', '中国银行', '陕西省西安市XXXXX', '刘文创', '4324325334', '租赁', '2023-12-26', '2024-12-26', '', '[/012/bb783a98d4c7bebc508c4948d4e9550.jpg, /012/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', '', '', 'LiuWenChuang', '待审核', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (35, '009', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/009/bb783a98d4c7bebc508c4948d4e9550.jpg, /009/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', '', '', 'QeHing3', '审核中', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (36, '013', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/013/bb783a98d4c7bebc508c4948d4e9550.jpg, /013/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', '', '', 'QeHing3', '审核中', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (37, '015', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '123', '345', '陕西省西安市XXXXX', '123', '123', '租赁', '2023-12-26', '2024-12-26', '我方', '[/015/hetong2_3.png, /015/合同.jpg, /015/hetong2_1.png, /015/hetong2_2.png, /015/0229泾开学校.pdf]', '', '123', 'QeHing3', '审核中', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (38, '016', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/016/file-1710059928159]', '', '', 'QeHing3', '审核中', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (39, '211', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/211/bb783a98d4c7bebc508c4948d4e9550.jpg, /211/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', '', '', 'yewuzhuguan', '待审批', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (40, '090', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/090/file-1710067916971]', '', '', 'yewuzhuguan', '待审批', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (41, '090', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/090/file-1710067916971, /090/bb783a98d4c7bebc508c4948d4e9550.jpg, /090/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', '', '', 'yewuzhuguan', '待审批', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (42, '091', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/091/bb783a98d4c7bebc508c4948d4e9550.jpg, /091/bcbc4c35b2368bee9bc965e293ae3e9.jpg]', '', '', 'yewuzhuguan', '待审批', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (43, '658', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/658/1710069104603_IMG20240309020852.jpg, /658/1710069104907_IMG20240309020901.jpg]', '', '', 'QeHing3', '待审批', NULL, NULL, NULL);
INSERT INTO `zulinhetong` VALUES (44, '123', 'xxxxx项目', '安平建筑公司', '安平建筑公司', '', '', '陕西省西安市XXXXX', '', '', '租赁', '2023-12-26', '2024-12-26', '', '[/123/1710069381683_mmexport1709904131883.jpg]', '', '', 'QeHing3', '审核中', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for zulinhetongshenpi
-- ----------------------------
DROP TABLE IF EXISTS `zulinhetongshenpi`;
CREATE TABLE `zulinhetongshenpi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `ChuZuDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '出租单位',
  `ChengZuDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '承租单位',
  `ChengZuFangSheHui` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '承租方社会',
  `ChengZuFangKaiHu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '承租方开户',
  `XiangMuDiZhi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `JieShouRen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接收人',
  `JieShouRenLianXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '接收人联系',
  `HeTongLeiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同类型',
  `WuLiaoMingXi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料明细',
  `QiShiRiQi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '起始日期',
  `JieZhiRiQi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '截至日期',
  `FuKuanJieDian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '付款节点',
  `WuLiaoYunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料运费',
  `HeTongTuPian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同图片',
  `HeTongFuJiaXin` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同附加信',
  `WuLiaoDanJia` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料单价',
  `PeiChangDanJia` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '赔偿单价',
  `JiHuaZuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计划租量',
  `ZheKouLu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '折扣率',
  `BeiZhuYuanYin` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注原因',
  `YeWuYuan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `TongZhiXingJinDu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '同执行进度',
  `ShiFouTongGuoShenPi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否通过审批',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租赁合同审批' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zulinhetongshenpi
-- ----------------------------
INSERT INTO `zulinhetongshenpi` VALUES (1, '001', '居然之家咸阳购物广场', '陕西安平建筑科技有限公司', '陕西凯丰建设有限公司', '', '', '咸阳市秦都区文林西路', '李会民', '15114905564', '租赁', '方柱扣', '发货后一天', '退货到货当天', '', '承租方承担', '', '', '每天每套', '表格形式出现', '100', '', '', '王楠', '', '', 'cmxadmin', '2023-12-14 17:52:18', NULL);

-- ----------------------------
-- Table structure for zulinhetongwuliao
-- ----------------------------
DROP TABLE IF EXISTS `zulinhetongwuliao`;
CREATE TABLE `zulinhetongwuliao`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `GuiGemM` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '规格（mm）',
  `XingHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '型号',
  `JiLiangDanWei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `SunHuaiPeiChang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '损坏赔偿',
  `DiuShiPeiChang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '丢失赔偿',
  `WuLiaoDanJia` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料单价',
  `BeiZhu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租赁合同物料' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zulinhetongwuliao
-- ----------------------------
INSERT INTO `zulinhetongwuliao` VALUES (1, '002', '钢柱箍', '500-800', '8#', '套', NULL, NULL, '0.32', '', 'cmxadmin', '2023-12-14 18:47:36', NULL);
INSERT INTO `zulinhetongwuliao` VALUES (2, '002', '钢柱箍', '700-1000', '8#', '套', NULL, NULL, '0.44', '', 'cmxadmin', '2023-12-14 18:48:10', NULL);
INSERT INTO `zulinhetongwuliao` VALUES (3, '002', '钢柱箍', '900-1200', '10#', '套', NULL, NULL, '0.55', '', 'cmxadmin', '2023-12-14 18:48:41', NULL);
INSERT INTO `zulinhetongwuliao` VALUES (4, '002', '梁夹具', '200-400', '', '套', NULL, NULL, '0.25', '', 'cmxadmin', '2023-12-14 18:49:19', NULL);
INSERT INTO `zulinhetongwuliao` VALUES (5, '001', '方柱扣', '700-1000 10#', '', '套', NULL, NULL, '0.45', '', 'cmxadmin', '2023-12-14 18:49:58', NULL);

-- ----------------------------
-- Table structure for zulinjiesuan
-- ----------------------------
DROP TABLE IF EXISTS `zulinjiesuan`;
CREATE TABLE `zulinjiesuan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料数量',
  `WuLiaoRiZuJin` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料日租金',
  `QiZuShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '起租时间',
  `ZongJiYunFei` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总计运费',
  `TuiHuiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '退回时间',
  `WeiSunHuaiJiaQian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '未损坏价钱',
  `WuLiaoSunHuaiQing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料损坏情',
  `PeiChangJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '赔偿价格',
  `ZongJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总计',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租赁结算' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zulinjiesuan
-- ----------------------------
INSERT INTO `zulinjiesuan` VALUES (1, '002', '方柱扣', '60', '0.45', '2023-12-16', '200', '2023-12-30', '578', '丢1损2', '1000', '1578', 'cmxadmin', '2023-12-14 17:43:33', NULL);

-- ----------------------------
-- Table structure for zulinqingsuan
-- ----------------------------
DROP TABLE IF EXISTS `zulinqingsuan`;
CREATE TABLE `zulinqingsuan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `WuLiaoMingCheng` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料名称',
  `WuLiaoShuLiang` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料数量',
  `WuLiaoRiZuJin` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料日租金',
  `QiZuShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '起租时间',
  `TuiHuiShiJian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '退回时间',
  `WeiSunHuaiJiaQian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '未损坏价钱',
  `WuLiaoSunHuaiQing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '物料损坏情',
  `ZheKouLu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '折扣率',
  `PeiChangJiaGe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '赔偿价格',
  `ZongJi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '总计',
  `ZuiZhongQingSuanJiaQian` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '最终清算价钱',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '租赁清算' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zulinqingsuan
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
