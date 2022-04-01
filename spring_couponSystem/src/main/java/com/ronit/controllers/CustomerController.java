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
import com.ronit.entities.LoginRequest;
import com.ronit.entities.ResponseDto;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.AuthorizationException;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.job.RemoveExpiredTokens;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerService;
import com.ronit.utils.LoginManager;
import com.ronit.utils.TokenManager;

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
	
	

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest)
			throws AuthorizationException, CouponSystemException {
		System.out.println("customer login");
		try {
			ClientService clientService = loginManager.login(loginRequest.getEmail(), loginRequest.getPassword(), ClientType.CUSTOMER);		//1- try to login
			customerservice = (CustomerService) clientService;
			String token = tokenManager.generateToken(ClientType.CUSTOMER);

			return new ResponseEntity<String>(token, HttpStatus.OK);
		} catch (CouponSystemException e) {
			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);


		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}


	}


	@GetMapping("/logout")
	public void logout(@RequestHeader("authorization") String token) {
		loginManager.logout(token);
	}
	
	@PostMapping("/purchase")
//	@GetMapping("/coupon")
	public  ResponseEntity<?> PurchaseCoupon(@RequestBody int couponId) throws AuthorizationException,
	CouponSystemException {
		if (true){//tokenManager.isTokenExists(token)) {
				customerservice.PurchaseCoupon(couponId);			
				ResponseDto responsdto = new ResponseDto(true, "Purchased Coupon");
				return new ResponseEntity<>(responsdto, HttpStatus.CREATED);
		}
		throw new AuthorizationException("Purchase not authorized");		
//			
		}
	
	@GetMapping("/coupon")
	public List<Coupon> getAllCustomerCoupons()
			throws CouponSystemException, AuthorizationException {
		if (true){
			return customerservice.getAllCustomerCoupons();
		} else {
			throw new AuthorizationException("company not authorized");

		}

	}
	@GetMapping("/coupon/category")
//	@GetMapping("/customerCouponsByCategory")
	public List<Coupon> getCustomerCoupons(@RequestParam("customerId") int customerId, @RequestParam("category") int category) throws CouponSystemException, AuthorizationException {
		if (true){//tokenManager.isTokenExists(token)) {
		return customerservice.getCustomerCoupons(customerId, category);
	}
	
		throw new AuthorizationException("Purchase not authorized");	
	}
//	@GetMapping("/coupon/{maxPrice}")
	@GetMapping("/price")
	public List<Coupon> getCustomerCouponsByPrice(
												  @RequestParam("customerId") int customerId, @RequestParam("maxPrice") double maxPrice) throws CouponSystemException, AuthorizationException {
		if (true){//tokenManager.isTokenExists(token)) {
			return customerservice.getCustomerCouponsByPrice(customerId, maxPrice);
		}
		
		throw new AuthorizationException("Purchase not authorized");	

	}
	
	@GetMapping("/details/{customerId}")
	//	@GetMapping("/customerDetails")
//	public Customer getAllCustomerDetails(@PathVariable("id") int customerId) throws CouponSystemException, AuthorizationException {
	public Customer getAllCustomerDetails(@PathVariable int customerId) throws CouponSystemException, AuthorizationException {
		return customerservice.getAllCustomerDetails(customerId);

}
}


