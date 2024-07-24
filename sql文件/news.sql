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

 Date: 24/07/2024 13:37:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `heading` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `session` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('看好以AI为核心的算力产业链 并建议关注卫星互联网的中长期机会 | 投研报告', '甬兴证券近日发布通信行业周报：中国引领全球车联网模块，蜂窝物联网市场高速增长。', '20240723', 'invest', 'https://www.cnenergynews.cn/jinrong/2024/07/23/detail_20240723168944.html');
INSERT INTO `news` VALUES ('东兴证券：改革释放最强音 助力券业高质量发展', '党的二十届三中全会审议通过了《中共中央关于进一步全面深化改革、推进中国式现代化的决定》（以下简称《决定》）。东兴证券（601198）表示，党的二十届三中全会开启了新时代全面深化改革的实践续篇、新征程推进中国式现代化的时代新篇，是党历史上又一个新的里程碑，擘画了宏伟蓝图、发出了改革强音，是对新时代新征程举什么旗、走什么路的再宣示。', '20240723', 'finance', 'https://news.10jqka.com.cn/20240723/c660060587.shtml');
INSERT INTO `news` VALUES ('国家医保局发布DRG/DIP2.0版本 医疗信息化建设加速（附概念股）', '据国家医保局新闻发布会介绍，国家医保局组织专家研究制定了按病组为71.0%。', '20240723', 'report', 'http://stock.10jqka.com.cn/20240723/c660058777.shtml');
INSERT INTO `news` VALUES ('腾讯云推出自研服务器OS，支持国产主流CPU', '腾讯近日发布腾讯云自研服务器操作系统TencentOS Server V3，可支持鲲鹏、海光和飞腾三大国产主流CPU，并已与鲲鹏、海光分别搭建本土数据库实验室。', '20240723', 'industry', 'https://www.chinaflashmarket.com/Industry/Details/181959');
INSERT INTO `news` VALUES ('全球资产配置丨后房地产时代该如何投资？', '当前是中国家庭资产配置调整的历史性关键性窗口期。', '20240723', 'invest', 'https://mp.weixin.qq.com/s?__biz=MzU2MDcxMjA1OQ==&idx=1&mid=2247527158&sn=bb99e2452468ff93fa6ac83ec8dd8771');
INSERT INTO `news` VALUES ('国家医保局发布DRG/DIP2.0版本，A股多只概念股应声涨停', '7月23日午后，A股DRG/DIP板块大涨，思创医惠（300078）(300078.SZ)、万达信息（300168）(300168.SZ)、久远银海（002777）(002777.SZ)、国新健康（000503）(000503.SZ)等股以涨停收盘。', '20240723', 'invest', 'http://stock.10jqka.com.cn/20240723/c660067003.shtml');
INSERT INTO `news` VALUES ('铁合金：联合挺价，效果如何', '中性本周盘面震荡盘整。合金工厂报价积极性较低，个别6517#报价仍集中在6750-6900元/吨区间。锰矿贸易商集中挺价，联合声明半碳酸低于46元/吨度停止销售，加蓬低于70元/吨度停止销售，澳块低于72停止销售。', '20240723', 'invest', 'http://stock.10jqka.com.cn/20240723/c660066529.shtml');
INSERT INTO `news` VALUES ('看好以AI为核心的算力产业链 并建议关注卫星互联网的中长期机会 | 投研报告', '甬兴证券近日发布通信行业周报：中国引领全球车联网模块，蜂窝物联网市场高速增长。', '20240723', 'invest', 'https://www.cnenergynews.cn/jinrong/2024/07/23/detail_20240723168944.html');
INSERT INTO `news` VALUES ('无人驾驶网约车8大核心龙头股分析，一篇文章梳理清楚', '近年来，随着人工智能、大数据、云计算等技术的不断发展，无人驾驶网约车逐渐从试验阶段走向商业化运营。', '20240723', 'hot', 'https://mp.weixin.qq.com/s?__biz=MjM5NjEyNTI0MA==&idx=1&mid=2650707148&sn=abdfb223877730869d93b1e145d8e95e');
INSERT INTO `news` VALUES ('新沃基金陈乐华离任副总经理', '2024-07-24，新沃基金发布公告，陈乐华因工作需要，于7月23日离任公司副总经理。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660096740.shtml');
INSERT INTO `news` VALUES ('突发！特斯拉暴跌', '昨夜，美股三大指数小幅收跌。\r\n\r\n　　道指跌57.35点，跌幅为0.14%；纳指跌10.22点，跌幅为0.06%；标普500指数跌8.67点，跌幅为0.16%。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660096608.shtml');
INSERT INTO `news` VALUES ('13亿元，溢价6倍！黄金龙头竞得金矿探矿权', '7月22日，甘肃省西和县大桥一带金及多金属矿详查探矿权的网上竞拍，在经过激烈争夺后，以溢价648.33%成交。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660096609.shtml');
INSERT INTO `news` VALUES ('苏银消金、中邮消金将首次发行金融债 上半年消金公司共发行255亿元', '近日，中邮消费金融有限公司（以下简称“中邮消金”）披露2024年第一期金融债券发行文件，拟发行规模为15亿元，附带5亿元的超额发行权。据了解，这也是中邮消金首次发行金融债。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660093712.shtml');
INSERT INTO `news` VALUES ('中东土豪出手，牵手2500亿“化学茅”，合作160万吨级大项目！五部门重磅，事关电解铝，基金重仓这些概念股', '　五部门印发重磅文件，优化电解铝产业布局和产能调控。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660093619.shtml');
INSERT INTO `news` VALUES ('特斯拉盘后大跌', '特斯拉盘后大跌。\r\n\r\n　　当地时间7月23日，美股三大指数小幅收跌。谷歌与特斯拉等大型科技公司的财报成为焦点。', '20240724', 'hot', 'https://news.10jqka.com.cn/20240724/c660096352.shtml');
INSERT INTO `news` VALUES ('国务院国资委最新部署；《电解铝行业节能降碳专项行动计划》发布……重要消息还有这些', '7月22日至23日，国务院国资委举办中央企业负责人研讨班。会议强调，要以发展新质生产力为重要着力点，加快推动中央企业高质量发展。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660096124.shtml');
INSERT INTO `news` VALUES ('凌晨公布，罕见大跌', '当地时间7月23日，美股整体表现波澜不惊，中国资产出现调整，纳斯达克中国金龙指数跌近2%，热门中概股多数走低。', '20240724', 'finance', 'https://news.10jqka.com.cn/20240724/c660095989.shtml');
INSERT INTO `news` VALUES ('深夜，茅台重要发声', '7月23日晚，“贵州茅台（600519）”微信公众号发布消息，贵州茅台酒2024年半年市场工作会召开。会议明确提出，客群转型，要瞄准独角兽、专精特新、小巨人等企业，培育新能源、生物科技、数字科技等新兴产业从业者为新消费群体。', '20240724', 'hot', 'https://news.10jqka.com.cn/20240724/c660095975.shtml');
INSERT INTO `news` VALUES ('Meta发布新款强大的AI模型Llama 3.1', 'Llama3.1拥有大范围新的能力，包括改善推理以帮助处理复杂的数学问题、或即时合成一整本书。', '20240723', 'industry', 'http://stock.10jqka.com.cn/20240723/c660089504.shtml');
INSERT INTO `news` VALUES ('2024世界物联网500强峰会成功举办 陈梓萱发表主题演讲', '2024年7月19日，“2024世界物联网500强峰会”在北京盛大开幕，共同探索物联网技术的无限可能。在大会上，交通车联委员会执行主席陈梓萱发表了主题演讲，就当前中国汽车产业格局的变化和问题，以及如何应对，提出了观点。', '20240723', 'industry', 'http://field.10jqka.com.cn/20240723/c660089412.shtml');
INSERT INTO `news` VALUES ('芯片股重挫，三家芯片半导体公司公布股东询价转让定价', '7月23日，芯片半导体股重挫，多只芯片ETF和半导体ETF深跌。其中，芯片ETF（512760）、半导体设备ETF（159516）、集成电路ETF（159546）收盘分别下跌4.82%、4.99%和4.72%.', '20240723', 'industry', 'https://www.thepaper.cn/newsDetail_forward_28166670');
INSERT INTO `news` VALUES ('百度正式进军大健康产业 五款AI产品改变未来医疗方式', '2024年，百度在健康产业生态大会上推出了五款大模型应用产品。通过利用百度健康的平台和AI能力，医生可以利用碎片化时间提供义诊服务，药械企业也能够实现超7000个临床项目与10万多名患者的精准匹配，从而解决疑难和罕见疾病患者信息不对称、确诊困难、缺医少药等问题。', '20240723', 'industry', 'https://dcdv.zol.com.cn/886/8865183.html');
INSERT INTO `news` VALUES ('第二代AION V 全球上市12.98万起售 加速无图NDA普及', '7月23日，埃安首款全球战略车型——第二代AION V（埃安霸王龙）正式上市，官方指导价12.98万-18.98万元，新车定位新硬派智驾SUV。', '20240723', 'industry', 'https://internet.cnmo.com/event/777385.html');
INSERT INTO `news` VALUES ('海资周报|LPR跟随逆回购同步“降息”', '上周A股市场震荡上行，截止上周五收盘，上证综指报收2982.31点，全周上涨0.37%，在无人驾驶、半导体等板块的带动下，创业板指周涨2.49%，报收1725.49。上周三北证50指数涨超7%，上周四和上周五虽有调整，但全周涨幅仍达到4.61%。港股上周震荡下行，三大指数高开低走，恒生指数、恒生科技指数、恒生国企指数分别下跌4.79%、6.49%、5.63%。海外市场方面，上周美股震荡调整，标普500指数下跌1.97%、纳斯达克指数下跌3.65%，道琼斯工业平均指数上涨0.72%。', '20240723', 'report', 'https://mp.weixin.qq.com/s?__biz=MzA4MzEyMDAxMA==&idx=1&mid=2651225964&sn=49af48160a7b957186ec9a34e71ef08b');
INSERT INTO `news` VALUES ('瑞银证券：下半年A股估值或小幅回升 大盘股将跑赢中小盘股', '瑞银证券中国股票策略分析师孟磊表示，预期下半年推动A股市场的长线资金，主要来自ETF和保险公司，这些资金对估值的推动将是缓慢渐进式，下半年A股估值或小幅回升，不过不太可能出现大幅上涨。', '20240723', 'report', 'http://stock.10jqka.com.cn/20240723/c660067380.shtml');
INSERT INTO `news` VALUES ('华创证券能源化工24年中期策略：供给的反抗 需求的新大陆', '华创证券发布研报称，当下，国内外库存周期的错位、地产周期的长周期下行已经反映在化工行业的估值中，而从全球化工企业的盈利大幅度下行，尤其是海外头部化工企业处于盈亏平衡线附近，意味着ROE见底，由此PB-ROE双底形成。困境孕育希望，突破口来自供给的反抗，而趋势性的机会来自需求的新大陆（000997）。将过往的国内地产+美国库存周期的需求二元结构修正为中国+发达国家库存周期+亚非拉的三元结构，进而看好受到发展中国家拉动的化工品有望走出长期上行需求趋势。', '20240723', 'report', 'http://stock.10jqka.com.cn/20240723/c660064166.shtml');
INSERT INTO `news` VALUES ('中金：建议关注建设银行、农业银行、招商银行及汇丰控股等高分红银行', '中金发布研究报告称，统计第二季银行股公募基金仓位以及估值情况。银行股基金仓位为2.64%，按季上升0.28个百分点，主要受银行股表现较好影响。年初至今A股和H股银行分别升26.3%和19.4%，国有大行及部分区域行表现较好。目前银行板块整体仍被基金低配约10.5个百分点，低配程度为历史较高水平，显示银行股仍有加仓空间。', '20240723', 'report', 'http://stock.10jqka.com.cn/20240723/c660063391.shtml');
INSERT INTO `news` VALUES ('中泰证券：新一轮存款利率调降可期 投资面对银行股行情有强支撑', '中泰证券（600918）发布研报称，降息符合预期，LPR挂钩7天OMO，利率市场化进一步深化。本次LPR调降10bp对银行2024年息差影响1bp左右，对营收和税前利润分别影响0.5pcts/1.1pcts。', '20240723', 'report', 'http://stock.10jqka.com.cn/20240723/c660062701.shtml');
INSERT INTO `news` VALUES ('中银证券：创新仍为医药行业未来发展主旋律 建议关注创新药械发展机会', '中银证券（601696）发布研报称，医药板块2024上半年相对承压明显，但对下半年依然保持相对乐观。一方面，24年医药板块业绩仍会呈现“先低后高”的趋势，下半年医药板块业绩有望逐步加速；另一方面，集采实施多年后，大部分医药产品其实已经逐步进入价格平稳的窗口期，在医药行业需求仍然会保持稳定增长的情况下，医药行业未来有望逐步进入平稳的发展阶段。除此之外，市场对创新产品的需求仍然迫切，创新仍为未来发展的主旋律，建议关注创新药械发展机会。', '20240723', 'report', 'http://stock.10jqka.com.cn/20240723/c660061724.shtml');

SET FOREIGN_KEY_CHECKS = 1;
