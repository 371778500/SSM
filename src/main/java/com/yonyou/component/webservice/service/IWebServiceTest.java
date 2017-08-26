package com.yonyou.component.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 * 定义一个webservice接口
 * @author luochp3
 *
 */

@WebService
public interface IWebServiceTest {
	@WebMethod 
	public UserBean GetInfo(String str);
}
