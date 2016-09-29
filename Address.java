/**
* Defines an Address type.
*/
package dw317.lib;

/**
 * @author Type your name
 */
public class Address {
	private String city = "";
	private String civicNumber = "";
	private String province = "";
	private String code = "";
	private String streetName = "";

	public Address() {
	}

	public Address(String civicNumber, String streetName, String city) {
		this.civicNumber = validateExistence("civic number", new String(civicNumber));
		this.streetName = validateExistence("street name", new String(streetName));
		this.city = validateExistence("city", new String(city));
	}

	public Address(Address address) {
		this.civicNumber = address.getCivicNumber();
		this.streetName = address.getStreetName();
		this.city = address.getCity();
	}

	public String getAddress() {
		String address = civicNumber + " " + streetName + "\n" + city;
		address += (province.equals("") ? "" : (", " + province)) + (code.equals("") ? "" : ("\n" + code));

		return address;

	}

	public String getCity() {
		return new String(city);
	}

	public void setCity(String city) {
		this.city = validateExistence("city", city);
	}

	public String getCivicNumber() {
		return new String(civicNumber);
	}

	public void setCivicNumber(String civicNumber) {
		this.civicNumber = validateExistence("civic number", civicNumber);
	}

	public String getProvince() {
		return new String(province);
	}

	public void setProvince(String province) {
		this.province = new String(province);
	}

	public String getCode() {
		return new String(code);
	}

	public void setCode(String code) {
		this.code = new String(code);
	}

	public String getStreetName() {
		return new String(streetName);
	}

	public void setStreetName(String streetName) {
		this.streetName = validateExistence("street name", new String(streetName));
	}

	public String toString() {
		return (civicNumber + "*" + streetName + "*" + city + "*" + province + "*" + code);
	}

	private String validateExistence(String fieldName, String fieldValue) {

		if (fieldValue == null) {
			throw new IllegalArgumentException(
					"Address Error - " + fieldName + " must exist. Invalid value = " + fieldValue);
		}
		String trimmedString = fieldValue.trim();
		if (trimmedString.isEmpty()) {

			throw new IllegalArgumentException(
					"Address Error - " + fieldName + " must exist. Invalid value = " + fieldValue);
		}
		return trimmedString;
	}

}
