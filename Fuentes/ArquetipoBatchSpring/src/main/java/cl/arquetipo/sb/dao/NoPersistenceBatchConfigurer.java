package cl.arquetipo.sb.dao;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.stereotype.Component;

/**
 * No persistir data en tablas de metadata
 * 
 * @author ccontrerasc
 *
 */
@Component
public class NoPersistenceBatchConfigurer extends DefaultBatchConfigurer {

	/**
	 * setDataSource
	 */
	@Override
	public void setDataSource(DataSource dataSource) {

	}

}