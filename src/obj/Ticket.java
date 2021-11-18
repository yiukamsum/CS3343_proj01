package obj;

public abstract class Ticket {
	private TicketType type;
	private MovieSession session;
	
	public Ticket(TicketType type, MovieSession session) {
		this.type = type;
		this.session = session;
	}
	
	public String getType() {
		return type.getType();
	}
	
	public int getPrice() {
		return type.getPrice();
	}
	
	public MovieSession getSession(){
		return session;
	}
	
	
}
