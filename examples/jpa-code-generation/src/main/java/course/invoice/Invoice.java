package course.invoice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@GeneratedValue(generator="invoice_seq")
	@SequenceGenerator(name="invoice_seq", schema="invoice", sequenceName="sequence_invoice", initialValue=100)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
	private Set<Item> items = new HashSet<Item>();
	
	private String comment;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.getInvoices().add(this);
	}

	public double total() {
		double total = 0.0;
		for (Item item : items) {
			total += item.getCost() * item.getQuantity();
		}
		return total;
	}
	
	public Set<Item> getItems() {
		return Collections.unmodifiableSet(items);
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public void removeAllItems() {
		items.clear();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Invoice other = (Invoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customer=" + customer + ", items=" + items + "]";
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
