
package cl.arquetipo.sb.generated.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Salida para el servicio
 * 
 * @author ccontrerasc
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dtoResponseCodigosEstadoHttp", "dtoResponseSetResultados" })
public class SalidaServicio {

	@JsonProperty("dtoResponseCodigosEstadoHttp")
	private DtoResponseCodigosEstadoHttp dtoResponseCodigosEstadoHttp;
	@JsonProperty("dtoResponseSetResultados")
	private DtoResponseSetResultados dtoResponseSetResultados;

	/** GET Y SET **/
	@JsonProperty("dtoResponseCodigosEstadoHttp")
	public DtoResponseCodigosEstadoHttp getDtoResponseCodigosEstadoHttp() {
		return dtoResponseCodigosEstadoHttp;
	}

	@JsonProperty("dtoResponseCodigosEstadoHttp")
	public void setDtoResponseCodigosEstadoHttp(DtoResponseCodigosEstadoHttp dtoResponseCodigosEstadoHttp) {
		this.dtoResponseCodigosEstadoHttp = dtoResponseCodigosEstadoHttp;
	}

	@JsonProperty("dtoResponseSetResultados")
	public DtoResponseSetResultados getDtoResponseSetResultados() {
		return dtoResponseSetResultados;
	}

	@JsonProperty("dtoResponseSetResultados")
	public void setDtoResponseSetResultados(DtoResponseSetResultados dtoResponseSetResultados) {
		this.dtoResponseSetResultados = dtoResponseSetResultados;
	}

	@Override
	public String toString() {
		return "SalidaServicio [dtoResponseCodigosEstadoHttp=" + dtoResponseCodigosEstadoHttp
				+ ", dtoResponseSetResultados=" + dtoResponseSetResultados + "]";
	}

}
