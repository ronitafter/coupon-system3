package com.ronit.utils;

import java.sql.Date;


import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronit.entities.TokenInfo;
//import com.ronit.entities.TokenInfo;
import com.ronit.enums.ClientType;


@Service
//@AllArgsConstructor
public class TokenManager {
	

//	-------------
	private Map<String, TokenInfo> tokens2;
	
	public TokenManager() {
		tokens2 = new HashMap<>();
//		tokens2.put("333", new TokenInfo());
	}
	
	public boolean isTokenExists(String token) {
		return tokens2.get(token) !=null;
//		return false;
	}
	
	public String generateToken(ClientType type) {
		TokenInfo info = TokenInfo.generate(type);
//		tokens2.put(info.getToken(), info);
//		return info.getToken();	
		String x = Double.toString(Math.random());
		tokens2.put(x, new TokenInfo());
		return x;

	}
	
	public void removeToken(String token) {
		tokens2.remove(token);
	}
	
	public void returnExpired() {
		tokens2.entrySet().removeIf((entry) -> isTokenExpired(entry.getValue().getCreationTime()));
		
	}
//	
	
	
	public void removeExpired() {
		tokens2.entrySet().removeIf((entry)-> 
		 new Date(0).after(entry.getValue().getCreationTime()));
		
	}
	
	public boolean isTokenExpired(Date time) {
		return new Date(0).after(DateUtils.addMinutes(time, 30));
//		
	}
	
	// -------------------------

	
	}



