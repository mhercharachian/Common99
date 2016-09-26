package group99.hotel.business;

import java.io.Serializable;
import group99.hotel.business.interfaces.Room;

/**
 * 
 * This program acts as a single Dawson room
 * 
 * @author Matt, Mher, Tahar
 *
 */

public class DawsonRoom implements Room, Serializable {

	private static final long serialVersionUID = 42031768871L;
	private final int roomNumber;
	private final RoomType roomType;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param roomNumber: the number of the room; consists of the floor and floor number
	 * 					 (e.g. 506)
	 * @param roomType: the type of the room
	 * 
	 */

	public DawsonRoom(int roomNumber, RoomType roomType) {
		this.roomNumber = validateRoomNumber(roomNumber);
		this.roomType = roomType;
	}
	
	/**
	 * 
	 * Overridden compareTo method
	 * 
	 * Rooms are compared by their floor, followed by their floor number
	 * 
	 */

	@Override
	public int compareTo(Room room) {

		if (this.roomNumber > room.getRoomNumber())
			return -1;

		if (this.roomNumber < room.getNumber())
			return 1;

		return 0;
	}
	
	/**
	 * 
	 * Overriden hashCode method as final
	 * 
	 */

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roomNumber;
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		return result;
	}
	
	/**
	 * 
	 * Overriden equals method
	 * 
	 */

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DawsonRoom))
			return false;
		DawsonRoom other = (DawsonRoom) obj;
		if (roomNumber != other.roomNumber)
			return false;
		if (roomType.equals(other.roomType))
			return false;
		
		return true;
	}
	
	/**
	 * 
	 * RoomType Getter
	 * 
	 * @return the room type
	 * 
	 */

	@Override
	public RoomType getRoomType() {
		return this.roomType;
	}
	
	/**
	 * 
	 * RoomNumber Getter
	 * 
	 * @return the room number
	 * 
	 */

	@Override
	public int getRoomNumber() {
		return this.roomNumber;
	}
	
	/**
	 * 
	 * Floor Getter
	 * 
	 * @return the floor
	 * 
	 */
	
	@Override
	public int getFloor() {
		return Integer.parseInt(Integer.toString(roomNumber).substring(0, 1));
	}
	
	/**
	 * 
	 * Number Getter
	 * 
	 * @return the floor number
	 * 
	 */

	@Override
	public int getNumber() {
		return Integer.parseInt(Integer.toString(roomNumber).substring(1, 3));
	}
	
	/**
	 * 
	 * Validates that the room number is valid if:
	 * 
	 * - it's floor is between 1 and 8 inclusive
	 * - it's floor number is between 1 and 8 inclusive
	 * 
	 * @param roomNumber: the supposed room number
	 * @return the room number, if valid
	 * @throws IllegalArgumentException if the room number is deemed invalid
	 */

	private static int validateRoomNumber(int roomNumber) throws IllegalArgumentException {
		
		if (roomNumber < 0)
			throw new IllegalArgumentException("Room number cannot be negative");
		
		// if the room number is not 3 digits long, throw an exception
		if (String.valueOf(roomNumber).length() != 3)
			throw new IllegalArgumentException("Room number must be 3 digits");

		// the first digit of the room number represent the floor
		int floor = Integer.parseInt(Integer.toString(roomNumber).substring(0, 1));

		// validate that floor is in valid range
		if (floor < 1 || floor > 8)
			throw new IllegalArgumentException("Floor " + floor + " does not exist");

		// the second and third digit on the room number represent the floor
		// number
		int floorNumber = Integer.parseInt(Integer.toString(roomNumber).substring(1, 3));

		// validate that the floor number is in valid range
		if (floorNumber < 1 || floorNumber > 8)
			throw new IllegalArgumentException("The floor number " + floorNumber + " does not exist on floor " + floor);

		return roomNumber;

	}

	/**
	 * 
	 * Overriden String method
	 * 
	 * @return the room number, followed by an asterisk and the room type
	 * 			(e.g. 508*penthouse)
	 * 
	 */
	
	@Override
	public String toString() {
		return this.roomNumber + "*" + this.roomType;
	}

}
