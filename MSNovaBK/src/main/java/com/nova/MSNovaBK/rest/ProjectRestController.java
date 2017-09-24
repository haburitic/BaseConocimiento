package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.ProjectDAO;
import com.nova.MSNovaBK.dto.Project;
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
public class ProjectRestController {
	static final Logger log = Logger.getLogger(ProjectRestController.class);
	@Autowired
	ProjectDAO projectDAO;

	/**
	 * Method for get one project with your ID
	 * 
	 * @param idnprj
	 *            Id the project
	 * @return Object the type project wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("project/find/{id}")
	@ResponseBody

	public Project getProject(@PathVariable("id") long idnprj) throws NovaBKDaoException {
		Project project = new Project();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in Project");
		try {

			project = projectDAO.findByIdnprj(idnprj);
			if (!project.equals(null)) {

				log.info("Log4j get the project with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for project " + e);
			throw new NovaBKDaoException(e);

		}

		return project;
	}

	/**
	 * Method for get all projects in the BD
	 * 
	 * @return arrayList whit all projects
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("project/findall")
	@ResponseBody
	public List<Project> getProjectAll() throws NovaBKDaoException {
		List<Project> project = new ArrayList<Project>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for Project");
		try {

			project = projectDAO.findAll();
			if (project.equals(null)) {

				log.info("Log4j get the list projects ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for project " + e);
			throw new NovaBKDaoException(e);

		}

		return project;
	}

	/**
	 * Method for Save one new project
	 * 
	 * @param data
	 *            for the new project
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "project/save", method = RequestMethod.POST)
	@ResponseBody
	public void setProject(@RequestBody Project project) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for project");
		try {
			projectDAO.save(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for project " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one project
	 * 
	 * @param idnprj
	 *            Id for project
	 * @param project
	 *            Data for update the project
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "project/edit/{id}")
	@ResponseBody

	public void editProject(@PathVariable("id") long idnprj, @RequestBody Project project) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for project");
		try {
			projectDAO.save(project);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for project " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one project
	 * 
	 * @param idnprj
	 *            ID the project
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "project/delete/{id}")
	@ResponseBody
	public void getDeleteProject(@PathVariable("id") long idnprj) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for project");
		try {
			projectDAO.delete(idnprj);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for project " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
