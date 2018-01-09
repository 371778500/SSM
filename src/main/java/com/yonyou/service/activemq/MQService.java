package com.yonyou.service.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ��Ϣ���Ͳ���ʹ��
 * @author luochp3
 *
 */

@Service
public class MQService {

	@Autowired
	private ActiveMQServiceImpl activeMQServiceImpl;
	
	//��Ϣ����
	public void sendMsg(){
		for (int i = 0; i < 500000; i++) { 
			activeMQServiceImpl.sendUserMsg("myQueue","���Ƿ��͵���Ϣ"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
