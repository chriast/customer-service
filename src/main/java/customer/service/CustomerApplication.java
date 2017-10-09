package customer.service;

import customer.service.aggregator.ContractAggregator;
import customer.service.client.CustomerClient;
import customer.service.client.StatusClient;
import customer.service.health.ContractHealthCheck;
import customer.service.resources.ContractResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CustomerApplication extends Application<CustomerConfiguration> {
	
	public static void main(final String[] args) throws Exception {
		new CustomerApplication().run(args);
	}

	@Override
	public String getName() {
		return "Customer";
	}

	@Override
	public void initialize(final Bootstrap<CustomerConfiguration> bootstrap) {

	}

	@Override
	public void run(final CustomerConfiguration config, final Environment environment) {
		ContractAggregator service = new ContractAggregator(
				new CustomerClient(config.customerServiceHost(), config.customerServicePort()),
				new StatusClient(config.statusServiceHost(), config.statusServicePort()));
		final ContractResource resource = new ContractResource(service);
		final ContractHealthCheck healthCheck = new ContractHealthCheck();
		environment.healthChecks().register("", healthCheck);
		environment.jersey().register(resource);
	}

}
