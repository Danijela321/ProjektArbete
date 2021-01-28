package com.webbutik.controller;



import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbutik.config.SecurityConfiguration;
import com.webbutik.entity.Car;
import com.webbutik.entity.ModelOfCar;
import com.webbutik.exception.NotAuthorized;
import com.webbutik.exception.OurServerException;
import com.webbutik.service.CarService;
import com.webbutik.service.ModelOfCarService;

/**
 * Mapping , satting path och requested body
 * @author Danijela
 *
 */
@RestController
public class CarController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarService service;

	/**
	 * Spara en car i tabell Car
	 * @param car Objekt i tabell Car
	 * @return Spara en car i tabell Car
	 * @throws OurServerException Om bil finns i tabell metoder kastar exception darfor att man kan inte spara tva bilar med samma namn dvs.regNr.
	 * @author Danijela
	 */
	@PostMapping("/saveCar")
	public Car saveCar(@RequestBody Car car) throws OurServerException {
		try {
			return service.saveCar(car);
		} catch (Exception e) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat.Bil finns  i tabell");
			throw new OurServerException("Bil finns  i tabell.");
		}
	}

	
	/**
	 * Alla bilar som fins i tabell Car
	 * @return List av alla bilar som fins i tabell Car
	 * @author Danijela
	 */
	@GetMapping("/cars")
	public List<Car> findAllCar() {
		return service.getAllCar();
	}

	/**
	 * Alla bilar som fins i tabell Car men bara om admin skickar request
	 * @return List av alla bilar som fins i tabell Car men bara om admin skickar request
	 * @author Danijela
	 */
	@GetMapping("/admin")
	public List<Car> AdminfindAllCar() {
		return service.getAllCar();
	}

	/**
	 * En bil med unik id
	 * @param id Id i tabell CAr
	 * @return En bil med unik id
	 * @author Danijela
	 */
	@GetMapping("/car/{id}")
	public Car findCarById(@PathVariable int id) {
		return service.getCarById(id);
	}

	/**
	 * En bil med unik regNr
	 * @param regNr Namn av bil
	 * @return En bil med unik regNr
	 * @author Danijela
	 */
	@GetMapping("/car/regNr/{regNr}")
	public Car findCarByRegNr(@PathVariable String regNr) {
		return service.getCarByRegNr(regNr);
	}

	/**
	 * Alla bilar med samma brand fran tabell CAr
	 * @param brand Volvo, Citroen, Ford...
	 * @return List av bilar med samma brand fran tabell CAr
	 * @author Danijela
	 */

	@GetMapping("/cars/brand/{brand}")
	public List<Car> getAllByBrand(@PathVariable Collection<String> brand) {// throws CarNotFound {
		return service.getAllByBrand(brand);
	}

	/**
	 * Alla bilar med samma brand och model
	 * @param brandName Volvo, Citroen, Ford...
	 * @param modelName  typ av model: m3, Clio,...
	 * @return List av bilar med samma brand och model
	 * @author Danijela
	 */
	@GetMapping("car/brand/{brandName}/model/{modelName}")
	public List<Car> findByBrandAndModel(@PathVariable Collection<String> brandName,
			@PathVariable Collection<String> modelName) {
		return service.getAllByBrandAndModel(brandName, modelName);
	}

	/**
	 * Alla bilar som ar billigare en prise som anvandare valde
	 * @param price Prise som anvandare satter in
	 * @return List av bilar som ar billigare en prise som anvandare valde
	 * @author Danijela
	 */
	@GetMapping("/car/BelowPrice/price/{price}")
	public List<Car> findBelowPrice(@PathVariable Integer price) {
		return service.getAllByBelowPrice(price);
	}

	/**
	 * Alla bilar fran tabell Car som har mindre kilometer an de som anvandare skrev
	 * @param kilometer Kilimeter som anvandare valde
	 * @return List bilar fran tabell Car som har mindre kilometer an de som anvandare skrev
	 * @author Danijela
	 */
	@GetMapping("/car/BelowKilometer/{kilometer}")
	public List<Car> findBelowKilometer(@PathVariable Integer kilometer) {
		return service.getAllBelowKilometer(kilometer);
	}

	/**
	 * Alla bilar med automatisk vaxel
	 * @param automatic Har eller ej automatisk växel
	 * @return List av bilar med automatisk vaxel
	 * @author Danijela
	 */
	@GetMapping("/car/automatic/{automatic}")
	public List<Car> findByAutomatic(@PathVariable boolean automatic) {
		return service.getAllAutomatic(automatic);
	}

	/**
	 * Alla bilar som man kan eller inte kan hyra ut
	 * @param isRentable Kan man hyra ut dem
	 * @return List av bilar som man kan hyra ut om isRentable==true, alla bilar som man kan inte hyra ut om isRentable==false
	 * @author Danijela
	 */
	@GetMapping("/car/rentable/isRentable/{isRentable}")
	public List<Car> findByRentable(@PathVariable boolean isRentable) {
		return service.getAllRentable(isRentable);
	}

	/**
	 * Alla bilar som har eller inte ha navigation
	 * @param navigation Har eller ej en bil navigation
	 * @return List av bilar som har(true) eller inte ha (false) navigation
	 * @author Danijela
	 */
	@GetMapping("/car/hasNavigation/{navigation}")
	public List<Car> findByNavigation(@PathVariable boolean navigation) {
		return service.getAllWithNavigation(navigation);
	}

	/**
	 * Alla bilar som ar nya eller begagnade
	 * @param isNew Ar bil ny eller ej
	 * @return List av bilar som ar nya(true) eller inte nya (false)
	 * @author Danijela
	 */
	@GetMapping("/car/nya/{isNew}")
	public List<Car> findByNew(@PathVariable boolean isNew) {
		return service.getAllNewCar(isNew);
	}

	/**
	 * Alla bilar som anvander samma typ av fuel
	 * @param fuel bensin, gas...
	 * @return List av bilar som anvander samma typ av fuel
	 * @author Danijela
	 */
	@GetMapping("/cars/fuel/{fuel}")
	public List<Car> getAllCarByFuel(@PathVariable String fuel) {
		return service.getAllWithSameFuel(fuel);
	}

	/**
	 * Alla bilar med samma brand och fuel
	 * @param brandName Volvo,Renault...
	 * @param fuel  bensin, gas..
	 * @return List av bilar med samma brand och fuel
	 * @author Danijela
	 */
	@GetMapping("car/brand/{brandName}/fuel/{fuel}")
	public List<Car> getAllCarByBrandAndFuel(@PathVariable Collection<String> brandName,
			@PathVariable Collection<String> fuel) {
		return service.getAllWithSamaBrandAndFuel(brandName, fuel);
	}

	/**
	 * Alla bilar som ar samma brand,model och anvander samma typ av fuel
	 * @param brandName Volvo, Renault..
	 * @param modelName m3, Clio....
	 * @param fuel bensin, gas
	 * @return List av bilar som ar samma brand,model och anvander samma typ av fuel
	 * @author Danijela
	 */
	@GetMapping("/car/brand/{brandName}/model/{modelName}/fuel/{fuel}")
	public List<Car> getAllCarByBrandAndModelAndFuel(@PathVariable Collection<String> brandName,
			@PathVariable Collection<String> modelName, @PathVariable Collection<String> fuel) {
		return service.getAllWithSamaBrandModelAndFuel(brandName, modelName, fuel);
	}

	/**
	 * Uptadera pris,kilometer, isRentable, har navigation
	 * @param car Uptadera pris,kilometer, isRentable, har navigation av en car
	 * @return updaterade car
	 * @author Danijela
	 */
	@PutMapping("/updateCar")
	public Car updateCar(@RequestBody Car car) {
		return service.updateCar(car);
	}

	/**
	 * Alla bilar som ar tillverkad samma ar
	 * @param yearProduce tilverkade ar
	 * @return List av bilar som ar tillverkad samma ar
	 * @author Danijela
	 */
	@GetMapping("/cars/year/{yearProduce}")
	public List<Car> getAllCarByYear(@PathVariable Integer yearProduce) {
		return service.getAllCarByYear(yearProduce);
	}

	/**
	 * Alla bilar med samma farg
	 * @param color Farg
	 * @return List av bilar med samma farg
	 * @author Danijela
	 */
	@GetMapping("/cars/color/{color}")
	public List<Car> getAllCarByColor(@PathVariable String color) {
		return service.getAllCarByColor(color);
	}

	/**
	 * Alla bilar som kom till butik med och efter date som anvandare valde
	 * @param timeStored Nar bil kom till butik
	 * @return En list av alla bilar som kom till butik med och efter date som anvandare valde
	 */
	@GetMapping("/cars/{timeStored}")
	public List<Car> getAllCarByTimeStored(@PathVariable Date timeStored){
		return service.getAllByTimeStored(timeStored);
	}
//	
//	@PutMapping("/updateCarPris")
//	public Car updatePrise(@RequestBody  Car car) {
//		return service.updatePrise(car, price);
//	}

//	@PutMapping("/updateCarIsRentable")
//	public Car updateRentable(@RequestBody Car car) {
//		return service.updateRentable(car);
//	}
//	
//	
//	@PutMapping("/updateCarIsNewAndKilometer")
//	public Car updateIsNewAndKilommeter(@RequestBody Car car) {
//		return service.updateIsNewAndKilommeter(car);
//	}

	/**
	 * Radera bil pga unik id
	 * @param id Id fran tabell
	 * @return Radera bil pga unik id
	 * @author Danijela
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteCarById(@PathVariable int id) {
		return service.deleteCar(id);
	}

	/**
	 * Radera bil pga namn
	 * @param regNr registration nummer, dvs bils namn
	 * @return Radera bil pga namn
	 * @author Danijela
	 */
	@DeleteMapping("/delete/regNr/{regNr}")
	public String deleteCarByRegNr(@PathVariable String regNr) {
		return service.deleteCArByRegNr(regNr);
	}

}
