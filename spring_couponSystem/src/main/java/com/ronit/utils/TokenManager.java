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
	private Map<String, TokenInfo> tokens;
	
	   public boolean isAuthorizedFor(String token, ClientType clientType)  {
		   TokenInfo tokenInfo = tokens.get(token);
		   if(tokenInfo == null) {
			   System.out.println("there is no token");
			   return false;
		   }
		   boolean result = tokenInfo.getClientType().equals(clientType);
		   return result;
		   }
	
	public TokenManager() {
		tokens = new HashMap<>();
//		tokens2.put("333", new TokenInfo());
	}
	
	public boolean isTokenExists(String token) {
		return tokens.get(token) !=null;
//		return false;
	}
	
	public String generateToken(ClientType type) {
		TokenInfo info = TokenInfo.generate(type);
//		tokens2.put(info.getToken(), info);
//		return info.getToken();	
		String x = Double.toString(Math.random());
		tokens.put(x, info);
//		tokens.put(x, new TokenInfo());
		return x;

	}
	
	public void removeToken(String token) {
		tokens.remove(token);
	}
	
	public void removeExpired() {
		System.out.println("get all token- before: " + tokens.size());
		System.out.println("removeExpired has started");
		tokens.entrySet().removeIf((entry) -> isTokenExpired(entry.getValue().getCreationTime()));
		System.out.println("get all tokens- after: " + tokens.size());
	
	}
//	
//	public void removeExpired() {
//		tokens.entrySet().removeIf((entry)-> 
//		 new Date(0).after(entry.getValue().getCreationTime()));
//		
//	}
	
	public boolean isTokenExpired(Date time) {
		System.out.println("isTokenExpired has started");
		return new Date(System.currentTimeMillis()).after(DateUtils.addMinutes(time, 1));
//		
	}
	
	// -------------------------

	
	}



