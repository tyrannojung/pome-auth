package com.pomeranian.auth.controller;

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
public class AuthController {


	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	/** application.properties **/
	@Autowired
	private WebConfig webConfig;
	
	/**
	 * pomeWebAuth
	 * @param locale
	 * @param request
	 * @return
	 */
	@GetMapping(value="/run")
	public ModelAndView pomeWebAuth(
			Locale locale
			, HttpServletRequest request
			) {
		
		String domain = request.getScheme()+"://"+request.getServerName();
		ModelAndView modelAndView = new ModelAndView("/auth/popup");
		
		//Google
		String googleOauthUrl = 
				"https://accounts.google.com/o/oauth2/v2/auth?client_id=" 
				+ webConfig.getGoogleClientId() 
				+ "&redirect_uri=" 
				+ domain + "/login/oauth_google"
	            + "&response_type=code&scope=email%20profile%20openid&access_type=offline";
		modelAndView.addObject("googleOauthUrl", googleOauthUrl);
		
		//Facebook
		String facebookOauthUrl = 
				"https://www.facebook.com/v12.0/dialog/oauth"
				+ "?client_id="
			    + webConfig.getFacebookClientId()
				+ "&redirect_uri="
				+ domain + "/login/oauth_facebook"
				+ "&state={\"{st=state123abc,ds=123456789}\"}"
				+ "&scope=email";
		modelAndView.addObject("facebookOauthUrl", facebookOauthUrl);
		
		//Apple
	    String appleOauthUrl = 
	    		webConfig.getAppleAuthUrl() 
	    		+ "/auth/authorize?client_id=" 
	    	    + webConfig.getAppleClentId() 
	    	    + "&redirect_uri=" 
	    	    + domain + "/login/oauth_apple"
	            + "&response_type=code id_token&scope=name email&response_mode=form_post";
	    modelAndView.addObject("appleOauthUrl", appleOauthUrl);
	    
		return modelAndView;
		
	}
	
	
}
