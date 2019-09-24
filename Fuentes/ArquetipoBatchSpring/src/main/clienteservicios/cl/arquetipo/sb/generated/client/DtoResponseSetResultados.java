
package cl.arquetipo.sb.generated.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codigoError", "mensajeError" })
public class DtoResponseSetResultados {

	@JsonProperty("codigoError")
	private Integer codigoError;
	@JsonProperty("mensajeError")
	private String mensajeError;

	@JsonProperty("codigoError")
	public Integer getCodigoError() {
		return codigoError;
	}

	@JsonProperty("codigoError")
	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	@JsonProperty("mensajeError")
	public String getMensajeError() {
		return mensajeError;
	}

	@JsonProperty("mensajeError")
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	@Override
	public String toString() {
		return "DtoResponseSetResultados [codigoError=" + codigoError + ", mensajeError=" + mensajeError + "]";
	}

}
