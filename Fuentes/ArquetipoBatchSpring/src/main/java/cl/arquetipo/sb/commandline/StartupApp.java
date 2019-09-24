package cl.arquetipo.sb.commandline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.arquetipo.sb.bean.ParametricaBean;
import cl.arquetipo.sb.dao.OracleProcedures;

/**
 * Permite inicializar el agendamiento desde la base de datos, se cargan los datos desde un SP
 * 
 * @author ccontrerasc
 *
 */
@Configuration
public class StartupApp {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(StartupApp.class);

	/**
	 * Conexion a BD
	 */
	@Autowired
	@Qualifier("transaccionesOracle")
	private OracleProcedures dao;

	/**
	 * Carga data desde SP
	 */
	@Bean
	public ParametricaBean obtenerParams() throws Exception {

		log.info("Cargando Rutinas del Proceso...");
		log.info("Cargando parametros desde BD...");

		ParametricaBean salida = dao.obtenerParametros();
		log.info("Salida: " + salida);

		if (salida != null)
			log.info("Parametros OK");
		else
			log.error("Error al cargar parametros desde la base de datos");

		return salida;

	}

}
