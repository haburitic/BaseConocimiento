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
@Table(name = "tb_prj_authorxproject")

/**
 * Class for create one object relation between project and author
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class AuthorxProject {
	static final Logger log = Logger.getLogger(AuthorxProject.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnauthorxprj_seq")
	@SequenceGenerator(name = "idnauthorxprj_seq", sequenceName = "idnauthorxprj_sequence", allocationSize = 1)

	@Column(name = "idnauthorxprj")
	private long idnauthorxprj;

	@NotNull
	private long idnprj;

	@NotNull
	private long idnauthor;
	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public AuthorxProject() {
		
	}

	/**
	 * This method get the parameters the front end in one object relation between project and author
	 * @param idnauthorxprj id the relation between author and project
	 * @param idnprj id the project
	 * @param idnauthor id the author
	 */
	public AuthorxProject(long idnauthorxprj, long idnprj, long idnauthor) {
		super();
		this.idnauthorxprj = idnauthorxprj;
		this.idnprj = idnprj;
		this.idnauthor = idnauthor;
		
	}

	//Getters and Setters
	
		public long getIdnauthorxprj() {
		return idnauthorxprj;
	}

	public void setIdnauthorxprj(long idnauthorxprj) {
		this.idnauthorxprj = idnauthorxprj;
	}

	public long getIdnprj() {
		return idnprj;
	}

	public void setIdnprj(long idnprj) {
		this.idnprj = idnprj;
	}

	public long getIdnauthor() {
		return idnauthor;
	}

	public void setIdnauthor(long idnauthor) {
		this.idnauthor = idnauthor;
	}

	public static Logger getLog() {
		return log;
	}

	
	@Override
	public String toString() {
		return "AuthorxProject[idnauthorxprj=" + idnauthorxprj + ", idnprj=" + idnprj + ", idnauthor=" + idnauthor + "]";
	}


}