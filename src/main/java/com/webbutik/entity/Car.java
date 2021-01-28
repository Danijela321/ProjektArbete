package com.webbutik.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity for tabell CAr
 * @author Danijela
 *
 */
@Entity
@Table(name = "Car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true, nullable = false)
	private String name; // regist.nummer
	private String brandName; // (Volvo, BMW, Reanult)
	private String modelName; // (Clio, Reanult 4)
	private int yearProduce;
	private String fuel; // bensin,gas,diesel
	private String color; // färg
	private int price; // pris
	private int kilometer; // kilometer
	private boolean isNew; // ny
	private boolean navigation; // navigation
	private boolean automatic; // automatisk
	private boolean isRentable; // går att hyra
	private Date timeStored; // tid på lager (från denna dag till nu)
	
	/**
	 * Relation OneToOne mellan tabeller CAr och modelOfCar
	 *  @author Danijela
	 */
	@OneToOne
	private ModelOfCar modelOfCarName;

	/**
	 * 
	 * @return model of car
	 *  @author Danijela
	 */
	public ModelOfCar getModelOfCarName() {
		return modelOfCarName;
	}

	/**
	 * 
	 * @param modelOfCarName Satter en model of car
	 *  @author Danijela
	 */
	public void setModelOfCarName(ModelOfCar modelOfCarName) {
		this.modelOfCarName = modelOfCarName;
	}

	/**
	 * En tom konstruktor
	 * @author Danijela
	 */
	public Car() {
	}

	/**
	 * Konstruktor av Car entity
	 * @param id Unik id i databas
	 * @param name Reg. nr. av bil, unik
	 * @param brandName Volvo, Renault...
	 * @param modelName Clio, Focus ,m3....
	 * @param yearProduce Tillverkade  ar
	 * @param fuel bensin, gas..
	 * @param color  Farg
	 * @param price Dyraste prise som valjer en anvandare
	 * @param kilometer Storsta kilometer som valjer anvandare
	 * @param isNew Ar bil ny eller begagnad
	 * @param navigation Har bil navigation eller ej
	 * @param automatic Har bil navigation eller ej
	 * @param isRentable Kan man hyra ut bilen eller ej
	 * @param timeStored När bilen kommer till butik
	 * @author Danijela
	 */
	public Car(int id, String name, String brandName, String modelName, int yearProduce, String fuel, String color,
			int price, int kilometer, boolean isNew, boolean navigation, boolean automatic, boolean isRentable,
			Date timeStored) {
		super();
		this.id = id;
		this.name = name;
		this.brandName = brandName;
		this.modelName = modelName;
		this.yearProduce = yearProduce;
		this.fuel = fuel;
		this.color = color;
		this.price = price;
		this.kilometer = kilometer;
		this.isNew = isNew;
		this.navigation = navigation;
		this.automatic = automatic;
		this.isRentable = isRentable;
		this.timeStored = timeStored;
	}

	/**
	 * 
	 * @return namn av bilen, dvs.reg.nr
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name namn av bilen
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return unik id fran databasen
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id unik id i databasen
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return namn av bilen
	 */
	public String getRegNr() {
		return name;
	}

	/**
	 * 
	 * @param regNr namn av bilen
	 */
	public void setRegNr(String regNr) {
		this.name = regNr;
	}

	/**
	 * 
	 * @return brand av bilen
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 
	 * @param brandName Volvo, Renault..
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * 
	 * @return typ av bil model
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 
	 * @param modelName Clio, m3, Focus...
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * 
	 * @return year
	 */
	public int getYearProduce() {
		return yearProduce;
	}

	/**
	 * 
	 * @param yearProduce Ar när bilen ar tillverkad
	 */
	public void setYearProduce(int yearProduce) {
		this.yearProduce = yearProduce;
	}

	/**
	 * 
	 * @return fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * 
	 * @param fuel bensin, gas..
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * 
	 * @return farg
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 
	 * @param color vit, gron...
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 
	 * @return prise
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price Storsta pris som anvandare valjer
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return kilometer
	 */
	public int getKilometer() {
		return kilometer;
	}

	/**
	 * 
	 * @param kilometer Storsta kilometer som anvandare valjer
	 */
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	/**
	 * 
	 * @return true/ false
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * 
	 * @param isNew ar bilen ny eller ej
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * 
	 * @return true/ false
	 */
	public boolean isNavigation() {
		return navigation;
	}

	/**
	 * 
	 * @param navigation Har eller ej navigation
	 */
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	/**
	 * 
	 * @return true/false
	 */
	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 * 
	 * @param automatic Har eller ej automatiskt vaxle
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	/**
	 * 
	 * @return true/false
	 */
	public boolean isRentable() {
		return isRentable;
	}
/**
 * 
 * @param isRentable Kan man eller ej hyra ut bilen
 */
	public void setRentable(boolean isRentable) {
		this.isRentable = isRentable;
	}

	/**
	 * 
	 * @return Date
	 */
	public Date getTimeStored() {
		return timeStored;
	}

	/**
	 * 
	 * @param timeStored Nar bilen ko till butik
	 */
	public void setTimeStored(Date timeStored) {
		this.timeStored = timeStored;
	}

}
