package dw317.lib.creditcard;

import java.util.Scanner;

/**
 * 
 * @author Matt, Mher, Tahar
 * 
 *         This program tests the Visa class
 *
 */

public class VisaTest {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			switch (test) {
			case 1:
				Visa peter = new Visa("4324007170639776");
				System.out.println("This should be valid: " + peter.getNumber());
				break;

			case 2:
				System.out.println("This should be invalid due to letters: ");
				Visa peterFake1 = new Visa("4214Q27392F92824");
				break;

			case 3:
				System.out.println("This should be invalid due to excessive numbers: ");
				Visa peterFake2 = new Visa("42345632423479234239892");

				break;

			case 4:
				System.out.println("This should be invalid due to the first numbers being invalid: ");
				Visa peterFake3 = new Visa("2214227392892824");
				break;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

	}

}
