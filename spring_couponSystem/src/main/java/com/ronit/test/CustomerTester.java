package com.ronit.test;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ronit.entities.Coupon;
import com.ronit.entities.Customer;
import com.ronit.enums.Category;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.services.CompanyService;
import com.ronit.services.CustomerService;
import com.ronit.utils.DateUtils;
import com.ronit.utils.LoginManager;

//@Order(3)
//@Component
public class CustomerTester implements CommandLineRunner {

	int customerID;
	private LoginManager loginManager;
	private CustomerService customerService;
	@Autowired
	private ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {

		Date now = new Date(new java.util.Date().getTime());
		Date inOneDay = new Date(now.getTime() + 24 * 60 * 60 * 1000);
		startCustomerTester();
	}

	public void startCustomerTester() {
		LoginManager loginManager = context.getBean(LoginManager.class);
		try {
			CustomerService customerServie = (CustomerService) loginManager.login("ggg@", "ggg123",
					ClientType.CUSTOMER);
			System.out.println("loged in as CUSTOMER");

//// -------------- CUSTOMER SERVICE TESTING --------------
////PurchaseCoupon:
//			PurchaseCoupon(customerServie);
//	getAllCustomerDetails:
//		Customer c = getAllCustomerDetails(customerServie);
//		System.out.println(c);
////			getAllCustomerDetails(customerServie);
////getAllCustomerCoupons1:
//			getAllCustomerCoupons(customerServie);
////getCustomerCoupons2:
////				getCustomerCoupons(customerServie);
////not working getCustomerCouponsByPrice
			getCustomerCouponsByPrice(customerServie);
//
		} catch (CouponSystemException e) {
			System.out.println("====== Error ========================");
			System.out.println(e.getMessage());
			System.out.println("====== ===== ========================");
			e.printStackTrace();
		}
	}

	public void PurchaseCoupon(CustomerService customerService) throws CouponSystemException {
		customerService.PurchaseCoupon(4);

	}
//
//	public List<Coupon> getCustomerCoupons(CustomerService customerService) throws CouponSystemException {
//		for (Coupon coupon : customerService.getCustomerCoupons(1, 3)) {
//			System.out.println(coupon);
//			
//		}
//		return null;
//	}
//
	public List<Coupon> getCustomerCouponsByPrice(CustomerService customerServie) throws CouponSystemException {
		for (Coupon coupon : customerServie.getCustomerCouponsByPrice(2, 100)) {
			System.out.println(coupon);
		}
//		return customerServie.getCustomerCouponsByPrice(1, 100);
		return null;

	}
//
	public Customer getAllCustomerDetails(CustomerService customerServie) throws CouponSystemException {
		return customerServie.getAllCustomerDetails(3);

	}

	public List<Coupon> getAllCustomerCoupons(CustomerService customerServie) throws CouponSystemException {
		for (Coupon coupon : customerServie.getAllCustomerCoupons()) {
			 System.out.println(coupon);
		}
		return null;
}
}
