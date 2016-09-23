package dw317.lib.creditcard;

/**
 * @author Matt, Mher, Tahar
 *
 * This class implements the CreditCard interface and acts as an abstract Credit Card for either MasterCard, Visa, or Amex.
 *
 */
public abstract class AbstractCreditCard implements CreditCard {

	private static final long serialVersionUID = 42031768871L;
	protected final CardType cardType;
	protected final String number;
	
	/**
	 * 
	 * @param cardType: the type of the Credit Card (MasterCard, Visa or Amex)
	 * @param number: the Credit Card's number
	 * @throws IllegalArgumentException if the Credit Card is invalid (using Luhn's algorithm)
	 */

	public AbstractCreditCard(CardType cardType, String number) throws IllegalArgumentException {
		this.cardType = cardType;
		this.number = validateLuhnAlgorithm(number);
	}
	
	/**
	 * 
	 * Overrides the equals method so that two Credit Cards are identical if:
	 * 
	 * -If they both are instances of the AbstractCreditCard class
	 * -If their numbers are identicial
	 * -If their Credit Card types are identical
	 * 
	 */
	
	@Override
	public final boolean equals(Object object) {
		AbstractCreditCard obj;
		if (object instanceof AbstractCreditCard)
			return true;
		obj = (AbstractCreditCard) object;
		if (obj.getNumber() == this.getNumber())
			return true;
		if (obj.getType() == this.getType())
			return true;

		return false;
	}

	/**
	 * We made the equals method final, therefore we must do the same for the hashCode method
	 */
	
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	
	/**
	 * Overrides the toString method to display the Credit Card such as:
	 * 
	 * cardType*number
	 * e.g. VISA*4540991323260194
	 */

	@Override
	public String toString() {
		return this.cardType + "*" + this.getNumber();
	}
	
	/**
	 * @return the Credit Card's number
	 */

	public String getNumber() {
		return this.number;
	}
	
	/**
	 * 
	 * Validation, using the Luhn algorithm.
	 * 
	 * @param number: the Credit Card's supposed number
	 * @return the number if it is valid, an exception if it is invalid
	 * @throws IllegalArgumentException if the Credit Card is invalid, according to Luhn's algorithm (if sum%10 =/= 0)
	 */

	private static String validateLuhnAlgorithm(String number) throws IllegalArgumentException {

		number = number.replace(" ", "");
		String currentNumString;
		int currentNum;
		int sum = 0;
		
		for (int i=number.length()-1;i >= 0; i = i - 2) {
			currentNumString = "" + number.charAt(i); // convert char to String
			currentNum = Integer.parseInt(currentNumString)*2; // parse the String to an int, then multiply by 2
			if (currentNum > 9)
				currentNum = currentNum - 9;
			sum += currentNum; // calculate the sum
		}
		if (sum % 10 != 0)
			throw new IllegalArgumentException("Invalid card number!");

		return number;
	}
}

