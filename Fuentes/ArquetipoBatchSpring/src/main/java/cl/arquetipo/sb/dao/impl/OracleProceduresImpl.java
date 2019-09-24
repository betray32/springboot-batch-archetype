package cl.arquetipo.sb.dao.impl;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cl.arquetipo.sb.bean.ParametricaBean;
import cl.arquetipo.sb.dao.OracleProcedures;
import cl.arquetipo.sb.helper.CustomYMLFile;
import cl.arquetipo.sb.helper.Utiles;

/**
 * Transacciones oracle para el proceso batch
 * 
 * @author ccontrerasc
 *
 */
@Repository
@Qualifier("transaccionesOracle")
public class OracleProceduresImpl implements OracleProcedures {

	/**
	 * Mensajes
	 */
	private static final String ERROR_ESCRIBIR_NOTIFICACION = "Error al momento de escribir la actualizacion de estado de la notificacion, ERROR > ";

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(OracleProceduresImpl.class);

	/**
	 * Conector con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/************************************
	 * DI
	 */
	@Autowired
	private CustomYMLFile properties;

	/**
	 * Ambiente - Desde archivo application.properties
	 */
	@Autowired
	private org.springframework.core.env.Environment env;
	
	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile yml;
	/***********************************/

	/**
	 * Pagar en FISA
	 * 
	 * @param registro
	 * @return
	 */
	@Override
	public ParametricaBean obtenerParametros() {

		log.info("DAO: " + "[Obteniendo parametros para la ejecucion del Batch]");
		ParametricaBean res = null;
		try {

			String procedure = properties.getProcedures().getObtieneParametrosBatch();
			log.info("Iniciando llamada al SP: " + procedure);
			StoredProcedureQuery query = entityManager
					/*
					 * Procedimiento
					 */
					.createStoredProcedureQuery(procedure)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(1, Integer.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(2, Long.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(3, Long.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

			log.info("Ejecutando SP");
			query.execute();
			log.info("Procedimiento ejecutado OK");

			res = new ParametricaBean();
			res.setEnabled((Integer) query.getOutputParameterValue(1));
			res.setFixedRate((Long) query.getOutputParameterValue(2));
			res.setFixedDelay((Long) query.getOutputParameterValue(3));
			res.setEstadoInicialLectura((String) query.getOutputParameterValue(4));
	
			return res;

		} catch (Exception e) {
			log.error("Error en la ejecucion, ERROR > ", e);
		}

		log.info("DAO - Finalizacion");
		return res;

	}
	
	/**
	 * Permite cambiar el estado de la notificacion dependiendo del envio de la misma mediante el EAP
	 * 
	 * @param v_ctr_id
	 * @param v_ctr_id_proceso
	 * @param v_ctr_estado
	 * @return
	 */
	@Override
	public int cambiarEstadoNotificacion(String v_ctr_id, String v_ctr_id_proceso, String v_ctr_estado) {
		
		log.info("DAO: " + "[Cambiar Estado Notificacion]");
		int salida = -1;
		
		try {

			String procedure = properties.getProcedures().getCambiarEstado();
			log.info("Iniciando llamada al SP: " + procedure);
			StoredProcedureQuery query = entityManager
					/*
					 * Procedimiento
					 */
					.createStoredProcedureQuery(procedure)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT)
					// Parametros
					.setParameter(1, v_ctr_id)
					.setParameter(2, v_ctr_id_proceso)
					.setParameter(3, v_ctr_estado);

			
			log.info("Ejecutando SP");
			query.execute();
			log.info("Procedimiento ejecutado OK");

			salida = (Integer) query.getOutputParameterValue(4);

		} catch (Exception e) {
			log.error(ERROR_ESCRIBIR_NOTIFICACION, e);
			insertaLogProceso(ERROR_ESCRIBIR_NOTIFICACION + e.getMessage(), 401);
		}

		log.info("DAO - Finalizacion");
		return salida;
		
	}
	
	
	/**
	 * Permite insertar el log del proceso
	 * @param v_ctr_id
	 * @param v_ctr_id_proceso
	 * @param v_ctr_estado
	 * @return
	 */
	@Override
	public int insertaLogProceso(String traza, int status) {
		
		int salida = -1;
		String procedure = properties.getProcedures().getInsertarLog();
		
		try {
	
			StoredProcedureQuery query = entityManager
					/*
					 * Procedimiento
					 */
					.createStoredProcedureQuery(procedure)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN)
					.registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(5, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(6, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(7, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(8, Integer.class, ParameterMode.OUT)
					// Parametros de entrada
					.setParameter(1, Utiles.getDateTime())
					.setParameter(2, traza)
					.setParameter(3, status)
					.setParameter(4, yml.getProcess_Name())
					.setParameter(5, env.getProperty("spring.datasource.username"))
					.setParameter(6, Utiles.obtenerIP())
					.setParameter(7, yml.getEsquemaBaseDatosLOG());
			
			query.execute();

		} catch (Exception e) {
			log.error("Error en la insercion de log, SP : " +procedure+ ", ERROR > ", e);
		}

		return salida;
		
	}

}
