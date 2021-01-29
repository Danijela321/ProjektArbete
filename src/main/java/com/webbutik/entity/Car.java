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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity for tabell CAr
 * @author Danijela
 *
 */
@Entity
@Table(name = "Car")
@Getter
@Setter
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
<<<<<<< HEAD

	public static class Builder {
		//Mandatory
		private String name; 
		private String brandName; 
		private String modelName; 
		private int yearProduce;
		private int price;
		//Optional
		private String fuel; 
		private String color;
		private int kilometer;
		private boolean isNew;
		private boolean navigation;
		private boolean automatic;
		private boolean isRentable;
		private Date timeStored;
		
		public Builder(String name, String brandName, String modelName, int yearProduced, int price) {
			this.name = name;
			this.brandName = brandName;
			this.modelName = modelName;
			this.yearProduce = yearProduced;
			this.price = price;
		}
		
		public Builder fuel(String fuel) {
			this.fuel = fuel;
			return this;
		}
		
		public Builder color(String color) {
			this.color = color;
			return this;
		}
		
		public Builder kilometer(int kilometer) {
			this.kilometer = kilometer;
			return this;
		}
		
		public Builder isNew(boolean isNew) {
			this.isNew = isNew;
			return this;
		}
		
		public Builder navigation(boolean navigation) {
			this.navigation = navigation;
			return this;
		}
		
		public Builder automatic(boolean automatic) {
			this.automatic = automatic;
			return this;
		}
		
		public Builder isRentable(boolean isRentable) {
			this.isRentable = isRentable;
			return this;
		}
		
		public Builder timeStored(Date timeStored) {
			this.timeStored = timeStored;
			return this;
		}
		
		public Car build() {
			return new Car(this);
		}
		
	}
=======
	
	/**
	 * Relation OneToOne mellan tabeller CAr och modelOfCar
	 *  @author Danijela
	 */
>>>>>>> c1d145f2d9f2f695ec438400cff65eb6ff596461
	@OneToOne
	private ModelOfCar modelOfCarName;

	/**
	 * Get model av bil
	 * @return model of car
	 *  @author Danijela
	 */
	public ModelOfCar getModelOfCarName() {
		return modelOfCarName;
	}

	/**
	 * Satter en model of car
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
<<<<<<< HEAD
	
	private Car(Builder b) {
		this.name = b.name;
		this.brandName = b.brandName;
		this.modelName = b.modelName;
		this.yearProduce = b.yearProduce;
		this.fuel = b.fuel;
		this.color = b.color;
		this.price = b.price;
		this.kilometer = b.kilometer;
		this.isNew = b.isNew;
		this.navigation = b.navigation;
		this.automatic = b.automatic;
		this.isRentable = b.isRentable;
		this.timeStored = b.timeStored;
	}

	public Car(int id, String name, String brandName, String modelName, int yearProduced, String fuel, String color,
=======

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
>>>>>>> c1d145f2d9f2f695ec438400cff65eb6ff596461
			int price, int kilometer, boolean isNew, boolean navigation, boolean automatic, boolean isRentable,
			Date timeStored) {
		super();
		this.id = id;
		this.name = name;
		this.brandName = brandName;
		this.modelName = modelName;
<<<<<<< HEAD
		this.yearProduce = yearProduced;
		this.fuel = fuel;
		this.color = color;
		this.price = price;
		this.kilometer = kilometer;
		this.isNew = isNew;
		this.navigation = navigation;
		this.automatic = automatic;
		this.isRentable = isRentable;
=======
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
	 * Get name
	 * @return namn av bilen, dvs.reg.nr
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param name namn av bilen
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get id
	 * @return unik id fran databasen
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id
	 * @param id unik id i databasen
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get registration nummer
	 * @return namn av bilen
	 */
	public String getRegNr() {
		return name;
	}

	/**
	 * Set registration nummer
	 * @param regNr namn av bilen
	 */
	public void setRegNr(String regNr) {
		this.name = regNr;
	}

	/**
	 * Get brand av bil
	 * @return brand av bilen
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Set brand av bil
	 * @param brandName Volvo, Renault..
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Get namn av model av bil
	 * @return typ av bil model
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Set namn av model av bil
	 * @param modelName Clio, m3, Focus...
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * Get tillverkade ar
	 * @return year
	 */
	public int getYearProduce() {
		return yearProduce;
	}

	/**
	 * Set tillverkade ar
	 * @param yearProduce Ar när bilen ar tillverkad
	 */
	public void setYearProduce(int yearProduce) {
		this.yearProduce = yearProduce;
	}

	/**
	 * Get fuel
	 * @return fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * Set fuel
	 * @param fuel bensin, gas..
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * Get farg
	 * @return farg
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set farg
	 * @param color vit, gron...
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Get prise
	 * @return prise
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Set prise
	 * @param price Storsta pris som anvandare valjer
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Get kilometer
	 * @return kilometer
	 */
	public int getKilometer() {
		return kilometer;
	}

	/**
	 * Set kilometer
	 * @param kilometer Storsta kilometer som anvandare valjer
	 */
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	/**
	 * Get ar/ej ny
	 * @return true/ false
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * Set ar/ej ny
	 * @param isNew ar bilen ny eller ej
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * Get har/ej har navigation
	 * @return true/ false
	 */
	public boolean isNavigation() {
		return navigation;
	}

	/**
	 * Set har/ej har navigation
	 * @param navigation Har eller ej navigation
	 */
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	/**
	 * Get ar/ej automatisk vaxel
	 * @return true/false
	 */
	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 * Set ar/ej automatisk vaxel
	 * @param automatic Har eller ej automatiskt vaxle
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	/**
	 * Get Kan man eller ej hyra ut bilen
	 * @return true/false
	 */
	public boolean isRentable() {
		return isRentable;
	}
/**
 * Set Kan man eller ej hyra ut bilen
 * @param isRentable Kan man eller ej hyra ut bilen
 */
	public void setRentable(boolean isRentable) {
		this.isRentable = isRentable;
	}

	/**
	 * Get nar bilen ko till butik
	 * @return Date
	 */
	public Date getTimeStored() {
		return timeStored;
	}

	/**
	 * Set nar bilen ko till butik
	 * @param timeStored Nar bilen ko till butik
	 */
	public void setTimeStored(Date timeStored) {
>>>>>>> c1d145f2d9f2f695ec438400cff65eb6ff596461
		this.timeStored = timeStored;
	}

}
