package dw317.lib.creditcard;

/**
 * 
 * @author Matt, Mher, Tahar
 * 
 * This program tests the CreditCard interface
 *
 */

public class CreditCardTest {
	public static void main(String[] args) {
		CreditCard.CardType amex = CreditCard.CardType.AMEX;
		CreditCard.CardType visa = CreditCard.CardType.VISA;
		CreditCard.CardType mastercard = CreditCard.CardType.MASTERCARD;

		System.out.println("This should display 'amex': " + amex);
		System.out.println("This should display 'visa': " + visa);
		System.out.println("This should display 'mastercard': " + mastercard);
	
	}
}