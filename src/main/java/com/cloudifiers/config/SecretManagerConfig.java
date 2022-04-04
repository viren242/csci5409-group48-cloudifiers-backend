package com.cloudifiers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.cloudifiers.model.DatabaseSecret;
import com.google.gson.Gson;

@Configuration
public class SecretManagerConfig {

	// aws secret manager credentials
	@Value("${cloud.aws.secret-manager.secret-name}")
	private String secretName;

	@Value("${cloud.aws.secret-manager.secret-region}")
	private String secretRegion;

	// aws cloud credentials
	@Value("${cloud.aws.credentials.secret-access-key}")
	private String secretAccessKey;

	@Value("${cloud.aws.credentials.access-key-id}")
	private String accessKeyId;

	@Value("${cloud.aws.credentials.session-token}")
	private String sessionToken;

	@Value("${cloud.aws.region.static}")
	private String region;

	@Autowired
	private Gson gson;

	@Bean
	public DatabaseSecret getSecret() {
		DatabaseSecret databaseSecret = null;
		try {
			AWSCredentials awsCredentials = new BasicSessionCredentials(accessKeyId, secretAccessKey, sessionToken);
			AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(
					awsCredentials);

			AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(region)
					.withCredentials(awsStaticCredentialsProvider).build();

			GetSecretValueRequest secretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
			GetSecretValueResult secretValueResult = null;

			secretValueResult = client.getSecretValue(secretValueRequest);

			if (secretValueResult.getSecretString() != null) {
				String secret = secretValueResult.getSecretString();
				databaseSecret = gson.fromJson(secret, DatabaseSecret.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return databaseSecret;
	}
}
