package com.yonyou.component.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 * ����һ��webservice�ӿ�
 * @author luochp3
 *
 */

@WebService
public interface IWebServiceTest {
	@WebMethod 
	public UserBean GetInfo(String str);
}
