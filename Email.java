package dw317.lib;

public class Email  {

	protected static final long serialVersionUID = 42031768871L;
	protected final String address;

	public Email(String address) {

		this.address = validateEmail(address);
	}

	public String getAddress() {

		return new String(this.address);
	}

	public String getUserId() {

		String userId = this.address.substring(0, this.getAddress().indexOf('@'));
		return userId;
	}

	public String getHost() {
		String host = this.address.substring(this.getAddress().indexOf('@'));
		return host;
	}

	@Override
	public String toString() {
		return getAddress();
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

	public int compareToIgnoreCase(Email email) {

		if (this.getHost().compareToIgnoreCase(email.getHost()) > 0)
			return 1;

		if (this.getHost().compareToIgnoreCase(email.getHost()) < 0)
			return -1;

		if (this.getUserId().compareToIgnoreCase(email.getUserId()) > 0)
			return 1;

		if (this.getUserId().compareToIgnoreCase(email.getUserId()) < 0)
			return -1;

		return 0;
	}

	private String validateEmail(String email) throws IllegalArgumentException{
		
		email=email.trim();
		
		if (email == null)
			throw new NullPointerException("ts,ts,ts");
		
		if (email.isEmpty())
			throw new IllegalArgumentException("Email cannot be empty");
		
		// validate that there is an @
		if (email.indexOf('@') == -1)
			throw new IllegalArgumentException("Email needs an @");
		
		String userId = email.substring(0, email.indexOf('@'));
		if (userId.length() <= 1 || userId.length() >= 32)
			throw new IllegalArgumentException("User ID must be between 1 and 32 characters");
		
		String host = email.substring(email.indexOf('@')+1);
		
		char currentChar;
		
		for(int i = 0; i < userId.length(); i++){
			
			currentChar = userId.charAt(i);
			
			// if char is not a letter, digit or special char, throw an exception
			if(!Character.isLetter(currentChar) && !Character.isDigit(currentChar) && !isLegalChar(currentChar))
				throw new IllegalArgumentException("Invalid character in userID");
			
			// validate that there aren't two dots in a row
			if (currentChar > 0)
				if (currentChar == '.' && userId.charAt(i-1) == '.')
					throw new IllegalArgumentException("Invalid User ID");
		}
		
		if(userId.charAt(0) == '.' || userId.charAt(userId.length()-1) == '.')
			throw new IllegalArgumentException("Invalid User ID");
;
		final char delimiter = '.';
		
		String segment;
		int firstIndex = 0;
		// append a dot to the email so each segment can be found
		String hostTemp = host + delimiter;
		int index = hostTemp.indexOf(delimiter);
		
		// validate each segment
		while (index != -1) {
			segment = hostTemp.substring(firstIndex, index);
			// validate that the segment has a valid length
			if (segment.length() <= 1 || segment.length() >= 32)
				throw new IllegalArgumentException("Invalid segment length");
			// validate that the segment has no illegal characters
			for(int i = 0; i < segment.length() ; i++ ){
				
				currentChar = segment.charAt(i);
				if(!Character.isLetter(currentChar) && !Character.isDigit(currentChar) && currentChar != '-')
					throw new IllegalArgumentException("Invalid character in segment");
			}
			firstIndex = index+1;
			index=hostTemp.indexOf(delimiter,firstIndex);
		}
		if(host.charAt(0) == '-' || host.charAt(host.length()-1) == '-')
			throw new IllegalArgumentException("Invalid Host");
		
		return email;
		
	}
	
	private boolean isLegalChar(char c) {
		
		if (c == '-')
			return true;
		if (c =='_')
			return true;
		if (c == '.')
			return true;
		return false;
	}

}
