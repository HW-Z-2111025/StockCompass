/*
 Navicat Premium Data Transfer

 Source Server         : root2212165
 Source Server Type    : MySQL
 Source Server Version : 100432
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100432
 File Encoding         : 65001

 Date: 24/07/2024 13:37:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `heading` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `session` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES ('谈谈2013-2014年的A股', '现在有点像13-14年，流动性极度匮乏，场内不动，场外嫌弃，周围也没有声音讨论A股', '20240724', 'hot2', 'https://xueqiu.com/1553799558/298519176');
INSERT INTO `discuss` VALUES ('赛力斯问界7月订单“腰斩”怎么破局？', '按照孙少军在个人微博上发布的数据，截止目前，鸿蒙智行7月累计锁单1.6万至1.65万，智界S7的占比一般是1成左右，这意味着，赛力斯问界7月累计锁单1.45万至1.5万左右。结合上周赛力斯问界的累计锁单0.6万左右，预计赛力斯问界7月的累计订单2.3万至2.35万左右。', '20240724', 'hot2', 'https://xueqiu.com/6843441724/298521338');
INSERT INTO `discuss` VALUES ('地产研究之宏观篇：房价什么时候止跌企稳？', '本来答应很多读者，要把一个多月前写了一半的新城控股的“烂尾楼”研报给写完，但是因为新城控股公司目前面临的住宅销售问题不只是公司自身问题，更大的是整个房地产行业面临的困境。\r\n', '20240724', 'hot2', 'https://xueqiu.com/7815672011/298536146');
INSERT INTO `discuss` VALUES ('空头杀跌，大盘逼近2900点整数关', '四大新兴行业板块和沪深300板块联袂杀跌，周二大小盘指数大跌，九成个股下跌，两市成交维持在6', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=2309405059574150594712');
INSERT INTO `discuss` VALUES ('9块9“卷”到奶茶界，咖啡卷完这是要卷奶茶了？', '​​这些年饮品市场的红火有目共睹，在一系列的现调饮品之中，咖啡和奶茶无疑是两大品类，在这两大品类之中，咖啡率先卷起了价格战，就在咖啡的价格战打的如火如荼的时候，奶茶的价格战也开始打起来了，卷完咖啡卷奶茶我们到底该怎么看？', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=2309405059572300907054');
INSERT INTO `discuss` VALUES ('有车型降价70万元？连宾利等超豪车都被卷入价格战了？', '从去年开始，各家车企的价格战消息是不绝于耳，在这样的情况下，越来越多的车企开始被卷入价格战，不过最近被卷入的车企已经开始让人有些吃惊了，这就是超豪华车企宾利、阿斯顿马丁，为啥连超豪车都被卷入价格战了？我们该怎么看这件事？', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=23093505059571042615982');
INSERT INTO `discuss` VALUES ('暴跌元凶曝光，今天还要升级？', '昨天的下跌，至今依旧被大家耿耿于怀，一个晚上过去了，不少小伙伴还在和我吐槽。\r\n\r\n我看不少大V对昨天的暴跌也显得相当无奈，似乎这时候大家都懵了。\r\n\r\n但我思考下来，这何尝和懂王吃到的那记子弹有什么不一样，都是一种警告。', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=2309405059568630890950');
INSERT INTO `discuss` VALUES ('7.24早盘：北上资金增仓榜（附股）', '市场昨日整体疲软，但是这并没有影响外资对一些个股的买入情绪。', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=2309405059565761987028');
INSERT INTO `discuss` VALUES ('再跌也挡不住，崩溃后迎来的是什么？', '​​这两天市场这种表现，实际也是很多机构意料之内的事情，前天参加一个公募组织的投资人交流会的时候，不少私募、公募的朋友已经预料到了市场的一些变化。挑些重点和大家说说。', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=2309405059558463635908');
INSERT INTO `discuss` VALUES ('邦尼论市：这个回落蓄势有点夸张', '邦尼论市：这个回落蓄势有点夸张\r\n国际资本暴买5800亿元 ', '20240724', 'famous', 'https://weibo.com/ttarticle/p/show?id=2309405059548791570443');
INSERT INTO `discuss` VALUES ('市场人士对后市的观点与策略（07/24）', '博采众长、形成自己的策略', '20240724', 'stock', 'https://weibo.com/ttarticle/p/show?id=2309405059547286077627');
INSERT INTO `discuss` VALUES ('一日一禅（性命）', '真正的修行和感悟都应该是来源于我们的生活，所以在现实中好好修行才是最好的修行', '20240724', 'stock', 'https://weibo.com/ttarticle/p/show?id=2309405059546602143972');
INSERT INTO `discuss` VALUES ('07/24盘前观点', '昨天‬大盘低开震荡走低，昨天‬大盘跳水更多的是一种非理性的杀跌，尤其是尾盘的放量‬跳水，大量的恐慌盘被杀出来了。市场发生了多杀多，相互踩踏的现象。昨天‬中信证券也是‬大幅调整；很多散户轻信爷叔言，情绪上脑，胡乱跟风买入；这一次上海爷叔‬估计‬被喷的体无完肤了‬；该‬补牙‬的年龄‬，他‬选择‬了补‬仓‬！这‬也是‬悲催的大‬A股民‬的‬真实‬写照‬。', '20240724', 'stock', 'https://weibo.com/ttarticle/p/show?id=2309405059544756912230');
INSERT INTO `discuss` VALUES ('有望今日向上反弹', '忍耐中把握市场机会，任何时候保持平常心。', '20240724', 'stock', 'https://weibo.com/ttarticle/p/show?id=2309405059534266695683');
INSERT INTO `discuss` VALUES ('下跌背后有大动作，GJ队真不救吗？', '​​本来晚上都不想写收评了，但老粉催的紧，说今天要是看不到收评，心里就更慌了，所以先放收评。', '20240724', 'stock', 'https://weibo.com/ttarticle/p/show?id=2309405059442696913184');

SET FOREIGN_KEY_CHECKS = 1;
