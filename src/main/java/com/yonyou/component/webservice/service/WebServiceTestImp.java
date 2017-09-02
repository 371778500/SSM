package com.yonyou.component.webservice.service;

import javax.jws.WebService;

import com.yonyou.component.webservice.service.IWebServiceTest;
import com.yonyou.component.webservice.service.UserBean;

/**
 * 实现webservice接口
 * @author luochp3
 *
 */
@WebService  
public class WebServiceTestImp implements IWebServiceTest {

	@Override
	public UserBean getInfo(String str) {
		System.out.println("这里是服务端的代码,获取的参数是："+str);
		return new UserBean(1,"lcp");
	}

}
