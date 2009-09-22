// $Id: DirectRequestPOST.java,v 1.6 2009-09-22 12:37:57 tgambet Exp $
// Author: Damien LEROY.
// (c) COPYRIGHT MIT, ERCIM ant Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.request;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;

import org.w3c.unicorn.contract.EnumInputMethod;
import org.w3c.unicorn.input.DirectInputModule;
import org.w3c.unicorn.response.Response;
import org.w3c.unicorn.util.ClientHttpRequest;

/**
 * Class to make a request directly using POST method
 * 
 * @author Damien LEROY
 */
public class DirectRequestPOST extends Request {

	/**
	 * URL for the post direct request
	 */
	private String sURL = null;

	/**
	 * Data Structure for the parameters
	 */
	private Map<String, String> mapOfParameter = null;

	/**
	 * Constructor for a direct request using post method
	 * 
	 * @param sURL
	 *            URL to connect
	 * @param sInputParameterName
	 *            parameter name
	 * @param aInputModule
	 *            input module for the request
	 * @param responseType
	 *            type of the response of the observer
	 * @throws IOException
	 *             odd error occurs
	 */
	protected DirectRequestPOST(final String sURL,
			final String sInputParameterName, DirectInputModule aInputModule,
			final String responseType, String observerId) {
		super();
		logger.trace("Constructor");
		logger.debug("URL : " + sURL + ".");
		logger.debug("Input parameter name : "+ sInputParameterName + ".");
		logger.debug("Input module : " + aInputModule + ".");
		mapOfParameter = new Hashtable<String, String>();
		this.sURL = sURL;
		this.observerId = observerId;
		addParameter(sInputParameterName, aInputModule.getStringContent());
		setResponseType(responseType);
	}

	@Override
	public void addParameter(final String sName, final String sValue) {
		logger.trace("addParameter");
		logger.debug("Name :" + sName + ".");
		logger.debug("Value :" + sValue + ".");
		mapOfParameter.put(sName, sValue);
	}

	@Override
	public Response doRequest() throws Exception {
		logger.trace("doRequest");
		
		ClientHttpRequest request = new ClientHttpRequest(sURL);
		request.setLang(sLang);
		request.setParameters(mapOfParameter);

		InputStream is = request.post();
		return streamToResponse(is);
	}

	@Override
	public EnumInputMethod getInputMethod() {
		logger.trace("getInputMethod");
		return EnumInputMethod.DIRECT;
	}

	@Override
	public String toString() {
		final int iStringBufferSize = 1000;
		final StringBuffer aStringBuffer = new StringBuffer(iStringBufferSize);
		aStringBuffer.append("url:").append(this.sURL);
		return aStringBuffer.toString();
	}

}
