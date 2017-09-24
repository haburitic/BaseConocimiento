package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.UserDAO;
import com.nova.MSNovaBK.dto.User;
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
public class UserRestController {
	static final Logger log = Logger.getLogger(UserRestController.class);
	@Autowired
	UserDAO userDAO;

	/**
	 * Method for get one user with your ID
	 * 
	 * @param idnuser
	 *            Id the user
	 * @return Object the user wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("user/find/{id}")
	@ResponseBody

	public User getUser(@PathVariable("id") long idnuser) throws NovaBKDaoException {
		User user = new User();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one in user");
		try {

			user = userDAO.findByIdnuser(idnuser);
			if (!user.equals(null)) {

				log.info("Log4j get the product with id in user ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for user" + e);
			throw new NovaBKDaoException(e);

		}

		return user;
	}

	/**
	 * Method for get all user in the BD
	 * 
	 * @return arrayList whit all users
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("user/findall")
	@ResponseBody
	public List<User> getUserAll() throws NovaBKDaoException {
		List<User> user = new ArrayList<User>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All in user");
		try {

			user = userDAO.findAll();
			if (user.equals(null)) {

				log.info("Log4j get the users list ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for user" + e);
			throw new NovaBKDaoException(e);

		}

		return user;
	}

	/**
	 * Method for Save one new user
	 * 
	 * @param data
	 *            for the new user
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "user/save", method = RequestMethod.POST)
	@ResponseBody
	public void setUser(@RequestBody User user) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save in user");
		try {
			userDAO.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for user " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one user
	 * 
	 * @param idnuser
	 *            Id for user
	 * @param user
	 *            Data for update the user
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "user/edit/{id}")
	@ResponseBody

	public void editUser(@PathVariable("id") long idnuser, @RequestBody User user) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for user");
		try {
			userDAO.save(user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for user " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one user
	 * 
	 * @param idnuser
	 *            ID the user
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "user/delete/{id}")
	@ResponseBody
	public void getDeleteUser(@PathVariable("id") long idnuser) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for user");
		try {
			userDAO.delete(idnuser);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for user" + e);
			throw new NovaBKDaoException(e);
		}

	}

}
