package co.com.ias.pruebatecnica.ws.service;

import java.util.List;

public interface IService<T> {
	/**
	 * Envia al DAO un objeto de tipo T para su persistencia
	 * 
	 * @param object
	 *            de tipo T enviado al DAO
	 */
	void create(T object);

	/**
	 * Envia al DAO una lista de objeto de tipo T para su persistencia
	 * 
	 * @param object
	 *            de tipo T enviado al DAO
	 */
	void create(List<T> object);

	/**
	 * Consulta al DAO un objeto de T por su ID
	 * 
	 * @param object
	 *            de tipo T con solo el campo ID setiado
	 * @return un objeto de tipo T
	 */
	T findById(T object);

	/**
	 * Consulta al DAO todos los objetos de tipo T persistidos
	 * 
	 * @return listado de objetos de tipo T
	 */
	List<T> findAll(Class<T> clase);

	/**
	 * Envia al DAO un objeto de tipo T para su modificacion
	 * 
	 * @param object
	 *            de tipo T
	 */
	void update(T object);

	/**
	 * Envia al DAO una lista de objetos de tipo T para su modificacion
	 * 
	 * @param object
	 */
	void update(List<T> object);

	/**
	 * Envia al DAO un objeto de tipo T para su eliminacion
	 * 
	 * @param object
	 *            de tipo T con solo el campo ID setiado
	 */
	void delete(T object);
}
