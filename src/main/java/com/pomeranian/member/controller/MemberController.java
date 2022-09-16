package com.pomeranian.member.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pomeranian.config.WebConfig;


@RestController
public class MemberController {


	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
//	@GetMapping(value="/signup")
//	public ModelAndView pomeSignUp(
//			Locale locale
//			) {
//		
//		ModelAndView modelAndView = new ModelAndView("/member/signup");
//		
//		return modelAndView;
//		
//	}
	
	
}
