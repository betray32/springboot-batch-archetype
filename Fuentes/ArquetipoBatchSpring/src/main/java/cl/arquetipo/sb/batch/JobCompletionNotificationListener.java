package cl.arquetipo.sb.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cl.arquetipo.sb.dao.OracleProcedures;

/**
 * Listener ejecutado una vez termina el proceso
 * 
 * @author ccontrerasc
 *
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final String JOB_FINALIZADO_ERRORES = "Job Finalizado con Errores, JOB ID: ";

	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(JobCompletionNotificationListener.class);
	
	/**
	 * Conexion a BD
	 */
	@Autowired
	@Qualifier("transaccionesOracle")
	private OracleProcedures dao;

	/**
	 * Se ejecuta despues del job
	 */
	@Override
	public void afterJob(JobExecution jobExecution) {

		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Job Finalizado Exitosamente, JOB ID: " + jobExecution.getJobInstance().getJobName());
		} else

		if (jobExecution.getStatus() == BatchStatus.FAILED) {
			log.error(JOB_FINALIZADO_ERRORES + jobExecution.getJobInstance().getJobName());
			dao.insertaLogProceso(JOB_FINALIZADO_ERRORES, 605);
		}

	}

}
