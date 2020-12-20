DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `is_admin` tinyint(1) DEFAULT 0 COMMENT '是否管理员（0 否、1 是）',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态：0正常、1停用、2删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_idx_user` (`user_name`),
  KEY `idx` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


