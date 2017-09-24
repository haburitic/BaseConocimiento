package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.AuthorxProjectDAO;
import com.nova.MSNovaBK.dto.AuthorxProject;
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
public class AuthorxProjectRestController {
	static final Logger log = Logger.getLogger(AuthorxProjectRestController.class);
	@Autowired
	AuthorxProjectDAO authorxProjectDAO;

/**
 * Method for get one relation between the author table and the project table
 * @param idnauthorxprj  Id for relation author and Project 
 * @return Object 
 * @throws NovaBKDaoException
 */
	@RequestMapping("authorxproject/find/{id}")
	@ResponseBody

	public AuthorxProject getAuthorxProject(@PathVariable("id") long idnauthorxprj) throws NovaBKDaoException {
		AuthorxProject authorxProject = new AuthorxProject();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in relation between author and project");
		try {

			authorxProject = authorxProjectDAO.findByIdnauthorxprj(idnauthorxprj);
			if (!authorxProject.equals(null)) {

				log.info("Log4j get the relation between author and project with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for relation between author and project" + e);
			throw new NovaBKDaoException(e);

		}

		return authorxProject;
	}

	
/**
 * Method for get all relation between the author table and the project table
 * @return ArrayLst with all relation between author and project
 * @throws NovaBKDaoException
 */
	@RequestMapping("authorxproject/findall")
	@ResponseBody
	public List<AuthorxProject> getAuthorxProjectAll() throws NovaBKDaoException {
		List<AuthorxProject> authorxProject = new ArrayList<AuthorxProject>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for relation between author and project");
		try {

			authorxProject = authorxProjectDAO.findAll();
			if (authorxProject.equals(null)) {

				log.info("Log4j get the list the relation between author and project ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for relation between author and project " + e);
			throw new NovaBKDaoException(e);

		}

		return authorxProject;
	}


/**
 * Method for Save one relation between the author table and the project table
 * @param authorxProject Object
 * @throws NovaBKRestException
 */
	
	@RequestMapping(value = "authorxproject/save", method = RequestMethod.POST)
	@ResponseBody
	public void setAuthorxProject(@RequestBody AuthorxProject authorxProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for relation between author and project");
		try {
			authorxProjectDAO.save(authorxProject);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for relation between author and project" + e);
			throw new NovaBKRestException(e);

		}

	}


	/**
	 * Method for edit one relation between the author table and the project table
	 * @param idnauthorxprj Id the  relation between the author and Project
	 * @param authorxProject Object
	 * @throws NovaBKRestException
	 */
	
	@RequestMapping(method = RequestMethod.PUT, path = "authorxproject/edit/{id}")
	@ResponseBody

	public void editAuthorxProject(@PathVariable("id") long idnauthorxprj, @RequestBody AuthorxProject authorxProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for relation between author and project");
		try {
			authorxProjectDAO.save(authorxProject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method update for relation between  author and project " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one relation between the author table and the project table
	 * @param idnauthorxprj Id the relation between author anda project
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "authorxproject/delete/{id}")
	@ResponseBody
	public void getDeleteAuthorxProject(@PathVariable("id") long idnauthorxprj) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for relation between author and project");
		try {
			authorxProjectDAO.delete(idnauthorxprj);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in Method Delete for relation between author and project " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
