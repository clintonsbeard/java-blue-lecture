package com.techelevator.dao;

import java.util.List;

import com.techelevator.dao.model.City;

public interface CityDAO {

	public void save(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	
}
