/*
 Navicat Premium Data Transfer

 Source Server         : local-3316
 Source Server Type    : MySQL
 Source Server Version : 50724 (5.7.24)
 Source Host           : 127.0.0.1:3316
 Source Schema         : airr_db

 Target Server Type    : MySQL
 Target Server Version : 50724 (5.7.24)
 File Encoding         : 65001

 Date: 10/07/2024 21:15:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ais_answer
-- ----------------------------
DROP TABLE IF EXISTS `ais_answer`;
CREATE TABLE `ais_answer`  (
  `answer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回答ID',
  `answer_uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '回答UUID 用于前端缓存',
  `tid` bigint(20) NOT NULL COMMENT '课题ID',
  `cid` bigint(20) NULL DEFAULT 0 COMMENT '填报用户ID',
  `custom_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '填报人姓名',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '性别',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '地址',
  `ip` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'IP',
  `is_draft` tinyint(3) UNSIGNED NULL DEFAULT 1 COMMENT '是否草稿状态',
  `collect_json` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '自动采集JSON',
  `extra_json` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '回答扩展JSON',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '填报主信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ais_answer_item
-- ----------------------------
DROP TABLE IF EXISTS `ais_answer_item`;
CREATE TABLE `ais_answer_item`  (
  `answer_id` bigint(20) NOT NULL COMMENT '回答ID',
  `item_id` bigint(20) NOT NULL COMMENT 'ITEM ID',
  `tid` bigint(20) NOT NULL COMMENT '课题ID',
  `answer_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '回答选项code',
  `answer` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '回答内容',
  PRIMARY KEY (`answer_id`, `item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '题目填报内容' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ais_company
-- ----------------------------
DROP TABLE IF EXISTS `ais_company`;
CREATE TABLE `ais_company`  (
  `comp_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司ID',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '唯一ID',
  `logo` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'Logo',
  `official_website` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '官网',
  `sortno` int(11) NULL DEFAULT 0 COMMENT '排序',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `contact` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '联系人',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '状态[0停用 1正常]',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`comp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ais_company_user_rela
-- ----------------------------
DROP TABLE IF EXISTS `ais_company_user_rela`;
CREATE TABLE `ais_company_user_rela`  (
  `comp_id` bigint(20) NOT NULL COMMENT '公司ID',
  `uid` bigint(20) NOT NULL COMMENT '用户ID(sys_user)',
  PRIMARY KEY (`comp_id`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ais_topic
-- ----------------------------
DROP TABLE IF EXISTS `ais_topic`;
CREATE TABLE `ais_topic`  (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课题ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '唯一编号',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `logo` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'Logo',
  `banner` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'Banner',
  `ref_website` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '关联站点',
  `sortno` int(11) NULL DEFAULT 0 COMMENT '排序',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `contact` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '联系人',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `is_login` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '是否需要登录',
  `submission_times` int(10) UNSIGNED NULL DEFAULT 1 COMMENT '允许填报次数默认1次',
  `status` int(11) NULL DEFAULT 1 COMMENT '审核状态[0草稿 1审核中 2 上线  9撤销]',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `uid` bigint(20) NOT NULL COMMENT '所属用户(sys_user)',
  `comp_id` bigint(20) NOT NULL COMMENT '公司ID',
  `head_html` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'head html',
  `foot_html` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'foot html',
  `load_type` tinyint(4) NULL DEFAULT 0 COMMENT '0 一次行加载,10 分页加载 每页十条',
  `template_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'temp_default' COMMENT '使用模版',
  `extra_json` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '扩展信息',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '民调主题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ais_topic_item
-- ----------------------------
DROP TABLE IF EXISTS `ais_topic_item`;
CREATE TABLE `ais_topic_item`  (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ITEM ID',
  `tid` bigint(20) NOT NULL COMMENT '课题ID',
  `no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '编号',
  `sortno` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '排序',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '后台名称',
  `label` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '显示题目',
  `help_doc` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '题目提示',
  `issue_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '问题类型[multi_check 多选 single_check 单选,single_select 下拉单选, text_input 填写内容,textarea_input 填写内容,region_select 行政区 ]',
  `is_required` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '是否必须',
  `el_rule` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '前端UI规则JSON',
  `el_option` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '下拉内容JSON',
  `extra_json` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '扩展JSON',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态[0 不显示 1显示]',
  `comp_id` bigint(20) NOT NULL COMMENT '公司ID',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '民调题目' ROW_FORMAT = Dynamic;
