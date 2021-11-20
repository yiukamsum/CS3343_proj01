package obj;

public class Ticket {
	private TicketType type;
	private MovieSession session;
	private String seat;
	
	public Ticket(TicketType type, MovieSession session, String seat) {
		this.type = type;
		this.session = session;
		this.seat = seat;
	}
	
	public String getType() {
		return type.getType();
	}
	
	public double getPrice() {
		return type.getPrice();
	}
	
	public MovieSession getSession(){
		return session;
	}
	
	public String getSeat() {
		return this.seat;
	}
}
