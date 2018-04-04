/**
 * 
 */
package io.kube.front.data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName kube-front
 * Creation date: Mar 31, 2018
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
public class Response<T> {

	private long responseTime;
	private String server;
	private String port;
	private List<String> errorList;
	private String status;
	private T baseResponse;

	/**
	 * @return the responseTime
	 */
	public long getResponseTime() {
		return responseTime;
	}

	/**
	 * @param responseTime
	 *            the responseTime to set
	 */
	public Response setResponseTime(long responseTime) {
		this.responseTime = responseTime;
		return this;
	}

	/**
	 * @return the server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * @param server
	 *            the server to set
	 */
	public Response setServer(String server) {
		this.server = server;
		return this;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public Response setPort(String port) {
		this.port = port;
		return this;
	}

	/**
	 * @return the baseResponse
	 */
	public T getBaseResponse() {
		return baseResponse;
	}

	/**
	 * @param baseResponse
	 *            the baseResponse to set
	 */
	public Response setBaseResponse(T baseResponse) {
		this.baseResponse = baseResponse;
		return this;
	}

	/**
	 * @return the errorList
	 */
	public List<String> getErrorList() {
		if (errorList == null) {
			errorList = new ArrayList<>();
		}
		return errorList;
	}

	/**
	 * @param errorList
	 *            the errorList to set
	 */
	public Response setErrorList(List<String> errorList) {
		this.errorList = errorList;
		return this;
	}

	public Response addError(String message) {
		getErrorList().add(message);
		return this;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public Response setStatus(String status) {
		this.status = status;
		return this;
	}

}
