package com.pomeranian.common.sns.google;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.pomeranian.config.WebConfig;

@RestController
public class GoogleController {
	
	/** application.properties **/
	@Autowired
	private WebConfig webConfig;

	/**
	 * googleAuth
	 * @param memberDTO
	 * @param session
	 * @param authCode
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/login/oauth_google")
	public ModelAndView googleAuth(
			HttpSession session
			, @RequestParam(value = "code") String authCode
			, HttpServletRequest request) throws Exception {
		
		//String domain = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); // http://localhost:8080
		String domain = request.getScheme()+"://"+request.getServerName(); // http://localhost	
		
		ModelAndView mav = new ModelAndView("/member/signup");
		
		//HTTP Request를 위한 RestTemplate
		RestTemplate restTemplate = new RestTemplate();
 
		//Google OAuth Access Token 요청을 위한 파라미터 세팅
		GoogleOAuthRequest googleOAuthRequestParam =  new GoogleOAuthRequest();
		googleOAuthRequestParam.setClientId(webConfig.getGoogleClientId());
		googleOAuthRequestParam.setClientSecret(webConfig.getGoogleSecret());
		googleOAuthRequestParam.setCode(authCode);
		googleOAuthRequestParam.setRedirectUri(domain + "/login/oauth_google");
		googleOAuthRequestParam.setGrantType("authorization_code");
		
		//JSON 파싱을 위한 기본값 세팅
		//요청시 파라미터는 스네이크 케이스로 세팅되므로 Object mapper에 미리 설정해준다.
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.setSerializationInclusion(Include.NON_NULL);
 
		//AccessToken 발급 요청
		ResponseEntity<String> resultEntity = restTemplate.postForEntity("https://oauth2.googleapis.com/token", googleOAuthRequestParam, String.class);
 
		//Token Request
		GoogleOAuthResponse result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponse>() {
		});
 
		//ID Token만 추출 (사용자의 정보는 jwt로 인코딩 되어있다)
		String jwtToken = result.getIdToken();
		String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo").queryParam("id_token", jwtToken).toUriString();
		String resultJson = restTemplate.getForObject(requestUrl, String.class);
		
		Map<String,String> googleInfo2 = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
		JSONObject googleInfo =  new JSONObject(googleInfo2);
		
		String email = googleInfo.get("email").toString();
        String google_id = googleInfo.get("sub").toString();
        System.out.println(email + ", " + google_id);
        System.out.println(googleInfo);
        
        mav.addObject("userInfo", googleInfo);
        return mav;
        
	}
	
}