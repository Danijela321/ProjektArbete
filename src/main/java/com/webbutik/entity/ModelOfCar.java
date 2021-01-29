package com.webbutik.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ModelOfCar")
@Getter
@Setter
public class ModelOfCar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "modelName", unique = true, nullable = false)
	private String name;
	@Column(name = "power_Hp_per_l")
	private int power; // 100 Hp/l, titel av column Hp/l
	@Column(name = "length_i_mm")
	private int length; // 4050 titel mm
	@Column(name = "width_i_mm")
	private int width; // 1798 titel mm
	@Column(name = "height_i_mm")
	private int height; // 1440 mm
	
	@Column(name = "weelBase_i_mm")
	private int weelBase; // 2583 mm
	private int seat; // 5
	private int doors; // 5

	public ModelOfCar() {
	}

	public ModelOfCar(String name, int power, int length, int width, int height, int weelBase, int seat, int doors) {
		super();
		this.name = name;
		this.power = power;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weelBase = weelBase;
		this.seat = seat;
		this.doors = doors;
	}

	/**
	 * Skriva ut egenskaper
	 */
//@Override
//	public String toString() {
//		return "ModelOfCar [id=" + id + ", modelName=" + name + ", power=" + power + ", length=" + length
//				+ ", width=" + width + ", height=" + height + ", weelBase=" + weelBase + ", seat=" + seat + ", doors="
//				+ doors + "]";
//	}

	public ModelOfCar(String name) {
		this.name = name;
	}
}
