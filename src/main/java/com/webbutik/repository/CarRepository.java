package com.webbutik.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.webbutik.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	
	Car findByName(String name);

	@Query(value = "SELECT u FROM Car u WHERE u.brandName IN :names")
	List<Car> findByBrand(@Param("names") Collection<String> brandName);

	@Query("SELECT u FROM Car u WHERE u.brandName IN :names AND u.modelName IN :models")
	List<Car> findAllByBrandAndModel(@Param("names") Collection<String> brandName,
			@Param("models") Collection<String> model);

	@Query(value = "SELECT u FROM Car u WHERE u.price <= :price")
	List<Car> findByBelowPrice(@Param("price") Integer price);

	@Query(value = "SELECT u FROM Car u WHERE u.kilometer <= :kilometer")
	List<Car> findBelowKilometer(@Param("kilometer") Integer kilometer);

	@Query(value = "SELECT u FROM Car u WHERE u.automatic IN :automatics")
	List<Car> findIsAutomatic(@Param("automatics") boolean automatic);

	@Query(value = "SELECT u FROM Car u WHERE u.isRentable IN :isRentables")
	List<Car> findAllRentable(@Param("isRentables") boolean isRentable);

	@Query(value = "SELECT u FROM Car u WHERE u.navigation IN :navigations")
	List<Car> findAllWithNavigation(@Param("navigations")boolean navigation);

	@Query(value = "SELECT u FROM Car u WHERE u.isNew IN :nya")
	List<Car> findAllNewCar(@Param("nya")  boolean nya);
	
	@Query(value = "SELECT u FROM Car u WHERE u.fuel IN :fuels")
	List<Car> findAllCarWithSameFuel(@Param("fuels" )String fuel);

	@Query("SELECT u FROM Car u WHERE u.brandName IN :names AND u.fuel IN :fuels")
	List<Car> findAllByBrandAndFuel(@Param("names") Collection<String> brandName, @Param("fuels") Collection<String> fuel);

	/**
	@Query("SELECT u FROM Car u WHERE u.brandName IN :names AND u.modelName IN :models")
	List<Car> findAllByBrandAndModel(@Param("names") Collection<String> brandName,
			@Param("models") Collection<String> model);
	 * 
	 * 
	 * 
	 * @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	 * User findUserByUserStatusAndUserName(@Param("status") Integer
	 * userStatus, @Param("name") String userName);
	 */

}