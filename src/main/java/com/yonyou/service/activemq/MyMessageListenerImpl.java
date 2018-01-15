package com.yonyou.service.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.alibaba.fastjson.JSONObject;

/**
 * �������̳нӿ�MessageListener
 * @author luochp3
 *
 */
public class MyMessageListenerImpl implements MessageListener {
	
	private ActiveMQServiceImpl activeMQServiceImpl;

	@Override
	public void onMessage(Message msg){
		
//		TextMessage text = (TextMessage) msg;
		ObjectMessage obj=(ObjectMessage) msg;
        System.out.println("========�յ�����Ϣ========");
        try {
        	JSONObject json=(JSONObject) obj.getObject();
            System.out.println(json.get("flag")+"===="+json.get("msg"));
            System.out.println();
            Thread.sleep(1000);
            activeMQServiceImpl.sendUserMsg("msgresult", "���Ǵ���������Ϣ���صĽ����"+json.get("msg"));
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
