package com.yonyou.entity.permission;



import java.io.Serializable;

/**
 * �˵�Entity
 * @author luochp3
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ��ʵ��id
	 */
	private String id;
	/**
	 * ����
	 */
	private String code;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ���ڵ�
	 */
	private String parentId;
	/**
	 * ����
	 */
	private Integer sort;
	/**
	 * ����
	 */
	private String href;
	/**
	 *  ͼ��url
	 */
	private String iconUrl;

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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if(other.getId().equals(id))
			return true;
		
		return false;
	}
	
}