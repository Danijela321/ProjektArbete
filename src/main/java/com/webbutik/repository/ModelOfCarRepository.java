package com.webbutik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webbutik.entity.ModelOfCar;

@Repository
public interface ModelOfCarRepository extends JpaRepository<ModelOfCar, Integer>{

	ModelOfCar findByName(String name);	

}
