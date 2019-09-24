
package cl.arquetipo.sb.generated.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Entrada para el servicio
 * 
 * @author ccontrerasc
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dtoRequestSetParametros", "dtoRequestDatosContextoHttp" })
public class InputServicio {

	@JsonProperty("dtoRequestSetParametros")
	private DtoRequestSetParametros dtoRequestSetParametros;
	@JsonProperty("dtoRequestDatosContextoHttp")
	private DtoRequestDatosContextoHttp dtoRequestDatosContextoHttp;

	/** GET Y SET **/
	@JsonProperty("dtoRequestSetParametros")
	public DtoRequestSetParametros getDtoRequestSetParametros() {
		return dtoRequestSetParametros;
	}

	@JsonProperty("dtoRequestSetParametros")
	public void setDtoRequestSetParametros(DtoRequestSetParametros dtoRequestSetParametros) {
		this.dtoRequestSetParametros = dtoRequestSetParametros;
	}

	@JsonProperty("dtoRequestDatosContextoHttp")
	public DtoRequestDatosContextoHttp getDtoRequestDatosContextoHttp() {
		return dtoRequestDatosContextoHttp;
	}

	@JsonProperty("dtoRequestDatosContextoHttp")
	public void setDtoRequestDatosContextoHttp(DtoRequestDatosContextoHttp dtoRequestDatosContextoHttp) {
		this.dtoRequestDatosContextoHttp = dtoRequestDatosContextoHttp;
	}

}
