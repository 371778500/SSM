package com.yonyou.entity.permission;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * �û�ʵ�� ����ʱ���ã�
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String userName;

	private String enable;

	private String name;

	private String password;
	
	private String salt;
	
	// �趨JSON���л�ʱ�����ڸ�ʽ
	private Date registerDate;
	
	// �趨JSON���л�ʱ�����ڸ�ʽ
	private Date updateDate;
	
	//���У���룬�����һ�����
	private String validateCode;
	
	//���ڴ洢������id
	private String processId;
	
	//������״̬ 1:δͬ��   0����ͬ��
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

	// ���־û������ݿ⣬Ҳ����ʾ��Restful�ӿڵ�����.
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