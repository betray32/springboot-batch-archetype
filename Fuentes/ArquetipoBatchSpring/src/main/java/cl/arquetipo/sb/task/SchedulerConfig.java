package cl.arquetipo.sb.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import cl.arquetipo.sb.commandline.StartupApp;
import cl.arquetipo.sb.helper.CustomYMLFile;

/**
 * SchedulerConfig
 * 
 * @author ccontrerasc
 *
 */
@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
	
	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(StartupApp.class);

	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile yml;

	/**
	 * Configurar las hebras del agendador
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

		threadPoolTaskScheduler.setPoolSize(yml.getThread_Pool_Size());
		threadPoolTaskScheduler.setThreadNamePrefix("SB_scheduled-task-pool-notifications");
		threadPoolTaskScheduler.initialize();

		scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
		log.info("Scheduler Configurado OK");
	}

}
