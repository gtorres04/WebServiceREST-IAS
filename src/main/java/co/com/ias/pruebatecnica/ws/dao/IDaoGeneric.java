package co.com.ias.pruebatecnica.ws.dao;

import java.util.List;

public interface IDaoGeneric<T> {
	/**
	 * Registra en la base de datos un objeto de tipo T.
	 * 
	 * @param object
	 */
	void create(T object);

	/**
	 * Registrar una lista de entidades de tipo T.
	 * 
	 * @param object
	 */
	void create(List<T> object);

	/**
	 * consulta en la base de datos un objeto de tipo T teniendo en cuenta su
	 * ID.
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 * @return objeto de tipo T correspondiente al ID
	 */
	T findById(T object);

	/**
	 * Consulta en la base de datos todos los objetos de tipo T.
	 * 
	 * @return Listado de objetos de tipo T
	 */
	List<T> findAll(Class<T> clase);

	/**
	 * Actualiza los valores de los atributos del objeto con ID digitado.
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 */
	void update(T object);

	/**
	 * elimina de la base de datos el objeto con ID digitado.
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 */
	void delete(T object);

	/**
	 * elimina de la base de datos una lista de objeto con ID digitado.
	 * 
	 * @param object
	 *            con solo el campo ID setiado
	 */
	void delete(List<T> object);
}
