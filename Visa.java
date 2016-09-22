/**
 * 
 */
package dw317.lib.creditcard;

/**
 * @author Matt, Mher, Tahar
 * 
 * This program acts as a single Visa, which extends from the AbstractCreditCard class.
 * 
 */
public class Visa extends AbstractCreditCard {
	
	/**
	 * 
	 * @param number: the number of the Visa, once it's been validated
	 * @throws IllegalArgumentException if the Visa number is invalid
	 * 	
	 */

	private static final long serialVersionUID = 42031766871L;

	public Visa(String number) throws IllegalArgumentException {
		super(CardType.VISA, validateNumber(number));
	}
	
	/**
	 * 
	 * @param number: the supposed number of the Visa
	 * @return the number if it is valid, an IllegalArgumentException if it is invalid
	 * @throws IllegalArgumentException if the Visa number is invalid:
	 * 									- if the number is not 16-digits long
	 * 									- if the first number is not a 4
	 */

	private static String validateNumber(String number) throws IllegalArgumentException {

		long num = 0;
		int length = number.length();
		
		if (length != 16)
			throw new IllegalArgumentException("Invalid amount of digits");

		try {
			num = Long.parseLong(number);
		} catch (IllegalArgumentException iae) {
			System.out.println("Card number must contain numbers ONLY");
			System.exit(0);
		}

		if ((int)(num / (Math.pow(10, 15))) != 4) { // validate that the first number is 4, then cast to integer to avoid decimals
			throw new IllegalArgumentException("First number must be 4");
		}
		return number;
	}

	@Override
	public CardType getType() {
		return this.cardType;
	}

}
