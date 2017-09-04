package com.yonyou.entity.permission;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * 用户实体 （暂时不用）
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String userName;

	private String enable;

	private String name;

	private String password;
	
	private String salt;
	
	// 设定JSON序列化时的日期格式
	private Date registerDate;
	
	// 设定JSON序列化时的日期格式
	private Date updateDate;
	
	//随机校验码，用于找回密码
	private String validateCode;
	
	//用于存储审批流id
	private String processId;
	
	//审批流状态 1:未同步   0：已同步
	private char processState;
	
	private String dr;

	private String remark;
	
	private String plainPassword;
	
	private long loginTs;

	public User() {
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDr() {
		return this.dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public String getProcessId() {
		return processId;
	}


	public void setProcessId(String processId) {
		this.processId = processId;
	}


	public char getProcessState() {
		return processState;
	}


	public void setProcessState(char processState) {
		this.processState = processState;
	}


	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
	
	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

	// 不持久化到数据库，也不显示在Restful接口的属性.
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }
    
    
    public long getLoginTs() {
        return loginTs;
    }

    public void setLoginTs(long loginTs) {
        this.loginTs = loginTs;
    }
    
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    

}