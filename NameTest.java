/**
 * 
 */
package dw317.lib;

import java.util.Scanner;

/**
 * @author Matt, Mher, Tahar
 * 
 *         This program tests the Name class
 *
 */
public class NameTest {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			switch (test) {
			case 1:
				Name name1 = new Name("Matthew", "Mileto");
				System.out.println("This should be valid: " + name1);
				break;

			case 2:
				Name name2 = new Name("Sterling", "Archer-Lana");
				System.out.println("This should be valid: " + name2);
				break;

			case 3:
				Name name3 = new Name("Peter", "Griffin'Bro");
				System.out.println("This should be valid: " + name3);
				break;

			case 4:
				Name name4 = new Name("Nas", "The Rapper");
				System.out.println("This should be valid: " + name4);
				break;

			case 5:
				System.out.println("This should be invalid due to invalid characters: ");
				Name name5 = new Name("M@tth3w", "Mileto");
				break;

			case 6:
				System.out.println("This should be invalid due to insufficient length: ");
				Name name6 = new Name("Matthew", "M");
				break;

			case 7:
				System.out.println("This should be invalid due to the apostrophe not being between two letters");
				Name name7 = new Name("Livin'", "It Up");
				break;
				
			case 8:
				System.out.println("This should be invalid due to the hyphen not being between two letters");
				Name name8 = new Name("A-","Is Your Grade");
			}

		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

	}
}
