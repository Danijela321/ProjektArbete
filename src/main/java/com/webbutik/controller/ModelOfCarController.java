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

/**
 * Mapping , satting path och requested body
 * @author Danijela
 *
 */
@RestController
public class ModelOfCarController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ModelOfCarController.class);


	@Autowired
	private ModelOfCarService service;

/**
 * Skapa en model av bil i modelOfCAr tabell
 * @param modelOfCar Clio, Focus, m3...
 * @return Skapa en model av bil i modelOfCAr tabell
 * @author Danijela
 */
	@PostMapping("/saveModel")
	public ModelOfCar saveModel(@RequestBody ModelOfCar modelOfCar)  {
		
			return service.saveModel(modelOfCar);

	}

	/**
	 * Radera model av bil pga unik id
	 * @param id Id i tabell
	 * @return String med meddelande att model av bil är raderad
	 * @throws OurServerException Om model finns inte i tabell eller denna model finns i tabell Car
	 * kastar metoden exceprion pga sql exception(violation of foreign key)
	 * @author Danijela
	 */
	@DeleteMapping("/deleteModel/{id}")
	public String deleteModelById(@PathVariable int id) throws OurServerException {
		try {
			return service.deleteModel(id);
		} catch (Exception e) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat");
			throw new OurServerException("Tyvärr kan model inte raderas!");
		}
	}

	/**
	 * Radera model av bil pga unik name, dvs pga typ av model
	 * @param name model av bil
	 * @return String med meddelande att model av bil är raderad
	 * @throws OurServerException Om model finns inte i tabell eller denna model finns i tabell Car
	 * kastar metoden exceprion pga sql exception(violation of foreign key)
	 * @author Danijela
	 */
	@DeleteMapping("/deleteModel/modelName/{name}")
	public String deleteModelByName(@PathVariable String name) throws OurServerException {
		try {
			return service.deleteModelByName(name);
		} catch (Exception e) {
			LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat");
			throw new OurServerException("Tyvärr kan model inte raderas!");
		}
	}

	/**
	 * Hamta en model av bil pga namn
	 * @param name model av bil
	 * @return en model av bil pga namn
	 * @author Danijela
	 */
	@GetMapping("model/name/{name}")
	public ModelOfCar findModelByName(@PathVariable String name) {
	
		return service.getModelByName(name);

	}
	


}
