package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.ProjectxLabelDAO;
import com.nova.MSNovaBK.dto.ProjectxLabel;
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
public class ProjectxLabelRestController {
	static final Logger log = Logger.getLogger(ProjectxLabelRestController.class);
	@Autowired
	ProjectxLabelDAO projectxLabelDAO;

	
/**
 * Method for get one relation between project and label with your ID
 * @param idprjlabel Id the relation between project and label
 * @return Object the relation between project and label
 * @throws NovaBKDaoException
 */
	@RequestMapping("Projectxlabel/find/{id}")
	@ResponseBody

	public ProjectxLabel getProjectxLabel(@PathVariable("id") long idnprjxlabel) throws NovaBKDaoException {
		ProjectxLabel projectxLabel = new ProjectxLabel();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in relation between project and label");
		try {

			projectxLabel = projectxLabelDAO.findByIdnprjxlabel(idnprjxlabel);
			if (!projectxLabel.equals(null)) {

				log.info("Log4j get the relation between project and label with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for relation between project and label " + e);
			throw new NovaBKDaoException(e);

		}

		return projectxLabel;
	}

	/**
	 * Method for get all labels in the BD
	 * 
	 * @return arrayList whit all labels
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("projectxlabel/findall")
	@ResponseBody
	public List<ProjectxLabel> getProjectxLabelAll() throws NovaBKDaoException {
		List<ProjectxLabel> projectxLabel = new ArrayList<ProjectxLabel>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All relation between project and label");
		try {

			projectxLabel = projectxLabelDAO.findAll();
			if (projectxLabel.equals(null)) {

				log.info("Log4j get the list relation between project and labels ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for relation between project and label " + e);
			throw new NovaBKDaoException(e);

		}

		return projectxLabel;
	}

	/**
	 * Method for Save one new label
	 * 
	 * @param data
	 *            for the new label
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "projectxlabel/save", method = RequestMethod.POST)
	@ResponseBody
	public void setProjectxLabel(@RequestBody ProjectxLabel projectxLabel) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for relation between project and label");
		try {
			projectxLabelDAO.save(projectxLabel);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for relation between project and label " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one label
	 * 
	 * @param idprjlabel
	 *            Id for label
	 * @param label
	 *            Data for update the label
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "projectxlabel/edit/{id}")
	@ResponseBody

	public void editProjectxLabel(@PathVariable("id") long idnprjxlabel, @RequestBody ProjectxLabel projectxLabel) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for relation between project and label");
		try {
			projectxLabelDAO.save(projectxLabel);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for relation between project and label " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one label
	 * 
	 * @param idprjlabel
	 *            ID the label
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "projectxlabel/delete/{id}")
	@ResponseBody
	public void getDeleteProjectxLabel(@PathVariable("id") long idnprjxlabel) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for relation between project and label");
		try {
			projectxLabelDAO.delete(idnprjxlabel);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for relation between project and label " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
