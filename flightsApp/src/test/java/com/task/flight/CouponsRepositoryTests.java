package com.task.flight;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.task.flight.repository.CouponsRepository;
import com.task.flight.repository.mockup.CouponsRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponsRepositoryTests {

	@Autowired
	CouponsRepository repository;
	
	@Test
	public void couponIsValid() {
		
		boolean isValid = repository.isCouponValid(CouponsRepositoryImpl.STARTING_COUPON_ID);
		assertTrue(isValid);
	}

}
