package com.yonyou.service.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * �������̳нӿ�MessageListener
 * @author luochp3
 *
 */
public class MyMessageListenerImpl implements MessageListener {
	
	private ActiveMQServiceImpl activeMQServiceImpl;

	@Override
	public void onMessage(Message msg){
		
		TextMessage text = (TextMessage) msg;
        System.out.println("========�յ�����Ϣ========");
        try {
            System.out.println(text.getText());
            System.out.println();
            Thread.sleep(1000);
            activeMQServiceImpl.sendUserMsg("msgresult", "���Ǵ���������Ϣ���صĽ����"+text.getText());
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
