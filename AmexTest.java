package dw317.lib.creditcard;

import java.util.Scanner;

/**
 * 
 * @author Matt, Mher, Tahar
 * 
 *         This program tests the Amex class
 *
 */

public class AmexTest {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			switch (test) {
			case 1:
				Amex homer = new Amex("349636534929918");
				System.out.println("This should be valid: " + homer.getNumber());
				break;

			case 2:
				System.out.println("This should be invalid due to letters: ");
				Amex homerFake1 = new Amex("3743Q297D661649");
				break;

			case 3:
				System.out.println("This should be invalid due to insufficient numbers: ");
				Amex homerFake2 = new Amex("374372949");

				break;

			case 4:
				System.out.println("This should be invalid due to the first numbers being invalid: ");
				Amex homerFake3 = new Amex("449636534929918");
				break;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

	}

}
