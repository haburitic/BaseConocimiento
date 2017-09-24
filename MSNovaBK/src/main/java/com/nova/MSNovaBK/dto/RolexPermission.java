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
@Table(name = "tb_adm_rolesxpermissions")

/**
 * Class for create one object relation between Role and Permission
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class RolexPermission {
	static final Logger log = Logger.getLogger(RolexPermission.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnrolexperm_seq")
	@SequenceGenerator(name = "idnrolexperm_seq", sequenceName = "idnrolexperm_sequence", allocationSize = 1)

	@Column(name = "idnrolexperm")
	private long idnrolexperm;

	@NotNull
	private long idnpermission;

	@NotNull
	private long idnrole;
	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public RolexPermission() {
		
	}

	
	/**
	 * This Method get the parameters the front end in one object relation between role and permission
	 * @param idnrolexperm Id the relation between role and permission
	 * @param idnpermission id the permission
	 * @param idnrole id the role
	 */
	public RolexPermission(long idnrolexperm, long idnpermission, long idnrole) {
		super();
		this.idnrolexperm = idnrolexperm;
		this.idnpermission = idnpermission;
		this.idnrole = idnrole;
		
	}

	//Getters and Setters


	public long getIdnrolexperm() {
		return idnrolexperm;
	}


	public void setIdnrolexperm(long idnrolexperm) {
		this.idnrolexperm = idnrolexperm;
	}


	public long getIdnpermission() {
		return idnpermission;
	}


	public void setIdnpermission(long idnpermission) {
		this.idnpermission = idnpermission;
	}


	public long getIdnrole() {
		return idnrole;
	}


	public void setIdnrole(long idnrole) {
		this.idnrole = idnrole;
	}


	public static Logger getLog() {
		return log;
	}
	
	@Override
	public String toString() {
		return "RolexPermissions[idnrolexperm=" + idnrolexperm + ", idnpermission=" + idnpermission + ", idnrole=" + idnrole + "]";
	}

}