package com.webbutik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.entity.ModelOfCar;
import com.webbutik.repository.ModelOfCarRepository;

@Transactional
@Service
public class ModelOfCarService {

	@Autowired
	private ModelOfCarRepository repository;


	public ModelOfCar saveModel(ModelOfCar modelOfCar) {
		return repository.save(modelOfCar);
	}


	public String deleteModel(int id) {
		repository.deleteById(id);
		return ("Model med id= " + id + " är raderad");
	}

	public String deleteModelByName(String name) {
		ModelOfCar gamlaModel=repository.findByName(name);
		repository.delete(gamlaModel);
		return ("Mode " + name + " är raderad");		

	}

	public ModelOfCar getModelByName(String name) {
		return repository.findByName(name);
	}

}
