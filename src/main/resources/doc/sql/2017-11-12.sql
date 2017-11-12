/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-11-12 22:23:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL COMMENT '订单id',
  `product_id` varchar(32) NOT NULL COMMENT '商品id',
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(1024) DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('13U85KQMT558S56JKE5SS95Z5GATMEV7', 'TZVC166X9U4NDJNKTNEB3NMVNGTAK2FV', 'WTVXGXTQCU1PBKJKQQ3H5GBZZ44HKZZ6', 'mobile111事实上', '100.00', '2', '5', '2017-11-12 20:19:44', '2017-11-12 20:19:44');
INSERT INTO `order_detail` VALUES ('ACU29Y23RW54CAUJP4RB9T4PTJQWNGQ1', 'HUWPDBN515DXQW2KS44KJN5X73VFNHQ7', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:35:21', '2017-11-12 17:35:21');
INSERT INTO `order_detail` VALUES ('PPU2WXHXE41VCGZJEG9CGNJYWYJ4MCWS', 'PZURDYE6GYV7KG5JXAJYKWP3958DNMAX', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:36:03', '2017-11-12 17:36:03');
INSERT INTO `order_detail` VALUES ('RDWX7F8S1J71C1UKDC3663FPQXFKMBUP', 'N6WMQK8AN1HCPF8K4FN4GB3RNMXWJ7VF', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:36:02', '2017-11-12 17:36:02');
INSERT INTO `order_detail` VALUES ('T6WGTV3D3PHUPJ8KZYBF889N6M95M54T', 'HMUEQ19XMDEWBDYJ9DW14BK2HMH1K9U3', 'WTVXGXTQCU1PBKJKQQ3H5GBZZ44HKZZ6', 'mobile111事实上', '100.00', '2', '5', '2017-11-12 20:20:07', '2017-11-12 20:20:07');
INSERT INTO `order_detail` VALUES ('TPWV91542ER7RJZKMCP3CTHJM39QNFBZ', 'GPVMQG33NU94HDGK8D686R31YJE5N9BR', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:38:34', '2017-11-12 17:38:34');
INSERT INTO `order_detail` VALUES ('TTVRU75VKYEKFJJKSDXXW5ER146WN1BM', 'H5W6595UK7BFSW7KX1TNJHKU89RWK4N2', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:35:41', '2017-11-12 17:35:41');
INSERT INTO `order_detail` VALUES ('UWV4GP293EWGJ2KKE8MZ4PNCTENSNCSF', '2ZTAZWAKPGM2SPNJ7V9P3E3XFDB3KR3S', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:38:35', '2017-11-12 17:38:35');
INSERT INTO `order_detail` VALUES ('UWW27J6BY211R23KVCC9ZYM5F3Z7KKBU', 'BRUA5AN3VSDHBA1JTFXN9HMBTZVZN2C4', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:35:41', '2017-11-12 17:35:41');
INSERT INTO `order_detail` VALUES ('WQVTGG6E8RKQF3GKESSHX54VKA3NMV11', 'UNWVMAA75YV8A2YK2HQN21NYRMTTJ6WZ', 'WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '2', '4', '2017-11-12 17:35:21', '2017-11-12 17:35:21');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(1024) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `buyer_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态,默认0下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('2ZTAZWAKPGM2SPNJ7V9P3E3XFDB3KR3S', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:38:35', '2017-11-12 17:38:35');
INSERT INTO `order_master` VALUES ('BRUA5AN3VSDHBA1JTFXN9HMBTZVZN2C4', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:35:41', '2017-11-12 17:35:41');
INSERT INTO `order_master` VALUES ('GPVMQG33NU94HDGK8D686R31YJE5N9BR', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:38:34', '2017-11-12 17:38:34');
INSERT INTO `order_master` VALUES ('H5W6595UK7BFSW7KX1TNJHKU89RWK4N2', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:35:41', '2017-11-12 17:35:41');
INSERT INTO `order_master` VALUES ('HMUEQ19XMDEWBDYJ9DW14BK2HMH1K9U3', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"ew3euwhd7sjw9diwkq\"', '200.00', '0', '0', '2017-11-12 20:20:07', '2017-11-12 20:20:07');
INSERT INTO `order_master` VALUES ('HUWPDBN515DXQW2KS44KJN5X73VFNHQ7', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:35:21', '2017-11-12 17:35:21');
INSERT INTO `order_master` VALUES ('N6WMQK8AN1HCPF8K4FN4GB3RNMXWJ7VF', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:36:02', '2017-11-12 17:36:02');
INSERT INTO `order_master` VALUES ('PZURDYE6GYV7KG5JXAJYKWP3958DNMAX', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '0', '0', '2017-11-12 17:36:03', '2017-11-12 17:36:03');
INSERT INTO `order_master` VALUES ('TBW2C5SS5DB1Q2TKVV5TR63PSS9CJK3Q', '光头强1111', '13222222222', '昌平1', '123456', '2.32', '0', '0', '2017-11-12 20:23:16', '2017-11-12 20:23:16');
INSERT INTO `order_master` VALUES ('TZVC166X9U4NDJNKTNEB3NMVNGTAK2FV', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"ew3euwhd7sjw9diwkq\"', '200.00', '0', '0', '2017-11-12 20:19:44', '2017-11-12 20:19:44');
INSERT INTO `order_master` VALUES ('UCT6F77ZFM8RMJBJJTPND2B19AANNEJZ', '光头强1111', '13222222222', '昌平1', '123456', '2.32', '0', '0', '2017-11-12 20:22:32', '2017-11-12 20:22:32');
INSERT INTO `order_master` VALUES ('UNWVMAA75YV8A2YK2HQN21NYRMTTJ6WZ', '\"张三\"', '\"18868822111\"', '\"慕课网总部\"', '\"WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N\"', '200.00', '2', '0', '2017-11-12 17:35:21', '2017-11-12 22:04:21');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_category_num` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='类目表';

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', 'test', '5', '2017-11-09 21:45:05', '2017-11-09 21:59:22');
INSERT INTO `product_category` VALUES ('2', '热销2', '10', '2017-11-09 21:58:06', '2017-11-09 22:00:36');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_desc` varchar(1024) DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(1024) DEFAULT NULL COMMENT '小图',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `product_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 正常，1下架',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('6VWZW5W4GBSRMR3K28YGSKQV4RY9NP9M', 'mobile', '100.00', '110', '1', '1', '10', '1', '2017-11-10 15:41:28', '2017-11-11 22:44:56');
INSERT INTO `product_info` VALUES ('GZW6G7Z6WTDPAD5KYYQPCZEHFF5QN44G', 'mobile', '100.00', '100', '2', '2', '10', '0', '2017-11-10 14:41:41', '2017-11-11 22:44:57');
INSERT INTO `product_info` VALUES ('PEW4V8XRYYPFQGVKK2BNRYZMHZZGKE6T', 'mobile11', '100.00', '80', '3', '3', '10', '1', '2017-11-10 14:43:31', '2017-11-12 14:33:06');
INSERT INTO `product_info` VALUES ('WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '78', '4', '4', '10', '0', '2017-11-10 14:42:38', '2017-11-12 22:04:21');
INSERT INTO `product_info` VALUES ('WTVXGXTQCU1PBKJKQQ3H5GBZZ44HKZZ6', 'mobile111事实上', '100.00', '106', '5', '5', '5', '0', '2017-11-10 15:43:56', '2017-11-12 20:20:07');
INSERT INTO `product_info` VALUES ('XSTAHN69DBGSC4HJGZBC1YAC41GSMD5A', 'mobile', '100.00', '110', null, null, '10', '1', '2017-11-12 20:28:10', '2017-11-12 20:28:10');
