package dw317.lib.creditcard;

/**
 * @author Matt, Mher, Tahar
 * 
 * This program acts as a single MasterCard, which extends from the AbstractCreditCard class.
 * 
 */
public final class MasterCard extends AbstractCreditCard {

	private static final long serialVersionUID = 42031766871L;
	
	/**
	 * 
	 * @param number: the number of the MasterCard, once it's been validated
	 * @throws IllegalArgumentException if the MasterCard number is invalid
	 * 	
	 */

	public MasterCard(String number) throws IllegalArgumentException {
		super(CardType.MASTERCARD, validateNumber(new String(number)));
	}
	
	/**
	 * 
	 * @param number: the supposed number of the MasterCard
	 * @return the number if it is valid, an IllegalArgumentException if it is invalid
	 * @throws IllegalArgumentException if the MasterCard number is invalid:
	 * 									- if the number is not 16-digits long
	 * 									- if the first two numbers are not in the range of 51 and 55
	 */

	private static String validateNumber(String number) throws IllegalArgumentException {

		number=number.trim();
		if (number == null)
			throw new NullPointerException("Number cannot be null");
		
		if (number.isEmpty())
			throw new IllegalArgumentException("Number cannot be empty");
		
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

		// validate that the first numbers are between 51 and 55, then cast to integer to avoid decimals
		if ((int)(num / (Math.pow(10, 15))) < 51 || (int)(num / (Math.pow(10, 14))) > 55) 
			throw new IllegalArgumentException("First numbers must be between 51 & 55");

		return number;
	}

	@Override
	public CardType getType() {
		return this.cardType;
	}

}

