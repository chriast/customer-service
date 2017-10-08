package customer.service.dtos;

public class Contract {
	private long customerId;
	private String customerName;
	private long contractId;
	@SuppressWarnings("unused")
	private String status;

	public Contract(long customerId, String customerName, long contractId) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.contractId = contractId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public long getContractId() {
		return contractId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contractId ^ (contractId >>> 32));
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		if (contractId != other.contractId)
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	

}
