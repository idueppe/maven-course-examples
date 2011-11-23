package course.invoice.dao;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import course.invoice.Customer;

public class CustomerDao extends JpaDaoSupport {
	
	public Customer findCustomer(Long id)
	{
		return getJpaTemplate().find(Customer.class, id);
	}

	public void createNewCustomer(String email) {
		Customer customer = new Customer();
		customer.setEmail(email);
		getJpaTemplate().persist(customer);
	}

}
