package cl.arquetipo.sb.batch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import cl.arquetipo.sb.bean.ListadoMaestroNotificaciones;
import cl.arquetipo.sb.dao.OracleProcedures;

/**
 * Se escribe y finaliza la ejecucion
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class WriterNotification implements ItemWriter<ListadoMaestroNotificaciones>, InitializingBean {

	/**
	 * Mensajes
	 */
	private static final String FINALIZANDO_ETAPA = "Finalizando Etapa Escritura de Notificaciones";
	private static final String ESCRIBIENDO_NOTIFICACION = "Escribiendo Notificacion: ";

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(WriterNotification.class);

	/**
	 * Mensajes
	 */
	private static final String CANTIDAD_PROCESAR = "Cantidad de registros a procesar : ";

	/**
	 * Conexion a BD
	 */
	@Autowired
	@Qualifier("transaccionesOracle")
	private OracleProcedures dao;

	/**
	 * Conector con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(entityManager, "An EntityManagerFactory is required");

	}

	/**
	 * Write
	 */
	@Override
	public void write(List<? extends ListadoMaestroNotificaciones> items) throws Exception {

		log.info("-----------------------------");
		log.info("[WRITER] Executing...");
		log.info("-----------------------------");

		log.info(CANTIDAD_PROCESAR + items.size());

		/*
		 * Recorrer lista
		 */
		items.stream().forEach(item -> {

			log.info(ESCRIBIENDO_NOTIFICACION + item);

			// Realizar acciones de escritura sobre los registros

		});

		log.info(FINALIZANDO_ETAPA);

	}

}
