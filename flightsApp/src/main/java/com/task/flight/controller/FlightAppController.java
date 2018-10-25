package com.task.flight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task.flight.cache.FlightDataCache;
import com.task.flight.repository.BaggageRepository;
import com.task.flight.repository.CouponsRepository;
import com.task.flight.repository.TicketsRepository;


@RestController
@RequestMapping("/api")
public class FlightAppController {
	
	@Autowired 
	TicketsRepository ticketsRepository;
	
	@Autowired 
	CouponsRepository couponsRepository;
	
	@Autowired 
	BaggageRepository baggageRepository;
	
    protected static final Logger logger = LoggerFactory.getLogger(FlightAppController.class);
    
    @RequestMapping(method = RequestMethod.GET, value = "/tickets/{ticketId}", produces = "text/plain")
    public String isTicketAvailable(@PathVariable("ticketId") Long ticketId) {
    	
    	logger.debug("request received for ticketId {}", ticketId);
    	String ret = String.valueOf(ticketsRepository.isTicketAvailable(ticketId));
    	logger.info("to return {}", ret);
    	return ret;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/baggage/{destinationId},{baggageId}", produces = "text/plain")
    public String checkIn(@PathVariable("destinationId") Long destinationId, @PathVariable("baggageId") String baggageId) {
    	
    	logger.debug("request received for destinationId {}, baggageId {}", destinationId, baggageId);
    	String ret = String.valueOf(baggageRepository.checkIn(destinationId, baggageId));
    	logger.info("to return {}", ret);
    	return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/baggage/{couponId},{price}", produces = "text/plain")
    public String getDiscount(@PathVariable("couponId") Long couponId, @PathVariable("price") Double price) {
    	
    	logger.debug("request received for couponId {}, price {}", couponId, price);
    	String ret = String.valueOf(couponsRepository.getDiscountedPrice(couponId, price));
    	logger.info("to return {}", ret);
    	return ret;
    }

}
