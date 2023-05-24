/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.26 : Database - express
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`express` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `express`;

/*Table structure for table `t_admin_menu` */

DROP TABLE IF EXISTS `t_admin_menu`;

CREATE TABLE `t_admin_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '管理员id',
  `menu_id` int NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_admin_menu` */

insert  into `t_admin_menu`(`id`,`user_id`,`menu_id`) values (26,2,1),(27,2,2),(28,2,3),(29,2,4),(30,2,6),(31,5,1),(32,5,2),(33,5,3),(34,5,4),(35,5,5),(36,5,6),(37,6,1),(38,6,2),(39,6,3),(40,6,4),(41,6,5),(42,6,6),(43,7,1),(44,7,2),(45,7,3),(46,7,4),(47,7,5),(48,7,6),(51,12,1),(52,12,2),(53,12,3),(54,12,4),(55,12,5),(56,12,6);

/*Table structure for table `t_car` */

DROP TABLE IF EXISTS `t_car`;

CREATE TABLE `t_car` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `car_no` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '无人机编号',
  `car_type` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '型号',
  `user_id` int NOT NULL COMMENT '所属快递员',
  `car_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '说明',
  `is_idle` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否空闲',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='车辆表';

/*Data for the table `t_car` */

insert  into `t_car`(`id`,`car_no`,`car_type`,`user_id`,`car_description`,`is_idle`,`created_time`,`updated_time`,`deleted`) values (1,'001','天机系列',3,'暂无',0,'2023-05-04 23:38:18','2023-05-17 14:28:58',0),(2,'002','天机系列',3,'暂无',0,'2023-04-18 19:43:36','2023-05-12 09:12:15',0),(3,'003','天机系列',3,'暂无',0,'2023-05-11 15:50:39','2023-05-17 14:28:59',0),(4,'004','天机系列',3,'暂无',0,'2023-05-11 22:13:48','2023-05-17 14:29:00',0),(5,'005','翼龙系列',3,'暂无',0,'2023-05-11 22:20:22','2023-05-17 14:29:01',0),(6,'006','翼龙系列',3,'暂无',0,'2023-05-11 22:20:40','2023-05-17 14:29:02',0),(7,'007','翼龙系列',3,'暂无',0,'2023-05-11 22:20:59','2023-05-18 11:26:13',0),(9,'008','翼龙系列',3,'暂无',1,'2023-05-18 11:29:29','2023-05-18 11:29:29',0);

/*Table structure for table `t_delivery` */

DROP TABLE IF EXISTS `t_delivery`;

CREATE TABLE `t_delivery` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `express_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递单号',
  `courier_id` int NOT NULL COMMENT '派件员ID',
  `drone_id` int NOT NULL COMMENT '派件无人机ID',
  `express_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '快递状态：0表示未送达，1表示已送达',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '送达时间',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='派件信息表';

/*Data for the table `t_delivery` */

insert  into `t_delivery`(`id`,`express_no`,`courier_id`,`drone_id`,`express_status`,`end_time`,`created_time`,`updated_time`,`deleted`) values (1,'20230417890299321234',3,2,1,'2023-04-18 19:34:00','2023-04-18 17:54:00','2023-05-05 00:49:17',0),(2,'232399302934821',3,2,1,'2023-04-18 22:11:00','2023-04-18 20:36:00','2023-05-05 00:49:15',0),(3,'2023041899023921',3,2,1,'2023-05-05 00:58:08','2023-04-24 15:05:00','2023-05-05 00:58:08',0),(4,'202304271530381682580638203',3,2,0,NULL,'2023-05-04 11:23:37','2023-05-05 00:49:11',0),(6,'20230504153829763304',3,2,0,NULL,'2023-05-05 00:37:33','2023-05-05 00:37:33',0),(7,'20230511152630613186',3,2,1,'2023-05-11 22:52:33','2023-05-11 15:45:00','2023-05-11 22:52:33',0),(8,'20230511225058988982',3,6,1,'2023-05-11 22:52:32','2023-05-11 22:51:00','2023-05-11 22:52:31',0),(9,'20230511224938968575',3,2,0,NULL,'2023-05-12 09:12:15','2023-05-12 09:12:15',0),(10,'20230511225041360381',3,5,0,NULL,'2023-05-16 15:09:46','2023-05-16 15:09:46',0),(11,'20230518110516861456',3,7,1,'2023-05-18 11:19:22','2023-05-18 11:18:00','2023-05-18 11:19:21',0);

/*Table structure for table `t_express` */

DROP TABLE IF EXISTS `t_express`;

CREATE TABLE `t_express` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `express_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递单号',
  `receiver_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NOT NULL COMMENT '收件人姓名',
  `receiver_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人电话',
  `receiver_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配送地址',
  `express_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '取件码',
  `entry_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
  `out_time` timestamp NULL DEFAULT NULL COMMENT '出库时间',
  `site_id` int DEFAULT NULL COMMENT '所属驿站',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0表示入库，1表示出库',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`,`receiver_address`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='快递表';

/*Data for the table `t_express` */

insert  into `t_express`(`id`,`express_no`,`receiver_name`,`receiver_phone`,`receiver_address`,`express_code`,`entry_time`,`out_time`,`site_id`,`status`,`created_time`,`updated_time`,`deleted`) values (7,'20230504153829763304','董卓','13878320092','安徽省合肥市屯溪路193号合肥工业大学1号楼','10-3321','2023-05-04 15:38:28','2023-05-05 00:37:34',3,1,'2023-05-04 15:38:29','2023-05-18 11:05:38',1),(9,'20230511152630613186','吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','23-1002','2023-05-11 15:26:28','2023-05-11 15:46:00',2,1,'2023-05-11 15:26:30','2023-05-11 15:45:59',0),(10,'20230511152800530379','曹操','15327568830','安徽省合肥市屯溪路193号合肥工业大学8号楼','10-3112','2023-05-09 00:00:00',NULL,2,0,'2023-05-11 15:28:00','2023-05-11 15:28:00',0),(11,'20230511153353406843','张辽','13253937931','安徽省合肥市屯溪路193号合肥工业大学10号楼','3-2009','2023-05-10 00:00:00',NULL,2,0,'2023-05-11 15:33:53','2023-05-11 15:36:06',0),(12,'20230511213350821808','诸葛亮','13987338863','安徽省合肥市屯溪路193号合肥工业大学2号楼','22-2778','2023-05-11 21:33:49',NULL,3,0,'2023-05-11 21:33:50','2023-05-11 22:42:14',1),(13,'20230511224654327747','夏侯惇','13754699823','安徽省合肥市屯溪路193号合肥工业大学4号楼','22-1073','2023-05-11 22:46:53',NULL,4,0,'2023-05-11 22:46:54','2023-05-11 22:46:54',0),(14,'20230511224938968575','吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','01-2281','2023-05-11 22:49:37','2023-05-12 09:12:16',5,1,'2023-05-11 22:49:38','2023-05-12 09:12:15',0),(15,'20230511225041360381','吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','21-2221','2023-05-11 22:50:38','2023-05-16 15:09:46',5,1,'2023-05-11 22:50:41','2023-05-16 15:09:46',0),(16,'20230511225058988982','吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','11-0212','2023-05-11 22:50:58','2023-05-11 22:51:46',5,1,'2023-05-11 22:50:58','2023-05-11 22:51:46',0),(17,'20230512084912508162','吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','10-2212','2023-05-12 08:49:11',NULL,2,0,'2023-05-12 08:49:12','2023-05-12 08:49:18',1),(18,'20230518110516861456','王垕','17388290283','安徽省合肥市屯溪路193号合肥工业大学9号楼','18-2991','2023-05-18 11:05:15','2023-05-18 11:18:01',3,1,'2023-05-18 11:05:16','2023-05-18 11:18:00',0),(19,'20230518111245741348','王垕','17388290283','安徽省合肥市屯溪路193号合肥工业大学8号楼','10-2381','2023-05-18 11:05:59',NULL,3,0,'2023-05-18 11:12:45','2023-05-18 11:13:18',1);

/*Table structure for table `t_express_site` */

DROP TABLE IF EXISTS `t_express_site`;

CREATE TABLE `t_express_site` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `site_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '站点名称',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_express_site` */

insert  into `t_express_site`(`id`,`site_name`,`deleted`) values (2,'北门农业银行驿站',0),(3,'南门驿站',0),(4,'东门教育超市内驿站',0),(5,'西门便利店旁驿站',0);

/*Table structure for table `t_information` */

DROP TABLE IF EXISTS `t_information`;

CREATE TABLE `t_information` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `information_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片链接',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  `createdTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='咨询表';

/*Data for the table `t_information` */

insert  into `t_information`(`id`,`title`,`information_type`,`img`,`description`,`createdTime`,`updated_time`,`deleted`) values (3,'五一假期停业三天！！！','通知','http://localhost:12345/common/img/202305112158291683813509562da16.webp','4.30-5.2休息。','2023-05-11 21:57:42','2023-05-11 21:57:42',0),(4,'喜报！','通知','http://localhost:12345/common/img/2023051811242616843802669065394.jpg','本驿站（北门农业银行旁）开业大吉，寄件八折优惠','2023-05-18 11:24:47','2023-05-18 19:40:32',1);

/*Table structure for table `t_logistics_info` */

DROP TABLE IF EXISTS `t_logistics_info`;

CREATE TABLE `t_logistics_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID，自增',
  `pick_express_id` int NOT NULL COMMENT '快递ID',
  `current_location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当前位置',
  `current_status` tinyint NOT NULL COMMENT '当前状态，0表示已揽收，1表示运输中，2表示派送中，3表示已签收',
  `delivery_time` timestamp NOT NULL COMMENT '发货时间',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='物流信息表，用于存储快递物流状态信息';

/*Data for the table `t_logistics_info` */

insert  into `t_logistics_info`(`id`,`pick_express_id`,`current_location`,`current_status`,`delivery_time`,`created_time`,`updated_time`,`deleted`) values (1,1,'快递员派送中',2,'2023-04-17 21:05:22','2023-04-17 21:05:21','2023-05-05 12:38:10',0),(2,2,'已揽件，准备发往目的地',0,'2023-04-18 17:39:32','2023-04-18 17:39:31','2023-05-11 15:47:12',0),(3,2,'已揽件，准备发往目的地',0,'2023-05-06 13:53:05','2023-05-06 13:53:04','2023-05-11 15:47:18',0),(4,3,'以装车，准备发往目的地',0,'2023-05-11 20:35:25','2023-05-11 20:35:24','2023-05-11 20:35:24',0),(5,4,'以装车，准备发往目的地',0,'2023-05-11 20:47:00','2023-05-11 20:47:00','2023-05-11 20:47:00',0),(6,7,'以装车，准备发往目的地',0,'2023-05-18 11:27:35','2023-05-18 11:27:34','2023-05-18 11:27:34',0),(7,6,'以装车，准备发往目的地',0,'2023-05-18 11:28:19','2023-05-18 11:28:18','2023-05-18 11:28:18',0);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单图标',
  `index` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单索引',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单标题',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `sort` int DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='菜单表';

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`icon`,`index`,`title`,`created_time`,`updated_time`,`deleted`,`sort`) values (1,'el-icon-location-outline','dashboard','系统首页','2023-04-17 09:25:10','2023-04-27 17:09:12',0,1),(2,'el-icon-mobile-phone','center','个人信息','2023-04-17 09:25:26','2023-04-27 17:09:15',0,2),(3,'el-icon-box','express','取件中心','2023-04-17 09:25:42','2023-05-15 18:21:01',0,3),(4,'el-icon-thumb','pick','寄件中心','2023-04-17 09:25:58','2023-04-27 17:09:18',0,4),(5,'el-icon-position','send','调度信息','2023-04-17 09:26:14','2023-05-15 18:29:07',0,5),(6,'el-icon-reading','information','资讯信息','2023-04-17 09:26:30','2023-04-27 17:09:33',0,7),(7,'el-icon-bicycle','courier','无人机管理员信息','2023-04-17 09:26:44','2023-05-04 16:56:03',0,8),(8,'el-icon-truck','car','无人机信息','2023-04-17 09:26:59','2023-05-04 16:55:55',0,9),(9,'el-icon-user','user','用户信息','2023-04-17 09:27:14','2023-04-27 17:09:37',0,10),(10,'el-icon-setting','setting','驿站快递管理员信息','2023-04-26 23:58:57','2023-05-15 18:25:59',0,11);

/*Table structure for table `t_pickup` */

DROP TABLE IF EXISTS `t_pickup`;

CREATE TABLE `t_pickup` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `express_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递单号',
  `user_id` int NOT NULL COMMENT '下单用户ID',
  `pickup_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '寄件人姓名',
  `pickup_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '寄件人电话',
  `pickup_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '寄件地址',
  `receiver_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人姓名',
  `receiver_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人电话',
  `receiver_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人地址',
  `express_company` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '快递公司',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '下单时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '订单状态：0：待无人机取件；1：以取件，待送达；2：已送达，待审核；3：已审核，待寄出；4：已寄出；5：审核未通过',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`,`pickup_address`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='取件信息表';

/*Data for the table `t_pickup` */

insert  into `t_pickup`(`id`,`express_no`,`user_id`,`pickup_name`,`pickup_phone`,`pickup_address`,`receiver_name`,`receiver_phone`,`receiver_address`,`express_company`,`amount`,`order_time`,`status`,`created_time`,`updated_time`,`deleted`) values (1,'202304172005201681733120438',2,'寄件人-a','17788889999','某处','收件人1-2','18788230921','地址-1','顺丰快递','15.00','2023-04-17 20:05:19',5,'2023-04-17 20:05:20','2023-05-11 21:29:53',1),(2,'202304181650091681807809663',4,'寄件人-b','18877776666','那里','普通用户寄件测试','17385662783','普通用户寄件测试','圆通快递','15.00','2023-04-18 16:50:08',4,'2023-04-18 16:50:09','2023-05-11 21:29:52',1),(3,'20230506134853783335',4,'寄件人-c','16677778888','这里','收件人-a','17788889999','某处','申通快递','15.00','2023-05-06 13:48:52',4,'2023-05-06 13:48:53','2023-05-11 21:30:02',1),(4,'20230511204237961315',4,'吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','貂蝉','13253937931','河南省三门峡市义马市千家小区','顺丰快递','15.00','2023-05-11 20:42:36',4,'2023-05-11 20:42:37','2023-05-11 23:06:36',0),(5,'20230511225445616477',4,'吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','关羽','13525648869','河南省洛阳市洛龙区上阳城','韵达快递','15.00','2023-05-11 22:54:44',5,'2023-05-11 22:54:45','2023-05-11 22:56:06',0),(6,'20230512091111935511',4,'吕布','17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','曹操','15327568830','河南省三门峡市义马市','顺丰快递','15.00','2023-05-12 09:11:10',4,'2023-05-12 09:11:11','2023-05-18 11:28:18',0),(7,'20230518111639720067',11,'王垕','17388290283','安徽省合肥市屯溪路193号合肥工业大学1号楼','梁王','16395384766','广东省深圳市南山区南方科技大学','韵达快递','15.00','2023-05-18 11:16:20',4,'2023-05-18 11:16:39','2023-05-18 11:27:34',0);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_name`,`role_description`,`created_time`,`updated_time`,`deleted`) values (1,'admin','驿站管理员','2023-04-17 09:27:33','2023-05-11 22:07:03',0),(2,'courier','无人机管理员','2023-04-17 09:27:46','2023-05-11 22:06:58',0),(3,'user','普通用户','2023-04-17 09:27:55','2023-04-17 09:27:55',0),(5,'super','系统管理员','2023-04-26 23:57:09','2023-05-11 15:05:15',0);

/*Table structure for table `t_role_menu` */

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int NOT NULL COMMENT '角色ID',
  `menu_id` int NOT NULL COMMENT '菜单ID',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

/*Data for the table `t_role_menu` */

insert  into `t_role_menu`(`id`,`role_id`,`menu_id`,`created_time`,`updated_time`,`deleted`) values (1,1,1,'2023-04-17 13:22:15','2023-04-17 13:22:15',0),(2,1,2,'2023-04-17 13:22:20','2023-04-17 13:22:20',0),(3,1,3,'2023-04-17 13:22:24','2023-04-17 13:22:24',0),(4,1,4,'2023-04-17 13:22:27','2023-04-17 13:22:27',0),(5,1,5,'2023-04-17 13:22:31','2023-04-17 13:22:31',0),(6,1,6,'2023-04-17 13:22:35','2023-04-17 13:22:35',0),(7,1,7,'2023-04-17 13:22:39','2023-04-17 13:22:39',0),(9,3,2,'2023-04-18 16:42:45','2023-04-18 16:42:45',0),(10,3,4,'2023-04-18 16:42:50','2023-04-18 16:42:50',0),(11,3,5,'2023-04-18 16:42:54','2023-04-18 16:42:54',0),(12,3,6,'2023-04-18 16:43:00','2023-04-18 16:43:00',0),(13,3,3,'2023-04-18 17:26:30','2023-04-18 17:26:30',0),(14,2,2,'2023-04-18 17:40:56','2023-04-18 17:40:56',0),(15,2,3,'2023-04-18 17:41:01','2023-04-18 17:41:01',0),(16,2,5,'2023-04-18 17:41:11','2023-04-18 17:41:11',0),(17,2,6,'2023-04-18 17:41:16','2023-04-18 17:41:16',0),(18,0,1,'2023-04-26 23:56:49','2023-04-26 23:56:49',0),(20,0,3,'2023-04-26 23:56:49','2023-04-26 23:56:49',0),(21,0,4,'2023-04-26 23:56:49','2023-04-26 23:56:49',0),(22,0,5,'2023-04-26 23:56:49','2023-04-26 23:56:49',0),(23,0,6,'2023-04-26 23:56:49','2023-04-26 23:56:49',0),(24,0,7,'2023-04-26 23:56:49','2023-04-26 23:56:49',0),(26,0,10,'2023-04-26 23:59:04','2023-04-26 23:59:04',0),(31,2,8,'2023-05-04 16:48:39','2023-05-04 16:48:39',0),(32,2,4,'2023-05-06 13:57:18','2023-05-06 13:57:18',0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `role_id` int NOT NULL COMMENT '角色',
  `enable_flag` tinyint(1) DEFAULT '1' COMMENT '启用状态',
  `last_login` timestamp NULL DEFAULT NULL COMMENT '最后登录时间',
  `site_id` int DEFAULT NULL COMMENT '管理员所属站点',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`role_id`,`enable_flag`,`last_login`,`site_id`,`created_time`,`updated_time`,`deleted`) values (1,'super','7beb539163cd65c54f4ee9d8d01ab827',0,1,'2023-05-23 15:24:47',NULL,'2023-04-27 00:25:47','2023-04-27 00:25:47',0),(2,'admin','7beb539163cd65c54f4ee9d8d01ab827',1,0,'2023-05-22 17:49:50',2,'2023-04-17 13:20:26','2023-05-23 15:15:59',0),(3,'courier','7beb539163cd65c54f4ee9d8d01ab827',2,1,'2023-05-19 08:52:13',NULL,'2023-04-18 15:00:16','2023-05-23 14:51:06',0),(4,'user','7beb539163cd65c54f4ee9d8d01ab827',3,1,'2023-05-23 16:00:11',NULL,'2023-04-18 16:43:38','2023-04-18 16:43:38',0),(5,'admin-1','7beb539163cd65c54f4ee9d8d01ab827',1,1,'2023-05-16 15:10:25',4,'2023-04-27 14:22:10','2023-05-05 10:55:50',0),(6,'admin-2','7beb539163cd65c54f4ee9d8d01ab827',1,1,'2023-05-18 11:04:40',3,'2023-05-05 11:52:31','2023-05-11 21:03:38',0),(7,'admin-3','7beb539163cd65c54f4ee9d8d01ab827',1,1,'2023-05-11 22:49:01',5,'2023-05-05 11:55:14','2023-05-11 22:10:07',0),(8,'user-1','7beb539163cd65c54f4ee9d8d01ab827',3,1,'2023-05-11 22:41:24',NULL,'2023-05-11 20:47:56','2023-05-11 22:11:22',0),(9,'user-2','7beb539163cd65c54f4ee9d8d01ab827',3,1,'2023-05-11 22:41:44',NULL,'2023-05-11 20:50:33','2023-05-11 22:11:25',0),(10,'courier-2','7beb539163cd65c54f4ee9d8d01ab827',2,1,'2023-05-16 17:26:37',NULL,'2023-05-16 17:26:35','2023-05-16 17:26:35',0),(11,'user-3','7beb539163cd65c54f4ee9d8d01ab827',3,1,'2023-05-18 11:18:26',NULL,'2023-05-18 11:02:31','2023-05-18 11:02:31',0),(12,'admin-4','7beb539163cd65c54f4ee9d8d01ab827',1,1,'2023-05-18 11:35:28',2,'2023-05-18 11:33:50','2023-05-23 14:52:44',0);

/*Table structure for table `t_user_info` */

DROP TABLE IF EXISTS `t_user_info`;

CREATE TABLE `t_user_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `age` int DEFAULT NULL COMMENT '年龄',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系地址',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

/*Data for the table `t_user_info` */

insert  into `t_user_info`(`id`,`user_id`,`name`,`gender`,`age`,`phone`,`address`,`created_time`,`updated_time`,`deleted`) values (2,2,'刘备','男',30,'15255568261','北门农业银行旁驿站','2023-04-17 13:20:26','2023-04-17 13:20:26',0),(3,3,'袁绍','男',40,'17866732183','屯溪路193号合肥工业大学','2023-04-18 15:00:16','2023-05-11 22:22:40',0),(4,4,'吕布','男',26,'17893748765','安徽省合肥市屯溪路193号合肥工业大学8号楼','2023-04-18 16:43:38','2023-04-18 16:43:38',0),(5,5,'袁术','男',55,'17366547753','东门教育超市内驿站','2023-04-27 14:22:10','2023-05-11 22:05:58',0),(6,6,'荀彧','男',45,'13878329901','南门驿站','2023-05-05 11:52:31','2023-05-05 11:52:31',0),(7,7,'陈宫','男',43,'13788886666','西门便利店旁驿站','2023-05-05 11:55:14','2023-05-05 11:55:14',0),(8,8,'张辽','男',45,'13253937931','安徽省合肥市屯溪路193号合肥工业大学6号楼','2023-05-11 20:47:56','2023-05-11 23:01:19',0),(9,9,'曹操','男',44,'15327568830','安徽省合肥市屯溪路193号合肥工业大学5号楼','2023-05-11 20:50:33','2023-05-11 23:01:23',0),(10,10,'袁潭',NULL,NULL,'13748691477',NULL,'2023-05-16 17:26:35','2023-05-16 17:26:35',0),(11,11,'王垕','男',33,'17388290283','安徽省合肥市屯溪路193号合肥工业大学9号楼','2023-05-18 11:02:31','2023-05-18 11:02:31',0),(12,12,'曹丕',NULL,NULL,'16354839283',NULL,'2023-05-18 11:33:50','2023-05-18 11:33:50',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
