package com.realestatebrokerage.config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.FirebaseApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.util.Utils;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;

@Configuration
public class NotificationConfiguration {
	@Autowired
	private ApplicationProperties applicationProperties;

	@Bean
	public Boolean init() {
		try {
			Map<String, Object> secretJson = new HashMap<>();
			secretJson.put("type", applicationProperties.getFireBase().getType());
			secretJson.put("project_id", applicationProperties.getFireBase().getProjectId());
			secretJson.put("private_key_id", applicationProperties.getFireBase().getPrivateKeyId());
			secretJson.put("private_key", applicationProperties.getFireBase().getPrivateKey());
			secretJson.put("client_email", applicationProperties.getFireBase().getClientEmail());
			secretJson.put("client_id", applicationProperties.getFireBase().getClientId());
			secretJson.put("auth_uri", applicationProperties.getFireBase().getAuthUri());
			secretJson.put("token_uri", applicationProperties.getFireBase().getTokenUri());
			secretJson.put("auth_provider_x509_cert_url",
					applicationProperties.getFireBase().getAuthProviderX509CertUrl());
			secretJson.put("client_x509_cert_url", applicationProperties.getFireBase().getClientX509CertUrl());
			InputStream accountService = new ByteArrayInputStream(
					Utils.getDefaultJsonFactory().toByteArray(secretJson));

			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(accountService))
					.setDatabaseUrl("https://databaseName.firebaseio.com").setDatabaseAuthVariableOverride(null)
					.build();
			FirebaseApp.initializeApp(options);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
