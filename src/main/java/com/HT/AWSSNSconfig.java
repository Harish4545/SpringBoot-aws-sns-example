package com.HT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;

@Configuration
public class AWSSNSconfig {
	
	public static final String SECRET_KEY="u+mmao5sVeIkHE/PX+NSqL36l1+pYTB453LHp75h";
	public static final String ACCESS_KEY="AKIA3CUFNT6PUOBRON4Q";
	
	@Primary
	@Bean
	public amazonSNSClient getSnsClient() {
		
		return (AmazonSnsClient) AmazonSNSClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY,SECRET_KEY)))
		.built();
	}

}
