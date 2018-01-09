package com.yonyou.service.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

public class ActiveMQServiceImpl implements IActiveMQService {
	
	//ע��jmsģ��
	private JmsOperations jmsOperations;

	/**
	 * ������Ϣ
	 * @param msg
	 */
	@Override
	public void sendUserMsg(String queueName, final String msg) {
		jmsOperations.send(             //������Ϣ
                queueName,//ָ��Ŀ�ĵ�
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(msg);      //������Ϣ
                    }
                }
            );
	}

	public JmsOperations getJmsOperations() {
		return jmsOperations;
	}

	public void setJmsOperations(JmsOperations jmsOperations) {
		this.jmsOperations = jmsOperations;
	}

}
