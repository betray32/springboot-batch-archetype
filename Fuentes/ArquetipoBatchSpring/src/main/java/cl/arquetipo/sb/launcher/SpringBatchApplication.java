package cl.arquetipo.sb.launcher;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Carga inicial
 * 
 * @author ccontrerasc
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableRetry
@ComponentScan
(
	{ 
		"cl.arquetipo.sb.batch",
		"cl.arquetipo.sb.bean",
		"cl.arquetipo.sb.commandline",
		"cl.arquetipo.sb.dao",
		"cl.arquetipo.sb.helper",
		"cl.arquetipo.sb.launcher",
		"cl.arquetipo.sb.rest",
		"cl.arquetipo.sb.task"
	}
)
public class SpringBatchApplication {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(SpringBatchApplication.class);

	/**
	 * MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		log.info("Inicializando - SpringBatchApplication");
		log.info("> Started at: " + date);

		SpringApplication.run(SpringBatchApplication.class, args);
	}

}
