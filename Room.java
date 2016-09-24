
public interface Room extends Comparable<Room>, Serializable{
	
	public RoomType getRoomType();
	
	public int getRoomNumber();
	
	public int  getFloor() ;
	
	public int getNumber();

}
