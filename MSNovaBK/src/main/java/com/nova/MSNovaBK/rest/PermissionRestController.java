package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.PermissionDAO;
import com.nova.MSNovaBK.dto.Permission;
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
public class PermissionRestController {
	static final Logger log = Logger.getLogger(PermissionRestController.class);
	@Autowired
	PermissionDAO permissionDAO;

	/**
	 * Method for get one permission with your ID
	 * 
	 * @param idnpermissions
	 *            Id the permission
	 * @return Object the permission wanted
	 * @throws NovaBKDaoException
	 *             Exception when the object not found
	 */

	@RequestMapping("permission/find/{id}")
	@ResponseBody

	public Permission getPermission(@PathVariable("id") long idnpermissions) throws NovaBKDaoException {
		Permission permission = new Permission();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j for method find one for permission");
		try {

			permission = permissionDAO.findByIdnpermissions(idnpermissions);
			if (!permission.equals(null)) {

				log.info("Log4j get the permission with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for permission " + e);
			throw new NovaBKDaoException(e);

		}

		return permission;
	}

	/**
	 * Method for get all permission in the BD
	 * 
	 * @return arrayList whit all permissions
	 * @throws NovaBKDaoException
	 */

	@RequestMapping("permission/findall")
	@ResponseBody
	public List<Permission> getPermissionAll() throws NovaBKDaoException {
		List<Permission> permission = new ArrayList<Permission>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for permission");
		try {

			permission = permissionDAO.findAll();
			if (permission.equals(null)) {

				log.info("Log4j get the list permission ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for permission " + e);
			throw new NovaBKDaoException(e);

		}

		return permission;
	}

	/**
	 * Method for Save one new permission
	 * 
	 * @param data
	 *            for the new permission
	 * @throws NovaBKRestException
	 */

	@RequestMapping(value = "permission/save", method = RequestMethod.POST)
	@ResponseBody
	public void setPermission(@RequestBody Permission permission) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method save for permission");
		try {
			permissionDAO.save(permission);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for permission " + e);
			throw new NovaBKRestException(e);

		}

	}

	/**
	 * Method for edit one permission
	 * 
	 * @param idnpermissions
	 *            Id for permissions
	 * @param permission
	 *            Data for update the permission
	 * @throws NovaBKRestException
	 */

	@RequestMapping(method = RequestMethod.PUT, path = "permission/edit/{id}")
	@ResponseBody

	public void editPermission(@PathVariable("id") long idnpermissions, @RequestBody Permission permission) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method edit for permission");
		try {
			permissionDAO.save(permission);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for permission " + e);
			throw new NovaBKRestException(e);
		}

	}

	/**
	 * Method for Delete one permission
	 * 
	 * @param idnpermission
	 *            ID the permission
	 * @throws NovaBKDaoException
	 */

	@RequestMapping(method = RequestMethod.DELETE, path = "permission/delete/{id}")
	@ResponseBody
	public void getDeletePermission(@PathVariable("id") long idnpermissions) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method Delete for permission");
		try {
			permissionDAO.delete(idnpermissions);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for permission" + e);
			throw new NovaBKDaoException(e);
		}

	}

}
