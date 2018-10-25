package com.task.flight.repository.mockup;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.task.flight.repository.TicketsRepository;

@Component
public class TicketsRepositoryImpl implements TicketsRepository {

	private Set<Long> ticketsSet;

	@Override
	public boolean isTicketAvailable(Long ticketId) {
		
		return ticketsSet.contains(ticketId);
	}
	
	@PostConstruct
	protected void init() {
		
		ticketsSet = new HashSet<>();
		ticketsSet.add(111111L);
		ticketsSet.add(111112L);
		ticketsSet.add(111113L);
	}
}
