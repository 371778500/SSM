package com.yonyou.service.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQProducerService {
	
	public void sendMsg(String msg){
		 try {  
	            // ��һ��������ConnectionFactory����������Ҫ�����û��������롢�Լ�Ҫ���ӵĵ�ַ����ʹ��Ĭ�ϼ��ɣ�Ĭ�϶˿�Ϊ"tcp://localhost:61616"  
	            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin",  
	                    "failover:(tcp://localhost:61616)?Randomize=false");  
	  
	            // �ڶ�����ͨ��ConnectionFactory�����������Ǵ���һ��Connection���ӣ����ҵ���Connection��start�����������ӣ�ConnectionĬ���ǹرյġ�  
	            Connection connection = connectionFactory.createConnection();  
	            connection.start();  
	  
	            // ��������ͨ��Connection���󴴽�Session�Ự�������Ļ������󣩣����ڽ�����Ϣ����������1Ϊ�Ƿ����������񣬲�������2Ϊǩ��ģʽ��һ�����������Զ�ǩ�ա�  
	            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);  
	  
	            // ���Ĳ���ͨ��Session����Destination����ָ����һ���ͻ�������ָ��������ϢĿ���������Ϣ��Դ�Ķ�����PTPģʽ�У�Destination������Queue�����У�
	            // ��Pub/Subģʽ��Destination������Topic�����⡣�ڳ����п���ʹ�ö��Queue��Topic��  
	            Destination destination = session.createQueue("myQueue");  
	  
	            // ���岽��������Ҫͨ��Session���󴴽���Ϣ�ķ��ͺͽ��ն��������ߺ������ߣ�MessageProducer/MessageConsumer��  
	            MessageProducer producer = session.createProducer(null);  
	  
	            // �����������ǿ���ʹ��MessageProducer��setDeliveryMode����Ϊ�����ó־û����Ժͷǳ־û����ԣ�DeliveryMode���������Ժ���ϸ���ܡ�  
	             producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
	  
	            // ���߲����������ʹ��JMS�淶��TextMessage��ʽ�������ݣ�ͨ��Session���󣩣�����MessageProducer��send�����������ݡ�ͬ��ͻ���ʹ��receive�������н������ݡ����Ҫ���ǹر�Connection���ӡ�  
	  
	            for (int i = 0; i < 500000; i++) {  
	                TextMessage msg2 = session.createTextMessage("�����ҷ��͵���Ϣ����" + i);  
	                // ��һ������Ŀ���ַ  
	                // �ڶ������� �����������Ϣ  
	                // ���������� �������ݵ�ģʽ  
	                // ���ĸ����� ���ȼ�  
	                // ��������� ��Ϣ�Ĺ���ʱ��  
	                producer.send(destination, msg2, DeliveryMode.NON_PERSISTENT, 0, 1000L);  
	                System.out.println("������Ϣ��" + msg2.getText());  
	                Thread.sleep(1000);  
	  
	            }  
	  
	            if (connection != null) {  
	                connection.close();  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}

}
