package com.task.flight.repository;

public interface BaggageRepository {

	public boolean checkIn(Long destinationId, String baggageId);

}
