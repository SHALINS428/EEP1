/*
 Navicat Premium Dump SQL

 Source Server         : shalins
 Source Server Type    : MySQL
 Source Server Version : 80035 (8.0.35)
 Source Host           : localhost:3306
 Source Schema         : symeep1

 Target Server Type    : MySQL
 Target Server Version : 80035 (8.0.35)
 File Encoding         : 65001

 Date: 03/12/2024 21:49:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `parent_id` int NULL DEFAULT NULL,
  `is_active` tinyint(1) NULL DEFAULT 1,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '家用电器', '家用电器类商品，包括电视、冰箱等', NULL, 1, '2024-12-03 15:11:04', '2024-12-03 15:11:04');
INSERT INTO `category` VALUES (2, '电视', '各类电视产品', 1, 1, '2024-12-03 15:11:04', '2024-12-03 15:11:04');
INSERT INTO `category` VALUES (3, '冰箱', '各类冰箱产品', 1, 1, '2024-12-03 15:11:04', '2024-12-03 15:11:04');
INSERT INTO `category` VALUES (4, '手机数码', '手机及数码类商品', NULL, 1, '2024-12-03 15:11:04', '2024-12-03 15:11:04');
INSERT INTO `category` VALUES (5, '智能手机', '各品牌智能手机', 4, 1, '2024-12-03 15:11:04', '2024-12-03 15:11:04');
INSERT INTO `category` VALUES (6, '电脑办公', '电脑及办公设备', NULL, 1, '2024-12-03 15:11:04', '2024-12-03 15:11:04');

SET FOREIGN_KEY_CHECKS = 1;
