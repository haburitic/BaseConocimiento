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
@Table(name = "tb_prj_projects_labels")

/**
 * Class for create one object label
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class Label {
	static final Logger log = Logger.getLogger(Label.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idprjlabel_seq")
	@SequenceGenerator(name = "idprjlabel_seq", sequenceName = "idprjlabel_sequence", allocationSize = 1)

	@Column(name = "idprjlabel")
	private long idprjlabel;

	@NotNull
	private String name;

	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public Label() {
		
	}

	
	/**
	 * This method get the parameters the front end in one object type Label
	 * @param idprjlabel Id for Label
	 * @param name Name for Label
	 */
	public Label(long idprjlabel, String name) {
		super();
		this.idprjlabel = idprjlabel;
		this.name = name;
		
	}

//Getters and Setters	
	public long getIdprjlabel() {
		return idprjlabel;
	}

	public void setIdprjlabel(long idprjlabel) {
		this.idprjlabel = idprjlabel;
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
		return "Label[idprjlabel=" + idprjlabel + ", name=" + name + "]";
	}

}