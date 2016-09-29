package group99.hotel.business;

import java.util.Optional;
import java.util.Scanner;
import dw317.lib.Email;
import dw317.lib.Name;
import dw317.lib.creditcard.CreditCard;
import dw317.lib.creditcard.MasterCard;
import dw317.lib.creditcard.Visa;

/**
 * 
 * This program tests the DawsonCustomer class
 * 
 * @author Matt, Mher, Tahar
 *
 */

public class DawsonCustomerTest {
	public static void main(String[] args) {

			Name n1 = new Name("Matthew", "Mileto");
			Email e1 = new Email("matt@gmail.com");
			Optional<CreditCard> card1 = Optional.ofNullable(new MasterCard("5214227392892824"));

			Name n2 = new Name("Tahar", "Mohammad Ali");
			Email e2 = new Email("miketyson@dawsoncollege.ca");
			Optional<CreditCard> card2 = Optional.ofNullable(new Visa("4324007170639776"));

			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			DawsonCustomer c1 = new DawsonCustomer(n1, e1, null);
			DawsonCustomer c2 = new DawsonCustomer(n2, e2, card1);
			DawsonCustomer c3 = new DawsonCustomer(n2,e1,card2);

			switch (test) {
			case 1:
				System.out.println("Credit Card should NOT display: ");
				System.out.println(c1);
				break;
			case 2:
				System.out.println("Credit Cards should display: ");
				System.out.println(c2);
				System.out.println(c3);
				break;
			case 3:
				if (c1.compareTo(c2) == -1)
					System.out.println(c1 + " comes before " + c2);
				else
					System.out.println(c2 + " comes before " + c1);
			}
	}
}
