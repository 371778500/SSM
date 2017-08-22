package com.yonyou.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;


public class SystemWebSocketHandler implements WebSocketHandler {

	private static ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();
	private Map<String, String> userMaps = new HashMap<String, String>();

	// private ArrayList<HashMap> userMaps = new ArrayList<HashMap>();

	//连接websocket成功后调用该方法
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println("ConnectionEstablished");
		String i = session.getId();
		System.out.println(i + " user size:" + users.size());
		users.add(session);
	}

	//监听前台有消息发送过来就会触发该方法
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		String schatMessage = (String) message.getPayload();
		System.out.println(schatMessage);
		JSONObject jsonObject = JSONObject.fromObject(schatMessage);
		ChatMessage bean = (ChatMessage) JSONObject.toBean(jsonObject,
				ChatMessage.class);
		String type = bean.getType();
		if (type.equals("0")) {
			userMaps.put(session.getId(), bean.getUsername());
			sendtoAllOnlineUsers();
		} else if (type.equals("1")) {
			sendMessageToUsers(message);
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
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 */
	private void sendMessageToUsers(WebSocketMessage<?> message) {
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendtoAllOnlineUsers() {
		OnlineStudents onlines = new OnlineStudents();
		ArrayList<String> username = new ArrayList<String>();
		for (Map.Entry<String, String> u : userMaps.entrySet()) {
			username.add(u.getValue());
		}
		onlines.setType("3");
		onlines.setUsernames(username);
		JSONObject jsonObject = JSONObject.fromObject(onlines);
		String text = jsonObject.toString();
		text = text.replace("\"3\"", "3");
		System.out.println(text);
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(new TextMessage(text));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发送当时所有的在线用户
	 */
	private void sendOnlineUsers(WebSocketSession session) {
		OnlineStudents onlines = new OnlineStudents();
		ArrayList<String> username = new ArrayList<String>();
		for (Map.Entry<String, String> u : userMaps.entrySet()) {
			username.add(u.getValue());
		}
		onlines.setType("3");
		onlines.setUsernames(username);
		JSONObject jsonObject = JSONObject.fromObject(onlines);
		String text = jsonObject.toString();
		text = text.replace("\"3\"", "3");
		System.out.println(text);
		try {
			session.sendMessage(new TextMessage(text));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 断开连接时移除用户
	 * 
	 * @param session
	 */
	private void removeUser(WebSocketSession session) {
		users.remove(session);
		userMaps.remove(session.getId());
		sendtoAllOnlineUsers();
	}
}
