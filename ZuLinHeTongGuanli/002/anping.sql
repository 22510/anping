-- MySQL dump 10.13  Distrib 8.2.0, for Win64 (x86_64)
--
-- Host: localhost    Database: anping
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chaxiao`
--

DROP TABLE IF EXISTS `chaxiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chaxiao` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='插销';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chaxiao`
--

LOCK TABLES `chaxiao` WRITE;
/*!40000 ALTER TABLE `chaxiao` DISABLE KEYS */;
/*!40000 ALTER TABLE `chaxiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daishoutuihuo`
--

DROP TABLE IF EXISTS `daishoutuihuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daishoutuihuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `YeWuYuan` varchar(100) DEFAULT NULL COMMENT '业务员',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='待收退货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daishoutuihuo`
--

LOCK TABLES `daishoutuihuo` WRITE;
/*!40000 ALTER TABLE `daishoutuihuo` DISABLE KEYS */;
INSERT INTO `daishoutuihuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','70','王楠','cmxadmin','2023-12-14 17:34:05',NULL);
/*!40000 ALTER TABLE `daishoutuihuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fahuoxinxichaxun`
--

DROP TABLE IF EXISTS `fahuoxinxichaxun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fahuoxinxichaxun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `WeiFaJianShu` varchar(100) DEFAULT NULL COMMENT '未发件数',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='发货信息查询';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fahuoxinxichaxun`
--

LOCK TABLES `fahuoxinxichaxun` WRITE;
/*!40000 ALTER TABLE `fahuoxinxichaxun` DISABLE KEYS */;
INSERT INTO `fahuoxinxichaxun` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','20','李会民','1511111111','王楠','2023-12-14','cmxadmin','2023-12-14 17:53:15',NULL);
/*!40000 ALTER TABLE `fahuoxinxichaxun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangguan`
--

DROP TABLE IF EXISTS `fangguan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fangguan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='方管';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangguan`
--

LOCK TABLES `fangguan` WRITE;
/*!40000 ALTER TABLE `fangguan` DISABLE KEYS */;
INSERT INTO `fangguan` VALUES (1,'1212','12121','2222','','','','','','cmxadmin','2023-12-12 20:49:36',NULL);
/*!40000 ALTER TABLE `fangguan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fangzhukou`
--

DROP TABLE IF EXISTS `fangzhukou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fangzhukou` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='方柱扣';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fangzhukou`
--

LOCK TABLES `fangzhukou` WRITE;
/*!40000 ALTER TABLE `fangzhukou` DISABLE KEYS */;
/*!40000 ALTER TABLE `fangzhukou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faqizulinfahuo`
--

DROP TABLE IF EXISTS `faqizulinfahuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faqizulinfahuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `WeiFaJianShu` varchar(100) DEFAULT NULL COMMENT '未发件数',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='发起租赁发货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faqizulinfahuo`
--

LOCK TABLES `faqizulinfahuo` WRITE;
/*!40000 ALTER TABLE `faqizulinfahuo` DISABLE KEYS */;
INSERT INTO `faqizulinfahuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','20','李会民','151149055','王楠','2023-12-14','cmxadmin','2023-12-14 17:20:42',NULL),(2,'002','中国青少年空天科普研学基地','陕西欧亚','钢柱箍','90','10','马姗姗','19391639827','王楠','2023-12-13','cmxadmin','2023-12-14 17:22:43',NULL);
/*!40000 ALTER TABLE `faqizulinfahuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faqizulintuihuo`
--

DROP TABLE IF EXISTS `faqizulintuihuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faqizulintuihuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `WeiShouTuiHuoJianShu` varchar(100) DEFAULT NULL COMMENT '未收退货件数',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='发起租赁退货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faqizulintuihuo`
--

LOCK TABLES `faqizulintuihuo` WRITE;
/*!40000 ALTER TABLE `faqizulintuihuo` DISABLE KEYS */;
INSERT INTO `faqizulintuihuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','60','20','李蓉蓉','15123412345','王楠','2023-12-30','cmxadmin','2023-12-14 17:27:22',NULL);
/*!40000 ALTER TABLE `faqizulintuihuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fukuanjiedian`
--

DROP TABLE IF EXISTS `fukuanjiedian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fukuanjiedian` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `FuKuanShiJian` varchar(100) DEFAULT NULL COMMENT '付款时间',
  `FuKuanLeiXing` varchar(100) DEFAULT NULL COMMENT '付款类型',
  `BeiZhu` varchar(100) DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='付款节点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fukuanjiedian`
--

LOCK TABLES `fukuanjiedian` WRITE;
/*!40000 ALTER TABLE `fukuanjiedian` DISABLE KEYS */;
INSERT INTO `fukuanjiedian` VALUES (1,'001','2023-12-26T16:00:00.000Z','预付款',NULL,'cmxadmin','2023-12-26 10:46:49',NULL),(4,'002','2023-12-27T16:00:00.000Z','预付款',NULL,'cmxadmin','2023-12-26 10:49:13',NULL);
/*!40000 ALTER TABLE `fukuanjiedian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gangbeileng`
--

DROP TABLE IF EXISTS `gangbeileng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gangbeileng` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='钢背楞';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gangbeileng`
--

LOCK TABLES `gangbeileng` WRITE;
/*!40000 ALTER TABLE `gangbeileng` DISABLE KEYS */;
/*!40000 ALTER TABLE `gangbeileng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gongjulan`
--

DROP TABLE IF EXISTS `gongjulan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gongjulan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `anjianmingcheng` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `MingCheng` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '名称',
  `FuID` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '父ID',
  `ShiFouDaKaiChuangKou` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '是否打开窗口',
  `TuBiao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '图标',
  `QianJingYanSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '前景颜色',
  `BeiJingYanSe` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '背影颜色',
  `ShiFouXuanZeYiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '是否选择一行',
  `ZhiXingCaoZuo` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '执行操作',
  `ZuJianLeiXing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '组件类型',
  `BeiZhu` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '备注',
  `ShuoMing` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '说明',
  `UserName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COMMENT='工具栏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gongjulan`
--

LOCK TABLES `gongjulan` WRITE;
/*!40000 ALTER TABLE `gongjulan` DISABLE KEYS */;
INSERT INTO `gongjulan` VALUES (1,'查询','查询','1','是','home','red','blue',NULL,'/api/busi','nzform','查询','',NULL,NULL,NULL),(2,'添加','添加','1','是','home','#ff00aa','red',NULL,'/cmxcore/add','nzform','添加一条记录','',NULL,NULL,NULL),(3,'新增案例','新增案例','1','是','home','#ff00aa','red',NULL,'/cmxcore/add',NULL,'添加一条记录','',NULL,NULL,NULL),(4,'新增措施前案例','新增措施前案例','1','是','home','#ff00aa','red',NULL,'/cmxcore/add',NULL,'添加一条记录','',NULL,NULL,NULL),(5,'新增措施后案例','新增措施后案例','1','是','home','#ff00aa','red',NULL,'/cmxcore/add',NULL,'添加一条记录','',NULL,NULL,NULL),(6,'删除','删除','1','否','delete','green','blue','是','/cmxcore/delete/{id}',NULL,'确认要删除吗?','',NULL,NULL,NULL),(7,'修改','修改','1','是','wallet','blue','yellow','是','/cmxcore/update/{id}','nzform','更新一行记录','',NULL,NULL,NULL),(8,'导出Excel','导出Excel','1','否','profile','green','green',NULL,'/api/busi/exportexcel',NULL,'导出Excel','',NULL,NULL,NULL),(9,'导入Excel','导入Excel','1','文件上传','project','#ff00aa','blue',NULL,'/api/busi/importexcel',NULL,'导入Excel','',NULL,NULL,NULL),(10,'追加Excel','导入Excel','1','文件上传','schedule','red','red',NULL,'/api/busi/addexcel',NULL,'导入Excel','',NULL,NULL,NULL),(11,'报送数据','报送数据','1','否','baosong.png',NULL,NULL,NULL,'/cmxcore/uploadData',NULL,'报送数据','',NULL,NULL,NULL),(12,'生成邮件','生成邮件','1','否','add.png',NULL,NULL,NULL,'/cmxcore/getfujian',NULL,'将以下内容生成附件','  ',NULL,NULL,NULL),(13,'邮件预览','邮件预览','1','是','preview.png',NULL,NULL,NULL,'/cmxcore/emailPreview/{id}',NULL,'预览邮件内容','11',NULL,NULL,NULL),(14,'批量更新','批量更新','1','是','update.png',NULL,NULL,NULL,'/cmxcore/updatePl',NULL,'更新多行记录','',NULL,NULL,NULL),(15,'发邮件','发邮件','1','是','page_white_freehand.png',NULL,NULL,NULL,'/cmxcore/sendEmail',NULL,'邮件发送','',NULL,NULL,NULL),(16,'导出TXT','导出TXT','1','否','page_white_freehand.png',NULL,NULL,NULL,'/btn/exporttxt',NULL,'导出TXT','',NULL,NULL,NULL),(17,'措施推荐','措施推荐','1','是','wallet','blue','yellow',NULL,'/cmxcore/update/{id}',NULL,'效果评价一行记录','',NULL,NULL,NULL),(18,'措施评价','措施评价','1','是','wallet','blue','yellow',NULL,'/cmxcore/update/{id}',NULL,'效果评价一行记录','',NULL,NULL,NULL),(19,'再次购买','再次购买','1','是','update.png',NULL,NULL,'是','/cmxcore/buyagain/{id}',NULL,'确定要再次购买吗？',' ',NULL,NULL,NULL),(20,'全部','全部','0','','',NULL,NULL,NULL,'',NULL,'','1',NULL,NULL,NULL);
/*!40000 ALTER TABLE `gongjulan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gouziluomuxiaopian`
--

DROP TABLE IF EXISTS `gouziluomuxiaopian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gouziluomuxiaopian` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='钩子螺母销片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gouziluomuxiaopian`
--

LOCK TABLES `gouziluomuxiaopian` WRITE;
/*!40000 ALTER TABLE `gouziluomuxiaopian` DISABLE KEYS */;
/*!40000 ALTER TABLE `gouziluomuxiaopian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hetongyingshoukuanhuizong`
--

DROP TABLE IF EXISTS `hetongyingshoukuanhuizong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hetongyingshoukuanhuizong` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `HeTongJieSuanZongJi` varchar(100) DEFAULT NULL COMMENT '合同结算总计',
  `HeTongQingSuanZongJi` varchar(100) DEFAULT NULL COMMENT '合同清算总计',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='合同应收款汇总';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hetongyingshoukuanhuizong`
--

LOCK TABLES `hetongyingshoukuanhuizong` WRITE;
/*!40000 ALTER TABLE `hetongyingshoukuanhuizong` DISABLE KEYS */;
INSERT INTO `hetongyingshoukuanhuizong` VALUES (1,'001','1578','','cmxadmin','2023-12-13 11:32:45','2023-12-14 17:44:05');
/*!40000 ALTER TABLE `hetongyingshoukuanhuizong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiaohengliangwaitao`
--

DROP TABLE IF EXISTS `jiaohengliangwaitao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jiaohengliangwaitao` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角横梁外套';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiaohengliangwaitao`
--

LOCK TABLES `jiaohengliangwaitao` WRITE;
/*!40000 ALTER TABLE `jiaohengliangwaitao` DISABLE KEYS */;
/*!40000 ALTER TABLE `jiaohengliangwaitao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jueseguanli`
--

DROP TABLE IF EXISTS `jueseguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jueseguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `JueSe` varchar(88) DEFAULT NULL COMMENT '角色',
  `ZhongYaoXing` varchar(88) DEFAULT NULL COMMENT '重要性',
  `BeiZhu` varchar(88) DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='角色管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jueseguanli`
--

LOCK TABLES `jueseguanli` WRITE;
/*!40000 ALTER TABLE `jueseguanli` DISABLE KEYS */;
INSERT INTO `jueseguanli` VALUES (1,'系统管理员','1','',NULL,NULL,NULL),(8,'业务员','','','cmxadmin','2023-12-12 22:36:41',NULL),(9,'业务经理','','','cmxadmin','2023-12-12 22:36:53',NULL),(10,'财务人员','','','cmxadmin','2023-12-12 22:37:03',NULL),(11,'财务经理','','','cmxadmin','2023-12-12 22:37:12',NULL),(12,'结算','','','cmxadmin','2023-12-12 22:37:22',NULL),(13,'结算经理','','','cmxadmin','2023-12-12 22:37:31',NULL),(14,'收发部门','','','cmxadmin','2023-12-12 22:37:57',NULL),(15,'收发管理','','','cmxadmin','2023-12-12 22:38:11',NULL),(16,'公司高管','','','cmxadmin','2023-12-12 22:38:25',NULL);
/*!40000 ALTER TABLE `jueseguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kehuguanli`
--

DROP TABLE IF EXISTS `kehuguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kehuguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `KeHuMingCheng` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `KeHuJianCheng` varchar(100) DEFAULT NULL COMMENT '客户简称',
  `ShuiHao` varchar(100) DEFAULT NULL COMMENT '税号',
  `DanWeiDiZhi` varchar(100) DEFAULT NULL COMMENT '单位地址',
  `DianHua` varchar(100) DEFAULT NULL COMMENT '电话',
  `KaiHuXing` varchar(100) DEFAULT NULL COMMENT '开户行',
  `YinHangZhangHu` varchar(100) DEFAULT NULL COMMENT '银行账户',
  `LianXiRen` varchar(100) DEFAULT NULL COMMENT '联系人',
  `LianXiDianHua` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `CaiWuRenYuan` varchar(100) DEFAULT NULL COMMENT '财务人员',
  `CaiWuGuDingDianHua` varchar(100) DEFAULT NULL COMMENT '财务固定电话',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='客户管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kehuguanli`
--

LOCK TABLES `kehuguanli` WRITE;
/*!40000 ALTER TABLE `kehuguanli` DISABLE KEYS */;
/*!40000 ALTER TABLE `kehuguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangbeihuo`
--

DROP TABLE IF EXISTS `kufangbeihuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangbeihuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `WuLiaoShuLiang` varchar(100) DEFAULT NULL COMMENT '物料数量',
  `ZhiXingRen` varchar(100) DEFAULT NULL COMMENT '执行人',
  `ShiYongShiJian` varchar(100) DEFAULT NULL COMMENT '使用时间',
  `BeiHuoShuoMing` varchar(100) DEFAULT NULL COMMENT '备货说明',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='库房备货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangbeihuo`
--

LOCK TABLES `kufangbeihuo` WRITE;
/*!40000 ALTER TABLE `kufangbeihuo` DISABLE KEYS */;
/*!40000 ALTER TABLE `kufangbeihuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangbeihuochaxun`
--

DROP TABLE IF EXISTS `kufangbeihuochaxun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangbeihuochaxun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `WuLiaoShuLiang` varchar(100) DEFAULT NULL COMMENT '物料数量',
  `BeiHuoZhuangTai` varchar(100) DEFAULT NULL COMMENT '备货状态',
  `ZhiXingRen` varchar(100) DEFAULT NULL COMMENT '执行人',
  `ShiYongShiJian` varchar(100) DEFAULT NULL COMMENT '使用时间',
  `BeiHuoShuoMing` varchar(100) DEFAULT NULL COMMENT '备货说明',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房备货查询';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangbeihuochaxun`
--

LOCK TABLES `kufangbeihuochaxun` WRITE;
/*!40000 ALTER TABLE `kufangbeihuochaxun` DISABLE KEYS */;
INSERT INTO `kufangbeihuochaxun` VALUES (1,'001','Z0.45-0.21-0.8','Z杠','加固件','根','100','正在备货','李蓉蓉','2023-12-13','正常备货','cmxadmin','2023-12-13 11:20:32',NULL);
/*!40000 ALTER TABLE `kufangbeihuochaxun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangbeihuolishishujuchaxun`
--

DROP TABLE IF EXISTS `kufangbeihuolishishujuchaxun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangbeihuolishishujuchaxun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `BeiHuoRen` varchar(100) DEFAULT NULL COMMENT '备货人',
  `BeiHuoShiJian` varchar(100) DEFAULT NULL COMMENT '备货时间',
  `BeiHuoZhuangTai` varchar(100) DEFAULT NULL COMMENT '备货状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房备货历史数据查询';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangbeihuolishishujuchaxun`
--

LOCK TABLES `kufangbeihuolishishujuchaxun` WRITE;
/*!40000 ALTER TABLE `kufangbeihuolishishujuchaxun` DISABLE KEYS */;
INSERT INTO `kufangbeihuolishishujuchaxun` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','李会民','李蓉蓉','2023-12-14','待发出','cmxadmin','2023-12-14 17:56:42',NULL);
/*!40000 ALTER TABLE `kufangbeihuolishishujuchaxun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangdaibeihuo`
--

DROP TABLE IF EXISTS `kufangdaibeihuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangdaibeihuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `BeiHuoRen` varchar(100) DEFAULT NULL COMMENT '备货人',
  `BeiHuoShiJian` varchar(100) DEFAULT NULL COMMENT '备货时间',
  `BeiHuoZhuangTai` varchar(100) DEFAULT NULL COMMENT '备货状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房待备货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangdaibeihuo`
--

LOCK TABLES `kufangdaibeihuo` WRITE;
/*!40000 ALTER TABLE `kufangdaibeihuo` DISABLE KEYS */;
INSERT INTO `kufangdaibeihuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','李会民','李蓉蓉','2023-12-14','正在备货','cmxadmin','2023-12-14 17:30:53',NULL);
/*!40000 ALTER TABLE `kufangdaibeihuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangfahuo`
--

DROP TABLE IF EXISTS `kufangfahuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangfahuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `FaHuoRen` varchar(100) DEFAULT NULL COMMENT '发货人',
  `FaHuoShiJian` varchar(100) DEFAULT NULL COMMENT '发货时间',
  `JiaShiRen` varchar(100) DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房发货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangfahuo`
--

LOCK TABLES `kufangfahuo` WRITE;
/*!40000 ALTER TABLE `kufangfahuo` DISABLE KEYS */;
INSERT INTO `kufangfahuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','15114905','李蓉蓉','2023-12-15','张三','陕A66908','承租单位','是','200','在途','cmxadmin','2023-12-14 17:33:29',NULL);
/*!40000 ALTER TABLE `kufangfahuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangfahuochaxun`
--

DROP TABLE IF EXISTS `kufangfahuochaxun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangfahuochaxun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `FaHuoRen` varchar(100) DEFAULT NULL COMMENT '发货人',
  `FaHuoShiJian` varchar(100) DEFAULT NULL COMMENT '发货时间',
  `JiaShiRen` varchar(100) DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房发货查询';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangfahuochaxun`
--

LOCK TABLES `kufangfahuochaxun` WRITE;
/*!40000 ALTER TABLE `kufangfahuochaxun` DISABLE KEYS */;
INSERT INTO `kufangfahuochaxun` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','李会民','李蓉蓉','2023-12-15','张三','陕A66908','承租单位','是','200','在途','cmxadmin','2023-12-14 17:57:59',NULL);
/*!40000 ALTER TABLE `kufangfahuochaxun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangfahuofangshiguanli`
--

DROP TABLE IF EXISTS `kufangfahuofangshiguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangfahuofangshiguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `FaHuoDingDanHao` varchar(100) DEFAULT NULL COMMENT '发货订单号',
  `ZongDanHao` varchar(100) DEFAULT NULL COMMENT '总单号',
  `FenDanHao` varchar(100) DEFAULT NULL COMMENT '分单号',
  `PeiSongFangShi` varchar(100) DEFAULT NULL COMMENT '配送方式',
  `PeiSongCheLiang` varchar(100) DEFAULT NULL COMMENT '配送车辆',
  `PeiSongSiJi` varchar(100) DEFAULT NULL COMMENT '配送司机',
  `SiJiDianHua` varchar(100) DEFAULT NULL COMMENT '司机电话',
  `JianKongRen` varchar(100) DEFAULT NULL COMMENT '监控人',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房发货方式管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangfahuofangshiguanli`
--

LOCK TABLES `kufangfahuofangshiguanli` WRITE;
/*!40000 ALTER TABLE `kufangfahuofangshiguanli` DISABLE KEYS */;
INSERT INTO `kufangfahuofangshiguanli` VALUES (1,'0001','0001','0001','货啦啦','陕A8889','李四','15064357890','王五','cmxadmin','2023-12-13 11:23:02',NULL);
/*!40000 ALTER TABLE `kufangfahuofangshiguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangshoudaotuihuo`
--

DROP TABLE IF EXISTS `kufangshoudaotuihuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangshoudaotuihuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `DiuShiMingXi` varchar(100) DEFAULT NULL COMMENT '丢失明细',
  `SunHuaiMingXi` varchar(100) DEFAULT NULL COMMENT '损坏明细',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `ShouHuoShiJian` varchar(100) DEFAULT NULL COMMENT '收货时间',
  `JiaShiRen` varchar(100) DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房收到退货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangshoudaotuihuo`
--

LOCK TABLES `kufangshoudaotuihuo` WRITE;
/*!40000 ALTER TABLE `kufangshoudaotuihuo` DISABLE KEYS */;
INSERT INTO `kufangshoudaotuihuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','60','1','2','李蓉蓉','12378947289','2023-12-30','张三','陕A68975','承担方','否','','已入库','cmxadmin','2023-12-14 17:38:24',NULL);
/*!40000 ALTER TABLE `kufangshoudaotuihuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kufangtuihuoxinxichaxun`
--

DROP TABLE IF EXISTS `kufangtuihuoxinxichaxun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kufangtuihuoxinxichaxun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `YunFei` varchar(100) DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) DEFAULT NULL COMMENT '垫付价格',
  `CheLiangXinXi` varchar(100) DEFAULT NULL COMMENT '车辆信息',
  `JiaShiRen` varchar(100) DEFAULT NULL COMMENT '驾驶人',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXi` varchar(100) DEFAULT NULL COMMENT '收货人联系',
  `ShouHuoShiJian` varchar(100) DEFAULT NULL COMMENT '收货时间',
  `SunHuaiMingXi` varchar(100) DEFAULT NULL COMMENT '损坏明细',
  `DiuShiMingXi` varchar(100) DEFAULT NULL COMMENT '丢失明细',
  `HuoWuZhuangTai` varchar(100) DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='库房退货信息查询';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kufangtuihuoxinxichaxun`
--

LOCK TABLES `kufangtuihuoxinxichaxun` WRITE;
/*!40000 ALTER TABLE `kufangtuihuoxinxichaxun` DISABLE KEYS */;
INSERT INTO `kufangtuihuoxinxichaxun` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','60','承租方','否','','陕A12121','张三','李蓉蓉','12121212121','2023-12-30','2','1','已入库','cmxadmin','2023-12-14 18:00:16',NULL);
/*!40000 ALTER TABLE `kufangtuihuoxinxichaxun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liangqiaju`
--

DROP TABLE IF EXISTS `liangqiaju`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `liangqiaju` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='梁卡具';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liangqiaju`
--

LOCK TABLES `liangqiaju` WRITE;
/*!40000 ALTER TABLE `liangqiaju` DISABLE KEYS */;
/*!40000 ALTER TABLE `liangqiaju` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mokuaifenpei`
--

DROP TABLE IF EXISTS `mokuaifenpei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mokuaifenpei` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `JueSe` varchar(80) DEFAULT NULL COMMENT '角色',
  `GongNengLieBiao` varchar(200) DEFAULT NULL COMMENT '功能列表',
  `MoKuaiMing` varchar(12000) DEFAULT NULL COMMENT '模块名',
  `BeiZhu` varchar(100) DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3 COMMENT='模块分配';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mokuaifenpei`
--

LOCK TABLES `mokuaifenpei` WRITE;
/*!40000 ALTER TABLE `mokuaifenpei` DISABLE KEYS */;
INSERT INTO `mokuaifenpei` VALUES (1,'1','添加,删除,修改','用户管理','',NULL,NULL,NULL),(2,'1','添加,删除,修改','模块分配','',NULL,NULL,NULL),(3,'1','添加,修改,删除,导出Excel','角色管理','',NULL,NULL,NULL),(4,'8','添加,修改,删除,导出Excel','发起租赁发货,租赁合同',NULL,NULL,NULL,NULL),(5,'8','添加,修改,删除','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同',NULL,NULL,NULL,NULL),(6,'8','添加,修改,删除','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同',NULL,NULL,NULL,NULL),(7,'10','添加,修改,删除','租赁合同,租赁结算,租赁清算,销售合同,销售订单交付',NULL,NULL,NULL,NULL),(8,'12','添加,修改,删除','租赁合同,库房发货,库房收到退货,租赁结算,租赁清算,',NULL,NULL,NULL,NULL),(9,'14','添加,修改,删除','库房备货,库房发货,库房发货查询,退货员清点货物,库房收到退货',NULL,NULL,NULL,NULL),(10,'15','添加,修改,删除,导出Excel','库房备货,库房发货,库房发货查询,库房备货查询,库房发货方式管理,,退货员清点货物,库房收到退货,退货信息查询,物流公司管理',NULL,NULL,NULL,NULL),(11,'8','添加,修改,删除','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同',NULL,NULL,NULL,NULL),(12,'8','添加,修改,删除','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同',NULL,NULL,NULL,NULL),(13,'9','添加,修改,删除,导出Excel','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,租赁合同审批',NULL,NULL,NULL,NULL),(14,'10','添加,修改,删除','租赁合同,租赁结算,租赁清算,销售合同,销售订单交付',NULL,NULL,NULL,NULL),(15,'11','添加,修改,删除,导出Excel','租赁合同,租赁结算,租赁清算,合同应收款汇总,销售合同,销售订单交付,销售业绩汇总,,合同应收款一览,销售应收款一览,',NULL,NULL,NULL,NULL),(16,'12','添加,修改,删除','租赁合同,库房发货,库房收到退货,租赁结算,租赁清算',NULL,NULL,NULL,NULL),(17,'13','添加,修改,删除,导出Excel','租赁合同,库房发货,库房收到退货,租赁结算,租赁清算,合同应收款汇总',NULL,NULL,NULL,NULL),(18,'14','添加,修改,删除','库房备货,库房发货,库房发货查询,退货员清点货物,库房收到退货',NULL,NULL,NULL,NULL),(19,'15','添加,修改,删除,导出Excel','库房备货,库房发货,库房发货查询,库房备货查询,库房发货方式管理,,退货员清点货物,库房收到退货,退货信息查询,物流公司管理',NULL,NULL,NULL,NULL),(20,'16','添加,修改,删除,导出Excel','人员管理,,物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,,客户管理,物流公司管理,,租赁合同,租赁合同审批,发起租赁发货,发货信息查询,库房备货,库房备货查询,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,租赁结算,租赁清算,合同应收款汇总,合同应收款一览,销售应收款一览',NULL,NULL,NULL,NULL),(21,'8','添加,修改,删除','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,发货信息查询,库房备货查询,库房发货查询,租赁合同物料,租赁结算,租赁清算,退货员清点货物,库房收到退货,退货信息查询',NULL,NULL,NULL,NULL),(22,'9','添加,修改,删除','物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,发货信息查询,库房备货查询,库房发货查询,租赁合同物料,租赁结算,租赁清算,退货员清点货物,库房收到退货,退货信息查询,租赁合同审批',NULL,NULL,NULL,NULL),(23,'11','添加,修改,删除,导出Excel','租赁合同,租赁结算,租赁清算,合同应收款汇总,销售合同,销售订单交付,销售业绩汇总,合同应收款一览,销售应收款一览',NULL,NULL,NULL,NULL),(24,'12','添加,修改,删除','租赁合同,库房发货,库房收到退货,租赁结算,租赁清算',NULL,NULL,NULL,NULL),(25,'13','添加,修改,删除,导出Excel','租赁合同,库房发货,库房收到退货,租赁结算,租赁清算,合同应收款汇总',NULL,NULL,NULL,NULL),(26,'14','添加,修改,删除','库房备货,库房发货,库房待备货,库房备货查询,库房待备货,库房备货查询,库房发货查询,退货员清点货物,库房收到退货',NULL,NULL,NULL,NULL),(27,'15','添加,修改,删除,导出Excel','库房备货,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,库房发货,库房发货查询,库房备货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,物流公司管理',NULL,NULL,NULL,NULL),(28,'16','添加,修改,删除,导出Excel','人员管理,物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,客户管理,物流公司管理,钢背楞,梁卡具,锁具,角横梁外套,客户管理,物流公司管理,租赁合同,租赁合同审批,发起租赁发货,发货信息查询,库房备货,库房备货查询,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,租赁结算,租赁清算,合同应收款汇总,合同应收款一览,销售应收款一览,租赁合同,租赁合同物料,租赁合同审批,发起租赁发货,发货信息查询,库房待备货,库房备货查询,库房发货,库房发货查询,库房发货方式管理,退货员清点货物,库房收到退货,退货信息查询,租赁结算,租赁清算,合同应收款汇总,销售合同,销售合同审批,销售发起发货,销售发货信息查询,销售库房备货,销售库房发货,销售库房发货方式管理,销售库房收到退货,销售库房退货查询,销售订单交付,销售业绩汇总',NULL,NULL,NULL,NULL),(29,'10','添加,修改,删除','租赁合同,租赁合同物料,租赁结算,租赁清算,合同应收款一览,销售应收款一览',NULL,NULL,NULL,NULL),(30,'8','添加,修改,删除',',物料汇总,物料库存一览图,租赁合同,租赁合同物料,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房备货历史数据查询,库房发货查询,库房退货信息查询,销售合同,销售合同物料,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房备货历史查询,销售库房发货查询,销售库房退货查询,转租合同,转租合同物料,转租业务员发起收货信息查询,转租业务员发起退回信息查询,转租物料入库历史查询,转租退回物料历史查询\n',NULL,NULL,NULL,NULL),(31,'9','添加,修改,删除',',物料汇总,物料库存一览图,租赁合同,租赁合同物料,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房备货历史数据查询,库房发货查询,库房退货信息查询,销售合同,销售合同物料,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房备货历史查询,销售库房发货查询,销售库房退货查询,转租合同,转租合同物料,转租业务员发起收货信息查询,转租业务员发起退回信息查询,转租物料入库历史查询,转租退回物料历史查询,租赁合同审批,销售合同审批,转租合同审批\n',NULL,NULL,NULL,NULL),(32,'10','添加,修改,删除','租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款\n',NULL,NULL,NULL,NULL),(33,'11','添加,修改,删除','租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款,合同应收款一览,销售应收款一览,转租应付款一览',NULL,NULL,NULL,NULL),(34,'12','添加,修改,删除','租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款',NULL,NULL,NULL,NULL),(35,'13','添加,修改,删除','租赁合同,库房发货查询,库房退货信息查询,租赁结算,租赁清算,销售合同,销售库房发货查询,销售库房退货查询,销售订单交付,转租合同,转租物料入库历史查询,转租退回物料历史查询,转租付款,合同应收款汇总,销售业绩汇总,转租盈利一览',NULL,NULL,NULL,NULL),(36,'14','添加,修改,删除','\n库房待备货,已备货未发货,库房备货历史数据查询,库房发货,库房发货查询,待收退货,退货员清点货物,库房收到退货,库房退货信息查询,销售库房待备货,销售库房已备货未发货,销售库房备货历史查询,销售库房发货,销售库房发货查询,销售库房待收退货,销售库房收到退货,销售库房退货查询,转租物料已发货待入库,转租入库,转租物料入库历史查询,转租退回物料待备货,转租退回物料,转租退回物料历史查询',NULL,NULL,NULL,NULL),(37,'15','添加,修改,删除','\n库房待备货,已备货未发货,库房备货历史数据查询,库房发货,库房发货查询,待收退货,退货员清点货物,库房收到退货,库房退货信息查询,销售库房待备货,销售库房已备货未发货,销售库房备货历史查询,销售库房发货,销售库房发货查询,销售库房待收退货,销售库房收到退货,销售库房退货查询,转租物料已发货待入库,转租入库,转租物料入库历史查询,转租退回物料待备货,转租退回物料,转租退回物料历史查询,物流公司管理,库房发货方式管理',NULL,NULL,NULL,NULL),(38,'16','添加,修改,删除','人员管理,物料汇总,物料库存一览图,客户管理,物流公司管理,库房发货方式管理,租赁合同,租赁合同物料,租赁合同审批,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房待备货,已备货未发货,库房备货历史数据查询,库房发货,库房发货查询,待收退货,退货员清点货物,库房收到退货,库房退货信息查询,租赁结算,租赁清算,合同应收款汇总,销售合同,销售合同物料,销售合同审批,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房待备货,销售库房已备货未发货,销售库房备货历史查询,\n销售库房发货,销售库房发货查询,销售库房待收退货,销售库房收到退货,销售库房退货查询,销售订单交付,销售业绩汇总,转租合同,转租合同物料,转租合同审批,转租业务员发起收货,转租业务员发起收货信息查询,转租业务员发起退回,转租业务员发起退回信息查询,转租物料已发货待入库,转租入库,转租物料入库历史查询,转租退回物料待备货,转租退回物料,转租退回物料历史查询,转租付款,转租盈利一览,合同应收款一览,销售应收款一览,转租应付款一览',NULL,NULL,NULL,NULL),(39,'8','添加,修改,删除','业务员',NULL,NULL,NULL,NULL),(40,'9','添加,修改,删除','业务员',NULL,NULL,NULL,NULL),(41,'10','添加,修改,删除','财务人员',NULL,NULL,NULL,NULL),(42,'11','添加,修改,删除','财务经理',NULL,NULL,NULL,NULL),(43,'11','添加,修改,删除','财务经理',NULL,NULL,NULL,NULL),(44,'12','添加,修改,删除','结算',NULL,NULL,NULL,NULL),(45,'13','添加,修改,删除','结算经理',NULL,NULL,NULL,NULL),(46,'12','添加,修改,删除','结算人员',NULL,NULL,NULL,NULL),(47,'14','添加,修改,删除','收发人员',NULL,NULL,NULL,NULL),(48,'15','添加,修改,删除','首发管理',NULL,NULL,NULL,NULL),(49,'16','添加,修改,删除','公司高管',NULL,NULL,NULL,NULL),(50,'8','添加,修改,删除','付款节点',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `mokuaifenpei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renyuanguanli`
--

DROP TABLE IF EXISTS `renyuanguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renyuanguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `XingMing` varchar(100) DEFAULT NULL COMMENT '姓名',
  `NianLing` varchar(100) DEFAULT NULL COMMENT '年龄',
  `XingBie` varchar(100) DEFAULT NULL COMMENT '性别',
  `JiaTingZhuZhi` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `YouXiang` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `DianHua` varchar(100) DEFAULT NULL COMMENT '电话',
  `ShouJi` varchar(100) DEFAULT NULL COMMENT '手机',
  `ZhiWu` varchar(100) DEFAULT NULL COMMENT '职务',
  `BeiZhu` varchar(100) DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='人员管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renyuanguanli`
--

LOCK TABLES `renyuanguanli` WRITE;
/*!40000 ALTER TABLE `renyuanguanli` DISABLE KEYS */;
INSERT INTO `renyuanguanli` VALUES (7,'王楠','22','女','xxxxxxxx','','18064357889','','业务员','','cmxadmin','2023-12-12 19:41:31','2023-12-13 12:36:20'),(8,'薛超','','','','','','','结算','','cmxadmin','2023-12-13 12:38:23',NULL),(9,'张帅','','','','','','','结算经理','','cmxadmin','2023-12-13 12:38:38',NULL),(10,'李蓉蓉','','','','','','','收发员','','cmxadmin','2023-12-13 12:39:10','2023-12-13 12:39:43');
/*!40000 ALTER TABLE `renyuanguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shenheliucheng`
--

DROP TABLE IF EXISTS `shenheliucheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shenheliucheng` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `ShenHeMingCheng` varchar(100) DEFAULT NULL COMMENT '审核名称',
  `YeWuMingCheng` varchar(100) DEFAULT NULL COMMENT '业务名称',
  `GuanJianZiDuan` varchar(100) DEFAULT NULL COMMENT '关键字段',
  `ShenHeZiDuan` varchar(100) DEFAULT NULL COMMENT '审核字段',
  `JueSe` varchar(100) DEFAULT NULL COMMENT '角色',
  `ShuJuFanWei` varchar(100) DEFAULT NULL COMMENT '数据范围',
  `TongGuoYu` varchar(100) DEFAULT NULL COMMENT '通过语',
  `JuJueYu` varchar(100) DEFAULT NULL COMMENT '拒绝语',
  `ShenHeZhaXunMingCheng` varchar(100) DEFAULT NULL COMMENT '审核查询名称',
  `XiuGaiYeWuZiDuan` varchar(100) DEFAULT NULL COMMENT '修改业务字段',
  `ShenHeXuHao` varchar(100) DEFAULT NULL COMMENT '审核序号',
  `ShenHeShunXu` varchar(88) DEFAULT NULL COMMENT '审核顺序',
  `ZiDuanPaiChu` varchar(88) DEFAULT NULL COMMENT '字段排除',
  `ZiDuanZhiDing` varchar(88) DEFAULT NULL COMMENT '字段指定',
  `ZiDuanZengJia` varchar(88) DEFAULT NULL COMMENT '字段增加',
  `BeiZhu` varchar(100) DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='审核流程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shenheliucheng`
--

LOCK TABLES `shenheliucheng` WRITE;
/*!40000 ALTER TABLE `shenheliucheng` DISABLE KEYS */;
/*!40000 ALTER TABLE `shenheliucheng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suoju`
--

DROP TABLE IF EXISTS `suoju`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suoju` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='锁具';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suoju`
--

LOCK TABLES `suoju` WRITE;
/*!40000 ALTER TABLE `suoju` DISABLE KEYS */;
/*!40000 ALTER TABLE `suoju` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tianjiabiaodanceshi`
--

DROP TABLE IF EXISTS `tianjiabiaodanceshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tianjiabiaodanceshi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `XingMing` varchar(100) DEFAULT NULL COMMENT '姓名',
  `XingBie` varchar(100) DEFAULT NULL COMMENT '性别',
  `ChuShengRiQi` varchar(100) DEFAULT NULL COMMENT '出生日期',
  `XueXing` varchar(100) DEFAULT NULL COMMENT '血型',
  `ShiFouBenDi` varchar(100) DEFAULT NULL COMMENT '是否本地',
  `GongYuLou` varchar(100) DEFAULT NULL COMMENT '公寓楼',
  `JiaTingChengYuan` varchar(100) DEFAULT NULL COMMENT '家庭成员',
  `NianLing` varchar(100) DEFAULT NULL COMMENT '年龄',
  `ZhengJianZhao` varchar(100) DEFAULT NULL COMMENT '证件照',
  `RiQiShiJian` varchar(100) DEFAULT NULL COMMENT '日期时间',
  `BiYeShiJian` varchar(100) DEFAULT NULL COMMENT '毕业时间',
  `DengLuMiMaZhongZhi` varchar(100) DEFAULT NULL COMMENT '登录密码重置',
  `ShiFouJianDangLiKa` varchar(100) DEFAULT NULL COMMENT '是否建党立卡',
  `RuXueShiJian` varchar(100) DEFAULT NULL COMMENT '入学时间',
  `XiHuanYanSe` varchar(100) DEFAULT NULL COMMENT '喜欢颜色',
  `GeRenPingJia` varchar(100) DEFAULT NULL COMMENT '个人评价',
  `GeRenPingFen` varchar(100) DEFAULT NULL COMMENT '个人评分',
  `ShiFouQueRen` varchar(100) DEFAULT NULL COMMENT '是否确认',
  `ZiDongWanCheng` varchar(100) DEFAULT NULL COMMENT '自动完成',
  `ChuanSuoKuang` varchar(100) DEFAULT NULL COMMENT '穿梭框',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3 COMMENT='添加表单测试';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tianjiabiaodanceshi`
--

LOCK TABLES `tianjiabiaodanceshi` WRITE;
/*!40000 ALTER TABLE `tianjiabiaodanceshi` DISABLE KEYS */;
INSERT INTO `tianjiabiaodanceshi` VALUES (2,'测试姓名','女','10:30','null','是','null','哥哥','8','null','null','2023-12-20T07:36:02.000Z','null','false','null','#B24545','null','null','100','null','null','cmxadmin','2023-12-20 15:38:16','2023-12-20 17:09:15'),(10,'添加表单测试','女','null',NULL,'否',NULL,NULL,'5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cmxadmin','2023-12-21 10:38:39',NULL),(19,'10:55','男','SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)',NULL,'是',NULL,NULL,'4',NULL,NULL,'2023-12-21T02:55:06.000Z',NULL,'true',NULL,'#DA3232',NULL,NULL,NULL,NULL,NULL,'cmxadmin','2023-12-21 10:55:42',NULL),(44,'添加表单测试','女','SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)',NULL,NULL,NULL,NULL,'18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3',NULL,NULL,NULL,'cmxadmin','2023-12-21 14:47:45',NULL),(45,'添加表单测试','女','SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)',NULL,NULL,NULL,NULL,'18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3',NULL,NULL,NULL,'cmxadmin','2023-12-22 16:30:09',NULL),(46,'添加表单测1','女','SELECT DATE_SUB(CURDATE(), INTERVAL 20 YEAR)',NULL,NULL,NULL,NULL,'18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3',NULL,NULL,NULL,'cmxadmin','2023-12-22 16:30:18',NULL);
/*!40000 ALTER TABLE `tianjiabiaodanceshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuihuoxinxichaxun`
--

DROP TABLE IF EXISTS `tuihuoxinxichaxun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuihuoxinxichaxun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `WeiShouTuiHuoJianShu` varchar(100) DEFAULT NULL COMMENT '未收退货件数',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `FaQiRen` varchar(100) DEFAULT NULL COMMENT '发起人',
  `FaQiShiJian` varchar(100) DEFAULT NULL COMMENT '发起时间',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='退货信息查询';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuihuoxinxichaxun`
--

LOCK TABLES `tuihuoxinxichaxun` WRITE;
/*!40000 ALTER TABLE `tuihuoxinxichaxun` DISABLE KEYS */;
INSERT INTO `tuihuoxinxichaxun` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','60','20','李蓉蓉','12121212121','王楠','2023-12-30','cmxadmin','2023-12-14 17:55:23',NULL);
/*!40000 ALTER TABLE `tuihuoxinxichaxun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuihuoyuanqingdianhuowu`
--

DROP TABLE IF EXISTS `tuihuoyuanqingdianhuowu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuihuoyuanqingdianhuowu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `DiuShiMingXi` varchar(100) DEFAULT NULL COMMENT '丢失明细',
  `SunHuaiMingXi` varchar(100) DEFAULT NULL COMMENT '损坏明细',
  `ShouHuoRen` varchar(100) DEFAULT NULL COMMENT '收货人',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `ShouHuoShiJian` varchar(100) DEFAULT NULL COMMENT '收货时间',
  `JiaShiRen` varchar(100) DEFAULT NULL COMMENT '驾驶人',
  `CheLiangXinXi` varchar(100) DEFAULT NULL COMMENT '车辆信息',
  `YunFei` varchar(100) DEFAULT NULL COMMENT '运费',
  `ShiFouDianFu` varchar(100) DEFAULT NULL COMMENT '是否垫付',
  `DianFuJiaGe` varchar(100) DEFAULT NULL COMMENT '垫付价格',
  `HuoWuZhuangTai` varchar(100) DEFAULT NULL COMMENT '货物状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='退货员清点货物';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuihuoyuanqingdianhuowu`
--

LOCK TABLES `tuihuoyuanqingdianhuowu` WRITE;
/*!40000 ALTER TABLE `tuihuoyuanqingdianhuowu` DISABLE KEYS */;
INSERT INTO `tuihuoyuanqingdianhuowu` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','60','1','2','李蓉蓉','145678996','2023-12-30','张三','陕A55678','承租方','否','','现场清点','cmxadmin','2023-12-14 17:36:25',NULL);
/*!40000 ALTER TABLE `tuihuoyuanqingdianhuowu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wuliaohuizong`
--

DROP TABLE IF EXISTS `wuliaohuizong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wuliaohuizong` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoMianJi` varchar(100) DEFAULT NULL COMMENT '物料面积',
  `BeiZhu` varchar(100) DEFAULT NULL COMMENT '备注',
  `WuLiaoDanJia` varchar(100) DEFAULT NULL COMMENT '物料单价',
  `XianYouKuCun` varchar(100) DEFAULT NULL COMMENT '现有库存',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='物料汇总';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wuliaohuizong`
--

LOCK TABLES `wuliaohuizong` WRITE;
/*!40000 ALTER TABLE `wuliaohuizong` DISABLE KEYS */;
INSERT INTO `wuliaohuizong` VALUES (1,'ZLU杠','根','1.11','6.67','一对一','80','1000','cmxadmin','2023-12-14 15:33:49',NULL),(2,'方管','根','4','4.8','一根对一根','80','1000','cmxadmin','2023-12-14 15:34:48',NULL),(3,'插销','个','0','0.4','一对一','70','1000','cmxadmin','2023-12-14 15:35:30',NULL),(4,'方柱扣','根','0','14','一根对一根 四根为一套','60','1000','cmxadmin','2023-12-14 15:36:31',NULL);
/*!40000 ALTER TABLE `wuliaohuizong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wuliaojiageguanli`
--

DROP TABLE IF EXISTS `wuliaojiageguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wuliaojiageguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `ShangPinBianHao` varchar(100) DEFAULT NULL COMMENT '商品编号',
  `ShangPinShuLiang` varchar(100) DEFAULT NULL COMMENT '商品数量',
  `HuoShuLiang` varchar(100) DEFAULT NULL COMMENT '货数量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='  物料价格管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wuliaojiageguanli`
--

LOCK TABLES `wuliaojiageguanli` WRITE;
/*!40000 ALTER TABLE `wuliaojiageguanli` DISABLE KEYS */;
/*!40000 ALTER TABLE `wuliaojiageguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wuliaoshuliang`
--

DROP TABLE IF EXISTS `wuliaoshuliang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wuliaoshuliang` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `ShangPinBianHao` varchar(100) DEFAULT NULL COMMENT '商品编号',
  `ShangPinShuLiang` varchar(100) DEFAULT NULL COMMENT '商品数量',
  `ShangPinKuCun` varchar(100) DEFAULT NULL COMMENT '商品库存',
  `ShangPinQueHuo` varchar(100) DEFAULT NULL COMMENT '商品缺货',
  `GouMaiShangXian` varchar(100) DEFAULT NULL COMMENT '购买上限',
  `GouMaiXiaXian` varchar(100) DEFAULT NULL COMMENT '购买下限',
  `JinHuoShangXian` varchar(100) DEFAULT NULL COMMENT '进货上限',
  `JinHuoXiaXian` varchar(100) DEFAULT NULL COMMENT '进货下限',
  `ZongJinHuoShuLiang` varchar(100) DEFAULT NULL COMMENT '总进货数量',
  `BenCiJinHuoShuLiang` varchar(100) DEFAULT NULL COMMENT '本次进货数量',
  `BenCiJinHuoShiJian` varchar(100) DEFAULT NULL COMMENT '本次进货时间',
  `LiShiJinHuoShuLiang` varchar(100) DEFAULT NULL COMMENT '历史进货数量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='物料数量';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wuliaoshuliang`
--

LOCK TABLES `wuliaoshuliang` WRITE;
/*!40000 ALTER TABLE `wuliaoshuliang` DISABLE KEYS */;
/*!40000 ALTER TABLE `wuliaoshuliang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wuliaoxinxiguanli`
--

DROP TABLE IF EXISTS `wuliaoxinxiguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wuliaoxinxiguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='物料信息管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wuliaoxinxiguanli`
--

LOCK TABLES `wuliaoxinxiguanli` WRITE;
/*!40000 ALTER TABLE `wuliaoxinxiguanli` DISABLE KEYS */;
/*!40000 ALTER TABLE `wuliaoxinxiguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wuliugongsiguanli`
--

DROP TABLE IF EXISTS `wuliugongsiguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wuliugongsiguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiuGongSiMingCheng` varchar(100) DEFAULT NULL COMMENT '物流公司名称',
  `DiZhi` varchar(100) DEFAULT NULL COMMENT '地址',
  `LianXiRen` varchar(100) DEFAULT NULL COMMENT '联系人',
  `LianXiDianHua` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `CheLiangXinXi` varchar(100) DEFAULT NULL COMMENT '车辆信息',
  `SiJiXingMing` varchar(100) DEFAULT NULL COMMENT '司机姓名',
  `SiJiDianHua` varchar(100) DEFAULT NULL COMMENT '司机电话',
  `CheLiangGuiGe` varchar(100) DEFAULT NULL COMMENT '车辆规格',
  `ZuiDaZaiZhong` varchar(100) DEFAULT NULL COMMENT '最大载重',
  `CheLiangBaoXian` varchar(100) DEFAULT NULL COMMENT '车辆保险',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='物流公司管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wuliugongsiguanli`
--

LOCK TABLES `wuliugongsiguanli` WRITE;
/*!40000 ALTER TABLE `wuliugongsiguanli` DISABLE KEYS */;
/*!40000 ALTER TABLE `wuliugongsiguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiaoshouhetong`
--

DROP TABLE IF EXISTS `xiaoshouhetong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xiaoshouhetong` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `KeHuMingCheng` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `ChanPinMingCheng` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `DunShu` varchar(100) DEFAULT NULL COMMENT '吨数',
  `DanJia` varchar(100) DEFAULT NULL COMMENT '单价',
  `DingJin` varchar(100) DEFAULT NULL COMMENT '定金',
  `HeTongZongE` varchar(100) DEFAULT NULL COMMENT '合同总额',
  `KeYongYuE` varchar(100) DEFAULT NULL COMMENT '可用余额',
  `YingShouJinE` varchar(100) DEFAULT NULL COMMENT '应收金额',
  `ShiFouKaiPiao` varchar(100) DEFAULT NULL COMMENT '是否开票',
  `HeTongZhuangTai` varchar(100) DEFAULT NULL COMMENT '合同状态',
  `QianDingRen` varchar(100) DEFAULT NULL COMMENT '签订人',
  `ZhuangTai` varchar(100) DEFAULT NULL COMMENT '状态',
  `DingJinZhuangTai` varchar(100) DEFAULT NULL COMMENT '定金状态',
  `HeTongMuBan` varchar(100) DEFAULT NULL COMMENT '合同模板',
  `HeTongJinDu` varchar(100) DEFAULT NULL COMMENT '合同进度',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='销售合同';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiaoshouhetong`
--

LOCK TABLES `xiaoshouhetong` WRITE;
/*!40000 ALTER TABLE `xiaoshouhetong` DISABLE KEYS */;
/*!40000 ALTER TABLE `xiaoshouhetong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yibeihuoweifahuo`
--

DROP TABLE IF EXISTS `yibeihuoweifahuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yibeihuoweifahuo` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `JianShu` varchar(100) DEFAULT NULL COMMENT '件数',
  `ShouHuoRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '收货人联系方式',
  `BeiHuoRen` varchar(100) DEFAULT NULL COMMENT '备货人',
  `BeiHuoShiJian` varchar(100) DEFAULT NULL COMMENT '备货时间',
  `BeiHuoZhuangTai` varchar(100) DEFAULT NULL COMMENT '备货状态',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='已备货未发货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yibeihuoweifahuo`
--

LOCK TABLES `yibeihuoweifahuo` WRITE;
/*!40000 ALTER TABLE `yibeihuoweifahuo` DISABLE KEYS */;
INSERT INTO `yibeihuoweifahuo` VALUES (1,'001','居然之家咸阳购物广场','咸阳市秦都区文林西路','方柱扣','80','151149055','李蓉蓉','2013-12-14','已备货','cmxadmin','2023-12-14 17:31:57',NULL);
/*!40000 ALTER TABLE `yibeihuoweifahuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghuguanli`
--

DROP TABLE IF EXISTS `yonghuguanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yonghuguanli` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `YongHuMing` varchar(100) DEFAULT NULL COMMENT '用户名',
  `JueSe` varchar(100) DEFAULT NULL COMMENT '角色',
  `YongHuXingZhi` varchar(600) DEFAULT NULL COMMENT '用户性质',
  `LianXiDianHua` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `ShouJi` varchar(100) DEFAULT NULL COMMENT '手机',
  `XingMing` varchar(100) DEFAULT NULL COMMENT '姓名',
  `YouXiang` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `DanWei` varchar(220) DEFAULT NULL COMMENT '单位',
  `DiZhi` varchar(100) DEFAULT NULL COMMENT '地址',
  `YongHuZhuangTai` varchar(100) DEFAULT NULL COMMENT '用户状态',
  `MiMa` varchar(100) DEFAULT NULL COMMENT '密码',
  `ZhangHaoYouXiaoQi` varchar(100) DEFAULT NULL COMMENT '账号有效期',
  `ZhuCeShiJian` varchar(100) DEFAULT NULL COMMENT '注册时间',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='用户管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghuguanli`
--

LOCK TABLES `yonghuguanli` WRITE;
/*!40000 ALTER TABLE `yonghuguanli` DISABLE KEYS */;
INSERT INTO `yonghuguanli` VALUES (1,'admin','1','所内','123','12399','超级管理员','123@qq.com','','北京市东城区东单三条五号','审核通过','c30807e6587ade285ba7ade9f881b3d7','2026-12-12','2023-12-12',NULL,NULL,NULL),(2,'wangnan','8',NULL,'1111',NULL,'王楠','1212',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','cb4f3a43c8a976cd002ce822ad5c9d13','2026-12-12','2023-12-12','cmxadmin','2023-12-12 22:49:40',NULL),(3,'dushuai','9',NULL,'1111',NULL,'杜帅','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','92f21f1af6552e1e5e994b73b0199db3','2026-12-12','2023-12-12','cmxadmin','2023-12-12 22:53:43',NULL),(4,'liuwenchuang','10',NULL,'1111',NULL,'刘文创','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','3f214452232b765fe3c9c938685bd645','2026-12-12','2023-12-12','cmxadmin','2023-12-12 22:55:48',NULL),(5,'fanzong','11',NULL,'1111',NULL,'樊总','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','62e69a0028e7776f9fc4d22c56286b68','2026-12-12','2023-12-12','cmxadmin','2023-12-12 23:00:38',NULL),(6,'xuechao','12',NULL,'1111',NULL,'薛超','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','d7c14553857b418397d0d504713bbe98','2026-12-12','2023-12-12','cmxadmin','2023-12-12 23:02:34',NULL),(7,'zhangshuai','13',NULL,'1111',NULL,'张帅','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','e6950a217d774f491d3e786998223419','2026-12-12','2023-12-12','cmxadmin','2023-12-12 23:03:30',NULL),(8,'lirongrong','14',NULL,'1111',NULL,'李蓉蓉','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','826e172ed2f3104b54bb3e89dddc3bfc','2026-12-12','2023-12-12','cmxadmin','2023-12-12 23:04:28',NULL),(9,'wanghuan','15',NULL,'1111',NULL,'王欢','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','1e45f47fdea6017665fa87cb273bb9f6','2026-12-12','2023-12-12','cmxadmin','2023-12-12 23:05:55',NULL),(10,'yuanzong','16',NULL,'1111',NULL,'袁总','',NULL,'陕西省渭南市临渭区双王街道菜鸟驿站','审核通过','a20ce4bea5fbae01d4cb73afcca88602','2026-12-12','2023-12-12','cmxadmin','2023-12-12 23:06:44',NULL);
/*!40000 ALTER TABLE `yonghuguanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zlugang`
--

DROP TABLE IF EXISTS `zlugang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zlugang` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `WuLiaoBianMa` varchar(100) DEFAULT NULL COMMENT '物料编码',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoLeiBie` varchar(100) DEFAULT NULL COMMENT '物料类别',
  `ZuHeWuLiao` varchar(100) DEFAULT NULL COMMENT '组合物料',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `JiaGe` varchar(100) DEFAULT NULL COMMENT '价格',
  `ZhangDu` varchar(100) DEFAULT NULL COMMENT '长度',
  `WuLiaoZhongLiang` varchar(100) DEFAULT NULL COMMENT '物料重量',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='ZLU杠';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zlugang`
--

LOCK TABLES `zlugang` WRITE;
/*!40000 ALTER TABLE `zlugang` DISABLE KEYS */;
INSERT INTO `zlugang` VALUES (1,'Z0.45-0.21-0.8','Z杠','加固件','否','根','','1.46','6.57','cmxadmin','2023-12-13 12:42:14',NULL);
/*!40000 ALTER TABLE `zlugang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zulinhetong`
--

DROP TABLE IF EXISTS `zulinhetong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zulinhetong` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `ChuZuDanWei` varchar(100) DEFAULT NULL COMMENT '出租单位',
  `ChengZuDanWei` varchar(100) DEFAULT NULL COMMENT '承租单位',
  `ChengZuFangSheHuiXinXiDaiMa` varchar(100) DEFAULT NULL COMMENT '承租方社会信息代码',
  `ChengZuFangKaiHuXing` varchar(100) DEFAULT NULL COMMENT '承租方开户行',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `JieShouRen` varchar(100) DEFAULT NULL COMMENT '接收人',
  `JieShouRenLianXiFangShi` varchar(100) DEFAULT NULL COMMENT '接收人联系方式',
  `HeTongLeiXing` varchar(100) DEFAULT NULL COMMENT '合同类型',
  `QiShiRiQi` varchar(100) DEFAULT NULL COMMENT '起始日期',
  `JieZhiRiQi` varchar(100) DEFAULT NULL COMMENT '截至日期',
  `WuLiaoYunFei` varchar(100) DEFAULT NULL COMMENT '物料运费',
  `HeTongTuPian` varchar(100) DEFAULT NULL COMMENT '合同图片',
  `HeTongFuJiaXinXi` varchar(100) DEFAULT NULL COMMENT '合同附加信息',
  `BeiZhuYuanYin` varchar(100) DEFAULT NULL COMMENT '备注原因',
  `YeWuYuan` varchar(100) DEFAULT NULL COMMENT '业务员',
  `HeTongZhiXingJinDu` varchar(100) DEFAULT NULL COMMENT '合同执行进度',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3 COMMENT='租赁合同';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zulinhetong`
--

LOCK TABLES `zulinhetong` WRITE;
/*!40000 ALTER TABLE `zulinhetong` DISABLE KEYS */;
INSERT INTO `zulinhetong` VALUES (2,'002','中国青少年空天科普研学基地项目','陕西航投安平新材料有限公司','陕西欧亚铭宇商贸有限公司','','','陕西欧亚','马姗姗','19391639827','租赁','发货当天','收货当天','承租方承担','','','','王楠','','cmxadmin','2023-12-14 17:06:53',NULL),(4,'001','xxxxx项目','1','安平建筑公司','1000000000000','招商银行','陕西省西安市','张三','18064357551','租赁','2023-12-26','2024-12-26','1',NULL,NULL,NULL,NULL,NULL,'cmxadmin','2023-12-26 11:38:26',NULL),(5,'003','xxxxx项目','安平建筑公司','安平建筑公司','1000000000','工商银行','陕西省西安市XXXXX','李四','1502926789','租赁','2023-12-26','2024-12-26','2','null','null','null','null','null','cmxadmin','2023-12-26 11:39:22','2024-03-01 23:30:42');
/*!40000 ALTER TABLE `zulinhetong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zulinhetongshenpi`
--

DROP TABLE IF EXISTS `zulinhetongshenpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zulinhetongshenpi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `XiangMuMingCheng` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `ChuZuDanWei` varchar(100) DEFAULT NULL COMMENT '出租单位',
  `ChengZuDanWei` varchar(100) DEFAULT NULL COMMENT '承租单位',
  `ChengZuFangSheHui` varchar(100) DEFAULT NULL COMMENT '承租方社会',
  `ChengZuFangKaiHu` varchar(100) DEFAULT NULL COMMENT '承租方开户',
  `XiangMuDiZhi` varchar(100) DEFAULT NULL COMMENT '项目地址',
  `JieShouRen` varchar(100) DEFAULT NULL COMMENT '接收人',
  `JieShouRenLianXi` varchar(100) DEFAULT NULL COMMENT '接收人联系',
  `HeTongLeiXing` varchar(100) DEFAULT NULL COMMENT '合同类型',
  `WuLiaoMingXi` varchar(100) DEFAULT NULL COMMENT '物料明细',
  `QiShiRiQi` varchar(100) DEFAULT NULL COMMENT '起始日期',
  `JieZhiRiQi` varchar(100) DEFAULT NULL COMMENT '截至日期',
  `FuKuanJieDian` varchar(100) DEFAULT NULL COMMENT '付款节点',
  `WuLiaoYunFei` varchar(100) DEFAULT NULL COMMENT '物料运费',
  `HeTongTuPian` varchar(100) DEFAULT NULL COMMENT '合同图片',
  `HeTongFuJiaXin` varchar(100) DEFAULT NULL COMMENT '合同附加信',
  `WuLiaoDanJia` varchar(100) DEFAULT NULL COMMENT '物料单价',
  `PeiChangDanJia` varchar(100) DEFAULT NULL COMMENT '赔偿单价',
  `JiHuaZuLiang` varchar(100) DEFAULT NULL COMMENT '计划租量',
  `ZheKouLu` varchar(100) DEFAULT NULL COMMENT '折扣率',
  `BeiZhuYuanYin` varchar(100) DEFAULT NULL COMMENT '备注原因',
  `YeWuYuan` varchar(100) DEFAULT NULL COMMENT '业务员',
  `TongZhiXingJinDu` varchar(100) DEFAULT NULL COMMENT '同执行进度',
  `ShiFouTongGuoShenPi` varchar(100) DEFAULT NULL COMMENT '是否通过审批',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='租赁合同审批';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zulinhetongshenpi`
--

LOCK TABLES `zulinhetongshenpi` WRITE;
/*!40000 ALTER TABLE `zulinhetongshenpi` DISABLE KEYS */;
INSERT INTO `zulinhetongshenpi` VALUES (1,'001','居然之家咸阳购物广场','陕西安平建筑科技有限公司','陕西凯丰建设有限公司','','','咸阳市秦都区文林西路','李会民','15114905564','租赁','方柱扣','发货后一天','退货到货当天','','承租方承担','','','每天每套','表格形式出现','100','','','王楠','','','cmxadmin','2023-12-14 17:52:18',NULL);
/*!40000 ALTER TABLE `zulinhetongshenpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zulinhetongwuliao`
--

DROP TABLE IF EXISTS `zulinhetongwuliao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zulinhetongwuliao` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `GuiGemM` varchar(100) DEFAULT NULL COMMENT '规格（mm）',
  `XingHao` varchar(100) DEFAULT NULL COMMENT '型号',
  `JiLiangDanWei` varchar(100) DEFAULT NULL COMMENT '计量单位',
  `SunHuaiPeiChang` varchar(100) DEFAULT NULL COMMENT '损坏赔偿',
  `DiuShiPeiChang` varchar(100) DEFAULT NULL COMMENT '丢失赔偿',
  `WuLiaoDanJia` varchar(100) DEFAULT NULL COMMENT '物料单价',
  `BeiZhu` varchar(100) DEFAULT NULL COMMENT '备注',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='租赁合同物料';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zulinhetongwuliao`
--

LOCK TABLES `zulinhetongwuliao` WRITE;
/*!40000 ALTER TABLE `zulinhetongwuliao` DISABLE KEYS */;
INSERT INTO `zulinhetongwuliao` VALUES (1,'002','钢柱箍','500-800','8#','套',NULL,NULL,'0.32','','cmxadmin','2023-12-14 18:47:36',NULL),(2,'002','钢柱箍','700-1000','8#','套',NULL,NULL,'0.44','','cmxadmin','2023-12-14 18:48:10',NULL),(3,'002','钢柱箍','900-1200','10#','套',NULL,NULL,'0.55','','cmxadmin','2023-12-14 18:48:41',NULL),(4,'002','梁夹具','200-400','','套',NULL,NULL,'0.25','','cmxadmin','2023-12-14 18:49:19',NULL),(5,'001','方柱扣','700-1000 10#','','套',NULL,NULL,'0.45','','cmxadmin','2023-12-14 18:49:58',NULL);
/*!40000 ALTER TABLE `zulinhetongwuliao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zulinjiesuan`
--

DROP TABLE IF EXISTS `zulinjiesuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zulinjiesuan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoShuLiang` varchar(100) DEFAULT NULL COMMENT '物料数量',
  `WuLiaoRiZuJin` varchar(100) DEFAULT NULL COMMENT '物料日租金',
  `QiZuShiJian` varchar(100) DEFAULT NULL COMMENT '起租时间',
  `ZongJiYunFei` varchar(100) DEFAULT NULL COMMENT '总计运费',
  `TuiHuiShiJian` varchar(100) DEFAULT NULL COMMENT '退回时间',
  `WeiSunHuaiJiaQian` varchar(100) DEFAULT NULL COMMENT '未损坏价钱',
  `WuLiaoSunHuaiQing` varchar(100) DEFAULT NULL COMMENT '物料损坏情',
  `PeiChangJiaGe` varchar(100) DEFAULT NULL COMMENT '赔偿价格',
  `ZongJi` varchar(100) DEFAULT NULL COMMENT '总计',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='租赁结算';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zulinjiesuan`
--

LOCK TABLES `zulinjiesuan` WRITE;
/*!40000 ALTER TABLE `zulinjiesuan` DISABLE KEYS */;
INSERT INTO `zulinjiesuan` VALUES (1,'001','方柱扣','60','0.45','2023-12-16','200','2023-12-30','578','丢1损2','1000','1578','cmxadmin','2023-12-14 17:43:33',NULL);
/*!40000 ALTER TABLE `zulinjiesuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zulinqingsuan`
--

DROP TABLE IF EXISTS `zulinqingsuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zulinqingsuan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自动增加的ID',
  `HeTongBianHao` varchar(100) DEFAULT NULL COMMENT '合同编号',
  `WuLiaoMingCheng` varchar(100) DEFAULT NULL COMMENT '物料名称',
  `WuLiaoShuLiang` varchar(100) DEFAULT NULL COMMENT '物料数量',
  `WuLiaoRiZuJin` varchar(100) DEFAULT NULL COMMENT '物料日租金',
  `QiZuShiJian` varchar(100) DEFAULT NULL COMMENT '起租时间',
  `TuiHuiShiJian` varchar(100) DEFAULT NULL COMMENT '退回时间',
  `WeiSunHuaiJiaQian` varchar(100) DEFAULT NULL COMMENT '未损坏价钱',
  `WuLiaoSunHuaiQing` varchar(100) DEFAULT NULL COMMENT '物料损坏情',
  `ZheKouLu` varchar(100) DEFAULT NULL COMMENT '折扣率',
  `PeiChangJiaGe` varchar(100) DEFAULT NULL COMMENT '赔偿价格',
  `ZongJi` varchar(100) DEFAULT NULL COMMENT '总计',
  `ZuiZhongQingSuanJiaQian` varchar(100) DEFAULT NULL COMMENT '最终清算价钱',
  `UserName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `InsertTime` varchar(30) DEFAULT NULL COMMENT '新增记录时间',
  `UpdateTime` varchar(30) DEFAULT NULL COMMENT '修改记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='租赁清算';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zulinqingsuan`
--

LOCK TABLES `zulinqingsuan` WRITE;
/*!40000 ALTER TABLE `zulinqingsuan` DISABLE KEYS */;
/*!40000 ALTER TABLE `zulinqingsuan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-05 16:29:06
