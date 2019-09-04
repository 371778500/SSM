package com.yonyou.service.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消息发送测试使用
 * @author luochp3
 *
 */

@Service
public class MQService {

	@Autowired
	private ActiveMQServiceImpl activeMQServiceImpl;
	
	//消息发送
	public void sendMsg(){
		for (int i = 0; i < 500000; i++) { 
			activeMQServiceImpl.sendUserMsg("myQueue","这是发送的消息"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
