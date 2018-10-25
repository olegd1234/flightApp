package com.task.flight.repository.mockup;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.task.flight.repository.CouponsRepository;

@Component
public class CouponsRepositoryImpl implements CouponsRepository {

	private final static int NUM_OF_RANDOM_COUPONS = 25;
	private final static double[] RANDOM_DISCOUNTS = { 0.1, 0.5, 0.6 };
	public final static long STARTING_COUPON_ID = 555555L;
	
	private Map<Long, Double> couponsMap;

	@Override
	public boolean isCouponValid(Long couponId) {
		
		return couponsMap.containsKey(couponId);
	}
	
	@PostConstruct
	protected void init() {
		

        Random  r = new Random(); 
		couponsMap = new HashMap<>();
		
		for (long i = STARTING_COUPON_ID; i < STARTING_COUPON_ID + NUM_OF_RANDOM_COUPONS; i++) {
			
			couponsMap.put(i, RANDOM_DISCOUNTS[r.nextInt(RANDOM_DISCOUNTS.length)]);
		}
	}

	@Override
	public Double getDiscountedPrice(Long couponId, Double price) {
		
		Double discount = couponsMap.get(couponId);
		if (discount == null) {
			discount = .0;
		}
		
		double retPrice = (1 - discount)*price;
		return new BigDecimal(retPrice).setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
	}
}
