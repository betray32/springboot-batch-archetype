package cl.arquetipo.sb.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import oracle.jdbc.OracleTypes;

/**
 * Setter para la data del usuario
 * 
 * @author ccontrerasc
 *
 */
public class ReaderMaestroInputMapper implements PreparedStatementSetter {

	/**
	 * Parametro de estado inicial
	 */
	private int queryState;

	/**
	 * Constructor
	 * 
	 * @param estadoInicialLecturaMaestro
	 */
	public ReaderMaestroInputMapper(int estadoInicialLecturaMaestro) {
		queryState = estadoInicialLecturaMaestro;
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {

		ps.setInt(1, queryState);
		((CallableStatement) ps).registerOutParameter(2, OracleTypes.CURSOR);

	}

}