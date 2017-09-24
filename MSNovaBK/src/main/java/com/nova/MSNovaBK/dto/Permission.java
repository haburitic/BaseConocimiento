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
@Table(name = "tb_adm_permissions")

/**
 * Class for create one object type permission
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class Permission {
	static final Logger log = Logger.getLogger(Permission.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnpermissions_seq")
	@SequenceGenerator(name = "idnpermissions_seq", sequenceName = "idnpermissions_sequence", allocationSize = 1)

	@Column(name = "idnpermissions")
	private long idnpermissions;

	@NotNull
	private String name;

	@NotNull
	private String description;

	
	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public Permission() {
		
	}

	/**
	 * This method get the parameters the front end in one object type Permission
	 * @param idnpermissions id for new permission
	 * @param name name for permission
	 * @param description description for permission
	 
	 */
	public Permission(long idnpermissions, String name, String description) {
		super();
		this.idnpermissions = idnpermissions;
		this.name = name;
		this.description = description;
		
	}

	//Getters and Setters
	
	public long getIdnpermissions() {
		return idnpermissions;
	}

	public void setIdnpermissions(long idnpermissions) {
		this.idnpermissions = idnpermissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Permission[idnpermissions=" + idnpermissions + ", name=" + name + ", " + "description=" + description  +  "]";
	}

}