package customer.service.resources;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import customer.service.aggregator.ContractAggregator;
import customer.service.client.CustomerClient;
import customer.service.client.StatusClient;
import customer.service.dtos.Contract;

public class ContractResourceTest {
	private static final String CUSTOMER_NAME = "Ida";
	private static final long CUSTOMER_ID = 1l;
	private static final long CONTRACT_ID = 2l;
	private static final String DELIVERY_STATUS = "delivered";
	private static final String CONTRACT_STATUS = "OK";
	
	private CustomerClient customerClient = Mockito.mock(CustomerClient.class);
	private StatusClient statusClient = Mockito.mock(StatusClient.class);
	private ContractAggregator contractAggregator = new ContractAggregator(customerClient, statusClient);
	private ContractResource contractResource = new ContractResource(contractAggregator);
	private Contract contract = new Contract(CUSTOMER_ID, CUSTOMER_NAME, CONTRACT_ID);
	
	@Before
	public void setup(){
		Mockito.when(customerClient.getCustomerId(CUSTOMER_NAME)).thenReturn(CUSTOMER_ID);
		Mockito.when(customerClient.getContractId(CUSTOMER_ID)).thenReturn(CONTRACT_ID);
		Mockito.when(statusClient.sendContract(contract)).thenReturn(DELIVERY_STATUS);
		Mockito.when(customerClient.updateContractStatus(DELIVERY_STATUS)).thenReturn(CONTRACT_STATUS);
	}
	
	@Test
	public void testResource() {
		Contract testContract = contractResource.createContract(CUSTOMER_NAME);
		assertTrue(testContract.getContractId() == CONTRACT_ID);
		assertTrue(testContract.getCustomerId() == CUSTOMER_ID);
		assertTrue(testContract.getCustomerName().equals(CUSTOMER_NAME));
		assertTrue(testContract.getStatus().equals(CONTRACT_STATUS));
	}
	
}
