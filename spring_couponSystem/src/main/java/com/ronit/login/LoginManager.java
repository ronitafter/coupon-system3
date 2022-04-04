package com.ronit.login;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ronit.enums.ClientType;
import com.ronit.exceptions.AuthorizationException;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.job.RemoveExpiredTokens;
import com.ronit.services.AdminService;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerService;

@Component
public class LoginManager {

	@Autowired
	TokenManager tokenManager;
	private RemoveExpiredTokens removeExpiredTokens;
		
	@Autowired
	private ApplicationContext context;

	public void logout(String token) {
		tokenManager.removeToken(token);
	}
	
	public ClientService login(String email, String passwaord, ClientType clientType) throws CouponSystemException {
		ClientService clientService = null;
		switch (clientType) {
		case COMPANY:
			 clientService = context.getBean(CompanyService.class);
			 break;
		case CUSTOMER:
			clientService = context.getBean(CustomerService.class);
			break;
		case ADMINISTRATOR:
			clientService = context.getBean(AdminService.class);
			break;
		}

		if (clientService.login(email, passwaord)) {
			return clientService;
		} else {
			throw new CouponSystemException("login failed");
		}
	}

}
