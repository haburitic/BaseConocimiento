package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.GnrProjectDAO;
import com.nova.MSNovaBK.dto.GnrProject;
import com.nova.MSNovaBK.excepciones.NovaBKDaoException;
import com.nova.MSNovaBK.excepciones.NovaBKRestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@CrossOrigin
@Controller

/**
 * Class for rest service http for CRUD
 * 
 * @author enlaRed.co
 * @version 1.0
 */
public class GnrProjectRestController {
	static final Logger log = Logger.getLogger(GnrProjectRestController.class);
	@Autowired
	GnrProjectDAO gnrProjectDAO;

	/**
	 * Method for get one general project with your ID
	 * 
	 * @param idgnrprj
	 *            Id the general project
	 * @return Object the type general project wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("gnrproject/find/{id}")
	@ResponseBody

	public GnrProject getGnrProject(@PathVariable("id") long idgnrprj) throws NovaBKDaoException {
		GnrProject gnrProject = new GnrProject();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in general Project");
		try {

			gnrProject = gnrProjectDAO.findByIdgnrprj(idgnrprj);
			if (!gnrProject.equals(null)) {

				log.info("Log4j get the general project with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for general  project " + e);
			throw new NovaBKDaoException(e);

		}

		return gnrProject;
	}

	/**
	 * Method for get all general projects in the BD
	 * 
	 * @return arrayList whit all projects
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("gnrproject/findall")
	@ResponseBody
	public List<GnrProject> getGnrProjectAll() throws NovaBKDaoException {
		List<GnrProject> gnrProject = new ArrayList<GnrProject>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for general Project");
		try {

			gnrProject = gnrProjectDAO.findAll();
			if (gnrProject.equals(null)) {

				log.info("Log4j get the list general projects ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for general project " + e);
			throw new NovaBKDaoException(e);

		}

		return gnrProject;
	}

	/**
	 * Method for Save one new general project
	 * 
	 * @param data
	 *            for the new project
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "gnrproject/save", method = RequestMethod.POST)
	@ResponseBody
	public void setGnrProject(@RequestBody GnrProject gnrProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for general project");
		try {
			gnrProjectDAO.save(gnrProject);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for general project " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one general project
	 * 
	 * @param idgnrprj
	 *            Id for general project
	 * @param gnrProject
	 *            Data for update the project
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "gnrproject/edit/{id}")
	@ResponseBody

	public void editGnrProject(@PathVariable("id") long idgnrprj, @RequestBody GnrProject gnrProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for general project");
		try {
			gnrProjectDAO.save(gnrProject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for general project " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one general project
	 * 
	 * @param idgnrprj
	 *            ID the general project
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "gnrproject/delete/{id}")
	@ResponseBody
	public void getDeleteGnrProject(@PathVariable("id") long idgnrprj) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for general project");
		try {
			gnrProjectDAO.delete(idgnrprj);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for general project " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
