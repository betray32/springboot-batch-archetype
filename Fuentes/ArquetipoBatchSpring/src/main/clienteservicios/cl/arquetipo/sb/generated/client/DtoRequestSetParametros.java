
package cl.arquetipo.sb.generated.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "rut", "nombres", "appPaterno", "appMaterno", "correoElectronico", "codProducto", "glosaProducto",
		"nroCuenta", "numeroTarjeta", "tipoTransaccion", "monto", "comercio", "fecha", "hora",
		"nombreApellidoOriginador", "nombreApellidoDestinario" })
public class DtoRequestSetParametros {

	@JsonProperty("rut")
	private String rut;
	@JsonProperty("nombres")
	private String nombres;
	@JsonProperty("appPaterno")
	private String appPaterno;
	@JsonProperty("appMaterno")
	private String appMaterno;
	@JsonProperty("correoElectronico")
	private String correoElectronico;
	@JsonProperty("codProducto")
	private Integer codProducto;
	@JsonProperty("glosaProducto")
	private String glosaProducto;
	@JsonProperty("nroCuenta")
	private String nroCuenta;
	@JsonProperty("numeroTarjeta")
	private String numeroTarjeta;
	@JsonProperty("tipoTransaccion")
	private String tipoTransaccion;
	@JsonProperty("monto")
	private Integer monto;
	@JsonProperty("comercio")
	private String comercio;
	@JsonProperty("fecha")
	private String fecha;
	@JsonProperty("hora")
	private String hora;
	@JsonProperty("nombreApellidoOriginador")
	private String nombreApellidoOriginador;
	@JsonProperty("nombreApellidoDestinario")
	private String nombreApellidoDestinario;

	@JsonProperty("rut")
	public String getRut() {
		return rut;
	}

	@JsonProperty("rut")
	public void setRut(String rut) {
		this.rut = rut;
	}

	@JsonProperty("nombres")
	public String getNombres() {
		return nombres;
	}

	@JsonProperty("nombres")
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@JsonProperty("appPaterno")
	public String getAppPaterno() {
		return appPaterno;
	}

	@JsonProperty("appPaterno")
	public void setAppPaterno(String appPaterno) {
		this.appPaterno = appPaterno;
	}

	@JsonProperty("appMaterno")
	public String getAppMaterno() {
		return appMaterno;
	}

	@JsonProperty("appMaterno")
	public void setAppMaterno(String appMaterno) {
		this.appMaterno = appMaterno;
	}

	@JsonProperty("correoElectronico")
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	@JsonProperty("correoElectronico")
	public void setCorreoElectronico(String correoElectronico) {

		if (correoElectronico != null) {
			correoElectronico = correoElectronico.trim();
			this.correoElectronico = correoElectronico;

		} else {
			this.correoElectronico = correoElectronico;
		}

	}

	@JsonProperty("codProducto")
	public Integer getCodProducto() {
		return codProducto;
	}

	@JsonProperty("codProducto")
	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	@JsonProperty("glosaProducto")
	public String getGlosaProducto() {
		return glosaProducto;
	}

	@JsonProperty("glosaProducto")
	public void setGlosaProducto(String glosaProducto) {
		this.glosaProducto = glosaProducto;
	}

	@JsonProperty("nroCuenta")
	public String getNroCuenta() {
		return nroCuenta;
	}

	@JsonProperty("nroCuenta")
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	@JsonProperty("numeroTarjeta")
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	@JsonProperty("numeroTarjeta")
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	@JsonProperty("tipoTransaccion")
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	@JsonProperty("tipoTransaccion")
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	@JsonProperty("monto")
	public Integer getMonto() {
		return monto;
	}

	@JsonProperty("monto")
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	@JsonProperty("comercio")
	public String getComercio() {
		return comercio;
	}

	@JsonProperty("comercio")
	public void setComercio(String comercio) {
		this.comercio = comercio;
	}

	@JsonProperty("fecha")
	public String getFecha() {
		return fecha;
	}

	@JsonProperty("fecha")
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@JsonProperty("hora")
	public String getHora() {
		return hora;
	}

	@JsonProperty("hora")
	public void setHora(String hora) {
		this.hora = hora;
	}

	@JsonProperty("nombreApellidoOriginador")
	public String getNombreApellidoOriginador() {
		return nombreApellidoOriginador;
	}

	@JsonProperty("nombreApellidoOriginador")
	public void setNombreApellidoOriginador(String nombreApellidoOriginador) {
		this.nombreApellidoOriginador = nombreApellidoOriginador;
	}

	@JsonProperty("nombreApellidoDestinario")
	public String getNombreApellidoDestinario() {
		return nombreApellidoDestinario;
	}

	@JsonProperty("nombreApellidoDestinario")
	public void setNombreApellidoDestinario(String nombreApellidoDestinario) {
		this.nombreApellidoDestinario = nombreApellidoDestinario;
	}

}
