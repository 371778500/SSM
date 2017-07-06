package com.yonyou.entity.test;

import java.util.Date;

public class Persion {
	private Integer id;

	private String cn;

	private String en;

	private Integer age;

	public Persion() {
		this.setId(new Date().getSeconds());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn == null ? null : cn.trim();
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en == null ? null : en.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}