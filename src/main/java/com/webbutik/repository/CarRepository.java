package com.webbutik.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.webbutik.entity.Car;
import com.webbutik.entity.ModelOfCar;

/**
 * Repository- hamta data fran databasen
 * JPA @Query annonation
 * @author Danijela
 *
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	
	/**
	 * 
	 * @param name Reg. nr.
	 * @return En Car pga unik namn dvs. reg.nr.
	 * @author Danijela
	 */
	Car findByName(String name);

	/**
	 * 
	 * @param brandName Volvo, Renault..
	 * @return En lista av bilar pga brand
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.brandName IN :names")
	List<Car> findByBrand(@Param("names") Collection<String> brandName);

	/**
	 * 
	 * @param brandName Volvo, Renault..
	 * @param model m3, Clio ..
	 * @return En lista av bilar far pga brand och model
	 * @author Danijela
	 */
	@Query("SELECT u FROM Car u WHERE u.brandName IN :names AND u.modelName IN :models")
	List<Car> findAllByBrandAndModel(@Param("names") Collection<String> brandName,
			@Param("models") Collection<String> model);

	/**
	 * 
	 * @param price Prise som anvandare valde
	 * @return En lista av bilar som ar biligare an prise som anvandare valde
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.price <= :price")
	List<Car> findByBelowPrice(@Param("price") Integer price);

	/**
	 * 
	 * @param kilometer Kilometer som anvandare valde
	 * @return En lista av bilar som har mindre kilometer an den som anvandare valde
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.kilometer <= :kilometer")
	List<Car> findBelowKilometer(@Param("kilometer") Integer kilometer);

	/**
	 * 
	 * @param automatic Automatisk vaxel
	 * @return List av bilar med automatisk eller en lista med manuell vaxel
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.automatic IN :automatics")
	List<Car> findIsAutomatic(@Param("automatics") boolean automatic);

	/**
	 * 
	 * @param isRentable Man kan eller inte kan hyra ut bil
	 * @return Lista av bilar som man kan eller en lista av bilar som man inte kan hyra ut
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.isRentable IN :isRentables")
	List<Car> findAllRentable(@Param("isRentables") boolean isRentable);

	/**
	 * 
	 * @param navigation Bil har eller inte har navigation
	 * @return en lista av bilar som har eller en lista av bilar som inte har navigation
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.navigation IN :navigations")
	List<Car> findAllWithNavigation(@Param("navigations") boolean navigation);

	/**
	 * 
	 * @param nya Nya bilar eller begagnade bilar
	 * @return En lista av nya bilar eller en lista av begagnade bilar
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.isNew IN :nya")
	List<Car> findAllNewCar(@Param("nya") boolean nya);

	/**
	 * 
	 * @param fuel Bensin, gas...
	 * @return En lista av bilar med samma typ av fuel
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.fuel IN :fuels")
	List<Car> findAllCarWithSameFuel(@Param("fuels") String fuel);
	/**
	 * 
	 * @param brandName Volvo, Renault...
	 * @param fuel Bensin , gas ..
	 * @return En lista av bilar som ar samma brand och anvander sama typ av fuel
	 * @author Danijela
	 */
	@Query("SELECT u FROM Car u WHERE u.brandName IN :names AND u.fuel IN :fuels")
	List<Car> findAllByBrandAndFuel(@Param("names") Collection<String> brandName,
			@Param("fuels") Collection<String> fuel);

	/**
	 * 
	 * @param brandName Volvo, Renault ..
	 * @param modelName m3, Clio...
	 * @param fuel Bensin, gas..
	 * @return En lista av bilar som ar samma brand, samma typ av model och anvander samma fuel
	 * @author Danijela
	 */
	@Query("SELECT u FROM Car u WHERE u.brandName IN :names AND u.modelName IN :models AND u.fuel IN :fuels")
	List<Car> findAllByBrandModelAndFuel(@Param("names") Collection<String> brandName,
			@Param("models") Collection<String> modelName, @Param("fuels") Collection<String> fuel);
	/**
	 * 
	 * @param yearProduce Ar när ar bil tillverkad
	 * @return En lista av bilar som ar tillverkad samma ar
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.yearProduce IN :years")
	List<Car> findCarsByYear(@Param("years") Integer yearProduce);

	/**
	 * 
	 * @param color Farg
	 * @return En lista av bilar som har samma farg
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE lower (u.color) IN :colors")
	List<Car> findCarsByColor(@Param("colors") String color);

	/**
	 * 
	 * @param timeStored Tid när bilen kom till butik
	 * @return En lista av bilar som kom till butik på samma tid
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.timeStored <= :timeStored")
	List<Car> findCarByTimeStored(@Param("timeStored") Date timeStored);

	/**
	 * 
	 * @param modelName typ av car, model: m3, Clio...
	 * @return En lista av bilar som ar samma typ
	 * @author Danijela
	 */
	@Query(value = "SELECT u FROM Car u WHERE u.modelName IN :modelNames")
	List<Car> findCarsByModelName(@Param("modelNames") String modelName);



}
