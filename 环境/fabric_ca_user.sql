/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 27/12/2018 16:54:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fabric_ca_user
-- ----------------------------
DROP TABLE IF EXISTS `fabric_ca_user`;
CREATE TABLE `fabric_ca_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限',
  `account` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `affiliation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `organization` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属机构',
  `enrollmentSecret` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `enrollment` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '证书',
  `msp_Id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `exp_date` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_peerOrg_unique`(`name`, `organization`) USING BTREE COMMENT '同一个机构下面一个用户名'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

alter table `fabric_ca_user` add column company_id varchar(20);

DROP TABLE IF EXISTS `collection_config`;

create table `collection_config`(
    collection_name varchar(20) not null ,
    sign_in_company varchar(20) COMMENT '签发企业ID',
    sign_out_company varchar(20) COMMENT '签收企业ID',
    financial_company varchar(20) COMMENT '金融机构ID',
    promise_company varchar(20) COMMENT '承诺付款方'
)
;
alter table `collection_config` add constraint unique_collection_config unique(sign_in_company,sign_out_company,financial_company);
