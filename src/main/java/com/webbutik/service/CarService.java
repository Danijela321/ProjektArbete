package com.webbutik.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.controller.CarController;
import com.webbutik.entity.Car;
import com.webbutik.entity.ModelOfCar;
import com.webbutik.exception.OurCustomExceptions;
import com.webbutik.exception.OurException;
import com.webbutik.exception.OurServerException;
import com.webbutik.repository.CarRepository;
import com.webbutik.repository.ModelOfCarRepository;

@Transactional
@Service
public class CarService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);
	@Autowired
	private CarRepository repository;

	// för att koppla car med model i modelOfCarTAble
	@Autowired
	private ModelOfCarRepository modelRepository;

	//klart
	public Car saveCar(Car car) throws Exception {
		ModelOfCar modelofcar = new ModelOfCar();
		String namnModelOfCar = modelofcar.getName();
		namnModelOfCar = car.getModelName();
		modelofcar = modelRepository.findByName(namnModelOfCar);
		
		Car existingCar = repository.findByName(car.getName());
		
		if(existingCar==null) {		
		car.setModelOfCarName(modelofcar);
		return repository.save(car);}
		else
			throw new OurServerException("Bil finns  i tabell");
	}

	// klart
	public List<Car> getAllCar() {
		if (repository.findAll().isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat: Där finns inte bilar");
			throw new OurCustomExceptions("Bilar finns inte i tabell");}
		else
			return repository.findAll();

	}

//klart
	public List<Car> getAllByBrand(Collection<String> brand) {
		if (repository.findByBrand(brand).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findByBrand(brand);

	}

	// klart
	public List<Car> getAllByBrandAndModel(Collection<String> brand, Collection<String> model) {
		if (repository.findAllByBrandAndModel(brand, model).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand och model");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllByBrandAndModel(brand, model);
	}

	// klart
	public Car getCarById(int id) {
		if(repository.findById(id).isEmpty())
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat.Bil finns inte i tabell");
		return repository.findById(id).orElseThrow(()  -> new OurCustomExceptions("Bil finns inte i tabell") );
	}
	
//klart
	public Car getCarByRegNr(String regNr) {
		if (repository.findByName(regNr) == null)
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma reg.numer");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
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
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma reg.nr.");
			throw new OurCustomExceptions("Bil finns inte i tabell");
		} else {
			repository.delete(gamlaCar);
			return "Bil med regNr= " + regNr + " är raderat";
		}

	}
//klart
	public Car updateCar(Car car) {
		Car gamlaCar = repository.findByName(car.getRegNr());
		
		if (gamlaCar==null) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med sama reg.nr");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
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
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga biligare bil");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findByBelowPrice(price);
	}

	// klart
	public List<Car> getAllBelowKilometer(Integer kilometer) {
		if (repository.findBelowKilometer(kilometer).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med mindre kilometer");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findBelowKilometer(kilometer);
	}

	//klart
	public List<Car> getAllAutomatic(boolean automatic) {
		if (repository.findIsAutomatic(automatic).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga automatic bil");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findIsAutomatic(automatic);
	}

	//klart
	public List<Car> getAllRentable(boolean isRentable) {
		if (repository.findAllRentable(isRentable).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil som man kan hyra ut");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllRentable(isRentable);
	}

	//klart
	public List<Car> getAllWithNavigation(boolean navigation) {
		if (repository.findAllWithNavigation(navigation).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med navigation");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllWithNavigation(navigation);
	}

	//klart
	public List<Car> getAllNewCar(boolean isNew) {
		if (repository.findAllNewCar(isNew).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga nya bil");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllNewCar(isNew);
	}

	//klart
	public List<Car> getAllWithSameFuel(String fuel) {
		if (repository.findAllCarWithSameFuel(fuel).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma fuel");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllCarWithSameFuel(fuel);
	}

	//klart
	public List<Car> getAllWithSamaBrandAndFuel(Collection<String> brandName, Collection<String> fuel) {
		if (repository.findAllByBrandAndFuel(brandName, fuel).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand ochfuel");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllByBrandAndFuel(brandName, fuel);
	}

	//klart
	public List<Car> getAllWithSamaBrandModelAndFuel(Collection<String> brandName, Collection<String> modelName,
			Collection<String> fuel) {
		if (repository.findAllByBrandModelAndFuel(brandName, modelName, fuel).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand och model samt fuel");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllByBrandModelAndFuel(brandName, modelName, fuel);
	}

	//klart
	public List<Car> getAllCarByYear(Integer yearProduce) {
		if (repository.findCarsByYear(yearProduce).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil som är gjort detta år");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findCarsByYear(yearProduce);
	}

	//klart
	public List<Car> getAllCarByColor(String color) {
		if (repository.findCarsByColor(color).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma färg");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findCarsByColor(color);
	}

	public List<Car> getAllByTimeStored(Date timeStored) {
		if (repository.findCarByTimeStored(timeStored).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bilsom ligger på lager mindre tid");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
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
