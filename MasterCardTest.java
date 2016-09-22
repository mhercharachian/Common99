package dw317.lib.creditcard;

import java.util.Scanner;

/**
 * 
 * @author Matt, Mher, Tahar
 * 
 *         This program tests the MasterCard class
 *
 */

public class MasterCardTest {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			switch (test) {
			case 1:
				MasterCard sterling = new MasterCard("5214227392892824");
				System.out.println("This should be valid: " + sterling.getNumber());
				break;

			case 2:
				System.out.println("This should be invalid due to letters: ");
				MasterCard sterlingFake1 = new MasterCard("5214Q27392F92824");
				break;

			case 3:
				System.out.println("This should be invalid due to insufficient numbers: ");
				MasterCard sterlingFake2 = new MasterCard("123456");
				
				break;

			case 4:
				System.out.println("This should be invalid due to the first numbers being invalid: ");
				MasterCard sterlingFake3 = new MasterCard("6214227392892824");
			
				break;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

	}

}
