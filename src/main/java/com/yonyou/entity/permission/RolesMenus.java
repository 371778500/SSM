package com.yonyou.entity.permission;

import java.io.Serializable;

/**
 * ��ɫ����ʵ��
 * @author luochp3
 *
 */
public class RolesMenus  implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * ��ʵ��id
	 */
	private String id;
	/**
	 * ��ɫid
	 */
	private String roleId;
	/**
	 * �˵�����id
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
