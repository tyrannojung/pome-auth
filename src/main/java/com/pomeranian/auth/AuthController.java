package com.pomeranian.auth;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pomeranian.config.WebConfig;


@RestController
public class AuthController {


	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	/** WebConfig **/
	@Autowired
	private WebConfig webConfig;
	
	
	@GetMapping(value="/run")
	public ModelAndView pomeWebAuth(
			Locale locale
			) {
		ModelAndView modelAndView = new ModelAndView("index");
		
		return modelAndView;
		
	}
	
	
}
