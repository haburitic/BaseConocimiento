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
@Table(name = "tb_prj_author")

/**
 * Class for create one object author
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class Author {
	static final Logger log = Logger.getLogger(Author.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idnauthor_seq")
	@SequenceGenerator(name = "idnauthor_seq", sequenceName = "idnauthor_sequence", allocationSize = 1)

	@Column(name = "idnauthor")
	private long idnauthor;

	@NotNull
	private String name;


	
	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public Author() {
		
	}

	/**
	 * This method get the parameters the front end in one object type Author
	 * @param idnauthor Id for author
	 * @param name Name the Author
	 */
	public Author(long idnauthor, String name) {
		super();
		this.idnauthor = idnauthor;
		this.name = name;
		
	}

	//Getters and Setters
	
	public long getIdnauthor() {
		return idnauthor;
	}

	public void setIdnauthor(long idnauthor) {
		this.idnauthor = idnauthor;
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
		return "Author[idnauthor=" + idnauthor + ", name=" + name +"]";
	}


}