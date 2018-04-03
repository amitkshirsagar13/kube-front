package io.kube.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.kube.front.service.MessageService;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName kube-front
 * Creation date: Apr 3, 2018
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@EnableDiscoveryClient
@SpringBootApplication
public class KubeFrontApplication {
	public static void main(String[] args) {
		SpringApplication.run(KubeFrontApplication.class, args);
	}

	public static final String ACCOUNTS_SERVICE_URL = "http://KUBE-SERVER";

	@LoadBalanced // Make sure to create the load-balanced template
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Message service calls microservice internally using provided URL.
	 */
	@Bean
	public MessageService messageService() {
		return new MessageService(ACCOUNTS_SERVICE_URL);
	}

}
