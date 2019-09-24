package cl.arquetipo.sb.dao;

import cl.arquetipo.sb.bean.ParametricaBean;

/**
 * Transacciones oracle para el proceso batch
 * 
 * @author ccontrerasc
 *
 */
public interface OracleProcedures {

	/**
	 * Pagar en FISA
	 * 
	 * @param registro
	 * @return
	 */
	public ParametricaBean obtenerParametros();

	/**
	 * Permite cambiar el estado de la notificacion dependiendo del envio de la misma mediante el EAP
	 * 
	 * @param v_ctr_id
	 * @param v_ctr_id_proceso
	 * @param v_ctr_estado
	 * @return
	 */
	public int cambiarEstadoNotificacion(String v_ctr_id, String v_ctr_id_proceso, String v_ctr_estado);

	/**
	 * Permite insertar el log del proceso
	 * 
	 * @param v_ctr_id
	 * @param v_ctr_id_proceso
	 * @param v_ctr_estado
	 * @return
	 */
	public int insertaLogProceso(String traza, int status);

}
