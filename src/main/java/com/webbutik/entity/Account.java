package com.webbutik.entity;

import java.io.Serializable;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
* 
* Represents a user's account. 
* <p>
* @author Erik Sandström
* </p>
*/
@Entity
@Table(name = "Account")
@Getter
@Setter
@AllArgsConstructor
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public static final int CUSTOMER = 0;
	public static final int ADMIN = 1;
	
	private String firstName;
	private String surname;
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	private int accessLevel;
	private boolean premiumMember = false;
	
	public Account(String firstName, String surname, String email, String password) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.accessLevel = CUSTOMER;
		this.premiumMember = false;
	}
	
	public Account() {
		
	}
	
	public String getFullName() {
		return this.firstName + " " + this.surname;
	}
	
	public String toString() {
		return "Name: " + firstName + " " + surname + "   Email:" + email;
	}

}
