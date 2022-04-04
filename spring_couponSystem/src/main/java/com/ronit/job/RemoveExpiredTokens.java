package com.ronit.job;

import java.sql.Date;


import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ronit.login.TokenInfo;
import com.ronit.login.TokenManager;

//@Component
public class RemoveExpiredTokens {

	@Autowired
	public TokenManager tokenManager;
	
	
	@Scheduled(fixedRate=1000*30)
	public void run() {
		System.out.println("RemoveExpiredTokens has started");
		removeExpiredSessions();
//		tokenManager.removeToken(null);
	}
	
	synchronized private void removeExpiredSessions() {
		tokenManager.removeExpired();
		
		

}
}
