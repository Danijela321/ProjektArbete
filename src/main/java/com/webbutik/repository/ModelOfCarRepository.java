package com.webbutik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webbutik.entity.ModelOfCar;

/**
 * Repository- hamta data fran databasen
 * JPA @Query annonation
 * @author Danijela
 *
 */
@Repository
public interface ModelOfCarRepository extends JpaRepository<ModelOfCar, Integer>{
/**
 * 
 * @param name Typ av model: m3, Clio
 * @return
 */
	ModelOfCar findByName(String name);	

}
