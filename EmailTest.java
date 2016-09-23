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
public class EmailTest {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			switch (test) {
			case 1:
				Email email1 = new Email("tahar98@live.ca");
				System.out.println("This should be valid: " + email1);
				break;

			case 2:
				Email email2 = new Email("matt.Mileto@dawsoncollege.gov.qc.ca");
				System.out.println("This should be valid: " + email2);
				break;

			case 3:
				Email email3 = new Email("mh____er@localhost");
				System.out.println("This should be valid: " + email3);
				break;

			case 4:
				System.out.println("This should be invalid due to insufficient length: ");
				Email email4 = new Email("m@heyo");
				break;

			case 5:
				System.out.println("This should be invalid due to invalid character: ");
				Email email5 = new Email("Peter@Gr!ff!n.com");
				break;
				
			case 6: 
				System.out.println("This should be invalid due to double dots: ");
				Email email6 = new Email("info..dawson@yahoo.ca");
				break;
				
			case 7: 
				System.out.println("This should be invalid due to special characters beginning or ending in user id: ");
				Email email7 = new Email(".Sterling.@archer.com");
				break;
				
			case 8:
				System.out.println("This should be invalid due to special characters beginning or ending in host: ");
				Email email8 = new Email("Brian@-Griffin.org");
				break;
				
			case 9:
				System.out.println("This should be invalid due to invalid segment length: ");
				Email email9 = new Email("userid@hostname.c.com");
				break;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}

	}
}
