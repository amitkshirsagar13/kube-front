/**
 * 
 */
package io.kube.front.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.kube.front.data.Message;
import io.kube.front.data.Response;
import io.kube.front.exception.ResponseNotFoundException;

/**
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
@Service
public class MessageService {
	private static Logger log4j = Logger.getLogger(MessageService.class);

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public MessageService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	public Response<Message> getByName(String name) throws ResponseNotFoundException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serviceUrl + "/rest/api/message")
				// Add query parameter
				.queryParam("name", name);
		String queryUrl = builder.buildAndExpand().toUri().toString();

		log4j.info("Called frontend service:" + queryUrl);
		Response<Message> responseList = restTemplate.getForObject(queryUrl, Response.class);

		if (responseList == null)
			throw new ResponseNotFoundException(name);
		else
			return responseList;
	}
}
