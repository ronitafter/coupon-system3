package com.ronit.login;

import javax.persistence.Entity;


import com.ronit.enums.ClientType;


public class LoginRequest {
    private ClientType clientType;
	private String email;
	private String password;
	
	public LoginRequest() {

	}

	
	public LoginRequest(String email, String password, ClientType clientType) {
		this.clientType = clientType;
		this.email = email;
		this.password = password;
	}


	public ClientType getClientType() {
		return clientType;
	}



	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "LoginRequest [clientType=" + clientType + ", email=" + email + ", password=" + password + "]";
	}


	


}
