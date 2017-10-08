package customer.service;

import io.dropwizard.Configuration;

public class CustomerConfiguration extends Configuration {
	public String customerServiceHost() {
		return "localhost";
	}

	public String statusServiceHost() {
		return "localhost";
	}

	public int customerServicePort() {
		return 8080;
	}

	public int statusServicePort() {
		return 8080;
	}
}
