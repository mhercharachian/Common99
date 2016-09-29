package group99.hotel.business;

import java.util.Optional;
import dw317.lib.Email;
import dw317.lib.Name;
import dw317.lib.creditcard.CreditCard;
import group99.hotel.business.interfaces.Customer;

/**
 * 
 * @author Matt, Mher, Tahar
 * 
 * This program implements the Customer interface and represents a single Dawson Customer
 *
 */

public class DawsonCustomer implements Customer {

	private static final long serialVersionUID = 42031768871L;
	Name name;
	Email email;
	Optional<CreditCard> card = null;

	/**
	 * 
	 * Single 3-parameter constructor
	 * 
	 * @param name: the Name of the customer
	 * @param email: the Email of the customer
	 * @param card: the Credit Card of the customer, if available
	 */
	
	public DawsonCustomer(Name name, Email email, Optional<CreditCard> card) {
		this.name = new Name(name.getFirstName(), name.getLastName());
		this.email = email;
		setCreditCard(card);
	}

	/**
	 * 
	 * Overriden compareTo method
	 * Customers are ordered based on their email address
	 * 
	 */
	
	@Override
	public int compareTo(Customer o) {
		return email.compareTo(o.getEmail());
	}
	
	/**
	 * 
	 * Overridden getName method
	 * Getter for the Customer's Name
	 * 
	 */

	@Override
	public Name getName() {
		return new Name(this.name.getFirstName(), this.name.getLastName());
	}
	
	/**
	 * 
	 * Overridden getEmail method
	 * Getter for the Customer's Email
	 * 
	 */

	@Override
	public Email getEmail() {
		return this.email;
	}
	
	/**
	 * 
	 * Overridden getCreditCard method
	 * Getter for the Customer's Credit Card, if available
	 * 
	 */

	@Override
	public Optional<CreditCard> getCreditCard() {
		return this.card;
	}
	
	/**
	 * 
	 * Overridden setCreditCard method
	 * Setter for the Customer's Credit Card
	 * 
	 */

	@Override
	public void setCreditCard(Optional<CreditCard> card) {
		this.card = card;

	}

	/**
	 * 
	 * Overridden toString method
	 * 
	 * @return the email, first name, last name, credit card type and number (separated by an asterisk) if Credit Card is NOT null
	 * @return the email, first name, last name only (separated by an asterisk) if Credit Card IS null
	 * 
	 */
	
	@Override
	public String toString() {
		return this.email + "*" + this.name.getFirstName() + "*" + this.name.getLastName() + "*"
				+ (this.card == null ? "*" : this.card.map(CreditCard::toString).orElse(""));
	}

	/**
	 * 
	 * Overridden hashCode method to final
	 * 
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	/**
	 * 
	 * Overridden equals method to final
	 * 
	 */

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DawsonCustomer))
			return false;
		DawsonCustomer other = (DawsonCustomer) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
