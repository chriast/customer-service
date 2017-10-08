package customer.service.client;

import java.net.URI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.UriBuilder;

public class CustomerClient extends AbstractClient<String> {
	public CustomerClient(String host, int port) {
		super(host, port);
	}

	public Long getCustomerId(String customerName) {
		URI uri = UriBuilder.fromPath(baseUri + "/customer").path(customerName).build();
		return Long.parseLong(get(uri));
	}

	public Long getContractId(long customerId) {
		URI uri = UriBuilder.fromPath(baseUri + "/contract").path(String.valueOf(customerId)).build();
		return Long.parseLong(get(uri));
	}

	public String updateContractStatus(String deliveryStatus) {
		URI uri = UriBuilder.fromPath(baseUri + "/status").build();
		return post(uri, Entity.entity(deliveryStatus, javax.ws.rs.core.MediaType.APPLICATION_JSON));
	}

}
