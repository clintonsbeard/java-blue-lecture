package com.techelevator.model;

import java.util.List;

public interface CityDao {

	List<City> getAllCities();
	long getCountOfCities();
}
