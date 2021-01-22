package com.webbutik.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.entity.Car;
import com.webbutik.repository.CarRepository;

@Transactional
@Service
public class CarService {
	@Autowired
	private CarRepository repository;
	


	public Car saveCar(Car car) {
		return repository.save(car);
	}

	public List<Car> getAllCar() {
		return repository.findAll();
	}
	
	
	
	public List<Car> getAllByBrand(Collection<String> brand) {
		return repository.findByBrand(brand);
	}
	
	public List<Car> getAllByBrandAndModel(Collection<String> brand, Collection<String> model){
		return repository.findAllByBrandAndModel(brand,model);
	}

	public Car getCarById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Car getCarByRegNr(String regNr) {
		return repository.findByName(regNr);
	}

	public String deleteCar(int id) {
		repository.deleteById(id);
		return ("Bil med id= " + id + " är raderad");
	}

	public String deleteCArByRegNr(String regNr) {
		Car gamlaCar = repository.findByName(regNr);
		repository.delete(gamlaCar);
		return "Bil med regNr= " + regNr + " är raderat";

	}

	public Car updateCar(Car car) {
		Car gamlaCar = repository.findByName(car.getRegNr());
		gamlaCar.setPrice(car.getPrice());
		gamlaCar.setKilometer(car.getKilometer());
		gamlaCar.setNew(car.isNew());
		gamlaCar.setNavigation(car.isNavigation());
		gamlaCar.setRentable(car.isRentable());
		return repository.save(gamlaCar);
	}

	public List<Car> getAllByBelowPrice(Integer price) {
	
		return repository.findByBelowPrice(price);
	}

	public List<Car> getAllBelowKilometer(Integer kilometer) {
		return repository.findBelowKilometer(kilometer);
	}

	public List<Car> getAllAutomatic(boolean automatic) {
		return repository.findIsAutomatic(automatic);
	}

	public List<Car> getAllRentable(boolean isRentable) {
		return repository.findAllRentable(isRentable);
	}

	public List<Car> getAllWithNavigation(boolean navigation) {
		return repository.findAllWithNavigation(navigation);
	}

	public List<Car> getAllNewCar(boolean isNew) {
		return repository.findAllNewCar(isNew);
	}

	public List<Car> getAllWithSameFuel(String fuel) {
		return repository.findAllCarWithSameFuel(fuel);
			}

	
	public List<Car> getAllWithSamaBrandAndFuel(Collection<String> brandName, Collection<String> fuel) {
		return repository.findAllByBrandAndFuel(brandName,fuel);
	}

	public List<Car> getAllWithSamaBrandModelAndFuel(Collection<String> brandName, Collection<String> modelName,
			Collection<String> fuel) {
		return repository.findAllByBrandModelAndFuel(brandName,modelName,fuel);
	}

	public List<Car> getAllCarByYear(Integer yearProduce) {
		return repository.findCarsByYear(yearProduce);
	}

	public List<Car> getAllCarByColor(String color) {
		return repository.findCarsByColor(color);
	}

	public List<Car> getAllByTimeStored(Date timeStored) {
		return repository.findCarByTimeStored(timeStored);
	}

	
//	public Car updatePrise( Car car,int price) {
//		Car gamlaCar = repository.findByName(car.getRegNr());
//		gamlaCar.setPrice(car.getPrice());
//		return repository.save(gamlaCar);
//	}
//	
//	public Car updateRentable(Car car) {
//		Car gamlaCar = repository.findByName(car.getRegNr());
//		gamlaCar.setRentable(car.isRentable());
//		return repository.save(gamlaCar);
//	}
//	
//	public Car updateIsNewAndKilommeter(Car car) {
//		Car gamlaCar = repository.findByName(car.getRegNr());
//		gamlaCar.setNew(car.isNew());
//		gamlaCar.setKilometer(car.getKilometer());
//		return repository.save(gamlaCar);
//	}
}
