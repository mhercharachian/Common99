/**
 * 
 */
package dw317.lib;

import java.io.Serializable;

/**
 * @author Matt, Mher, Tahar
 *
 */
public class Name implements Serializable {
	
	private static final long serialVersionUID = 42031768871L;
	private String firstName;
	private String lastName;

	/**
	 * Default constructor
	 */

	public Name() {
		this.firstName = "";
		this.lastName = "";
	}

	/**
	 * 
	 * 2nd constructor
	 * 
	 * @param the
	 *            First name
	 * @param the
	 *            Last name
	 */

	public Name(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	/**
	 * 
	 * @return the first name
	 */

	public String getFirstName() {
		return new String(this.firstName);
	}

	/**
	 * 
	 * Sets the first name, once validated
	 * 
	 * @param firstName
	 */

	public void setFirstName(String firstName) {
		this.firstName = validateName(new String(firstName));
	}

	/**
	 * 
	 * @return the last name
	 */

	public String getLastName() {
		return new String(this.lastName);
	}

	/**
	 * 
	 * Sets the last name, once validated
	 * 
	 * @param lastName
	 */

	public void setLastName(String lastName) {
		this.lastName = validateName(new String(lastName));
	}

	/**
	 * 
	 * Overrides the toString class so a full name looks like: first name
	 * (space) last name
	 * 
	 */

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * 
	 * Validates the first and last name. The names are invalid if:
	 * 
	 * 	- They consist of less than 2 characters
	 * 	- They consist of a characters that aren't a 
	 *    letter, apostrophe('), hyphen(-) or space
	 *  - They consist of an apostrophe, hyphen or space
	 *    that aren't between two letters
	 * 
	 * 
	 * @param name
	 * @return the name, if valid
	 * @throws IllegalArgumentException if the name is invalid
	 */

	private static String validateName(String name) throws IllegalArgumentException {

		name = name.trim();
		if (name == null)
			throw new NullPointerException("Last name cannot be null");

		if (name.isEmpty())
			throw new IllegalArgumentException("Last name cannot be empty");

		if (name.length() < 2)
			throw new IllegalArgumentException("Last name must be at least 2 characters");

		char c;
		int length = name.length();
		
		// if there is a special character at the beginning or end of the name,
		// throw an exception
		if (isLegalChar(name.charAt(0)) || isLegalChar(name.charAt(length-1)))
			throw new IllegalArgumentException("Special characters must be in between two letters");
		
		for (int i = length - 1; i >= 0; i--) {
			c = name.charAt(i);

			// if char is not a letter nor a special character, throw an exception
			if (!Character.isLetter(c) && !isLegalChar(c))
				throw new IllegalArgumentException("First or last name cannot contain " + name.charAt(i));
			
			// before validating that the chars are legal, make sure we don't
			// get an IndexOutOfBounds error
			if (name.charAt(i) > 0 && name.charAt(i) < length-1)
				// if the char is a special character, check to
				// see if the chars next to it are letters. If they are not, throw an exception
				if (isLegalChar(c))
					if (Character.isLetter((name.charAt(i - 1))) && Character.isLetter((name.charAt(i + 1))))
						continue;
					else
						throw new IllegalArgumentException(c + " must be in between two letters");
		}
		return name;
	}
	
	/**
	 * 
	 * Validates if the char is legal in a name
	 * 
	 * @param c: the char being validated
	 * @return true if the char is legal, false if not
	 */

	private static boolean isLegalChar(char c) {
		if (c == '\'')
			return true;
		if (c == ' ')
			return true;
		if (c == '-')
			return true;

		return false;
	}

}
