package customer.service.health;

import com.codahale.metrics.health.HealthCheck;

public class ContractHealthCheck extends HealthCheck{
	
	
	public ContractHealthCheck() {
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}
