package com.yonyou.entity.permission;

import java.io.Serializable;

/**
 * 角色功能实体
 * @author luochp3
 *
 */
public class RolesMenus  implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 本实体id
	 */
	private String id;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 菜单功能id
	 */
	private String menuId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
