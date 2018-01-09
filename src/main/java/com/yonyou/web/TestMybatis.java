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
import com.yonyou.service.activemq.MQService;

@Controller
@RequestMapping(value = "/test")
public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
	private ApplicationContext ac = null;
	@Autowired
	private TestPersionService testservice;
	@Autowired
	private MQService mqService;
//	@Autowired
//	private ActiveMQConsumerService activeMQConsumerService;
	

	/**
	 * ����mybatis 
	 * @return
	 */
	@RequestMapping(value = "activemq", method = RequestMethod.GET)
	@ResponseBody
	public String activemq() {
		mqService.sendMsg();
		return "true";
	}
	
	/**
	 * ����mybatis 
	 * @return
	 */
	@RequestMapping(value = "consumermq", method = RequestMethod.GET)
	@ResponseBody
	public void consumermq() {
		//activeMQConsumerService.getMsg();
	}
	/**
	 * ����mybatis 
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
	 * ����websocket
	 * @return
	 */
	@RequestMapping(value = "websocket", method = RequestMethod.GET)
	public String pageSkip() {
		return "page/websocket/chat";
	}
	
	/**
	 * ����webservice
	 * �ͻ��˵ĵ��÷���˵�webservice
	 * @return
	 * @throws RemoteException 
	 */

	@RequestMapping(value = "webservice", method = RequestMethod.GET)
	@ResponseBody
	public UserBean getUser() throws RemoteException {
		//ͨ��ʹ���Զ����ɵĴ����еĴ�������е���webservice
		IWebServiceTestProxy proxy=new IWebServiceTestProxy();
		return proxy.getInfo("���ǿͻ��˴����Ĳ���");
	}
}
