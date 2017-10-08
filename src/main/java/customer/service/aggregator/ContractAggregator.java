package customer.service.aggregator;

import customer.service.client.CustomerClient;
import customer.service.client.StatusClient;
import customer.service.dtos.Contract;

public class ContractAggregator {
	private final CustomerClient customerClient;
	private final StatusClient statusClient;

	public ContractAggregator(CustomerClient customerClient, StatusClient statusClient) {
		this.customerClient = customerClient;
		this.statusClient = statusClient;
	}

	public Contract createContract(String customerName) {
		long customerId = customerClient.getCustomerId(customerName);
		long contractId = customerClient.getContractId(customerId);
		Contract contract = new Contract(customerId,customerName,contractId);
		String deliveryStatus = statusClient.sendContract(contract);
		contract.setStatus(customerClient.updateContractStatus(deliveryStatus));
		return contract;
	}

}
