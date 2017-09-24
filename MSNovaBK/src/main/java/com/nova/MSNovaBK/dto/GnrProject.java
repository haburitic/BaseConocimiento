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
@Table(name = "tb_gnr_project")

/**
 * Class for create one object general project
 * 
 * @author enlaRed.co
 * @version 1.0
 */

public class GnrProject {
	static final Logger log = Logger.getLogger(GnrProject.class);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgnrprj_seq")
	@SequenceGenerator(name = "idgnrprj_seq", sequenceName = "idgnrprj_sequence", allocationSize = 1)

	@Column(name = "idgnrprj")
	private long idgnrprj;

	@NotNull
	private String shortname;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private Date creationdate;

	/**
	 * Builder for the class without parameter
	 * 
	 * @param None
	 */

	public GnrProject() {

	}

	/**
	 * This method get the parameters the front end in one object project
	 * 
	 * @param idgnrprj
	 *            id for new projects
	 * @param shortname
	 *            short name for identification the projects
	 * @param name
	 *            general name for the project
	 * @param description
	 *            reference words for explain the project
	 * @param creationdate
	 *            creation date the project in system
	 */

	public GnrProject(long idgnrprj, String shortname, String name, String description, Date creationdate) {
		super();
		this.idgnrprj = idgnrprj;
		this.shortname = shortname;
		this.name = name;
		this.description = description;
		this.creationdate = creationdate;

	}

	// Getters and Setters


	public long getIdgnrprj() {
		return idgnrprj;
	}

	public void setIdgnrprj(long idgnrprj) {
		this.idgnrprj = idgnrprj;
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

	public static Logger getLog() {
		return log;
	}


	@Override
	public String toString() {
		return "Project[idgnrprj=" + idgnrprj + ", shortname=" + shortname + ", " + "name=" + name + ", description="
				+ description + ", creationdate=" + creationdate + "]";
	}	

}
