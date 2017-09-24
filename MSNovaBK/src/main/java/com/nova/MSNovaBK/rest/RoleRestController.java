package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.RoleDAO;
import com.nova.MSNovaBK.dto.Role;
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
public class RoleRestController {
	static final Logger log = Logger.getLogger(RoleRestController.class);
	@Autowired
	RoleDAO roleDAO;

	/**
	 * Method for get one role with your ID
	 * 
	 * @param idnrole
	 *            Id the Role
	 * @return Object the Role wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("role/find/{id}")
	@ResponseBody

	public Role getRole(@PathVariable("id") long idnrole) throws NovaBKDaoException {
		Role role = new Role();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one fot role");
		try {

			role = roleDAO.findByIdnrole(idnrole);
			if (!role.equals(null)) {

				log.info("Log4j get the role with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Find for role" + e);
			throw new NovaBKDaoException(e);

		}

		return role;
	}

	/**
	 * Method for get all roles in the BD
	 * 
	 * @return arrayList whit all roles
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("role/findall")
	@ResponseBody
	public List<Role> getRoleAll() throws NovaBKDaoException {
		List<Role> role = new ArrayList<Role>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for role");
		try {

			role = roleDAO.findAll();
			if (role.equals(null)) {

				log.info("Log4j get the list Roles ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for role " + e);
			throw new NovaBKDaoException(e);

		}

		return role;
	}

	/**
	 * Method for Save one new role
	 * 
	 * @param data
	 *            for the new role
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "role/save", method = RequestMethod.POST)
	@ResponseBody
	public void setRole(@RequestBody Role role) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for role");
		try {
			roleDAO.save(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for role " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one role
	 * 
	 * @param idnrole
	 *            Id for role
	 * @param role
	 *            Data for update the role
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "role/edit/{id}")
	@ResponseBody

	public void editRole(@PathVariable("id") long idnrole, @RequestBody Role role) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Update for Role");
		try {
			roleDAO.save(role);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Update for Role " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one Role
	 * 
	 * @param idnrole
	 *            ID the role
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "role/delete/{id}")
	@ResponseBody
	public void getDeleteRole(@PathVariable("id") long idnrole) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for Role");
		try {
			roleDAO.delete(idnrole);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in Method Delete for Role " + e);
			throw new NovaBKDaoException(e);
		}

	}

}