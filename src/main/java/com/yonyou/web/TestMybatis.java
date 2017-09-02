package com.yonyou.web;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.component.webservice.client.IWebServiceTestProxy;
import com.yonyou.component.webservice.client.UserBean;
import com.yonyou.entity.Persion;
import com.yonyou.service.TestPersionService;

@Controller
@RequestMapping(value = "/test")
public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
	private ApplicationContext ac = null;
	@Autowired
	private TestPersionService testservice;

	
	/**
	 * 测试mybatis 
	 * @return
	 */
	@RequestMapping(value = "test1", method = RequestMethod.GET)
	@ResponseBody
	public Persion test1() {
		Persion p = new Persion();
		System.out.println(testservice.insertPersion(p));
		return p;
	}
	
	/**
	 * 测试websocket
	 * @return
	 */
	@RequestMapping(value = "websocket", method = RequestMethod.GET)
	public String pageSkip() {
		return "page/websocket/chat";
	}
	
	/**
	 * 测试webservice
	 * 客户端的调用服务端的webservice
	 * @return
	 * @throws RemoteException 
	 */

	@RequestMapping(value = "webservice", method = RequestMethod.GET)
	@ResponseBody
	public UserBean getUser() throws RemoteException {
		//通过使用自动生成的代码中的代理类进行调用webservice
		IWebServiceTestProxy proxy=new IWebServiceTestProxy();
		return proxy.getInfo("我是客户端传来的参数");
	}
}
