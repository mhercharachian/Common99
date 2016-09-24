
public interface Customer {
	
	public Name getname();
	
	public Email getEmail();
	
	public Optional<CreditCard> getCreditCard();	
	
	public void setCreditCard(Optional<CreditCard> card);

}
