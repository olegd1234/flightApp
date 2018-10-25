package com.task.flight.repository.mockup;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.task.flight.repository.BaggageRepository;

@Component
public class BaggageRepositoryImpl implements BaggageRepository {

	private Set<Long> destinationsSet;

	@Override
	public boolean checkIn(Long destinationId, String baggageId) {
		
		if (destinationsSet.contains(destinationId)) {
			return false;
		}
		
		//DO NOTHING - no check in action implemented
		return true;
	}
	
	@PostConstruct
	protected void init() {
		
		destinationsSet = new HashSet<>();
		destinationsSet.add(999999L);
		destinationsSet.add(999998L);
		destinationsSet.add(999997L);
	}

}
