package com.yonyou.service.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听器继承接口MessageListener
 * @author luochp3
 *
 */
public class MyMessageListenerImpl implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		
		TextMessage text = (TextMessage) msg;
        System.out.println("========收到的消息========");
        try {
            System.out.println(text.getText());
            System.out.println();
        } catch (JMSException e) {
            e.printStackTrace();
        }

	}

}
