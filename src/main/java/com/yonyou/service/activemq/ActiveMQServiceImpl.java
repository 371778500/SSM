package com.yonyou.service.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

import com.alibaba.fastjson.JSONObject;
/**
 * 消息发送
 * @author luochp3
 *
 */
public class ActiveMQServiceImpl implements IActiveMQService {
	
	//注入jms模板
	private JmsOperations jmsOperations;

	/**
	 * 发送消息
	 * @param msg
	 */
	@Override
	public void sendUserMsg(String queueName, final String msg) {
		final JSONObject json=new JSONObject();
		json.put("msg", msg);
		json.put("flag", "01");
		jmsOperations.send(             //发送消息
                queueName,//指定目的地
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(json);      //创建消息
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
