
package cl.arquetipo.sb.generated.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ipCliente", "codigoCanal", "nombreCanal", "codigoAplicacion", "nombreAplicacion", "empresaAplicacion" })
public class DtoRequestDatosContextoHttp {

	@JsonProperty("ipCliente")
	private String ipCliente;
	@JsonProperty("codigoCanal")
	private String codigoCanal;
	@JsonProperty("nombreCanal")
	private String nombreCanal;
	@JsonProperty("codigoAplicacion")
	private String codigoAplicacion;
	@JsonProperty("nombreAplicacion")
	private String nombreAplicacion;
	@JsonProperty("empresaAplicacion")
	private String empresaAplicacion;

	@JsonProperty("ipCliente")
	public String getIpCliente() {
		return ipCliente;
	}

	@JsonProperty("ipCliente")
	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	@JsonProperty("codigoCanal")
	public String getCodigoCanal() {
		return codigoCanal;
	}

	@JsonProperty("codigoCanal")
	public void setCodigoCanal(String codigoCanal) {
		this.codigoCanal = codigoCanal;
	}

	@JsonProperty("nombreCanal")
	public String getNombreCanal() {
		return nombreCanal;
	}

	@JsonProperty("nombreCanal")
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}

	@JsonProperty("codigoAplicacion")
	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}

	@JsonProperty("codigoAplicacion")
	public void setCodigoAplicacion(String codigoAplicacion) {
		this.codigoAplicacion = codigoAplicacion;
	}

	@JsonProperty("nombreAplicacion")
	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	@JsonProperty("nombreAplicacion")
	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	@JsonProperty("empresaAplicacion")
	public String getEmpresaAplicacion() {
		return empresaAplicacion;
	}

	@JsonProperty("empresaAplicacion")
	public void setEmpresaAplicacion(String empresaAplicacion) {
		this.empresaAplicacion = empresaAplicacion;
	}

}
