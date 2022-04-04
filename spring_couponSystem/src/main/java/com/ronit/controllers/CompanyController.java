package com.ronit.controllers;

import java.util.List;



import javax.servlet.http.HttpSession;

import com.ronit.entities.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ronit.beans.ResponseDto;
import com.ronit.entities.Company;
import com.ronit.entities.Coupon;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.AuthorizationException;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.exceptions.InvalidOperationException;
import com.ronit.job.RemoveExpiredTokens;
import com.ronit.login.LoginManager;
import com.ronit.login.LoginRequest;
import com.ronit.login.TokenManager;
import com.ronit.services.AdminService;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController extends ClientController {

	@Autowired
	private LoginManager loginManager;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private TokenManager tokenManager;

	private RemoveExpiredTokens removeExpiredTokens;

	@PostMapping("/coupon")
	public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon)
			throws AuthorizationException {
		try {
			companyService.addCoupon(coupon);
			ResponseDto responsdto = new ResponseDto(true, "coupon added");
			return new ResponseEntity<>(responsdto, HttpStatus.CREATED);

		} catch (CouponSystemException e) {
			ResponseDto responsdto = new ResponseDto(false, e.getMessage());
			return new ResponseEntity<>(responsdto, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/coupon")
	public ResponseEntity<?> UpdateCoupon(@RequestBody Coupon coupon)
			throws CouponSystemException, AuthorizationException {
			companyService.UpdateCoupon(coupon);
			return ResponseEntity.ok(coupon);
	
	}

	@DeleteMapping("/coupon/{couponId}/{companyId}")
	public ResponseEntity<?> deleteCoupon(@PathVariable("couponId") int couponId, @PathVariable("companyId") int companyId)
			throws CouponSystemException, AuthorizationException {
			companyService.deleteCoupon(couponId, companyId);
			return ResponseEntity.ok().build();

	}
	@GetMapping("/coupon/category/{categoryId}")
	public List<Coupon> getCompanyCoupons(@PathVariable int categoryId)
			throws CouponSystemException, AuthorizationException {
		return companyService.getCompanyCoupons(categoryId);
	}

	@GetMapping("/coupon/{maxPrice}")
	public List<Coupon> getCompanyCouponsByPrice(@PathVariable double maxPrice)
			throws CouponSystemException, AuthorizationException {
			return companyService.getCompanyCouponsByPrice(maxPrice);
		}
	

	@GetMapping("/company")
	public List<Coupon> getAllCompanyCoupons()
			throws CouponSystemException, AuthorizationException {
			return companyService.getAllCompanyCoupons();
		}

	

	@GetMapping("/id")
	public List<Coupon> getAllCompanyCoupons(@PathVariable int companyId)
			throws CouponSystemException, AuthorizationException {
			return companyService.getMyCompanyCoupons(companyId);
	}

	@GetMapping("/details/{companyId}")
	public Company getCompanyDetails(@PathVariable int companyId)
			throws CouponSystemException, AuthorizationException {
		System.out.println("getCompanyDetails");
			return companyService.getCompanyDetails(companyId);
	}
}
