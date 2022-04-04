package com.ronit.controllers;

import java.util.List;




import com.ronit.test.AdminControllerTester;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.entities.Company;
import com.ronit.entities.Coupon;
import com.ronit.entities.Customer;
import com.ronit.entities.ResponseDto;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.AuthorizationException;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.exceptions.InvalidOperationException;
import com.ronit.job.RemoveExpiredTokens;
import com.ronit.login.LoginManager;
import com.ronit.login.LoginRequest;
import com.ronit.login.TokenInfo;
import com.ronit.login.TokenManager;
import com.ronit.services.AdminService;
import com.ronit.services.ClientService;
import com.ronit.services.CompanyService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController extends ClientController {


	@Autowired
	private LoginManager loginManager;
//	@Autowired
	private AdminService adminService;
//	@Autowired
//	private ResponseDto ResponseDto;
	private RemoveExpiredTokens removeExpiredTokens;	
	@Autowired
	private TokenManager tokenManager;	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;

	}


	@GetMapping("/test")
	public void test() {
		System.out.println("+++++++++++++++++");
		//adminControllerTester.addOneCompany();
//		adminControllerTester.testApi();
	}

	@GetMapping("/fillData")
	public void fillDataInDb() {
		System.out.println("----------------");
		//adminControllerTester.addOneCompany();
		System.out.println("!!!!!!!!!!!!!!!");
	}

	@GetMapping("/logout")
	public void logout(@RequestHeader("authorization") String token) {
		loginManager.logout(token);
	}


// ************************************ COMPANY *****************************************************************

// ___________________________________ Add Company _____________________________________________________________
	
//add company - Company company
	@PostMapping("/company")
	public ResponseEntity<Company> addCompany(//@RequestHeader("authorization") String token,
										@RequestBody Company company)
			throws InvalidOperationException, CouponSystemException {
		
		try {
			Company addedCompany = adminService.addCompany(company);
			return new ResponseEntity<Company>(addedCompany, HttpStatus.CREATED);

		} catch (Exception e) {
			return null;
		}

	}
// ___________________________________ Update Company ___________________________________________________________
	@PutMapping("/company")
	public ResponseEntity<?> updateCompany(@RequestBody Company company)
			throws InvalidOperationException, CouponSystemException {
		adminService.updateCompany(company);
//		return ResponseEntity.ok(company);
		return ResponseEntity.ok(company);

	}
	
// ___________________________________ Update Customer ____________________________________________________________
	@PutMapping("/customer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws CouponSystemException {
		adminService.updateCustomer(customer);
		return ResponseEntity.ok(customer);
	}
	
// ___________________________________ Delete Company ____________________________________________________________
	@DeleteMapping("/company/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("id") int id)
			throws CouponSystemException {

		try {
			adminService.deleteCompany(id);
			return new ResponseEntity<>("company deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("company not found", HttpStatus.NOT_FOUND);
		}
	}

// ___________________________________ Get All Companies _________________________________________________________
	@GetMapping("/companies")
	public List<Company> getAllCompanies(){
		return adminService.getAllCompanies();

	}

// ___________________________________ Get One Company ___________________________________________________________
	@GetMapping("/company/{companyId}")
	public ResponseEntity<?> getCompanyById(@PathVariable int companyId) {
		try {
			Company company = adminService.getOneCompany(companyId);
			return new ResponseEntity<>(company, HttpStatus.OK);
		} catch (CouponSystemException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

// ************************************ CUSTOMER *****************************************************************

// ___________________________________ Add Customer _____________________________________________________________
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(
			@RequestBody Customer customer)
throws InvalidOperationException, CouponSystemException {

try {
	Customer addedCustomer = adminService.addCustomer(customer);
return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
} catch (Exception e) {
return null;
}
	}
// ___________________________________ Delete Customer ____________________________________________________________
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
		try {
			adminService.deleteCustomer(customerId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CouponSystemException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

// ___________________________________ getAllCustomers ____________________________________________________________
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() throws AuthorizationException {
		if (true){
			List<Customer> customers = adminService.getAllCustomers();
			return customers;
		}

		throw new AuthorizationException("user not authorized");
	}
	

// ___________________________________ getAllCustomers ____________________________________________________________
		@GetMapping("/coupons")
		public List<Coupon> getAllCoupons() throws AuthorizationException {
			System.out.println("getAllCoupons");
		
				List<Coupon> coupons = adminService.getAllCoupons();
				return coupons;
		}
		
// ___________________________________ Get One Customer ___________________________________________________________
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getOneCustomer(@PathVariable("id") Integer id) throws CouponSystemException {
		try {
			Customer customer = adminService.getOneCustomer(id);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (CouponSystemException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
