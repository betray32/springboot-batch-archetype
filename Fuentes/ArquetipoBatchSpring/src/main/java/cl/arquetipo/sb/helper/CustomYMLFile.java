package cl.arquetipo.sb.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * CustomYMLFile
 * 
 * @author ccontrerasc
 *
 */
@Component
@ConfigurationProperties
public class CustomYMLFile {

	private String VersionBatch;
	private int Thread_Pool_Size;
	private int Block_Size;
	private String Process_Name;
	private String EsquemaBaseDatosLOG;

	/**
	 * Procedimientos
	 */
	private Procedures Procedures;
	private Endpoints Endpoints;

	/**
	 * Procedimientos
	 * 
	 * @author ccontrerasc
	 *
	 */
	public static class Procedures {

		private String ObtieneMaestro;
		private String ObtieneParametrosBatch;
		private String CambiarEstado;
		private String InsertarLog;

		/** GET Y SET **/
		public String getObtieneMaestro() {
			return ObtieneMaestro;
		}

		public void setObtieneMaestro(String obtieneMaestro) {
			ObtieneMaestro = obtieneMaestro;
		}

		public String getObtieneParametrosBatch() {
			return ObtieneParametrosBatch;
		}

		public void setObtieneParametrosBatch(String obtieneParametrosBatch) {
			ObtieneParametrosBatch = obtieneParametrosBatch;
		}

		public String getCambiarEstado() {
			return CambiarEstado;
		}

		public void setCambiarEstado(String cambiarEstado) {
			CambiarEstado = cambiarEstado;
		}

		public String getInsertarLog() {
			return InsertarLog;
		}

		public void setInsertarLog(String insertarLog) {
			InsertarLog = insertarLog;
		}

	}

	/**
	 * Endpoints
	 * 
	 * @author ccontrerasc
	 *
	 */
	public static class Endpoints {
		private String EnviarNotificacion;

		/** GET Y SET **/
		public String getEnviarNotificacion() {
			return EnviarNotificacion;
		}

		public void setEnviarNotificacion(String enviarNotificacion) {
			EnviarNotificacion = enviarNotificacion;
		}

	}

	/** GET Y SET **/
	public String getVersionBatch() {
		return VersionBatch;
	}

	public void setVersionBatch(String versionBatch) {
		VersionBatch = versionBatch;
	}

	public int getThread_Pool_Size() {
		return Thread_Pool_Size;
	}

	public void setThread_Pool_Size(int thread_Pool_Size) {
		Thread_Pool_Size = thread_Pool_Size;
	}

	public int getBlock_Size() {
		return Block_Size;
	}

	public void setBlock_Size(int block_Size) {
		Block_Size = block_Size;
	}

	public String getProcess_Name() {
		return Process_Name;
	}

	public void setProcess_Name(String process_Name) {
		Process_Name = process_Name;
	}

	public String getEsquemaBaseDatosLOG() {
		return EsquemaBaseDatosLOG;
	}

	public void setEsquemaBaseDatosLOG(String esquemaBaseDatosLOG) {
		EsquemaBaseDatosLOG = esquemaBaseDatosLOG;
	}

	public Procedures getProcedures() {
		return Procedures;
	}

	public void setProcedures(Procedures procedures) {
		Procedures = procedures;
	}

	public Endpoints getEndpoints() {
		return Endpoints;
	}

	public void setEndpoints(Endpoints endpoints) {
		Endpoints = endpoints;
	}

	@Override
	public String toString() {
		return "CustomYMLFile [VersionBatch=" + VersionBatch + ", Thread_Pool_Size=" + Thread_Pool_Size + ", Block_Size=" + Block_Size + ", Process_Name="
				+ Process_Name + ", EsquemaBaseDatosLOG=" + EsquemaBaseDatosLOG + ", Procedures=" + Procedures + ", Endpoints=" + Endpoints + "]";
	}

}
