package com.nova.MSNovaBK.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;


import org.apache.log4j.Logger;



@Entity
@Table(name = "tb_prj_documents")

/**
 * Class for create one object document
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class Document {
	static final Logger log = Logger.getLogger(Document.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idndocument_seq")
	@SequenceGenerator(name = "idndocument_seq", sequenceName = "idndocument_sequence", allocationSize = 1)

	@Column(name = "idndocument")
	private long idndocument;

	@NotNull
	private String shortname;

	@NotNull
	private String name;

	@NotNull
	private String description;
	
	@NotNull
	private Date creationdate;
	
	@NotNull
	private long idnprj;
	
	@NotNull
	private byte[] file;

	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public Document() {
		
	}

	/**
	 * This method get the parameters the front end in one object project
	 * @param idndocument id for new document
	 * @param shortname shortname for document
	 * @param name name for document
	 * @param description description for document
	 * @param creationdate creation date the document
	 * @param idnprj idn the project associate
	 * @param file is the file document
	 */
	
	public Document(long idndocument, String shortname, String name, String description, Date creationdate, long idnprj, byte[] file) {
		super();
		this.idndocument = idndocument;
		this.shortname = shortname;
		this.name = name;
		this.description = description;
		this.creationdate = creationdate;
		this.idnprj = idnprj;
		this.file = file;

	}

	// Getters and Setters

	public long getIdndocument() {
		return idndocument;
	}

	public void setIdndocument(long idndocument) {
		this.idndocument = idndocument;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
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

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public long getIdnprj() {
		return idnprj;
	}

	public void setIdnprj(long idnprj) {
		this.idnprj = idnprj;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public static Logger getLog() {
		return log;
	}

	
	@Override
	public String toString() {
		return "Document[idndocument=" + idndocument + ", shortname=" + shortname + ", " + "name=" + name + ", description="
				+ description + ", creationdate=" + creationdate + ", idnprj=" + idnprj + ", file=" + file + "]";
	}
}
