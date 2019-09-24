package cl.arquetipo.sb.batch;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.StoredProcedureItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import cl.arquetipo.sb.bean.ListadoMaestroNotificaciones;
import cl.arquetipo.sb.bean.ParametricaBean;
import cl.arquetipo.sb.dao.OracleProcedures;
import cl.arquetipo.sb.dao.ReaderMaestroInputMapper;
import cl.arquetipo.sb.dao.ReaderMaestroOutputMapper;
import cl.arquetipo.sb.helper.CustomYMLFile;
import oracle.jdbc.OracleTypes;

/**
 * Read data from oracle stored procedure - fisa
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class ReaderNotification {

	/**
	 * Mensajes
	 */
	private static final String ERROR_READER_BLOQUE = "No se ha podido leer el bloque a procesar, Error > ";
	private static final String BLOQUE_DE_LECTURA_OK = "Bloque de lectura obtenido exitosamente";

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ReaderNotification.class);

	@Autowired
	private CustomYMLFile properties;

	@Autowired
	private DataSource dataSource;

	@Autowired
	@Qualifier("obtenerParams")
	private ParametricaBean bean;

	@Autowired
	@Qualifier("transaccionesOracle")
	private OracleProcedures dao;

	/**
	 * Lee los registros que contengan el estado indicado
	 * 
	 * @return
	 */
	public ItemStreamReader<ListadoMaestroNotificaciones> read() {

		try {

			log.info("[READ] Executing...");

			StoredProcedureItemReader<ListadoMaestroNotificaciones> reader = new StoredProcedureItemReader<ListadoMaestroNotificaciones>();

			String logMetadataReader = 
					"Detalle del datasource conectado" 
					+ " - Schema: "
					+ dataSource.getConnection().getSchema() 
					+ " - Catalog: " + dataSource.getConnection().getCatalog()
					+ " - NetworkTimeOut: " 
					+ dataSource.getConnection().getNetworkTimeout()
					+ " - TransactionIsolation: " 
					+ dataSource.getConnection().getTransactionIsolation();

			log.info(logMetadataReader);

			reader.setDataSource(dataSource);

			// Procedure
			reader.setProcedureName(properties.getProcedures().getObtieneMaestro());
			SqlParameter[] parameters = 
				{ 
					new SqlParameter("P_ESTADO", OracleTypes.NUMBER),
					new SqlParameter("OUT_ESTADO", OracleTypes.CURSOR) 
				};

			/*
			 * Le seteo al reader los parametros ya definidos. Ademas le digo que Mapper
			 * necesito para procesarlo como un objeto y le indico en que posicion esta el
			 * cursor
			 */
			reader.setParameters(parameters);
			reader.setRowMapper(new ReaderMaestroOutputMapper());
			reader.setRefCursorPosition(2);

			// Setear parametros
			int estadoInicialNotificaciones = Integer.parseInt(bean.getEstadoInicialLectura());
			String logEstadoInicial = "En el parametro de entrada, posicion 1: [P_ESTADO] se asignara el campo: " + estadoInicialNotificaciones;
			log.info(logEstadoInicial);

			reader.setPreparedStatementSetter(new ReaderMaestroInputMapper(estadoInicialNotificaciones));

			/*
			 * Permite ejecutar el StoredProcedureItemReader
			 */
			log.info("Ejecutando Reader...");
			reader.afterPropertiesSet();
			log.info("SQL EJECUTADO: " + reader.getSql());

			log.info(BLOQUE_DE_LECTURA_OK);

			return reader;

		} catch (Exception e) {
			dao.insertaLogProceso(ERROR_READER_BLOQUE + e.getMessage(), 101);
			log.error(ERROR_READER_BLOQUE);
		}

		return null;

	}

}
