package com.yonyou.service.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.alibaba.fastjson.JSONObject;

/**
 * 监听器继承接口MessageListener
 * @author luochp3
 *
 */
public class MyMessageListenerImpl implements MessageListener {
	
	private ActiveMQServiceImpl activeMQServiceImpl;

	@Override
	public void onMessage(Message msg){
		
//		TextMessage text = (TextMessage) msg;
		ObjectMessage obj=(ObjectMessage) msg;
        System.out.println("========收到的消息========");
        try {
        	JSONObject json=(JSONObject) obj.getObject();
            System.out.println(json.get("flag")+"===="+json.get("msg"));
            System.out.println();
            Thread.sleep(1000);
            activeMQServiceImpl.sendUserMsg("msgresult", "这是处理这条消息返回的结果："+json.get("msg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public ActiveMQServiceImpl getActiveMQServiceImpl() {
		return activeMQServiceImpl;
	}

	public void setActiveMQServiceImpl(ActiveMQServiceImpl activeMQServiceImpl) {
		this.activeMQServiceImpl = activeMQServiceImpl;
	}
	

}
