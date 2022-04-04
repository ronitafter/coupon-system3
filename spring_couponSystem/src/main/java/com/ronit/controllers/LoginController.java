package com.ronit.controllers;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.enums.ClientType;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.login.LoginManager;
import com.ronit.login.LoginRequest;
import com.ronit.login.TokenInfo;
import com.ronit.login.TokenManager;
import com.ronit.services.AdminService;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private TokenManager tokenManager;
	protected AdminService adminService;
	protected CompanyService companyService;
	protected CustomerService customerService;

	@PostMapping
	public ResponseEntity<TokenInfo> login(@RequestBody LoginRequest loginRequest) throws CouponSystemException {
		ClientService clientService = null;
		try {
		clientService =loginManager.login(loginRequest.getEmail(), loginRequest.getPassword(), loginRequest.getClientType());
		String token = tokenManager.generateToken(loginRequest.getClientType(), clientService.getId());
		return new ResponseEntity<TokenInfo>(tokenManager.getInfoForToken(token), HttpStatus.OK);
		} catch (Exception e) {

		return new ResponseEntity<TokenInfo>(HttpStatus.BAD_REQUEST);
		}
}
}


