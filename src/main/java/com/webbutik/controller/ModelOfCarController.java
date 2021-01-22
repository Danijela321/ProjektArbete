package com.webbutik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.webbutik.entity.ModelOfCar;
import com.webbutik.service.ModelOfCarService;

@RestController
public class ModelOfCarController {

	
	@Autowired
	private ModelOfCarService service;
	
	
	@PostMapping("/saveModel")
	public ModelOfCar saveModel(@RequestBody ModelOfCar modelOfCar) {
		return service.saveModel(modelOfCar);
	}
	
	@DeleteMapping("/deleteModel/{id}")
	public String deleteModelById(@PathVariable int id) {
		return service.deleteModel(id);
	}
	
	
	@DeleteMapping("/deleteModel/modelName/{name}")
	public String deleteModelByName(@PathVariable String name) {
		return service.deleteModelByName(name);
	}

	@GetMapping("model/name/{name}")
	public ModelOfCar findModelByName(@PathVariable String name) {
		return service.getModelByName(name);
	}
		
}
