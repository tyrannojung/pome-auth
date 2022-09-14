package com.pomeranian.common.sns.facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pomeranian.config.WebConfig;

@Component
public class FacebookLoginUtill {
	
	/** application.properties **/
	@Autowired
	private WebConfig webConfig;
	
	/** HttpServletRequest **/
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * getAccessToken
	 * @param authorize_code
	 * @return
	 */
	public String getAccessToken (String authorize_code) {
		
		//String domain = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort(); // http://localhost:8080
		String domain = request.getScheme()+"://"+request.getServerName(); // http://localhost
		
        String access_Token = "";
        String reqURL = "https://graph.facebook.com/v12.0/oauth/access_token"
        				+"?client_id="+webConfig.getFacebookClientId()
        				+"&redirect_uri="+ domain + "/login/oauth_facebook"
        				+"&client_secret="+ webConfig.getFacebookSecretId()
        				+"&code="+ authorize_code;

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            //	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
                
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();

            System.out.println("access_token : " + access_Token);

            br.close();
            bw.close();
            
        } catch (IOException e) {
        	//e.printStackTrace();
			System.out.println(e.getMessage().toString());
			
        }
        return access_Token;
        
    }
	
	/**
	 * getUserInfo
	 * @param access_Token
	 * @return
	 */
    public HashMap<String, Object> getUserInfo (String access_Token) {
        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://graph.facebook.com/me?fields=id,name,email";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            
            JSONObject facebookInfo =  new JSONObject(result);
            
            String name = facebookInfo.getString("name");
            String id = facebookInfo.getString("id");
            String email = facebookInfo.getString("email");
            
            userInfo.put("name", name);
            userInfo.put("id", id);
            userInfo.put("email", email);
            
        } catch (IOException e) {
        	//e.printStackTrace();
			System.out.println(e.getMessage().toString());
			
        }
        return userInfo;
        
    }
}
