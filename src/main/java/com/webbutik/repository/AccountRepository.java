package com.webbutik.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.webbutik.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query(value = "SELECT u FROM Account u WHERE u.id IN :id")
	Account findById(@Param("id") int id);

	@Query(value = "SELECT u FROM Account u WHERE u.email IN :email")
	void deleteByEmail(@Param("email") String email);

	@Query(value = "SELECT u FROM Account u WHERE u.firstName IN :name")
	List<Account> findByName(@Param("name") String firstName);

	@Query(value = "SELECT u FROM Account u WHERE u.surname IN :surname")
	List<Account> findBySurname(@Param("surname") String surname);

	@Query("SELECT u FROM Account u WHERE u.firstName IN :name AND u.surname IN :surname")
	List<Account> findByFullName(@Param("name") String firstName, @Param("surname") String surname);

	@Query(value = "SELECT u FROM Account u WHERE u.email IN :email")
	Account findByEmail(@Param("email") String email);

	@Query(value = "SELECT u FROM Account u WHERE u.accessLevel IN :level")
	List<Account> findByAccessLevel(@Param("level") int accessLevel);

	@Query(value = "SELECT u FROM Account u WHERE u.premiumMember IN :premiumMember")
	List<Account> findByMember(@Param("premiumMember") boolean premiumMember);

	@Query("SELECT u FROM Account u WHERE u.email IN :email AND u.password IN :password")
	Account findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query(value = "SELECT u FROM Account u WHERE u.email IN :email")
	boolean existsByEmail(@Param("email") String email);

}
