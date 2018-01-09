package com.yonyou.service.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * �������̳нӿ�MessageListener
 * @author luochp3
 *
 */
public class MyMessageListenerImpl implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		
		TextMessage text = (TextMessage) msg;
        System.out.println("========�յ�����Ϣ========");
        try {
            System.out.println(text.getText());
            System.out.println();
        } catch (JMSException e) {
            e.printStackTrace();
        }

	}

}
