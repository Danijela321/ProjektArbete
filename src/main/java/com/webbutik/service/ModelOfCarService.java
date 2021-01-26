package com.webbutik.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.entity.Car;
import com.webbutik.entity.ModelOfCar;
import com.webbutik.exception.OurCustomExceptions;
import com.webbutik.exception.OurServerException;
import com.webbutik.repository.CarRepository;
import com.webbutik.repository.ModelOfCarRepository;

@Transactional
@Service
public class ModelOfCarService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ModelOfCarService.class);

	@Autowired
	private ModelOfCarRepository repository;

	@Autowired
	private CarRepository carRepository;

	public ModelOfCar saveModel(ModelOfCar modelOfCar) throws Exception {
		ModelOfCar existingModel = repository.findByName(modelOfCar.getName());
		if (existingModel == null)
			return repository.save(modelOfCar);
		else
			{
			throw new OurServerException("Model finns  i tabell");}

	}

	public String deleteModel(Integer id) throws OurServerException {
		ModelOfCar existingModel = repository.findById(id).get();
		String nameOfExistingModel = existingModel.getName();
		List<Car> existingCar = carRepository.findCarsByModelName(nameOfExistingModel);

		if (existingCar.isEmpty()) {
			repository.findById(id).get();
			repository.deleteById(id);
			return ("Model med id= " + id + " är raderad");
		} else
			{
			throw new OurServerException("Tyvärr kan model inte raderas!");}
	}

	public String deleteModelByName(String name) throws OurServerException {

		ModelOfCar gamlaModel = repository.findByName(name);
		String nameOfExistingModel = gamlaModel.getName();
		List<Car> existingCar = carRepository.findCarsByModelName(nameOfExistingModel);

		if (existingCar.isEmpty() || existingCar.equals(null)) {

			repository.delete(gamlaModel);
			return ("Mode " + name + " är raderad");
		} else
			{
			throw new OurServerException("Tyvärr kan model inte raderas!");}
	}

	public ModelOfCar getModelByName(String name) {
		if (repository.findByName(name) == null)
		{LOGGER.error("Spring Boot informerar mig om att ett fel har inträffat");
			throw new OurCustomExceptions("Model finns inte i tabell");}
		else
			return repository.findByName(name);
	}

}
