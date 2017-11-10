/*
Navicat MySQL Data Transfer

Source Server         : 172.25.1.233
Source Server Version : 50720
Source Host           : 172.25.1.233:3306
Source Database       : sell

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-11-10 18:37:02
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

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名称',
  `category_num` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_category_num` (`category_num`)
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
  `priduct_icon` varchar(1024) DEFAULT NULL COMMENT '小图',
  `category_num` int(11) NOT NULL COMMENT '类目编号',
  `product_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 正常，1下架',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('6VWZW5W4GBSRMR3K28YGSKQV4RY9NP9M', 'mobile', '100.00', '110', null, null, '10', '1', '2017-11-10 15:41:28', '2017-11-10 15:41:28');
INSERT INTO `product_info` VALUES ('GZW6G7Z6WTDPAD5KYYQPCZEHFF5QN44G', 'mobile', '100.00', '100', null, null, '10', '0', '2017-11-10 14:41:41', '2017-11-10 14:41:41');
INSERT INTO `product_info` VALUES ('PEW4V8XRYYPFQGVKK2BNRYZMHZZGKE6T', 'mobile', '100.00', '110', null, null, '10', '1', '2017-11-10 14:43:31', '2017-11-10 14:43:31');
INSERT INTO `product_info` VALUES ('WJT2PQ64CYBBDKEJ5914GSWRWCFEM79N', 'mobile', '100.00', '100', null, null, '10', '1', '2017-11-10 14:42:38', '2017-11-10 14:42:38');
INSERT INTO `product_info` VALUES ('WTVXGXTQCU1PBKJKQQ3H5GBZZ44HKZZ6', 'mobile', '100.00', '110', null, null, '10', '1', '2017-11-10 15:43:56', '2017-11-10 15:43:56');
