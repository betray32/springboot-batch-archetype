
package cl.arquetipo.sb.generated.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codigo", "mensaje", "descripcion" })
public class DtoResponseCodigosEstadoHttp {

	@JsonProperty("codigo")
	private Integer codigo;
	@JsonProperty("mensaje")
	private String mensaje;
	@JsonProperty("descripcion")
	private String descripcion;

	@JsonProperty("codigo")
	public Integer getCodigo() {
		return codigo;
	}

	@JsonProperty("codigo")
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@JsonProperty("mensaje")
	public String getMensaje() {
		return mensaje;
	}

	@JsonProperty("mensaje")
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@JsonProperty("descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	@JsonProperty("descripcion")
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "DtoResponseCodigosEstadoHttp [codigo=" + codigo + ", mensaje=" + mensaje + ", descripcion=" + descripcion + "]";
	}

}
