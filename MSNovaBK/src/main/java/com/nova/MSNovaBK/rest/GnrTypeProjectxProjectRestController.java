package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.GnrTypeProjectxProjectDAO;
import com.nova.MSNovaBK.dto.GnrTypeProjectxProject;
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
public class GnrTypeProjectxProjectRestController {
	static final Logger log = Logger.getLogger(GnrTypeProjectxProjectRestController.class);
	@Autowired
	GnrTypeProjectxProjectDAO gnrTypeProjectxProjectDAO;


	/**
	 * Method for get one relation between type general project and project with your ID
	 * @param idnprjgnrxtp Id the relation between type general project and project
	 * @return Object wanted
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("gnrtypeprojectxpoject/find/{id}")
	@ResponseBody

	public GnrTypeProjectxProject getGnrTypeProject(@PathVariable("id") long idnprjgnrxtp) throws NovaBKDaoException {
		GnrTypeProjectxProject gnrTypeProjectxProject = new GnrTypeProjectxProject();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in the relation between type general Project and project");
		try {

			gnrTypeProjectxProject = gnrTypeProjectxProjectDAO.findByIdnprjgnrxtp(idnprjgnrxtp);
			if (!gnrTypeProjectxProject.equals(null)) {

				log.info("Log4j get the relation between type project and general project with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for relation between type general project and project " + e);
			throw new NovaBKDaoException(e);

		}

		return gnrTypeProjectxProject;
	}


/**
 * Method for get all relation between type project and general project
 * @return Arraylist
 * @throws NovaBKDaoException
 */
	@RequestMapping("gnrtypeprojectxproject/findall")
	@ResponseBody
	public List<GnrTypeProjectxProject> getGnrTypeProjectxProjectAll() throws NovaBKDaoException {
		List<GnrTypeProjectxProject> gnrTypeProjectxProject = new ArrayList<GnrTypeProjectxProject>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All in relation between type project and general project");
		try {

			gnrTypeProjectxProject = gnrTypeProjectxProjectDAO.findAll();
			if (gnrTypeProjectxProject.equals(null)) {

				log.info("Log4j get the list the relation between types projects and general project");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for relation between type project and general project " + e);
			throw new NovaBKDaoException(e);

		}

		return gnrTypeProjectxProject;
	}

	
/**
 * Method for save one relation between type project and project
 * @param gnrtypeProjectxProject Data for the new relation between type project and project
 * @throws NovaBKRestException
 */
	@RequestMapping(value = "gnrtypeprojectxproject/save", method = RequestMethod.POST)
	@ResponseBody
	public void setGnrTypeProjectxProject(@RequestBody GnrTypeProjectxProject gnrTypeProjectxProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method save for relation between type project and general project");
		try {
			gnrTypeProjectxProjectDAO.save(gnrTypeProjectxProject);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for relation between type project and project " + e);
			throw new NovaBKRestException(e);

		}

	}

/**
 * Method for edit one relation between type project and project
 * @param idnprjgnrxtp id the relation between type project and project
 * @param gnrtypeProjectxProject Object
 * @throws NovaBKRestException
 */
	@RequestMapping(method = RequestMethod.PUT, path = "gnrtypeprojectxproject/edit/{id}")
	@ResponseBody

	public void editGnrTypeProjectxProject(@PathVariable("id") long idnprjgnrxtp, @RequestBody GnrTypeProjectxProject gnrTypeProjectxProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for relation between type project and general project");
		try {
			gnrTypeProjectxProjectDAO.save(gnrTypeProjectxProject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for relation between type project and project " + e);
			throw new NovaBKRestException(e);
		}

	}

	
/**
 * Method for delete one relation between type project and general project with your ID
 * @param idnprjgnrxtp Id the relation between type project and general project
 * @throws NovaBKDaoException
 */
	@RequestMapping(method = RequestMethod.DELETE, path = "gnrtypeprojectxproject/delete/{id}")
	@ResponseBody
	public void getDeleteGnrTypeProjectxProject(@PathVariable("id") long idnprjgnrxtp) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method Delete for relation between type project and general project");
		try {
			gnrTypeProjectxProjectDAO.delete(idnprjgnrxtp);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for relation between type project and general project " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
