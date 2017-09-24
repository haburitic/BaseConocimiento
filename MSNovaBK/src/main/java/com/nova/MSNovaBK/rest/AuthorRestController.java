package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.AuthorDAO;

import com.nova.MSNovaBK.dto.Author;

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
public class AuthorRestController {
	static final Logger log = Logger.getLogger(AuthorRestController.class);
	@Autowired
	AuthorDAO authorDAO;

	/**
	 * Method for get one author with your ID
	 * 
	 * @param idnauthor
	 *            Id the author
	 * @return Object the author wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("author/find/{id}")
	@ResponseBody

	public Author getAuthor(@PathVariable("id") long idnauthor) throws NovaBKDaoException {
		Author author = new Author();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in author");
		try {

			author = authorDAO.findByIdnauthor(idnauthor);
			if (!author.equals(null)) {

				log.info("Log4j get the author with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Method Find for author " + e);
			throw new NovaBKDaoException(e);

		}

		return author;
	}

	/**
	 * Method for get all authors in the BD
	 * 
	 * @return arrayList whit all authors
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("author/findall")
	@ResponseBody
	public List<Author> getAuthorAll() throws NovaBKDaoException {
		List<Author> author = new ArrayList<Author>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for author");
		try {

			author = authorDAO.findAll();
			if (author.equals(null)) {

				log.info("Log4j get the list authors ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for authors" + e);
			throw new NovaBKDaoException(e);

		}

		return author;
	}

	/**
	 * Method for Save one new author
	 * 
	 * @param data
	 *            for the new author
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "author/save", method = RequestMethod.POST)
	@ResponseBody
	public void setAuthor(@RequestBody Author author) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for author");
		try {
			authorDAO.save(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for author " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one author
	 * 
	 * @param idnauthor
	 *            Id for author
	 * @param author
	 *            Data for update the author
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "author/edit/{id}")
	@ResponseBody

	public void editAuthor(@PathVariable("id") long idnauthor, @RequestBody Author author) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for author");
		try {
			authorDAO.save(author);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for author " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one author
	 * 
	 * @param idnauthor
	 *            ID the author
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "author/delete/{id}")
	@ResponseBody
	public void getDeleteAuthor(@PathVariable("id") long idnauthor) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for author");
		try {
			authorDAO.delete(idnauthor);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for author " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
