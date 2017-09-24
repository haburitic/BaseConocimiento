package com.nova.MSNovaBK.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nova.MSNovaBK.dao.RolexPermissionDAO;
import com.nova.MSNovaBK.dto.RolexPermission;
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
public class RolexPermissionRestController {
	static final Logger log = Logger.getLogger(RolexPermissionRestController.class);
	@Autowired
	RolexPermissionDAO rolexPermissionDAO;

	
/**
 *  Method for get one relation between role and permission with your ID
 * @param idnrolxperm Id the rolexpermission
 * @return Object the rolexpermission wanted
 * @throws NovaBKDaoException Exception when the object not found
 */
	
	@RequestMapping("rolexpermission/find/{id}")
	@ResponseBody

	public RolexPermission getRolexPermission(@PathVariable("id") long idnrolexperm) throws NovaBKDaoException {
		RolexPermission rolexPermission = new RolexPermission();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method find one for Relation between rol and permission ");
		try {

			rolexPermission = rolexPermissionDAO.findByIdnrolexperm(idnrolexperm);
			if (!rolexPermission.equals(null)) {

				log.info("Log4j get the relation between role and permission with id ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find for relation between role and permission " + e);
			throw new NovaBKDaoException(e);

		}

		return rolexPermission;
	}

	
/**
 * Method for get all relation between roles and permission
 * @return arraylist whit all permissions
 * @throws NovaBKDaoException
 */
	
	@RequestMapping("rolexpermission/findall")
	@ResponseBody
	public List<RolexPermission> getRolexPermissionAll() throws NovaBKDaoException {
		List<RolexPermission> rolexPermission = new ArrayList<RolexPermission>();

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method find All for relation between role and permission");
		try {

			rolexPermission = rolexPermissionDAO.findAll();
			if (rolexPermission.equals(null)) {

				log.info("Log4j get the list relation between role and permission ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in Find All the relation between role and permission " + e);
			throw new NovaBKDaoException(e);

		}

		return rolexPermission;
	}

	
/**
 * Method for save one relation between role and permission
 * @param rolexPermission data  for the new rolexpermission
 * @throws NovaBKRestException
 */
	@RequestMapping(value = "rolexpermission/save", method = RequestMethod.POST)
	@ResponseBody
	public void setRolexPermission(@RequestBody RolexPermission rolexPermission) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method save for relaion between role and permission");
		try {
			rolexPermissionDAO.save(rolexPermission);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Save for relation between role and permission " + e);
			throw new NovaBKRestException(e);

		}

	}


/**
 * Method for edit one relation between role and permission
 * @param idnrolexperm Id for rolexpermission
 * @param rolexPermission Object for Update the rolexpermission
 * @throws NovaBKRestException
 */
	@RequestMapping(method = RequestMethod.PUT, path = "rolexpermission/edit/{id}")
	@ResponseBody

	public void editRolexPermission(@PathVariable("id") long idnrolexperm, @RequestBody RolexPermission rolexPermission) throws NovaBKRestException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method edit for relation between role and permission");
		try {
			rolexPermissionDAO.save(rolexPermission);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Update for relation between role and permission" + e);
			throw new NovaBKRestException(e);
		}

	}	
	
/**
 * Method for Delete one relation between role and permission
 * @param idnrolexperm Id the rolexpermission
 * @throws NovaBKDaoException
 */
	@RequestMapping(method = RequestMethod.DELETE, path = "rolexpermission/delete/{id}")
	@ResponseBody
	public void getDeleteRolexPermission(@PathVariable("id") long idnrolexperm) throws NovaBKDaoException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j in method Delete for relation between role and permission");
		try {
			rolexPermissionDAO.delete(idnrolexperm);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error("Log4j Error in method Delete for relation between role and permission " + e);
			throw new NovaBKDaoException(e);
		}

	}

}
