package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.TypeProjectDAO;
import com.nova.MSNovaBK.dto.TypeProject;
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
public class TypeProjectRestController {
	static final Logger log = Logger.getLogger(TypeProjectRestController.class);
	@Autowired
	TypeProjectDAO typeProjectDAO;

	/**
	 * Method for get one type Project with your ID
	 * 
	 * @param idnprjtype
	 *            Id the type project
	 * @return Object the type project wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("typeproject/find/{id}")
	@ResponseBody

	public TypeProject getTypeProject(@PathVariable("id") long idnprjtype) throws NovaBKDaoException {
		TypeProject typeProject = new TypeProject();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in type Project");
		try {

			typeProject = typeProjectDAO.findByIdnprjtype(idnprjtype);
			if (!typeProject.equals(null)) {

				log.info("Log4j get the type project with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for type project " + e);
			throw new NovaBKDaoException(e);

		}

		return typeProject;
	}

	/**
	 * Method for get all types projects in the BD
	 * 
	 * @return arrayList whit all types projects
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("typeproject/findall")
	@ResponseBody
	public List<TypeProject> getTypeProjectAll() throws NovaBKDaoException {
		List<TypeProject> typeProject = new ArrayList<TypeProject>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All in type project");
		try {

			typeProject = typeProjectDAO.findAll();
			if (typeProject.equals(null)) {

				log.info("Log4j get the list types projects ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for type project " + e);
			throw new NovaBKDaoException(e);

		}

		return typeProject;
	}

	/**
	 * Method for Save one new type project
	 * 
	 * @param data
	 *            for the new type project
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "typeproject/save", method = RequestMethod.POST)
	@ResponseBody
	public void setTypeProject(@RequestBody TypeProject typeProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method save for type project");
		try {
			typeProjectDAO.save(typeProject);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for type project " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one type project
	 * 
	 * @param idnprjtype
	 *            Id for type project
	 * @param typeProject
	 *            Data for update the type project
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "typeproject/edit/{id}")
	@ResponseBody

	public void editTypeProject(@PathVariable("id") long idnprjtype, @RequestBody TypeProject typeProject) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for type project");
		try {
			typeProjectDAO.save(typeProject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for type project " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one type project
	 * 
	 * @param idnprjtype
	 *            ID the type project
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "typeproject/delete/{id}")
	@ResponseBody
	public void getDeleteTypeProject(@PathVariable("id") long idnprjtype) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method Delete for type project");
		try {
			typeProjectDAO.delete(idnprjtype);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for type project " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
