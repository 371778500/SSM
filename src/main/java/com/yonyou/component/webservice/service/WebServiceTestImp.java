package com.yonyou.component.webservice.service;

import javax.jws.WebService;

import com.yonyou.component.webservice.service.IWebServiceTest;
import com.yonyou.component.webservice.service.UserBean;

/**
 * ʵ��webservice�ӿ�
 * @author luochp3
 *
 */
@WebService  
public class WebServiceTestImp implements IWebServiceTest {

	@Override
	public UserBean getInfo(String str) {
		System.out.println("�����Ƿ���˵Ĵ���,��ȡ�Ĳ����ǣ�"+str);
		return new UserBean(1,"lcp");
	}

}
