package cl.arquetipo.sb.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import cl.arquetipo.sb.bean.ListadoMaestroNotificaciones;
import cl.arquetipo.sb.generated.client.InputServicio;
import cl.arquetipo.sb.generated.client.SalidaServicio;
import cl.arquetipo.sb.helper.Constantes;
import cl.arquetipo.sb.helper.CustomYMLFile;

/**
 * Ejemplo de cliente y servicio Rest
 * 
 * @author ccontrerasc
 *
 */
@Service
public class RestClient {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(RestClient.class);

	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile properties;

	/**
	 * Notificaciones
	 * 
	 * @param notificacion
	 * @return
	 */
	@Retryable(value = { Exception.class }, maxAttempts = 2, backoff = @Backoff(delay = 1000))
	public SalidaServicio enviarNotificacion(ListadoMaestroNotificaciones notificacion) throws Exception {

		SalidaServicio salida = null;
		String endpoint = properties.getEndpoints().getEnviarNotificacion();

		/**********************
		 * LLAMADA REST
		 */
		String inicioEjecucionServicio = "Se creara la llamada al servicio URL [" + endpoint + "] ";
		log.info(inicioEjecucionServicio);

		// Armar request
		ObjectMapper mapper = new ObjectMapper();
		InputServicio request = mapper.readValue(notificacion.getCtr_request(), InputServicio.class);
		log.info("[Request] " + new Gson().toJson(request));

		log.info("Ejecutando servicio...");
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add(Constantes.HEADER_TOKEN_KEY, Constantes.HEADER_TOKEN_VALUE);

		HttpEntity<InputServicio> httpRequest = new HttpEntity<>(request, headers);
		salida = rest.postForObject(endpoint, httpRequest, SalidaServicio.class);
		log.info("Servicio invocado OK...");

		log.info("[Response]" + new Gson().toJson(salida));

		return salida;

	}

}
