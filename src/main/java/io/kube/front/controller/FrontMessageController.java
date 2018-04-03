/**
 * 
 */
package io.kube.front.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kube.front.data.Message;
import io.kube.front.data.Response;
import io.kube.front.service.MessageService;

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
@RestController
@RequestMapping(value = "/rest")
public class FrontMessageController {
	private static Logger log4j = Logger.getLogger(FrontMessageController.class);

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/api/message", method = RequestMethod.GET, produces = "application/json")
	public Response<Message> list(@RequestParam(name = "name") String name) throws Exception {
		log4j.info("Called frontend controller");
		return messageService.getByName(name);
	}
}
