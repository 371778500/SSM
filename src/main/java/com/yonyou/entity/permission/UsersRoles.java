package com.yonyou.entity.permission;

import java.io.Serializable;

/**
 * 
 * 用户功能实体
 * @author luochp3
 *
 */
public class UsersRoles  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 本实体id
	 */
	private String id;
	/**
	 * 用户id	
	 */
	private String userId;
	/**
	 * 角色id
	 */
	private String roleId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
