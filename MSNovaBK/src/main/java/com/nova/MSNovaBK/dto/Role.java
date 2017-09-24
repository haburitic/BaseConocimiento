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
@Table(name = "tb_adm_roles")

/**
 * Class for create one object type Role
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class Role {
	static final Logger log = Logger.getLogger(Role.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnrole_seq")
	@SequenceGenerator(name = "idnrole_seq", sequenceName = "idnrole_sequence", allocationSize = 1)

	@Column(name = "idnrole")
		private long idnrole;

	@NotNull
	private String namerole;

	@NotNull
	private String description;

	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public Role() {
	
	}

	/**
	 * This method get the parameters the front end in one object type Role
	 * @param idnrole idn for role
	 * @param namerole name the role
	 * @param description description the role
	 */
	public Role(long idnrole, String namerole, String description) {
		super();
		this.idnrole = idnrole;
		this.namerole = namerole;
		this.description = description;
	}

//Getters and Setters
	
	
	public long getIdnrole() {
		return idnrole;
	}

	public void setIdnrole(long idnrole) {
		this.idnrole = idnrole;
	}

	public String getNamerole() {
		return namerole;
	}

	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Logger getLog() {
		return log;
	}

	
	@Override
	public String toString() {
		return "Role[idnrole=" + idnrole + ", namerole=" + namerole + ", " + "description=" + description + "]";
	}

}