/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : dota2

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-03-30 16:47:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `file_type` varchar(50) NOT NULL COMMENT '文件类型',
  `file_name` varchar(150) NOT NULL COMMENT '文件名称',
  `upload_date` datetime NOT NULL COMMENT '上传时间',
  `upload_user_id` bigint(20) unsigned NOT NULL COMMENT '上传用户',
  `file_address` varchar(255) NOT NULL COMMENT '文件地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建日期',
  `last_updated` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- ----------------------------
-- Table structure for button
-- ----------------------------
DROP TABLE IF EXISTS `button`;
CREATE TABLE `button` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `button_name` varchar(20) NOT NULL COMMENT '按钮名称',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `row_no` int(10) unsigned NOT NULL COMMENT '排序号,用于按钮排序',
  `icon` varchar(35) DEFAULT NULL,
  `position` varchar(5) NOT NULL DEFAULT 'TOP' COMMENT '按钮位置 TOP 顶部, RIGHT 列表操作栏',
  `click` varchar(50) NOT NULL COMMENT '点击触发的函数名称',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建日期',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `button_menu_id_index` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='按钮表';

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门',
  `row_no` int(10) unsigned NOT NULL COMMENT '排序号',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建日期',
  `last_updated` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_name_unique_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for dict_member
-- ----------------------------
DROP TABLE IF EXISTS `dict_member`;
CREATE TABLE `dict_member` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `description` varchar(100) DEFAULT NULL COMMENT '字典描述',
  `val` varchar(100) NOT NULL COMMENT '字典值',
  `sort` int(10) unsigned NOT NULL COMMENT '排序号',
  `dict_name` varchar(100) NOT NULL COMMENT '字典名称',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `dict_member_dict_name_sort_index` (`dict_name`,`sort`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for enterprise_portal_info
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_portal_info`;
CREATE TABLE `enterprise_portal_info` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `content` text NOT NULL COMMENT 'json值',
  `remark` varchar(255) DEFAULT NULL COMMENT '配置说明',
  `activated` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否激活此配置',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='企业门户信息配置';

-- ----------------------------
-- Table structure for faq
-- ----------------------------
DROP TABLE IF EXISTS `faq`;
CREATE TABLE `faq` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `question` varchar(200) NOT NULL COMMENT '问题',
  `answer` text NOT NULL COMMENT '答案',
  `type` varchar(50) NOT NULL COMMENT '归类',
  `sort` int(10) unsigned NOT NULL COMMENT '序号',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for interface_definition
-- ----------------------------
DROP TABLE IF EXISTS `interface_definition`;
CREATE TABLE `interface_definition` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `module` varchar(50) NOT NULL COMMENT '模块名称',
  `code` varchar(100) NOT NULL COMMENT '接口代码',
  `description` varchar(100) NOT NULL COMMENT '接口描述',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  PRIMARY KEY (`id`),
  KEY `interface_definition_module_last_updated_index` (`module`,`last_updated`) USING BTREE COMMENT '接口模块,修改时间索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='接口定义主表';

-- ----------------------------
-- Table structure for interface_param
-- ----------------------------
DROP TABLE IF EXISTS `interface_param`;
CREATE TABLE `interface_param` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `code` varchar(100) NOT NULL COMMENT '参数',
  `description` varchar(100) NOT NULL COMMENT '参数说明',
  `interface_id` bigint(20) unsigned NOT NULL COMMENT '归属接口ID',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '归属的上级参数ID',
  `required` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否必填',
  `data_type` varchar(20) NOT NULL COMMENT '数据类型',
  `default_value` varchar(50) DEFAULT NULL COMMENT '默认值',
  `requested` bit(1) NOT NULL COMMENT '1 请求参数, 0 响应参数',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `interface_param_interface_id_index` (`interface_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='接口参数';

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '职位名称',
  `department_id` bigint(20) NOT NULL COMMENT '所属部门',
  `row_no` int(10) unsigned NOT NULL COMMENT '排序号',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`),
  KEY `job_department_id_index` (`department_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='职位';

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `menu_name` varchar(15) NOT NULL COMMENT '菜单名称',
  `path` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `component` varchar(100) DEFAULT NULL COMMENT '组件名称',
  `vue_name` varchar(40) DEFAULT NULL COMMENT '菜单在vue中的name',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `row_no` int(10) unsigned NOT NULL COMMENT '排序号,用于菜单排序',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `redirect` varchar(50) DEFAULT NULL COMMENT '面包屑跳转路径',
  `affix` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否常驻tab',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  `hidden` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否隐藏(指左侧边栏)',
  `keep_alive` bit(1) DEFAULT b'1' COMMENT '是否缓存页面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) unsigned NOT NULL,
  `message_id` bigint(20) unsigned NOT NULL COMMENT '消息内容表ID',
  `receiver_id` bigint(20) unsigned NOT NULL COMMENT '接收人用户ID',
  `sender_id` bigint(20) unsigned NOT NULL COMMENT '发送人用户ID',
  `status` varchar(20) NOT NULL DEFAULT 'UN_READ' COMMENT '消息状态',
  `query_id` varchar(42) NOT NULL COMMENT '查询标识,由receiver_id 和 sender_id组合而成,按字典排序',
  `type` varchar(20) NOT NULL COMMENT '消息类型枚举',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`),
  KEY `message_receiver_id_type_status` (`receiver_id`,`type`,`status`) USING BTREE COMMENT '接收人_消息状态索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息表';

-- ----------------------------
-- Table structure for message_content
-- ----------------------------
DROP TABLE IF EXISTS `message_content`;
CREATE TABLE `message_content` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `type` varchar(20) NOT NULL COMMENT '消息类型枚举',
  `content` text NOT NULL COMMENT '消息内容',
  `title` varchar(100) NOT NULL COMMENT '消息标题',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `template_id` bigint(20) DEFAULT NULL COMMENT '系统消息对应的模版ID',
  PRIMARY KEY (`id`),
  KEY `message_content_type_template_id_date_created_index` (`type`,`template_id`,`date_created`) USING BTREE COMMENT '消息类型索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息内容表';

-- ----------------------------
-- Table structure for message_template
-- ----------------------------
DROP TABLE IF EXISTS `message_template`;
CREATE TABLE `message_template` (
  `id` bigint(20) unsigned NOT NULL,
  `code` varchar(35) NOT NULL COMMENT '模版编码',
  `name` varchar(35) NOT NULL COMMENT '模版名称',
  `template` varchar(255) NOT NULL COMMENT '模版字符串',
  `whether_need_format` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否需要格式化',
  `type` varchar(35) NOT NULL COMMENT '消息分类',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建日期',
  `last_updated` datetime NOT NULL COMMENT '最后修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息模版';

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL,
  `permission_name` varchar(50) NOT NULL COMMENT '权限名称',
  `permission_code` varchar(50) NOT NULL COMMENT '权限编码(对应后端接口)',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '上级权限',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- ----------------------------
-- Table structure for request_head
-- ----------------------------
DROP TABLE IF EXISTS `request_head`;
CREATE TABLE `request_head` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `interface_id` bigint(20) unsigned NOT NULL COMMENT '接口ID',
  `code` varchar(100) NOT NULL COMMENT '参数',
  `required` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否必填',
  `default_value` varchar(100) DEFAULT NULL COMMENT '默认值',
  `description` varchar(100) DEFAULT NULL COMMENT '参数说明',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='请求头';

-- ----------------------------
-- Table structure for role_button
-- ----------------------------
DROP TABLE IF EXISTS `role_button`;
CREATE TABLE `role_button` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `button_id` bigint(20) unsigned NOT NULL COMMENT '按钮ID',
  PRIMARY KEY (`id`),
  KEY `role_button_role_id_button_id_index` (`role_id`,`button_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色按钮关联表';

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) unsigned NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`),
  KEY `role_menu_role_id_menu_id_index` (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表';

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `permission_id` bigint(20) unsigned NOT NULL COMMENT '权限ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `role_permission_role_id_permission_id_index` (`role_id`,`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';

-- ----------------------------
-- Table structure for status_log
-- ----------------------------
DROP TABLE IF EXISTS `status_log`;
CREATE TABLE `status_log` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `operator_id` bigint(20) unsigned NOT NULL COMMENT '操作人ID',
  `change_date` datetime NOT NULL COMMENT '状态变更时间',
  `remark` varchar(150) DEFAULT NULL COMMENT '备注',
  `status` varchar(50) NOT NULL COMMENT '状态',
  `entity_id` bigint(20) unsigned NOT NULL COMMENT '关联实体ID,根据类型区分',
  `entity_class_name` varchar(50) NOT NULL COMMENT '关联实体类名',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  PRIMARY KEY (`id`),
  KEY `audit_record_entity_id_entity_class_name_change_date` (`entity_id`,`entity_class_name`,`change_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审核记录表';

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '配置名称',
  `code` varchar(50) NOT NULL COMMENT '配置编码',
  `val` text NOT NULL COMMENT '配置值',
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `date_created` datetime NOT NULL COMMENT '创建日期',
  `last_updated` datetime NOT NULL COMMENT '最后更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置';

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `role_code` varchar(60) NOT NULL COMMENT '角色编码',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `date_created` datetime NOT NULL COMMENT '创建日期',
  `last_updated` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `username` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名,手机号',
  `register_date` datetime NOT NULL COMMENT '注册日期',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '逻辑删除位',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `last_password_reset_date` datetime DEFAULT NULL COMMENT '最后密码重置时间',
  `status` varchar(20) NOT NULL DEFAULT 'NORMAL' COMMENT '用户状态',
  `date_created` datetime NOT NULL COMMENT '创建时间',
  `last_updated` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `system_user_user_name_unique_index` (`username`) USING BTREE COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `user_role_user_id_role_id_index` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

