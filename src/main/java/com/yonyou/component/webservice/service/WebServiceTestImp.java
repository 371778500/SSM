package com.yonyou.component.webservice.service;

import javax.jws.WebService;

/**
 * 实现webservice接口
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
