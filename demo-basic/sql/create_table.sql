CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_name` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `user_type` varchar(10) DEFAULT NULL COMMENT '用户类型（0管理端、1执行端、2企业端）',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `is_admin` tinyint(1) DEFAULT NULL COMMENT '是否管理员（0 否、1 是）',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态：0正常、1停用、2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_user` (`user_name`,`password`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

CREATE TABLE `role` (
  `role_id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_type` tinyint(3) NOT NULL COMMENT '角色类型（0 管理端、1 执行端）',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(11) DEFAULT '1' COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围',
  `status` char(1) DEFAULT '1' COMMENT '角色状态（0正常 1停用 2删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='角色表';

CREATE TABLE `user_role_rel` (
  `company_id` bigint(20) unsigned NOT NULL COMMENT '公司ID',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '角色ID',
  PRIMARY KEY (`company_id`,`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='用户角色关联表';

