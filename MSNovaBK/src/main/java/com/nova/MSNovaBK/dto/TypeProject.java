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
@Table(name = "tb_prj_projects_types")

/**
 * Class for create one object type project
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class TypeProject {
	static final Logger log = Logger.getLogger(TypeProject.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnprjtype_seq")
	@SequenceGenerator(name = "idnprjtype_seq", sequenceName = "idnprjtype_sequence", allocationSize = 1)

	@Column(name = "idnprjtype")
	private long idnprjtype;

	@NotNull
	private String name;



	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public TypeProject() {
		
	}

	/**
	 * This method get the parameters the front end in one object type project
	 * @param idnprjtype idn for new type project
	 * @param name name for type project
	 * 
	 */
	
	public TypeProject(long idnprjtype, String name) {
		super();
		this.idnprjtype = idnprjtype;
		this.name = name;
		
	}

//Getters and Setters	

	public long getIdnprjtype() {
		return idnprjtype;
	}

	public void setIdnprjtype(long idnprjtype) {
		this.idnprjtype = idnprjtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "TypeProject[idnprjtype=" + idnprjtype + ", name=" + name + ", "  + "]";
	}

}