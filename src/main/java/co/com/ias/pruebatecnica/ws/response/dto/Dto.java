/**
 * 
 */
package co.com.ias.pruebatecnica.ws.response.dto;

import java.io.Serializable;

/**
 * @author gerlinorlandotorressaavedra
 *
 */
public class Dto<W> extends ResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private W object;

	/**
	 * @return the object
	 */
	public W getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(W object) {
		this.object = object;
	}

}
