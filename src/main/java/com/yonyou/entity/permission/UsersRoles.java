package com.yonyou.entity.permission;

import java.io.Serializable;

/**
 * 
 * �û�����ʵ��
 * @author luochp3
 *
 */
public class UsersRoles  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ʵ��id
	 */
	private String id;
	/**
	 * �û�id	
	 */
	private String userId;
	/**
	 * ��ɫid
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
