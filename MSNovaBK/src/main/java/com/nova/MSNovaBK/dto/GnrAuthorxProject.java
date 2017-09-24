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
@Table(name = "tb_gnr_projectxauthor")

/**
 * Class for create one object relation between project and author
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class GnrAuthorxProject {
	static final Logger log = Logger.getLogger(GnrAuthorxProject.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idprjgnrxprj_seq")
	@SequenceGenerator(name = "idprjgnrxprj_seq", sequenceName = "idprjgnrxprj_sequence", allocationSize = 1)

	@Column(name = "idprjgnrxprj")
	private long idprjgnrxprj;

	@NotNull
	private long idgnrprj;

	@NotNull
	private long idnauthor;
	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public GnrAuthorxProject() {
		
	}

	/**
	 * This method get the parameters the front end in one object relation between project and author
	 * @param idprjgnrxprj id the relation between author and project
	 * @param idgnrprj id the project
	 * @param idnauthor id the author
	 */
	public GnrAuthorxProject(long idprjgnrxprj, long idgnrprj, long idnauthor) {
		super();
		this.idprjgnrxprj = idprjgnrxprj;
		this.idgnrprj = idgnrprj;
		this.idnauthor = idnauthor;
		
	}

//Getters and setters	
	
	public long getIdprjgnrxprj() {
		return idprjgnrxprj;
	}

	public void setIdprjgnrxprj(long idprjgnrxprj) {
		this.idprjgnrxprj = idprjgnrxprj;
	}

	public long getIdgnrprj() {
		return idgnrprj;
	}

	public void setIdgnrprj(long idgnrprj) {
		this.idgnrprj = idgnrprj;
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
		return "AuthorxProject[idprjgnrxprj=" + idprjgnrxprj + ", idgnrprj=" + idgnrprj + ", idnauthor=" + idnauthor + "]";
	}


}