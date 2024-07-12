-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('终端用户', '3', '1', 'user', 'cuser/user/index', 1, 0, 'C', '0', '0', 'cuser:user:list', '#', 'admin', sysdate(), '', null, '终端用户菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('终端用户查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'cuser:user:query',        '#', 'admin', sysdate(), '', null, '');

-- insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
-- values('终端用户新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'cuser:user:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('终端用户修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'cuser:user:edit',         '#', 'admin', sysdate(), '', null, '');

-- insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
-- values('终端用户删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'cuser:user:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('终端用户导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'cuser:user:export',       '#', 'admin', sysdate(), '', null, '');