package com.webbutik.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.entity.Car;
import com.webbutik.entity.ModelOfCar;
import com.webbutik.exception.OurCustomExceptions;
import com.webbutik.repository.CarRepository;
import com.webbutik.repository.ModelOfCarRepository;

@Transactional
@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	// för att koppla car med model i modelOfCarTAble
	@Autowired
	private ModelOfCarRepository modelRepository;

	public Car saveCar(Car car) {
		ModelOfCar modelofcar = new ModelOfCar();
		String namnModelOfCar = modelofcar.getName();
		namnModelOfCar = car.getModelName();
		modelofcar = modelRepository.findByName(namnModelOfCar);
		
		car.setModelOfCarName(modelofcar);
		return repository.save(car);
		
	}

	// klart
	public List<Car> getAllCar() {
		if (repository.findAll().isEmpty())
			throw new OurCustomExceptions("Bilar finns inte i tabell");
		else
			return repository.findAll();

	}

//klart
	public List<Car> getAllByBrand(Collection<String> brand) {
		if (repository.findByBrand(brand).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findByBrand(brand);

	}

	// klart
	public List<Car> getAllByBrandAndModel(Collection<String> brand, Collection<String> model) {
		if (repository.findAllByBrandAndModel(brand, model).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllByBrandAndModel(brand, model);
	}

	// klart
	public Car getCarById(int id) {
		return repository.findById(id).orElseThrow(() -> new OurCustomExceptions("Bil finns inte i tabell"));
	}

//klart
	public Car getCarByRegNr(String regNr) {
		if (repository.findByName(regNr) == null)
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findByName(regNr);
	}

	//klart
	public String deleteCar(int id) {
		//getCarByID testar bad request
		getCarById(id);
		repository.deleteById(id);
		return ("Bil med id= " + id + " är raderad");
	}

	// klart
	public String deleteCArByRegNr(String regNr) {
		Car gamlaCar = repository.findByName(regNr);
		if (gamlaCar == null) {
			throw new OurCustomExceptions("Bil finns inte i tabell");
		} else {
			repository.delete(gamlaCar);
			return "Bil med regNr= " + regNr + " är raderat";
		}

	}
//klart
	public Car updateCar(Car car) {
		Car gamlaCar = repository.findByName(car.getRegNr());
		
		if (gamlaCar==null)
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else {
		
		gamlaCar.setPrice(car.getPrice());
		gamlaCar.setKilometer(car.getKilometer());
		gamlaCar.setNew(car.isNew());
		gamlaCar.setNavigation(car.isNavigation());
		gamlaCar.setRentable(car.isRentable());
		return repository.save(gamlaCar);
	}}

	// klart
	public List<Car> getAllByBelowPrice(Integer price) {
		if (repository.findByBelowPrice(price).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findByBelowPrice(price);
	}

	// klart
	public List<Car> getAllBelowKilometer(Integer kilometer) {
		if (repository.findBelowKilometer(kilometer).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findBelowKilometer(kilometer);
	}

	//klart
	public List<Car> getAllAutomatic(boolean automatic) {
		if (repository.findIsAutomatic(automatic).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findIsAutomatic(automatic);
	}

	//klart
	public List<Car> getAllRentable(boolean isRentable) {
		if (repository.findAllRentable(isRentable).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllRentable(isRentable);
	}

	//klart
	public List<Car> getAllWithNavigation(boolean navigation) {
		if (repository.findAllWithNavigation(navigation).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllWithNavigation(navigation);
	}

	//klart
	public List<Car> getAllNewCar(boolean isNew) {
		if (repository.findAllNewCar(isNew).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllNewCar(isNew);
	}

	//klart
	public List<Car> getAllWithSameFuel(String fuel) {
		if (repository.findAllCarWithSameFuel(fuel).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllCarWithSameFuel(fuel);
	}

	//klart
	public List<Car> getAllWithSamaBrandAndFuel(Collection<String> brandName, Collection<String> fuel) {
		if (repository.findAllByBrandAndFuel(brandName, fuel).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllByBrandAndFuel(brandName, fuel);
	}

	//klart
	public List<Car> getAllWithSamaBrandModelAndFuel(Collection<String> brandName, Collection<String> modelName,
			Collection<String> fuel) {
		if (repository.findAllByBrandModelAndFuel(brandName, modelName, fuel).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findAllByBrandModelAndFuel(brandName, modelName, fuel);
	}

	//klart
	public List<Car> getAllCarByYear(Integer yearProduce) {
		if (repository.findCarsByYear(yearProduce).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findCarsByYear(yearProduce);
	}

	//klart
	public List<Car> getAllCarByColor(String color) {
		if (repository.findCarsByColor(color).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findCarsByColor(color);
	}

	public List<Car> getAllByTimeStored(Date timeStored) {
		if (repository.findCarByTimeStored(timeStored).isEmpty())
			throw new OurCustomExceptions("Bil finns inte i tabell");
		else
			return repository.findCarByTimeStored(timeStored);
	}

//	
//	public List<Car>getAllByModelName(String modelName){
//		return repository.findCarByModelName(modelName);
//	}

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
