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

	//存放websocket连接信息
	private static ArrayList<WebSocketSession> linkUsers = new ArrayList<WebSocketSession>();
	//存放用户信息
	private Map<String, String> userMaps = new HashMap<String, String>();

	//连接websocket成功后调用该方法
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println("ConnectionEstablished");
		String id = session.getId();
		linkUsers.add(session);
		System.out.println(id + " 当期连接的用户数量:" + linkUsers.size());
	}

	//监听前台有消息发送过来就会触发该方法
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

	//连接出错
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		removeUser(session);
	}

	//连接关闭后调用该方法
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		System.out.println("ConnectionClosed");
		removeUser(session);
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	//WebSocketSession.sendMessage(message); 为后台发送消息，会触发前台监听消息的方法
	
	
	/**
	 * 给所有在线用户发送消息,及连接上服务器上的websocket
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
	 * 定时发送消息给用户
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
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS); 
        
	}
	

	/**
	 * 断开连接时移除用户
	 * 
	 * @param session
	 */
	private void removeUser(WebSocketSession session) {
		linkUsers.remove(session);
		userMaps.remove(session.getId());
	}
}
