package forrest.controller.sy.roomservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
@Controller
@ServerEndpoint(value="/chat/{userId}")
public class WebSocketController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//왜 static 으로 만들었을까?
	              // <key, value>
	static HashMap<String, Session> userList = new HashMap<String, Session>();
	private String storeId = null;
	//서버 접속시
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String id) {
		System.out.println("onOpen");
		//@PathParam 은 웹소켓에서 사용하는 @PathVariables		
		//1. userId 가 중복되는지 확인
		storeId = id;
		if(userList.get(id) != null) {
			logger.info("중복 발생");	
			sendMsg(session,"사용중인 아이디 입니다.");
		}else{//중복이 아닐 경우
			logger.info("중복 아님");
			userList.put(id, session);  // userList.put("이숭무", "1232242")
			                            // userList.put("한재용", "97977696")
			broadCast(id+"님이 접속 하였습니다.   현재 접속자 수 : "+userList.size());
		}	
	}

	//서버 종료시
	@OnClose
	public void onClose(Session session) {	
		System.out.println("onClose");
		String val = session.getId();//종료한 sessionId 확인
		
		Set<String>keys =  userList.keySet();
		for(String key : keys) {		
			if(val.equals(userList.get(key).getId())) {
				logger.info("종료하려는 userId : "+key);
				userList.remove(key, session);
				logger.info("현재 접속자 : "+userList.size());
				broadCast(key+"님께서 나가셨습니다.    현재 접속자("+userList.size()+")");
			}
		}	
		
	}
	
	//메시지 수신시
	@OnMessage
	public void onMessage(String msg, Session session) {
		
		broadCast(msg);
	}
	
	//에러 발생시
	@OnError
	public void onError(Session session, Throwable e) {
		logger.info("문제 세션 : "+ session);
		System.out.println(e.toString());
	}
	
	//메시지 전체 전송
	private void broadCast(String text){
		logger.info("전달 대상 : "+userList.size());
		// Map에 있는 모든 키를 가져
		Set<String>keys =  userList.keySet();
		try {		
			// list에 있는 모든 사용자에게 메세지를 전송하기 위해서 모든 키를 하나씩 받아 
			for(String key : keys) {
				logger.info("key : "+key);
				//id에 해당하는 session을 가져
				Session session = userList.get(key);
		        // key(ID)에 해당 세션을 가진 사용자에게 메세지 전달 
				session.getBasicRemote().sendText(text);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//한명에게 메시지 전달
	//비밀채팅 
	private void sendMsg(Session session, String msg) {
		try {
			session.getBasicRemote().sendText(msg);
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
}
