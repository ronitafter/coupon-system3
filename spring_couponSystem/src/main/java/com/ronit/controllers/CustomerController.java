package com.ronit.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.entities.Coupon;
import com.ronit.entities.Customer;
import com.ronit.entities.ResponseDto;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.AuthorizationException;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.job.RemoveExpiredTokens;
import com.ronit.login.LoginManager;
import com.ronit.login.LoginRequest;
import com.ronit.login.TokenManager;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController extends ClientController {
	
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private TokenManager tokenManager;
	private RemoveExpiredTokens removeExpiredTokens;
	@Autowired
	private LoginManager loginManager;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerservice = customerService;
	}
	

	@GetMapping("/logout")
	public void logout(@RequestHeader("authorization") String token) {
		loginManager.logout(token);
	}
	
	@PostMapping("/purchase")
	public  ResponseEntity<?> PurchaseCoupon(@RequestBody int couponId) throws AuthorizationException,
	CouponSystemException {
				customerservice.PurchaseCoupon(couponId);			
				ResponseDto responsdto = new ResponseDto(true, "Purchased Coupon");
				return new ResponseEntity<>(responsdto, HttpStatus.CREATED);		
		}
	@GetMapping("/coupon")
	public List<Coupon> getAllCustomerCoupons(@RequestHeader("authorization") String token)
			throws CouponSystemException, AuthorizationException {	
			var tokenInfo = tokenManager.getInfoForToken(token);
			return customerservice.getAllCustomerCoupons(tokenInfo.getId());
		}

	@GetMapping("/coupon/category")
	public List<Coupon> getCustomerCoupons(@RequestParam("customerId") int customerId, @RequestParam("category") int category) throws CouponSystemException, AuthorizationException {
		return customerservice.getCustomerCoupons(customerId, category);
	}
	
	@GetMapping("/price")
	public List<Coupon> getCustomerCouponsByPrice(@RequestHeader("authorization") String token, 
			@RequestParam("maxPrice") double maxPrice)
					throws CouponSystemException, AuthorizationException {
		var tokenInfo = tokenManager.getInfoForToken(token);
			return customerservice.getCustomerCouponsByPrice(tokenInfo.getId(), maxPrice);
		}	
	@GetMapping("/details/{customerId}")
	public Customer getAllCustomerDetails(@PathVariable int customerId) throws CouponSystemException, AuthorizationException {
		return customerservice.getAllCustomerDetails(customerId);

}
}


