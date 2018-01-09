package com.yonyou.service.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQConsumerService {
	
	public void getMsg(){
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
	  
	            // ���岽��ͨ��Session����MessageConsumer  
	            MessageConsumer consumer = session.createConsumer(destination);  
	  
	            while (true) {  
	                TextMessage msg = (TextMessage) consumer.receive();  
	                if (msg == null)  
	                    break;  
	                System.out.println("==========�յ������ݣ�" + msg.getText());  
	            }  
	  
	            if (connection != null) {  
	                connection.close();  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}


}
