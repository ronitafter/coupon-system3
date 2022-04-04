package com.ronit.test;

import java.sql.Date;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ronit.exceptions.CouponSystemException;
import com.ronit.login.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.ronit.entities.Company;
import com.ronit.entities.ResponseDto;
import com.ronit.services.AdminService;

//@Component
public class CustomerControllerTester implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		String token = doLogin();

		doPurchase(token);
		
		// like this:
//		doCouponGet(token);
//		doCouponDelete(token)
	}
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private AdminService adminService;
	
	public void startCompanyTester() throws CouponSystemException {
//		addOneCompany();
		
	}

//	public void addOneCompany()  {
////
////********************** ADD Company ********************************

	public void doPurchase(String token) {
		//purchase

				// create headers
				
				HttpHeaders headers = new HttpHeaders();
				// set `content-type` header
				headers.setContentType(MediaType.APPLICATION_JSON);
				// set `accept` header
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				headers.add("authorization", token);
				HttpEntity<String> entity = new HttpEntity<>("9", headers);
				ResponseEntity<ResponseDto> response2 = restTemplate.postForEntity
						(String.format("http://localhost:8080/customer/purchase"),
								entity, ResponseDto.class);
				ResponseDto dto;
				if(response2.getStatusCode().equals(HttpStatus.CREATED) ) {
					System.out.println("purchased coupon");
					dto = response2.getBody();
					if(dto.isSuccess()) {
						System.out.println("true");
					}
				}
	}
	
	public String doLogin() {
		//login
				LoginRequest loginRequest = new LoginRequest("bbb@", "bbb123", null);
				ResponseEntity<String> response = restTemplate.postForEntity
						(String.format("http://localhost:8080/customer/login"),
								loginRequest, 
								String.class);
				String token = "";
				if(response.getStatusCode().equals(HttpStatus.OK) ) {
					System.out.println("logged in as customer");
					token = response.getBody();
				}
				
				return token;
	}
	
//********************** updateCompany ********************************
		static void updateCompany(AdminService adminService) throws CouponSystemException {
			Company company = new Company(4, "Compan4", "Compan4@mail", "CompanY1123");
			adminService.updateCompany(company);
			System.out.println(company);
		}
	
	
//********************** GET ALL CUSTOMER ORDERS ********************************
		// 1. Wrapper class
		// 2. list using ParameterizedTypeReference and exchange method
		// 3. array
//		ResponseEntity<Order[]> res = resttemplate.getForEntity("http://localhost:8080/customer/orders/1",Order[].class);
//		Order[] arr = res.getBody();
//		List<Order> list = new ArrayList<>(Arrays.asList(arr));
//		System.out.println(list);
		
//********************** GET ALL CUSTOMERS ********************************
// WORKIN
//		CustomerList customers = resttemplate.getForObject(String.format("http://localhost:8080/customer"),
//				CustomerList.class);
//		System.out.println(String.format("received customers: %s", customers.getCustomers()));
// NOT WORKING
//	Customer[] customersArr = resttemplate.getForObject(String.format("http://localhost:8080/customer"), Customer[].class);
//		System.out.println(customersArr);
//********************** DELETE CUSTOMER ********************************	
//		System.out.println("checking method DeleteCustomer");
//	    resttemplate.delete("http://localhost:8080/customer/2");
//		System.out.println("customer deleted");
		
		
//	CustomersList customers = restTemplate.getForObject("http://localhost:8080/customer/ByFirstName?firstName=ranDanker", CustomersList.class);	
//	System.out.println(String.format("received customers: %s", customers.getCustomers()));
//    customers.getCustomers().forEach(customer -> System.out.println(customer));
//********************** ADD ORDER ********************************
		
//		?????
		
//********************** UPDATE ORDER ********************************

//????
				
// ********************** getAllUsersByAgeAndName **********************

//???
//********************** getAllCustomerByAge **********************
		// NOT WORKING
//	CustomerList customers = resttemplate.getForObject("http://localhost:8080/customer/ByAge?age=25", CustomerList.class);
//	System.out.println(String.format("received customers: %s", customers.getCustomers()));
//	System.err.println(customers.getCustomers());

//********************** GET ALL ORDERS ********************************
//		ResponseEntity<Order[]> res = resttemplate.getForEntity("http://localhost:8080/orders",Order[].class);
//		Order[] arr = res.getBody();
//		List<Order> list = new ArrayList<>(Arrays.asList(arr));
//		System.out.println(list);
//	
//			
//********************** ? ********************************	
//		List list = resttemplate.getForObject("http://localhost:8080/orders", List.class);
//		System.out.println(list);
//		Object orderAsMap =  list.get(0);
//		System.out.println(orderAsMap.getClass());

//		RequestEntity<?> req = new RequestEntity<>(HttpMethod.GET, new URI("http://localhost:8080/orders"));		
//		ParameterizedTypeReference<List<Order>> listOfOrder = new ParameterizedTypeReference<List<Order>>() {
//		};

//		List<Order> list2 = resttemplate.exchange(req, listOfOrder).getBody();
//		System.out.println(list2);
//		Order order = list2.get(0);		
				
// __________________________________ get the new customer __________________________________ 
//		
//		System.out.println("getting the new customer");
//		System.out.println(String.format("GET %s/customer/%d",SERVER_URL,response.getBody()));
////		Customer newCustomer = resttemplate.getForObject(String.format("%s/customer/%d", SERVER_URL,response.getBody()), Customer.class);
//		Customer newCustomer = resttemplate.getForObject("http://localhost:8080/customer/1", Customer.class);
//		System.out.println(String.format("new customer: %s", newCustomer.toString()));
//		System.out.println(newCustomer);

//	}
		

		

	
	}
