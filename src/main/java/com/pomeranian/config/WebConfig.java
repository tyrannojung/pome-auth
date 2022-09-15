package com.pomeranian.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
	
	private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	@Value("${google.client.id}")
    private String googleClientId;
	
	@Value("${google.secret}")
    private String googleSecret;
	
	@Value("${facebook.client.id}")
    private String facebookClientId;
	
	@Value("${facebook.secret.id}")
    private String facebookSecretId;
	
    @Value("${apple.auth.url}")
    private String appleAuthUrl;

    @Value("${apple.team.id}")
    private String appleTeamId;

    @Value("${apple.client.id}")
    private String appleClentId;

    @Value("${apple.key.id}")
    private String appleKeyId;

    @Value("${apple.key.path}")
    private String appleKeyPath;
    
	public String getGoogleClientId() {
		return googleClientId;
	}
	
	public String getGoogleSecret() {
		return googleSecret;
	}
    
	public String getFacebookClientId() {
		return facebookClientId;
	}
	
	public String getFacebookSecretId() {
		return facebookSecretId;
	}
    
	public String getAppleAuthUrl() {
		return appleAuthUrl;
	}

	public String getAppleTeamId() {
		return appleTeamId;
	}

	public String getAppleClentId() {
		return appleClentId;
	}

	public String getAppleKeyId() {
		return appleKeyId;
	}

	public String getAppleKeyPath() {
		return appleKeyPath;
	}
	
}
