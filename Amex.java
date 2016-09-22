/**
 * 
 */
package dw317.lib.creditcard;

/**
 * @author Matt, Mher, Tahar
 * 
 *         This program acts as a single Amex, which extends from the
 *         AbstractCreditCard class.
 * 
 */
public class Amex extends AbstractCreditCard {

	private static final long serialVersionUID = 42031766871L;

	/**
	 * 
	 * @param number:
	 *            the number of the Amex, once it's been validated
	 * @throws IllegalArgumentException
	 *             if the Amex number is invalid
	 * 
	 */

	public Amex(String number) throws IllegalArgumentException {
		super(CardType.AMEX, validateNumber(number));
	}

	/**
	 * 
	 * @param number:
	 *            the supposed number of the Amex
	 * @return the number if it is valid, an IllegalArgumentException if it is
	 *         invalid
	 * @throws IllegalArgumentException
	 *             if the MasterCard number is invalid: - if the number is not
	 *             15-digits long - if the first two numbers are not 34 nor 37
	 */

	private static String validateNumber(String number) throws IllegalArgumentException {

		long num = 0;
		int length = number.length();

		if (length != 15)
			throw new IllegalArgumentException("Invalid amount of digits");

		try {
			num = Long.parseLong(number);
		} catch (IllegalArgumentException iae) {
			System.out.println("Card number must contain numbers ONLY");
			System.exit(0);
		}

		// validate that the first numbers are either 34 or 37, then cast to
		// integer to avoid decimals
		if ((int) (num / (Math.pow(10, 13))) != 34 && (int) (num / (Math.pow(10, 13))) != 37)
			throw new IllegalArgumentException("First numbers must be 34 or 37");

		return number;
	}

	@Override
	public CardType getType() {
		return this.cardType;
	}

}
