package com.pomeranian.common.sns.facebook;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pomeranian.config.WebConfig;

@RestController
public class FacebookController {
	
	/** application.properties **/
	@Autowired
	private WebConfig webConfig;
	
	/** facebookLoginUtill **/
	@Autowired
	private FacebookLoginUtill facebookLoginUtill;
	
	/**
	 * oauthKakao
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/login/oauth_facebook")
	public ModelAndView oauthKakao(
			HttpSession session
			, @RequestParam(value = "code", required = false) String code) throws Exception {
		
		ModelAndView mav = new ModelAndView("/member/signup");

        String access_Token = facebookLoginUtill.getAccessToken(code);
        HashMap<String, Object> userInfo = facebookLoginUtill.getUserInfo(access_Token);
        JSONObject facebookInfo =  new JSONObject(userInfo);
        
//        String email = facebookInfo.getString("email");
//        String facebook_id = facebookInfo.getString("id");
        
        mav.addObject("userInfo", facebookInfo);
        
        return mav;
        
	}
}