package cl.arquetipo.sb.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.arquetipo.sb.bean.ListadoMaestroNotificaciones;
import cl.arquetipo.sb.dao.OracleProcedures;

/**
 * Etapa de procesamiento
 * 
 * @author ccontrerasc
 *
 */
@Service
public class ProcessorNotification implements ItemProcessor<ListadoMaestroNotificaciones, ListadoMaestroNotificaciones> {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ProcessorNotification.class);

	/**
	 * Conexion a BD
	 */
	@Autowired
	@Qualifier("transaccionesOracle")
	private OracleProcedures dao;

	/**
	 * Procesamiento
	 */
	@Override
	public ListadoMaestroNotificaciones process(ListadoMaestroNotificaciones item) throws Exception {

		log.info("-----------------------------");
		log.info("[PROCESS] Executing...");
		log.info("Notificacion: " + item);

		// Realizar acciones para el procesador

		return item;

	}

}
