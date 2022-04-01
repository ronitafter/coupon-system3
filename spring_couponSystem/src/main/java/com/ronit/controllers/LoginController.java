package com.ronit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.entities.LoginRequest;
import com.ronit.services.AdminService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerService;
import com.ronit.utils.LoginManager;


@RestController
@RequestMapping("/login")
public class LoginController {

	 @Autowired
	    private LoginManager loginManager;
	 
	 protected AdminService adminService;
	    protected CompanyService companyService;
	    protected CustomerService customerService;
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
	    	switch (loginRequest.getClientType()) {
	    	case ADMIN: getAdminToken()
	    	}
	    	
	    	return null;
	    }
}
