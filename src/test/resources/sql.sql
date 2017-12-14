
CREATE TABLE `app_zf_cache` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `inner_code` varchar(11) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '售卖机编码',
  `menu` text CHARACTER SET utf8mb4 COMMENT '下单请求的参数',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付类型',
  `from_today` int(1) DEFAULT NULL COMMENT '是否当日',
  `mdse_id` int(15) DEFAULT NULL COMMENT '商品id',
  `main_order_id` int(15) DEFAULT NULL COMMENT '主订单id',
  `out_trade_no` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商户订单号',
  `channel` int(1) DEFAULT NULL COMMENT '1:小程序 2：速冻机',
  `mdse_name` varchar(15) DEFAULT NULL COMMENT '商品名称',
  `openid` varchar(128) DEFAULT NULL COMMENT '用户标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `app_common_problem` (
  `problem_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题ID',
  `problem_title` varchar(255) DEFAULT NULL COMMENT '问题标题',
  `problem_content` varchar(255) DEFAULT NULL COMMENT '问题内容',
  `parent_id` varchar(100) DEFAULT NULL COMMENT '父级ID',
  `problem_order` varchar(100) DEFAULT NULL COMMENT '问题顺序',
  PRIMARY KEY (`problem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='常见问题表';


ALTER TABLE `sanquan`.`app_invoice` ADD COLUMN `dutyNumber` INT(15) NULL COMMENT '税号';
ALTER TABLE `sanquan`.`app_invoice` ADD COLUMN `companySelf` INT(1) NULL COMMENT '0：公司 1：个人';
ALTER TABLE `sanquan`.`app_invoice` ADD COLUMN `area` VARCHAR(20) NULL COMMENT '所属区域';
