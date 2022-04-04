package com.ronit.login;

import java.sql.Date;


import java.util.UUID;

import com.ronit.enums.ClientType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TokenInfo {
	private int id;
	private String token;
	private Date creationTime;
	private ClientType clientType;
	
public static TokenInfo generate(ClientType type, int id) {
	TokenInfo info = TokenInfo.builder().token(UUID.randomUUID().toString()).creationTime(new Date(System.currentTimeMillis())).clientType(type).id(id).build();
	return info;
	
	
}

}
