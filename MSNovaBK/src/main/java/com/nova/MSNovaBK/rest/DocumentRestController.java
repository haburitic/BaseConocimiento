package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.DocumentDAO;
import com.nova.MSNovaBK.dto.Document;
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
public class DocumentRestController {
	static final Logger log = Logger.getLogger(DocumentRestController.class);
	@Autowired
	DocumentDAO documentDAO;

	/**
	 * Method for get one document with your ID
	 * 
	 * @param idndocument Id the document
	 * @return Object the type document wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("document/find/{id}")
	@ResponseBody

	public Document getDocument(@PathVariable("id") long idndocument) throws NovaBKDaoException {
		Document document = new Document();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in document");
		try {

			document = documentDAO.findByIdndocument(idndocument);
			if (!document.equals(null)) {

				log.info("Log4j get the document with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for document" + e);
			throw new NovaBKDaoException(e);

		}

		return document;
	}

	/**
	 * Method for get all documents in the BD
	 * 
	 * @return arrayList whit all documents
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("document/findall")
	@ResponseBody
	public List<Document> getDocumentAll() throws NovaBKDaoException {
		List<Document> document = new ArrayList<Document>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for document");
		try {

			document = documentDAO.findAll();
			if (document.equals(null)) {

				log.info("Log4j get the list documents ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for document " + e);
			throw new NovaBKDaoException(e);

		}

		return document;
	}

	/**
	 * Method for Save one new document
	 * 
	 * @param data
	 *            for the new document
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "document/save", method = RequestMethod.POST)
	@ResponseBody
	public void setDocument(@RequestBody Document document) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for document");
		try {
			documentDAO.save(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in methd Save for document " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one document
	 * 
	 * @param idndocument
	 *            Id for document
	 * @param document
	 *            Data for update the document
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "document/edit/{id}")
	@ResponseBody

	public void editDocument(@PathVariable("id") long idndocument, @RequestBody Document document) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for document");
		try {
			documentDAO.save(document);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for document " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one document
	 * 
	 * @param idndocument
	 *            ID the document
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "document/delete/{id}")
	@ResponseBody
	public void getDeleteDocument(@PathVariable("id") long idndocument) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for document");
		try {
			documentDAO.delete(idndocument);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for document " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
