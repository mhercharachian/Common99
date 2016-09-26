package dw317.lib;

public class Person {
	
	String firstName;
	String lastName;
	Address address;
	Name name;

	public Person(String firstName, String lastName) {
		this.firstName = new String(firstName);
		this.lastName = new String(lastName);
		this.address = null;
	}
	
	public Person(String firstName, String lastName, Address address) {
		this.firstName = new String(firstName);
		this.lastName = new String(lastName);
		this.address = new String(address);
	}

	public Name getName() {
		return new Name(this.firstName, this.lastName);
	}

	public void setName(String firstName, String lastName) {
		this.name = new Name(firstName, lastName);
	}

	public Address getAddress() {
		return new Address(this.address);
	}

	public void setAddress(Address address) {
		this.address = new Address(address);
	}
	
	@Override
	public String toString() {
	             
	    return name.toString() + "*" + 
	(address == null ? ""  : 
	       address.toString());                      
	}
}
