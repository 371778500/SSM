package com.yonyou.entity.permission;

import java.io.Serializable;



/**
 * ½ÇÉ«ÊµÌå
 * @author luochp3
 */
 
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String code;

	private String name;
	
	public Role() {
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}