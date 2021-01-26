package com.webbutik.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbutik.entity.ModelOfCar;

import com.webbutik.exception.OurCustomExceptions;
import com.webbutik.exception.OurServerException;
import com.webbutik.repository.CarRepository;
import com.webbutik.service.ModelOfCarService;

@RestController
public class ModelOfCarController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ModelOfCarController.class);


	@Autowired
	private ModelOfCarService service;

	@PostMapping("/saveModel")
	public ModelOfCar saveModel(@RequestBody ModelOfCar modelOfCar) throws OurServerException {
		try {
			return service.saveModel(modelOfCar);
		} catch (Exception e) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat");
			throw new OurServerException("Model finns  i tabell");
		}
	}

	@DeleteMapping("/deleteModel/{id}")
	public String deleteModelById(@PathVariable int id) throws OurServerException {
		try {
			return service.deleteModel(id);
		} catch (Exception e) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat");
			throw new OurServerException("Tyvärr kan model inte raderas!");
		}
	}

	@DeleteMapping("/deleteModel/modelName/{name}")
	public String deleteModelByName(@PathVariable String name) throws OurServerException {
		try {
			return service.deleteModelByName(name);
		} catch (Exception e) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat");
			throw new OurServerException("Tyvärr kan model inte raderas!");
		}
	}

	@GetMapping("model/name/{name}")
	public ModelOfCar findModelByName(@PathVariable String name) {
	
		return service.getModelByName(name);

	}

}
