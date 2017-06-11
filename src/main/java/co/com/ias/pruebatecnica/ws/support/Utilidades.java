package co.com.ias.pruebatecnica.ws.support;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gerlinorlandotorressaavedra
 *
 */
public class Utilidades {
	/**
	 * Constructor privado para que no se genere un instancia de esta clase
	 */
	private Utilidades() {
	}

	/**
	 * Elimina los objetos nulos que existan en la lista recivida por el
	 * parametro
	 * 
	 * @param listado
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List eliminarObjetosNulos(List listado) {
		List listadoAux = listado;
		if (listado != null) {
			List objetosNoNulos = new ArrayList<>(0);
			for (int i = 0; i < listado.size(); i++) {
				Object objeto = listado.get(i);
				if (null != objeto) {
					objetosNoNulos.add(objeto);
				}
			}
			listadoAux = objetosNoNulos;
		}
		return listadoAux;
	}
}
