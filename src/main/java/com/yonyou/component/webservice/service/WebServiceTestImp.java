package com.yonyou.component.webservice.service;

import javax.jws.WebService;

/**
 * ʵ��webservice�ӿ�
 * @author luochp3
 *
 */
@WebService  
public class WebServiceTestImp implements IWebServiceTest {

	@Override
	public UserBean GetInfo(String str) {
		return new UserBean(1,"lcp");
	}

}
