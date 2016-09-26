package group99.hotel.business;

import java.util.Scanner;

/**
 * 
 * This program tests the DawsonRoom class
 * 
 * @author Matt, Mher, Tahar
 *
 */

public class DawsonRoomTest {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Pick a test case");
			int test = sc.nextInt();

			DawsonRoom room1 = new DawsonRoom(301, RoomType.NORMAL);
			DawsonRoom room2 = new DawsonRoom(106, RoomType.SUITE);

			switch (test) {
			case 1:
				System.out.println("This should be valid: " + room1);
				break;

			case 2:
				System.out.println("This should be valid: " + room2);
				break;

			case 3:
				DawsonRoom room3 = new DawsonRoom(308, RoomType.PENTHOUSE);
				System.out.println("This should be valid: " + room3);
				break;

			case 4:
				System.out.println("This should be invalid due to invalid floor: ");
				DawsonRoom room4 = new DawsonRoom(905, RoomType.NORMAL);
				break;

			case 5:
				System.out.println("This should be invalid due to invalid floor number: ");
				DawsonRoom room5 = new DawsonRoom(509, RoomType.NORMAL);
				break;
				
			case 6: 
				System.out.println("This should be invalid due to a negative floor number: ");
				DawsonRoom room6 = new DawsonRoom(-605, RoomType.NORMAL);
				break;

			case 7:
				System.out.println("Testing the CompareTo method");
				if (room1.compareTo(room2) == -1)
					System.out.println(room2 + " comes before " + room1);
				else if (room1.compareTo(room2) == 1)
					System.out.println(room1 + " comes before " + room2);
				else
					System.out.println(room1 + " and " + room2 + " are equal");
				break;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
	}
}
