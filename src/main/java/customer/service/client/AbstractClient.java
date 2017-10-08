package customer.service.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AbstractClient<T> {
	final Client client = ClientBuilder.newClient();
	private static String BASE_PATH = "http://%s:%d/";
	public String baseUri;
	private Class<T> clazz;

	public AbstractClient(String host, int port) {
		baseUri = String.format(BASE_PATH, host, port);
	}

	public T get(URI uri) {
		Response resp = client.target(uri).request(MediaType.APPLICATION_JSON).get();
		return resp.readEntity(clazz);
	}

	public T post(URI uri, Entity<?> entity) {
		Response resp = client.target(uri).request(MediaType.APPLICATION_JSON).post(entity);
		return resp.readEntity(clazz);
	}
}
