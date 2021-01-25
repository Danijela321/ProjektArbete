package com.webbutik.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
public class ModelOfCarService {

	@Autowired
	private ModelOfCarRepository repository;

	 @Autowired
	private CarRepository carRepository;

	public ModelOfCar saveModel(ModelOfCar modelOfCar) {
		return repository.save(modelOfCar);
	}

	public String deleteModel(Integer id) {

		repository.findById(id).orElseThrow(() -> new OurCustomExceptions("Model finns inte i tabell"));
		repository.deleteById(id);
		return ("Model med id= " + id + " är raderad");
	}

	public String deleteModelByName(String name) {
				
		ModelOfCar gamlaModel = repository.findByName(name);
		if (gamlaModel == null) {
			throw new OurCustomExceptions("Model finns inte i tabell");
		}
		else {
			repository.delete(gamlaModel);
			return ("Mode " + name + " är raderad");
		}
	}

	public ModelOfCar getModelByName(String name) {
		if (repository.findByName(name) == null)
			throw new OurCustomExceptions("Model finns inte i tabell");
		else
			return repository.findByName(name);
	}

}
