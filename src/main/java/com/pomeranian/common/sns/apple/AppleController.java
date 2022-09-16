package com.pomeranian.common.sns.apple;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pomeranian.config.WebConfig;


@RestController
public class AppleController {
	
	/** application.properties **/
	@Autowired
	private WebConfig webConfig;
	
	/** appleLoginUtil **/
	@Autowired
	private AppleLoginUtil appleLoginUtil;
	
	/**
	 * oauth_apple
	 * @param request
	 * @param code
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/oauth_apple")
	public ModelAndView oauth_apple(
			Locale locale
			, HttpSession session
			, HttpServletRequest request
			, @RequestParam(value = "code", required= false) String code
			, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("/member/signup");
		
		// 애플로그인 취소시 로그인페이지로 이동
		if(code == null) {
			return mav;
			
		}
		
	    String client_id = webConfig.getAppleClentId();
	    String client_secret = appleLoginUtil.createClientSecret(webConfig.getAppleTeamId(), webConfig.getAppleClentId(), webConfig.getAppleKeyId(), webConfig.getAppleKeyPath(), webConfig.getAppleAuthUrl());
	    
	    // 토큰 검증 및 발급
	    String reqUrl = webConfig.getAppleAuthUrl() + "/auth/token";
	    Map<String, String> tokenRequest = new HashMap<>();
	    tokenRequest.put("client_id", client_id);
	    tokenRequest.put("client_secret", client_secret);
	    tokenRequest.put("code", code);
	    tokenRequest.put("grant_type", "authorization_code");
	    String apiResponse = appleLoginUtil.doPost(reqUrl, tokenRequest);
	    JSONObject tokenResponse = new JSONObject(apiResponse);
        JSONObject appleInfo = appleLoginUtil.decodeFromIdToken(tokenResponse.getString("id_token"));
        System.out.println(appleInfo);
        mav.addObject("userInfo", appleInfo);
        
        return mav;
	}
}