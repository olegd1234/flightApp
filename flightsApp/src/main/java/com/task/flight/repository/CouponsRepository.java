package com.task.flight.repository;

public interface CouponsRepository {

	public boolean isCouponValid(Long couponId);
	
	//if coupon not found or is otherwise not valid, full price is returned
	public Double getDiscountedPrice(Long couponId, Double price);

}
