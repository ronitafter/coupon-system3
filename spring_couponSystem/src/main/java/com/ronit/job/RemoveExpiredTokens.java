package com.ronit.job;

import java.sql.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ronit.entities.TokenInfo;
import com.ronit.utils.TokenManager;
//import com.ronit.utils.TokenManager.Token;

@Component
public class RemoveExpiredTokens {

	@Autowired
	public TokenManager tokenManager;
	
	
	@Scheduled(fixedRate=1000*30)
	public void run() {
		System.out.println("RemoveExpiredTokens has started");
		removeExpiredSessions();
//		tokenManager.removeToken(null);
	}
	
//	
//    public TokenInfo tokenInfo;
//	private static final long EXPIRATION_TIME_PERIOD_IN_MILLIS = 1000*60*10; //10 min
//	private static final long EXPIRATION_THREAD_PERIOD_IN_MILLIS = 1000*5; //5 seconds
//	private static long lastToken = 5678;
//	private Map<String, Token> tokens = new HashMap<String, RemoveExpiredTokens.Token>();
	
//
//	
//	public RemoveExpiredTokens() {
//		super();
//	}
//
//	synchronized public boolean isTokenExist(String token) {
//		return tokens.containsKey(token);
//	}
//
//	synchronized public String getNewToken() {
//		Token newToken = new Token();
//		tokens.put(newToken.getToken(), newToken);
//		System.out.println("New token created by server: "+newToken.getToken());
//		return newToken.getToken();
//	}
//	
//	public void initThread() {
//	    int delay = 0; // delay for 0 sec.
//	    Timer timer = new Timer();
//
//		System.out.println("Remove Expired Sessions Thread Initialized!");
//	    timer.scheduleAtFixedRate(new TimerTask() {
//	      public void run() {
//	        removeExpiredSessions();
//	      }
//	    }, delay, EXPIRATION_THREAD_PERIOD_IN_MILLIS);
//	}
//	
	synchronized private void removeExpiredSessions() {
		tokenManager.removeExpired();
		
		
		
//	}
//
//	
//	public class Token {
//		private String token;
//		private long createTime;
//		
//		public Token() {
//			super();
//			this.token = "Coupn_project_token_"+lastToken++;
//			this.createTime = (new Date(0)).getTime();
//		}
//
//		public void printRemainTimeInSeconds() {
//			long nowTime = (new Date(0)).getTime();
//			long remainTime = (EXPIRATION_TIME_PERIOD_IN_MILLIS-(nowTime-createTime));
//			String t="";
//			if(remainTime<1000){
//				t="Milliseconds";
//			}
//			else if(remainTime<60000) {
//				t="Seconds";
//				remainTime/=1000;
//			}
//			else {
//				t="Minutes";
//				remainTime/=(60*1000);
//			}
//			System.out.println(token+", Remaining time, a litle bit more than " +remainTime+" "+t);
//		}
//
//		public boolean isExpired()
//		{
//			long nowTime = (new Date(0)).getTime();
//			return (nowTime-createTime)>EXPIRATION_TIME_PERIOD_IN_MILLIS;
//		}
//		public String getToken() {
//			return token;
//		}
//
//		public long getCreateTime() {
//			return createTime;
//		}
//
//		@Override
//		public String toString() {
//			return "Token [token=" + token + ", createTime=" + createTime + "]";
//		}

}
}
