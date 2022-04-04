package com.ronit.services;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ronit.entities.Company;
import com.ronit.entities.Coupon;
import com.ronit.entities.Customer;
import com.ronit.enums.Category;
import com.ronit.enums.ClientType;
import com.ronit.exceptions.CouponSystemException;
import com.ronit.repositories.CouponRepository;
import com.ronit.repositories.CustomerRepository;

import jdk.jfr.DataAmount;

@Service
@Scope("prototype")
@Transactional(rollbackFor = CouponSystemException.class)
public class CustomerService extends ClientService {

	private int customerId;
	
	public int getId() {
		return customerId;
	}
// -------------------------- login -----------------------------------------
	public boolean login(String email, String passwaord) {
		if (customerRepository.existsByEmailAndPassword(email, passwaord)) {
			Customer customer = customerRepository.findByEmailAndPassword(email, passwaord);
			this.customerId = customer.getId();
			return true;
		}

		return false;

	}

// -------------------------- Contractor -----------------------------------------
	@Autowired
	public CustomerService(CouponRepository couponrepository, CustomerRepository customerrepository) {
		this.couponRepository = couponrepository;
		this.customerRepository = customerrepository;

	}

// -------------------------- PurchaseCoupon -----------------------------------------
	public void PurchaseCoupon(int couponId) throws CouponSystemException {
		Optional<Coupon> opt = this.couponRepository.findById(couponId);
		if (opt.isEmpty()) {
			throw new CouponSystemException("PurchaseCoupon faild - coupon with this Id not found");
		}
		Coupon coupon = opt.get();
		if (coupon.getAmount() <= 0) {
			throw new CouponSystemException("PurchaseCoupon faild - amount for this coupo is 0");
		}
		if (couponRepository.existsByIdAndCustomersId(couponId, 0)) {
			throw new CouponSystemException("PurchaseCoupon faild - coupon exists for this CustomerId");
		}

		if (coupon.getEndDate().before(new Date())) {
			throw new CouponSystemException("could not  Purchase coupon - coupon  is expired");
		} else {
			Customer customer = customerRepository.getById(0);
			customer.addCoupon(coupon);
			coupon.setAmount(coupon.getAmount() - 1);
			System.out.println("coupon Purchased successfully");
			System.out.println("coupon Id: " + couponId + " customer Id: " + 0);

		}

	}

// -------------------------- getAllCustomerCoupons -----------------------------------------

	public List<Coupon> getAllCustomerCoupons(int customerId) throws CouponSystemException {
		var result = couponRepository.findByCustomersId(customerId);
		if (result.isEmpty()) {
			throw new CouponSystemException(
					"getAllCustomerCoupons faild - Coupons not found in this category for this customer");
		} else {
			return new ArrayList<Coupon>(result);

		}

	}

// -------------------------- getCustomerCoupons -----------------------------------------
	public List<Coupon> getCustomerCoupons(int customerId, int category) throws CouponSystemException {
		var result = couponRepository.findByCustomerIdAndCategory(customerId, category);
		if (result.isEmpty()) {
			throw new CouponSystemException(
					"getCustomerCoupons faild - Coupons not found in this category for this customer");
		} 

			return new ArrayList<Coupon>(result);
		

	}

// -------------------------- getCustomerCouponsByPrice -----------------------------------------
	public List<Coupon> getCustomerCouponsByPrice(int customerId, double maxPrice) throws CouponSystemException {
		if (couponRepository.findCustomerCouponsByMaxPrice(customerId, maxPrice).isEmpty()) {
			throw new CouponSystemException("getCustomerCoupons faild - customerId not found");
		} else {
			return new ArrayList<Coupon>(couponRepository.findCustomerCouponsByMaxPrice(customerId, maxPrice));
		}
	}

// -------------------------- getAllCustomerDetails -----------------------------------------
	public Customer getAllCustomerDetails(int customerId) throws CouponSystemException {
		Optional<Customer> opt = this.customerRepository.findById(customerId);
		if (opt.isEmpty()) {
			throw new CouponSystemException("getAllCustomerDetails faild - Customer not found");
		}

		System.out.println("getAllCustomerDetails");
		return opt.get();
	}

}
