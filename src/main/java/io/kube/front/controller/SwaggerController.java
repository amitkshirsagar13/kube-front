package io.kube.front.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName kube-server
 * Creation date: Mar 13, 2018
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
public class SwaggerController {

	/**
	 * log4j object for debugging.
	 */
	private static Logger log4j = Logger.getLogger(SwaggerController.class);

	@RequestMapping(value = "/swagger", method = RequestMethod.GET)
	public ModelAndView swaggerui() {
		return new ModelAndView("redirect:" + "/swagger-ui.html");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("redirect:" + "/swagger-ui.html");
	}
}
