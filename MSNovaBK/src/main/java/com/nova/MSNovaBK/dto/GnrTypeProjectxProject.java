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
@Table(name = "tb_gnr_projectxtypeproject")

/**
 * Class for create one object relation between project and type project
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class GnrTypeProjectxProject {
	static final Logger log = Logger.getLogger(GnrTypeProjectxProject.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnprjgnrxtp_seq")
	@SequenceGenerator(name = "idnprjgnrxtp_seq", sequenceName = "idnprjgnrxtp_sequence", allocationSize = 1)

	@Column(name = "idnprjgnrxtp")
	private long idnprjgnrxtp;

	@NotNull
	private long idgnrprj;

	@NotNull
	private long idnprjtype;
	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public GnrTypeProjectxProject() {
		
	}

	
	/**
	 * This method get the parameters the front end in one object relation between project and type project
	 * @param idnprjgnrxtp id the relation between type project and project
	 * @param idgnrprj id the project
	 * @param idnprjtype id the type project
	 */
	public GnrTypeProjectxProject(long idnprjgnrxtp, long idgnrprj, long idnprjtype) {
		super();
		this.idnprjgnrxtp = idnprjgnrxtp;
		this.idgnrprj = idgnrprj;
		this.idnprjtype = idnprjtype;
		
	}

	//Getters and Setters


	public long getIdnprjgnrxtp() {
		return idnprjgnrxtp;
	}


	public void setIdnprjgnrxtp(long idnprjgnrxtp) {
		this.idnprjgnrxtp = idnprjgnrxtp;
	}


	public long getIdgnrprj() {
		return idgnrprj;
	}


	public void setIdgnrprj(long idgnrprj) {
		this.idgnrprj = idgnrprj;
	}


	public long getIdnprjtype() {
		return idnprjtype;
	}


	public void setIdnprjtype(long idnprjtype) {
		this.idnprjtype = idnprjtype;
	}


	public static Logger getLog() {
		return log;
	}



	
	@Override
	public String toString() {
		return "TypeProjectxProject[idnprjgnrxtp=" + idnprjgnrxtp + ", idgnrprj=" + idgnrprj + ", idnprjtype=" + idnprjtype + "]";
	}

}