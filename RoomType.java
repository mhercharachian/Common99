
public enum RoomType {
	
	NORMAL,SUITE,PENTHOUSE;
	
	public String toString(){
		
		switch(this){
			
			case NORMAL: return "normal";
			case SUITE: return "suite";
			case PENTHOUSE: return "penthouse";
			default: throw new IllegalArgumentException();
		
		}
		
	}
}
