package com.webbutik.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Car")
public class Car {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegNr() {
		return name;
	}
	public void setRegNr(String regNr) {
		this.name = regNr;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getYearProduce() {
		return yearProduce;
	}
	public void setYearProduce(int yearProduce) {
		this.yearProduce = yearProduce;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getKilometer() {
		return kilometer;
	}
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public boolean isNavigation() {
		return navigation;
	}
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}
	public boolean isAutomatic() {
		return automatic;
	}
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	public boolean isRentable() {
		return isRentable;
	}
	public void setRentable(boolean isRentable) {
		this.isRentable = isRentable;
	}
	public Date getTimeStored() {
		return timeStored;
	}
	public void setTimeStored(Date timeStored) {
		this.timeStored = timeStored;
	}
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
	
	public Car() {}
	

	public Car(int id, String regNr, String brandName, String modelName, int yearProduce, String fuel, String color,
			int price, int kilometer, boolean isNew, boolean navigation, boolean automatic, boolean isRentable,
			Date timeStored) {
		super();
		this.id = id;
		this.name = regNr;
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


//	/**
//	 * koppling med table modelofcar med hjalp av variable modelOfCar som ar en
//	 * instance variable av klass ModelOfCar
//	 */
//	@ManyToOne
//	@JoinColumn(name = "MODELOFCAR_FK")
//	private ModelOfCar modelOfCar;
}
