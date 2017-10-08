package customer.service.client;

import java.net.URI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import customer.service.dtos.Contract;

public class StatusClient extends AbstractClient<String> {

	public StatusClient(String host, int port) {
		super(host, port);
	}

	public String sendContract(Contract contract) {
		URI uri = UriBuilder.fromPath(baseUri + "/status").build();
		return post(uri, Entity.entity(contract, MediaType.APPLICATION_JSON));
	}
}
