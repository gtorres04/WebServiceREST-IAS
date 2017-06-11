/**
 * 
 */
package co.com.ias.pruebatecnica.ws.response.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author gerlinorlandotorressaavedra
 *
 */
public class ListaDto<W> extends ResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<W> listado;

	/**
	 * @return the proveedores
	 */
	public List<W> getList() {
		return listado;
	}

	/**
	 * @param proveedores the proveedores to set
	 */
	public void setList(List<W> listado) {
		this.listado = listado;
	}
	
	
}
