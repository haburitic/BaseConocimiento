package com.nova.MSNovaBK.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


import org.apache.log4j.Logger;

@Entity
@Table(name = "tb_adm_users")

/**
 * Class for create one object user
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class User {
	static final Logger log = Logger.getLogger(User.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnuser_seq")
	@SequenceGenerator(name = "idnuser_seq", sequenceName = "idnuser_sequence", allocationSize = 1)

	@Column(name = "idnuser")
	private long idnuser;

	@NotNull
	private String name;

	@NotNull
	private String lastname;

	@NotNull
	private String nameuser;

	
	@NotNull
	private long idnrole; 
	
	@NotNull
	private String email;

	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public User() {

	}

	/**
	 * This method get the parameters the front end in one object user
	 * @param idnuser id for new user
	 * @param name name the user
	 * @param lastname lastname the user
	 * @param nameuser this nameuser is email
	 * @param idnrol id the rol for this user
	 * @param email email the user
	 */
	
	public User(long idnuser, String name, String lastname, String nameuser, long idnrole, String email) {
		super();
		this.idnuser = idnuser;
		this.name = name;
		this.lastname = lastname;
		this.nameuser = nameuser;
		this.idnrole = idnrole;
		this.email = email;

	}

	//Getters and Setter
	
	
	public long getIdnuser() {
		return idnuser;
	}

	public void setIdnuser(long idnuser) {
		this.idnuser = idnuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNameuser() {
		return nameuser;
	}

	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}

	public long getIdnrole() {
		return idnrole;
	}

	public void setIdnrole(long idnrole) {
		this.idnrole = idnrole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "User[idnuser=" + idnuser + ", name=" + name + ", " + "lastname=" + lastname + ", nameuser="
				+ nameuser + ", idnrole=" + idnrole + ", email=" + email + "]";
	}

}