package com.nova.MSNovaBK.rest;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
public class MainController {

	static final Logger log = Logger.getLogger(MainController.class);

	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "Developed by UdeA ";
	}

}