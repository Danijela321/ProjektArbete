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
	@OneToOne
	private ModelOfCar modelOfCarName;

	public ModelOfCar getModelOfCarName() {
		return modelOfCarName;
	}

	public void setModelOfCarName(ModelOfCar modelOfCarName) {
		this.modelOfCarName = modelOfCarName;
	}

	public Car() {
	}
	
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
			int price, int kilometer, boolean isNew, boolean navigation, boolean automatic, boolean isRentable,
			Date timeStored) {
		super();
		this.id = id;
		this.name = name;
		this.brandName = brandName;
		this.modelName = modelName;
		this.yearProduce = yearProduced;
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

}
