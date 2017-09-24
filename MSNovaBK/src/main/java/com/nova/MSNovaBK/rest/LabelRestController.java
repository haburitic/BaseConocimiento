package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.LabelDAO;
import com.nova.MSNovaBK.dto.Label;
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
public class LabelRestController {
	static final Logger log = Logger.getLogger(LabelRestController.class);
	@Autowired
	LabelDAO labelDAO;

	/**
	 * Method for get one Label with your ID
	 * 
	 * @param idprjlabel
	 *            Id the label
	 * @return Object the type label wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("label/find/{id}")
	@ResponseBody

	public Label getLabel(@PathVariable("id") long idprjlabel) throws NovaBKDaoException {
		Label label = new Label();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in label");
		try {

			label = labelDAO.findByIdprjlabel(idprjlabel);
			if (!label.equals(null)) {

				log.info("Log4j get the label with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for label " + e);
			throw new NovaBKDaoException(e);

		}

		return label;
	}

	/**
	 * Method for get all labels in the BD
	 * 
	 * @return arrayList whit all labels
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("label/findall")
	@ResponseBody
	public List<Label> getLabelAll() throws NovaBKDaoException {
		List<Label> label = new ArrayList<Label>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for label");
		try {

			label = labelDAO.findAll();
			if (label.equals(null)) {

				log.info("Log4j get the list labels ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for label " + e);
			throw new NovaBKDaoException(e);

		}

		return label;
	}

	/**
	 * Method for Save one new label
	 * 
	 * @param data
	 *            for the new label
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "label/save", method = RequestMethod.POST)
	@ResponseBody
	public void setLabel(@RequestBody Label label) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for label");
		try {
			labelDAO.save(label);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for label " + e);
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

	@RequestMapping(method = RequestMethod.PUT, path = "label/edit/{id}")
	@ResponseBody

	public void editLabel(@PathVariable("id") long idprjlabel, @RequestBody Label label) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for label");
		try {
			labelDAO.save(label);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for label " + e);
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

	@RequestMapping(method = RequestMethod.DELETE, path = "label/delete/{id}")
	@ResponseBody
	public void getDeleteLabel(@PathVariable("id") long idprjlabel) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for label");
		try {
			labelDAO.delete(idprjlabel);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for label " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
