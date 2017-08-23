package com.yonyou.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//import net.sf.json.JSONObject;


import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.util.DateTimeUtil;


public class SystemWebSocketHandler implements WebSocketHandler {
	ScheduledExecutorService service=null;

	//���websocket������Ϣ
	private static ArrayList<WebSocketSession> linkUsers = new ArrayList<WebSocketSession>();
	//����û���Ϣ
	private Map<String, String> userMaps = new HashMap<String, String>();

	//����websocket�ɹ�����ø÷���
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println("ConnectionEstablished");
		String id = session.getId();
		linkUsers.add(session);
		System.out.println(id + " �������ӵ��û�����:" + linkUsers.size());
	}

	//����ǰ̨����Ϣ���͹����ͻᴥ���÷���
	public void handleMessage(WebSocketSession session,WebSocketMessage<?> message) throws Exception {
		String socketInfo = (String) message.getPayload();
		System.out.println(socketInfo);
		JSONObject jsonObject =JSONObject.parseObject(socketInfo);
		String type = jsonObject.getString("type");
		if (type.equals("start")) {
			userMaps.put(session.getId(), jsonObject.getString("username"));
			skipSendMessageToUser(0);
		} else if (type.equals("gointo")) {
			skipSendMessageToUser(Integer.parseInt(jsonObject.getString("time")));
		}else if (type.equals("goouto")) {
			skipSendMessageToUser(Integer.parseInt(jsonObject.getString("time")));
		}
	}

	//���ӳ���
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		removeUser(session);
	}

	//���ӹرպ���ø÷���
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		System.out.println("ConnectionClosed");
		removeUser(session);
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	//WebSocketSession.sendMessage(message); Ϊ��̨������Ϣ���ᴥ��ǰ̨������Ϣ�ķ���
	
	
	/**
	 * �����������û�������Ϣ,�������Ϸ������ϵ�websocket
	 * 
	 * @param message
	 */
	private void sendtoAllOnlineUsers(WebSocketMessage<?> message) {
		
		for (WebSocketSession user : linkUsers) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}

	/**
	 * ��ʱ������Ϣ���û�
	 */
	private void skipSendMessageToUser(final int value){
		if(service!=null){
			service.shutdownNow();
		}
		Runnable runnable = new Runnable() {  
            public void run() {  
            	Date date=DateTimeUtil.getDate(new Date(),value,5);
            	String str=DateTimeUtil.shortFmt3(date);
            	JSONObject json=new JSONObject();
            	json.put("time", str);
            	sendtoAllOnlineUsers(new TextMessage(json.toString()));
            }  
        };  
        service = Executors.newSingleThreadScheduledExecutor(); 
        // �ڶ�������Ϊ�״�ִ�е���ʱʱ�䣬����������Ϊ��ʱִ�еļ��ʱ��  
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS); 
        
	}
	

	/**
	 * �Ͽ�����ʱ�Ƴ��û�
	 * 
	 * @param session
	 */
	private void removeUser(WebSocketSession session) {
		linkUsers.remove(session);
		userMaps.remove(session.getId());
	}
}
