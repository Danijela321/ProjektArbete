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

/**
 * Servis av Car
 * @author Danijela
 *
 */
@Transactional
@Service
public class CarService {
	/**
	 * Loggning med hjalp av LoggerFactory.getLogger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);
	@Autowired
	private CarRepository repository;

	// för att koppla car med model i modelOfCarTAble
	@Autowired
	private ModelOfCarRepository modelRepository;

	//klart
	/**
	 * Skapar en ny bil i tabell car
	 * @param car En ny bil
	 * @return  Skapar en ny bil i tabell car
	 * @author Danijela
	 */
	public Car saveCar(Car car)  {
		ModelOfCar modelofcar = new ModelOfCar();
		String namnModelOfCar = modelofcar.getName();
		namnModelOfCar = car.getModelName();
		modelofcar = modelRepository.findByName(namnModelOfCar);
		
		Car existingCar = repository.findByName(car.getName());
		
		if(existingCar==null) {		
		car.setModelOfCarName(modelofcar);
		return repository.save(car);}
		else {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat.Bil finns  i tabell");			
			throw new OurCustomExceptions("Bil finns i tabell");
		}
	}

	// klart
	/**
	 * List av alla bilar. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @return List av alla bilar
	 * @author Danijela
	 */
	public List<Car> getAllCar() {
		if (repository.findAll().isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat: Där finns inte bilar");
			throw new OurCustomExceptions("Bilar finns inte i tabell");}
		else
			return repository.findAll();

	}

//klart
	/**
	 * List av alla bilar med samma brand. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param brand Volvo, Renault...
	 * @return List av alla bilar med samma brand
	 * @author Danijela
	 */
	public List<Car> getAllByBrand(Collection<String> brand) {
		if (repository.findByBrand(brand).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findByBrand(brand);

	}

	// klart
	/**
	 * List av alla bilar med samma brand och model.Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param brand Volvo, Renault...
	 * @param model m3, Clio...
	 * @return  List av alla bilar med samma brand och model
	 * @author Danijela
	 */
	public List<Car> getAllByBrandAndModel(Collection<String> brand, Collection<String> model) {
		if (repository.findAllByBrandAndModel(brand, model).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand och model");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllByBrandAndModel(brand, model);
	}

	// klart
	/**
	 * Hamtar en bil fran tabell car pga unik id. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param id Unik id i tabell
	 * @return En bil med exact id
	 * @author Danijela
	 */
	public Car getCarById(int id) {
		if(repository.findById(id).isEmpty())
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat.Bil finns inte i tabell");
		return repository.findById(id).orElseThrow(()  -> new OurCustomExceptions("Bil finns inte i tabell") );
	}
	
//klart
	/**
	 *  Hamtar en bil fran tabell car pga unik regNr. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param regNr Unik registration nummer
	 * @return En bil med exact regNr
	 * @author Danijela
	 */
	public Car getCarByRegNr(String regNr) {
		if (repository.findByName(regNr) == null)
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma reg.numer");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findByName(regNr);
	}

	//klart
	/**
	 * Radera bil fran tabell car pga unik id
	 * @param id Unik id i tabell car
	 * @return Radera bil fran tabell car pga unik id
	 * @author Danijela
	 */
	public String deleteCar(int id) {
		//getCarByID testar bad request
		getCarById(id);
		repository.deleteById(id);
		return ("Bil med id= " + id + " är raderad");
	}

	// klart
	/**
	 * Radera bil fran tabell car pga unik regNr. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param regNr Unik registration nummer i tabell car
	 * @return Radera bil fran tabell car pga unik regNr
	 * @author Danijela
	 */
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
	/**
	 * Updatera pris,kilometer, isRentable, har navigation av en bil pga regNr. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param car En bil 
	 * @return Updatera pris,kilometer, isRentable, har navigation
	 * @author Danijela
	 */
	public Car updateCar(Car car) {
		Car gamlaCar = repository.findByName(car.getName());
		
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
	/**
	 * En list av bilar som ar billigaste an prise som anvandare valjer. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param price Prise av bil
	 * @return En list av bilar som ar billigaste an prise som anvandare valjer
	 * @author Danijela
	 */
	public List<Car> getAllByBelowPrice(Integer price) {
		if (repository.findByBelowPrice(price).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga biligare bil");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findByBelowPrice(price);
	}

	// klart
	/**
	 * En list av bilar som har mindre kilometer an kilometer som anvandare valde
	 * Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param kilometer Kilometer
	 * @return En list av bilar som har mindre kilometer an kilometer som anvandare valde
	 * @author Danijela
	 */
	public List<Car> getAllBelowKilometer(Integer kilometer) {
		if (repository.findBelowKilometer(kilometer).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med mindre kilometer");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findBelowKilometer(kilometer);
	}

	//klart
	/**
	 * List av bilar som har eller inte har automatisk vaxel. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param automatic Automatisk vaxel 
	 * @return alla bilar som har eller inte har automatisk vaxel
	 * @author Danijela
	 */
	public List<Car> getAllAutomatic(boolean automatic) {
		if (repository.findIsAutomatic(automatic).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga automatic bil");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findIsAutomatic(automatic);
	}

	//klart
	/**
	 * List av bilar som man kan eller inte kan hyra ut. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param isRentable Kan man hyra ut dem
	 * @return Alla bilar som man kan (true) eller inte kan (false) hyra ut
	 * @author Danijela
	 */
	public List<Car> getAllRentable(boolean isRentable) {
		if (repository.findAllRentable(isRentable).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil som man kan hyra ut");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllRentable(isRentable);
	}

	//klart
	/**
	 * Alla bilar som har(true) eller inte ha (false) navigation.  Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param navigation Har eller ej en bil navigation
	 * @return Alla bilar som har(true) eller inte ha (false) navigation
	 * @author Danijela
	 */
	public List<Car> getAllWithNavigation(boolean navigation) {
		if (repository.findAllWithNavigation(navigation).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med navigation");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllWithNavigation(navigation);
	}

	//klart
	/**
	 * Alla bilar som ar nya(true) eller inte nya (false). Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param isNew Ar bil ny eller begagnade
	 * @return Alla bilar som ar nya(true) eller inte nya (false)
	 * @author Danijela
	 */
	public List<Car> getAllNewCar(boolean isNew) {
		if (repository.findAllNewCar(isNew).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga nya bil");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllNewCar(isNew);
	}

	//klart
	/**
	 * List bilar som anvander samma typ av fuel. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param fuel Bensin, gas...
	 * @return Alla bilar som anvander samma typ av fuel
	 * @author Danijela
	 */
	public List<Car> getAllWithSameFuel(String fuel) {
		if (repository.findAllCarWithSameFuel(fuel).isEmpty())
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma fuel");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllCarWithSameFuel(fuel);
	}

	//klart
	/**
	 * Alla bilar med samma brand och fuel. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param brandName Volvo, Renault...
	 * @param fuel Bensin, gas...
	 * @return Alla bilar med samma brand och fuel
	 * @author Danijela
	 */
	public List<Car> getAllWithSamaBrandAndFuel(Collection<String> brandName, Collection<String> fuel) {
		if (repository.findAllByBrandAndFuel(brandName, fuel).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand ochfuel");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllByBrandAndFuel(brandName, fuel);
	}

	//klart
	/**
	 * Alla bilar som ar samma brand,model och anvander samma typ av fuel. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param brandName Volvo, Renault..
	 * @param modelName m3, Clio...
	 * @param fuel Bensin, gas...
	 * @return Alla bilar som ar samma brand,model och anvander samma typ av fuel
	 * @author Danijela
	 */
	public List<Car> getAllWithSamaBrandModelAndFuel(Collection<String> brandName, Collection<String> modelName,
			Collection<String> fuel) {
		if (repository.findAllByBrandModelAndFuel(brandName, modelName, fuel).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma brand och model samt fuel");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findAllByBrandModelAndFuel(brandName, modelName, fuel);
	}

	//klart
	/**
	 * Alla bilar som ar tillverkad samma ar. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param yearProduce  Tillverkade ar
	 * @return List av bilar som ar tillverkad samma ar
	 * @author Danijela
	 */
	public List<Car> getAllCarByYear(Integer yearProduce) {
		if (repository.findCarsByYear(yearProduce).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil som är gjort detta år");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findCarsByYear(yearProduce);
	}

	//klart
	/**
	 * Alla bilar med samma farg. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param color Farg
	 * @return List av bilar med samma farg
	 * @author Danijela
	 */
	public List<Car> getAllCarByColor(String color) {
		if (repository.findCarsByColor(color).isEmpty()) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat. Där finns inga bil med samma färg");
			throw new OurCustomExceptions("Bil finns inte i tabell");}
		else
			return repository.findCarsByColor(color);
	}

	/**
	 * Alla bilar som kom till butik med och efter date som anvandare valde. Om bil finns inte i tabell kastar metoder exception: OurCustomExceptions.
	 * @param timeStored Nar bil kom till butik
	 * @return En list av alla bilar som kom till butik med och efter date som anvandare valde
	 * @author Danijela
	 */
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
