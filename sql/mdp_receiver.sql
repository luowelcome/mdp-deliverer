
CREATE TABLE IF NOT EXISTS `t_msg_templates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模板的ID',
  `code` VARCHAR(40) NOT NULL COMMENT '模板的code, 是唯一的',
  `name` VARCHAR(40) NOT NULL COMMENT '模板的名称',
  `content` VARCHAR(2000) NOT NULL COMMENT '模板的内容',
  `template_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '模板的类型',
  `description` VARCHAR(200) COMMENT '模板的描述',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '模板的状态',
  `version_num` int(20) NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `created_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '创建者',
  `created_at` DATETIME NOT NULL COMMENT '创建时间',
  `updated_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '更新者',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_msg_temp_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT='消息的模板表';

insert into `t_msg_templates` (`code`,`name`,`content`,`description`,`created_at`) values ('sales-test','sales-test','亲爱的 $userName: 你账户上收到一张价值 $rmbNumber人民币的礼券，请尽情享用，谢谢!','sales-test',now());
insert into `t_msg_templates` (`code`,`name`,`content`,`description`,`created_at`) values ('sales-test1','sales-test1','Dear $userName: You will get $rmbNumber RMB for the gift! Thanks!','sales-test1',now());


CREATE TABLE IF NOT EXISTS `t_msg_channels` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '渠道ID',
  `code` VARCHAR(40) NOT NULL COMMENT '渠道code, 是唯一的',
  `name` VARCHAR(40) NOT NULL COMMENT '渠道名称',
  `channel_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '渠道的类型',
  `description` VARCHAR(200) COMMENT '渠道描述',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '渠道的状态',
  `version_num` int(20) NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `created_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '创建者',
  `created_at` DATETIME NOT NULL COMMENT '创建时间',
  `updated_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '更新者',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mt_msg_channels_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT='消息的渠道表';



CREATE TABLE IF NOT EXISTS `t_msg_temp_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `temp_code` VARCHAR(40) NOT NULL COMMENT '模板的code, 是唯一的',
  `channel_code` VARCHAR(40) NOT NULL COMMENT '渠道的code, 是唯一的',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态',
  `version_num` int(20) NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `created_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '创建者',
  `created_at` DATETIME NOT NULL COMMENT '创建时间',
  `updated_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '更新者',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `t_msg_temp_channel_codes` (`temp_code`,`channel_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT='消息的模板与渠道的关联表';



CREATE TABLE IF NOT EXISTS `t_inner_messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `template_code` VARCHAR(40) NOT NULL COMMENT '模板的代码',
  `reference_type` VARCHAR(100) NOT NULL COMMENT '消息引用者的类型',
  `reference_id` VARCHAR(100) NOT NULL COMMENT '消息引用者的id',
  `content` VARCHAR(2000) NOT NULL COMMENT '消息的内容',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '消息的状态',
  `version_num` int(20) NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `created_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '创建者',
  `created_at` DATETIME NOT NULL COMMENT '创建时间',
  `updated_by` VARCHAR(40) NOT NULL DEFAULT '' COMMENT '更新者',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间间',
  PRIMARY KEY (`id`),
  KEY `t_inner_msg_temp_code` (`template_code`),
  KEY `t_inner_msg_ref_type_id` (`reference_type`,`reference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT '站内信的消息表';

