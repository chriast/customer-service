package customer.service.dtos;

public class Customer {
	private long customerId;
	private String customerName;

	public Customer(long customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

}
