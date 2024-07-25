SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    header VARCHAR(255)
);