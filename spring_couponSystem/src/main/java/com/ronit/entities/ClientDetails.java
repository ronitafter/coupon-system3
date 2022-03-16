package com.ronit.entities;

public class ClientDetails {

	private long id;
	private String email;
	private String password;
	private String clientType;

	public ClientDetails() {

	}

	public ClientDetails(long id, String email, String password, String clientType) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.clientType = clientType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "ClientDetails [id=" + id + ", email=" + email + ", password=" + password + ", clientType=" + clientType
				+ "]";
	}

}
