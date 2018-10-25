package com.task.flight.cache;

public interface FlightDataCache<T> {
	
	public void put(Object key, T value);
	public T get(Object key);
	
}
