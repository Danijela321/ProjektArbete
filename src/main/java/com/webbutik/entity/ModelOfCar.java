package com.webbutik.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

=======
/**
 * Model of car entity
 * @author Danijela
 *
 */
>>>>>>> c1d145f2d9f2f695ec438400cff65eb6ff596461
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

	/**
	 * tom konstruktor
	 */
	public ModelOfCar() {
	}

	/**
	 * Konstruktor av model_of_car entity
	 * @param name typ av model av bil
	 * @param power Hur mycket kraft harbilen
	 * @param length Hur langd ar bilen
	 * @param width HUr bredd ar bilen
	 * @param height Hur hojd ar bilen
	 * @param weelBase Vilken hjulbas har bilen
	 * @param seat Hur manga sittplats har bilen
	 * @param doors Hur manga dorrar har bilen
	 * @author Danijela
	 */
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
<<<<<<< HEAD
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
=======
	 * Set unik id fan databas( gör databas automatisk)
	 * @param id Unik id fran databasen
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set namn av model
	 * @param name typ av model
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set mootor kraft av model
	 * @param power Kraft
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * Set langd
	 * @param length langd 
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Set bredd
	 * @param width bredd
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Set hojd
	 * @param height Hojd
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Set hjulbas
	 * @param weelBase Hjulbas
	 */
	public void setWeelBase(int weelBase) {
		this.weelBase = weelBase;
	}

	/**
	 * Set sittplats
	 * @param seat Sittplats
	 */
	public void setSeat(int seat) {
		this.seat = seat;
	}

	/**
	 * Set antal av dorrar
	 * @param doors Dorrar
	 */
	public void setDoors(int doors) {
		this.doors = doors;
	}

/**
 * Get namn av model av bil
 * @param name typ av model
 */
	public ModelOfCar(String name) {
		this.name = name;
	}

	/**
	 * Get name
	 * @return typ av model
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get antal av sittplatser
	 * @return antal av sittplatser
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * Get antal av dorrar
	 * @return antal av dorrar
	 */
	public int getDoors() {
		return doors;
	}

	/**
	 * Get unik id
	 * @return unik id fran databasen
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get motor kraft
	 * @return Kraft
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Get langd
	 * @return langd
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Get bredd
	 * @return bredd
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get hojd
	 * @return hojd
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get hjulbas
	 * @return hjulbas
	 */
	public int getWeelBase() {
		return weelBase;
	}

>>>>>>> c1d145f2d9f2f695ec438400cff65eb6ff596461
}
