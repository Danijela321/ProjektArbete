package com.webbutik.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbutik.entity.Car;
import com.webbutik.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService service;

	@PostMapping("/saveCar")
	public Car saveCar(@RequestBody Car car) {
		return service.saveCar(car);
	}

	@GetMapping("/cars")
	public List<Car> findAllCar() {
		return service.getAllCar();
	}

	@GetMapping("/car/{id}")
	public Car findCarById(@PathVariable int id) {
		return service.getCarById(id);
	}

	@GetMapping("/car/regNr/{regNr}")
	public Car findCarByRegNr(@PathVariable String regNr) {
		return service.getCarByRegNr(regNr);
	}
	
	
	@GetMapping("/cars/brand/{brand}")
	public List<Car> getAllByBrand(@PathVariable Collection<String> brand) {//throws CarNotFound {
		return service.getAllByBrand(brand);
	}
	
	@GetMapping("car/brand/{brandName}/model/{modelName}")
	public List<Car>findByBrandAndModel(@PathVariable Collection<String> brandName, @PathVariable Collection<String> modelName)
	{return service.getAllByBrandAndModel(brandName,modelName);}
	
	@GetMapping("/car/BelowPrice/price/{price}")
	public List<Car> findBelowPrice(@PathVariable Integer price){
		return service.getAllByBelowPrice(price);
	}
	
	@GetMapping("/car/BelowKilometer/{kilometer}")
	public List<Car> findBelowKilometer(@PathVariable Integer kilometer) {
		return service.getAllBelowKilometer(kilometer);
	}

	@GetMapping("/car/automatic/{automatic}")
	public List<Car> findByAutomatic(@PathVariable boolean automatic){
		return service.getAllAutomatic(automatic);
	}
	
	@GetMapping("/car/rentable/isRentable/{isRentable}")
	public List<Car> findByRentable(@PathVariable boolean isRentable){
		return service.getAllRentable(isRentable);
	}
	
	@GetMapping("/car/hasNavigation/{navigation}")
	public List<Car> findByNavigation(@PathVariable boolean navigation){
		return service.getAllWithNavigation(navigation);
	}
	
	
	@GetMapping("/car/nya/{isNew}")
	public List<Car> findByNew(@PathVariable boolean isNew){
		return service.getAllNewCar(isNew);
	}
		
		
	@GetMapping("/cars/fuel/{fuel}")
		public List<Car> getAllCarByFuel(@PathVariable String fuel){
			return service.getAllWithSameFuel(fuel);
		}
		
	@GetMapping("car/brand/{brandName}/fuel/{fuel}")
	public List<Car> getAllCarByBrandAndFuel(@PathVariable Collection<String> brandName,@PathVariable Collection<String> fuel){
		return service.getAllWithSamaBrandAndFuel(brandName,fuel);
			}
	
	
	
	
	@PutMapping("/updateCar")
	public Car updateCar(@RequestBody Car car) {
		return service.updateCar(car);
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
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteCarById(@PathVariable int id) {
		return service.deleteCar(id);
	}
	
	@DeleteMapping("/delete/regNr/{regNr}")
	public String deleteCarByRegNr(@PathVariable String regNr) {
		return service.deleteCArByRegNr(regNr);
	}

}
