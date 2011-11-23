package course.invoice.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import course.invoice.dao.CustomerDao;

public class CustomerRegistrationService {

	private CustomerDao customerDAO;

	public void withoutCustomer(String email) throws Exception {
		registerCustomer(email);
	}

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = Exception.class)
	public void registerCustomer(String email) throws Exception {
		customerDAO.createNewCustomer(email);
		throw new Exception("rollback now!");
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDAO = customerDao;
	}

}
