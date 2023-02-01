package com.HT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootAwsSnsExampleApplication {
	
	private AmazonSNSClient snsClient;
	
	String TOPIC_ARN="arn:aws:sns:ap-northeast-1:761562767263:javatechie-topic";
	
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest request=new SubscribeRequest(TOPIC_ARN,"email",email);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm the subscription, check your email : \" + email;
	}
	
	@GetMapping("/sendNotification")
	public String publishMessageToTopic(){
		 PublishRequest publishRequest=new PublishRequest(TOPIC_ARN,buildEmailBody(),"Notification: Network connectivity issue");
		 snsClient.publish(publishRequest);
		 return "Notification send successfully !!";
	}



	private String buildEmailBody(){
		return "Dear Employee ,\n" +
				"\n" +
				"\n" +
				"Connection down Bangalore."+"\n"+
				"All the servers in Bangalore Data center are not accessible. We are working on it ! \n" +
				"Notification will be sent out as soon as the issue is resolved. For any questions regarding this message please feel free to contact IT Service Support team";
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsSnsExampleApplication.class, args);
	}

}
