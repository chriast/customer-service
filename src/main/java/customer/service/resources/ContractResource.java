package customer.service.resources;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import customer.service.aggregator.ContractAggregator;
import customer.service.dtos.Contract;

@Resource
@Path("/contract")
@Produces(MediaType.APPLICATION_JSON)
public class ContractResource {
	private ContractAggregator contractAggregator;

	public ContractResource(ContractAggregator contractAggregator) {
		this.contractAggregator = contractAggregator;
	}

	@POST
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{customerName}")
	public Contract createContract(@PathParam("customerName") String customerName) {
		return contractAggregator.createContract(customerName);
	}
}
