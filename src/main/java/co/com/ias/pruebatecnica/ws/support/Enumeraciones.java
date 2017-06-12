
package co.com.ias.pruebatecnica.ws.support;

public class Enumeraciones {

	/**
	 * Constructor privado evitando la instanciacion de esta clase
	 */
	private Enumeraciones() {
	}

	/**
	 * Mensajes correspondientes a las exceptiones gestionadas por la capa DAO
	 * 
	 * @author gerlinorlandotorressaavedra
	 *
	 */
	public enum MSN_EXCEPTION_DAO {
		MSN_ERROR_NO_GESTIONADO("Estamos presentando problemas tecnicos");

		private String mensaje;

		MSN_EXCEPTION_DAO(String mensaje) {
			this.mensaje = mensaje;
		}

		public String getMensaje() {
			return mensaje;
		}
	}

	/**
	 * Mensajes correspondientes a las exceptiones gestionadas por la capa DAO
	 * 
	 * @author gerlinorlandotorressaavedra
	 *
	 */
	public enum MSN_EXCEPTION_SERVICE {
		MSN_ERROR_NO_GESTIONADO("Estamos presentando problemas tecnicos"),
		MSN_REGISTRO_EXITOSO("El registro se realizo de manera exitosa"),
		MSN_EDICION_EXITOSO("La modificacion se realizo de manera exitosa"),
		MSN_ELIMINACION_EXITOSO("La eliminacion se realizo de manera exitosa"),
		MSN_REGISTRO_CODIGO_EXISTENTE("Registro con codigo existente");

		private String mensaje;

		MSN_EXCEPTION_SERVICE(String mensaje) {
			this.mensaje = mensaje;
		}

		public String getMensaje() {
			return mensaje;
		}
	}

	/**
	 * @author gerlinorlandotorressaavedra
	 * Codigos de respuesta segun la solicitud hecha.
	 */
	public enum CodigosResponseDto{
		SUCCES((byte)0), FAIL((byte)-1);
		
		private byte codigo;
		private CodigosResponseDto(byte numero){
			this.codigo=numero;
		}
		/**
		 * @return the codigo
		 */
		public byte getValue() {
			return codigo;
		}
		
	}
	
	/**
	 * @author gerlinorlandotorressaavedra
	 *	valores de ejecucion de respuesta segun la solicitud hecha.
	 */
	public enum EjecucionResponseDto{
		SUCCES(true), FAIL(false);
		
		private boolean valor;
		private EjecucionResponseDto(boolean valor){
			this.valor=valor;
		}
		/**
		 * @return the codigo
		 */
		public boolean getValue() {
			return valor;
		}
		
	}
	
	/**
	 * @author gerlinorlandotorressaavedra
	 * Mensajes transaccional.
	 */
	public enum MensajesTransaccional{
		REGISTRO_EXITOSO("Registro Exitoso"), 
		MODIFICACION_EXITOSA("Modificacion Exitosa"), 
		ELIMINACION_EXITOSA("Eliminacion Exitosa");
		private String msn;
		private MensajesTransaccional(String msn){
			this.msn=msn;
		}
		/**
		 * @return the msn
		 */
		public String getMsn() {
			return msn;
		}
		
	}
	
}
