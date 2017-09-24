package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.GnrAuthorxProjectDAO;
import com.nova.MSNovaBK.dto.GnrAuthorxProject;
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
public class GnrAuthorxProjectRestController {
	static final Logger log = Logger.getLogger(GnrAuthorxProjectRestController.class);
	@Autowired
	GnrAuthorxProjectDAO gnrAuthorxProjectDAO;

/**
 * Method for get one relation between the author table and the general project table
 * @param idprjgnrxprj  Id for relation author and general Project 
 * @return Object 
 * @throws NovaBKDaoException
 */
	@RequestMapping("gnrauthorxproject/find/{id}")
	@ResponseBody

	public GnrAuthorxProject getGnrAuthorxProject(@PathVariable("id") long idprjgnrxprj) throws NovaBKDaoException {
		GnrAuthorxProject gnrAuthorxProject = new GnrAuthorxProject();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in relation between author and General project");
		try {

			gnrAuthorxProject = gnrAuthorxProjectDAO.findByIdprjgnrxprj(idprjgnrxprj);
			if (!gnrAuthorxProject.equals(null)) {

				log.info("Log4j get the relation between author and general project with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for relation between author and general project" + e);
			throw new NovaBKDaoException(e);

		}

		return gnrAuthorxProject;
	}

	
/**
 * Method for get all relation between the author table and the general project table
 * @return ArrayLst with all relation between author and general project
 * @throws NovaBKDaoException
 */
	@RequestMapping("gnrauthorxproject/findall")
	@ResponseBody
	public List<GnrAuthorxProject> getGnrAuthorxProjectAll() throws NovaBKDaoException {
		List<GnrAuthorxProject> gnrAuthorxProject = new ArrayList<GnrAuthorxProject>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for relation between author and general project");
		try {

			gnrAuthorxProject = gnrAuthorxProjectDAO.findAll();
			if (gnrAuthorxProject.equals(null)) {

				log.info("Log4j get the list the relation between author and general project ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for relation between author and general project " + e);
			throw new NovaBKDaoException(e);

		}

		return gnrAuthorxProject;
	}


/**
 * Method for Save one relation between the author table and the general project table
 * @param gnrAuthorxProject Object
 * @throws NovaBKRestException
 */
	
	@RequestMapping(value = "gnrauthorxproject/save", method = RequestMethod.POST)
	@ResponseBody
	public void setGnrAuthorxProject(@RequestBody GnrAuthorxProject gnrAuthorxProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for relation between author and general project");
		try {
			gnrAuthorxProjectDAO.save(gnrAuthorxProject);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for relation between author and general project" + e);
			throw new NovaBKRestException(e);

		}

	}


	/**
	 * Method for edit one relation between the author table and the general project table
	 * @param idprjgnrxprj Id the  relation between the author and general Project
	 * @param gnrAuthorxProject Object
	 * @throws NovaBKRestException
	 */
	
	@RequestMapping(method = RequestMethod.PUT, path = "gnrauthorxproject/edit/{id}")
	@ResponseBody

	public void editGnrAuthorxProject(@PathVariable("id") long idprjgnrxprj, @RequestBody GnrAuthorxProject gnrAuthorxProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for relation between author and general project");
		try {
			gnrAuthorxProjectDAO.save(gnrAuthorxProject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method update for relation between  author and general project " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one relation between the author table and the general project table
	 * @param idprjgnrxprj Id the relation between author and general project
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "gnrauthorxproject/delete/{id}")
	@ResponseBody
	public void getDeleteGnrAuthorxProject(@PathVariable("id") long idprjgnrxprj) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for relation between author and general  project");
		try {
			gnrAuthorxProjectDAO.delete(idprjgnrxprj);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in Method Delete for relation between author and general project " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
