package cl.arquetipo.sb.bean;

/**
 * Bean de la tabla del sp
 * 
 * @author ccontrerasc
 *
 */
public class ParametricaBean {

	private long fixedRate;
	private long fixedDelay;
	private int enabled;
	private String estadoInicialLectura;

	/** GET Y SET **/
	public long getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(long fixedRate) {
		this.fixedRate = fixedRate;
	}

	public long getFixedDelay() {
		return fixedDelay;
	}

	public void setFixedDelay(long fixedDelay) {
		this.fixedDelay = fixedDelay;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getEstadoInicialLectura() {
		return estadoInicialLectura;
	}

	public void setEstadoInicialLectura(String estadoInicialLectura) {
		this.estadoInicialLectura = estadoInicialLectura;
	}

	@Override
	public String toString() {
		return "ParametricaBean [fixedRate=" + fixedRate + ", fixedDelay=" + fixedDelay + ", enabled=" + enabled + ", estadoInicialLectura="
				+ estadoInicialLectura + "]";
	}

}
