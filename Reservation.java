
public interface Reservation {
	
	public Customer getCustomer();
	
	public Room getRoom();
	
	public LocalDate getCheckInDate();
	
	public LocalDate getCheckOutDate();
	
	public int getNumberDays();

}
